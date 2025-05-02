package org.example.msg;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class ChatController {

    private final MessageService messageService;
    private final List<Message> messages = new ArrayList<>();
    private final CompositeDisposable disposables = new CompositeDisposable();

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void startListening() {
        Disposable subscription = messageService.getMessageStream()
                .observeOn(Schedulers.io())
                .subscribe(
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
