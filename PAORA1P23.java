// PROGRAMA --> Pràctica 3.3: Escriptura de fitxer XML
// AUTOR --> Pablo Abad Ortega
// DATA --> 12/11/2025
package pao.ra1.p23;

import java.io.File; // Gestió de fitxers
import java.time.LocalDateTime; // Data i hora actual
import java.time.format.DateTimeFormatter; // Format de data
import java.util.Random; // Valors aleatoris
import java.util.Scanner; // Entrada per teclat
import javax.xml.parsers.DocumentBuilder; // Constructor XML DOM
import javax.xml.parsers.DocumentBuilderFactory; // Fàbrica de parsers XML
import javax.xml.transform.OutputKeys; // Propietats de sortida
import javax.xml.transform.Result; // Destí transformació XML
import javax.xml.transform.Source; // Origen transformació XML
import javax.xml.transform.Transformer; // Escriure XML
import javax.xml.transform.TransformerFactory; // Crear transformador XML
import javax.xml.transform.dom.DOMSource; // Font DOM per XML
import javax.xml.transform.stream.StreamResult; // Sortida a fitxer XML
import org.w3c.dom.Document; // Document XML principal
import org.w3c.dom.Element; // Element XML
import org.w3c.dom.NodeList; // Llista de nodes XML


public class PAORA1P23 // classe principal
{
    public static void main(String[] args) // inici del programa
    {
        Scanner sc = new Scanner(System.in); // deteca el teclat
        boolean continuar = true; // per controlar els bucles
        while (continuar) // bucle principal del codi
        {
            System.out.println("MENÚ CLASH ROYALE - XML"); // Títol del menú
            System.out.println("1. Afegir un jugador nou (Exercici 5)"); // Opció 1
            System.out.println("2. Simular una partida (Exercici 6)"); // Opció 2
            System.out.println("3. Sortir"); // Opció 3 sortir
            System.out.print("Tria una opció: "); // Demanar elecció usuari
            int opcio = sc.nextInt(); // Llegir número opció
            sc.nextLine(); // Eliminar salts pendents
            switch (opcio) // Comprovar opció triada

        {
            case 1: 
                afegirJugadorNou(sc); // crida exercici 5
                break; // Sortir del case
            case 2:
                simular_partida(); // crida exercici 6
                break; // Sortir del case
            case 3:
                continuar = false; // Finalitzar el bucle del menú
                System.out.println("Sortint del Programa"); // Missatge de sortida
                break; // Sortir del case
            default:
                System.out.println("La opció escollida no es vàlida!"); // avisa d'error de la opció
            }
        }
        sc.close(); // Tancar escàner
   }

    
    // EXERCICI 5 - AFEGIR UN JUGADOR NOU   
    public static void afegirJugadorNou(Scanner sc) // Definir mètode amb Scanner
    {
        System.out.println("\n" + "=".repeat(50)); // Línia separadora
        System.out.println("AFEGIR JUGADOR NOU"); // Títol mètode
        System.out.println("=".repeat(50)); // Línia separadora

        try // Bloc try-catch
        {

            // 1-DEMANAR DADES PEL TECLAT
            System.out.print("Posa el nom del nou jugador --> "); // Demanar nom jugador
            String nom_jugador = sc.nextLine(); // Llegir entrada teclat

            // 2-LLEGIR EL FITXER XML EXISTENT
            File arxiu = new File("clash.xml"); // Fitxer XML existent
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance(); // Crear fàbrica builder
            DocumentBuilder constructor = factoria.newDocumentBuilder(); // Crear constructor XML
            Document doc = constructor.parse(arxiu); // Parsejar document XML
            doc.getDocumentElement().normalize(); // Normalitzar document


            // 3-CREAR ELS ELEMENTS XML AMB EL DOM
            Element root = doc.getDocumentElement(); // Agafem l'element arrel <Jugadors>
            // crear el element de <Jugador>
            Element jugador = doc.createElement("Jugador");
            // crear i afegir el nom <Nom>
            Element nom = doc.createElement("Nom");
            nom.setTextContent(nom_jugador);
            jugador.appendChild(nom);
            // crear i afegir el nivell <Nivell> 
            Element nivell = doc.createElement("Nivell");
            nivell.setTextContent("1");
            jugador.appendChild(nivell);
            // crear i afegir les copes <Copes> 
            Element copes = doc.createElement("Copes");
            copes.setTextContent("0");
            jugador.appendChild(copes);
            // crear i afegir l'or <Or> 
            Element or = doc.createElement("Or");
            or.setTextContent("0");
            jugador.appendChild(or);
            // crear i afegir les gemes <Gemes> 
            Element gemes = doc.createElement("Gemes");
            gemes.setTextContent("0");
            jugador.appendChild(gemes);
            // crear i afegir les estrelles <Estrelles>
            Element estrelles = doc.createElement("Estrelles");
            estrelles.setTextContent("0");
            jugador.appendChild(estrelles);
            // crear element de les partides <Partides> de forma buida
            Element partides = doc.createElement("Partides");
            jugador.appendChild(partides);
            // 4-AFEGIR EL JUGADOR EN EL DOCUMENT XML
            root.appendChild(jugador);
            // 5-ESCRIURE EL FITXER XML AL NOU FORMAT AMB EL NOU JUGADOR
            TransformerFactory transformerFactory = TransformerFactory.newInstance(); // Crear fàbrica transformer
            Transformer transformer = transformerFactory.newTransformer(); // Crear objecte transformer
            transformer.setOutputProperty(OutputKeys.METHOD, "xml"); // Sortida XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Activar indentació
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Espais indentació
            Source source = new DOMSource(doc); // Origen document XML
            Result result = new StreamResult(new File("clash.xml")); // Destí fitxer XML
            transformer.transform(source, result); // Escriure fitxer XML

            System.out.println("\nJugador '" + nom_jugador + "' s'ha afegit"); // Missatge jugador afegit
            System.out.println(" - Nivell --> 1"); // Mostrar nivell inicial
            System.out.println(" - Copes --> 0"); // Mostrar copes inicials
            System.out.println(" - Or --> 0"); // Mostrar or inicial
            System.out.println(" - Gemes --> 0"); // Mostrar gemes inicials
            System.out.println(" - Estrelles --> 0"); // Mostrar estrelles inicials
            } catch (Exception e) // Capturar errors
            {
                System.err.println("ERROR en afegir el jugador --> " + e.getMessage()); // Missatge error
                e.printStackTrace(); // Mostrar traça error
            }
            }

    
    // EXERCICI 6: SIMULAR UNA PARTIDA ENTRE DOS JUGADOR ALEATORIS

