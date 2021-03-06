package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void home_validateResponseURL() {
        String s = userController.home(model);
        Assert.assertEquals("user/list", s);
    }

    @Test
    public void addUser_validateResponseURL() {
        User user = new User();
        user.setId(1);
        user.setFullname("xyz");
        user.setUsername("xyzabc");
        user.setPassword("123456");
        user.setRole("ADMIN");
        String s = userController.addUser(user);
        Assert.assertEquals("user/add", s);
    }

    @Test
    public void validate_validateResponseURL() {
        User user = new User();
        user.setId(1);
        user.setFullname("xyz");
        user.setUsername("xyzabc");
        user.setPassword("123456");
        user.setRole("ADMIN");
        String s = userController.validate(user, bindingResult, model);
        Assert.assertEquals("redirect:/user/list", s);
    }


    @Test
    public void updateUser_validateResponseURL() {
        User user = new User();
        user.setId(1);
        user.setFullname("xyz");
        user.setUsername("xyzabc");
        user.setPassword("123456");
        user.setRole("ADMIN");
        String s = userController.updateUser(1, user, bindingResult, model);
        Assert.assertEquals("redirect:/user/list", s);
    }

    @Test
    public void deleteUser_validateResponseURL() {
        User user = new User();
        user.setId(1);
        user.setFullname("xyz");
        user.setUsername("xyzabc");
        user.setPassword("123456");
        user.setRole("ADMIN");
        Mockito.when(userService.getByIdUser(1)).thenReturn(user);
        String s = userController.deleteUser(1, model);
        Assert.assertEquals("redirect:/user/list", s);
    }
}