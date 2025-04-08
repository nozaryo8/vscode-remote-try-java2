package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

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
