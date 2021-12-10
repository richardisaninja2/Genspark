import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void userInput() {
        assertEquals("Congratulations you won!", main.userInput(2), "it doesnt work");
    }

    @AfterEach
    void tearDown() {
    }


}