import java.util.*;

public class Cubes
{
  //Data fields
  ArrayList<Cube> cubes = new ArrayList<Cube>();              //Full set of cubes
  ArrayList<Integer> string1 = new ArrayList<Integer>();;     //String for solution 1
  ArrayList<Integer> string2 = new ArrayList<Integer>();;     //String for solution 2

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
          a = 1 + ((int)(Math.floor((n+0)*Math.PI) % 26));
          b = 1 + ((int)(Math.floor((n+1)*Math.PI) % 26));
          c = 1 + ((int)(Math.floor((n+2)*Math.PI) % 26));
          d = 1 + ((int)(Math.floor((n+3)*Math.PI) % 26));
          e = 1 + ((int)(Math.floor((n+4)*Math.PI) % 26));
          f = 1 + ((int)(Math.floor((n+5)*Math.PI) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      case 1:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((int)(Math.floor((n+0)*Math.E) % 26));
          b = 1 + ((int)(Math.floor((n+1)*Math.E) % 26));
          c = 1 + ((int)(Math.floor((n+2)*Math.E) % 26));
          d = 1 + ((int)(Math.floor((n+3)*Math.E) % 26));
          e = 1 + ((int)(Math.floor((n+4)*Math.E) % 26));
          f = 1 + ((int)(Math.floor((n+5)*Math.E) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      case 2:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((int)(Math.floor((n+0)*Math.sqrt(3)) % 26));
          b = 1 + ((int)(Math.floor((n+1)*Math.sqrt(3)) % 26));
          c = 1 + ((int)(Math.floor((n+2)*Math.sqrt(3)) % 26));
          d = 1 + ((int)(Math.floor((n+3)*Math.sqrt(3)) % 26));
          e = 1 + ((int)(Math.floor((n+4)*Math.sqrt(3)) % 26));
          f = 1 + ((int)(Math.floor((n+5)*Math.sqrt(3)) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
      case 3:
        for(int j = 0; j < 26; j+=1)
        {
          n = j*6;
          a = 1 + ((int)(Math.floor((n+0)*Math.sqrt(5)) % 26));
          b = 1 + ((int)(Math.floor((n+1)*Math.sqrt(5)) % 26));
          c = 1 + ((int)(Math.floor((n+2)*Math.sqrt(5)) % 26));
          d = 1 + ((int)(Math.floor((n+3)*Math.sqrt(5)) % 26));
          e = 1 + ((int)(Math.floor((n+4)*Math.sqrt(5)) % 26));
          f = 1 + ((int)(Math.floor((n+5)*Math.sqrt(5)) % 26));
          temp = new Cube(a,b,c,d,e,f);
          cubes.add(temp);
        }
        break;
        
      case 4: // test case with 4 cubes
          int size = 3;
        for(int j = 0; j < size; j+=1)
        {
          n = j*6;
          a = 1 + ((int)(Math.floor((n+0)*Math.E) % size));
          b = 1 + ((int)(Math.floor((n+1)*Math.E) % size));
          c = 1 + ((int)(Math.floor((n+2)*Math.E) % size));
          d = 1 + ((int)(Math.floor((n+3)*Math.E) % size));
          e = 1 + ((int)(Math.floor((n+4)*Math.E) % size));
          f = 1 + ((int)(Math.floor((n+5)*Math.E) % size));
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
  private boolean nodeConflict(int i, int j, int s)
  {
    int x = cubes.get(i).faces[j*2];     //face 1 of pair
    int y = cubes.get(i).faces[j*2+1];   //face 2 of pair
    int xCount = 1;
    int yCount = 1;
    int x2, y2;
    
    ArrayList<Integer> stringX;
    
    if(s == 0)
        stringX = string1;
    else
    {
        stringX = string2;
        //If node already used in string 1
        if( string1.get(i) == j )
            return true;
    }
    
    for(int k = 0; k < stringX.size(); k+=1)
    {
      x2 = cubes.get(k).faces[stringX.get(k)*2];
      y2 = cubes.get(k).faces[stringX.get(k)*2+1];
      
      if(x == y)
      {
          xCount +=1;
          yCount +=1;
      }
      
      if(x2 == x)
          xCount +=1;
      if(y2 == x)
          xCount +=1;
      if(x2 == y)
          yCount +=1;
      if(y2 == y)
          yCount +=1;
      
      if(xCount >= 3 || yCount >= 3)
          return true;
    }
    
    return false;
  }

  private void addNode(int j, int s)
  {
      if(s == 0)
          string1.add(j);
      else
          string2.add(j);
      
  }

  private void popNode(int s)
  {
      if(s == 0)
          string1.remove(string1.size()-1);
      else
          string2.remove(string2.size()-1);
  }

  private int lastNodePositionAtJ(int s)
  {
    if(s == 0)
      return string1.size() - 1;
    else
      return string2.size() - 1;
  }

  public boolean findSolution()
  {
    int j = 0;
    for (int s = 0; s < 2; s += 1)
    {
      for (int i = 0; i < cubes.size(); i += 1)
      {
        if( j <= 2 && i >= 0 ) // j <= 2
        {
          if( !nodeConflict(i,j,s) )
          {
            addNode(j,s);
            j = 0;
          }
          else
          {
            j += 1;
            i -= 1;
          }
        }
        else
        {
          popNode(s);
          i -= 2;
          j = lastNodePositionAtJ(s) + 1;
        }
      }
    }
    return true;
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
    return cubes.size();
  }

  public Cube get(int i)
  {
    return cubes.get(i);
  }

  public void add(int i, Cube c)
  {
    cubes.add(i, c);
  }
  
  @Override
  public String toString()
  {
    String result = "";
    for(Cube cube : cubes)
    {
      result += cube.toString() + "\n";
    }
    return result;
  }
  
  public String strings()
  {
    String result = "";
    for(int i = 0; i < string1.size(); i+=1)
    {
      result += cubes.get(i).getPair(string1.get(i)) + 
              "   " +
              cubes.get(i).getPair(string2.get(i)) +
              "\n";
    }
    return result;
  }
  
  public String string(int s)
  {
      ArrayList<Integer> stringX;
    String result = "";
    if(s == 0)
        stringX = string1;
    else
        stringX = string2;
    
      for( int i : stringX)
          result += i + " ";
      
      return result;
  }
  
}