package reto3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Reto3 {

    @Test
    @DisplayName("Problemático")
    void reto(){
        //solucion
        List<? extends Number> numberList;

        //List<Number> numberList;

        List<Integer> integerList = List.of(1,2,3);

        numberList = integerList; // igualando
        System.out.println(numberList);
        assertNotNull(numberList);
    }

}
