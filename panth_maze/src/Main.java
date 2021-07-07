
import java.util.LinkedList;

public class Main {

        static int [][] maze = {
                {'X', '#', '.', 'S'},
                {'.', '#', '.', '.'},
                {'.', '.', '.', '#'},
                {'.', '#', '.', '.'},
                {'.', '#', '.', '.'},
                {'.', '.', '.', '#'}};


/*X koniec
. cesta
# prekazka
S start
 */
      static LinkedList<Position> path = new LinkedList<Position>();



    public static void main(String[] args) {
        Position p = new Position(0, 3);


        path.push(p);

        // sout na vypisanie pozicie v liste System.out.println(maze [path.peek().y][path.peek().x]);

        while (true){
            int x = path.peek().x;
            int y = path.peek().y;
            maze [y][x] = 0;

            if (isValid(y + 1, x)){
                //dolu
                if (maze[y + 1][x] == 'X'){
                    System.out.println("d, GG EZ");
                    return;
                }
                else if (maze[y + 1][x] == '.'){
                    path.push(new Position(y + 1, x));
                    System.out.println("d, ");
                    continue;
                }
            }

            if (isValid(y - 1, x)){
                //hore
                if (maze[y - 1][x] == 'X'){
                    System.out.println("u, GG EZ");
                    return;
                }
                else if (maze[y - 1][x] == '.'){
                    path.push(new Position(y - 1, x));
                    System.out.println("u, ");
                    continue;
                }
            }



            if (isValid(y, x + 1)){
                //vpravo
                if (maze[y][x + 1] == 'X'){
                    System.out.println("r, GG EZ");
                    return;
                }
                else if (maze[y][x + 1] == '.'){
                    path.push(new Position(y, x + 1));
                    System.out.println("r, ");
                    continue;
                }
            }

            if (isValid(y, x - 1)){
                //vlavo
                if (maze[y][x - 1] == 'X'){
                    System.out.println("l, GG EZ");
                    return;
                }
                else if (maze[y][x - 1] == '.'){
                    path.push(new Position(y, x - 1));
                    System.out.println("l, ");
                    continue;
                }
                path.pop();
                System.out.println("b, ");
                if (path.size() <= 0){
                    System.out.println("Nuh uh");
                    return;
                }
            }
        }
    }

    public static boolean isValid(int y, int x){
        if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length){
            return false;
        }

        return true;
    }
}
