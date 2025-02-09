public class Main {
    public static void main(String[] args) {
        User user1 = new User("Veebha", 20, "Delhi", 9123456789L);
        User user2 = new User("Veebha", 20, "Delhi", 9123456789L);
        SecondaryUser secUser1 = new SecondaryUser("Mithra", 30, "Mumbai", 9784561235L);
        SecondaryUser secUser2 = new SecondaryUser("Mithra", 30, "Mumbai", 9784561235L);


        System.out.println("User Object 1: " + user1);
        System.out.println("User Object 2: " + user2);
        System.out.println("SecondaryUser Object 1: " + secUser1);
        System.out.println("SecondaryUser Object 2: " + secUser2);

        System.out.println("Checking equality:");
        System.out.println("User1.equals(User2) -> " + user1.equals(user2));
        System.out.println("SecondaryUser1.equals(SecondaryUser2) -> " + secUser1.equals(secUser2));
    }
}
