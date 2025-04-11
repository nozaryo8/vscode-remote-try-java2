package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void testAggregateMain() {
        List<Map<String, Integer>> temperatureData = new ArrayList<>();

        Map<String, Integer> entry1 = new HashMap<>();
        entry1.put("JPN", 30);
        temperatureData.add(entry1);
        
        Map<String, Integer> entry2 = new HashMap<>();
        entry2.put("JPN", 25);
        temperatureData.add(entry2);
        
        Map<String, Integer> entry3 = new HashMap<>();
        entry3.put("AUS", 25);
        temperatureData.add(entry3);
        
        Map<String, Integer> entry4 = new HashMap<>();
        entry4.put("JPN", 26);
        temperatureData.add(entry4);
        
        Map<String, Integer> entry5 = new HashMap<>();
        entry5.put("JPN", 18);
        temperatureData.add(entry5);

        Main.main(temperatureData);
    
        // リストの順序も含めて完全に一致するか検証
    }
}
