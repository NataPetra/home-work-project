package classes;

import java.io.*;

public class Counter {

    private int number;
    private static final String fileName = System.getenv().get("USERPROFILE") + File.separator + "tempForNata" + File.separator + "counterResult.txt";

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int checkFile(){
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            number=dis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    public void writeInt(int num){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}