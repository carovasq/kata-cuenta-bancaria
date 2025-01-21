package org.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class CuentaBancariaTestUnitario {

    private CuentaDeAhorros cuentaAhorros;

    @BeforeEach
    public void setUp() {
        // Inicializamos la cuenta de ahorros antes de cada prueba
        cuentaAhorros = new CuentaDeAhorros(15000, 12);  // Saldo inicial de 15000 y tasa anual del 12%
    }

    @Test
    public void testConsignar() {
        // Verificamos que al consignar, el saldo aumente
        cuentaAhorros.consignar(2000);
        assertEquals(17000, cuentaAhorros.getSaldo(), "El saldo debe aumentar después de consignar.");
    }

    @Test
    public void testRetirar() {
        // Verificamos que al retirar, el saldo disminuya
        cuentaAhorros.retirar(5000);
        assertEquals(10000, cuentaAhorros.getSaldo(), "El saldo debe disminuir después de retirar.");
    }

    @Test
    public void testRetiroSinSaldoSuficiente() {
        // Verificamos que no se pueda retirar más de lo que tiene en la cuenta
        cuentaAhorros.retirar(20000);
        assertEquals(15000, cuentaAhorros.getSaldo(), "El saldo no debe cambiar si no hay suficiente dinero.");
    }

    @Test
    public void testExtractoMensualConComision() {
        // Configuración inicial
        CuentaDeAhorros cuenta = new CuentaDeAhorros(15000, 12); // Saldo inicial 15000, tasa anual 12%

        // Realizar 6 retiros
        cuenta.retirar(1000); // Retiros 1-4 no tienen comisión adicional
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000); // Retiro 5
        cuenta.retirar(1000); // Retiro 6

        // Generar el extracto mensual
        cuenta.extractoMensual();

        // Verificar saldo final esperado
        float saldoEsperado = 7840.0f; // Calculado manualmente
        assertEquals(saldoEsperado, cuenta.getSaldo(), 0.01, "El saldo debe reflejar la comisión de más de 4 retiros.");
    }


}
