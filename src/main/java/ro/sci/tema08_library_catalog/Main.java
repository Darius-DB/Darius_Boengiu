package ro.sci.tema08_library_catalog;

import ro.sci.tema08_library_catalog.book.ArtAlbum;
import ro.sci.tema08_library_catalog.book.Book;
import ro.sci.tema08_library_catalog.book.Catalog;
import ro.sci.tema08_library_catalog.book.Novel;


public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("The Book Thief", 584);
        Book novel1 = new Novel("A Song of Ice and Fire", 2000, "Fiction");
        Book novel2 = new Novel("Novel 2", 500, "SF");
        Book artAlbum1 = new ArtAlbum("Art Album", 50, "Bond Paper");
        Book artAlbum2 = new ArtAlbum("Art Album", 30, "Gloss Coated Paper");
        Book artAlbum3 = new ArtAlbum("Art Album", 20, "Matt Coated Paper");

        Catalog.addBooks(book1);

        Catalog.addBooks(novel1);
        Catalog.addBooks(novel2);

        Catalog.addBooks(artAlbum1);
        Catalog.addBooks(artAlbum2, artAlbum3);

        Catalog.listBooks();
        System.out.println("-------------------------------------------------------------------------");
        Catalog.listBooks("novel");
        System.out.println("-------------------------------------------------------------------------");
        Catalog.listBooks("art album");
        System.out.println("-------------------------------------------------------------------------");

        Catalog.deleteBooks(artAlbum1);
        Catalog.listBooks("art album");
        Catalog.deleteBooks(artAlbum2, artAlbum3);
        System.out.println("-------------------------------------------------------------------------");
        Catalog.listBooks("art album");



    }
}
