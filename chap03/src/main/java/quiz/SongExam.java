package quiz;

public class SongExam {
    public static void main(String[] args) {
        Song song1 = new Song();
        song1.setTitle("수퍼노바");
        song1.setArtist("에스파");
        song1.setGenre("K-pop");
        song1.setLyrics("수수수 수퍼노바");
        song1.setPlayTime(180);
        song1.output();

        Song song2 = new Song();
        song2.setTitle("제목2");
        song2.setArtist("가수2");
        song2.setGenre("장르2");
        song2.setLyrics("가사2");
        song2.setPlayTime(240);
        song2.output();
    }
}
