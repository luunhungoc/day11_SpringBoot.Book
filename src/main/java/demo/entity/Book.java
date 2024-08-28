package demo.entity;

public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private double price;
    private String name;

    public Book() {
    }

    public Book(int id, String author, double price, String name) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//    @ManyToOne
//    @JoinColumn(name="categoryId")
//    private CategoryEntity category;

    //    @OneToOne(cascade = {CascadeType.ALL})
//    @PrimaryKeyJoinColumn
//    private BookDetailsEntity bookDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public CategoryEntity getCategory() {
//        return category;
//    }
//
//    public void setCategory(CategoryEntity category) {
//        this.category = category;
//    }
//
//    public BookDetailsEntity getBookDetails() {
//        return bookDetails;
//    }
//
//    public void setBookDetails(BookDetailsEntity bookDetails) {
//        this.bookDetails = bookDetails;
//    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}