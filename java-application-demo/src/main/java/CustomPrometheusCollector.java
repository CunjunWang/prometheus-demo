import io.prometheus.client.Collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CunjunWang on 2020/6/17.
 */
public class CustomPrometheusCollector extends Collector {

    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> metricFamilySamples = new ArrayList<MetricFamilySamples>();

        String metricName = "my_guage_1";

        // code to get metrics
        MetricFamilySamples.Sample sample1 = new MetricFamilySamples.Sample(
                metricName, Arrays.asList("label1"), Arrays.asList("value1"), 10);
        MetricFamilySamples.Sample sample2 = new MetricFamilySamples.Sample(
                metricName, Arrays.asList("label1", "label2"), Arrays.asList("value1", "value2"), 5);

        MetricFamilySamples samples = new MetricFamilySamples(metricName, Type.GAUGE,
                "this is a demo metric data", Arrays.asList(sample1, sample2));

        metricFamilySamples.add(samples);

        return metricFamilySamples;
    }

}
