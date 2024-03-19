package com.jack.engineeringassessment.controller;

import com.jack.engineeringassessment.vo.Food;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class FoodController {
    static Map<String, Food> map = new HashMap<>();

    static {
        map.put("shanghai", Food.builder().key(UUID.randomUUID().toString()).name("milk tea").price(BigDecimal.valueOf(11)).build());
        map.put("nanjing", Food.builder().key(UUID.randomUUID().toString()).name("duck").price(BigDecimal.valueOf(29)).build());
        map.put("beijing", Food.builder().key(UUID.randomUUID().toString()).name("barbecued duck").price(BigDecimal.valueOf(120)).build());
    }

    @GetMapping("/getFood")
    public ResponseEntity<List<Food>> getFood(String city) {
        if (!map.containsKey(city)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(List.of(map.get(city)).stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }
}
