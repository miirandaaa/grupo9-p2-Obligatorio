import org.apache.commons.csv.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CargaDatos {
    public void datos() throws IOException {
        Reader in = new FileReader("grupo9-p2-Obligatorio/Obligatorio/Dataset/f1_dataset_test.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        int counter=100;
        for (CSVRecord record : records) {
            System.out.println(record.get(1));
            counter--;
            if(counter==0){
                break;
            }
        }
    }
}
