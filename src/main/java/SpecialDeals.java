public class SpecialDeals {
    private int minTickets;
    private double discountPercentage;

    public SpecialDeals(int minTickets, double discountPercentage) {
        this.minTickets = minTickets;
        this.discountPercentage = discountPercentage;
    }

    public int getMinTickets() {
        return minTickets;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}

