import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Maze{
  private char[][] maze;
  private ArrayList<String> lines;
  private int[][] moves;
  private boolean animate;

  public static void main(String[]args){
    try{
      Maze m1 = new Maze("Maze1.txt");
      m1.solve(7, 1);
      System.out.println(m1);
      //int[] s = m1.findS();
      //System.out.println(s[0] + " " + s[1]);
    }
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
    for (int idx = 0; idx < maze.length; idx ++){
      for (int idx2 = 0; idx2 < maze[0].length; idx2 ++){
        maze[idx][idx2] = lines.get(idx).charAt(idx2);
      }
    }
    moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    animate = false;
  }

  private int solve(int r, int c){
    if (maze[r][c] == 'E') return -1;
    if (maze[r][c] == ' ' || maze[r][c] == 'S'){
      maze[r][c] = '@';
      for (int idx = 0; idx < moves.length; idx ++){
        return solve(r + moves[idx][0], c + moves[idx][1]);
      }
      maze[r][c] = '.';
    }
    return -1;
  }

  public int[] findS(){
    for (int idx = 0; idx < maze.length; idx ++){
      for (int idx2 = 0; idx2 < maze[0].length; idx2 ++){
        if (maze[idx][idx2] == 'S') return new int[]{idx, idx2};
      }
    }
    return new int[1243241249];
  }

  public void setAnimate(boolean b) {animate = b;}

  public String toString(){
    String output = "";
    for (int idx = 0; idx < maze.length; idx ++){
      for (int idx2 = 0; idx2 < maze[0].length; idx2 ++){
        output += maze[idx][idx2];
      }
      output += "\n";
    }
    return output;
  }
}
