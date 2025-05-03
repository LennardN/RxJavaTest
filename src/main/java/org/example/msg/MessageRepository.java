package org.example.msg;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class MessageRepository {

    private final PublishSubject<Message> messageStream = PublishSubject.create();

    public Observable<Message> observeIncomingMessages() {
        return messageStream.hide();
    }

    // Simuliere eingehende Nachrichten; in einem richtigen Projekt würde man hier ein Websocket Listener benutzen.
    // Man könnte mit einem Service diese Daten in das Repository legen, welcher die dan weitergehend verwaltet
    public void simulateIncomingMessage(Message message) {
        messageStream.onNext(message);
    }

    public void simulateError(Throwable error) {
        messageStream.onError(error);
    }
}
