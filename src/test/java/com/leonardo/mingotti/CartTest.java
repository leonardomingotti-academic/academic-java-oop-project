package com.leonardo.mingotti;

import com.leonardo.mingotti.model.Cart;
import com.leonardo.mingotti.model.Category;
import com.leonardo.mingotti.model.MenuItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    public void addAndSums(){

        MenuItem coffe = new MenuItem(
                "Coffe",
                new BigDecimal(3),
                Category.COFFEE
        );

        int qty = 2;
        Cart cart = new Cart();

        cart.add(coffe, qty);

        BigDecimal subtotal = cart.subtotal();

        assertEquals(coffe.getPrice().multiply(new BigDecimal(qty)), subtotal);

    }
}
