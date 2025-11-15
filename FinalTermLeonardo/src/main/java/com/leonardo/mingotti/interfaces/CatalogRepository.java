package com.leonardo.mingotti.interfaces;
import com.leonardo.mingotti.model.Category;
import com.leonardo.mingotti.model.MenuItem;

import java.util.List;

public interface CatalogRepository {
    List<MenuItem> all();
    List<MenuItem> byCategory(Category category);
}