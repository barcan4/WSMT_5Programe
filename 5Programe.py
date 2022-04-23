import sys


def citesteCLI() -> str:
    '''
    citeste din linia de comanda numele fisierului
    '''
    stringCLI = ""
    for i in range(1, len(sys.argv)):
        stringCLI += sys.argv[i] + " "
    stringCLI.strip()
    return stringCLI

def citesteFisier(numeFisier: str) -> list:
    '''
    citire a matricei dintr-un fisier
    '''

    matrice = []

    try:
        fisier = open(numeFisier, "r")
        stringuri = fisier.read()
        linii = stringuri.split("\n")

        for linie in linii:
            valoriLinii = linie.split(" ")
            matrice.append(valoriLinii)
    except IOError:
        print("Nu s-a aflat un fisier cu acest nume")
    
    return matrice

def arataMatrice(matrice: list) -> None:
    '''
    afisare a matrice linie cu linie
    '''

    for i in range(len(matrice)):
        linie = "";
        for j in range(len(matrice[i])):
            linie += matrice[i][j] + " "
        print(linie)

def arataMatriceElemente(matrice: list) -> None:
    '''
    afisare a matrice element cu element dupa forma nr linie, nr coloana si valoare
    '''

    for i in range(len(matrice)):
        for j in range(len(matrice[i])):
            print("Linia ", i," | Coloana ", j," | Valoarea ", matrice[i][j])


def sorteazaMatrice(matrice: list) -> None:
    '''
    sorteaza matrice data prin tehnica sortarii prin insertie
    '''
    for i in range(1, len(matrice)):
        cheie = matrice[i]
        j = i - 1
        while j >= 0 and cheie < matrice[j]:
            matrice[j + 1] = matrice[j]
            j -= 1
        matrice[j + 1] = cheie

def startapp():
    
    #se da fisier in linia de comanda
    stringInput = citesteCLI()

    #citire matrice din fisier
    matriceCitita = citesteFisier(stringInput)
    
    #afisare intreaga matrice
    print("Inainte de sortare: ")
    arataMatrice(matriceCitita)
    
    #afisare matrice element cu element
    arataMatriceElemente(matriceCitita)

    #sortam matricea folosing sortarea prin insertie
    sorteazaMatrice(matriceCitita)

    #afisam la final matricea
    print("---------------------\nDupa sortare: ")
    arataMatrice(matriceCitita)


startapp()