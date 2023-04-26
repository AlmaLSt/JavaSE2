package reto2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticTest {

    @Test
    void reto2(){
        Integer input = 1234;
        String expected = "1234";

        String output = Static.ConvertToString(input);

        assertEquals(expected, output);
    }

}