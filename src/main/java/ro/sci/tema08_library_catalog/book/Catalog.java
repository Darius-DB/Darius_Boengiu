package ro.sci.tema08_library_catalog.book;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private static List<Book> bookList = new ArrayList<>();
    private static List<Novel> novelList = new ArrayList<>();
    private static List<ArtAlbum> artAlbumList = new ArrayList<>();

    public Catalog() {
    }

    public static void addBooks(Book book) {
        if (book instanceof Novel) {
            novelList.add((Novel) book);
        } else if (book instanceof ArtAlbum) {
            artAlbumList.add((ArtAlbum) book);
        } else {
            bookList.add(book);
        }
    }

    public static void addBooks(Book ...book) {
        for (Book bookItem : book) {
            if (bookItem instanceof Novel) {
                novelList.add((Novel) bookItem);
            } else if (bookItem instanceof  ArtAlbum) {
                artAlbumList.add((ArtAlbum) bookItem);
            } else {
                bookList.add(bookItem);
            }
        }
    }

    public static void deleteBooks(Book book) {
        if (book instanceof Novel) {
            novelList.remove(book);
        } else if (book instanceof ArtAlbum) {
            artAlbumList.remove(book);
        } else {
            bookList.remove(book);
        }
    }

    public static void deleteBooks(Book ...book) {
        for (Book bookItem : book) {
            if (bookItem instanceof Novel) {
                novelList.remove(bookItem);
            } else if (bookItem instanceof ArtAlbum) {
                artAlbumList.remove(bookItem);
            } else {
                bookList.remove(bookItem);
            }
        }
    }

    public static void listBooks() {
        System.out.println(bookList);
    }

    public static void listBooks(String category) {
        if (category.equalsIgnoreCase("novel")) {
            System.out.println(novelList);
        } else if (category.equalsIgnoreCase("art album")) {
            System.out.println(artAlbumList);
        }
    }


}
