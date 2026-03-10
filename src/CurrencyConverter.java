import java.util.List;


public class CurrencyConverter {

    private final List<Currency> currencies;

    public CurrencyConverter(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public double convert(double amount, String fromCode, String toCode) {
        // Buscar moneda origen
        Currency from = currencies.stream()
                .filter(c -> c.code().equalsIgnoreCase(fromCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Moneda origen no encontrada: " + fromCode));

        // Buscar moneda destino
        Currency to = currencies.stream()
                .filter(c -> c.code().equalsIgnoreCase(toCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Moneda destino no encontrada: " + toCode));

        // Fórmula: amount * (rateDestino / rateOrigen)
        return amount * (to.rate() / from.rate());
    }
}
