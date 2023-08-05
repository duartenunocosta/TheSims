package mindera.mindswap.house;

public class House {
    private int price;
    private int cleannessLevel;
    private int maxCleannessLevel;

    public House(){
        this.price = 50000;
        this.maxCleannessLevel = 100;
        this.cleannessLevel = maxCleannessLevel;
    }

    public int getPrice() {
        return price;
    }
}
