
import java.util.ArrayList;
import java.util.Scanner;

interface manage_attraction{
    void add_attraction();
    void remove_attractions();

    void view_attraction();

    void Modify_attracton();
}

interface manageA{
    void add_animal();
    void remove_animal();
    void view_animal();

    void update_animal_details();
}

class manage_animal implements manageA{
    public int getMammal() {
        return this.mammal;
    }
    public void setMammal(int mammal) {
        this.mammal = mammal;
    }

    public int getReptiles() {
        return this.reptiles;
    }

    public void setReptiles(int reptiles) {
        this.reptiles = reptiles;
    }

    public int getAmbhibians() {
        return this.ambhibians;
    }

    public void setAmbhibians(int ambhibians) {
        this.ambhibians = ambhibians;
    }
    private int mammal = 0;
    private int reptiles = 0;
    private int ambhibians = 0;

    private ArrayList<Animal> zoo_animal = new ArrayList<>();
    public ArrayList<Animal> getZoo_animal() {
        return zoo_animal;
    }

    public void setZoo_animal(ArrayList<Animal> zoo_animal) {
        this.zoo_animal = zoo_animal;
    }

    public void update_animal_details() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Update animal from ZOO.");

        // Display the list of animals
        System.out.println("List of Animals:");
        for (int i = 0; i < zoo_animal.size(); i++) {
            System.out.println((i + 1) + ". " + zoo_animal.get(i).getAnimal_name());
        }
        System.out.println(".......................");

        System.out.print("Enter the number of the animal to update: ");
        int animalNumber = sc.nextInt();

        // Check if the input is within a valid range
        if (animalNumber >= 1 && animalNumber <= zoo_animal.size()) {
            Animal animalToUpdate = zoo_animal.get(animalNumber - 1);

            System.out.println("What do you want to update?");
            System.out.println("1. Update Name");
            System.out.println("2. Update Type");
            System.out.print("Enter your choice: ");
            int select = sc.nextInt();

            if (select == 1) {
                System.out.print("Enter the new name: ");
                String new_name = sc.next();
                animalToUpdate.setAnimal_name(new_name);
                System.out.println("Animal's name updated in the ZOO.");
            } else if (select == 2) {
                System.out.print("Enter the new Type: ");
                String new_Type = sc.next();
                animalToUpdate.setAnimal_type(new_Type);
                System.out.println("Animal's type updated in the ZOO.");
            } else {
                System.out.println("Invalid input...");
            }
        } else {
            System.out.println("Invalid choice. Cannot update the animal.");
        }
        System.out.println(".......................");
    }

    public void remove_animal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Remove animal from ZOO.");

        // Display the list of animals
        System.out.println("List of Animals:");
        for (int i = 0; i < zoo_animal.size(); i++) {
            System.out.println((i + 1) + ". " + zoo_animal.get(i).getAnimal_name());
        }
        System.out.println(".......................");

        System.out.print("Enter the number of the animal to remove: ");
        int animalNumber = sc.nextInt();
        System.out.println("..................");

        // Check if the input is within a valid range
        if (animalNumber >= 1 && animalNumber <= zoo_animal.size()) {
            Animal animalToRemove = zoo_animal.get(animalNumber - 1);
            zoo_animal.remove(animalToRemove);
            System.out.println("Animal removed from the zoo.");
        } else {
            System.out.println("Invalid choice. Cannot remove the animal.");
        }
    }
    public void view_animal(){
        if(zoo_animal.isEmpty()){
            System.out.println("No animal present in the ZOO...");
        }
        else {
            for (Animal animal : zoo_animal) {
                animal.print();
                System.out.println(".......................");
            }
        }
        System.out.println("Total number of animal of Mammal type is: " + this.getMammal() );
        System.out.println("Total number of animal of Reptiles type is: " + this.getReptiles());
        System.out.println("Total number of animal of Amphibians type is: " + this.getAmbhibians());
        System.out.println(".......................");
    }

    public void setCount(){
        this.setMammal(0);
        this.setReptiles(0);
        this.setAmbhibians(0);

        for (Animal animal : zoo_animal) {
            if (animal.getAnimal_type().equals("Mammals")) {
                this.setMammal(this.getMammal() + 1);
            } else if (animal.getAnimal_type().equals("Reptiles")) {
                this.setReptiles(this.getReptiles() + 1);
            } else if (animal.getAnimal_type().equals("Amphibians")) {
                this.setAmbhibians(this.getAmbhibians() + 1);
            }
        }
    }

    public void add_animal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Add animal to ZOO.");


        while(true){
            System.out.print("Enter the type of the animal: ");
            String animalType = sc.next();

            System.out.print("Enter the name of the animal: ");
            String firstAnimalName = sc.next();

            Animal animal = new Animal(animalType, firstAnimalName);
            animal.set_animal(animalType);

            zoo_animal.add(animal);


            this.setCount();
            int a = this.getMammal();

            int b = this.getAmbhibians();
            int c = this.getReptiles();

//            System.out.println( a +" "+ b +" "+c);

            if (zoo_animal.size() >= 6) {
                if ((this.getMammal() >= 2) &&
                        ( this.getAmbhibians() >= 2) &&
                        ( this.getReptiles() >= 2)) {
                    break;
                }
                System.out.println(".......................");


                System.out.println("Atleast, Two Animals should be present of the same type");

            }

        }
        System.out.println(".......................");
    }
}
public class Admin extends manage_animal implements manage_attraction {

