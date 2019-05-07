/*
* Abdulla Binissa
* 12/06/2018 - 5:00PM -
* 12/10/2018 - 9:30PM - 3:00AM
* 12/10/2018 - 3:45PM - 5:00PM
*
*
*/

import java.util.*;

public class Insanity
{
  public static void main(String[] args)
  {
    int arrayCase = 4;
    if(args.length > 0) arrayCase = Integer.parseInt(args[0]);

    Cubes ogCubes = new Cubes(arrayCase); // first cube puzzle
    Cubes myCubes = ogCubes;
    ArrayList<Integer> minObstacle = new ArrayList<Integer>();
    int i = myCubes.size() - 1;
    
    System.out.print(myCubes.toString() + "\n");

    //myCubes.sort(); //Sorts cubes of average colors

    boolean firstIteration = true;

    while (true)
    {
      //If no solution for n Cubes, find solution for n-1 cubes
      if ( !myCubes.findSolution() )
      {
        //If no more cubes to remove, minObstacle is found
        if( i < 0)
          break;

        myCubes.remove(i);
        i -= 1;
        firstIteration = false;
      }

      //If solution found and for full set of cubes return solution
      else if ( firstIteration )
        break;

      //  If solution found, add last removed cube back
      // and remove decrement i
      else
      {
        myCubes.add( i+1, ogCubes.get(i+1));
        minObstacle.add(i+1);
        myCubes.remove(i);
        i -= 1;
      }

    }

    if( firstIteration )
    {
      System.out.print("Solution Exists!\n");
      System.out.print(myCubes.strings() + "\n");
      System.out.print(myCubes.string(0) + "\n");
      System.out.print(myCubes.string(1) + "\n");
    }

    else
    {
      System.out.print("Solution does not exist!\n");
      System.out.print("Minimum Obstacle are cubes: ");
      printMinObstacle(minObstacle);
    }

  }

  public static void printMinObstacle(ArrayList<Integer> arr)
  {
    for( int a : arr)
    {
      System.out.print(a + " ");
    }
  }

}
