
package groupchat;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server {
	private static int uniqueId;
	private ArrayList<ClientThread> al;
	private ServerGUI sg;
	private SimpleDateFormat sdf;
	private int port;
	private boolean keepGoing;
	

	public Server(int port) {
		this(port, null);
	}
	
	public Server(int port, ServerGUI sg) {
		this.sg = sg;
		this.port = port;
		sdf = new SimpleDateFormat("HH:mm");
		al = new ArrayList<ClientThread>();
	}
	
	public void start() {
		keepGoing = true;
		try 
		{
			ServerSocket serverSocket = new ServerSocket(port);

			while(keepGoing) 
			{
				display("Chờ kết nối từ Client...");
				
				Socket socket = serverSocket.accept();  	
		
				if(!keepGoing)
					break;
				ClientThread t = new ClientThread(socket);  
				al.add(t);									
				t.start();
			}
			// Khi dừng serverSocket
			try {
				serverSocket.close();
				for(int i = 0; i < al.size(); ++i) {
					ClientThread tc = al.get(i);
					try {
					tc.sInput.close();
					tc.sOutput.close();
					tc.socket.close();
					}
					catch(IOException ioE) {
						
					}
				}
			}
			catch(Exception e) {
				display("Lỗi khi đóng server và clients. ");
			}
		}
		
		catch (IOException e) {
            String msg = sdf.format(new Date()) + " Exception on new ServerSocket.\n";
			display(msg);
		}
	}		
    
	protected void stop() {
		keepGoing = false;

		try {
			new Socket("localhost", port);
		}
		catch(Exception e) {
		}
	}
	// Ghi luồng sự kiện lên GUI
	private void display(String msg) {
		String time = "[" +sdf.format(new Date()) + "] " + msg;
		if(sg == null)
			System.out.println(time);
		else
			sg.appendEvent(time+ "\n");
	}
	// Luồng thông điệp cho tất cả Client
	private synchronized void broadcast(String message) {
		String time = sdf.format(new Date());
		String messageLf = "[" +time+ "] " + message + "\n";
		if(sg == null)
			System.out.print(messageLf);
		else
			sg.appendRoom(messageLf);     
		
		for(int i = al.size(); --i >= 0;) {
			ClientThread ct = al.get(i);

			if(!ct.write(messageLf)) {
				al.remove(i);
				display("Ngắt kết nối Client " + ct.username + ".");
			}
		}
	}

	// Khi Client gửi thông điệp Đăng xuất
	synchronized void remove(int id) {
		for(int i = 0; i < al.size(); ++i) {
			ClientThread ct = al.get(i);
			// found it
			if(ct.id == id) {
				al.remove(i);
				return;
			}
		}
	}
	

	public static void main(String[] args) {
		int portNumber = 1500;
		switch(args.length) {
			case 1:
				try {
					portNumber = Integer.parseInt(args[0]);
				}
				catch(Exception e) {
					System.out.println("Lỗi cổng.");
					return;
				}
			case 0:
				break;
			default:
				System.out.println("Usage is: > java Server [portNumber]");
				return;
				
		}
		Server server = new Server(portNumber);
		server.start();
	}

	// Tạo luồng cho các Client
	class ClientThread extends Thread {
		Socket socket;
		ObjectInputStream sInput;
		ObjectOutputStream sOutput;

		int id;
		String username;
		ChatMessage cm;
		String date;

		
		ClientThread(Socket socket) {

			id = ++uniqueId;
			this.socket = socket;

			System.out.println("Thread trying to create Object Input/Output Streams");
			try
			{

				sOutput = new ObjectOutputStream(socket.getOutputStream());
				sInput  = new ObjectInputStream(socket.getInputStream());
                                
				username = (String) sInput.readObject();
				display(username + " đã kết nối.");
			}
			catch (IOException e) {
				display("Lỗi tạo luồng vào/ra. ");
				return;
			}

			catch (ClassNotFoundException e) {
			}
            date = new Date().toString() + "\n";
		}

	
		public void run() {
			boolean keepGoing = true;
			while(keepGoing) {
				try {
					cm = (ChatMessage) sInput.readObject();
				}
				catch (IOException e) {
					display(username + ": Lỗi khi đọc luồng. ");
					break;				
				}
				catch(ClassNotFoundException e2) {
					break;
				}
				String message = cm.getMessage();

				switch(cm.getType()) {

				case ChatMessage.MESSAGE:
					broadcast(username + ": " + message);
					break;
				case ChatMessage.LOGOUT:
					display(username + " đã ngắt kết nối.");
					keepGoing = false;
					break;
				case ChatMessage.WHOISIN:
                                        for(int i = 0; i < al.size(); ++i) {
						ClientThread ct = al.get(i);
						write("- "+ct.username +"\n");
					}
                                        break;
				}
			}
			remove(id);
			close();
		}
		
		
		private void close() {
			try {
				if(sOutput != null) sOutput.close();
			}
			catch(Exception e) {}
			try {
				if(sInput != null) sInput.close();
			}
			catch(Exception e) {};
			try {
				if(socket != null) socket.close();
			}
			catch (Exception e) {}
		}

		
		private boolean write(String msg) {
			if(!socket.isConnected()) {
				close();
				return false;
			}
			try {
				sOutput.writeObject(msg);
			}
			catch(IOException e) {
				display("Lỗi gửi tin nhắn từ " + username);
				display(e.toString());
			}
			return true;
		}
	}
}



