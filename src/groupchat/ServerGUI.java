

package groupchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The server as a GUI
public class ServerGUI extends JFrame implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L; 
	private JButton btn_stopStart;
	private JTextArea txa_Chat, txa_Event;
	private JTextField txf_PortNumber;
	private Server server;

	// server constructor that receive the port to listen to for connection as parameter
	ServerGUI(int port) {
		super("Chat Server");
		server = null;
                
		JPanel north = new JPanel();
		north.add(new JLabel("Port number: "));
		txf_PortNumber = new JTextField("  " + port);
		north.add(txf_PortNumber);
                Color colorBg = Color.decode("0x56A8E3");
                north.setBackground(colorBg);

		btn_stopStart = new JButton("Start");
		btn_stopStart.addActionListener(this);
		north.add(btn_stopStart);
		add(north, BorderLayout.NORTH);
                
		// the txa_Event and txa_Chat room
		JPanel center = new JPanel(new GridLayout(2,1));
		txa_Chat = new JTextArea(80,80);
		txa_Chat.setEditable(false);
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(txa_Chat));
		txa_Event = new JTextArea(80,80);
		txa_Event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(txa_Event));	
		add(center);
		
		// need to be informed when the user click the close button on the frame
		addWindowListener(this);
		setSize(400, 500);
		setVisible(true);
                this.setLocationRelativeTo(null);
                this.setIconImage(new ImageIcon("./" +"src/Icons/icon.png").getImage());
	}		

	// append message to the two JTextArea
	// position at the end
	void appendRoom(String str) {
		txa_Chat.append(str);
		txa_Chat.setCaretPosition(txa_Chat.getText().length() - 1);
	}
	void appendEvent(String str) {
		txa_Event.append(str);
		txa_Event.setCaretPosition(txa_Chat.getText().length() - 1);
		
	}
	
	// start or stop where clicked
	public void actionPerformed(ActionEvent e) {
		if(server != null) {
			server.stop();
			server = null;
			txf_PortNumber.setEditable(true);
			btn_stopStart.setText("Start");
			return;
		}
      	// OK start the server	
		int port;
		try {
			port = Integer.parseInt(txf_PortNumber.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Cổng không hợp lệ !");
			return;
		}
		server = new Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		btn_stopStart.setText("Stop");
		txf_PortNumber.setEditable(false);
	}
	
	// entry point to start the Server
	public static void main(String[] arg) {
		// start server default port 1500
		new ServerGUI(1500);
	}


	public void windowClosing(WindowEvent e) {
		// if my Server exist
		if(server != null) {
			try {
				server.stop();			// ask the server to close the conection
			}
			catch(Exception eClose) {
			}
			server = null;
		}

		dispose();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

	/*
	 * A thread to run the Server
	 */
	class ServerRunning extends Thread {
		public void run() {
			server.start();        
			// the server failed
			btn_stopStart.setText("Start");
			txf_PortNumber.setEditable(true);
			appendEvent("Dừng server...\n");
			server = null;
		}
	}

}