    private ArrayList<Visitors> visitor = new ArrayList<>();
    private ArrayList<Visitors> registered = new ArrayList<>();

    public ArrayList<Visitors> getRegistered() {
        return registered;
    }

    public void setRegistered(ArrayList<Visitors> registered) {
        this.registered = registered;
    }

    public boolean LoginMember(){
        Admin a = this;
        Scanner sc = new Scanner(System.in);

//        for (Visitors visit : a.registered){
//            System.out.println(visit.getName()+ " "+ visit.getPassword());
//        }

        System.out.print("Enter username: ");
        String name = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        for (Visitors visit : a.registered){

            if(visit.getEmail().equals(name) && visit.getPassword().equals(pass)){
                System.out.println("Logged in Successfully");
                return true;
            }
        }
        System.out.println("Incorrect Username or password...");
        return false;
    }

    public ArrayList<Visitors> getVisitor() {
        return visitor;
    }

    public void setVisitor(ArrayList<Visitors> visitor) {
        this.visitor = visitor;
    }

    private ArrayList<String> feedback = new ArrayList<>();
    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    public void addfeedback(String feed_back){
        feedback.add(feed_back);
    }

    public void viewFeedback(){
        if(this.feedback.isEmpty()){
            System.out.println("No any feedback...");
        }
        int count = 1;
        for(String feedback : feedback){
            System.out.println(count + ". " + feedback);
            count++;
        }
        System.out.println(".......................");
    }

    private double revenue = 0.0;

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getRevenue() {
        return revenue;
    }

    ArrayList<Attraction> VisitedAttraction = new ArrayList<>();

    public void findMaxVisitedAttraction() {

        ArrayList<Attraction> visitedAttraction = this.getVisitedAttraction();

        if (visitedAttraction.isEmpty()) {
            System.out.println("No visitor has arrived yet");
            return; // Return null if the list is empty
        }

        Attraction maxVisitedAttraction = visitedAttraction.get(0);
        int maxVisitCount = 1; // Initialize with the count of the first attraction

        for (int i = 0; i < visitedAttraction.size(); i++) {
            Attraction currentAttraction = visitedAttraction.get(i);
            int currentVisitCount = 1;

            for (int j = i + 1; j < visitedAttraction.size(); j++) {
                if (currentAttraction.equals(visitedAttraction.get(j))) {
                    currentVisitCount++;
                }
            }

            if (currentVisitCount > maxVisitCount) {
                maxVisitCount = currentVisitCount;
                maxVisitedAttraction = currentAttraction;
            }
        }

        System.out.print("Most Popular Attraction: ");

        System.out.println(maxVisitedAttraction.getAttraction_name());
    }

    public ArrayList<Attraction> getVisitedAttraction() {
        return VisitedAttraction;
    }

    public void setVisitedAttraction(ArrayList<Attraction> visitedAttraction) {
        VisitedAttraction = visitedAttraction;
    }

    private int totalVisitors = 0;

