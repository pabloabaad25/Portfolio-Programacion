// PROGRAMA --> Simulador de dados
// AUTOR --> Pablo Abad Ortega
// FECHA --> 24/11/2025

#include <iostream> // libreria de entrada/salida
#include <cstdlib> // libreria de numeros random
#include <ctime> // libreria de tiempo y fecha
#include <string> // librería de cadenas de caracteres.
#include <windows.h> // librería de la Interfaz de Programación de Aplicaciones (API) de Windows.
using namespace std; // para no tener que poner std::

string cara1_6 =
"+----+\n"
"|    |\n"
"|  * |\n"
"|    |\n"
"+----+\n";

string cara2_6 =
"+----+\n"
"|*   |\n"
"|    |\n"
"|   *|\n"
"+----+\n";

string cara3_6 =
"+----+\n"
"|*   |\n"
"|  * |\n"
"|   *|\n"
"+----+\n";

string cara4_6 =
"+----+\n"
"|*  *|\n"
"|    |\n"
"|*  *|\n"
"+----+\n";

string cara5_6 =
"+----+\n"
"|*  *|\n"
"|  * |\n"
"|*  *|\n"
"+----+\n";

string cara6_6 =
"+----+\n"
"|*  *|\n"
"|*  *|\n"
"|*  *|\n"
"+----+\n";

HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);

// Declaración de las 12 caras del D12
string cara1 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        1         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara2 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        2         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara3 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        3         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara4 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        4         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara5 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        5         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara6 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        6         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara7 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        7         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara8 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        8         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara9 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(        9         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara10 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(       10         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara11 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(       11         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

string cara12 =
"      ________\n"
"   .-'        `-.\n"
" .'              `.\n"
"(       12         )\n"
" `.              .'\n"
"   `-.        .-'\n"
"      `------'\n";

// Función para imprimir la cara correspondiente
void imprimir_dado_cara(int numero)
{
    switch (numero)
    {
    case 1: cout << cara1; break;
    case 2: cout << cara2; break;
    case 3: cout << cara3; break;
    case 4: cout << cara4; break;
    case 5: cout << cara5; break;
    case 6: cout << cara6; break;
    case 7: cout << cara7; break;
    case 8: cout << cara8; break;
    case 9: cout << cara9; break;
    case 10: cout << cara10; break;
    case 11: cout << cara11; break;
    case 12: cout << cara12; break;
    default:
        cout << "ERROR, NO HA SIDO POSIBLE IMPRIMIR EL NUMERO " << numero << ".\n";
        break;
    }

    cout << "\n"; // Otro salto de línea después del dibujo
}

// Función para imprimir la cara del dado
void imprimir_dado_cara_6(int numero)
{
    switch (numero)
    {
    case 1:
        cout << cara1_6;
        break;
    case 2:
        cout << cara2_6;
        break;
    case 3:
        cout << cara3_6;
        break;
    case 4:
        cout << cara4_6;
        break;
    case 5:
        cout << cara5_6;
        break;
    case 6:
        cout << cara6_6;
        break;
    default:
        cout << "ERROR, " << numero << " NO HA SIDO POSIBLE!\n"; // mensaje de error si se intenta imprimir un número fuera de rango [1-6]
        break;
    }

    cout << "\n"; // Otro salto de línea después del dibujo
}

void pedir_cara_usuario()
{
    // PEDIR NUMERO AL USUARIO
    string cara_usuario_str; // guardar el texto que el usuario ponga
    cout << "PON UN NUMERO ENTRE 1 Y 6 --> "; // muestra texto en pantalla
    cin >> cara_usuario_str; // lee la entrada y la guarda en "cara_usuario"

    int numero = stoi(cara_usuario_str); // convierte el texto en un número entero

    // COMPROVACION DEL NUMERO ENTRE 1 Y 6 EN BUCLE
    while (numero < 1 || 6 < numero) // bucle que se repite para introducir un valor válido
    {
        cout << "ESTA NUMERO ESTA FUERA DEL RANGO, CUIDADO! VUELVE HACERLO --> "; // mensaje de error 
        cin >> cara_usuario_str; // espera y lee la entrada de texto que el usuario escribe
        numero = stoi(cara_usuario_str); // convierte una string en int
    }

    cout << "NUMERO DE CARA PUESTA" << endl; // muestra texto en pantalla
    imprimir_dado_cara_6(numero); // dibujo de la cara del dado elegida por el usuario
}

int main() // inicio del programa
{
    srand(time(NULL)); // inicialización de números random

    // pedir_cara_usuario();

    int cara_aleatoria = 1 + rand() % 6; // generar número aleatorio (entre 1 y 6)
    cout << "EL NUMERO ESCOGIDO DE FORMA RANDOM ES EL SIGUIENTE --> " << cara_aleatoria << endl; // muestra el resultado numérico final
    imprimir_dado_cara_6(cara_aleatoria); // muestra en pantalla la cara del dado random


    cara_aleatoria = 1 + rand() % 12; // generar número aleatorio (entre 1 y 12)
    cout << "ESTO ES UNA TIRADA ALEATORIA DE 12 CARAS --> " << cara_aleatoria << endl; // muestra texto en pantalla
    imprimir_dado_cara(cara_aleatoria); // muestra en pantalla la cara del dado random

    // GENERA NUM ALEATORIO ENTRE 1 Y 6 IMPRIME LA CARA DEL DADO DURANTE 4 ITERACIONES
    for (int i = 0; i < 4; i++)
    {
        int cara_aleatoria = 1 + rand() % 6; // generar número aleatorio (entre 1 y 6)
        cout << "EL NUMERO ESCOGIDO DE FORMA RANDOM ES EL SIGUIENTE --> " << cara_aleatoria << endl; // muestra el resultado numérico final
        imprimir_dado_cara_6(cara_aleatoria); // muestra en pantalla la cara del dado random
    }
    
    Sleep(1000); // pausar la ejecución del programa 1 segundo
    return 0; // final del programa
}