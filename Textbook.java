public class Textbook {
    private String title;
    private String author;
    private int copies;
    private double price;
    private String bankingInfo;

    public Textbook(String title, String author, int copies, double price, String bankingInfo) {
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.price = price;
        this.bankingInfo = bankingInfo;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCopies() { return copies; }
    public double getPrice() { return price; }
    public String getBankingInfo() { return bankingInfo; }

    @Override
    public String toString() {
        return title + " by " + author + " - " + copies + " copies, R" + price;
    }
}
