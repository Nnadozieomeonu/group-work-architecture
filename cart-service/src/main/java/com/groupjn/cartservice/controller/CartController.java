package com.groupjn.cartservice.controller;


import com.groupjn.cartservice.configuration.ShoppingConfiguration;
import com.groupjn.cartservice.entity.Cart;
import com.groupjn.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("addProductToCart")
    public ResponseEntity<?> addProductToCart(@RequestBody HashMap<String, String> addCartRequest){

       try {
           String keys[] = {"productId","userId","qty","price"};
           if(ShoppingConfiguration.validationWithHashMap(keys,addCartRequest)){

           }
           int productId = Integer.parseInt(addCartRequest.get("productId"));
           int userId = Integer.parseInt(addCartRequest.get("userId"));
           int quantity = Integer.parseInt(addCartRequest.get("qty"));
           double price = Double.parseDouble(addCartRequest.get("price"));
           List<Cart> cart =  cartService.addCartbyUserIdAndProductId(productId,userId,quantity,price);
           return ResponseEntity.ok(cart);
       }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Bad request");
       }
    }


    @PostMapping("removeProductFromCart")
    public ResponseEntity<?> removeCartWithProductId(@RequestBody HashMap<String, String> removeCartRequest) throws Exception {

        try{
            String keys[] = {"userId","cartId"};
            if(ShoppingConfiguration.validationWithHashMap(keys,removeCartRequest)){

            }
            List<Cart> cart =  cartService.removeCartByUserId(Integer.parseInt(removeCartRequest.get("cartId")),
                    Integer.parseInt(removeCartRequest.get("userId")));
            return ResponseEntity.ok(cart);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error procesing request");
        }


    }

    @PostMapping("getCartByUserId")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String, String> getCartRequest){
        try{
            String keys[] = {"userId"};
            if(ShoppingConfiguration.validationWithHashMap(keys,getCartRequest)){

            }
            List<Cart> cart =  cartService.getCartByUserId(Integer.parseInt(getCartRequest.get("userId")));
            return ResponseEntity.ok(cart);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error procesing request");
        }
    }



    @PostMapping("updateQtyForCart")
    public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String, String> updateCartRequest){

        try {
            String keys[] = {"cartId","userId","qty","price"};
            if(ShoppingConfiguration.validationWithHashMap(keys,updateCartRequest)){

            }
            int cartId = Integer.parseInt(updateCartRequest.get("cartId"));
            int userId = Integer.parseInt(updateCartRequest.get("userId"));
            int quantity = Integer.parseInt(updateCartRequest.get("qty"));
            double price = Double.parseDouble(updateCartRequest.get("price"));
            cartService.updateQtyByCartId(cartId,price,quantity);
            List<Cart> cart =  cartService.getCartByUserId(userId);
            return ResponseEntity.ok(cart);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Bad request");
        }
    }
}
