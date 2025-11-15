package com.leonardo.mingotti;
import com.leonardo.mingotti.model.Cart;
import com.leonardo.mingotti.model.Category;
import com.leonardo.mingotti.model.MenuItem;
import com.leonardo.mingotti.repo.FileReceiptRepository;
import com.leonardo.mingotti.services.ReceiptService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptFileTest {
    @TempDir Path temp;

    @Test void writes_receipt_file() throws Exception {
        var cart = new Cart();
        cart.add(new MenuItem("Coffee", new BigDecimal("3.00"), Category.COFFEE), 2);

        var svc = new ReceiptService(new java.math.BigDecimal("0.00")::add); // dummy tax, or use FlatRateTaxCalculator

        //var saver = new ReceiptSaver(svc, new FileReceiptRepository(temp));
        //Path p = saver.renderAndSave(cart);

    var lines = svc.render(cart);
        //var dir = Path.of("C:\\Users\\golkhandani\\Desktop\\Fall2025\\SQA109\\TestDemo");
    var printer = new FileReceiptRepository(temp);
    var p = printer.save(lines);

        assertTrue(Files.exists(p));
        assertTrue(Files.size(p) > 0);

        //new FileReader(p.toFile());
    }
}