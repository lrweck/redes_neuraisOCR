/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes.neurais;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisr
 */
public final class FileConverter {

    private List<Digito> lista = new ArrayList<>();

    public FileConverter() {
    }

    public FileConverter(List<List<String>> arquivo) throws FileNotFoundException {
        convert(arquivo);
    }

    public List<Digito> getLista() {
        return lista;
    }

    public void addElement(Digito d) {
        this.lista.add(d);
    }

    public void convert(List<List<String>> listaArquivo) {

        for (int i = 0; i < listaArquivo.size(); i++) { // Quantidade de Elementos
            lista.add(lineToDigito(listaArquivo.get(i)));
        }
    }

    private Digito lineToDigito(List<String> linha) {

        Digito d = new Digito();

        byte X = 0;
        byte Y = 0;
        String numero = "";

        for (int i = 0; i < linha.size(); i++) {
            if (i < 256) {
                if (Y == 16) {
                    Y = 0;
                    X++;
                }
                d.setXY(X, Y, Float.parseFloat(linha.get(i).trim()));
                Y++;
            } else {
                numero += linha.get(i).trim();
            }
        }

        switch (numero) {
            case "1000000000":
                d.setNumeroReal(0);
                break;
            case "0100000000":
                d.setNumeroReal(1);
                break;
            case "0010000000":
                d.setNumeroReal(2);
                break;
            case "0001000000":
                d.setNumeroReal(3);
                break;
            case "0000100000":
                d.setNumeroReal(4);
                break;
            case "0000010000":
                d.setNumeroReal(5);
                break;
            case "0000001000":
                d.setNumeroReal(6);
                break;
            case "0000000100":
                d.setNumeroReal(7);
                break;
            case "0000000010":
                d.setNumeroReal(8);
                break;
            case "0000000001":
                d.setNumeroReal(9);
                break;
        }
        return d;
    }

}
