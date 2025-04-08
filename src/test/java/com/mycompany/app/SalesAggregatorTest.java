package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// あなたはECサイトのバックエンドエンジニアです。
// 日々蓄積される売上データをもとに、日別の売上合計を計算する関数を実装してください。
// 入力：売上データの配列（各要素は date と amount を含むオブジェクト）
// 出力：date とその total を持つオブジェクトの配列（降順ソート済み）
// 同じ日付の売上は合算してください
// 日付は "YYYY-MM-DD" 形式です

public class SalesAggregatorTest {

    @Test
    void testAggregateByDate_basicCase() {
        SalesAggregator aggregator = new SalesAggregator();
        List<SalesAggregator.Sale> input = List.of(
                new SalesAggregator.Sale("2025-04-03", 500),
                new SalesAggregator.Sale("2025-04-03", 100),
                new SalesAggregator.Sale("2025-04-01", 1000)
        );

        List<SalesAggregator.DailyTotal> expected = List.of(
                new SalesAggregator.DailyTotal("2025-04-01", 1000),
                new SalesAggregator.DailyTotal("2025-04-03", 600)
        );

        List<SalesAggregator.DailyTotal> result = aggregator.aggregateByDate(input);
        assertEquals(expected, result);
    }
}
