package beadando;

public class Song{
    public String title;
    public ArrayList<String> sounds;
    public ArrayList<String> lyrics;


    Song(String title,ArrayList<String> sounds){
        this.title=title;
        this.sounds=sounds;
    }

    public addLyrics(ArrayList<String> lyrics){
        this.lyrics=lyrics;
    }
}