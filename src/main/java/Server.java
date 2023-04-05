import java.util.ArrayList;

public class Server {

    private ArrayList<String> menu;

    public Server(ArrayList<String> menu){
        this.menu = menu;
    }

    public boolean canServeGuest(Guest guest){
        if(guest.getAge() < 18){
            return false;
        }
        if(guest.getWallet() < 5.0){
            return false;
        }
        if(guest.getSobriety() < 50){
            return false;
        }
        if(guest.getIsBanned()){
            return false;
        }
        if(guest.getCurrency() != '£'){
            return false;
        }
        if(!menu.contains(guest.getFavouriteDrink())){
            return false;
        }
        return true;
    }

//    public boolean isOldEnough(Guest guest){
//        if(guest.getAge() >= 18){
//            return true;
//        }
//        return false;
//    }

//    public boolean hasEnoughMoney(Guest guest){
//        if(guest.getWallet() > 5.0){
//            return true;
//        }
//        return false;
//    }


}
