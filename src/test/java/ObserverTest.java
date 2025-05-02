import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class ObserverTest {
    /*
    Testen mit Observable, subscribe und Threadsafe Objekten
     */

    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    Observable<String> observable = Observable.fromArray(letters);

    static String result1 = ""; //workaround nicht threadsafe

    @Test
    public void testStaticString(){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(
                item -> result1 += item,  //OnNext wird für jedes objekt im Datenstrom (Oberserveable) ausgeführt
                Throwable::printStackTrace, //OnError wird ausgeführt fa
                () -> result1 += "_Completed"  //OnCompleted
        ).dispose();
        Assertions.assertEquals(result1, "abcdefg_Completed");
    }

    @Test
    public void testAtomicReference(){
        AtomicReference<String> result2 = new AtomicReference<>("");
        observable.subscribe(
                item -> result2.updateAndGet(r -> r + item),  //OnNext wird für jedes objekt im Datenstrom (Oberserveable) ausgeführt
                Throwable::printStackTrace, //OnError wird ausgeführt fa
                () -> result2.updateAndGet(r -> r + "_Completed")  //OnCompleted
        ).dispose();
        Assertions.assertEquals(result2.get(), "abcdefg_Completed");
    }

    @Test
    public void testStringBuilder() {
        StringBuilder result3 = new StringBuilder();
        observable.subscribe(
                //item -> result3.append(item) lange alternative
                result3::append,  //OnNext wird für jedes objekt im Datenstrom (Oberserveable) ausgeführt
                Throwable::printStackTrace, //OnError wird ausgeführt fa
                () -> result3.append("_Completed")  //OnCompleted
        ).dispose();
        Assertions.assertEquals(result3.toString(), "abcdefg_Completed");
    }
}
