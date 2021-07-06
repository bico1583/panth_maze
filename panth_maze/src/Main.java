
import java.util.LinkedList;

public class Main {

        static int [][] maze = {
                {2, 0, 1, 3},
                {1, 1, 0, 1},
                {0, 0, 1, 1}  };
/*2 koniec
1 cesta
0 prekazka
3 start
 */
      static LinkedList<Position> path = new LinkedList<Position>();



    public static void main(String[] args) {
        Position p = new Position(0, 3);


        path.push(p);

        System.out.println(maze [path.peek().y][path.peek().x]);

        while (true){
            int x = path.peek().x;
            int y = path.peek().y;
            maze [y][x] = 0;
            //dolu
            if (maze[y + 1][x] == 2){
                System.out.println("GG EZ");
                return;
            }
            else if (maze[y + 1][x] == 1){
                path.push(new Position(y + 1, x));
                System.out.println("d, ");
                continue;
            }
            else{
                return;
            }
        }


    }
}
