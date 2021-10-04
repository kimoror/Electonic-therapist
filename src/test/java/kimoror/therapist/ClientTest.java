package kimoror.therapist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Client client;

    @BeforeEach
    public void setUp(){
        client = new Client();
    }

    @Test
    void getName() {
        client.setName("adsf");
        Assertions.assertEquals("adsf", client.getName());
    }

    @Test
    void setName() {
        client.setName("adsf");
        Assertions.assertEquals("adsf", client.getName());
    }

    @Test
    void getAge() {
        client.setAge(33);
        Assertions.assertEquals(33, client.getAge());
    }

    @Test
    void setAge() {
        client.setAge(33);
        Assertions.assertEquals(33, client.getAge());
    }

    @Test
    void getSex() {
        client.setSex("М");
        Assertions.assertEquals("М", client.getSex());
    }

    @Test
    void setSex() {
        client.setSex("М");
        Assertions.assertEquals("М", client.getSex());

    }

    @Test
    void getPainType() {
        client.setPainType(1);
        Assertions.assertEquals(1, client.getPainType());
    }

    @Test
    void setPainType() {
        client.setPainType(1);
        Assertions.assertEquals(1, client.getPainType());
    }
}