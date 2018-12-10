/*
* Abdulla Binissa
* 12/06/2018 - 5:00PM -
* 12/10/2018 - 9:30PM - 2:00AM
*
*/

import java.util.*;

public class Cube
{
  int[] faces;

  public Cube(int a, int b, int c, int d, int e, int f)
  {
    faces[0] = a;
    faces[1] = b;
    faces[2] = c;
    faces[3] = d;
    faces[4] = e;
    faces[5] = f;
  }
}

public class Cubes
{
  //Data fields
  ArrayList<Cube> cubes;
  ArrayList<int[]> string1;
  ArrayList<int[]> string2;

  //Constructor
  public Cubes(int i)
  {
    Cube temp;
    int a,b,c,d,e,f;
    int n;
    switch(i)
    {
      case 0:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((Math.floor((n+0)*Math.pi) % 26));
          b = 1 + ((Math.floor((n+1)*Math.pi) % 26));
          c = 1 + ((Math.floor((n+2)*Math.pi) % 26));
          d = 1 + ((Math.floor((n+3)*Math.pi) % 26));
          e = 1 + ((Math.floor((n+4)*Math.pi) % 26));
          f = 1 + ((Math.floor((n+5)*Math.pi) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      case 1:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((Math.floor((n+0)*Math.e) % 26));
          b = 1 + ((Math.floor((n+1)*Math.e) % 26));
          c = 1 + ((Math.floor((n+2)*Math.e) % 26));
          d = 1 + ((Math.floor((n+3)*Math.e) % 26));
          e = 1 + ((Math.floor((n+4)*Math.e) % 26));
          f = 1 + ((Math.floor((n+5)*Math.e) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      case 2:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((Math.floor((n+0)*Math.sqrt(3)) % 26));
          b = 1 + ((Math.floor((n+1)*Math.sqrt(3)) % 26));
          c = 1 + ((Math.floor((n+2)*Math.sqrt(3)) % 26));
          d = 1 + ((Math.floor((n+3)*Math.sqrt(3)) % 26));
          e = 1 + ((Math.floor((n+4)*Math.sqrt(3)) % 26));
          f = 1 + ((Math.floor((n+5)*Math.sqrt(3)) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      case 3:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((Math.floor((n+0)*Math.sqrt(5)) % 26));
          b = 1 + ((Math.floor((n+1)*Math.sqrt(5)) % 26));
          c = 1 + ((Math.floor((n+2)*Math.sqrt(5)) % 26));
          d = 1 + ((Math.floor((n+3)*Math.sqrt(5)) % 26));
          e = 1 + ((Math.floor((n+4)*Math.sqrt(5)) % 26));
          f = 1 + ((Math.floor((n+5)*Math.sqrt(5)) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      default:
        System.out.println("Error 101");
        break;
    }
  }

  //Methods
  private void fsAdd();

  public boolean findSolution()
  {

  }

  public void sort()
  {

  }

  public void remove(int i)
  {
    cubes.remove(i);
  }

  public int size()
  {
    cubes.size();
  }

  public Cube get(int i)
  {
    cubes.get(i);
  }

  public void add(int i, Cube c)
  {
    cubes.add(i, c);
  }

}

public class Insanity
{
  public static void main(String[] args)
  {
    Cubes ogCubes = new Cubes(0); // first cube puzzle
    Cubes myCubes = ogCubes;
    ArrayList<int> minObstacle;
    int i = myCubes.size() - 1;

    myCubes.sort(); //Sorts cubes of average colors

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
      else if ( i == myCubes.size() - 1 )
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
      System.out.print("Solution Exists!");
      //myCubes.printSolution();
    }

    else
    {
      System.out.print("Solution does not exist!\n");
      System.out.print("Minimum Obstacle are cubes: ");
      printMinObstacle(minObstacle);
    }

  }

  public void printMinObstacle(ArrayList<int> arr)
  {
    for( int a : arr)
    {
      System.out.print(a + " ");
    }
  }

}
