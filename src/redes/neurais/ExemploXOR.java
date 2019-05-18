
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.encog.Encog;
import org.encog.engine.network.activation.ActivationTANH;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import redes.neurais.Digito;
import redes.neurais.FileConverter;
import redes.neurais.FileReader;

/**
 * Exemplo de RN para resolver o XOR. Esta implementa��o foi adaptada do
 * original em <http://www.heatonresearch.com/wiki/Hello_World>.
 *
 * O problema, os dados de entrada e sa�da est�o dispon�veis nos slides da
 * disciplina.
 *
 * @author Fernando dos Santos (fernando.santos@udesc.br)
 */
public class ExemploXOR {

    /**
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(final String args[]) throws FileNotFoundException, IOException {

        System.out.println("Working Directory = "
                + System.getProperty("user.dir"));

        FileReader f = new FileReader(".\\dataset\\semeion.data", " ");

        List<List<String>> arq = f.ler();
        FileConverter c = new FileConverter(arq);
//
//        for (int i = 0; i < c.getLista().size(); i++) {
//            long inicio = System.currentTimeMillis();
//            System.out.println(c.getLista().get(i) + "\n======\n");
//            System.out.println("Item: [" + i + "] - Tempo total: " + (System.currentTimeMillis() - inicio) + "ms ");
//        }

//        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter(".\\sample.dat"));
        

//        writer.close();
        for (int i = 0; i < c.getLista().size(); i++) {
            writer.write(c.getLista().get(i).toSample()+"\n");
        }
        writer.close();
    }
}
