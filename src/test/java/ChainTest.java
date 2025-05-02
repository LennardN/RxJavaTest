import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

public class ChainTest {
    /*
    Testen mit map, reduce, collect zum veränder von Datenströmen
     */


    @Test
    public void test1(){
        Observable.fromArray("a", "b", "c", "d", "e", "f", "g")//Direkte Verabreitung vom Datenstrom vom Observable
                .reduce("", (acc, item) -> acc + item)
                .map(s -> s + "_Completed")
                .subscribe(System.out::println)
                .dispose();

    }
}
