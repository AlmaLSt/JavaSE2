import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ejemplo2 {

    List<Integer> transformar(Iterable<Integer> conjunto, Function<Integer, Integer> function) {
        List<Integer> nuevaLista = new ArrayList<>();

            for(Integer v : conjunto){
                nuevaLista.add(function.apply(v));
            }
    return nuevaLista;
    }

    Integer transformarYSumar(Iterable<Integer> conjunto, Function<Integer, Integer> function){
       Integer i = 0;

        for(Integer v: conjunto){
            i += function.apply(v);
        }

        return i;
    }
}
