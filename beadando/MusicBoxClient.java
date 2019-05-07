package beadando;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class MusicBoxClient {

   
    public static void main(String[] args) throws Exception {
        String MACHINE = "localhost";
        // String MACHINE = "127.0.0.1";
        // String MACHINE = "::1";
        int PORT = 40000;
  
        try (
                Socket s = new Socket(MACHINE, PORT);
                Scanner sc = new Scanner(s.getInputStream());
                Scanner sc2 = new Scanner(System.in);
                PrintWriter pw = new PrintWriter(s.getOutputStream());
              
                ) {

            while (sc2.hasNextLine()) {
                String  line = sc2.nextLine();
                
                System.out.println(line);
                pw.println(line);
                pw.flush();
                
            }

           
               
          

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

    }

}
