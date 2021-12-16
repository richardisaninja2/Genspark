import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class MainTest {
    Main main;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        main = new Main();
    }


    @Test
    void difficulty() {
    }

    @Test
    void structure() {
        assertEquals(2, main.structure(2), "it doesn't word");
    }


    /*
    @Test
    void getInput() {
    }

    @Test
    void guesses() {
    }
    */

    @AfterEach
    void tearDown() {
    }

}