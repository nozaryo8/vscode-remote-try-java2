package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


// あなたはECサイトのバックエンドエンジニアです。
// 日々蓄積される売上データをもとに、日別の売上合計を計算する関数を実装してください。
// 入力：売上データの配列（各要素は 日付 と 売り上げ を含むオブジェクト）
// 出力：日付とその日の売り上げ合計を持つオブジェクトの配列（売り上げで降順ソート済み）
// 同じ日付の売上は合算してください
// 日付は "YYYY-MM-DD" 形式です

public class SalesAggregatorTest {
    
    @Test
    void testAggregateByDate_basicCase() {
        SalesAggregator aggregator = new SalesAggregator();
        List<SalesAggregator.Sales> input = List.of(
            new SalesAggregator.Sales(parseDate("2025-04-09"), 10000), 
            new SalesAggregator.Sales(parseDate("2025-04-09"), 10000),
            new SalesAggregator.Sales(parseDate("2025-04-08"), 10000), 
            new SalesAggregator.Sales(parseDate("2025-04-08"), 10000), 
            new SalesAggregator.Sales(parseDate("2025-04-08"), 10000), 
            new SalesAggregator.Sales(parseDate("2025-04-07"), 10000));

        List<SalesAggregator.Sales> expected = List.of(
            new SalesAggregator.Sales(parseDate("2025-04-08"), 30000),
            new SalesAggregator.Sales(parseDate("2025-04-09"), 20000), 
            new SalesAggregator.Sales(parseDate("2025-04-07"), 10000) );
        
            List<SalesAggregator.Sales> result = aggregator.aggregateByDate(input);
    
        // サイズを確認
        assertEquals(3, result.size());
        
        // 内容を個別に確認
        assertSalesListContains(result, parseDate("2025-04-08"), 30000);
        assertSalesListContains(result, parseDate("2025-04-09"), 20000);
        assertSalesListContains(result, parseDate("2025-04-07"), 10000);
    }

    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("日付のパースに失敗しました: " + dateStr, e);
        }
    }

    // カスタムアサーションメソッド
    private void assertSalesListContains(List<SalesAggregator.Sales> salesList, Date date, int amount) {
        for (SalesAggregator.Sales sales : salesList) {
            if (sales.date.equals(date) && sales.amount.equals(amount)) {
                return; // 一致するものが見つかった
            }
        }
        fail("リストに以下の要素が含まれていません: 日付=" + date + ", 金額=" + amount);
    }
}
