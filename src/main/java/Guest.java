public class Guest {

    private String name;
    private int age;

    private double wallet;

    private int sobriety;

    private boolean isBanned;

    private char currency;

    private String favouriteDrink;

    public Guest(String name, int age, double wallet, int sobriety, boolean isBanned, char currency, String favouriteDrink){
        this.name = name;
        this.age = age;
        this.wallet = wallet;
        this.sobriety = sobriety;
        this.isBanned = isBanned;
        this.currency = currency;
        this.favouriteDrink = favouriteDrink;
    }

    public int getAge() {
        return this.age;
    }

    public double getWallet() {
        return this.wallet;
    }

    public int getSobriety(){
        return this.sobriety;
    }

    public boolean getIsBanned(){
        return this.isBanned;
    }

    public char getCurrency(){
        return this.currency;
    }

    public String getFavouriteDrink(){
        return this.favouriteDrink;
    }
}
