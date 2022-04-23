import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _5Programe {
    private static String citesteCLI(String[] args) {
        /**
         * citeste din linia de comanda numele fisierului
         */
        String stringCLI = "";
        for (int i = 0; i < args.length; i++) {
            stringCLI += args[i] + " ";
        }
        stringCLI.trim();
        return stringCLI;
    }

    private static List<List<String>> citesteFisier(String numeFisier) {
        /**
         * citire a matricei dintr-un fisier
         */
        List<List<String>> matrice = new ArrayList<List<String>>();
        try {
            File fisier = new File(numeFisier);
            Scanner linii = new Scanner(fisier);
            while (linii.hasNextLine()) {
                String linie = linii.nextLine();
                List<String> linieArr = Arrays.asList(linie.split(" "));
                matrice.add(linieArr);
            }
            linii.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return matrice;
    }
    
    private static void arataMatrice(List<List<String>> matrice) {
        /**
         * afisare a matrice linie cu linie
         */
        for (List<String> i : matrice) {
            String linie = "";
            for (String j : i) {
                linie += j + " ";
            }
            linie.trim();
            System.out.println(linie);
        }
    }

    private static void arataMatriceElemente(List<List<String>> matrice) {
        /**
         * afisare a matrice element cu element dupa forma nr linie, nr coloana si valoare
         */
        for (int i = 0; i < matrice.size(); i++) {
            for (int j = 0; j < matrice.get(i).size(); j++) {
                System.out.println("Linie " + i + " | Coloana " + j + " | Valoare " + matrice.get(i).get(j));
            }
        }
    }

    private static int verificaVector(List<String> vector1, List<String> vector2) {
        /**
         * functie ajutatoare pentru sortarea matricei
         */
        int n = 0;
        if (vector1.size() < vector2.size()) {
            n = vector1.size();
        }
        else n = vector2.size();
        for (int i = 0; i < n; i++) {
            if (vector1.get(i).compareTo(vector2.get(i)) > 0) {
                return 1;
            }
            else if (vector1.get(i).compareTo(vector2.get(i)) < 0) {
                return -1;
            }
        }
        return 0;
    }

    private static void sorteazaMatrice(List<List<String>> matrice) {
        /**
         * sorteaza matrice data prin tehnica sortarii prin insertie
         */
        for (int i = 0; i < matrice.size(); i++) {
            List<String> cheie = matrice.get(i);
            int j = i - 1;

            while (j >= 0 && verificaVector(cheie, matrice.get(j)) < 0) {
                matrice.set(j + 1, matrice.get(j));
                j--;
            }
            matrice.set(j + 1, cheie);
        }
    }

    private static void startapp(String[] args) {
        //se da fisier in linia de comanda
        String stringInput = citesteCLI(args);
        
        //citire matrice din fisier
        List<List<String>> matriceCitita = citesteFisier(stringInput);
        
        //afisare intreaga matrice
        System.out.println("Inainte de sortare: ");
        arataMatrice(matriceCitita);
        
        //afisare matrice element cu element
        arataMatriceElemente(matriceCitita);
        
        //sortam matricea folosing sortarea prin insertie
        sorteazaMatrice(matriceCitita);
        
        //afisam la final matricea
        System.out.println("---------------------\nDupa sortare: ");
        arataMatrice(matriceCitita);
    }
    public static void main(String[] args) {
        startapp(args);
    }
}