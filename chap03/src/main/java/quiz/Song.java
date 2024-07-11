package quiz;

public class Song {
    String title;
    String artist;
    String genre;
    String lyrics;
    int playTime; //곡길이

    void setTitle(String title) {
        this.title = title;
    }
    void setArtist(String artist) {
        this.artist = artist;
    }
    void setGenre(String genre) {
        this.genre = genre;
    }
    void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
    void setPlayTime(int playTime) {
        this.playTime = playTime;
    }
    void output(){
        System.out.println("title = " + title);
        System.out.println("artist = " + artist);
        System.out.println("genre = " + genre);
        System.out.println("lyrics = " + lyrics);
        System.out.println("playTime = " + playTime);
    }
}
