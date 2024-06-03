import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddsBooksToDataBase {
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library catalog system";
        String username = "Jareth";
        String password = "Jareth0223";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insertQuery = "INSERT INTO books (title, author, genre, publicationDate) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Loop through each book and add it to the database
            addBook();
            // Assuming you have a List<Book> named "books" containing Book objects
            for (Book book : books) {
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setString(3, book.getGenre());
                preparedStatement.setDate(4, java.sql.Date.valueOf(book.getPublicationDate()));
                preparedStatement.executeUpdate();
            }

            System.out.println("Books added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addBook() {
        // Add the 100 books to the list
        books.add(new Book(1, "To Kill a Mockingbird", "Harper Lee", "Fiction", "1960-07-11"));
        books.add(new Book(2, "1984", "George Orwell", "Science Fiction", "1949-06-08"));
        books.add(new Book(3, "Pride and Prejudice", "Jane Austen", "Romance", "1813-01-28"));
        books.add(new Book(4, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "1925-04-10"));
        books.add(new Book(5, "Animal Farm", "George Orwell", "Political Satire", "1945-08-17"));
        books.add(new Book(6, "The Catcher in the Rye", "J.D. Salinger", "Fiction", "1951-07-16"));
        books.add(new Book(7, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "1954-07-29"));
        books.add(new Book(8, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "1997-06-26"));
        books.add(new Book(9, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", "1998-07-02"));
        books.add(new Book(10, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", "1999-07-08"));
        books.add(new Book(11, "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", "2000-07-08"));
        books.add(new Book(12, "Harry Potter and the Order of the Phoenix", "J.K. Rowling", "Fantasy", "2003-06-21"));
        books.add(new Book(13, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasy", "2005-07-16"));
        books.add(new Book(14, "Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasy", "2007-07-21"));
        books.add(new Book(15, "The Hobbit", "J.R.R. Tolkien", "Fantasy", "1937-09-21"));
        books.add(new Book(16, "The Da Vinci Code", "Dan Brown", "Mystery", "2003-03-18"));
        books.add(new Book(17, "The Alchemist", "Paulo Coelho", "Fantasy", "1988-09-01"));
        books.add(new Book(18, "The Chronicles of Narnia", "C.S. Lewis", "Fantasy", "1950-10-16"));
        books.add(new Book(19, "The Hunger Games", "Suzanne Collins", "Science Fiction", "2008-09-14"));
        books.add(new Book(20, "Catch-22", "Joseph Heller", "Satire", "1961-10-10"));
        books.add(new Book(21, "Lord of the Flies", "William Golding", "Fiction", "1954-09-17"));
        books.add(new Book(22, "Moby-Dick", "Herman Melville", "Adventure", "1851-10-18"));
        books.add(
                new Book(23, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", "1979-10-12"));
        books.add(new Book(24, "The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction", "1890-07-20"));
        books.add(new Book(25, "Frankenstein", "Mary Shelley", "Horror", "1818-01-01"));
        books.add(new Book(26, "Brave New World", "Aldous Huxley", "Science Fiction", "1932-01-01"));
        books.add(new Book(27, "Wuthering Heights", "Emily Bronte", "Gothic Fiction", "1847-12-19"));
        books.add(new Book(28, "The Secret Garden", "Frances Hodgson Burnett", "Children's", "1911-10-01"));
        books.add(new Book(29, "Anne of Green Gables", "Lucy Maud Montgomery", "Children's", "1908-04-01"));
        books.add(new Book(30, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery", "1892-10-14"));
        books.add(new Book(31, "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", "1865-11-26"));
        books.add(new Book(32, "The Adventures of Tom Sawyer", "Mark Twain", "Fiction", "1876-12-01"));
        books.add(new Book(33, "The Adventures of Huckleberry Finn", "Mark Twain", "Fiction", "1884-12-10"));
        books.add(new Book(34, "Little Women", "Louisa May Alcott", "Fiction", "1868-09-30"));
        books.add(new Book(35, "The War of the Worlds", "H.G. Wells", "Science Fiction", "1898-01-01"));
        books.add(new Book(36, "Don Quixote", "Miguel de Cervantes", "Fiction", "1605-01-16"));
        books.add(new Book(37, "Dracula", "Bram Stoker", "Horror", "1897-05-26"));
        books.add(new Book(38, "Crime and Punishment", "Fyodor Dostoevsky", "Psychological Fiction", "1866-01-01"));
        books.add(new Book(39, "The Count of Monte Cristo", "Alexandre Dumas", "Adventure", "1844-08"));
        books.add(new Book(40, "Les Misérables", "Victor Hugo", "Historical Fiction", "1862-03-15"));
        books.add(new Book(41, "The Kite Runner", "Khaled Hosseini", "Fiction", "2003-05-29"));
        books.add(new Book(42, "The Road", "Cormac McCarthy", "Post-Apocalyptic Fiction", "2006-09-26"));
        books.add(new Book(43, "Great Expectations", "Charles Dickens", "Fiction", "1861-08-01"));
        books.add(new Book(44, "The Bell Jar", "Sylvia Plath", "Autobiographical Fiction", "1963-01-14"));
        books.add(new Book(45, "The Scarlet Letter", "Nathaniel Hawthorne", "Romance", "1850-03-16"));
        books.add(new Book(46, "The Grapes of Wrath", "John Steinbeck", "Fiction", "1939-04-14"));
        books.add(new Book(47, "The Odyssey", "Homer", "Epic Poetry", "8th century BCE"));
        books.add(new Book(48, "The Old Man and the Sea", "Ernest Hemingway", "Novella", "1952-09-01"));
        books.add(new Book(49, "Of Mice and Men", "John Steinbeck", "Fiction", "1937-02-06"));
        books.add(new Book(50, "Anna Karenina", "Leo Tolstoy", "Realist Fiction", "1877-01-01"));
        books.add(new Book(51, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Magical Realism",
                "1967-05-30"));
        books.add(new Book(52, "The Brothers Karamazov", "Fyodor Dostoevsky", "Philosophical Fiction", "1880-11-26"));
        books.add(new Book(53, "East of Eden", "John Steinbeck", "Family Saga", "1952-09-19"));
        books.add(new Book(54, "The Little Prince", "Antoine de Saint-Exupéry", "Children's Literature", "1943-04-06"));
        books.add(new Book(55, "Slaughterhouse-Five", "Kurt Vonnegut", "Science Fiction", "1969-03-31"));
        books.add(new Book(56, "War and Peace", "Leo Tolstoy", "Historical Fiction", "1869-01-01"));
        books.add(new Book(57, "Gone with the Wind", "Margaret Mitchell", "Historical Fiction", "1936-06-30"));
        books.add(new Book(58, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "1925-04-10"));
        books.add(new Book(59, "Moby-Dick", "Herman Melville", "Adventure", "1851-10-18"));
        books.add(new Book(60, "The Adventures of Huckleberry Finn", "Mark Twain", "Fiction", "1884-12-10"));
        books.add(new Book(61, "A Tale of Two Cities", "Charles Dickens", "Historical Fiction", "1859-04-30"));
        books.add(new Book(62, "The Adventures of Tom Sawyer", "Mark Twain", "Fiction", "1876-12-01"));
        books.add(new Book(63, "Crime and Punishment", "Fyodor Dostoevsky", "Psychological Fiction", "1866-01-01"));
        books.add(new Book(64, "The Brothers Karamazov", "Fyodor Dostoevsky", "Philosophical Fiction", "1880-11-26"));
        books.add(new Book(65, "Les Misérables", "Victor Hugo", "Historical Fiction", "1862-03-15"));
        books.add(new Book(66, "The Count of Monte Cristo", "Alexandre Dumas", "Adventure", "1844-08-28"));
        books.add(new Book(67, "Pride and Prejudice", "Jane Austen", "Romance", "1813-01-28"));
        books.add(new Book(68, "The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction", "1890-07-20"));
        books.add(new Book(69, "The Scarlet Letter", "Nathaniel Hawthorne", "Romance", "1850-03-16"));
        books.add(new Book(70, "The Call of the Wild", "Jack London", "Adventure", "1903-06-17"));
        books.add(new Book(71, "Treasure Island", "Robert Louis Stevenson", "Adventure", "1883-05-23"));
        books.add(new Book(72, "Dracula", "Bram Stoker", "Gothic Horror", "1897-05-26"));
        books.add(new Book(73, "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", "1865-11-26"));
        books.add(new Book(74, "Around the World in Eighty Days", "Jules Verne", "Adventure", "1873-01-30"));
        books.add(new Book(75, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery", "1892-10-14"));
        books.add(new Book(76, "The Three Musketeers", "Alexandre Dumas", "Historical Adventure", "1844-03-14"));
        books.add(new Book(77, "Anne of Green Gables", "Lucy Maud Montgomery", "Children's", "1908-04-01"));
        books.add(new Book(78, "Wuthering Heights", "Emily Brontë", "Gothic Fiction", "1847-12-19"));
        books.add(new Book(79, "Little Women", "Louisa May Alcott", "Coming-of-Age Fiction", "1868-09-30"));
        books.add(new Book(80, "The Iliad", "Homer", "Epic Poetry", "8th century BCE"));
        books.add(new Book(81, "The Odyssey", "Homer", "Epic Poetry", "8th century BCE"));
        books.add(new Book(82, "A Christmas Carol", "Charles Dickens", "Novella", "1843-12-19"));
        books.add(new Book(83, "The Wind in the Willows", "Kenneth Grahame", "Children's", "1908-10-08"));
        books.add(new Book(84, "The Jungle Book", "Rudyard Kipling", "Children's", "1894-10-05"));
        books.add(new Book(85, "The Adventures of Pinocchio", "Carlo Collodi", "Children's", "1883-07-07"));
        books.add(new Book(86, "The War of the Worlds", "H.G. Wells", "Science Fiction", "1898-01-01"));
        books.add(new Book(87, "Frankenstein", "Mary Shelley", "Gothic Horror", "1818-01-01"));
        books.add(new Book(88, "The Time Machine", "H.G. Wells", "Science Fiction", "1895-05-07"));
        books.add(new Book(89, "Peter Pan", "J.M. Barrie", "Children's", "1911-12-27"));
        books.add(new Book(90, "The Adventures of Tom Sawyer", "Mark Twain", "Fiction", "1876-12-01"));
        books.add(new Book(91, "Black Beauty", "Anna Sewell", "Children's", "1877-11-24"));
        books.add(new Book(92, "The Secret Garden", "Frances Hodgson Burnett", "Children's", "1911-10-01"));
        books.add(new Book(93, "The Arabian Nights", "Anonymous", "Folklore", "8th-14th century"));
        books.add(new Book(94, "Robinson Crusoe", "Daniel Defoe", "Adventure", "1719-04-25"));
        books.add(new Book(95, "Gulliver's Travels", "Jonathan Swift", "Satire", "1726-10-28"));
        books.add(new Book(96, "Jane Eyre", "Charlotte Brontë", "Gothic Romance", "1847-10-16"));
        books.add(new Book(97, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery", "1892-10-14"));
        books.add(new Book(98, "Great Expectations", "Charles Dickens", "Coming-of-Age Fiction", "1861-08-01"));
        books.add(new Book(99, "The Count of Monte Cristo", "Alexandre Dumas", "Adventure", "1844-08-28"));
        books.add(new Book(100, "Charlotte's Web", "E.B. White", "Children's", "1952-10-15"));
    }
}
