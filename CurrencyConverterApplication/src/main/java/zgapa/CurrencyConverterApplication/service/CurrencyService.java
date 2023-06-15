package zgapa.CurrencyConverterApplication.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zgapa.CurrencyConverterApplication.exceptions.WrongInputException;
import zgapa.CurrencyConverterApplication.model.CurrencyQuery;
import zgapa.CurrencyConverterApplication.storage.CurrencyQueryRepository;

import java.util.Objects;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;
    private final CurrencyQueryRepository currencyQueryRepository;

    public CurrencyService(RestTemplate restTemplate, CurrencyQueryRepository currencyQueryRepository) {
        this.restTemplate = restTemplate;
        this.currencyQueryRepository = currencyQueryRepository;
    }

    public CurrencyQuery getCurrencyQuery(String currency, int days) {
//        http://api.nbp.pl/api/exchangerates/rates/A/EUR/last/1/?format=json
        if(days <= 0){
            throw new WrongInputException("Dni muszą mieć wartość minimalnie 1");
        }
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + currency + "/last/" + days + "?format=json";
        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
//            przelecJSONa(rootNode);

            int i = days;
            double sum = 0;
            double rate;
            while(i > 0) {
                rate = rootNode.get("rates").get(i-1).get("mid").asDouble();
                sum = sum + rate;
                System.out.println(rate);
                i--;
            }
            double averageRate = sum/days;
            return createCurrencyQuery(currency, days, averageRate);

        } catch (Exception e) {
            throw new WrongInputException("Waluta nie taka");
        }
    }

    private CurrencyQuery createCurrencyQuery(String currency, int days, double rate) {
        CurrencyQuery currencyQuery = new CurrencyQuery();
        currencyQuery.setCurrency(currency);
        currencyQuery.setDays(days);
        currencyQuery.setRate(rate);
        currencyQueryRepository.save(currencyQuery);

        return currencyQuery;
    }

    private void przelecJSONa(JsonNode rootNode){

        // Cały JSON otrzymany jako string z endpointu GET
        System.out.println(rootNode);

        // Wyciąganie wartości currency jako text
        String currencyFullName = rootNode.get("currency").asText();
        System.out.println(currencyFullName);

        // Wchodzimy w tablicę rates; kolejne indexy tablicy (w tym przypadku tylko pierwszy element);
        // element w tablicy o kluczu "mid"; jako wartość Double
        double rate = rootNode.get("rates").get(0).get("mid").asDouble();
        System.out.println(rate);
    }
}