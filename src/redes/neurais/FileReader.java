/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes.neurais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luisr
 */
public class FileReader {

    private String arquivo;
    private String delimitador;
    
    public FileReader() {
    }

    public FileReader(String arq, String delimitador) {
        this.arquivo = arq;
        this.delimitador = delimitador;
    }

    public List<List<String>> ler() throws FileNotFoundException {

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(this.arquivo));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        
//        System.out.println("size: "+ records.size());
//        for (int i = 0; i < records.size(); i++) {
//            System.out.println("size2: " + records.get(i).size());
//            for (int j = 0; j < records.get(i).size(); j++) {
//                System.out.println(records.get(i));
//            }
//            
//        }
        
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(this.delimitador);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
