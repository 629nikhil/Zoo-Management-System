import java.util.ArrayList;
import java.util.Scanner;

abstract class visi{
    public void register(Admin a){;}
    public void exploreZoo(Admin a){;}

    public void ViewSpecialDeals(Admin a){;}

}

public class Visitors extends visi {
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;

    private String memmberShip;

    private double code = 0.0;
    private ArrayList<Attraction> attTickets = new ArrayList<>();

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public void register(Admin a){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Visitor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Visitor Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character left in the input buffer

        System.out.print("Enter Visitor Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter Visitor Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine(); // Consume the newline character left in the input buffer

        System.out.print("Enter Visitor Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Visitor Password: ");
        String password = sc.nextLine();

        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;

        a.getRegistered().add(this);
        System.out.println(".....................");

        System.out.println("Registration is successful.");
    }

    public String getMemmberShip() {
        return memmberShip;
    }

    public void setMemmberShip(String memmberShip) {
        this.memmberShip = memmberShip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    // Password validation can be added here.
    public boolean isPasswordValid(String inputPassword) {
        return password.equals(inputPassword);
    }

    public boolean login(String email, String providedPassword) {
        if (this.email.equals(email) && isPasswordValid(providedPassword)) {
            return true; // Successful login
        }
        return false; // Login failed
    }

    public void exploreZoo(Admin a) {


        ArrayList<Attraction> attractions = a.getAttractions();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Explore the Zoo:");
            System.out.println("1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");
            System.out.println(".....................");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            System.out.println(".....................");
            switch (choice) {
                case 1:
                    if (attractions.isEmpty()){
                        System.out.println("NO attraction present...");
                        break;
                    }
                    System.out.println("Attractions in the Zoo:");
                    for (int i = 0; i < attractions.size(); i++) {
                        System.out.println((i + 1) + ". " + attractions.get(i).getAttraction_name());
                    }
                    System.out.println(".....................");

                    System.out.print("Enter your choice: ");
                    int attractionChoice = scanner.nextInt();
                    System.out.println(".....................");
                    if (attractionChoice >= 1 && attractionChoice <= attractions.size()) {
                        System.out.println("ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!");
                    } else {
                        System.out.println("Invalid attraction choice.");
                    }
                    System.out.println(".....................");
                    break;

                case 2:
                    if (a.getZoo_animal().isEmpty()){
                        System.out.println("NO animal present in the zoo...");
                    }
                    // Implement viewing animals here
                    System.out.println("Animals in the ZOOtopia");

                    for(Animal animal : a.getZoo_animal()){
                        animal.print();
                    }
                    System.out.println(".....................");
                    break;

                case 3:
                    System.out.println("return back");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    public void buyMembership(Admin a) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a membership type:");
        System.out.println("1. Basic for Rs 20");
        System.out.println("2. Premium for Rs 50");
        System.out.println(".......................");
        System.out.print("Enter the number for your choice: ");

        int choice = scanner.nextInt();
        double membershipPrice = 0.0;
        System.out.println(".......................");
        if (choice == 1) {
            membershipPrice = 20.0;
            this.setMemmberShip("Basic");
        } else if (choice == 2) {
            membershipPrice = 50.0;
            this.setMemmberShip("Premium");
        } else {
            System.out.println("Invalid choice. No membership purchased.");
            return;
        }

        // Apply discounts and special deals here if needed
        if (this.getAge() < 18) { // Minor
            membershipPrice -= membershipPrice * 0.10; // Apply a 10% discount for minors
        } else if (this.getAge() > 60) {
            membershipPrice -= membershipPrice * 0.20; // Apply a 20% discount for seniors
        }
        System.out.println(".......................");
        System.out.print("Apply Coupon Code: ");
        String code = scanner.next();
        System.out.println(".......................");

        this.applyCode(code, a);

        double total = membershipPrice*(1 - this.code);
        a.setRevenue(a.getRevenue() + total);

        // Update the visitor's balance
        if (balance >= membershipPrice) {
            this.balance = this.balance -  membershipPrice*(1 - this.code);
            System.out.println("Membership purchased successfully.");
            System.out.print("Your Balance is now: ");
            System.out.println(this.balance);

        } else {
            System.out.println("Insufficient balance. Membership not purchased.");
            this.setMemmberShip("");
        }
        System.out.println(".......................");
    }

    public void buyTickets(Admin a) {
        if (this.getMemmberShip() == null) {
            System.out.println("Buy a membership first...");
            return;
        }

        if (this.getMemmberShip().equals("Premium")) {
            attTickets = a.getAttractions();
            System.out.println("You have free access to all the attractions");
            return;
        } else if (this.getMemmberShip().equals("Basic")) {
            ArrayList<Attraction> attractions = a.getAttractions();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Buy Tickets:");
            System.out.println(".......................");
            System.out.print("Enter the number of tickets to buy: ");
            int totalTicket = scanner.nextInt();
            System.out.println(".......................");

            System.out.println("Buy Tickets:");
            System.out.println("Select an Attraction to buy Ticket:");
            for (int i = 0; i < attractions.size(); i++) {
                System.out.println((i + 1) + ". " + attractions.get(i).getAttraction_name() + " (Rs" + attractions.get(i).getTicketPrice() + ")");
            }
            System.out.println(".......................");
            System.out.print("Enter the attraction you want to visit: ");
            int attractionChoice = scanner.nextInt();
            System.out.println(".......................");

            SpecialDeals deal = null;
            double percentage;

            if (a.getDeals().isEmpty()) {
                System.out.println("No deal present...");
                percentage = 1; // Default to no discount when no deals are available
            } else {
                for (SpecialDeals dea : a.getDeals()) {
                    if (totalTicket % dea.getMinTickets() == 0) {
                        deal = dea;
                        break;
                    }
                }

                if (deal != null) {
                    percentage = deal.getDiscountPercentage() * 0.01;
                } else {
                    percentage = 1; // Default to no discount when no suitable deal is found
                }
            }

            if (attractionChoice >= 1 && attractionChoice <= attractions.size()) {
                double ticketPrice = attractions.get(attractionChoice - 1).getTicketPrice();
                double totalTicketPrice = totalTicket * ticketPrice;

                totalTicketPrice -= totalTicketPrice * percentage;


                System.out.print("Apply Coupon Code: ");
                String code = scanner.next();

                this.applyCode(code, a);

                double discount = totalTicketPrice * this.code;
                double total = totalTicketPrice - discount;

                // Update the visitor's balance
                if (balance >= total) {
                    balance -= total;
                    System.out.println("Tickets purchased successfully. Your balance is now " + balance);
                    a.setRevenue(a.getRevenue() + total);
                    attTickets.add(attractions.get(attractionChoice - 1));
                } else {
                    System.out.println("Insufficient balance. Tickets not purchased. Your balance is now " + balance);
                }
            } else {
                System.out.println("Invalid attraction choice.");
            }
        } else {
            System.out.println("Buy one membership first...");
        }
        System.out.println(".......................");
    }


    public void viewDiscounts(Admin a) {
        System.out.println(".......................");



//        Admin a = new Admin();
        ArrayList<Discount> discounts = a.getDiscounts();

        if(discounts.isEmpty()){
            System.out.println("NO discounts available...");
            return;
        }

        System.out.println("View Discounts:");
        for (int i = 0; i < discounts.size(); i++) {
            Discount discount = discounts.get(i);
            System.out.println((i + 1) +". " + discount.getCategory() + "("+discount.getDiscountPercentage()+"% discount - "+ discount.getDiscountCode()+")" );
        }
        System.out.println(".......................");
    }

    public void applyCode(String cod, Admin a){
        if (cod.equals("None")){
            return;
        }

//        Admin a = new Admin();
        ArrayList<Discount> discounts = a.getDiscounts();

        for (Discount discount : discounts){
            if(discount.getDiscountCode().equals(cod)){
                setCode(discount.getDiscountPercentage()*0.01);
                return;
            }
        }
    }

    public void ViewSpecialDeals(Admin a){
        ArrayList<SpecialDeals> deals = a.getDeals();

        for(int i = 0; i < deals.size(); i++){
            System.out.println((i+1) + ". Buy " + deals.get(i).getMinTickets() + " tickets and get " + deals.get(i).getDiscountPercentage() + "% off");
        }
        System.out.println(".......................");
    }

    public void visitAttraction(Admin a) {
        if (this.getMemmberShip() == null) {
            System.out.println("Buy a membership first...");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Visit Attractions:");

        ArrayList<Attraction> attractions = a.getAttractions();

        if (attractions.isEmpty()) {
            System.out.println("No attractions are currently available.");
            return;
        }

        System.out.println("Select an Attraction to visit:");

        for (int i = 0; i < attractions.size(); i++) {
            System.out.println((i + 1) + ". " + attractions.get(i).getAttraction_name());
        }
        System.out.println(".......................");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        System.out.println(".......................");

        if (choice < 1 || choice > attractions.size()) {
            System.out.println("Invalid choice...");
            return;
        }

        Attraction chosenAttraction = attractions.get(choice - 1);

        if (chosenAttraction.getStatus().equals("open")) {
            if (this.memmberShip.equals("Premium")) {
                System.out.println("Thank you for visiting " + chosenAttraction.getAttraction_name() + ". Hope you enjoyed the attraction.");
                a.VisitedAttraction.add(chosenAttraction);
                a.setTotalVisitors(a.getTotalVisitors()+1);
            } else if (this.memmberShip.equals("Basic")) {
                if (attTickets.contains(chosenAttraction)) {
                    System.out.println("Ticket Used.");
                    System.out.println("Thank you for visiting " + chosenAttraction.getAttraction_name() + ". Hope you enjoyed the attraction.");
                    attTickets.remove(chosenAttraction);
                    a.VisitedAttraction.add(chosenAttraction);
                    a.setTotalVisitors(a.getTotalVisitors()+1);
                } else {
                    System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                }
            }
        } else {
            System.out.println("Attraction is not yet open. Please visit later.");
        }

        System.out.println(".......................");
    }


    public void visitAnimal(Admin a){
        if(this.getMemmberShip() == null){
            System.out.println("Buy the membership first...");
        }
        else if (this.getMemmberShip().equals("Basic") || this.getMemmberShip().equals("Premium")){
            Scanner sc = new Scanner(System.in);
            ArrayList<Animal> availableAnimal = a.getZoo_animal();

//        int  count = availableAnimal.size();
            for(int i = 0; i < availableAnimal.size(); i++){
                System.out.println((i+1) + ". "+ availableAnimal.get(i).getAnimal_name());
            }
            System.out.println(".......................");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println(".......................");

            if (choice >= availableAnimal.size() && choice <= 0){
                System.out.println("Invalid choice...");

            }

            else {
                System.out.println(availableAnimal.get(choice-1).getAnimal_name() + " Visted.");
                System.out.println(".......................");
                System.out.print("Do you want to feed? (yes/no) : ");
                String str = sc.next();
                System.out.println(".......................");

                a.setTotalVisitors(a.getTotalVisitors() + 1);

                if(str.equals("yes")){
                    System.out.print(availableAnimal.get(choice).getAnimal_name()+" voice: ");
                    System.out.println(availableAnimal.get(choice).getSound()+ "..........");

                    System.out.println("Description: ");
                    System.out.println(availableAnimal.get(choice).getDescription());
                }


            }
        }
        else {
            System.out.println("Membership not valid...");
        }
        System.out.println(".......................");

    }

    public void feedback(Admin a){
        Scanner sc = new Scanner(System.in);
        System.out.println(".......................");
        System.out.print("Enter your Feedback(Maximum 200 characters): ");
        String feed_back = sc.next();
        System.out.println(".......................");

        a.addfeedback(feed_back);

    }




}
