async function citesteCLI() {
    /**
     * citeste din linia de comanda numele fisierului
     */
    var stringCLI = "";

    var args = process.argv.slice(2);

    for (let i = 0; i < args.length; i++) {
        stringCLI += ' ' + args[i];
        stringCLI = stringCLI.trimStart();
    }
    return stringCLI;
}

async function citesteFisier(numeFisier) {
    /**
     * citire a matricei dintr-un fisier
     */
    var matrice = [];

    const fs = require('fs');
    const readline = require('readline');

    const fisier = readline.createInterface({
        input: fs.createReadStream(numeFisier),
        output: process.stdout,
        terminal: false
    });

    for await (const linie of fisier) {
        var elemente = linie.split(" ")
        matrice.push(elemente);
    }
    return matrice;
}

function arataMatrice(matrice) {
    /**
     * afisare a matrice linie cu linie
     */
    for (let i = 0; i < matrice.length; i++) {
        var linie = "";
        for(let j = 0; j <matrice[i].length; j++) {
            linie += ' ' + matrice[i][j];
        }
        linie = linie.trimStart();
        console.log(linie);
    }
}

function arataMatriceElemente(matrice) {
    /**
     * afisare a matrice element cu element dupa forma nr linie, nr coloana si valoare
     */
    for (let i = 0; i < matrice.length; i++) {
        for(let j = 0; j <matrice[i].length; j++) {
            console.log('Linie %d | Coloana %d | Valoare %s', i, j, matrice[i][j])
        }
    }
}

function sorteazaMatrice(matrice) {
    /**
     * sorteaza matrice data prin tehnica sortarii prin insertie
     */
    for (let i = 1; i < matrice.length; i++) {
        cheie = matrice[i];
        j = i - 1;
        while (j >= 0 && cheie < matrice[j]) {
            matrice[j + 1] = matrice[j];
            j -= 1;
        }
        matrice[j + 1] = cheie
    }
}

async function startapp() {
    //se da fisier in linia de comanda
    let stringInput = await citesteCLI()

    //citire matrice din fisier
    let matriceCitita = await citesteFisier(stringInput)
    
    //afisare intreaga matrice
    console.log("Inainte de sortare: ");
    arataMatrice(matriceCitita)
    
    //afisare matrice element cu element
    arataMatriceElemente(matriceCitita)
    
    //sortam matricea folosing sortarea prin insertie
    sorteazaMatrice(matriceCitita)
    
    //afisam la final matricea
    console.log("---------------------\nDupa sortare: ");
    arataMatrice(matriceCitita)
}

startapp()