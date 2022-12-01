package com.vttp2022.ssfworkshop15.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfworkshop15.service.ChessboxRedis;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path="/api/boardgame", produces="application/json")
public class GameController {
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    ChessboxRedis service;


    @PostMapping( consumes = "application/json")
    public ResponseEntity<String> postGame(@RequestBody String payload) throws IOException {
        JsonObject body;
        URI location;


        try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
            JsonReader reader = Json.createReader(is);
            body = reader.readObject();
            location = new URI("/api/boardgame");

            //gamesvc.save(body);
        } catch (Exception e) {
            body = Json.createObjectBuilder()
                       .add("error", e.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
        
        // build json object with payload
        // save
        return ResponseEntity.created(location).body(body.toString());
    }
}
    
    /*@GetMapping(path="/boardgame/{id}")
    public ResponseEntity<String> getGame(@PathVariable String chessName) {
        
        final Chessbox cb = service.findById(chessName);

        final JsonObject resp = Json.createObjectBuilder()
                                .add("name", cb.getName())
                                .add("pieces", (JsonValue) cb.getPieces())
                                .add("board", Json.createObjectBuilder()
                                .add("totalCount", (JsonValue) cb.getPieces().getBoard())
                                .add("size", cb.getPieces().getBoard().getSize().
                                ).build()
    }*/

    
