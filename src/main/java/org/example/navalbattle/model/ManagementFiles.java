package org.example.navalbattle.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManagementFiles {
    String serializable = "serializable.ser"; //File name
    File file = new File(serializable);
    public void creatingFile(){
        try{

            if (file.createNewFile()) {

                System.out.println("Created file: " + file.getName());
            } else {
                System.out.println("Already there is a file."+file.getPath());
            }

        }catch(IOException e){
            System.out.println("Error to create file.");
            e.printStackTrace();
        }
    }

    public void WritingOnFile(){  //NO SE SABE SI AQUÍ DEBE IR
        try{
            FileWriter writer = new FileWriter(file);
            writer.write("Game state..."); // Message to write
            writer.close();
            System.out.println("Writed content on file.");
        }catch(IOException e){
            System.out.println("Error to write on file.");
            e.printStackTrace();
        }

    }

    public boolean isEmpty(){
        if (file.length() != 0){
            return false;
        }
        return true;
    }

    public String getFilePath() {
        return file.getPath();
    }
}
