package kimoror.therapist;

import kimoror.therapist.Client;
import kimoror.therapist.Therapist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;


public class TherapistTest {
    @Mock
    Client currentClient;

    Therapist therapist;

    @BeforeEach
    void setUp(){
        this.therapist = new Therapist();
        therapist.setCurrentClient(new Client());
    }

    @Test
    public void setClientNameTest(){

        String input = "Михаил";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        therapist.setClientName();

        Assertions.assertEquals("Михаил", therapist.getCurrentClient().getName());
    }

    /**
     * Ошибка
     * @java.util.NoSuchElementException - выбрасывается потому что, метод зашёл в цикл и ожидает повторного ввода.
     * А ввода нет
     */
    @Test
    public void setClientNameTestNoLineFound(){

        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NoSuchElementException.class, () -> therapist.setClientName());
    }

    @Test
    public void setClientSexTest(){

        String input = "М";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        therapist.setClientSex();

        Assertions.assertEquals("М", therapist.getCurrentClient().getSex());
    }

    /**
     * Ошибка
     * @java.util.NoSuchElementException - выбрасывается потому что, метод зашёл в цикл и ожидает повторного ввода.
     * А ввода нет
     */
    @Test
    public void setClientSexTestNoLineFound(){

        String input = "af";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NoSuchElementException.class, () -> therapist.setClientSex());
    }

    @Test
    public void setClientAgeTest(){

        String input = "15";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        therapist.setClientAge();

        Assertions.assertEquals(15, therapist.getCurrentClient().getAge());
    }

    /**
     * Ошибка
     * @java.util.NoSuchElementException - выбрасывается потому что, метод зашёл в цикл и ожидает повторного ввода.
     * А ввода нет
     */
    @Test
    public void setClientAgeTestNoLineFound(){

        String input = "0.3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NoSuchElementException.class, () -> therapist.setClientAge());

    }

    @Test
    public void setClientPainTypeTest(){

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        therapist.setClientPainType();

        Assertions.assertEquals(3, therapist.getCurrentClient().getPainType());
    }

    /**
     * Ошибка
     * @java.util.NoSuchElementException - выбрасывается потому что, метод зашёл в цикл и ожидает повторного ввода.
     * А ввода нет
     */
    @Test
    public void setClientPainTypeTestNoLineFound(){

        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(NoSuchElementException.class, () -> therapist.setClientPainType());

    }
}
