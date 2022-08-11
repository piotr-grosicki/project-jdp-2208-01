//package com.kodilla.ecommercee.domain;
//
//import com.kodilla.ecommercee.repository.CartRepository;
//import org.junit.Test;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CartRepositoryTestSuite {
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Test
//    public void testFindAllCarts() {
//
//        //Given
//        Cart cart1 = new Cart();
//        Cart cart2 = new Cart();
//
//        //When
//        cartRepository.save(cart1);
//        cartRepository.save(cart2);
//
//        //Then
//        assertEquals(2, cartRepository.findAll().size());
//
//        //CleanUp
//        cartRepository.deleteById(cart1.getId());
//        cartRepository.deleteById(cart2.getId());
//    }
//
//    @Test
//    public void testFindCartById() {
//        //Given
//        Cart cart = new Cart();
//
//        //When
//        cartRepository.save(cart);
//        Long id = cart.getId();
//        Optional<Cart> foundCart = cartRepository.findById(id);
//
//        //Then
//        assertNotNull(foundCart);
//        assertEquals(id, foundCart.get().getId());
//
//        //CleanUp
//        cartRepository.deleteById(cart.getId());
//    }
//
//    @Test
//    public void testSaveCart() {
//        //Given
//        Cart cart = new Cart();
//
//        //When
//        cartRepository.save(cart);
//        Long cartId = cart.getId();
//        Optional<Cart> savedCart = cartRepository.findById(cartId);
//
//        //Then
//        assertTrue(savedCart.isPresent());
//
//        //CleanUp
//        cartRepository.deleteById(cart.getId());
//    }
//
//    @Test
//    public void testDeleteCart() {
//        //Given
//        Cart cart = new Cart();
//        cartRepository.save(cart);
//
//        //When
//        Long id = cart.getId();
//        cartRepository.deleteById(id);
//        Optional<Cart> removedCart = cartRepository.findById(id);
//        int availableCart = cartRepository.findAll().size();
//
//        //Then
//        assertEquals(Optional.empty(), removedCart);
//        assertEquals(0, availableCart);
//
//    }
//
//    @Test
//    public void testRelationsWithCart() {
//
//        //Given
//        Group group = new Group("shoes");
//
//        Product productOne = new Product("timberland premium 6 inch boot", new BigDecimal(650), true, group);
//        Product productTwo = new Product("timberland solar wave", new BigDecimal(750), true, group);
//        Product productThree = new Product("timberland santamonica sunrise", new BigDecimal(750), true, group);
//        Product productFour = new Product("timberland seoul city sneaker", new BigDecimal(750), false, group);
//        Product productFive = new Product("timberland dausette oxford", new BigDecimal(750), true, group);
//
//        User userOne = new User("marcin_kowalski2", true);
//        User userTwo = new User("marcin_nowak", true);
//
//        Cart cartOne = new Cart();
//        Cart cartTwo = new Cart();
//
//        List<Product> productList1 = new ArrayList<>();
//        productList1.add(productOne);
//        productList1.add(productTwo);
//        productList1.add(productThree);
//
//        List<Product> productList2 = new ArrayList<>();
//        productList2.add(productOne);
//        productList2.add(productTwo);
//        productList2.add(productThree);
//        productList2.add(productFour);
//        productList2.add(productFive);
//
//        List<Cart> cartList1 = new ArrayList<>();
//        cartList1.add(cartOne);
//
//        List<Cart> cartList2 = new ArrayList<>();
//        cartList2.add(cartOne);
//        cartList2.add(cartTwo);
//
//        Order orderOne = new Order(userOne, cartOne, LocalDateTime.now(), "in progress", productList1);
//        Order orderTwo = new Order(userTwo, cartTwo, LocalDateTime.of(2022, 07, 23, 12, 55), "in progress", productList2);
//
//
//        //When
//        cartOne.setProducts(productList1);
//        cartTwo.setProducts(productList2);
//
//        productOne.setCarts(cartList1);
//        productOne.setCarts(cartList2);
//        productTwo.setCarts(cartList1);
//        productTwo.setCarts(cartList2);
//        productThree.setCarts(cartList1);
//        productThree.setCarts(cartList2);
//        productFour.setCarts(cartList1);
//        productFive.setCarts(cartList1);
//
//        cartOne.setUser(userOne);
//        cartTwo.setUser(userTwo);
//
//        orderOne.setCart(cartOne);
//        orderTwo.setCart(cartTwo);
//
//        cartRepository.save(cartOne);
//        cartRepository.save(cartTwo);
//
//        //Then
//        assertEquals(3, cartOne.getProducts().size());
//        assertEquals(5, cartTwo.getProducts().size());
//        assertEquals(2, productOne.getCarts().size());
//        assertEquals(1, productFive.getCarts().size());
//        assertEquals("marcin_kowalski2", cartOne.getUser().getUsername());
//        assertEquals("marcin_nowak", cartTwo.getUser().getUsername());
//        assertEquals(cartOne, orderOne.getCart());
//        assertEquals(cartTwo, orderTwo.getCart());
//
//        try {
//            cartRepository.deleteAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}