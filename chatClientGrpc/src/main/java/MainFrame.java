import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel firstUserLabel  =new JLabel("First User:");
    private JLabel secondtUserLabel  =new JLabel("Second User:");

    private JTextField firstUserText = new JTextField(30);
    private JTextField secondtUserText = new JTextField(30);

    private JButton start = new JButton("Start Conversation");

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,600);

        JPanel panel = new JPanel();
        panel.add(firstUserLabel);
        panel.add(firstUserText);

        JPanel panel1 = new JPanel();
        panel.add(secondtUserLabel);
        panel.add(secondtUserText);

        JPanel panel2 = new JPanel();
        panel.add(start);

        JPanel panel3 = new JPanel();
        panel3.add(panel);
        panel3.add(panel1);
        panel3.add(panel2);

        this.add(panel3);
    }

    public void addStartListener(ActionListener buttonStart){
        start.addActionListener(buttonStart);
    }

    public String getFirstUserText() {
        return firstUserText.getText();
    }

    public String getSecondtUserText() {
        return secondtUserText.getText();
    }
}
















