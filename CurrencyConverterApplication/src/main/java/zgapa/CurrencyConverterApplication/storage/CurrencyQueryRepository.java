package zgapa.CurrencyConverterApplication.storage;
import org.springframework.data.jpa.repository.JpaRepository;
import zgapa.CurrencyConverterApplication.model.CurrencyQuery;

public interface CurrencyQueryRepository extends JpaRepository<CurrencyQuery, Long> {
}
