package com.niq.dataTeam.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niq.dataTeam.Dto.ProductDto;
import com.niq.dataTeam.Dto.ShopperPersonalizedProductListDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final String QUEUE_NAME = "product-queue";
    private static final String QUEUE_NAME2 = "shopper-queue";

    public String saveProduct( ProductDto productDto) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(productDto);
            rabbitTemplate.convertAndSend(QUEUE_NAME, jsonMessage);

        } catch (Exception e){
            e.printStackTrace();
        }
        return "Message sent to RabbitMQ: " + productDto.toString();
    }

    @Override
    public String saveShopperPersonalizedProduct(ShopperPersonalizedProductListDto shopperPersonalizedProductListDto) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(shopperPersonalizedProductListDto);
            rabbitTemplate.convertAndSend(QUEUE_NAME2, jsonMessage);

        } catch (Exception e){
            e.printStackTrace();
        }
        return "Message sent to RabbitMQ";
    }
}
