import io.prometheus.client.Gauge;

/**
 * Created by CunjunWang on 2020/6/17.
 */
public class CustomGauge {

    private final Gauge inProgressRequests;

    public CustomGauge() {
        inProgressRequests = Gauge
                .build()
                .name("in_progress_requests")
                .labelNames("method")
                .help("Gauge for in progress requests.")
                .register();
    }

    void processRequest() {
        inProgressRequests.inc();
        System.out.println("Processing the request...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Process finished");
        inProgressRequests.dec();
    }

}
