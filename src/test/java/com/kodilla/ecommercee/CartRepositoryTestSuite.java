package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testFindAllCarts() {

        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Product product1 = new Product();
        Product product2 = new Product();

        //When

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        cart1.setProducts(productList);

        List<Product> productList2 = new ArrayList<>();
        productList2.add(product2);
        cart2.setProducts(productList2);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart1);
        product1.setCarts(carts);

        List<Cart> carts2 = new ArrayList<>();
        carts2.add(cart2);
        product2.setCarts(carts2);

        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //Then
        assertEquals(2, cartRepository.findAll().size());

        //CleanUp
        cartRepository.deleteById(cart1.getId());
        cartRepository.deleteById(cart2.getId());
    }

    @Test
    public void testFindCartById() {
        //Given
        Cart cart = new Cart();
        Product product = new Product();

        //When
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        cart.setProducts(productList);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        product.setCarts(carts);

        cartRepository.save(cart);
        Long id = cart.getId();
        Optional<Cart> foundCart = cartRepository.findById(id);

        //Then
        assertNotNull(foundCart);
        assertEquals(id, foundCart.get().getId());

        //CleanUp
        cartRepository.deleteById(cart.getId());
    }

    @Test
    public void testSaveCart() {
        //Given
        Cart cart = new Cart();
        Product product = new Product();

        //When
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        cart.setProducts(productList);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        product.setCarts(carts);

        cartRepository.save(cart);
        Long cartId = cart.getId();
        Optional<Cart> savedCart = cartRepository.findById(cartId);

        //Then
        assertTrue(savedCart.isPresent());

        //CleanUp
        cartRepository.deleteById(cart.getId());
    }

    @Test
    public void  testDeleteCart() {
        //Given
        Cart cart = new Cart();
        Product product = new Product();

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        cart.setProducts(productList);

        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        product.setCarts(carts);

        cartRepository.save(cart);

        //When
        Long id = cart.getId();
        cartRepository.deleteById(id);
        Optional<Cart> removedCart = cartRepository.findById(id);
        int availableCart = cartRepository.findAll().size();

        //Then
        assertEquals(Optional.empty(), removedCart);
        assertEquals(0, availableCart);

    }
}
