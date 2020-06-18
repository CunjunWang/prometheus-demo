import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

/**
 * Created by CunjunWang on 2020/6/17.
 */
public class CustomExporter {

    public static void main(String[] args) {
        try {
            // register the custom collector
            new CustomPrometheusCollector().register();
            CustomGauge gauge = new CustomGauge();
            HTTPServer server = new HTTPServer(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
