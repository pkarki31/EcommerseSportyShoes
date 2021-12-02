package com.Simplilearn.eCommerceSportyShoes.controller;

import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import com.Simplilearn.eCommerceSportyShoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

	@Autowired
	ProductService prodService;

	//Model model;

	@GetMapping("/products")
	public String listProducts(Model theModel) {

		theModel.addAttribute("product",prodService.getProdcuts());

		//System.out.print("product :"+prodService.getProdcuts());

		return "dashboard";
	}

//	@GetMapping("/products/{name}")
//	public List<Product> searchProductByName(@PathVariable("name") String productName) {
//		return prodService.findByName(productName);
//	}

	@GetMapping("/createProduct")
	public String createProduct(Model model) {

		System.out.print("inside create product ...");
		model.addAttribute("prod",new Product());
		return "createProduct";
	}

	@PostMapping("/products")
	public String addProduct(@ModelAttribute(value="prod") Product newProduct,Model theModel) {

		System.out.print("newProduct :"+newProduct.getName());
		boolean created=prodService.save(newProduct);

		if(created){
			theModel.addAttribute("updateProductMsg","Product Created Successfully ");

			return "redirect:/products";
		}

		else {

			theModel.addAttribute("updateProductMsg","Something went wrong, Try Again!");

			return "createProduct";
		}
	}

	@PostMapping("/productUpdateToEdit")
	//@RequestMapping(value="/empUpdateToEdit", method = RequestMethod.POST)
	public String productUpdateToEdit(@ModelAttribute(value="prod") Product product, Map<String, Object> model) {
		model.put("prod", product);
		return "productUpdateToEdit";
	}

	@GetMapping("/productUpdate")
	public String changePassword(@RequestParam("oldname") String oldname,
								 @RequestParam("updatedName") String updatedName,
								 @RequestParam("price") String price,@RequestParam("size") String size
			,@RequestParam("category") String category,Model theModel) {

		System.out.print("oldname : "+oldname);
		System.out.print("updatedName : "+updatedName);

		boolean passwordChanged = prodService.updateProduct(oldname,updatedName, price,size,category);
		if (passwordChanged) {

			theModel.addAttribute("updateProductMsg","Product Updated Successfully ");

			return "redirect:/products";
		} else {

			theModel.addAttribute("updateProductMsg","Something went wrong, Try Again!");

			return "productUpdateToEdit";
		}
	}
}
