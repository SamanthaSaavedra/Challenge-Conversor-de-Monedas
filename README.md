# 💱 Conversor de Monedas

Aplicación de consola desarrollada en **Java** que permite convertir entre distintas monedas latinoamericanas en tiempo real, consumiendo la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## 🚀 ¿Qué hace?

Al ejecutar el programa, se muestra un menú interactivo donde el usuario elige el par de monedas que desea convertir, ingresa el monto y obtiene el resultado al instante con tasas de cambio actualizadas.

```
****************************************************
Sea bienvenido/a al conversor de monedas =]
1) Dolar =>> Peso Argentino
2) Peso Argentino =>> Dolar
3) Dolar =>> Real Brasileño
4) Real Brasileño =>> Dolar
5) Dolar =>> Peso Colombiano
6) Peso Colombiano =>> Dolar
7) Dolar =>> Peso Mexicano
8) Peso Mexicano =>> Dolar
9) Dolar =>> Soles
10) Soles =>> Dolar
11) Pesos Mexicanos =>> Soles
12) Soles =>> Pesos Mexicanos
13) Salir
****************************************************
```

---

## 🌎 Monedas soportadas

| Código | Moneda               | País            |
|--------|----------------------|-----------------|
| USD    | Dólar                | Estados Unidos  |
| ARS    | Peso Argentino       | Argentina       |
| BRL    | Real                 | Brasil          |
| COP    | Peso Colombiano      | Colombia        |
| MXN    | Peso Mexicano        | México          |
| PEN    | Sol                  | Perú            |

---

## 🛠️ Tecnologías utilizadas

- **Java** (JDK 17+)
- **Gson** — para parsear las respuestas JSON de la API
- **ExchangeRate-API** — fuente de tasas de cambio en tiempo real
- **HttpURLConnection** — para hacer las peticiones HTTP sin librerías externas

---

## 📁 Estructura del proyecto

```
src/
├── Main.java              # Punto de entrada, menú y lógica de navegación
├── ApiService.java        # Conexión a la API y parseo de tasas de cambio
├── CurrencyConverter.java # Lógica de conversión entre monedas
└── Currency.java          # Record que representa una moneda (código + tasa)
```

### Descripción de cada clase

- **`Main.java`** — Muestra el menú en un bucle, lee la opción del usuario y llama al conversor con los parámetros correctos.
- **`ApiService.java`** — Hace una petición GET a la API, filtra solo las monedas permitidas y devuelve una lista de objetos `Currency`.
- **`CurrencyConverter.java`** — Recibe la lista de monedas y aplica la fórmula de conversión: `monto × (tasa_destino / tasa_origen)`.
- **`Currency.java`** — Record inmutable con dos campos: `code` (ej. `"USD"`) y `rate` (tasa respecto al dólar).

---

## ⚙️ Cómo ejecutarlo

### Requisitos previos

- Java JDK 17 o superior instalado
- La librería `gson` en el classpath (puedes descargarla desde [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson))

### Pasos

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-monedas.git
   cd conversor-de-monedas
   ```

2. **Compila el proyecto** (asegúrate de incluir Gson en el classpath)
   ```bash
   javac -cp gson-2.10.1.jar src/*.java -d out/
   ```

3. **Ejecuta la aplicación**
   ```bash
   java -cp out/:gson-2.10.1.jar Main
   ```

> 💡 Si usas **IntelliJ IDEA**, solo abre el proyecto y agrega Gson como dependencia en `File > Project Structure > Libraries`. Luego corre `Main.java` directamente.

---

## 🔑 API Key

El proyecto usa la API de **ExchangeRate-API**. La clave está definida directamente en `Main.java`:

```java
String apiKey = "TU_API_KEY_AQUÍ";
```

Puedes obtener tu propia clave gratuita en [exchangerate-api.com](https://www.exchangerate-api.com/) y reemplazarla ahí.

> ⚠️ Se recomienda no subir tu API key directamente en el código fuente en proyectos públicos. Considera moverla a una variable de entorno o archivo de configuración.

---

## 💡 Ejemplo de uso

```
Elija una opcion valida:
> 7

Ingrese la cantidad en USD: 100

100.0 USD -> 1720.5 MXN
```

---

## 🧩 Posibles mejoras futuras

- [ ] Agregar soporte para más monedas
- [ ] Manejo de errores más amigable para entradas inválidas
- [ ] Exportar historial de conversiones a un archivo `.txt`
- [ ] Interfaz gráfica con JavaFX o Swing
- [ ] Mover la API key a variables de entorno

---

## 👤 Autor

Desarrollado como parte del **Challenge Conversor de Monedas** de Alura Latam + Oracle Next Education (ONE).
