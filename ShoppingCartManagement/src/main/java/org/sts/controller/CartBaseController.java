package org.sts.controller;

import javax.servlet.http.HttpServletRequest;

import org.sts.modal.Cart;


public abstract class CartBaseController {
	
	protected Cart getOrCreateCart(HttpServletRequest request)
	{
		Cart cart = null;
		cart = (Cart) request.getSession().getAttribute("CART_KEY");
		if(cart == null){
			cart = new Cart();
			request.getSession().setAttribute("CART_KEY", cart);
		}
		return cart;
	}

}
