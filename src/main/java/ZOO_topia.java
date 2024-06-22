
import java.util.Scanner;

public class ZOO_topia {
    public static void main(String[] args) {
        System.out.println("Welcome to ZOOtopia!");
        System.out.println(".......................");

        Admin admin = new Admin();
//        Visitors visitor = new Visitors();

        while (true){
            Visitors visitor = new Visitors();
            System.out.println("1. Enter as a Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. Exit the Zoo");
            System.out.println("..................");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your Choice: ");
            int choice  = sc.nextInt();

            if (choice == 1){
                System.out.println("..................");
                System.out.print("Enter Admin Username: ");
                String name = sc.next();
                System.out.print("Enter Admin Password: ");
                String password = sc.next();
                System.out.println("..................");


                boolean login = admin.login(name, password);

                if (login){
                    System.out.println("Logged in as Admin");
                    System.out.println(".......................");
                }
                else {
                    System.out.println("Incorrect Username or Password");
                    System.out.println(".......................");
                    continue;
                }
                int choi;

                while (true) {
                    // Print the menu
                    System.out.println("Admin Menu:");
                    System.out.println("1. Manage Attractions");
                    System.out.println("2. Manage Animals");
                    System.out.println("3. Schedule Events");
                    System.out.println("4. Set Discounts");
                    System.out.println("5. Set Special Deal");
                    System.out.println("6. View Visitor Stats");
                    System.out.println("7. View Feedback");
                    System.out.println("8. Exit");

                    // Get user choice
                    System.out.println(".......................");

                    System.out.print("Enter your choice (1-8): ");
                    choi = sc.nextInt();
                    System.out.println(".......................");
                    // Process user choice
                    if (choi == 1) {
                        // Code to handle "Manage Attractions"
                        while(true){
                            System.out.println("Managing Attractions...");

                            System.out.println("1. Add Attractions");
                            System.out.println("2. View Attractions");
                            System.out.println("3. Modify Attractions");
                            System.out.println("4. Remove Attractions");
                            System.out.println("5. Exit");
                            System.out.println(".......................");

                            int selection;
                            System.out.print("Enter your choice: ");
                            selection = sc.nextInt();
                            System.out.println(".......................");

                            if (selection == 1) {
                                admin.add_attraction();
                            } else if (selection == 2) {
                                admin.view_attraction();
                            } else if (selection == 3) {
                                admin.Modify_attracton();
                            } else if (selection == 4) {
                                admin.remove_attractions();
                            } else if (selection == 5) {
                                System.out.println("return back");
                                System.out.println(".......................");
                                break;
                            }
                        }
                    } else if (choi == 2) {
                        // Code to handle "Manage Animals"
                        while(true){
                            System.out.println("Managing Animals...");

                            System.out.println("1. Add Animals");
                            System.out.println("2. Update animal details");
                            System.out.println("3. Remove animal");
                            System.out.println("4. view animals in the zoo");
                            System.out.println("5. Exit");
                            System.out.println(".......................");

                            int selection;
                            System.out.print("Enter your choice: ");
                            selection = sc.nextInt();
                            System.out.println(".......................");



                            if (selection == 1) {
                                admin.add_animal();
                            } else if (selection == 2) {
                                admin.update_animal_details();
                            } else if (selection == 3) {
                                admin.remove_animal();
                            }else if(selection == 4){
                                admin.view_animal();
                            }else if (selection == 5) {
                                System.out.println("return back");
                                System.out.println(".......................");
                                break;
                            }
                        }
                    } else if (choi == 3) {
                        admin.scheduleEvent();
                    } else if (choi == 4) {
                        // Code to handle "Set Discounts"
                        System.out.println("Set Discounts...");

                        while(true){
                            System.out.println("1. Add Discount");
                            System.out.println("2. Modify Discount");
                            System.out.println("3. Remove Discount");
                            System.out.println("4. view Discount");
                            System.out.println("5. Exit");

                            System.out.println(".......................");
                            System.out.print("Enter your choice: ");
                            int SD_choice = sc.nextInt();
                            System.out.println(".......................");

                            if (SD_choice == 1) {
                                admin.addDiscount();
                                System.out.println("Discount Added successfully");
                            } else if (SD_choice == 2) {
                                admin.ModifyDiscount();
                                System.out.println("Discount Modified successfully");
                            } else if (SD_choice == 3) {
                                admin.removeDiscount();
                                System.out.println("Discount Removed Successfully.");
                            } else if (SD_choice == 4) {
                                admin.view_Discounts();
                            }else{
                                break;
                            }

                        }
                    } else if (choi == 5) {
                        // Code to handle "Set Special Deal"
                        admin.setDeals();
                        System.out.println("Special deals menu");
                        while(true){
                            System.out.println("1. Add special Deals.");
                            System.out.println("2. Remove special deals.");
                            System.out.println("3. View deals.");
                            System.out.println("4. Exit");
                            System.out.println(".......................");
                            System.out.print("Enter your choice: ");
                            int ch = sc.nextInt();
                            System.out.println(".......................");
                            if (ch == 1){
                                System.out.println("Adding Special Deal...");
                                admin.addSpecialDeal();
                                System.out.println(".......................");
                            } else if (ch == 2) {
                                admin.removeSpecialDeal();
                            } else if (ch == 3) {
                                admin.viewDeals();
                            }else{
                                break;
                            }

                        }
                    } else if (choi == 6) {
                        // Code to handle "View Visitor Stats"
                        System.out.println("Viewing Visitor Stats...");

                        System.out.println("Total Visitors: " + admin.getTotalVisitors());
                        System.out.println("Total Revenue: " + admin.getRevenue());
                        admin.findMaxVisitedAttraction();
                        System.out.println(".......................");

                    } else if (choi == 7) {
                        // Code to handle "View Feedback"
                        System.out.println("Viewing Feedback...");
                        admin.viewFeedback();
                    } else if (choi == 8) {
                        System.out.println("Logged Out");
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a number from 1 to 8.");
                    }

                }

            }else if (choice == 2){

                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println(".......................");

                System.out.print("Enter your choice: ");

                int option;
                option = sc.nextInt();
                System.out.println(".......................");

                if (option == 1){
                    visitor.register(admin);
                }

                else if(option == 2){

                    boolean a = admin.LoginMember();
                    if(!a){
                        continue;
                    }
                }
                System.out.println(".......................");
                while (true){
                    System.out.println("Visitor Menu:");
                    System.out.println("1. Explore the Zoo");
                    System.out.println("2. Buy Membership");
                    System.out.println("3. Buy Tickets");
                    System.out.println("4. View Discounts");
                    System.out.println("5. View Special Deals");
                    System.out.println("6. Visit Animals");
                    System.out.println("7. Visit Attractions");
                    System.out.println("8. Leave Feedback");
                    System.out.println("9. Log Out");
                    System.out.println(".......................");

                    System.out.print("Enter your choice: ");
                    int visiter_choice = sc.nextInt();
                    System.out.println(".......................");
                    if (visiter_choice == 1){
                        visitor.exploreZoo(admin);
                    }
                    else if (visiter_choice == 2){

                        visitor.buyMembership(admin);

                    }
                    else if (visiter_choice == 3){
                        visitor.buyTickets(admin);
                    }
                    else if (visiter_choice == 4){
                        System.out.println(".......................");

                        System.out.println("View Discounts....");
                        visitor.viewDiscounts(admin);

                    }
                    else if (visiter_choice == 5){
                        System.out.println(".......................");
                        System.out.println("Special Deals,,");
                        visitor.ViewSpecialDeals(admin);
                        // view deals
                    }
                    else if (visiter_choice == 6){
                        visitor.visitAnimal(admin);
                    }
                    else if (visiter_choice == 7){
                        visitor.visitAttraction(admin);
                    }
                    else if (visiter_choice == 8){
                        visitor.feedback(admin);
                    }
                    else if (visiter_choice == 9){
                        System.out.println("Logged out");
                        break;
                    }
                }
            }else if (choice == 3){
                System.out.println("Exiting the ZOO...");
                break;
            }
        }

    }
}
