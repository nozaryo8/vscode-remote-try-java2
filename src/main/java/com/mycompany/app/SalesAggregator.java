package com.mycompany.app;

import java.lang.reflect.Constructor;
import java.util.*;


public class SalesAggregator {
    /**
     * 与えられた売上データから、日別売上合計を計算し、売上の多い順に並べて返す
     *
     * @param sales 売上データのリスト
     * @return 日別の売上合計リスト（降順にソート済み）
     */
    public List<Sales> aggregateByDate(List<Sales> sales) {

        // 反省会
        // 1, HashMapを使うと計算量を落とすことができる。
        // 前提: この関数の計算量はO(N^2) = この計算量は不合格
        // 
        // 2. テストケース
        // 空のデータ、NULLを入れるべき
        //
        // 3. バリデーション(優先度低)
        // NULL値
        //
        // 4. 想定質問
        // inputのデータが増えた時に何が起こるか?
        // →メモリ消費量が増える
        // 解決策→inputのデータを分割して、複数回に分けて関数を呼び出す
        //
        // この関数をAPIのレスポンスとして利用する場合の計算量削減
        // ReactiveProgramming
        // 一括ではなく、ちょっとずつレスポンスを返す
        // 
        // バッチの処理で利用する場合の計算量削減
        // 改善前のフロー: DBからデータを取り出す→計算・整形して保存し直す。
        // 改善後のフロー: 全件取り出すのではなく、ちょっとずつ呼び出して保存し直す。
        //
        // それぞれの計算量は?
        // ・forの計算量
        // ・sortの計算量
        // ・HashMapの計算量
        // 
        // キーワード: 空間計算量、時間計算量
        // 
        // 5. Javaの書き方を復習
        // neetcodeのeasyを複数問やる
        // sortの書き方をおぼえる
        // HashMap

        // 入力のバリデーション
        if (sales == null) {
            return new ArrayList<>();
        }

         // 日付をキー、売上合計を値とするMapを作成
        Map<Date, Integer> salesByDate = new HashMap<>();
        
        // 1回のループで日付ごとの合計を計算 - O(N)
        for (Sales sale : sales) {
            if (sale != null && sale.date != null && sale.amount != null) {
                // getOrDefaultを使って既存の合計に新しい金額を加算
                salesByDate.put(sale.date, salesByDate.getOrDefault(sale.date, 0) + sale.amount);
            }
        }

        // MapをListに変換
        List<Sales> aggregatedSales = new ArrayList<>();
        for (Map.Entry<Date, Integer> entry : salesByDate.entrySet()) {
            aggregatedSales.add(new Sales(entry.getKey(), entry.getValue()));
        }
        
        // 売上高で降順ソート - O(M log M), Mは一意な日付の数
        aggregatedSales.sort((a, b) -> Integer.compare(b.amount, a.amount));
        
        return aggregatedSales;
    }

    public static class Sales {
        Date date;
        Integer amount;
        public Sales(Date date, Integer amount) {
            this.date = date;
            this.amount = amount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sales sales = (Sales) o;
            return Objects.equals(date, sales.date) && 
                Objects.equals(amount, sales.amount);
        }
        
    }
}