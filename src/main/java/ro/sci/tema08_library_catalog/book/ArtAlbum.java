package ro.sci.tema08_library_catalog.book;

public class ArtAlbum extends Book{
    private String paperQuality;

    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", paperQuality=" + paperQuality +
                '}';
    }
}
