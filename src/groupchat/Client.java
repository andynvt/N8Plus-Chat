
package groupchat;


import java.net.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JOptionPane;


public class Client  {

	// Nhap/Xuat
	private ObjectInputStream sInput;
	private ObjectOutputStream sOutput;
	private Socket socket;

	private ClientGUI cg;
	
	private String server, username;
	private int port;

	Client(String server, int port, String username) {
            this(server, port, username, null);
	}

	Client(String server, int port, String username, ClientGUI cg) {
		this.server = server;
		this.port = port;
		this.username = username;
		this.cg = cg;
	}
	
	public boolean start() {
		// Ket noi Socket
		try {
			socket = new Socket(server, port);
                        
		} 
		// Bao loi neu ko ket noi duoc !
		catch(Exception ec) {
                    int err = JOptionPane.showConfirmDialog(null, "Server hiện tại đang bận..\nVui lòng thử lại sau !", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                    if (err == JOptionPane.OK_OPTION){
                        System.exit(0);
                    }
                    return false;
		}
		
		String msg = "Chào mừng đến với N8+ GroupChat!";
		display(msg);	
		
		try
		{
			sInput  = new ObjectInputStream(socket.getInputStream());
			sOutput = new ObjectOutputStream(socket.getOutputStream());
                       
		}
		catch (IOException eIO) {
			display("Lỗi khi tạo luồng nhập/xuất. ");
			return false;
		}

		// Tạo luồng lắng nghe từ Sever
		new ListenFromServer().start();
		try
		{
			sOutput.writeObject(username);
		}
		catch (IOException eIO) {
			display("Lỗi đăng nhập. ");
			disconnect();
			return false;
		}
		return true;
	}

	
	// Viết tin nhắn lên giao diện
	private void display(String msg) {
		if(cg == null)
			System.out.println(msg);    
		else
			cg.appendChat(msg + "\n");
                
	}
        
        
	//Gửi thông điệp tới Server
	void sendMessage(ChatMessage msg) {
		try {
			sOutput.writeObject(msg);
		}
		catch(IOException e) {
			display("Exception writing to server: " + e);
		}
	}

	private void disconnect() {
		try { 
                    if(sInput != null) sInput.close();
		}
		catch(Exception e) {}
		try {
                    if(sOutput != null) sOutput.close();
		}
		catch(Exception e) {}
                try{
                    if(socket != null) socket.close();
		}
		catch(Exception e) {}
		if(cg != null)
			cg.connectionFailed();
			
	}
	
	public static void main(String[] args) {
		// Giá trị mặc định
		int portNumber = 1500;
		String serverAddress = "localhost";
		String userName = "Anonymous";
                
                
		switch(args.length) {
			case 3:
				serverAddress = args[2];
			case 2:
				try {
					portNumber = Integer.parseInt(args[1]);
				}
				catch(Exception e) {
					System.out.println("Invalid port number.");
					System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
					return;
				}
			case 1: 
				userName = args[0];
			case 0:
				break;
			
			default:
				System.out.println("Usage is: > java Client [username] [portNumber] {serverAddress]");
			return;
		}
		
		Client client = new Client(serverAddress, portNumber, userName);
		
		if(!client.start())
			return;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("> ");
			String msg = scan.nextLine();
                        
			if(msg.equalsIgnoreCase("LOGOUT")) {
				client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
				break;
			}
			else if(msg.equalsIgnoreCase("WHOISIN")) {
				client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));    
                               
			}
                        else {				
				client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
			}
                }              
		client.disconnect();	
	}

	
	class ListenFromServer extends Thread {
            public void run() {
		while(true) {
                    try {
			String msg = (String) sInput.readObject();
                            if(cg == null) {
				System.out.println(msg);
				System.out.print("> ");
                            }
                           
                            else { 
				cg.appendChat(msg);  
                                playSound();
                            }
			}
			catch(IOException e) {
                            display("Đã ngắt kết nối tới server!\n");
                            if(cg != null) 
				cg.connectionFailed();
				break;
                        }
                        catch(ClassNotFoundException e2) {
			}
		}
            }
	}
        
        void playSound() {
            try {
                File f = new File("./" + "Audio/Message_Sound.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
         }
}


