package Principal;
package ConsumoAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ConsultaDivisa condiv = new ConsultaDivisa();
        HashMap<Integer, String> monedas = new HashMap<Integer, String>();
        monedas.put(1, "ARS Peso argentino");
        monedas.put(2, "BOB Boliviano boliviano");
        monedas.put(3, "BRL Real Brasileño");
        monedas.put(4, "CLP Peso chileno");
        monedas.put(5, "COP Peso colombiano");
        monedas.put(6, "USD Dolar estdounidense");
        monedas.put(7, "MXN Peso mexicano");

        for(Integer key: monedas.keySet()){
            String value = monedas.get(key);
            System.out.println(key+" "+value);
        }

        Scanner  moneda_base = new Scanner(System.in);
        System.out.println("Indica la divisa base: ");
        var base= moneda_base.nextLine();
        condiv.setBase(base);

        Scanner  moneda_cambio = new Scanner(System.in);
        System.out.println("Indica la divisa cambio: ");
        var cambio = moneda_cambio.nextLine();
        condiv.setCambio(cambio);

        Scanner moneda_cantidad = new Scanner(System.in);
        System.out.println("Cantidad a convertir: ");
        var cantidad =moneda_cantidad.nextLine();

        System.out.println("Los datos introducidos fueron Base: "
                +condiv.getBase()+" Cambio: "+condiv.getCambio());

        try {
            condiv.getResConsulta(base, cambio);
            System.out.println("Valor de la divisa de cambio al día de hoy: "+condiv.getConversion());
            var resultado = Float.valueOf(cantidad) * Float.valueOf(condiv.getConversion());
            System.out.println("Serian: "+resultado);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}