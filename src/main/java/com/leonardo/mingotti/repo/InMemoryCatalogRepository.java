package com.leonardo.mingotti.repo;

import com.leonardo.mingotti.interfaces.TaxCalculator.CatalogRepository;
import com.leonardo.mingotti.model.Category;
import com.leonardo.mingotti.model.MenuItem;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryCatalogRepository implements CatalogRepository {
    private final List<MenuItem> data = List.of(
            new MenuItem("Americano", new BigDecimal("3.50"), Category.COFFEE),
            new MenuItem("Latte", new BigDecimal("4.20"), Category.COFFEE),
            new MenuItem("Croissant", new BigDecimal("4.25"), Category.BAKERY)
    );
    @Override public List<MenuItem> all(){ return data; }

    @Override public List<MenuItem> byCategory(Category c){
        return data.stream().filter(mi -> mi.getCategory()==c).toList(); }
}