import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumansTest {
    Humans human;
    @BeforeEach
    void setUp() {
        human = new Humans();
    }


    @Test
    void setName() {
        assertEquals("this", human.setName("this"), "the function isn't working correctly");
    }

    @Test
    void getHealth() {
        assertEquals(25, human.getHealth(), "the input isn't correct");
    }

    @AfterEach
    void tearDown() {
    }


}