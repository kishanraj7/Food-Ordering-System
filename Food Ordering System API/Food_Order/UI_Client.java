package Food_Order;
import Food_Order.Controllers.ResturentController;
import Food_Order.Controllers.UserController;
import Food_Order.Controllers.foodItemController;
import Food_Order.Controllers.orderController;
import Food_Order.Models.FoodItem;
import Food_Order.Models.Order;
import Food_Order.Models.Resturant;
import Food_Order.Models.User;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UI_Client {
    //Calling Controllers
    static UserController userController = new UserController();
    static ResturentController resturentController = new ResturentController();
    static foodItemController foodItemController = new foodItemController();
    static orderController orderController = new orderController();
    static Scanner sc = new Scanner(System.in);
    //Email And User Name Validation
    static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{3,20}$");

    public static void main(String[] args) {
        l1:
        while (true) {
            displayMainMenu();
            int choice=0;
            try {
                choice = sc.nextInt();
                }
            catch (Exception e){
                sc.nextLine();
                System.out.println("Invalid Data Type");
                continue ;
            }
            if (choice == 1) {
                registerMenu();
            } else if (choice == 2) {
                System.out.println("Enter Your User Name: ");
                String uName= sc.next();
                System.out.println("Enter Your PassWord: ");
                String pass= sc.next();
                String log=userController.Login(uName,pass);
                System.out.println(log);
                if(log.equals("Successfully Login As OWNER")||log.equals("Successfully Login")){
                    // Owner Menu
                    if(log.equals("Successfully Login As OWNER")){
                        System.out.println("Welcome To Tomato Restaurant Partner App");
                        l2: while (true){
                            // Some Data Declaration
                            String ownId=null;
                            //Start
                           dispalyOwnerMenu_1();
                           int inp= 0;
                            try {
                                inp = sc.nextInt();
                            }
                            catch (Exception e){
                                sc.nextLine();
                                System.out.println("Invalid Data Type");
                                continue ;
                            }
                           switch (inp){
                               case -1:
                                   System.out.println("Leaving The Program .............");
                                   break l1;
                               case 0:
                                   System.out.println("Moving To Sign Up Page ...........");
                                   break l2;
                               case 1:
                                   System.out.print("Enter Restaurant ID: ");
                                   String resId= sc.next();
                                   System.out.print("Enter Owner ID: ");
                                   ownId= sc.next();
                                   System.out.print("Enter Restaurant Name: ");
                                   sc.nextLine();
                                   String name= sc.nextLine();
                                   System.out.print("Enter Restaurant Location: ");
                                   String loc= sc.nextLine();
                                   System.out.print("Enter Restaurant Phone Number: ");
                                   String pno= sc.next();
                                   validatePhoneNo(pno);
                                   System.out.print("Enter Your Type Of Cuisines: ");
                                   sc.nextLine();
                                   String cus= sc.nextLine();
                                   Resturant resturant=new Resturant(resId,ownId,name,loc,pno,cus);
                                   resturentController.createResturant(resturant);
                                   break ;
                               case 2:
                                   System.out.print("Enter Your Restaurant ID: ");
                                   resId= sc.next();
                                   System.out.print("Enter Restaurant Name: ");
                                   sc.nextLine();
                                   name= sc.nextLine();
                                   System.out.print("Enter Restaurant Location: ");
                                   loc= sc.nextLine();
                                   System.out.print("Enter Restaurant Phone Number: ");
                                   pno= sc.next();
                                   validatePhoneNo(pno);
                                   System.out.print("Enter Your Type Of Cuisines: ");
                                   sc.nextLine();
                                   cus= sc.nextLine();
                                   Resturant resturant1= new Resturant(resId,ownId,name,loc,pno,cus);
                                   resturentController.updateResturant(resId,resturant1);
                                   break ;
                               case 3:
                                   System.out.print("Enter Your Restaurant ID: ");
                                   resId= sc.next();
                                   resturentController.deleteResturant(resId);
                                   break ;
                               case 4:
                                   System.out.println("Loading Your Restaurant Details ..............");
                                   resturentController.getRestroByOwnerId(ownId);
                                   break ;
                               case 5:
                                   l3:while (true){
                                       //Variables
                                       String resid=null;
                                       dispalyOwnerMenu_2();
                                       int input=0;
                                       try {
                                           input = sc.nextInt();
                                       }
                                       catch (Exception e){
                                           sc.nextLine();
                                           System.out.println("Invalid Data Type");
                                           continue ;
                                       }
                                       switch (input){
                                           case -1:
                                               System.out.println("Leaving The Program .............");
                                               break l1;
                                           case 0:
                                               System.out.println("Moving To Sign Up Page ...........");
                                               break l2;
                                           case 1:
                                               System.out.println("Moving To Restaurant Creation page..............");
                                               break l3;
                                           case 2:
                                               System.out.println();
                                               System.out.print("Enter Your Restaurant ID: ");
                                               resid= sc.next();
                                               System.out.print("Enter Dish ID Which You Want To Add To Menu: ");
                                               String dishId= sc.next();
                                               System.out.print("Enter Dish Name Which You Want To Add To Menu: ");
                                               String Iname= sc.next();
                                               System.out.print("Enter A Description For Your Dish: ");
                                               sc.nextLine();
                                               String desc= sc.nextLine();
                                               System.out.print("Enter Price For Your Dish: ");
                                               double price= sc.nextDouble();
                                               boolean available = false;
                                               System.out.println("Press [1] If Item Is Available");
                                               System.out.print("Enter Your Choice: ");
                                               int ch= sc.nextInt();
                                               if(ch==1){
                                                   available=true;
                                               }
                                               else {
                                                   System.out.println("Invalid Input Provided");
                                               }
                                               FoodItem food=new FoodItem(dishId,resid,Iname,desc,price,available);
                                               foodItemController.addItem(resid,food);
                                               break ;
                                           case 3:
                                               System.out.print("Enter Dish ID Which You Want To Update In Menu: ");
                                               dishId=sc.next();
                                               System.out.print("Enter Dish Name Which You Want To Add To Menu: ");
                                               Iname= sc.next();
                                               System.out.print("Enter A Description For Your Dish: ");
                                               sc.nextLine();
                                               desc= sc.nextLine();
                                               System.out.print("Enter Price For Your Dish: ");
                                               price= sc.nextDouble();
                                               available = false;
                                               System.out.println("Press [1] If Item Is Available");
                                               System.out.print("Enter Your Choice: ");
                                               ch= sc.nextInt();
                                               if(ch==1){
                                                   available=true;
                                               }
                                               else {
                                                   System.out.println("Invalid Input Provided");
                                               }
                                               FoodItem foodItem = new FoodItem(dishId,resid,Iname,desc,price,available);
                                               foodItemController.updateItem(dishId,foodItem);
                                               break ;
                                           case 4:
                                               System.out.print("Enter Dish ID Which You Want To Delete From Menu: ");
                                               dishId=sc.next();
                                               foodItemController.deleteItem(dishId);
                                               break ;
                                           case 5:
                                               System.out.print("Enter Your Restaurant ID: ");
                                               resid=sc.next();
                                               System.out.println("Loading Your Menu...................");
                                               System.out.println("\n--------------------------Menu--------------------\n");
                                               foodItemController.loadMenu(resid);
                                               break ;
                                           case 6:
                                               l4:while (true){
                                                   dispalyOwnerMenu_3();
                                                   try {
                                                       input = sc.nextInt();
                                                   }
                                                   catch (Exception e){
                                                       sc.nextLine();
                                                       System.out.println("Invalid Data Type");
                                                       continue ;
                                                   }
                                                   switch (input) {
                                                       case -1:
                                                           System.out.println("Leaving The Program .............");
                                                           break l1;
                                                       case 0:
                                                           System.out.println("Moving To Sign Up Page ...........");
                                                           break l2;
                                                       case 1:
                                                           System.out.println("Moving To Restaurant Creation page..............");
                                                           break l3;
                                                       case 2:
                                                           System.out.println("Moving To Managing Restaurant Page................");
                                                           break l4;
                                                       case 3:
                                                           System.out.print("Enter Your Restaurant ID: ");
                                                           resid=sc.next();
                                                           orderController.viewOrder(resid);
                                                           break ;
                                                       case 4:
                                                           System.out.print("Enter Order ID: ");
                                                           String oid=sc.next();
                                                           String status="PENDING";
                                                           System.out.println("Press [1] If Started Preparing The Order");
                                                           System.out.println("Press [2] If Order Is Prepared Successfully");
                                                           System.out.print("Enter Your Choice: ");
                                                           ch= sc.nextInt();
                                                           if(ch==1){
                                                               status="IN_PROGRESS";
                                                           } else if (ch==2) {
                                                               status="COMPLETED";
                                                           }else {
                                                               System.out.println("Invalid Input");
                                                           }
                                                           orderController.updateOrderStatus(oid,status);
                                                           break ;
                                                           // l4
                                                       default:
                                                           System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                                                           break ;
                                                   }
                                               }
                                               // l3
                                           default:
                                               System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                                               break ;
                                       }
                                   }
                                   //l2
                               default:
                                   System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                                   break ;
                           }
                        }
                    }


                    //User Menu
                    else {
                        l5:while (true){
                            dispalyUserMenu();
                            int option=0;
                            try {
                                option = sc.nextInt();
                            }
                            catch (Exception e){
                                sc.nextLine();
                                System.out.println("Invalid Data Type");
                                continue ;
                            }
                            switch (option){
                                case -1:
                                    System.out.println("Leaving The Program .............");
                                    break l1;
                                case 0:
                                    System.out.println("Moving To Sign Up Page ...........");
                                    break l5;
                                case 1:
                                    System.out.print("Enter Restaurant ID Whose Menu you Want To See: ");
                                    String ResId= sc.next();
                                    foodItemController.loadMenu(ResId);
                                    break ;
                                case 2:
                                    System.out.println();
                                    System.out.print("Enter Your Order ID: ");
                                    String oid= sc.next();
                                    System.out.print("Enter Your ID: ");
                                    String cusId= sc.next();
                                    System.out.print("Enter Restaurant ID: ");
                                    ResId = sc.next();
                                    System.out.print("Enter Number Of Items For Which You Want To Place Order: ");
                                    int n= sc.nextInt();
                                    ArrayList<FoodItem> foodItems = new ArrayList<>();
                                    for (int i=0;i<n;i++){
                                        System.out.print("Enter Dish Name: ");
                                        sc.nextLine();
                                        String f= sc.nextLine();
                                        System.out.print("Enter Dish Price: ");
                                        double dishPrice = sc.nextDouble();
                                        foodItems.add(new FoodItem(f,dishPrice));
                                    }
                                    Order ord = new Order(oid,cusId,ResId,foodItems);
                                    orderController.place_Order(ord);
                                    break ;
                                case 3:
                                    System.out.print("Enter Your ID");
                                    cusId= sc.next();
                                    orderController.checkStatus(cusId);
                                    break ;
                                default:
                                    System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                            }
                        }
                    }
                }

            } else if (choice == 3) {
               viewProfile();
            } else {
                System.out.println("Leaving The Program ..............");
                break l1;
            }
        }

    }

    //Methods
    static void displayMainMenu() {
        System.out.println("Press [1] To Register");
        System.out.println("Press [2] To Login");
        System.out.println("Press [3] To View Your Profile");
        System.out.println("Press [0] To Exit The Program");
        System.out.print("Enter Your Choice : ");
        System.out.println();
    }
    static void registerMenu() {
        System.out.println("Enter Your Email Address: ");
        String email = sc.next();
        validateEmail(email);
        System.out.print("Enter Your User Name: ");
        String uName = sc.next();
        validateUserName(uName);
        System.out.print("Enter Your PassWord: ");
        String pass = sc.next();
        System.out.print("Enter Your Role: ");
        String role = sc.next();
        System.out.print("Enter Your ID: ");
        String id = sc.next();
        User u = new User(email, uName, pass, role, id);
        userController.Register(u);
        System.out.println();
    }
    static void dispalyUserMenu(){
        System.out.println();
        System.out.println("Press [-1] For Leaving The Program");
        System.out.println("Press [0] For Logging Out Of Tomato App");
        System.out.println("Press [1] For Loading Menu Of Desired Restaurant");
        System.out.println("Press [2] For Placing An Order");
        System.out.println("Press [3] For Checking Your Order Status");
        System.out.print("Enter Your Choice: ");
    }
    static void dispalyOwnerMenu_1(){
        System.out.println();
        System.out.println("Press [-1] For Leaving The Program");
        System.out.println("Press [0] For Logging Out Of Tomato Partner App");
        System.out.println("Press [1] For Creating Restaurant");
        System.out.println("Press [2] For Updating Restaurant Information");
        System.out.println("Press [3] For Deleting Your Restaurant");
        System.out.println("Press [4] For Viewing Your Restaurant Details On Tomato");
        System.out.println("Press [5] For Moving To Managing Restaurant Page");
        System.out.print("Enter Your Choice: ");
    }
    static void dispalyOwnerMenu_2(){
        System.out.println();
        System.out.println("Press [-1] For Leaving The Program");
        System.out.println("Press [0] For Logging Out Of Tomato Partner App");
        System.out.println("Press [1] For Moving To Restaurant Creation Page");
        System.out.println("Press [2] For Adding An Item To Your Restaurant Menu");
        System.out.println("Press [3] For Updating An Item From Your Restaurant Menu");
        System.out.println("Press [4] For Deleting An Item From Your Restaurant Menu");
        System.out.println("Press [5] For Viewing Your Restaurant Menu");
        System.out.println("Press [6] For Moving To Orders Page");
        System.out.print("Enter Your Choice: ");
    }
    static void dispalyOwnerMenu_3(){
        System.out.println();
        System.out.println("Press [-1] For Leaving The Program");
        System.out.println("Press [0] For Logging Out Of Tomato Partner App");
        System.out.println("Press [1] For Moving To Restaurant Creation Page");
        System.out.println("Press [2] For Moving To Managing Restaurant Page");
        System.out.println("Press [3] For Viewing Orders For Your Restaurant");
        System.out.println("Press [4] For Updating Order Status");
        System.out.print("Enter Your Choice: ");
    }
    static void validatePhoneNo(String phone) {
        while (true) {
            boolean validLenght = phone.length() == 10;
            boolean hasDigit = true;
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    hasDigit = false;
                }
            }
            if (validLenght && hasDigit) {
                break;
            } else {
                System.out.println("Invalid Phone Number Please Enter A Correct Phone Number. ");
                System.out.println();
                System.out.print("Re Enter Your Phone Number : ");
                phone = sc.next();
            }
        }
    }
    static String validateEmail(String email) {
        while (true) {
            Matcher matcher = EMAIL_PATTERN.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                System.out.println("Invalid Email Address. Please enter a correct email address.");
                System.out.print("Re-enter your email address: ");
                email = sc.next();
            }
        }
    }
    static void viewProfile() {
        System.out.print("Enter Your ID: ");
        String id = sc.next();
        userController.getProfile(id);
    }

    static String validateUserName(String username) {
        while (true) {
            Matcher matcher = USERNAME_PATTERN.matcher(username);
            if (matcher.matches()) {
                return username;
            } else {
                System.out.println("Invalid Username. Please enter a correct username.");
                System.out.print("Re-enter your username: ");
                username = sc.next();
            }
        }
    }
}
