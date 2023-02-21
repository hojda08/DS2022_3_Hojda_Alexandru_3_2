public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        ChatFrame chatFrame = new ChatFrame();

        Controller controller = new Controller(mainFrame,chatFrame);
    }
}
