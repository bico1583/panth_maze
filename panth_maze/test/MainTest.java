import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  static  char [][] maze = {
            {'X', '#',},
            {'.', 'S'}};
  @RepeatedTest(5)
    @DisplayName("Test of the path.")
    void movementTest() throws FileNotFoundException {
        char [][] maze = {
              {'X', '#',},
              {'.', 'S'}};
      assertEquals(Main.movement(maze), "l u ");
    }

    @RepeatedTest(3)
    void isValid() throws FileNotFoundException {
       assertFalse(Main.isValid(2, 2, maze));
    }

}