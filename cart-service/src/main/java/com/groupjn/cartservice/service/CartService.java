package com.groupjn.cartservice.service;

import com.groupjn.cartservice.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    List<Cart> addCartbyUserIdAndProductId(int productId, int userId,int qty,double price) throws Exception;
    void updateQtyByCartId(int cartId, double price, int qty) throws Exception;
    List<Cart> getCartByUserId(int userId);
    List<Cart> removeCartByUserId(int cart_id,int userId);

    //List<Cart> CheckOutCart(int cartid, int userid);
    //CheckOutCart
}
