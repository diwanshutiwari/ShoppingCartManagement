package org.sts.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sts.entities.Category;
import org.sts.entities.Product;
import org.sts.repository.ProductRepository;
import org.sts.service.CatalogService;

@RestController
public class HomeController {
	
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ProductRepository pr;
	
	@GetMapping("home")
	public List<Product> home()
	{
		return catalogService.getAllProducts();
		
	}
	
	
	
	@RequestMapping("/categories/{name}")
	public Category category(@PathVariable String name)
	{
		Category category = catalogService.getCategoryByName(name);
		return category;
	}
	
	@RequestMapping("/categories")
	public List<Category> getAllCategory(){
		
		return catalogService.getAllCategories();
	}
	

}
