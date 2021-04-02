package com.groupjn.cartservice.service;

import com.groupjn.cartservice.entity.Cart;
import com.groupjn.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> addCartbyUserIdAndProductId(int productId, int userId, int qty,double price) throws Exception{

        try {
            if(cartRepository.getCartByproductIdAnduserId(userId,productId).isPresent()){
                throw new Exception("Product is aready in cart.");
            }

            Cart cart = new Cart();
            cart.setQuantity(qty);
            cart.setUser_id(userId);
            cart.setProduct_id(productId);
            //TODO price has to be checked with quantity
            cart.setPrice(price);
            cartRepository.save(cart);
            return this.getCartByUserId(userId);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void updateQtyByCartId(int cartId, double price, int qty) throws Exception {
        cartRepository.updateQtyByCartId(cartId,price,qty);
    }

    @Override
    public List<Cart> getCartByUserId(int userId) {
        return cartRepository.getCartByuserId(userId);
    }

    @Override
    public List<Cart> removeCartByUserId(int cartId, int userId) {
        cartRepository.deleteAllCartByIdUserId(cartId,userId);
        return this.getCartByUserId(userId);
    }
}
