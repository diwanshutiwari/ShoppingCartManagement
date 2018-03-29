package org.sts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sts.entities.Product;
import org.sts.service.CatalogService;
import org.sts.utils.WebUtils;



@RestController
public class ProductController {
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping("/products/{sku}")
	public Product product(@PathVariable String sku)
	{
		Product product = catalogService.getProductBySku(sku);
		
		return product;
	}
	
	@RequestMapping("/products")
	public List<Product> searchProducts(@RequestParam(name="q", defaultValue="") String query)
	{
		List<Product> products = catalogService.searchProducts(query);
		
		return products;
	}
	
	@RequestMapping(value="/products/images/{productId}", method=RequestMethod.GET)
	public void showProductImage(@PathVariable String productId, HttpServletRequest request, HttpServletResponse response) {
		try {
			FileSystemResource file = new FileSystemResource(WebUtils.IMAGES_DIR +productId+".jpg");     
			response.setContentType("image/jpg");
			org.apache.commons.io.IOUtils.copy(file.getInputStream(), response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}	      
	}

}
