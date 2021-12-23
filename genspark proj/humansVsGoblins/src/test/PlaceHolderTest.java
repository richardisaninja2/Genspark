import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceHolderTest {
    PlaceHolder place;
    @BeforeEach
    void setUp() {
        place = new PlaceHolder();
    }
    @Test
    void setName(){
        assertEquals("hello", place.setName("hello"), "the input is invalid");
    }
    @Test
    void getName() {
        assertEquals( new String(Character.toChars(Integer.parseInt("26C9",16))), place.getName(), "output is not correct");
    }
    @AfterEach
    void tearDown() {
    }

}