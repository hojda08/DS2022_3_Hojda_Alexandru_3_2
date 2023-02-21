import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class ClientGRPC {
    ManagedChannel managedChannel;
    ChatServiceGrpc.ChatServiceBlockingStub chatServiceBlockingStub;

    public ClientGRPC() {
        this.managedChannel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        this.chatServiceBlockingStub = ChatServiceGrpc.newBlockingStub(managedChannel);

    }

    public void sendMessage(String user,String text){
        Messages.Message message = Messages.Message.newBuilder().setSender(user).setText(text).build();
        chatServiceBlockingStub.sendMessage(message);
    }

    public List<Messages.Message> getMessages(){
        Messages.MessageList messageListasd = chatServiceBlockingStub.getMessages(Messages.Empty.newBuilder().build());
        List<Messages.Message> messagesasd = messageListasd.getMessagesList();
        System.out.println(messagesasd.size());

        for(Messages.Message mess : messagesasd){
            System.out.println("Sender: " + mess.getSender() + " -> " + mess.getText());
        }

        return messagesasd;
    }
}
