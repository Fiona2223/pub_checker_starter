import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ServerTest {

    Server server;

    @BeforeEach
    public void setUp(){
//        System.out.println(Drink.);
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Old Fashioned");
        menu.add("White Russian");
        menu.add("Zoom");
        menu.add("Alexander");
        menu.add("Espresso Martini");
        menu.add("Bloody Mary");
        server = new Server(menu);
    }

    // TODO: test that guest can only get served if over 18
    @Test
    public void canServe(){
        Guest guest = new Guest("Zsolt", 19, 10.0, 100, false, '£', "Bloody Mary");
        boolean actual = server.canServeGuest(guest);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void cannotServeIfUnder18(){
        Guest youngGuest = new Guest("Zsolt", 10, 10.0, 90, false, '£', "Zoom");
        boolean actual = server.canServeGuest(youngGuest);
        assertThat(actual).isEqualTo(false);
    }


    // TODO: test that guest can only get served if has enough money to buy a drink (every drink is £5)
    @Test
    public void cannotGetServedIfBroke(){
        Guest brokeGuest = new Guest("Zsolt", 21, 3.0, 70, false, '£', "Old Fashioned");
        boolean actual = server.canServeGuest(brokeGuest);
        assertThat(actual).isEqualTo(false);
    }

    // TODO: test that guest can only get served if sober enough (set sobriety level on guest)
    @Test
    public void cannotGetServedIfDrunk(){
        Guest drunkGuest = new Guest("Zsolt", 21, 10.0, 9, false, '£', "Alexander");
        boolean actual = server.canServeGuest(drunkGuest);
        assertThat(actual).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest is not banned from the pub
    @Test
    public void cannotGetServedIfBanned(){
        Guest rowdyGuest = new Guest("Zsolt", 21, 10.0, 80, true, '£', "Espresso Martini");
        boolean actual = server.canServeGuest(rowdyGuest);
        assertThat(actual).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest can pay in local currency (add £ char as currency)
    @Test
    public void cannotGetServedIfTryingToPayWithMonopolyMoney(){
        Guest foreignGuest = new Guest("Zsolt", 21, 10.0, 80, false, 'F', "White Russian");
        boolean actual = server.canServeGuest(foreignGuest);
        assertThat(actual).isEqualTo(false);
    }
    // EXTENSIONS

    // TODO: test that guest can only get served if server can make favourite drink
    //  (give server a list of drinks (strings) it can make)
    @Test
    public void cannotGetServedIfCannotMakeFavouriteDrink(){
        Guest pickyGuest = new Guest("Zsolt", 21, 10.0, 80, false, '£', "Purple rain");
        boolean actual = server.canServeGuest(pickyGuest);
        assertThat(actual).isEqualTo(false);
    }

}
