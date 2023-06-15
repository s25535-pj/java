package zgapa.CurrencyConverterApplication.Notatki;

public class notatki {

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<String> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
//    }

//    public class CurrencyNotFoundException extends RuntimeException {
//        public CurrencyNotFoundException(String errorMessage) {
//            super(errorMessage);
//        }
//    }

//        try {
//            CurrencyRate currencyRate = restTemplate.getForObject(apiUrl, CurrencyRate.class);
//            if (currencyRate != null) {
//                System.out.println("works");
//                float rate = currencyRate.getRate();
//                String currency2 = currencyRate.getCurrency();
//                System.out.println(currency2);
//                saveCurrencyQuery(currency, days, rate);
//                System.out.println(rate);
//                return rate;
//
//            }
//        } catch (Exception e) {
//            throw new CurrencyNotFoundException("No data found for the specified currency or date range.");
//        }



    //public class CurrencyRate {
//    @JsonProperty("mid")
//    private float rate;
//
//    @JsonProperty("rates")
//    private float rates;
//
//    @JsonProperty("currency")
//    private String currency;
//
//    public float getRate() {
//        return rate;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setRate(float rate) {
//        this.rate = rate;
//    }
//}
}
