package org.example.msg;

import io.reactivex.rxjava3.core.Observable;

public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Observable<Message> getMessageStream() {
        return repository.observeIncomingMessages();
    }
}
