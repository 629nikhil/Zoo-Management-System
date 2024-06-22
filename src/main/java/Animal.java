public class Animal {
    private String animal_type;
    private String animal_name;

    private String description;

    private String sound;

    private String food;

    public Animal(String animal_type, String animal_name) {
        this.animal_type = animal_type;
        this.animal_name = animal_name;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public String getDescription() {
        return description;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void print(){
        System.out.println("Animal name: " + this.getAnimal_name());
        System.out.println("This animal eats " + this.getFood());
        System.out.println("Animal sound: " + this.getSound());
        System.out.println("Animal description: ");
        System.out.println(this.getDescription() + "\n");


    }

    public void set_animal(String animal_type){
        if (animal_type.equals("Mammals")){
            this.setFood("veg and non veg");
            this.setDescription("Mammals are vertebrates");
            this.setSound("Bark");
        }
        else if (animal_type.equals("Reptiles")){
            this.setFood("Insects, Bird and frogs");
            this.setDescription("air-breathing, cold-blooded vertebrates");
            this.setSound("squealing sounds or low growls");

        }
        else if (animal_type.equals("Amphibians")){
            this.setFood("bugs, slugs, snails,");
            this.setDescription("small vertebrates that need water, or a moist environment, to survive.");
            this.setSound("croak");
        }
    }
}

