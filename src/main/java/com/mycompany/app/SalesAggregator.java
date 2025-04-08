package com.mycompany.app;

import java.util.*;

public class SalesAggregator {

    public static class Sale {
        public String date;
        public int amount;

        public Sale(String date, int amount) {
            this.date = date;
            this.amount = amount;
        }
    }

    public static class DailyTotal {
        public String date;
        public int total;

        public DailyTotal(String date, int total) {
            this.date = date;
            this.total = total;
        }

        @Override
        public String toString() {
            return "DailyTotal{" +
                    "date='" + date + '\'' +
                    ", total=" + total +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DailyTotal)) return false;
            DailyTotal that = (DailyTotal) o;
            return total == that.total && Objects.equals(date, that.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, total);
        }
    }

    /**
     * 与えられた売上データから、日別売上合計を計算し、売上の多い順に並べて返す
     *
     * @param sales 売上データのリスト
     * @return 日別の売上合計リスト（降順にソート済み）
     */
    public List<DailyTotal> aggregateByDate(List<Sale> sales) {
        return new ArrayList<>();
    }
}
