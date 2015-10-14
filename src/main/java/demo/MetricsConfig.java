package demo;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import org.springframework.boot.actuate.autoconfigure.ExportMetricReader;
import org.springframework.boot.actuate.metrics.reader.MetricReader;
import org.springframework.boot.actuate.metrics.reader.MetricRegistryMetricReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
    @Bean
    @ExportMetricReader
    public MetricReader metricReader() {
        return new MetricRegistryMetricReader(metricRegistry());
    }

    public MetricRegistry metricRegistry() {
        final MetricRegistry metricRegistry = new MetricRegistry();

        metricRegistry.register("jvm.gc",new GarbageCollectorMetricSet());
        metricRegistry.register("jvm.mem",new MemoryUsageGaugeSet());
        metricRegistry.register("jvm.thread-states",new ThreadStatesGaugeSet());
        return metricRegistry;
    }
}
