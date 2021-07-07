
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

        static int [][] maze = {
                {'X', '#', '.', '.'},
                {'.', '#', '.', '.'},
                {'.', '.', '.', '#'},
                {'.', '#', '.', '.'},
                {'.', '#', '.', 'S'},
                {'.', '.', '.', '#'}};


/*X koniec
. cesta
# prekazka
S start
 */
      static LinkedList<Position> path = new LinkedList<Position>();



    public static void main(String[] args) throws FileNotFoundException {
       // Position p = new Position(0, 3); stara fixna poloha startu zmenena na dynamicku ↓ cyklom
        char [][] m = MazeFileLoader();
        /*
        na vypis suborov v adresari
        File file = new File("./src");
        for(String fileNames : file.list()) System.out.println(fileNames);*/
        int i, j;
        for (i = 0; i < maze.length; i++){
            for (j = 0; j < maze[i].length; j++){
                if(maze[i][j] == 'S'){
                    Position p = new Position(i,j);
                    System.out.println("start found on: " + i + " " + j);
                    path.push(p);
                }
            }
        }

        // sout na vypisanie pozicie v liste System.out.println(maze [path.peek().y][path.peek().x]);

        while (true){
            int x = path.peek().x;
            int y = path.peek().y;
            maze [y][x] = '#';

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

    public static char[][] MazeFileLoader() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("./src/input.txt")));
        int rows = 14;
        int columns = 35;
        char[][] maze = new char[rows][columns];
        char [] pole = new char[rows];
        while (sc.hasNextLine()) {
           for (int i = 0; i < maze.length; i++) {
               pole = sc.nextLine().toCharArray();

               /*  String[] line = sc.nextLine().trim().split(" ");
                pole[i] = line[0].charAt(i);*/
                for (int j = 0; j < columns; j++) {
                    maze[i] = pole;
                }
            }
        }
        System.out.println(pole);
        System.out.println(Arrays.deepToString(maze));
        return maze;

    }
}
