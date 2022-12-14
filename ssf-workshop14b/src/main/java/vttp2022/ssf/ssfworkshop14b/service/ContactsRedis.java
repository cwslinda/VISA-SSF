package vttp2022.ssf.ssfworkshop14b.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import vttp2022.ssf.ssfworkshop14b.model.Contact;

@Service
public class ContactsRedis implements ContactsRepo {
    private static final Logger logger = LoggerFactory.getLogger(ContactsRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(final Contact contact){
        redisTemplate.opsForValue().set(contact.getId(), contact);
    }

    @Override
    public Contact findById(final String contactid){
        Contact result = (Contact) redisTemplate.opsForValue().get(contactid);
        logger.info(">>>" + result.getEmail());
        return result;
    }

}
