import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers (String fileLocation) {
        list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public void writeContentToFile(String fileLocation){
        File file = new File(fileLocation);
        if (!file.exists()){
        try {
            file.createNewFile();
            System.out.println("File was created");
        }
        catch (IOException ex){
            System.out.println("file not created!");
        }
    }
    else {
            try {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
                for (Integer x : list){
                    fileWriter.write(x + "\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
             catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        }

    public void readConntentFromFile(String fileLocation) {
        File file2 = new File(fileLocation);
        try {
            if (!file2.exists()) throw new ExceptionForTest("file not exists");
            else if (file2.length() == 0) throw new ExceptionForTest("file is empty");
            else {
                try {
                    String text =null;
                    BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
                    while ((text = reader.readLine()) != null){
                        list.add(Integer.parseInt(text));
                    }
                    for (int x : list){
                        System.out.println(x);
                    }
                }
                catch (IOException e){
                    System.out.println("File not foud");
                }
            }
        }
        catch (ExceptionForTest e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        ListOfNumbers list = new ListOfNumbers("/Users/sergey/Downloads/Demo111.txt");
        list.writeContentToFile("/Users/sergey/Downloads/Demo111.txt");

    }
}