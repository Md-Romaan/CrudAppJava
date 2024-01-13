package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.Model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void createProduct(Product product) {
		hibernateTemplate.saveOrUpdate(product);

	}
	
	//get all products
	public List<Product> getProducts(){
		List<Product> products = hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//get single product
	public Product getProduct(int pid) {
		Product product = hibernateTemplate.get(Product.class, pid);
		return product;
	}
	
	@Transactional
	public void deleteProduct(int pid) {
		Product p = hibernateTemplate.load(Product.class, pid);
		hibernateTemplate.delete(p);
	}
	
	
	
	
	
}