    public int getTotalVisitors() {
        return totalVisitors;
    }

    public void setTotalVisitors(int totalVisitors) {
        this.totalVisitors = totalVisitors;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }

    public ArrayList<SpecialDeals> getDeals() {
        return deals;
    }

    public void setDeals(ArrayList<SpecialDeals> deals) {
        this.deals = deals;
    }

    private ArrayList<Discount> discounts = new ArrayList<>();

    private ArrayList<SpecialDeals> deals = new ArrayList<>();

    private final String user = "Nikhil";

    private final String password = "123";
    private ArrayList<Attraction> attractions = new ArrayList<>();

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public boolean login(String username, String Password){
        if (username.equals(this.getUser()) && Password.equals(this.getPassword())){
            System.out.println("Logged in successfully");
            return true;
        }
        return false;

    }

    public void view_Discounts(){
        ArrayList<Discount> discounts = this.getDiscounts();

        if(discounts.isEmpty()){
            System.out.println("NO discounts available...");
            return;
        }

        System.out.println("View Discounts:");
        for (int i = 0; i < discounts.size(); i++) {
            Discount discount = discounts.get(i);
            System.out.println((i + 1) +". " + discount.getCategory() + "("+discount.getDiscountPercentage()+"% discount - "+ discount.getDiscountCode() + ")");
        }
        System.out.println(".......................");
    }
    @Override
    public void add_attraction() {
        Scanner sc = new Scanner(System.in);
        Attraction attraction = new Attraction();

        System.out.print("Enter the Attraction name: ");
        String Att_name = sc.nextLine();
        attraction.setAttraction_name(Att_name);

        System.out.print("Enter the Attraction Description: ");
        String Att_Description = sc.nextLine();
        attraction.setDescription(Att_Description);

        System.out.print("Enter the Attraction Price: ");
        double Att_Price = sc.nextDouble();
        attraction.setTicketPrice(Att_Price);

        System.out.println(".......................");

        // Generate a new unique ID for the attraction
        int newAttractionID = generateNewAttractionID();
        attraction.setAttraction_id(newAttractionID);

        // Check for duplicate attractions by name
        if (isAttractionNameUnique(Att_name)) {
            this.attractions.add(attraction);
            System.out.println("Attraction added successfully...");
        } else {
            System.out.println("Attraction with the same name already exists.");

        }
        System.out.println(".......................");
    }

    // Generate a new unique attraction ID
    private int generateNewAttractionID() {
        // You can implement this method to generate a unique ID based on the existing attractions.
        // For example, you can find the maximum ID and increment it.
        int maxID = 0;
        for (Attraction existingAttraction : attractions) {
            if (existingAttraction.getAttraction_id() > maxID) {
                maxID = existingAttraction.getAttraction_id();
            }
        }
        return maxID + 1;
    }

    // Check if the attraction name is unique
    private boolean isAttractionNameUnique(String attractionName) {
        for (Attraction existingAttraction : attractions) {
            if (existingAttraction.getAttraction_name().equals(attractionName)) {
                return false; // Name is not unique
            }
        }
        return true; // Name is unique
    }

    @Override
    public void remove_attractions() {
        Scanner sc  = new Scanner(System.in);
        Attraction attraction = new Attraction();

        if (attractions.isEmpty()){
            System.out.println("Not any attraction present...");
            return;
        }

        System.out.println("..................");

        System.out.print("Enter the Attraction name: ");
        String attractionName = sc.next();
        System.out.println("..................");

        Attraction existingAttraction = null;

        for (Attraction att : attractions) {
            if (att.getAttraction_name().equals(attractionName)) {
                existingAttraction = att;
                break;
            }
        }

        if(existingAttraction != null){
            this.attractions.remove(existingAttraction);
            System.out.println("Attraction removed successfully...");
        }
        else{
            System.out.println("Attraction not exist in the zooTopia");
        }
        System.out.println("..................");

    }

    public void view_attraction() {
        Scanner sc  = new Scanner(System.in);

        if (attractions.isEmpty()){
            System.out.println("Not any attraction present...");
            return;
        }

        for(Attraction attraction : attractions){
            System.out.print("Attraction name: ");
            System.out.println(attraction.getAttraction_name());

            System.out.print("Attraction ID: ");
            System.out.println(attraction.getAttraction_id());

            System.out.print("Attraction Description : ");
            System.out.println(attraction.getDescription());

            System.out.print("Attraction Price : ");
            System.out.println(attraction.getTicketPrice());
            System.out.println("..................");

        }

    }

