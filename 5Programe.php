<?php

    function citesteCLI($argv, $argc) {
        /**
         * citeste din linia de comanda numele fisierului
         */
        $stringCLI = "";
        for ($i=1; $i < $argc; $i++) {
            $stringCLI .= $argv[$i] . ' ';
        }
        $stringCLI = trim($stringCLI);
        return $stringCLI;
    }

    function citesteFisier($numeFisier) {
        /**
         * citire a matricei dintr-un fisier
         */
        $matrice = [];

        $linii = file($numeFisier);
        foreach ($linii as $linie) {
            $matrice[] = explode(' ', $linie);
        }
        return $matrice;
    }

    function arataMatrice($matrice) {
        /**
         * afisare a matrice linie cu linie
         */
        for($i = 0; $i < count($matrice); $i++) {
            $linie = '';
            for ($j = 0; $j < count($matrice[$i]); $j++) {
                $linie .= ' ' . $matrice[$i][$j];
            }
            $linie = trim($linie);
            $linie .= "\n";
            echo $linie;
        }
    }

    function arataMatriceElemente($matrice) {
        /**
         * afisare a matrice element cu element dupa forma nr linie, nr coloana si valoare
         */
        for ($i = 0; $i < count($matrice); $i++) {
            for ($j = 0; $j < count($matrice[$i]); $j++) {
                echo 'Linie ' . $i . ' | Coloana ' . $j . ' | Valoare ' . $matrice[$i][$j] . "\n";
            }
        }
    }

    function verificaVector($vector1, $vector2) {
        /**
         * functie ajutatoare pentru sortarea matricei
         */
        $n = 0;
        if (count($vector1) < count($vector2)) {
            $n = count($vector1);
        }
        else $n = count($vector2);
        for ($i = 0; $i < $n; $i++) {
            if ($vector1[$i] > $vector2[$i]) {
                return 1;
            } elseif ($vector1[$i] < $vector2[$i]) {
                return -1;
            }
        }
        return 0;
    }

    function sorteazaMatrice(&$matrice) {
        /**
         * sorteaza matrice data prin tehnica sortarii prin insertie
         */
        for ($i = 0; $i < count($matrice); $i++) {
            $cheie = $matrice[$i];
            $j = $i - 1;

            while ($j >= 0 && verificaVector($cheie, $matrice[$j]) < 0) {
                $matrice[$j + 1] = $matrice[$j];
                $j--;
            }
            $matrice[$j + 1] = $cheie;
        }
    }

    function startapp($argv, $argc) {
        //se da fisier in linia de comanda
        $stringInput = citesteCLI($argv, $argc);
        
        //citire matrice din fisier
        $matriceCitita = citesteFisier($stringInput);
        
        //afisare intreaga matrice
        echo "Inainte de sortare: \n";
        arataMatrice($matriceCitita);
        
        //afisare matrice element cu element
        arataMatriceElemente($matriceCitita);
        
        //sortam matricea folosing sortarea prin insertie
        sorteazaMatrice($matriceCitita);
        
        //afisam la final matricea
        echo "---------------------\nDupa sortare: \n";
        arataMatrice($matriceCitita);
    }

    startapp($argv, $argc);
?>