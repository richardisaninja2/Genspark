import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.IOException;

class HighScoreTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void checkHighScore() throws IOException {
        assertEquals(2, main.checkHighScore(), "this is not the correct answer");
    }



    @AfterEach
    void tearDown() {
    }

    @Test
    void testCheckHighScore() {
    }
}