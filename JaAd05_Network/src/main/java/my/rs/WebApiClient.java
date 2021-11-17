package my.rs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

public class WebApiClient {

    public static void main(String[] args) {
        String url = "http://yand.dyndns.org/api/tickers.aspx";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);

//        String result = target.request().get(String.class);
//        System.out.println(result);

//        StockData[] data = target.request().get(StockData[].class);
        List<StockData> data = target.request()
                            .get(new GenericType<List<StockData>>(){});
        for(var sd: data) {
            System.out.println(sd.getTicker() + " текщий курс: " + sd.getValue());
        }


        client.close();
    }

}

class StockData {
    private String ticker;
    private int value;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
