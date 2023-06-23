package zgapa.CurrencyConverterApplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zgapa.CurrencyConverterApplication.model.CurrencyQuery;
import zgapa.CurrencyConverterApplication.service.CurrencyService;


@RestController
@RequestMapping()
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Zwóć średnią cenę danej waluty z x ostatnich dni", method = "GET",
            description = "Podaj ilość dni i kod waluty a przepowiem czy przeszłość.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Średnia zwórcona pomyślnie",
                    content = {@Content(schema = @Schema(implementation = CurrencyQuery.class), mediaType = "application/json")}),

            @ApiResponse(responseCode = "400",
                    description = "Błędne dane (prawdopodobnie błędna ilość dni)",
                    content = {@Content()}),

            @ApiResponse(responseCode = "404",
                    description = "Błędne dane, (prawdopodobnie błędna waluta)",
                    content = {@Content()}),

            @ApiResponse(responseCode = "504",
                    description = "Server banku zdech",
                    content = {@Content()})
    })

    @GetMapping("/currency/{currency}")
    public ResponseEntity<CurrencyQuery> getCurrencyQuery(@PathVariable String currency, @RequestParam(required = false, defaultValue = "1") int days) {
        return ResponseEntity.ok(currencyService.getCurrencyQuery(currency, days));
    }
}
