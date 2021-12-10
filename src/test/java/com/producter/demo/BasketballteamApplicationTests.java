package com.producter.demo;

import com.producter.demo.constants.Constants;
import com.producter.demo.controller.PlayerController;
import com.producter.demo.entity.model.PlayerModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasketballteamApplicationTests {

    @Autowired
    PlayerController playerController;

    @Test
    void contextLoads() {
    }
}
