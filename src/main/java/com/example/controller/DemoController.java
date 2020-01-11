package com.example.controller;

import com.example.entity.Product;
import com.example.myspringbootstarter.MyService;
import com.example.entity.User;
import com.example.service.ProductService;
import com.example.service.RushService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@PropertySource("classpath:demo.properties")
public class DemoController {

    AtomicInteger count = new AtomicInteger();
    @Value("${user.age}")
    String name;

    @Autowired
    UserService userService;

    @Autowired
    MyService myService;

    @Autowired
    KafkaTemplate template;

    @Autowired
    RushService rushService;

    @Autowired
    ProductService productService;
    @RequestMapping("/demo")
    public void demo() {
        System.out.println("demo");
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/demo2")
    public String demo2() {
        System.out.println("demo2");
        return name;
    }

    @RequestMapping("/addUser")
    public void demo3() {
        User u = new User();
        u.setUserName("111");
        u.setPassWord("111");
        userService.addUser(u);
    }

    @RequestMapping("/user")
    public void user() {
        User u = userService.findUserById(1);
        System.out.println(u);
    }

    @RequestMapping("/starter")
    public void starter() {
        System.out.println("starter-->" + myService.doService());

    }

    @RequestMapping("/init")
    @ResponseBody
    public Product init(String name){
        Product p = new Product();
        p.setName(name);
        productService.save(p);
        return p;
    }


    @RequestMapping("/stock")
    @ResponseBody
    public Product stock(Long id,Integer count){
        Product p = productService.findById(id);
        if (p != null){
            p.setCount(count);
            productService.save(p);
        }
        return p;
    }

    @RequestMapping("/rush")
    public void rush(Long id) throws Exception {
        int value = count.incrementAndGet();
        System.out.println("rush==>"+value);
        rushService.rush(1L);
    }
}
