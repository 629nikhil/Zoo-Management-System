public class Discount {
    private String discountCode;
    private double discountPercentage;

    private String category;

    public String getCategory() {
        return category;
    }

    public Discount(String discountCode, double discountPercentage, String category) {
        this.discountCode = discountCode;
        this.discountPercentage = discountPercentage;
        this.category = category;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
