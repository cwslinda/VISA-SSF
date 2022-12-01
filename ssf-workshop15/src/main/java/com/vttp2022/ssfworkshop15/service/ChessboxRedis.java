package com.vttp2022.ssfworkshop15.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vttp2022.ssfworkshop15.model.ChessMain;

@Service
public class ChessboxRedis implements ChessboxRepo {
    private static final Logger logger = LoggerFactory.getLogger(ChessboxRedis.class);
   
    @Autowired 
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(final ChessMain chessbox){
        redisTemplate.opsForValue().set(chessbox.getName(), chessbox);
    }

    @Override
    public ChessMain findById(final String chessName){
        ChessMain result = (ChessMain) redisTemplate.opsForValue().get(chessName);
        return result;
    }
}
