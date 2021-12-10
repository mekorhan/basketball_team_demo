package com.producter.demo.controller;

import com.producter.demo.entity.model.PlayerModel;
import com.producter.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<Object> addPlayer(@RequestBody PlayerModel player) {
        try {
            return ResponseEntity.ok(playerService.addPlayer(player));
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e1) {
            return new ResponseEntity<>(e1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<PlayerModel>> inquireAllPlayers() {
        return ResponseEntity.ok(playerService.inquireAllPlayers());
    }
}
