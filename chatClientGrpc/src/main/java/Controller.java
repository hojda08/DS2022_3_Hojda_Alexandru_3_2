import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {
    private MainFrame mainFrame;
    private ChatFrame chatFrame;
    private ClientGRPC clientGRPC;

    public Controller(MainFrame mainFrame, ChatFrame chatFrame) {

        clientGRPC = new ClientGRPC();

        this.mainFrame = mainFrame;
        this.chatFrame = chatFrame;

        this.mainFrame.addStartListener(new StartListener());

        this.chatFrame.addBackListener(new BackListener());
        this.chatFrame.addGetMessagesListener(new GetMessagesListener());
        this.chatFrame.addSendListener(new SendMessageListener());
        this.chatFrame.addSendSecondListener(new SendSecondMessageListener());


        this.mainFrame.setVisible(true);
        this.chatFrame.setVisible(false);
    }

    class StartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            chatFrame.setVisible(true);
            mainFrame.setVisible(false);

            chatFrame.setStUser(mainFrame.getFirstUserText());
            chatFrame.setNdUser(mainFrame.getSecondtUserText());
        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setVisible(true);
            chatFrame.setVisible(false);
        }
    }

    class GetMessagesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            List<Messages.Message> messages = clientGRPC.getMessages();

            for(Messages.Message message : messages){
                chatFrame.getTextArea().append("\n" + message.getSender() + ":   " + message.getText());
            }
        }
    }

    class SendMessageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clientGRPC.sendMessage(chatFrame.getFirstUserText(),chatFrame.getFirstUserMessage());
        }
    }

    class SendSecondMessageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clientGRPC.sendMessage(chatFrame.getSecondtUserText(),chatFrame.getSecondtUserMessage());
        }
    }


}
