package pao_ra1_p1;

import java.io.File; // importa la classe File del paquet java.io
import java.io.FileWriter; // importa la classe FileWriter
import java.io.IOException; // importa la classe IOException
import java.util.Scanner; // importa la classe Scanner per llegir deades de diverses fonts

public class PAO_RA1_P1 // permet ser accessible desde qualsevol part del codi
{

    private static final int opcio = 0; // Variable per guardar l'opció de l'usuari
    private static Scanner teclado; // Scanner estàtic per ser accessible des de tots els mètodes

    public static void main(String[] args) // comencament del programa
    {
        menu(); // mostrar les opcions per lusuari
        teclado = new Scanner(System.in);
            int opcio = 0; // declara i incia la variable OPCIO en 0
            while (opcio != 6) // inicia un bucle WHILE que es repeteix fins la opcio 6 per sortir
            {
                System.out.println(" --Escull opcio: "); // ensenya un missatge per demanar a lusuari que doni una opcio
                opcio = teclado.nextInt(); // llegeix un numero enter que lusuari posi i o guarda a la variable OPCIO
                teclado.nextLine(); // fa un salt de linia
                Seleccio(opcio); // metode seleccio
            }
    }

    // EXERCICI 1 - CREA UN METODE MENÚ()
    private static void menu() // mètode anomenat menu que és d'ús intern
    { 
        System.out.println("**********************"); // per imprimir una línia d'asteriscs a la consola
        System.out.println("******* MENÚ *********"); // imprimeix el text "******* MENÚ *********" a la consola 
        System.out.println("1.- Comprova fitxers"); // imprimeix el text "******* comprovar fitxers *********" a la consola 
        System.out.println("2.- Llista d'arxius"); // imprimeix el text "******* llistat d'arxius *********" a la consola 
        System.out.println("3.- Crear arxiu TXT"); // imprimeix el text "******* crear arxius txt *********" a la consola 
        System.out.println("4.- Mostrar contingut"); // imprimeix el text "******* mostrar contingut *********" a la consola 
        System.out.println("5.- Crear directori i arxiu"); // imprimeix el text "******* crear directoris i arxius *********" a la consola 
        System.out.println("6.- Comprova fitxer des del terminal"); // imprimeix el text "******* comprovvar fitxers *********" a la consola 
        System.out.println("7.- Sortir"); // imprimeix el text "******* sortir *********" a la consola 
        System.out.println("**********************"); // per imprimir una línia d'asteriscs a la consola
    }

    private static void Seleccio(int opcio) throws UnsupportedOperationException // Realitza una acció basada en opcion i llança una UnsupportedOperationException si l'opció no és vàlida o no està implementada.
    {
        switch (opcio)
        {
            case 1:
                menu();
                break;
            case 2:
                exercici2(); // exercici 2 - comprovar fitxers
                break;
            case 3:
                exercici3(); // exercici3 - llistar arxius
                break;
            case 4:
                exercici4(); // exercici4 - mostrar contingut
                break;
            case 5:
                exercici5(); // exercici5 - crear directori i arxius
                break;
            case 6:
                exercici6(); // exercici6 - Comprova fitxer des del terminal
                break;
            case 7:
                exercici7(); // exercici7 - Sortir
                break;
            default:
                break;
        }
    }

    // EXERCICI 2 - COMPROVAR LA EXISTÈNCIA DE FITXERS
    private static void exercici2()
    {
        File arxiu = new File("./prova/nop.txt");
        if (arxiu.exists())
        {
            System.out.println("l'arxiu NOP si existeix");
        } else
        {
            System.out.println("l'arxiu NOP no existeix");
        }

        File arxiu2 = new File("C:\\Windows\\notepad.exe");
        if (arxiu2.exists())
        {
            System.out.println("l'arxiu notepad.exe si existeix");
        } else
        {
            System.out.println("l'arxiu notepad.exe no existeix");
        }
    }

    // EXERCICI 3 - LLISTAR ARXIUS AMB BUCLE FOR (File f : Ficheros)
    private static void exercici3() // difineixo un metode per EXERCICI3
    {
        File directori = new File("C:\\Windows\\"); // crea un objecte FILE amb la ruta del directori C:\\Windows\\
        if (directori.exists()) // verifica si el directori existeix 
        {
            System.out.println("Llistat d'arxius a C:\\Windows\\:"); // el programa ensenya a lusuari un missatge diguent el llistat d'arxius 
            File[] fitxers = directori.listFiles(); // obté llistat de tots els arxius i directoris de un altre directori
            for (File f : fitxers)
            {
                System.out.println(f.getName()); 
            }
        }
    }

    // EXERCICI 4 - CREAR I ESCRIURE EN UN ARXIU .TXT:
    private static void exercici4()
    {
        String arxiu1 = "arxiu1.txt";
        String text1 = "Aquest és un primer escrit al meu arxiu.";
        try ( FileWriter escriptor1 = new FileWriter(arxiu1))
        {
            escriptor1.write(text1);
            System.out.println("Text escrit correctament a " + text1);
        } catch (IOException e)
        {
            System.out.println("S'ha produït un error en escriure a " + arxiu1);
        }
    }

