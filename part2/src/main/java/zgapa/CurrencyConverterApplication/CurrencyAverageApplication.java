package zgapa.CurrencyConverterApplication;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;


    @SpringBootApplication
    public class CurrencyAverageApplication {

        public static void main(String[] args) {
            SpringApplication.run(CurrencyAverageApplication.class, args);
        }
    }

    @RestController
    class CurrencyController {

        private final CurrencyService currencyService;

        @Autowired
        public CurrencyController(CurrencyService currencyService) {
            this.currencyService = currencyService;
        }

        @GetMapping("/currency/{code}")
        public ResponseEntity<Double> getAverageCurrencyRate(
                @PathVariable("code") String currencyCode,
                @RequestParam(value = "days", defaultValue = "1") int numberOfDays) {

            double averageRate = currencyService.calculateAverageRate(currencyCode, numberOfDays);
            return ResponseEntity.ok(averageRate);
        }

        @ExceptionHandler(CurrencyNotFoundException.class)
        public ResponseEntity<String> handleCurrencyNotFoundException(CurrencyNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(InvalidNumberOfDaysException.class)
        public ResponseEntity<String> handleInvalidNumberOfDaysException(InvalidNumberOfDaysException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Service
    class CurrencyService {

        private static final String NBP_API_URL = "http://api.nbp.pl/api/exchangerates/rates/a/%s/last/%d/?format=json";

        private final CurrencyQueryRepository currencyQueryRepository;

        @Autowired
        public CurrencyService(CurrencyQueryRepository currencyQueryRepository) {
            this.currencyQueryRepository = currencyQueryRepository;
        }

        public double calculateAverageRate(String currencyCode, int numberOfDays) {
            validateNumberOfDays(numberOfDays);
            CurrencyQuery currencyQuery = saveCurrencyQuery(currencyCode, numberOfDays);
            List<Double> rates = fetchRatesFromNBP(currencyCode, numberOfDays);
            double averageRate = rates.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
            currencyQuery.setAverageRate(averageRate);
            currencyQueryRepository.save(currencyQuery);
            return averageRate;
        }

        private void validateNumberOfDays(int numberOfDays) {
            if (numberOfDays <= 0) {
                throw new InvalidNumberOfDaysException("Number of days must be greater than zero.");
            }
        }

        private CurrencyQuery saveCurrencyQuery(String currencyCode, int numberOfDays) {
            CurrencyQuery currencyQuery = new CurrencyQuery(currencyCode, numberOfDays);
            return currencyQueryRepository.save(currencyQuery);
        }

        private List<Double> fetchRatesFromNBP(String currencyCode, int numberOfDays) {
            String url = String.format(NBP_API_URL, currencyCode, numberOfDays);
            RestTemplate restTemplate = new RestTemplate();
            NbpResponse nbpResponse = restTemplate.getForObject(url, NbpResponse.class);
            if (nbpResponse == null || nbpResponse.getRates() == null || nbpResponse.getRates().isEmpty()) {
                throw new CurrencyNotFoundException("Currency data not found for code: " + currencyCode);
            }
            return nbpResponse.getRates();
        }
    }

    @Repository
    interface CurrencyQueryRepository extends JpaRepository<CurrencyQuery, Long> {
    }

    @Entity
    @Table(name = "currency_queries")
    class CurrencyQuery {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String currencyCode;

        private int numberOfDays;

        private double averageRate;

        @Temporal(TemporalType.TIMESTAMP)
        private Date queryDateTime;

        public CurrencyQuery() {
            this.queryDateTime = new Date();
        }

        public CurrencyQuery(String currencyCode, int numberOfDays) {
            this();
            this.currencyCode = currencyCode;
            this.numberOfDays = numberOfDays;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public int getNumberOfDays() {
            return numberOfDays;
        }

        public void setNumberOfDays(int numberOfDays) {
            this.numberOfDays = numberOfDays;
        }

        public double getAverageRate() {
            return averageRate;
        }

        public void setAverageRate(double averageRate) {
            this.averageRate = averageRate;
        }

        public Date getQueryDateTime() {
            return queryDateTime;
        }

        public void setQueryDateTime(Date queryDateTime) {
            this.queryDateTime = queryDateTime;
        }
    }

    class NbpResponse {

        private List<Double> rates;

        public List<Double> getRates() {
            return rates;
        }

        public void setRates(List<Double> rates) {
            this.rates = rates;
        }

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class CurrencyNotFoundException extends RuntimeException {

        public CurrencyNotFoundException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    class InvalidNumberOfDaysException extends RuntimeException {

        public InvalidNumberOfDaysException(String message) {
            super(message);
        }
    }

}
