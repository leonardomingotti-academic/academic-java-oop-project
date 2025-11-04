package com.leonardo.mingotti;
import com.leonardo.mingotti.model.Category;
import com.leonardo.mingotti.repo.InMemoryCatalogRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    @Test
    void filters_by_category_counts(){
        var repo = new InMemoryCatalogRepository();
        assertEquals(2, repo.byCategory(Category.COFFEE).size());
        assertEquals(1, repo.byCategory(Category.BAKERY).size());
    }
}