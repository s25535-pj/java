package zgapa.CurrencyConverterApplication.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CurrencyQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id zapytania", example = "1")
    private Long id;

    @Schema(description = "Kod waluty", example = "USD")
    private String currency;

    @Schema(description = "Z ilu dni średnia została wyliczona", minimum = "1", example = "7")
    private int days;

    @Schema(description = "Wartość średniej", example = "4.52")
    private double rate;

    @Schema(description = "Znacznik czasu kiedy wykonano zapytanie")
    private LocalDateTime timestamp;

    public CurrencyQuery() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public int getDays() {
        return days;
    }

    public double getRate() {
        return rate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
