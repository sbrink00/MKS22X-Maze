import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        //This is generally bad behavior
        File text = new File("Maze1.txt");
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"
        //inf stands for the input file
        Scanner inf = new Scanner(text);
        String lineLength = inf.nextLine();
        int col = lineLength.length();
        inf.reset();
        int row = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            row ++;
            //System.out.println(line);//hopefully you can do other things with the line
        }
        char[][] maze = new char[row][col];
        inf.reset();
        int r = 0;
        while(inf.hasNextLine()){
          String line = inf.nextLine();
          for (int idx = 0; idx < line.length(); idx ++){
            maze[r][idx] = line.charAt(idx);
          }
          r ++;
        }
        String output = "[[";
        for (int idx = 0; idx < maze.length; idx ++){
          System.out.println(printArray(maze[idx])+"\n");
        }
    }

    public static String printArray(char[] ary){
      String output = "";
      for (int idx = 0; idx < ary.length; idx ++){
        output += ary[idx] + " ";
      }
      return output;
    }
}
