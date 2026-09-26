package co.edu.uniquindio.rentcar.service;

import co.edu.uniquindio.rentcar.model.Cliente;
import co.edu.uniquindio.rentcar.repository.IRentCarRepository;
import co.edu.uniquindio.rentcar.repository.RentCarRepository;

import java.util.List;

public class ClienteService {
    private static ClienteService instancia;
    private final IRentCarRepository rentCarRepository;

    private ClienteService() {
        this.rentCarRepository = RentCarRepository.getInstancia();
        inyectarDatosSemilla();
    }

    public static synchronized ClienteService getInstancia() {
        if (instancia == null) {
            instancia = new ClienteService();
        }
        return instancia;
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente != null) {
            rentCarRepository.guardarCliente(cliente);
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return rentCarRepository.obtenerClientes();
    }

    public Cliente buscarClientePorTelefono(long telefonoBuscado) {
        for (Cliente cliente : rentCarRepository.obtenerClientes()) {
            if (cliente.getTelefono() == telefonoBuscado) {
                return cliente;
            }
        }
        return null;
    }

    public boolean esNumeroPerfecto(long telefono) {
        if (telefono <= 0) return false;

        long sumaDivisores = 0;
        for (long i = 1; i <= telefono / 2; i++) {
            if (telefono % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == telefono;
    }

    // Datos ficticios para que la interfaz tenga registros de demostración.
    private void inyectarDatosSemilla() {
        Cliente c1 = new Cliente.ClienteBuilder()
                .conNombre("Cliente de prueba 1")
                .conDocumentoIdentidad("DEMO-001")
                .conTelefono(6)
                .conEdad(28)
                .build();

        Cliente c2 = new Cliente.ClienteBuilder()
                .conNombre("Cliente de prueba 2")
                .conDocumentoIdentidad("DEMO-002")
                .conTelefono(28)
                .conEdad(34)
                .build();

        registrarCliente(c1);
        registrarCliente(c2);
    }
}