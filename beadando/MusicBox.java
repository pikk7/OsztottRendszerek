
package beadando;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
//import beadando.Song;

public class MusicBox {
    public static void main(String[] args) throws Exception {
        ArrayList<Song> mySongs=new ArrayList<>();
        int PORT = 40000;
        Double speed;
        Sting trans;
        String title;
        ArrayList<String> sounds=new ArrayList<>;
        try (ServerSocket ss = new ServerSocket(PORT);) {
            while (true) {
                try (Socket s = ss.accept();
                        Scanner sc = new Scanner(s.getInputStream());
                        PrintWriter pw = new PrintWriter(s.getOutputStream());) {

                    while (sc.hasNextLine()) {
                        String[] input = sc.nextLine().split("\\s");
                        String tmp = input[0];
                        switch (tmp) {
                        case "add":
                            title=input[1];
                            sounds=new ArrayList<>(sc.nextLine().split("\\s"));
                            Song newSong=new Song(title,sounds);
                            mySongs.add(newSong);
                            System.out.println( mySongs.get(mySongs.size()-1).title);
                            System.out.println( mySongs.get(mySongs.size()-1).sounds);
                            
                            break;
                        case "addlyrics":
                            System.out.println(input[1]);
                            for(int i=0;i<mySongs.size();i++){
                                if(mySongs.get(i).title.equals(input[1])){
                                    mySongs.get(i).addLyrics(sc.nextLine());
                                }
                            }
                            break;

                        case "play":
                             speed=input[1];
                             trans=input[2];
                             title=input[3];
                            break;
                        case "change":
                            System.out.println(input[1]);
                            break;
                        case "stop":
                            System.out.println(input[1]);
                            break;
                        default:
                            System.out.println("Nincs ilyen, probald ujra");

                        }
                    }

                }
            }

        }
    }

}
