// Pràctica 2 - Lectura i escriptura de fitxers
// PROGRAMA --> Lectura de fitxers i creació de usuaris amb contrasenya
// AUTOR --> Pablo Abad Ortega
// DATA --> 10/10/2025

package pao_ra1_p2; // Defineix el paquet on es troba la classe

import java.io.BufferedReader; // Llegeix arxius línia per línia de forma eficient
import java.io.FileReader; // Obre i llegeix arxius de text
import java.io.FileWriter; // Escriu dades en arxius de text
import java.io.IOException; // Gestiona errors d'entrada/sortida d'arxius
import java.util.Scanner; // Llegeix dades introduïdes per l'usuari des del teclat
import java.util.logging.Logger; // Registra errors i missatges del programa

public class PAO_RA1_P2 // Classe principal del programa
{
    public static void main(String[] args) throws IOException // Inici del programa
    {
        Scanner teclado = new Scanner(System.in); // Crea un objecte per llegir dades que escrigui el usuari en el teclat
        int opcio = 0; // Variable per guardar l'opció del menú que vulgui el usuari

        while (opcio != 6) // Bucle que es repeteix fins que l'usuari vulgui sortir a la opcio 6
        {
            menu(); // demana al mètode que ensenya el menú
            System.out.println("Escull opció:"); // Demana a l'usuari que posi una opció
            opcio = teclado.nextInt(); // Llegeix el número que posi l'usuari
            teclado.nextLine(); // fa el salt de línia pendent
            seleccio(opcio); // Executa l'acció corresponent a l'opció escollida per l'usuari
        }

        teclado.close(); // Tanca l'objecte Scanner per alliberar recursos
    }

    private static void menu() // Mètode que mostra el menú principal del programa
    {
        System.out.println("*******MENU PRINCIPAL*********"); // Títol del menú
        System.out.println("1 - Menu"); // Opció per tornar a mostrar el menú
        System.out.println("2 - Usuaris i Contrasenyes"); // Opció per crear nous usuaris
        System.out.println("3 - Comprovació de l'Usuari"); // Opció per validar login d'usuari
        System.out.println("6 - Sortir"); // Opció per finalitzar el programa
    }

    private static void seleccio(int opcio) throws IOException // Mètode que executa l'opció escollida del menú
    {
        switch (opcio) // Estructura de control segons l'opció que vulgui l'usuari
        {
            case 1: // Si l'usuari escull l'opció 1
                menu(); // Torna a mostrar el menú
                break; // Surt del switch
            case 2: // Si l'usuari escull l'opció 2
                exercici2(); // Crida al mètode per crear usuaris i contrasenyes
                break; // Surt del switch
            case 3: // Si l'usuari escull l'opció 3
                exercici3(); // Crida al mètode per comprovar login d'usuari
                break; // Surt del switch
            case 6: // Si l'usuari escull l'opció 6
                System.out.println("Sortint del programa..."); // Mostra missatge de sortida
                break; // Surt del switch
            default: // Si l'opció no és vàlida
                System.out.println("Opció no vàlida"); // Mostra missatge d'error
                break; // Surt del switch
        }
    }

    private static void exercici2() throws IOException // Mètode per crear i guardar usuaris amb les contrasenyes
    {
        FileWriter f = new FileWriter("./Usuaris.txt", true); // Crea i obra l'arxiu per afegir els usuaris
        Scanner entrada = new Scanner(System.in); // Crea Scanner per llegir les dades dels usuaris
        String nom = "a", passwd = "a"; // Inicialitza variables per nom d'usuari i la contrasenya

        while (!"".equals(nom)) // Bucle que es repeteix mentre el nom no estigui buit
        {
            System.out.println("Introdueix el nom d'usuari (Deixar en blanc per finalitzar): "); // Demana el nom de l'usuari
            nom = entrada.nextLine(); // Llegeix el nom que posi l'usuari

            if ("".equals(nom)) // Comprova si l'usuari ha deixat el camp sense res
            {
                break; // Surt del bucle i acaba la creació dels usuaris
            }       

            System.out.println("Introdueix la contrasenya: "); // Demana la contrasenya per l'usuari
            passwd = entrada.nextLine(); // Llegeix la contrasenya que posi
            f.write(nom + ":" + passwd + "\n"); // Escriu usuari i contrasenya a l'arxiu amb el format nom:contrasenya
        }

        f.close(); // Tanca l'arxiu per guardar els canvis
        System.out.println("Usuaris guardats correctament."); // Mostra missatge de confirmació
    }     

    private static void exercici3() throws IOException // Mètode per validar l'usuari i contrasenya (login)
    {
        Scanner entrada = new Scanner(System.in); // Crea Scanner per llegir dades del teclat
        System.out.println("Introdueix el nom d'usuari: "); // Demana el nom d'usuari
        String nom = entrada.nextLine(); // Llegeix el nom d'usuari
        System.out.println("Introdueix la contrasenya: "); // Demana la contrasenya
        String passwd = entrada.nextLine(); // Llegeix la contrasenya

        String contrasenya = usuariExisteix(nom); // Crida al mètode per buscar la contrasenya de l'usuari a l'arxiu

        if (contrasenya.equals("")) // Comprova si l'usuari no existeix (retorna cadena buida)
        {
            System.out.println("L'usuari no existeix"); // Mostra missatge que l'usuari no s'ha trobat
        } 
        else // Si l'usuari existeix
        {
            if (passwd.equals(contrasenya)) // Comprova si la contrasenya introduïda coincideix
            {
                System.out.println("CORRECTE!"); // Login correcte
            } 
            else // Si la contrasenya no coincideix
            {
                System.out.println("Contrasenya errònia"); // Mostra missatge d'error de contrasenya
            }
        }
    }

    private static String usuariExisteix(String usuari) throws IOException // Mètode que busca un usuari a l'arxiu i retorna la seva contrasenya
    {
        FileReader fr = null; // Inicialitza el lector d'arxius a null
        BufferedReader buf = null; // Inicialitza el buffer de lectura a null

        try // bucle per gestionar la lectura de l'arxiu 
        {
            fr = new FileReader("./Usuaris.txt"); // Obre l'arxiu d'usuaris
            buf = new BufferedReader(fr); // Crea el buffer per llegir línia a línia
            String linia = buf.readLine(); // Llegeix la primera línia de l'arxiu

            while (linia != null) // Recorre totes les línies de l'arxiu "usuaris"
            {
                String[] parts = linia.split(":"); // Divideix la línia per el caràcter ':' 
                if (parts.length >= 2 && parts[0].equals(usuari)) // Comprova si té el format té les 2 parts i el nom es correcte
                {
                    return parts[1]; // dona la contrasenya 
                }
                linia = buf.readLine(); // llegirà la següent línia
            }
        } 
        catch (IOException ex) // Si hi ha error en llegir l'arxiu...
        {
            Logger.getLogger(PAO_RA1_P2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); // Registra l'error
        } 
        finally // bucle que s'executa sempre per tancar els recursos
        {
            try 
            {
                if (buf != null) // Si el buffer està obert...
                {
                    buf.close(); // Tanca el buffer
                }
                if (fr != null) // Si el FileReader està obert...
                {
                    fr.close(); // es tanca el FileReader
                }
            } 
            catch (IOException ex) // Si hi ha error quant es tanqui...
            {
                Logger.getLogger(PAO_RA1_P2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex); // fa el registre de l'error
            }
        }

        return "s'acaba el programa";
    }
}