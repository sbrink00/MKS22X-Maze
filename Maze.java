import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Maze{
  private char[][] maze;
  private ArrayList<String> lines;


  public static void main(String[]args){
    try{Maze m1 = new Maze("Maze1.txt");}
    catch (FileNotFoundException e) {e.printStackTrace();}

  }

  public Maze(String filename) throws FileNotFoundException{
    Scanner scan = new Scanner(new File(filename));
    lines = new ArrayList<String>();
    while (scan.hasNext()){
      String temp = scan.nextLine();
      lines.add(temp);
    }
    maze = new char[lines.size()][lines.get(0).length()];
    //System.out.println(maze[0][0]);
  }
}