    public void Modify_attracton() {
        Scanner sc = new Scanner(System.in);

        if (attractions.isEmpty()){
            System.out.println("Not any attraction present...");
            return;
        }

        System.out.println("Select the attraction you want to Modify: ");
        for (int i = 0; i < attractions.size(); i++) {
            System.out.println((i + 1) + ". " + attractions.get(i).getAttraction_name());
        }
        System.out.println(".......................");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.println(".......................");


        System.out.println("What do you want to Modify? ");
        System.out.println("1. Name");
        System.out.println("2. Description");
        System.out.println("3. Price");
        System.out.println(".......................");
        System.out.print("Enter your choice: ");
        int select = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println(".......................");


        if (select == 1) {
            System.out.print("Enter the New Name: ");
            String name = sc.nextLine();
            attractions.get(choice - 1).setAttraction_name(name);
        } else if (select == 2) {
            System.out.print("Enter the New Description: ");
            String des = sc.nextLine();
            attractions.get(choice - 1).setDescription(des);
        } else if (select == 3) {
            System.out.print("Enter the New Price: ");
            double price = sc.nextDouble();
            attractions.get(choice - 1).setTicketPrice(price);
        } else {
            System.out.println("Invalid choice...");
        }
        System.out.println(".......................");

        System.out.println("Attraction Modified Successfully.");
        System.out.println(".......................");

    }

    public void add_animal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Add animal to ZOO.");


