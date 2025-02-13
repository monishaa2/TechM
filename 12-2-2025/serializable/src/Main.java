import java.io.*;


public class Main {

  public static void main(String[] args) throws IOException {
      serialize();
      deserialize();


  }

      public static void serialize()
      {
          try {
             
              Student s1 = new Student(211, "ravi");
            
              FileOutputStream fout = new FileOutputStream("f.txt");
              ObjectOutputStream out = new ObjectOutputStream(fout);
              out.writeObject(s1);
              out.flush();
             
              out.close();
              System.out.println("success");
          } catch (Exception e) {
              System.out.println(e);
          }
      }
      public static void deserialize() {
          try {
              
              ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
              Student s = (Student) in.readObject();
             
              System.out.println(s.rno + " " + s.name);
              
              in.close();
          } catch (Exception e) {
              System.out.println(e);
          }
      }
}

    class Student implements Serializable
    {
        Student(int rno, String name){
            this.rno=rno;
            this.name=name;
        }
        int rno;
        String name;
    }


