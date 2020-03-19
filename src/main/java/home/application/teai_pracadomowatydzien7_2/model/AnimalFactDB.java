package home.application.teai_pracadomowatydzien7_2.model;

public class AnimalFactDB {

    private long id;
    private String text;

    public AnimalFactDB(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public AnimalFactDB() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AnimalFactDB{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
