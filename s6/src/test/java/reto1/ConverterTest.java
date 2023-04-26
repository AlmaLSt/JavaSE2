package reto1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void string(){
        Integer integer = 1234;
        String expected = "1234";

        Converter<Integer> integerConverter = new Converter<>();

        assertEquals(expected, integerConverter.convertir(integer));
    }

}