package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    private CuentaCorriente cuenta;


    @BeforeEach
    void setUp() {
        // Inicializar una cuenta corriente con saldo de 5000 y tasa anual del 5%
        cuenta = new CuentaCorriente(5000f, 5f);
    }



    @Test
    void testRetirar() {
        cuenta.retirar(2000f);

        assertEquals(3000f, cuenta.getSaldo(), 0.01);
        assertEquals(1, cuenta.getNumeroDeRetiros());
    }

    @Test
    void testSobregiro() {
        cuenta.retirar(6000f);

        assertEquals(0f, cuenta.getSaldo(), 0.01);
        assertEquals(1, cuenta.getNumeroDeRetiros());
        assertTrue(cuenta.toString().contains("Sobregiro: 1000.0"));
    }

    @Test
    void testSobregiroCombinado() {
        cuenta.retirar(3000f);
        cuenta.retirar(3000f);

        assertEquals(0f, cuenta.getSaldo(), 0.01);
        assertEquals(2, cuenta.getNumeroDeRetiros());
        assertTrue(cuenta.toString().contains("Sobregiro: 1000.0"));
    }

    @Test
    void testExtractoMensual() {
        cuenta.consignar(2000f);
        cuenta.retirar(3000f);

        cuenta.extractoMensual();

        assertTrue(cuenta.getSaldo() > 4000f);
        assertTrue(cuenta.getSaldo() <= 7000f);
    }

    @Test
    void testSobregiroEnExtracto() {
        cuenta.retirar(6000f);

        cuenta.extractoMensual();

        assertTrue(cuenta.getSaldo() >= 0);
    }

}
