import java.io.Serializable;
import  java.io.*;
public class example2 {
    public static void serialize()
    {
        try {
            //Creating the object
            employee e1 = new employee(21,"anisha","anishahakunakmatata@gmail.com");
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(e1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void deserialize() {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
            employee e  = (employee) in.readObject();
            //printing the data of the serialized object
            System.out.println(e.eno + " " + e.ename);
            //closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main (String [] args) throws IOException
    {
        serialize();
        deserialize();
    }

}


class employee  implements Serializable
{
    int eno ;
    String ename ;
    String email ;

    employee(int eno , String ename , String email)
    {
        this.eno = eno;
        this.ename = ename;
        this.email = email;
    }
}