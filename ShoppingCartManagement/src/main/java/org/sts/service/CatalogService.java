package org.sts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sts.CartException;
import org.sts.entities.Category;
import org.sts.entities.Product;
import org.sts.repository.CategoryRepository;
import org.sts.repository.ProductRepository;

@Service
@Transactional
public class CatalogService {

	
	@Autowired CategoryRepository categoryRepository;
	@Autowired ProductRepository productRepository;
	
	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
	}
	
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public Category getCategoryByName(String name) {
		return categoryRepository.getByName(name);
	}
	
	public Category getCategoryById(Integer id) {
		
		
		Optional<Category> op=categoryRepository.findById(id);
		
		if(op.isPresent()){
			return op.get();
		}
		return null;
		
	}

	public Category createCategory(Category category) {
		Category persistedCategory = getCategoryByName(category.getName());
		if(persistedCategory != null){
			throw new CartException("Category "+category.getName()+" already exist");
		}
		return categoryRepository.save(category);
	}

	public Category updateCategory(Category category) {
		Category persistedCategory = getCategoryById(category.getId());
		if(persistedCategory == null){
			throw new CartException("Category "+category.getId()+" doesn't exist");
		}
		persistedCategory.setDescription(category.getDescription());
		persistedCategory.setDisplayOrder(category.getDisplayOrder());
		persistedCategory.setDisabled(category.isDisabled());
		return categoryRepository.save(persistedCategory);
	}

	public Product getProductById(Integer id) {
		
		
		Optional<Product> op=productRepository.findById(id);
		
		if(op.isPresent()){
			return op.get();
		}
		return null;
	}
	
	public Product getProductBySku(String sku) {
		return productRepository.findBySku(sku);
	}
	
	public Product createProduct(Product product) {
		Product persistedProduct = getProductBySku(product.getName());
		if(persistedProduct != null){
			throw new CartException("Product SKU "+product.getSku()+" already exist");
		}
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		Product persistedProduct = getProductById(product.getId());
		if(persistedProduct == null){
			throw new CartException("Product "+product.getId()+" doesn't exist");
		}
		persistedProduct.setDescription(product.getDescription());
		persistedProduct.setDisabled(product.isDisabled());
		persistedProduct.setPrice(product.getPrice());
		persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
		return productRepository.save(persistedProduct);
	}

	public List<Product> searchProducts(String query) {
		return productRepository.search("%"+query+"%");
	}
	
	
}
