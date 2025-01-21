# kata-cuenta-bancaria (*195)

Este proyecto simula un sistema de cuentas bancarias con distintos tipos de cuentas: `CuentaBancaria`, `CuentaDeAhorros` y `CuentaCorriente`. Cada clase tiene atributos y métodos que gestionan el saldo, las consignaciones, los retiros, las comisiones y el interés mensual. El sistema también incluye un conjunto de pruebas unitarias con cobertura mínima del 70%.

## Descripción del Proyecto

El programa modela una cuenta bancaria con los siguientes atributos y métodos:

### Clase `CuentaBancaria` (Clase Base)
Representa una cuenta bancaria general con los siguientes atributos:
- **saldo**: Saldo de la cuenta (float).
- **numeroDeConsignaciones**: Número de consignaciones realizadas (int).
- **numeroDeRetiros**: Número de retiros realizados (int).
- **tasaAnual**: Tasa anual (float).
- **comisionMensual**: Comisión mensual (float).

Métodos principales:
- `consignar(float cantidad)`: Consigna una cantidad de dinero en la cuenta.
- `retirar(float cantidad)`: Realiza un retiro de dinero (no puede superar el saldo).
- `calcularInteresMensual()`: Calcula el interés mensual y actualiza el saldo.
- `extractoMensual()`: Actualiza el saldo restando la comisión mensual y calculando el interés mensual.
- `imprimir()`: Imprime los valores de los atributos de la cuenta.

### Clase `CuentaDeAhorros` (Hija de `CuentaBancaria`)
Representa una cuenta de ahorros con un atributo adicional que determina si la cuenta está activa:
- **estadoActivo**: Indica si la cuenta está activa (booleano).

Métodos redefinidos:
- `consignar(float cantidad)`: Solo se puede consignar si la cuenta está activa.
- `retirar(float cantidad)`: Solo se puede retirar si la cuenta está activa.
- `extractoMensual()`: Si el número de retiros es mayor a 4, se cobra una comisión adicional por cada retiro.
- `imprimir()`: Imprime el saldo de la cuenta, la comisión mensual y el número de transacciones.

### Clase `CuentaCorriente` (Hija de `CuentaBancaria`)
Representa una cuenta corriente con un atributo adicional de sobregiro:
- **sobregiro**: Representa el monto que la cuenta está en deuda (float).

Métodos redefinidos:
- `retirar(float cantidad)`: Permite retirar dinero incluso si el saldo es insuficiente, y el monto restante se convierte en sobregiro.
- `consignar(float cantidad)`: Reduce el sobregiro si es necesario.
- `extractoMensual()`: Realiza el extracto mensual según las condiciones.
- `imprimir()`: Imprime el saldo, la comisión mensual, el número de transacciones y el valor de sobregiro.

## Requisitos

- **Java 11 o superior**
- **JUnit 5** (para pruebas unitarias)
- **Maven** (para gestión de dependencias)

## Instrucciones de Uso

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/carovasq/kata-cuenta-bancaria.git