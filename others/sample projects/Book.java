public class Book {
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private String publicationDate;

    // Constructor
    public Book(int bookID, String title, String author, String genre, String publicationDate) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    // Getters and setters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}