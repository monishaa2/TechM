public class SecondaryUser {
    private String name;
    private int age;
    private String city;
    private long mobilenumber;

    public SecondaryUser(String name, int age, String city, long mobilenumber) {
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
}
