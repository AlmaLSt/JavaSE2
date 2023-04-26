package ejemplo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EchoClassTest {
    @Test
    void echoString(){
        String input = "Hola mundo";
        assertEquals(input, EchoClass.echo(input));
    }

    @Test
    void echoNumber(){
        Integer input = 5326;
        assertEquals(input, EchoClass.echo(input));
    }

    public class Clase{
        private String name;
        Clase(String name){
            this.name = name;
        }
    }

    @Test
    void echoClase(){
        Clase input = new Clase("Alma");
        assertEquals(input, EchoClass.echo(input));
    }
}