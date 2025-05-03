package org.example.msg;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class ChatController {



    private final MessageService messageService;
    private final List<Message> messages = new ArrayList<>(); //Liste von Message Elemente. Könnte mit JavaFx auch mit Nodes realisiert werden.
    private final CompositeDisposable disposables = new CompositeDisposable(); //Speicherung der Subscription; Dient dazu diese zu speichern solang Daten gelsen werden und zu löschen wenn diese wieder freigegeben werden.

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void startListening() {
        Disposable subscription = messageService.getMessageStream() //Nachrichten Quelle wird geholt
                .observeOn(Schedulers.io()) // Setzt die Verarbeitung der Items (Messsages) auf den Main Thread der Anwendung
                .subscribe( // Verabreitung der verschiedenen Items
                        msg -> {
                            messages.add(msg);
                            System.out.println("Neue Nachricht: " + msg.getContent());
                        },
                        error -> System.err.println("Fehler beim Nachrichtenstrom: " + error)
                );

        disposables.add(subscription);
    }

    public void stopListening() {
        disposables.clear();
    }

    public List<Message> getMessages() {
        return messages;
    }
}
