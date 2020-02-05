package com.springfxsecurity.springfxsecurity.controllers;

import com.springfxsecurity.springfxsecurity.configuration.StageManager;
import com.springfxsecurity.springfxsecurity.emuns.FxmlView;
import com.springfxsecurity.springfxsecurity.entities.Role;
import com.springfxsecurity.springfxsecurity.entities.RoleName;
import com.springfxsecurity.springfxsecurity.entities.User;
import com.springfxsecurity.springfxsecurity.repositories.IRoleRepository;
import com.springfxsecurity.springfxsecurity.services.IUserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


@Controller
@Slf4j
public class LoginController implements Initializable {


    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label lblLogin;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    PasswordEncoder encoder;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private void login(ActionEvent event) throws IOException {

        try {
            Authentication request = new UsernamePasswordAuthenticationToken(getUsername(), getPassword());
            Authentication result = authManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            lblLogin.setText(userService.test());
            log.info(userService.customFind((long)(1)).getName());



        } catch (AuthenticationException e) {
            lblLogin.setText("Login Failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getPassword() {
        return password.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        User user = new User();
        user.setName("fdsfds");
        user.setEmail("dsfds@hotmail.com");
        user.setPassword("2");
        user.setUsername("dfd");

        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
