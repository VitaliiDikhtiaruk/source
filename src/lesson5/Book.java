package lesson5;

//создал класс и поля класса
public class Book {
	private int id;
	private String bookName;
	private String author;
	private String publisher;
	private int year;
	private int pages;
	private int price;
	private String cover;

	// при создании обьекта book необходимо указать след. аргументы

	Book(int id, String bookName, String author, String publisher, int year, int pages, int price, String cover) {
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.pages = pages;
		this.price = price;
		this.cover = cover;
	}

	// гетеры

	public int getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return year;
	}

	public int getPages() {
		return pages;
	}

	public int getPrice() {
		return price;
	}

	public String getCover() {
		return cover;
	}

}