        while(true){
            System.out.print("Enter the type of the animal: ");
            String animalType = sc.next();

            System.out.print("Enter the name of the animal: ");
            String firstAnimalName = sc.next();

            Animal animal = new Animal(animalType, firstAnimalName);
            animal.set_animal(animalType);

            getZoo_animal().add(animal);


            this.setCount();
            int a = this.getMammal();

            int b = this.getAmbhibians();
            int c = this.getReptiles();

//            System.out.println( a +" "+ b +" "+c);

            if (getZoo_animal().size() >= 6) {
                if ((this.getMammal() >= 2) &&
                        ( this.getAmbhibians() >= 2) &&
                        ( this.getReptiles() >= 2)) {
                    break;
                }
                System.out.println(".......................");


                System.out.println("Atleast, Two Animals should be present of the same type");

            }

        }
        System.out.println(".......................");
    }

    public void scheduleEvent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("List of Attractions:");

        if (this.attractions.isEmpty()){
            System.out.println("No active Attraction in the zoo...");
        }
        for (int i = 0; i < this.attractions.size(); i++) {
            System.out.println((i + 1) + ". " + this.attractions.get(i).getAttraction_name());
        }
        System.out.println(".......................");

        System.out.print("Enter the number of the attraction for scheduling an event: ");
        int attractionNumber = sc.nextInt();

        // Check if the input is within a valid range
        if (attractionNumber >= 1 && attractionNumber <= attractions.size()) {
            System.out.print("Is the attraction open or close: ");
            String isOpen = sc.next();

            attractions.get(attractionNumber - 1).setStatus(isOpen);

            System.out.println("Event scheduled successfully for " + attractions.get(attractionNumber - 1).getAttraction_name());
        } else {
            System.out.println("Invalid choice. Cannot schedule an event.");
        }
        System.out.println(".......................");
    }

    public void addDiscount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the discount code: ");
        String discountCode = scanner.next();

        // Check if the discount code already exists
        for (Discount existingDiscount : discounts) {
            if (existingDiscount.getDiscountCode().equalsIgnoreCase(discountCode)) {
                System.out.println("Discount already exists.");
                return; // Exit the method without adding the duplicate discount
            }
        }

        System.out.print("Enter the Category: ");
        String category = scanner.next();

        System.out.print("Enter the discount percentage: ");
        double discountPercentage = scanner.nextDouble();

        Discount newDiscount = new Discount(discountCode, discountPercentage, category);
        discounts.add(newDiscount);
        System.out.println("Discount added: " + discountCode + " (" + discountPercentage + "%)");
        System.out.println(".......................");
    }

    public void ModifyDiscount(){

        if (discounts.isEmpty()){
            System.out.println("No discount available...");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("List of available Discount.");

        for(int i = 0; i < discounts.size(); i++){
            System.out.println((i+1) + ". "+ discounts.get(i).getCategory() + "  " + discounts.get(i).getDiscountPercentage());
        }

        System.out.println(".................");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        System.out.println(".................");

        Discount existingDiscount = discounts.get(choice-1);

        System.out.println("What do you want to update?");
        System.out.println("1. Discount category.");
        System.out.println("2. Discount code.");
        System.out.println("3. Discount percentage");

        System.out.print("Enter your choice: ");
        int select = sc.nextInt();

        if(select == 1){
            System.out.print("Enter the new Category: ");
            String newCategory = sc.next();
            discounts.get(choice-1).setCategory(newCategory);

        } else if (select == 2) {
            System.out.print("Enter the new Code: ");
            String newCode = sc.next();
            discounts.get(choice-1).setDiscountCode(newCode);

        } else if (select == 3) {
            System.out.print("Enter the new Percentage: ");
            double newPercentage = sc.nextInt();
            discounts.get(choice-1).setDiscountPercentage(newPercentage);
        }
        System.out.println(".......................");
    }

    public void removeDiscount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("List of Discounts:");
        for (int i = 0; i < discounts.size(); i++) {
            System.out.println((i + 1) + ". " + discounts.get(i).getDiscountCode());
        }
        System.out.println(".......................");

        System.out.print("Enter the number of the discount to remove: ");
        int discountNumber = scanner.nextInt();

        // Check if the input is within a valid range
        if (discountNumber >= 1 && discountNumber <= discounts.size()) {
            Discount discountToRemove = discounts.get(discountNumber - 1);
            discounts.remove(discountToRemove);
            System.out.println("Discount removed successfully.");
        } else {
            System.out.println("Invalid choice. Cannot remove the discount.");
        }
        System.out.println(".......................");
    }

    public void setDeals(){
        for(SpecialDeals deal : deals){
            if(deal.getMinTickets() == 2 || deal.getMinTickets() == 3){
                return;
            }
        }
        SpecialDeals deals1 = new SpecialDeals(2,15);
        SpecialDeals deals2 = new SpecialDeals(3,30);
        this.deals.add(deals1);
        this.deals.add(deals2);
    }

    public void addSpecialDeal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the minimum number of Tickets: ");
        int minTickets = scanner.nextInt();

        System.out.print("Enter the discount percentage: ");
        double discountPercentage = scanner.nextDouble();

        for (SpecialDeals existingDeal : deals) {
            if (existingDeal.getMinTickets() == minTickets) {
                System.out.println("Deal already exist.");
                return;
            }
        }

        SpecialDeals newDeal = new SpecialDeals(minTickets, discountPercentage);
        deals.add(newDeal);
        System.out.println("Special deal added: " + minTickets + " Tickets, " + discountPercentage + "% discount");
    }

    public void viewDeals(){
        if (deals.isEmpty()){
            System.out.println("No deals Present...");
            return;
        }
        for (int i = 0; i < deals.size(); i ++) {
            System.out.println((i+1)+ ". "+"Buy "+ deals.get(i).getMinTickets()+ " and get " + deals.get(i).getDiscountPercentage()+ "% off");
        }
        System.out.println(".................");
    }
    public void removeSpecialDeal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("List of Special Deals:");
        for (int i = 0; i < deals.size(); i++) {
            System.out.println((i + 1) + ". Minimum Tickets: " + deals.get(i).getMinTickets());
        }
        System.out.println(".......................");

        System.out.print("Enter the number of the special deal to remove: ");
        int dealNumber = scanner.nextInt();

        // Check if the input is within a valid range
        if (dealNumber >= 1 && dealNumber <= deals.size()) {
            SpecialDeals dealToRemove = deals.get(dealNumber - 1);
            deals.remove(dealToRemove);
            System.out.println("Special deal removed: " + dealToRemove.getMinTickets() + " Tickets");
        } else {
            System.out.println("Invalid choice. Cannot remove the special deal.");
        }
    }








}