        /**
         *
         */
        public static void simular_partida() // Mètode simular partida
        {
            System.out.println("\n" + "=".repeat(50)); // Línia separadora
            System.out.println("SIMULACIÓ DE PARTIDA"); // Títol simulació
            System.out.println("=".repeat(50)); // Línia separadora
            try
            {
                // 1-LLEGIR EL FITXER XML
                File arxiu = new File("clash.xml"); // Fitxer XML
                DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance(); // Fàbrica builder
                DocumentBuilder constructor = factoria.newDocumentBuilder(); // Constructor XML
                Document doc = constructor.parse(arxiu); // Parsejar document
                doc.getDocumentElement().normalize(); // Normalitzar XML

                // 2-AGAFAR TOTS ELS JUGADORS
                NodeList jugadors = doc.getElementsByTagName("Jugador"); // Llista jugadors
                int numero_jugadors = jugadors.getLength(); // Comptar jugadors
                if (numero_jugadors < 2) // Comprovar mínim 2
                {
                    System.out.println("ERROR --> Cal tenir 2 jugador per fer la partida!"); // Missatge error
                    return; // Sortir mètode
                }

                // 3-SELECCIONAR ELS DOS JUGADORS RANDOM
                Random r = new Random(); // Generador aleatori
                int index1 = r.nextInt(numero_jugadors); // Index jugador 1
                int index2 = r.nextInt(numero_jugadors); // Index jugador 2
                // perquè siguin diferents els jugadors:
                while (index2 == index1) // Evitar duplicats
                {
                    index2 = r.nextInt(numero_jugadors); // Tornar a generar
                }

            Element jugador_1 = (Element) jugadors.item(index1); // Seleccionar jugador 1
            Element jugador_2 = (Element) jugadors.item(index2); // Seleccionar jugador 2
            String nom_jugador_1 = jugador_1.getElementsByTagName("Nom").item(0).getTextContent(); // Nom jugador 1
            String nom_jugador_2 = jugador_2.getElementsByTagName("Nom").item(0).getTextContent(); // Nom jugador 2

            // 4- CREAR ELS RESULTATS DE FORMA RANDOM
            int gols_jugador_1 = r.nextInt(4); // Gols jugador 1 (0–3)
            int gols_jugador_2 = r.nextInt(4); // Gols jugador 2 (0–3)
            String resultats = gols_jugador_1 + "-" + gols_jugador_2; // Format resultat

            // 5-CREAR LES DADES DE LA PARTIDA
            LocalDateTime ara = LocalDateTime.now(); // Hora actual
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Format data
            String data = ara.format(formatter); // Data partida

            // Durada random entre 2 i 6 minuts
            int minuts = 2 + r.nextInt(5); // Minuts aleatoris
            int segons = r.nextInt(60); // Segons aleatoris
            String durada = String.format("%02d:%02d", minuts, segons); // Format durada
            String tipus = "Lliga"; // Tipus partida

            
            // 6-CREAR ELEMENT <Partida> PER EL JUGADOR 1
            Element partida_1 = doc.createElement("Partida"); // Crear node partida 1

            Element data_1 = doc.createElement("Data"); // Node data partida 1
            data_1.setTextContent(data); // Assignar data
            partida_1.appendChild(data_1); // Afegir data a partida 1

            Element resultat_1 = doc.createElement("Resultat"); // Node resultat partida 1
            resultat_1.setTextContent(resultats); // Assignar resultat
            partida_1.appendChild(resultat_1); // Afegir resultat a partida 1

            Element durada_1 = doc.createElement("Durada"); // Node durada partida 1
            durada_1.setTextContent(durada); // Assignar durada
            partida_1.appendChild(durada_1); // Afegir durada a partida 1

            Element tipus_1 = doc.createElement("Tipus"); // Node tipus partida 1
            tipus_1.setTextContent(tipus); // Assignar tipus
            partida_1.appendChild(tipus_1); // Afegir tipus a partida 1

            // afegir el jugador 1 a la partida
            Element partides_1 = (Element) jugador_1.getElementsByTagName("Partides").item(0); // Node partides jugador 1
            partides_1.appendChild(partida_1); // Afegir partida 1 al jugador 1

            // 7-CREAR ELEMENT <Partida> PER JUGADOR 2
            String resultat_alreves = gols_jugador_2 + "-" + gols_jugador_1; // Crear resultat invers
            Element partida_2 = doc.createElement("Partida"); // Crear node partida 2

            Element data_2 = doc.createElement("Data"); // Crear node data partida 2
            data_2.setTextContent(data); // Assignar data
            partida_2.appendChild(data_2); // Afegir data a partida 2

            
            Element resultat_2 = doc.createElement("Resultat"); // Crear node resultat
            resultat_2.setTextContent(resultat_alreves); // Assignar resultat jugador 2
            partida_2.appendChild(resultat_2); // Afegir a partida 2

            Element durada_2 = doc.createElement("Durada"); // Crear node durada
            durada_2.setTextContent(durada); // Assignar durada partida
            partida_2.appendChild(durada_2); // Afegir a partida 2

            Element tipus_2 = doc.createElement("Tipus"); // Crear node tipus
            tipus_2.setTextContent(tipus); // Assignar tipus partida
            partida_2.appendChild(tipus_2); // Afegir a partida 2

            // Afegir al jugador 2 a la partida
            Element partides_2 = (Element) jugador_2.getElementsByTagName("Partides").item(0); // Node partides jugador 2
            partides_2.appendChild(partida_2); // Afegir partida 2 al jugador 2

            
            // 8-ACTUALITZAR COPES DELS GUANYADORS        
            String guanyador = ""; // Inicialitzar guanyador
            int noves_copes_guanyador = 0; // Inicialitzar noves copes
            if (gols_jugador_1 > gols_jugador_2) // Comprovar si jugador 1 guanya
            {
                // guanya el jugador 1                     
                guanyador = nom_jugador_1; // Assignar guanyador
                Element copesNode = (Element) jugador_1.getElementsByTagName("Copes").item(0); // Node copes jugador 1
                int copes_actuals = Integer.parseInt(copesNode.getTextContent()); // Llegir copes actuals
                noves_copes_guanyador = copes_actuals + 3; // Sumar 3 copes
                copesNode.setTextContent(String.valueOf(noves_copes_guanyador)); // Actualitzar copes
            } else if (gols_jugador_2 > gols_jugador_1) // Comprovar si jugador 2 guanya

            {
                // guanya jugador 2                          
                guanyador = nom_jugador_2; // Assignar guanyador
                Element copesNode = (Element) jugador_2.getElementsByTagName("Copes").item(0); // Node copes jugador 2
                int copes_actuals = Integer.parseInt(copesNode.getTextContent()); // Llegir copes actuals
                noves_copes_guanyador = copes_actuals + 3; // Sumar 3 copes
                copesNode.setTextContent(String.valueOf(noves_copes_guanyador)); // Actualitzar copes
            } else
            {
                // empat                                     
                guanyador = "EMPAT"; // Assignar empat
                Element copesNode_1 = (Element) jugador_1.getElementsByTagName("Copes").item(0); // Node copes jugador 1
                int copes_1 = Integer.parseInt(copesNode_1.getTextContent()); // Llegir copes jugador 1
                copesNode_1.setTextContent(String.valueOf(copes_1 + 1)); // Sumar 1 copa

                Element copesNode_2 = (Element) jugador_2.getElementsByTagName("Copes").item(0); // Node copes jugador 2
                int copes_2 = Integer.parseInt(copesNode_2.getTextContent()); // Llegir copes jugador 2
                copesNode_2.setTextContent(String.valueOf(copes_2 + 1)); // Sumar 1 copa
            }

            
            // 9-ESCRIURE FITXER XML AMB LES COSES NOVES   // Guardar canvis XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance(); // Crear fàbrica transformer
            Transformer transformer = transformerFactory.newTransformer(); // Crear objecte transformer
            transformer.setOutputProperty(OutputKeys.METHOD, "xml"); // Format sortida XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Activar indentació
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Espais per nivell
            Source source = new DOMSource(doc); // Origen: document XML
            Result result = new StreamResult(new File("clash.xml")); // Destí: fitxer XML
            transformer.transform(source, result); // Escriure al fitxer

            
            // 10-ENSENYAR ELS RESULTATS PER PANTALLA
            System.out.println("\nJugador 1 --> " + nom_jugador_1); // nom del jugador 1
            System.out.println("Jugador 2 --> " + nom_jugador_2); // nom del jugador 2
            System.out.println("Data --> " + data); // mostra la data al terminal
            System.out.println("Resultat --> " + resultats); // mostrar resultats
            System.out.println("Durada --> " + durada); // mostrar la durada
            System.out.println("Tipus --> " + tipus); // mostrar el tipus de partida
            if (guanyador.equals("EMPAT")) // comprovacio de l'empat
            {
                System.out.println("RESULTAT --> EMPAT!"); // missatge en cas d'empat
                System.out.println("Tots dos jugadors obtenen +1 copa"); // empat i afegeix 1 a les copes dels dos jugadors
            } else // 
            {
                System.out.println("GUANYADOR --> " + guanyador); // mostrar el guanyador de la partida
                System.out.println("Noves copes de " + guanyador + " --> " + noves_copes_guanyador); // Copes noves
            }

        } catch (Exception e) // catura els errors 
        {
            System.err.println("ERROR en la simulacio de la partida --> " + e.getMessage()); // misstge de error de la partida
            e.printStackTrace(); 
        }
    }
}