    // EXERCICI 5 - MOSTRAR EL CONTINGUT DELS ARXIUS 
    private static void exercici5() // incia l'exercici 5 
    {
        System.out.println("posa el nom del directori:"); // el programa demana a lusuari una solicitut
        Scanner teclado = new Scanner(System.in); // cra un nou objecte SCANNER
        String nomDirectori = teclado.nextLine(); // llegeix la linia de text que lusuari posi
        File directori1 = new File(nomDirectori); // crea el opbjecte FILE 

        if (!directori1.exists()) // en el cas de que existeixi...
        {
            if (directori1.mkdir()) // si no existeix intentara crea el directori i retorna TRUE si funciona
            {
                System.out.println("Directori '" + directori1.getName() + "' creat."); // en cas de que MKDIR sigui TRUE, es crearà

            } else // en cas de que sigui FALSE ...
            { 
                System.out.println("No s'ha pogut crear el directori '" + directori1.getName() + "'."); // el programa imprimeix i fa un salt de linia
            }
        } else 
        {
            System.out.println("El directori ja existeix."); // el programa avisa a lusuari de que existeix el fitxer
        }
    }
    // EXERCICI 6 - COMPROVAR FITXER DESDEL TERMINAL
    private static void exercici6() // entrada del codi per crear directori i arxius
    {
        System.out.println("genera un directori i un arxiu amb un nom aleatori"); // el programa envia un misatge 
        String uniqueId = UUID.randomUUID().toString(); // crea un nom random i d'un sol ús unic
        String randomDirName = "directori-aleatori" + uniqueId.substring(0, 8); // crea el nom que tindrà el nou directori
        File newDir = new File(randomDirName); // es prepara per treballar amb el sistema de fitxers amb el nom que he creat
        if (newDir.mkdir()) // en el cas de que es faci el directori ...
        {
            System.out.println("Directori nou: " + newDir.getAbsolutePath()); // el programa informa a lusuari que el directori esta creat i la ruta del directori
            String randomFileName = "arxiu_" + uniqueId + ".txt"; // fa el nom complet de l'arxiu de text que s'hagi creat
            File newFile = new File(newDir, randomFileName); // defineix la ruta del nou directori amb el fiotxer
            try // inicia el codi de excepcions 
            {
                if (newFile.createNewFile()) // es la representacio de la ruta del fitxer
                {
                    System.out.println("Arxiu creat: " + newFile.getName()); // el programa envia misattge per confirmar que esta creat l'arxiu
                    try (FileWriter writer = new FileWriter(newFile)) // crea un objecte que es conecta amb l'arxiu que he creat
                    {
                        writer.write("Aquest arxiu es va crear automàticament."); // escriu un misatge en el fitxeer
                        System.out.println("Contingut escrit a l'arxiu."); // el programa li diu a lusuari que s'ha acabat correctament
                    }
                } else // si la condicio anteroir es FALSE...
                {
                    System.out.println("No s'ha pogut crear l'arxiu: " + newFile.getName()); // el programa li diu a lusuari que s'ha creat el fixter 
                }
            } catch (IOException e) // incia el gestor de errors en cas de fallada
            {
                System.err.println("Error d'IO en crear l'arxiu: " + e.getMessage()); // executa quant es detecti un error dentrada o sortida 
            }
        } else // en cas d'error retorna FALSE i tanca el bloc de IF
        {
            System.out.println("No s'ha pogut crear el directori."); // el programa avisa a lusuari que el bloc no ha funcionat i s'ha acabat la execució
        }
    }
    // EXERCICI 7 - 
    public static void exercici7() // declaro la funcio 
    {
        System.out.println("EXERCICI 7: Informació d'un fitxer"); // el programa ensenya a lusuari un misatge indicant el nom de l'exercici
        
        Scanner sc = new Scanner(System.in); // Crea Lector d'Entrada
        
        System.out.println("Entra l'adreça d'un fitxer"); // el programa li demana a lusuari que posi la ruta del fitxer
        
        String adreçaFitxer = sc.next(); // guarda la ruta del fitxer
        
        File f = new File(adreçaFitxer); // el programa lleixeig la ruta de l'arxiu
        
        if (f.isFile()) // el programa comprova el fitxer
        { 
            System.out.println("Nom:" + f.getName()); // el programa ensenya el nom de l'arxiu
            
            System.out.println("Path:" + f.getPath()); // el programa ensenya la ruta de l'arxiu on es troba
            
            System.out.println("Longitud:" + f.length() + "bytes"); // el programa ensenya la mida de l'arxiu en bytes
        } else // si el fitxer no existeix
        {
            System.out.println("El fitxer no existeix"); // en cas de qe no funcioni, el programa avisa a lusuari de que no ha funcionat
        }
    }
}