// PROGRAMA --> GESTOR DE NOTES
// AUTOR --> Pablo Abad Ortega
// DATA --> 28/10/2025

#include <iostream> // Incloc entrada i sortida
#include <list>
#include <iomanip> // Necessària per formatar la sortida
#include <windows.h> // De moment no la necessito, però la deixo
using namespace std; // Utilitzo l'espai estàndard

// Definim la mida màxima de l'array de notes
#define MAX_NOTAS 40

void registrar_notes(double notas[], int* total_de_notes) // Inicio la funció
{
    if (*total_de_notes >= MAX_NOTAS) // Verifico l'espai disponible
    {
        cout << "No es poden registrar més notes, està complet! Màx: " << MAX_NOTAS << " notes." << endl;
        return;
    }

    double nota_actual;
    cout << "Registrar Notes" << endl;
    // Poso un punt (.) per decimals
    cout << "Posa les notes (fes servir '.' per als decimals), posa -1 per acabar" << endl;

    // Bucle per llegir notes
    while (*total_de_notes < MAX_NOTAS) // Mentre tingui espai
    {
        cout << "Nota #" << (*total_de_notes + 1) << ": ";

        if (!(cin >> nota_actual)) // Miro si és vàlida
        {
            cout << "Entrada no vàlida. Posa només números o -1 per acabar." << endl;
            cin.clear();
            cin.ignore(10000, '\n');
            continue; // Torno al principi
        }

        if (nota_actual == -1) // Si posa -1...
        {
            break; // Surt del bucle
        }

        if (nota_actual < 0 || nota_actual > 10) // Valido la nota
        {
            cout << "La nota ha d'estar entre 0 i 10." << endl;
            continue; // Torno a demanar nota
        }

        notas[*total_de_notes] = nota_actual; // Guardo la nota
        (*total_de_notes)++; // Incremento el total
    }

    cout << "S'han registrat " << *total_de_notes << " notes." << endl; // Mostro el resultat
}

void calcular_mitjana(const double notas[], int total_de_notes) // Calcula la mitjana
{
    if (total_de_notes == 0) // Comprovo si hi ha notes
    {
        cout << "No hi ha notes registrades." << endl;
        return;
    }

    double suma = 0.0; // Poso la suma a zero
    for (int i = 0; i < total_de_notes; ++i) // Recorro totes les notes
    {
        suma += notas[i]; // Sumo la nota actual
    }

    double mitjana = suma / total_de_notes; // Faig la divisió

    cout << "NOTA MITJANA" << endl; // Imprimeixo el títol
    cout << "----------------------------" << endl;
    cout << "Total de notes: " << total_de_notes << endl; // Mostro el total
    // Ús std::fixed i std::setprecision(2) per mostrar 2 decimals.
    cout << "La nota mitjana és: " << fixed << setprecision(2) << mitjana << endl; // Mostro el resultat
    cout << "----------------------------" << endl;
}

void mostrar_histograma(const double notas[], int total_de_notes) // Dibuixo el meu histograma
{
    if (total_de_notes == 0) // Comprovo si hi ha notes
    {
        cout << "No hi ha notes registrades per fer l'histograma." << endl;
        return;
    }

    // Inicialitzo els meus comptadors
    int suspensos = 0;   // Notes menors de 5
    int aprobats = 0;    // Notes entre 5 i 6.4
    int notables = 0;    // Notes entre 6.5 i 8.4
    int excelents = 0;   // Notes majors de 8.5 (i fins a 10)

    for (int i = 0; i < total_de_notes; ++i) { // Recorro totes les notes
        double nota = notas[i];
        if (nota < 5.0) {
            suspensos++; // Incremento suspensos
        }
        else if (nota < 6.5) {
            aprobats++; // Incremento aprovats
        }
        else if (nota < 8.5) {
            notables++; // Incremento notables
        }
        else { // 8.5 <= nota <= 10.0
            excelents++; // Incremento excel·lents
        }
    }

    // Imprimeixo l'histograma simple
    cout << "HISTOGRAMA DE NOTES" << endl; // Imprimeixo el títol
    cout << "-----------------------------------" << endl;

    // Mostro Suspesos
    cout << "Suspensos (<5.0):  " << setw(3) << suspensos << " |"; // setw(3) ajusta a 3 espais
    for (int i = 0; i < suspensos; ++i) { cout << "*"; } // Dibuixo amb asteriscs
    cout << endl;

    // Mostro Aprovats
    cout << "Aprovats (5.0-6.4):" << setw(3) << aprobats << " |";
    for (int i = 0; i < aprobats; ++i) { cout << "*"; }
    cout << endl;

    // Mostro Notables
    cout << "Notables (6.5-8.4):" << setw(3) << notables << " |";
    for (int i = 0; i < notables; ++i) { cout << "*"; }
    cout << endl;

    // Mostro Excel·lents
    cout << "Excel·lents (8.5+):" << setw(3) << excelents << " |";
    for (int i = 0; i < excelents; ++i) { cout << "*"; }
    cout << endl;

    cout << "-----------------------------------" << endl;
    cout << "Total de notes processades: " << total_de_notes << endl;
}


int main() // Aquí comença el programa
{
    // VARIABLES
    double notas[MAX_NOTAS] = { 0.0 }; // Aquest és el meu array
    int total_de_notas = 0; // El meu total de notes

    string opcion; // Declaro la meva opció

    do // Creo un bucle per al menú
    {
        // Imprimeixo el missatge inicial (ara dins del bucle)
        cout << "\n----------------------------" << endl; // Poso un separador
        cout << "GESTOR DE NOTES" << endl
            << "Benvingut/da al gestor de notes" << endl
            << "----------------------------" << endl
            << "[RT] Registrar notes" << endl
            << "[MJ] Consultar nota mitjana" << endl
            << "[HT] Histograma de notes" << endl
            << "[FIN] Sortir" << endl
            << "----------------------------" << endl
            << "Escull una opció: ";

        if (!(cin >> opcion)) {
            cout << "Error llegint l'opció. Sortint." << endl;
            break;
        }

        cout << "Opció escollida: " << opcion << endl; // Mostro l'opció escollida

        // COMPROVO L'OPCIÓ QUE ESCOLLEIX L'USUARI
        if (opcion == "RT") // Si l'opció és RT
        {
            cout << "REGISTRAR NOTES" << endl; // Imprimeixo el títol
            registrar_notes(notas, &total_de_notas); // Cridem la funció
        }
        else if (opcion == "MJ") // Si l'opció és MJ
        {
            calcular_mitjana(notas, total_de_notas); // Cridem la mitjana
        }
        else if (opcion == "HT") // Si l'opció és HT
        {
            mostrar_histograma(notas, total_de_notas); // Cridem l'histograma
        }
        else if (opcion == "FIN") // Si l'opció és FIN
        {
            cout << "FINALITZANT el gestor de notes. Adéu!" << endl; // Imprimeixo el títol i surto
            return 0;
        }
        else
        {
            cout << "OPCIÓ NO RECONEGUDA" << endl;
        }
    } while (true); // Repeteixo el bucle

    return 0;
}