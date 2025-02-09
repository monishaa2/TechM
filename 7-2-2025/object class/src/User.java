import java.util.Objects;
public class User {
    private String name;
    private int age;
    private String city;
    private long mobilenumber;

    public User(String name, int age, String city, long mobilenumber) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.mobilenumber = mobilenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(long mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Override
    public String toString() {
        return "name=" + name + "', age=" + age + ", city='" + city + "', mobilenumber=" + mobilenumber;
    }

    @Override
    public int hashCode() {
        return name.length() + age + city.length() + (int) (mobilenumber % 1000);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            return this.name.equals(user.name);
        }
        return false;
    }

}
