import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Chatter extends JFrame implements IChatter, ActionListener {
    

    public Chatter(String Name, Server groupchat) {

        jf = new JFrame(); 
        jf.setSize(300,500);
        jf.setTitle(Name);
        jf.setLayout(new FlowLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display messeages
        display = new JTextArea(20,20);
        display.setEditable(false);
        // Scroll pane
        JScrollPane sp = new JScrollPane(display);

        jf.add(sp);
        
        // Text Box
        typeMsg = new JTextArea(5,20);
        jf.getContentPane().add(typeMsg);

        // Send Button
        JButton send = new JButton("Send Message");
        send.addActionListener(this);
        Dimension size1 = jf.getPreferredSize();
        send.setBounds(30, 40, size1.height, size1.width);
        jf.getContentPane().add(send);

        jf.setVisible(true);

        
        chat = groupchat; 
    }

    private JFrame jf;
    private JTextArea display; 
    private JTextArea typeMsg; 
    private Server chat;  
    private ArrayList<String> msg = new ArrayList<String>();
    
    
    public void newMessage(String name, String message) {
        msg.add(name + ": " + message + '\n');
        //formats ArrayList
        String history = " " + msg.toString()
            .replace(",", "")
            .replace("[", "")
            .replace("]", "")
            .trim();
        // displace chat conversation
        display.setText(history);
    }

    public void actionPerformed(ActionEvent e) {
        // call server to update chat
        chat.newMessage(jf.getTitle(), typeMsg.getText());
        //erase type field
        typeMsg.setText("");
    }

        
}
