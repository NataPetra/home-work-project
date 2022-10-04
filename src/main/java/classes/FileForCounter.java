package classes;

import java.io.File;
import java.io.IOException;

public class FileForCounter {

    private static final String fileName = "counterResult.txt";
    private static Counter counter;

    public static void createFile(){
        String nameDir = System.getenv().get("USERPROFILE") + File.separator + "tempForNata";
        File dir = new File(nameDir);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(nameDir + File.separator + fileName);
        counter = new Counter();
        if(!file.exists()){
            try {
                file.createNewFile();
                counter.setNumber(0);
                counter.writeInt(counter.getNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
