package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Fernando Perez de Ayala
 * Fecha: 11/12/2023
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        List<Client>  out= new ArrayList<Client>(0);
        var setOut = new HashSet<Client>( 0 );
        var todosClientes = new ArrayList<Client>( 0 );
        ClientDAO clientDAO = new ClientDAO();
        todosClientes = ( ArrayList<Client> ) clientDAO.getAll();

        for (Client cliente: todosClientes){
            for(Car coche: cliente.getCars()){
                if(Objects.equals( coche.getManufacturer( ) , manufacturer )){
                    setOut.add( cliente );
                }
            }
        }
        out = setOut.stream( ).toList();

        return out;
    }
}
