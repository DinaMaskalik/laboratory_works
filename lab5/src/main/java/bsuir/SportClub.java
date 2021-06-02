package bsuir;

public class SportClub {

    private String section;
    private String FIO;
    private double price;

    public SportClub(String section, String FIO, double price) {
        this.section = section;
        this.FIO = FIO;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "section='" + section + '\'' +
                ", FIO='" + FIO + '\'' +
                ", price=" + price +
                '}';
    }
}
