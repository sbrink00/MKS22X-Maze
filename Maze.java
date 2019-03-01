import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Maze{
  private char[][] maze;
  private ArrayList<String> lines;
  private int[][] moves;
  private boolean animate;

  public static void main(String[]args){
    try{
      Maze m1 = new Maze("Maze2.txt");
      //m1.setAnimate(true);
      System.out.println(m1.solve());
      //System.out.println(m1.movesToString());
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

  private int solve(){
    int[] start = findS();
    return solve(start[0], start[1], 0);
    //return countAts();
  }

  private int solve(int r, int c, int total){
    if (maze[r][c] == 'E') return total;
    if (maze[r][c] == ' ' || maze[r][c] == 'S'){
      maze[r][c] = '@';
      for (int idx = 0; idx < moves.length; idx ++){
        if (solve(r + moves[idx][0], c + moves[idx][1], total + 1) != -1) return total;
      }
      maze[r][c] = '.';
    }
    if (animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
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

  public int countAts(){
    int total = 0;
    for (int idx = 0; idx < maze.length; idx ++){
      for (int idx2 = 0; idx2 < maze[0].length; idx2 ++){
        if (maze[idx][idx2] == '@') total ++;
      }
    }
    return total;
  }

  public void setAnimate(boolean b) {animate = b;}
  public void clearTerminal(){System.out.println("\033[2J\033[1;1H");}
  private void wait(int millis){
     try {Thread.sleep(millis);}
     catch (InterruptedException e) {}
  }

  public String movesToString(){
    String output = "[[";
      for (int idx = 0; idx < moves.length; idx ++){
        for (int idx2 = 0; idx2 < moves[0].length; idx2 ++){
          output += moves[idx][idx2] + ", ";
        }
        output = output.substring(0, output.length() - 2) + "], [";
      }
      return output.substring(0, output.length() - 3) + "]";
    }

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
