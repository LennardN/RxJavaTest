import org.example.msg.*;
import org.junit.jupiter.api.Test;

public class TestMessaging {

    @Test
    public void test(){
        MessageRepository repo = new MessageRepository();
        MessageService service = new MessageService(repo);
        ChatController vm = new ChatController(service);

        vm.startListening();

        repo.simulateIncomingMessage(new Message("Alice", "Hallo!"));
        repo.simulateIncomingMessage(new Message("Bob", "Hey Alice!"));

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        vm.stopListening();
    }
}
