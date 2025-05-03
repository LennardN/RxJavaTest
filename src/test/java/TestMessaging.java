import org.example.msg.*;
import org.junit.jupiter.api.Test;

public class TestMessaging {

    @Test
    public void test(){
        /*
        Das Repository liefert Daten
        Der Service kapselt die Quelle
        Der Controller benutzt die Daten
        */
        MessageRepository repo = new MessageRepository();
        MessageService service = new MessageService(repo);
        ChatController vm = new ChatController(service);

        vm.startListening();

        repo.simulateIncomingMessage(new Message("Alice", "Hallo!"));
        repo.simulateIncomingMessage(new Message("Bob", "Moin!"));
        repo.simulateError(new Throwable("Error1234"));

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        vm.stopListening();

        /*
        Vorteile:
        - Threadsafe
        - Asynchron => nicht blockierend
        - Parallelisiert automatisch
         */
    }
}
