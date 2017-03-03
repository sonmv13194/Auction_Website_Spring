package hvcntt.org.shoppingweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hvcntt.org.shoppingweb.model.CartItem;
import hvcntt.org.shoppingweb.model.Product;
import hvcntt.org.shoppingweb.service.CartItemService;
import hvcntt.org.shoppingweb.service.ProductService;

@Controller
public class CartPageController {
	@Autowired
	ProductService productservice;
	@Autowired
	CartItemService cartItemService;
	@RequestMapping(value="/cart")
	public String cartPage(@RequestParam("idproduct")int idproduct,Model model,HttpSession session){
		Product product=productservice.findOne(idproduct);
		if(session.getAttribute("cart")==null){
			List<CartItem> cartItem= new ArrayList<>();
			cartItem.add(new CartItem(1,product));
			session.setAttribute("cart", cartItem);
		}
		else{
			@SuppressWarnings("unchecked")
			List<CartItem> items= (List<CartItem>) session.getAttribute("cart");
			int index=isExist(idproduct, session);
			if(index==-1){
				items.add(new CartItem(1,product));
			}
			else{
				int quantity=items.get(index).getQuantity()+1;
				items.get(index).setQuantity(quantity);
			}
		}
		
		return "cart";
	}
	
	private int isExist(int idproduct,HttpSession session){
		@SuppressWarnings("unchecked")
		List<CartItem> items= (List<CartItem>) session.getAttribute("cart");
		for(int i=0;i<items.size();i++){
			if(items.get(i).getProduct().getIdproduct()==idproduct){
				return i;
			}
		}
		return -1;
	}
	@RequestMapping(value="/viewcart")
	private String viewCart(HttpSession session){
		@SuppressWarnings({ "unchecked", "unused" })
		List<CartItem> listItems= (List<CartItem>) session.getAttribute("cart");
		return "cart";
	}
}