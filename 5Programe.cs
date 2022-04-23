using System;
using System.Collections.Generic;
using System.Linq;

class _5Programe
{
    private static string citesteCLI(string[] args) {
        //// 
        //// citeste din linia de comanda numele fisierului
        //// 
        string stringCLI = "";
        for (int i = 0; i < args.Length; i++) {
            stringCLI += args[i] + " ";
        }
        stringCLI.Trim();
        return stringCLI;
    }

    private static List<List<string>> citesteFisier(string numeFisier) {
        //// 
        //// citire a matricei dintr-un fisier
        //// 
        List<List<string>> matrice = new List<List<string>>();
        
        string[] linii = System.IO.File.ReadAllLines(numeFisier);
        foreach(string linie in linii) {
            List<string> linieArr = new List<string>(linie.Split(new string[] { " " }, StringSplitOptions.None));
            matrice.Add(linieArr);
        }
        return matrice;
    }

    private static void arataMatrice(List<List<string>> matrice) {
        //// 
        //// afisare a matrice linie cu linie
        //// 
        foreach (List<string> i in matrice)
        {
            string linie = "";
            foreach (string j in i)
            {
                linie += j + " ";
            }
            linie.Trim();
            Console.WriteLine(linie);
        }
    }

    private static void arataMatriceElemente(List<List<string>> matrice) {
        //// 
        //// afisare a matrice element cu element dupa forma nr linie, nr coloana si valoare
        //// 
        for (int i = 0; i < matrice.Count; i++)
        {
            for (int j = 0; j < matrice[i].Count; j++)
            {
                Console.WriteLine("Linie " + i + " | Coloana " + j + " | Valoare " + matrice[i][j]);
            }
        }
    }

    private static int verificaVector(List<string> vector1, List<string> vector2) {
        //// 
        //// functie ajutatoare pentru sortarea matricei
        //// 
        int n = 0;
        if (vector1.Count < vector2.Count) {
            n = vector1.Count;
        }
        else n = vector2.Count;
        for (int i = 0; i < n; i++)
        {
            if (String.Compare(vector1[i], vector2[i]) > 0) {
                return 1;
            }
            else if (String.Compare(vector1[i], vector2[i]) < 0) {
                return -1;
            }
        }
        return 0;
    }

    private static void sorteazaMatrice(List<List<string>> matrice) {
        //// 
        //// sorteaza matrice data prin tehnica sortarii prin insertie
        //// 
        for (int i = 0; i < matrice.Count; i++)
        {
            List<string> cheie = matrice[i];
            int j = i - 1;

            while (j >= 0 && verificaVector(cheie, matrice[j]) < 0) {
                matrice[j + 1] = matrice[j];
                j--;
            }
            matrice[j + 1] = cheie;
        }
    }

    static void Main(string[] args)
    {
        //se da fisier in linia de comanda
        string stringInput = citesteCLI(args);
        
        //citire matrice din fisier
        List<List<string>> matriceCitita = citesteFisier(stringInput);

        //afisare intreaga matrice
        Console.WriteLine("Inainte de sortare: ");
        arataMatrice(matriceCitita);

        //afisare matrice element cu element
        arataMatriceElemente(matriceCitita);
        
        //sortam matricea folosing sortarea prin insertie
        sorteazaMatrice(matriceCitita);
        
        //afisam la final matricea
        Console.WriteLine("---------------------\nDupa sortare: ");
        arataMatrice(matriceCitita);
    }
}