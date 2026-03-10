import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        // API key desde variable de entorno (nunca hardcodeada)
        String apiKey = System.getenv("EXCHANGE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Error: no se encontró la variable de entorno EXCHANGE_API_KEY.");
            System.err.println("Defínela antes de ejecutar el programa:");
            System.err.println("  export EXCHANGE_API_KEY=\"tu_api_key\"  (Mac/Linux)");
            System.err.println("  set EXCHANGE_API_KEY=tu_api_key        (Windows cmd)");
            return;
        }

        ApiService apiService = new ApiService(apiKey);

        // Traemos solo las monedas que nos interesan
        List<Currency> currencies = apiService.fetchCurrencies();

        // Creamos el converter
        CurrencyConverter converter = new CurrencyConverter(currencies);

        while(flag){
            menu();
            int selection = scanner.nextInt();
            double amount, result;


            switch (selection){
                case 1: // USD -> ARS
                    System.out.print("Ingrese la cantidad en USD: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "USD", "ARS");
                    System.out.println(amount + " USD -> " + result + " ARS");
                    break;

                case 2: // ARS -> USD
                    System.out.print("Ingrese la cantidad en ARS: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "ARS", "USD");
                    System.out.println(amount + " ARS -> " + result + " USD");
                    break;

                case 3: // USD -> BRL
                    System.out.print("Ingrese la cantidad en USD: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "USD", "BRL");
                    System.out.println(amount + " USD -> " + result + " BRL");
                    break;

                case 4: // BRL -> USD
                    System.out.print("Ingrese la cantidad en BRL: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "BRL", "USD");
                    System.out.println(amount + " BRL -> " + result + " USD");
                    break;

                case 5: // USD -> COP
                    System.out.print("Ingrese la cantidad en USD: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "USD", "COP");
                    System.out.println(amount + " USD -> " + result + " COP");
                    break;

                case 6: // COP -> USD
                    System.out.print("Ingrese la cantidad en COP: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "COP", "USD");
                    System.out.println(amount + " COP -> " + result + " USD");
                    break;

                case 7: // USD -> MXN
                    System.out.print("Ingrese la cantidad en USD: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "USD", "MXN");
                    System.out.println(amount + " USD -> " + result + " MXN");
                    break;

                case 8: // MXN -> USD
                    System.out.print("Ingrese la cantidad en MXN: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "MXN", "USD");
                    System.out.println(amount + " MXN -> " + result + " USD");
                    break;

                case 9: // USD -> PEN
                    System.out.print("Ingrese la cantidad en USD: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "USD", "PEN");
                    System.out.println(amount + " USD -> " + result + " PEN");
                    break;

                case 10: // PEN -> USD
                    System.out.print("Ingrese la cantidad en PEN: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "PEN", "USD");
                    System.out.println(amount + " PEN -> " + result + " USD");
                    break;

                case 11: // MXN -> PEN
                    System.out.print("Ingrese la cantidad en MXN: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "MXN", "PEN");
                    System.out.println(amount + " MXN -> " + result + " PEN");
                    break;

                case 12: // PEN -> MXN
                    System.out.print("Ingrese la cantidad en PEN: ");
                    amount = scanner.nextDouble();
                    result = converter.convert(amount, "PEN", "MXN");
                    System.out.println(amount + " PEN -> " + result + " MXN");
                    break;

                case 13:
                    System.out.println("Saliendo...");
                    flag = false;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }


            System.out.println(); // línea en blanco para separar iteraciones
        }

        scanner.close();
    }

    public static void menu(){
        System.out.println("****************************************************");
        System.out.println("Sea bienvenido/a al conversor de monedas =]");
        System.out.println("1) Dolar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dolar");
        System.out.println("3) Dolar =>> Real Brasileño");
        System.out.println("4) Real Brasileño =>> Dolar");
        System.out.println("5) Dolar =>> Peso Colombiano");
        System.out.println("6) Peso Colombiano =>> Dolar");
        System.out.println("7) Dolar =>> Peso Mexicano");
        System.out.println("8) Peso Mexicano =>> Dolar");
        System.out.println("9) Dolar =>> Soles");
        System.out.println("10) Soles =>> Dolar");
        System.out.println("11) Pesos Mexicanos =>> Soles");
        System.out.println("12) Soles =>> Pesos Mexicanos");
        System.out.println("13) Salir");
        System.out.println("Elija una opcion valida: ");
        System.out.println("*****************************************************\n");
    }
}