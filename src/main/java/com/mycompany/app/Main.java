package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
        /*

    [
    {"JPN": 30},
    {"JPN": 25},
    {"AUS": 25},
    {"JPN": 26},
    {"JPN": 18}
    ]

    タスク1：すべての温度データの出力
    すべての温度エントリーを「国コード: 温度」の形式で出力してください。
    */
    public void main (List<Map<String, Integer>> args) {
        
        // Create sample data using a List of HashMaps
        List<Map<String, Integer>> temperatureData = new ArrayList<>();
        
        // Add temperature entries
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

        // [{"JPN": 30},{"JPN": 25},{"AUS": 25}, {"JPN": 26}, {"JPN": 18}]
        // タスク1：すべての温度データの出力
        // すべての温度エントリーを「国コード: 温度」の形式で出力してください。
        for (Map<String, Integer> arg : args) {
            System.out.println(arg.entrySet());
        }

        // タスク2：各国の最新温度の出力
        // 各国の最新（配列内で最後に出現する）温度エントリーを出力してください。複数の国が// ある場合は、すべての国の最新データを出力してください。

        Map<String, Integer> task2 = new HashMap<>();
        for (Map<String, Integer>arg : args) {
            arg.forEach((key, value) -> {
                task2.put(key ,value);
            });
            // もしくは上の代わりに下記でも実装可能
            // task2.putAll(arg);
        }	
        System.out.println(task2.entrySet());
        


        // タスク3：最高温度と最低温度の出力
        // データセット内の最高温度と最低温度を見つけ、それぞれの国コードと共に出力してください。

        Map<String, Integer> hiTemperatureData = new HashMap<>();
        Map<String, Integer> lowTemperatureData = new HashMap<>();

        // 時間計算量: O(N×M) - Nはマップの数、Mは各マップの平均エントリ数
        // 空間計算量: O(1) - 追加のメモリをほとんど消費しない(ラムダ用のわずかなメモリのみ 2重for文と比べて少しだけオーバーヘッドが長い)
        for (Map<String, Integer>arg : args) {
            arg.forEach((key, value) -> {
                if(!hiTemperatureData.containsKey(key) || hiTemperatureData.get(key) < value) {
                    hiTemperatureData.put(key ,value);
                } 

                if( !lowTemperatureData.containsKey(key) || lowTemperatureData.get(key) < value) {
                    lowTemperatureData.put(key ,value);
                } 
            });
            // arg.forEach((key, value) -> {
            //     if(!hiTemperatureData.containsKey(key) ) {
            //         hiTemperatureData.put(key ,value);
            //     } else if (hiTemperatureData.get(key) > value) {
            //         hiTemperatureData.put(key ,value);
            //     }
            //     if(!lowTemperatureData.containsKey(key) ) {
            //         lowTemperatureData.put(key ,value);
            //     } else if (lowTemperatureData.get(key) > value) {
            //         lowTemperatureData.put(key ,value);
            //     }
            // });
        }
        // HashMap 
        // ArrayList

        System.out.println(hiTemperatureData.entrySet());
        System.out.println(lowTemperatureData.entrySet());
    }

}
