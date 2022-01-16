package testing;

import GUI.GUIController;
import fields.Field;

import fields.Property;
import fields.StreetField;
import game.Player;
import org.junit.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentTest {
    Field[] squares = new Field[40];
    GUIController controller;
    private StreetField property;
    int price;
    int houseprice;
    int[] rent;
    int house;
    int index;
    Player owner;
    Color color;
    String fieldname;

    public void StreetField (String fieldname, int price, int houseprice, int[] rent, Color color, int index, GUIController controller) {
        this.fieldname = fieldname;
        this.price = price;
        this.houseprice = houseprice;
        this.rent = rent;
        this.controller = controller;
        this.color = color;
        this.house = 0;
        this.index = index;
    }

    /**
     * Testing the CupRoll method in our Cup-class
     */
    @Test
    public void RentTest() {
        squares[1] = new OwnedProperty("Rødovrevej", 1200, 1000, new int[]{50, 250, 750, 2250, 4000, 6000}, new Color(75, 155, 225), 1, controller);
        int expectingResult = 50;
        int actualResult = rent[house];
        assertEquals(expectingResult, actualResult);

        }
    }

