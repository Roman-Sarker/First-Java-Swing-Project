package jswingfirstproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class TextFile {

    public void writeTextFile(String pContent) throws IOException {
        BufferedWriter textBuild = null;
        try {
            //File file = new File("E:\\StudentInfo.txt");
            File file = new File("StudentInfo.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            textBuild = new BufferedWriter(fileWriter);
            textBuild.write(pContent);
            textBuild.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (textBuild != null) {
                textBuild.close();
            }
        }
    }

    public String readTextFileLine(String pFileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(pFileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line.replace(',', '\t'));
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String readValue = sb.toString();
            //System.out.println("Read Value :"+readValue);

            return readValue;
        } finally {
            br.close();
        }

    }

    public String readTextFileChar(String pFileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(pFileName));
        String line = br.readLine();
        char carecter = 0;
        String readData = "";
        int len = 0;

        StringBuilder sb = new StringBuilder();
        try {
            while (line != null) {
                len = line.length();
                for (int i = 0; i < len; i++) {
                    carecter = (char)line.charAt(i);
                    if (carecter == ',') {
                        carecter = '\t';
                    }
                    readData = readData + carecter;
                }
                sb.append(readData);
//                sb.append("<BR />");
//                sb.append(System.lineSeparator()); 
//                sb.append(System.getProperty("line.separator"));
//                sb.append('\n');
                line = br.readLine();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
            }
        }

        return readData;
    }

    public static void main(String[] args) throws IOException {

        TextFile textFile = new TextFile();
//        textFile.writeTextFile("Roman Sarker Rana");
//        System.out.println("Successfully write text file.");

        System.out.println(textFile.readTextFileLine("StudentInfo.txt"));
        //System.out.println(textFile.readTextFileChar("StudentInfo.txt"));
    }
}
