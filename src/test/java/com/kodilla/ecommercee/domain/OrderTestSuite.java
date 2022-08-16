package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void shouldCreateOrder() {
        Group group = new Group("shoes");
        Product productOne = new Product("timberland premium 6 inch boot", new BigDecimal(650), true, group);
        User userOne = new User("marcin_kowalski2", true);
        Cart cartOne = new Cart();
        cartOne.getProducts().add(productOne);
        Order orderOne = new Order(userOne, cartOne, LocalDateTime.now(), "in progress", cartOne.getProducts());

        orderRepository.save(orderOne);
        Long id = orderOne.getId();

        assertTrue(Optional.ofNullable(id).isPresent());
        assertNotEquals(0L, Optional.ofNullable(id));

        try {
            orderRepository.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldRetrieveOrders() {

        Order orderOne = new Order();
        Order orderTwo = new Order();

        orderRepository.save(orderOne);
        orderRepository.save(orderTwo);

        List<Order> ordersList = orderRepository.findAll();

        assertTrue(ordersList.size() == 2);
        assertTrue(ordersList.contains(orderOne));
        assertTrue(ordersList.contains(orderTwo));

        try {
            orderRepository.deleteAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRelationsWithOrder() {
        Group group = new Group("shoes");
        Product productOne = new Product("timberland premium 6 inch boot", new BigDecimal(650), true, group);
        Product productTwo = new Product("timberland solar wave", new BigDecimal(750), true, group);
        Product productThree = new Product("timberland santamonica sunrise", new BigDecimal(750), true, group);
        Product productFour = new Product("timberland seoul city sneaker", new BigDecimal(750), false, group);
        Product productFive = new Product("timberland dausette oxford", new BigDecimal(750), true, group);

        User userOne = new User("marcin_kowalski2", true);
        User userTwo = new User("marcin_nowak", true);

        Cart cartOne = new Cart();
        Cart cartTwo = new Cart();

        cartOne.getProducts().add(productOne);
        cartOne.getProducts().add(productTwo);
        cartOne.getProducts().add(productThree);
        cartTwo.getProducts().add(productOne);
        cartTwo.getProducts().add(productTwo);
        cartTwo.getProducts().add(productThree);
        cartTwo.getProducts().add(productFour);
        cartTwo.getProducts().add(productFive);

        Order orderOne = new Order(userOne, cartOne, LocalDateTime.now(), "in progress", cartOne.getProducts());
        Order orderTwo = new Order(userTwo, cartTwo, LocalDateTime.of(2022, 07, 23, 12, 55), "in progress", cartTwo.getProducts());

        group.getProducts().add(productOne);
        group.getProducts().add(productTwo);
        group.getProducts().add(productThree);
        group.getProducts().add(productFour);
        group.getProducts().add(productFive);

        productOne.getOrders().add(orderOne);
        productOne.getOrders().add(orderTwo);
        productTwo.getOrders().add(orderOne);
        productTwo.getOrders().add(orderTwo);
        productThree.getOrders().add(orderOne);
        productThree.getOrders().add(orderTwo);
        productFour.getOrders().add(orderTwo);
        productFive.getOrders().add(orderTwo);

        productOne.getCarts().add(cartOne);
        productOne.getCarts().add(cartTwo);
        productTwo.getCarts().add(cartOne);
        productTwo.getCarts().add(cartTwo);
        productThree.getCarts().add(cartOne);
        productThree.getCarts().add(cartTwo);
        productFour.getCarts().add(cartTwo);
        productFive.getCarts().add(cartTwo);

        orderOne.setCart(cartOne);
        orderTwo.setCart(cartTwo);

        userOne.setCart(cartOne);
        userTwo.setCart(cartTwo);

        orderRepository.save(orderOne);

        assertEquals(3, orderOne.getProducts().size());
        assertFalse(orderOne.getProducts().contains(productFive));
        assertEquals(3, orderOne.getProducts().stream()
                .filter(product -> product.getGroup().getName().equals("shoes"))
                .count());
        assertEquals(3, orderOne.getProducts().size());
        assertEquals("marcin_kowalski2", orderOne.getUser().getUsername());
        assertEquals("marcin_nowak", orderTwo.getUser().getUsername());
        assertTrue(orderOne.getCart().equals(cartOne));
        assertTrue(orderTwo.getCart().equals(cartTwo));

        try {
            orderRepository.deleteAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}