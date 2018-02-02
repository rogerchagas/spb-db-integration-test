package com.ericsson.poc.integration;

import com.ericsson.poc.model.Category;
import com.ericsson.poc.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CategoryIntegrationTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void populateTheDatabase(){
        Category category1  = new Category("Games");
        Category category2 = new Category("Sports");
        categoryRepository.save(Arrays.asList(category1, category2));
    }

    @Test
    public void testIfTheCategoryTableHasAListWithTwoCategories(){
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        assertNotNull(categories);
        assertThat(categories.size(), is(equalTo(2)));
        assertThat(categories.get(0).getName(), is(equalTo("Games")));
        assertThat(categories.get(1).getName(), is(equalTo("Sports")));
    }

}
