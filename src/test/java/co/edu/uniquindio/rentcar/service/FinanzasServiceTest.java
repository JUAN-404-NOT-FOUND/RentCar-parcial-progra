package co.edu.uniquindio.rentcar.service;

import co.edu.uniquindio.rentcar.model.SolicitudAlquilerDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanzasServiceTest {
    @Test
    void sumaIngresosDeReservasDentroDelPeriodo() {
        LocalDate inicio = LocalDate.of(2041, 3, 10);
        LocalDate fin = inicio.plusDays(1);
        SolicitudAlquilerDTO solicitud = new SolicitudAlquilerDTO(
                "PRUEBA-FIN-1", "DEMO-001", "KMS123",
                inicio, fin, "ECONOMICA", 0.0, List.of());

        AlquilerService.getInstancia().generarFacturaAlquiler(solicitud);

        double ingresos = FinanzasService.getInstancia()
                .calcularIngresosPeriodo(inicio, fin);

        assertEquals(195000.0, ingresos, 0.001);
    }
}
