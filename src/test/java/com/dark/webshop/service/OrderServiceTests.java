package com.dark.webshop.service;

import com.dark.webshop.service.interfaces.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrderServiceTests {
    @Autowired
    OrderService orderService;
    @Test
    public void createOrder()
    {

    }
    @Test
    public void testGetOrdersByUser() {
    }
}
