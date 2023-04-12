import java.sql.SQLIntegrityConstraintViolationException;
import java.util.function.Function;

public class Ejemplo1 {

    //Forma 1
//    private final StringToInteger parser  = new StringToInteger() {
//        @Override
//        public Integer convertir(String str) {
//            return Integer.parseInt(str);
//        }
//    };

    //Forma 2
//    private final StringToInteger parser = s -> Integer.parseInt(s);
//    Integer sumar(String a, String b){
//        return parser.convertir(a) + parser.convertir(b);
//    }

    private final Function<String, Integer> parser = Integer::parseInt;

    Integer sumar(String a, String b) {
        return parser.apply(a) + parser.apply(b);
    }

}
