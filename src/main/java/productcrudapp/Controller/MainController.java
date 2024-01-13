package productcrudapp.Controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.Model.Product;
import productcrudapp.dao.ProductDao;

@Controller
public class MainController {
	
	
	@Autowired
	private ProductDao productDao;
	
	
	
	
	@RequestMapping("/")
	public String home(Model m) {
		
		List<Product> products = productDao.getProducts();
		m.addAttribute("products",products);
		
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","ADD PRODUCT");
		return "add_product_form";
	}
	
	@RequestMapping(path = "/handle-product", method = RequestMethod.POST)
	public RedirectView  handleProduct(@ModelAttribute Product product, HttpServletRequest req) {
		System.out.println(product);
		
		//adding to db
		productDao.createProduct(product);
		
		
		RedirectView redirectView = new RedirectView();
		String contextPath = req.getContextPath();
		redirectView.setUrl(contextPath);
		return redirectView;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId")int productId,  HttpServletRequest req) {
		
		productDao.deleteProduct(productId);
		
		RedirectView redirectView = new RedirectView();
		String contextPath = req.getContextPath();
		redirectView.setUrl(contextPath);
		return redirectView;
	}
	
	@RequestMapping("/update/{pid}")
	public String updateProduct(@PathVariable("pid") int pid, Model m) {
		Product product = productDao.getProduct(pid);
		m.addAttribute("product",product);
		
		
		
		return "update_form";
	}
	
	
	
}
