

package groupchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The server as a GUI
public class ServerGUI extends JFrame implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L; 
	private JButton stopStart;
	private JTextArea chat, event;
	private JTextField tPortNumber;
	private Server server;

	// server constructor that receive the port to listen to for connection as parameter
	ServerGUI(int port) {
		super("Chat Server");
		server = null;
                
		JPanel north = new JPanel();
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
                Color colorBg = Color.decode("0x56A8E3");
                north.setBackground(colorBg);

		stopStart = new JButton("Start");
		stopStart.addActionListener(this);
		north.add(stopStart);
		add(north, BorderLayout.NORTH);
                
		// the event and chat room
		JPanel center = new JPanel(new GridLayout(2,1));
		chat = new JTextArea(80,80);
		chat.setEditable(false);
		appendRoom("Chat room.\n");
		center.add(new JScrollPane(chat));
		event = new JTextArea(80,80);
		event.setEditable(false);
		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));	
		add(center);
		
		// need to be informed when the user click the close button on the frame
		addWindowListener(this);
		setSize(400, 500);
		setVisible(true);
                this.setLocationRelativeTo(null);
	}		

	// append message to the two JTextArea
	// position at the end
	void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}
	void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
		
	}
	
	// start or stop where clicked
	public void actionPerformed(ActionEvent e) {
		if(server != null) {
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			stopStart.setText("Start");
			return;
		}
      	// OK start the server	
		int port;
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Cổng không hợp lệ !");
			return;
		}
		server = new Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
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
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Dừng server...\n");
			server = null;
		}
	}

}


