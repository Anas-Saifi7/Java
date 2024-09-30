//import javax.net.ssl.KeyManagerFactorySpi;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

     class Room{
         private int roomNumber;
         private String roomType;
         private double price;
         
         private boolean isAvailable;

         //  using the constructor
         public  Room(int roomNumber, String roomType, double price, boolean isAvailable ){
             this.roomNumber = roomNumber;
             this.roomType = roomType;
             this.price = price;
             this.isAvailable = isAvailable;
         }
 // using Getters
         public int getRoomNumber() {
             return roomNumber;
         }

         public String getRoomType() {
             return roomType;
         }

         public double getPrice() {
             return price;
         }

         public boolean isAvailable() {
             return isAvailable;
         }
//         public void setAvailable(boolean available){
//             isAvailable = available;
//         }
         @Override
          public String toString(){
             return "Room Number:" + roomNumber + "Room Type:" + roomType + "Price $" + price + "Available" + isAvailable;
          }
     }

     class Reservation{
         private User user;
         private Room room;
         private String checkInDate;
         private String checkOutDate;

         //  using constructor

         public Reservation(User user,Room room, String checkInDate,String checkOutDate) {
             this.user = user;
             this.room = room;
             this.checkInDate = checkInDate;
             this.checkOutDate = checkOutDate;
//              room.setAvailable(false);
         }
         @Override
         public String toString(){
             return "Reservation Details: \n User:" + user.getName() + "\nRoom :" + room.getRoomNumber() + "(" +
                     room.getRoomType() +") \n CheckIn:" + checkInDate + "\n CheckOut:" + checkOutDate;
         }
     }

     class Payment{
         public static boolean processPayment(User user, double amount){
             System.out.println("Processing payment of $" + amount + "for user :" + user.getName());
             return true;
         }
     }

     class User{
         private String name;
         private String email;
// using Constructoranas
         
         public User(String name, String email) {
          this.name = name;
          this.email = email;
         }
// using Getters
         public String getName() {
             return name;
         }

         public String getEmail() {
             return email;
         }
     }
     public class HotelReservation{
         private List<Room> rooms = new ArrayList<>();
         private List<Reservation> reservations = new ArrayList<>();

         private Scanner sc = new Scanner(System.in);
         public HotelReservation(){
             rooms.add(new Room(101, "Single", 100, true));
             rooms.add(new Room(102, "Double", 150, true));
             rooms.add(new Room(103, "Suite", 300, true));
         }
         public void searchRooms(){
             System.out.println("Available Rooms: ");
             for(Room room : rooms){
                 if(room.isAvailable()){
                     System.out.println(room);
                 }
             }
         }

    public void makeReservation(User user) {
         searchRooms();
         System.out.print("Enter room Number to reserve : ");
         int roomNumber = sc.nextInt();
         Room selectedRoom = null;
         for(Room room : rooms){
             if(room.getRoomNumber() == roomNumber && room.isAvailable()){
                 selectedRoom = room;
                 break;
             }
         }
         if(selectedRoom == null){
             System.out.println("Room not available. Try again.");
             return ;
         }

         System.out.println("Enter check-in date(yyyy-mm-dd): ");
         String checkInDate = sc.next();

        System.out.println("Enter check-out date(yyyy-mm-dd): ");
        String checkOutDate = sc.next();

         if(Payment.processPayment(user,selectedRoom.getPrice())){
             Reservation reservation = new Reservation(user,selectedRoom, checkInDate, checkOutDate );
             reservations.add(reservation);

             System.out.println("Reservation successful !");

             System.out.println("reservation");
         }
         else{
             System.out.println("Payment failed. Try again.");
         }
    }

     public void viewReservation(User user){
         System.out.println("Your Reservations : ");
         for(Reservation reservation : reservations){
             if(reservation.toString().contains(user.getName())){
                 System.out.println(reservation);
             }
         }
     }
    public static void main(String[] args) {
      HotelReservation system = new  HotelReservation();
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter your name :");
      String name = sc.nextLine();

      System.out.print("Enter your Email :");
      String email = sc.nextLine();

      User user = new User(name, email);
      while(true){
          System.out.println("\n Hotel Reservation System");

          System.out.println("1. Search available rooms");
          System.out.println("2. Make a Reservation");
          System.out.println("3. View your Reservation");
          System.out.println("4. Exit");

          System.out.println("Choose an Option: ");

          int choice = sc.nextInt();
          switch(choice){
              case 1:
                  system.searchRooms();
                  break;

              case 2:
                  system.makeReservation(user);
                  break;

              case 3:
                  system.viewReservation(user);
                  break;
              case 4:
                  System.out.println("Exiting the system");
                  return;

              default:
                  System.out.println("Invalid choice Please try again.");
          }
      }
    }
}