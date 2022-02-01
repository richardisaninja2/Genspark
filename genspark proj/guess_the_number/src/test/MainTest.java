import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MainTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }


    @Test
    void userInput(){
        assertEquals("Good Job", game.userInput(20, "a"));
    }

    @Test
    void newGame() {
   // assertEquals("congeas you won", main.newGame(2), "the game ended");
    }

    @AfterEach
    void tearDown() {
    }

}