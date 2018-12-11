public class Cube
{
  public int[] faces;

  public Cube(int a, int b, int c, int d, int e, int f)
  {
    faces = new int[6];
    faces[0] = a;
    faces[1] = b;
    faces[2] = c;
    faces[3] = d;
    faces[4] = e;
    faces[5] = f;
  }
  
  private String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
}
  
  public String getPair(int i)
  {
    return getCharForNumber(faces[i*2]) + "-" + getCharForNumber(faces[i*2 +1]);
  }
  
  @Override
  public String toString()
  {
    return String.format("%s-%s   %s-%s   %s-%s", 
            getCharForNumber(faces[0]), 
            getCharForNumber(faces[1]),
            getCharForNumber(faces[2]),
            getCharForNumber(faces[3]),
            getCharForNumber(faces[4]),
            getCharForNumber(faces[5]) );
  }
  
}