import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main dragon;

    @BeforeEach
    void setUp() {
        dragon = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void userInput() {
        assertEquals(" You approach the cave...\n Its dark and spooky... \n A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite!\n", dragon.userInput(1));

        assertEquals("Congratulations you won!", dragon.userInput(2));

        assertNotEquals("Congratulations you won!", Main.userInput(1));
        assertNotEquals(" You approach the cave...\n Its dark and spooky... \n A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite!\n", dragon.userInput(2));

    }
}