import java.util.*;

public class TransMilenio {
    
    // definir las estaciones
    private static ArrayList<String> estaciones = new ArrayList<String>(
        Arrays.asList("Portal Suba", "21 Ángeles", "Marly", "Portal Norte", "Universidades", "Calle 100", "Portal 80", "Plaza de las Américas", "Santa Isabel", "Tercer Milenio", "Avenida Chile", "Museo Nacional", "Portal Eldorado")
    );
    
    // definir las rutas
    private static ArrayList<String> rutas = new ArrayList<String>(
        Arrays.asList("K43", "L82", "H97", "F23", "D24", "E44", "G70", "J76")
    );
    
    // definir los tipos de autobuses
    private static HashMap<String, String> tiposDeAutobuses = new HashMap<String, String>();
    static {
        tiposDeAutobuses.put("K43", "alimentador");
        tiposDeAutobuses.put("L82", "troncal");
        tiposDeAutobuses.put("H97", "expreso");
        tiposDeAutobuses.put("F23", "alimentador");
        tiposDeAutobuses.put("D24", "troncal");
        tiposDeAutobuses.put("E44", "alimentador");
        tiposDeAutobuses.put("G70", "expreso");
        tiposDeAutobuses.put("J76", "troncal");
    }
    
    // definir las estaciones de cada ruta
    private static ArrayList<ArrayList<String>> estacionesPorRuta = new ArrayList<ArrayList<String>>();
    static {
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Portal Suba", "Suba - TV 91", "Avenida Suba", "Avenida Boyacá", "Autopista Norte", "Héroes", "Flores", "Museo del Oro")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Portal 80", "Portal de la 80", "Avenida Cali", "Avenida Caracas", "Calle 72", "Calle 76", "Calle 85", "Calle 100", "NQS - Calle 127", "NQS - Calle 145", "Portal Usme")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Portal Eldorado", "El Tiempo Maloka", "Av. Esperanza", "Calle 26", "Calle 53", "Calle 72", "Calle 85", "Calle 100", "Autopista Norte", "Héroes", "Flores", "Museo del Oro")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Avenida Las Villas", "Avenida Ciudad de Cali", "Avenida Boyacá", "Carrera 30", "Carrera 10", "Calle 19", "Museo Nacional")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Portal Norte", "Calle 146", "Calle 161", "Toberín", "Calle 187", "Avenida Boyacá", "Carrera 30", "Calle 45", "Museo Nacional")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Portal Suba", "Suba - TV 91", "Avenida Suba", "Avenida Boyacá", "Carrera 30", "Calle 72", "Calle 80")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Tintal", "Puente Aranda", "San Façon", "Carrera 13", "Calle 72", "Calle 80", "Carrera 50", "Calle 26", "El Dorado")));
        estacionesPorRuta.add(new ArrayList<String>(Arrays.asList("Portal Eldorado", "El Tiempo Maloka", "Av. Esperanza", "Carrera 50", "Calle 26", "Carrera 7", "Calle 63", "Calle 76", "Calle 85", "Calle 100", "NQS - Calle 127", "NQS - Calle 145", "Portal Usme")));
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Bienvenido al sistema de información de TransMilenio.");
    System.out.println("Por favor, seleccione la estación:");
    for (String estacion : estaciones) {
        System.out.println("- " + estacion);
    }
    String estacionSeleccionada = sc.nextLine();
    System.out.println("Por favor, seleccione la ruta:");
    for (String ruta : rutas) {
        System.out.println("- " + ruta);
    }
    String rutaSeleccionada = sc.nextLine();
    String tipoDeAutobus = tiposDeAutobuses.get(rutaSeleccionada);
    System.out.println("Ha seleccionado la ruta " + rutaSeleccionada + ", que es de tipo " + tipoDeAutobus + ".");
    
    // buscar las estaciones de la ruta seleccionada
    ArrayList<String> estacionesDeRuta = null;
    int indiceDeRuta = rutas.indexOf(rutaSeleccionada);
    if (indiceDeRuta != -1) {
        estacionesDeRuta = estacionesPorRuta.get(indiceDeRuta);
    }
    
    // mostrar las estaciones de la ruta seleccionada
    if (estacionesDeRuta != null) {
        System.out.println("La ruta " + rutaSeleccionada + " pasa por las siguientes estaciones:");
        boolean encontrada = false;
        for (String estacion : estacionesDeRuta) {
            if (estacion.equals(estacionSeleccionada)) {
                encontrada = true;
            }
            if (encontrada) {
                System.out.println("- " + estacion);
            }
        }
        if (!encontrada) {
            System.out.println("Lo siento, la estación " + estacionSeleccionada + " no se encuentra en la ruta " + rutaSeleccionada + ".");
        }
    } else {
        System.out.println("Lo siento, no se ha encontrado la ruta " + rutaSeleccionada + ".");
    }
}
}

