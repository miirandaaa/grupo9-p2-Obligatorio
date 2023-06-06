import org.apache.commons.csv.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CargaDatos {
    public void datos() throws IOException {
        Reader in = new FileReader("Obligatorio/src/Dataset/f1_dataset_test.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        int counter=10;
        for (CSVRecord record : records) {
            System.out.println(record.get(1));
            counter--;
            if(counter==0){
                break;
            }
        }
    }
}
