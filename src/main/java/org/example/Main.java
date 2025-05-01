package org.example;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import org.junit.jupiter.api.Assertions;

public class Main {

    static String result = "";
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                i -> result += i,  //OnNext
                Throwable::printStackTrace, //OnError
                () -> result += "_Completed" //OnCompleted
        ).dispose();
        Assertions.assertEquals(result, "abcdefg_Completed");


    }
}