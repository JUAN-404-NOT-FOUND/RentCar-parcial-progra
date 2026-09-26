package co.edu.uniquindio.rentcar.service;

import co.edu.uniquindio.rentcar.model.ModalidadEconomica;
import co.edu.uniquindio.rentcar.model.Reserva;
import co.edu.uniquindio.rentcar.model.ServicioAdicional;
import co.edu.uniquindio.rentcar.model.Vehiculo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiquidadorFinancieroTest {
    @Test
    void calculaTarifaPorDiasMasServiciosMenosDescuento() {
        Reserva reserva = new Reserva();
        reserva.setFechaInicio(LocalDate.of(2040, 2, 1));
        reserva.setFechaFin(LocalDate.of(2040, 2, 3));
        reserva.setVehiculo(new Vehiculo("TEST01", "Marca", "Modelo", 2040, "Prueba", 100.0));
        reserva.setModalidad(new ModalidadEconomica(
                "MOD-TEST", "Económica", "Prueba", 1, 50.0, "Disponible"));
        reserva.setServiciosSeleccionados(List.of(
                new ServicioAdicional("SERV-TEST", "GPS", "Prueba", 20.0, true)));
        reserva.setDescuento(10.0);

        assertEquals(310.0, LiquidadorFinanciero.calcularTotalReserva(reserva), 0.001);
    }

    @Test
    void devuelveCeroSiLaReservaEsNula() {
        assertEquals(0.0, LiquidadorFinanciero.calcularTotalReserva(null));
    }
}
