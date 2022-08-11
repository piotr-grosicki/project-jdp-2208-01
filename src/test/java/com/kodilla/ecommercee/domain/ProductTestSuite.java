//package com.kodilla.ecommercee.domain;
//
//import com.kodilla.ecommercee.repository.ProductRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class ProductTestSuite {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void shouldCreateProduct() {
//        Group group = new Group("shoes");
//        Product productOne = new Product("timberland premium 6 inch boot", new BigDecimal(650), true, group);
//
//        productRepository.save(productOne);
//        Long id = productOne.getId();
//
//        assertTrue(Optional.ofNullable(id).isPresent());
//        assertNotEquals(0L, Optional.ofNullable(id));
//
//        try {
//            productRepository.deleteById(id);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void shouldRetrieveProducts() {
//        Group group = new Group("shoes");
//        Product productOne = new Product("timberland premium 6 inch boot", new BigDecimal(650), true, group);
//        Product productTwo = new Product("timberland solar wave", new BigDecimal(750), true, group);
//        Product productThree = new Product("timberland santamonica sunrise", new BigDecimal(750), true, group);
//
//        productRepository.save(productOne);
//        productRepository.save(productTwo);
//        productRepository.save(productThree);
//
//        List<Product> productList = (List<Product>) productRepository.findAll();
//
//        assertTrue(productList.size() == 3);
//        assertTrue(productList.contains(productOne));
//        assertTrue(productList.contains(productTwo));
//        assertTrue(productList.contains(productThree));
//
//        try {
//            productRepository.deleteAll();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testRelationsWithProduct() {
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
//        Order orderOne = new Order(userOne, cartOne, LocalDateTime.now(), "in progress", productList1);
//        Order orderTwo = new Order(userTwo, cartTwo, LocalDateTime.of(2022, 07, 23, 12, 55), "in progress", productList2);
//
//        group.getProducts().add(productOne);
//        group.getProducts().add(productTwo);
//        group.getProducts().add(productThree);
//        group.getProducts().add(productFour);
//        group.getProducts().add(productFive);
//
//        List<Order> orderList1 = new ArrayList<>();
//        orderList1.add(orderOne);
//        orderList1.add(orderTwo);
//
//        List<Order> orderList2 = new ArrayList<>();
//        orderList2.add(orderTwo);
//
//        List<Cart> cartList1 = new ArrayList<>();
//        cartList1.add(cartOne);
//        cartList1.add(cartTwo);
//
//        List<Cart> cartList2 = new ArrayList<>();
//        cartList2.add(cartTwo);
//
//        productOne.setOrders(orderList1);
//        productTwo.setOrders(orderList1);
//        productThree.setOrders(orderList1);
//        productFour.setOrders(orderList2);
//        productFive.setOrders(orderList2);
//
//        cartOne.setProducts(productList1);
//        cartTwo.setProducts(productList2);
//
//        productOne.setCarts(cartList1);
//        productTwo.setCarts(cartList1);
//        productThree.setCarts(cartList1);
//        productFour.setCarts(cartList2);
//        productFive.setCarts(cartList2);
//
//        orderOne.setCart(cartOne);
//        orderTwo.setCart(cartTwo);
//
//        userOne.setCart(cartOne);
//        userTwo.setCart(cartTwo);
//
//        productRepository.save(productOne);
//
//        assertEquals("shoes", productOne.getGroup().getName());
//        assertEquals(2, productOne.getCarts().size());
//        assertEquals(1, productFive.getCarts().size());
//        assertEquals(2, productTwo.getOrders().size());
//        assertEquals(1, productFour.getOrders().size());
//
//        try {
//            productRepository.deleteAll();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//}