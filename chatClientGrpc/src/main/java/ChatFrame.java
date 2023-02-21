import javax.swing.*;
import java.awt.event.ActionListener;

public class ChatFrame extends JFrame {
    private JLabel firstUserLabel  =new JLabel("First User:");
    private JLabel secondtUserLabel  =new JLabel("Second User:");
    private JLabel firstUserMessageLabel  =new JLabel("Message First User:");
    private JLabel secondMessageUserLabel  =new JLabel("Message Second User:");

    private JTextField firstUserText = new JTextField(30);
    private JTextField secondtUserText = new JTextField(30);

    private JTextField firstUserMessage = new JTextField(30);
    private JTextField secondtUserMessage = new JTextField(30);

    private JButton back = new JButton("Back");
    private JButton sendFirst = new JButton("Send First");
    private JButton sendSecond = new JButton("Send Second");
    private JButton getMessages = new JButton("Get Messages");

    private JTextArea textArea = new JTextArea();

    private String stUser;
    private String ndUser;

    public ChatFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);

        textArea.setText("");
        //textArea.setSize(400,400);

        JPanel panel = new JPanel();
        panel.add(firstUserLabel);
        panel.add(firstUserText);

        JPanel panelMessage = new JPanel();
        panelMessage.add(firstUserMessageLabel);
        panelMessage.add(firstUserMessage);

        JPanel panel1 = new JPanel();
        panel1.add(secondtUserLabel);
        panel1.add(secondtUserText);

        JPanel panelMessage1 = new JPanel();
        panelMessage1.add(secondMessageUserLabel);
        panelMessage1.add(secondtUserMessage);

        JPanel panel2 = new JPanel();
        panel2.add(sendFirst);
        panel2.add(sendSecond);
        panel2.add(back);
        panel2.add(getMessages);

        JPanel panelTextArea = new JPanel();
        panelTextArea.add(textArea);

        JPanel panel3 = new JPanel();
        panel3.add(panel);
        panel3.add(panelMessage);
        panel3.add(panel1);
        panel3.add(panelMessage1);
        panel3.add(panel2);
        panel3.add(panelTextArea);



        this.add(panel3);
    }

    public void addBackListener(ActionListener buttonBack){
        back.addActionListener(buttonBack);
    }

    public void addSendListener(ActionListener buttonSend){
        sendFirst.addActionListener(buttonSend);
    }

    public void addSendSecondListener(ActionListener buttonSend){
        sendSecond.addActionListener(buttonSend);
    }

    public void addGetMessagesListener(ActionListener buttonGetMessages){
        getMessages.addActionListener(buttonGetMessages);
    }

    public String getFirstUserText() {
        return firstUserText.getText();
    }

    public String getSecondtUserText() {
        return secondtUserText.getText();
    }

    public String getFirstUserMessage() {
        return firstUserMessage.getText();
    }

    public String getSecondtUserMessage() {
        return secondtUserMessage.getText();
    }

    public String getStUser() {
        return stUser;
    }

    public void setStUser(String stUser) {
        this.stUser = stUser;
    }

    public String getNdUser() {
        return ndUser;
    }

    public void setNdUser(String ndUser) {
        this.ndUser = ndUser;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}




















