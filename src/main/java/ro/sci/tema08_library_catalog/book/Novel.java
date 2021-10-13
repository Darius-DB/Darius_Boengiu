package ro.sci.tema08_library_catalog.book;

public class Novel extends Book{
    private String type;

    public Novel(String name, int numberOfPages, String type) {
        super(name, numberOfPages);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", type=" + type +
                '}';
    }
}
