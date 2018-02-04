package gsi;

import java.util.Random;
import java.util.Scanner;

public class GSI {

    static Scanner sc = new Scanner(System.in);
    static String abc = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑñOoPpQqRrSsTtUuVvWwXxYyZz";
    static char[] seed = abc.toCharArray();
    static int[] numCamp = new int[100];
    static String[] registros;
    static int contador = 0;

    public static void main(String[] args) {

        System.out.println("Bienvenido");
        System.out.println("Por favor digite cuantos registros desea generar:");
        int numRig = sc.nextInt();
        registros = new String[numRig];
        System.out.println("Por favor digite el numero de campos:");
        int numCampos = sc.nextInt();

        while (numCampos < 2) {
            System.out.println("El numero de registros debe ser mayor o igual que 2");
            System.out.println("por favor digite el numero de campos nuevamente ");
            numCampos = sc.nextInt();
        }

        for (int i = 0; i < numCampos; i++) {
            System.out.println("Digite el numero de digitos k que contendra el campo " + (i + 1) + ":");
            numCamp[i] = sc.nextInt();
        }

        String str = "";
        for (int i = 0; i < numRig; i++) {
            for (int j = 0; j < numCampos; j++) {
                if (j > 0) {
                    if (random(2).compareTo("1") == 0) {
                        str = str + "[" + random(numCamp[j]) + "]";
                    } else {
                        str = str + "[" + randomS(numCamp[j]) + "]";
                    }
                } else {
                    do{
                        registros[i] = random(numCamp[j]);
                    }while(varificarRegistro(registros[i]));
                    contador++;
                    str = str + "[" + registros[i] + "]";
                }
                System.out.print(str);
                str = "";
            }
            System.out.println("");
        }
        System.out.println("$-REGISTROS GENERADOS SIN REPETICION-$");
    }

    public static String random(int n) {
        String temp = "";
        Random r = new Random();
        int rand = r.nextInt(10);

        int i = 0;
        temp = temp.concat(Integer.toString(rand));
        while (temp.length() < n && i < n) {
            rand = r.nextInt(10);
            temp = temp.concat(Integer.toString(rand));
            i++;
        }
        return temp;
    }

    public static String randomS(int n) {
        String temp = "";
        Random r = new Random();
        int rand = r.nextInt(54);

        int i = 0;
        temp = temp + seed[rand];
        while (temp.length() < n && i < n) {
            rand = r.nextInt(54);
            temp = temp + seed[rand];
            i++;
        }
        return temp;
    }

    private static boolean varificarRegistro(String registro) {
        for (int i = 0; i < contador; i++) {
            if (registros[i].compareTo(registro) == 0) {
                System.out.println("Generado ahora:"+registro);
                System.out.println("coincidio con el registro numero "+i+":"+registros[i]);
                detener();
                return true;
            }
        }
        return false;
    }
    
    private static void detener(){
        int n;
        do{
            System.out.println("digite 0 para continuar...");
            n = sc.nextInt();
        }while(n != 0);    
    }
}
