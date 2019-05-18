/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes.neurais;

/**
 *
 * @author luisr
 */
public class Digito {

    private boolean[][] matrizDigito = new boolean[16][16];
    private int numeroReal;

    public Digito() {
    }

    public Digito(boolean[][] matrizDigito, byte numeroReal) {
        this.matrizDigito = matrizDigito;
        this.numeroReal = numeroReal;
    }

    public int getNumeroReal() {
        return numeroReal;
    }

    public void setNumeroReal(int numeroReal) {
        this.numeroReal = numeroReal;
    }

    public boolean[][] getMatrizDigito() {
        return matrizDigito;
    }
    
    public void setXY(byte X, byte Y, float valor){
        this.matrizDigito[X][Y] = (valor == 1.0f);
    }

    public void setMatrizDigito(boolean[][] matrizDigito) {
        this.matrizDigito = matrizDigito;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("\n");
        b.append("Número real: ").append(this.numeroReal).append("\n");
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                b.append(!matrizDigito[i][j] ? "░" : "▓");
            }
            b.append("\n");
        }
        return b.toString();
    }
    
    public String toSample(){
        StringBuilder b = new StringBuilder();
        b.append(this.numeroReal);
        b.append(" ");
        for (int i = 0; i < matrizDigito.length; i++) {
            for (int j = 0; j < matrizDigito.length; j++) {
                b.append(!matrizDigito[i][j] ? "0" : "1");
            }
        }
        return b.toString();
    }
}
