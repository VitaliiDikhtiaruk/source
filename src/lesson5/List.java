package lesson5;

// создал класс для работы с обьектами Book
class List {

	// новые обьекты Book заносятся в массив, через него обращаемся к содержимому

	private Book[] bookList = new Book[100];
	int a = 0;

	void addBook(Book book) {
		this.bookList[a++] = book;
	}

	// вывод книг по атору

	public void getListByAuthor(String byAuthor) {

		for (Book b : bookList) {
			if (b != null) {
				if (byAuthor.equalsIgnoreCase(b.getAuthor())) {

					System.out.println("id: " + b.getId() + " author: " + b.getAuthor() + " publisher: "
							+ b.getPublisher() + " year: " + b.getYear() + " pages: " + b.getPages() + " price: "
							+ b.getPrice() + " cover: " + b.getCover());

				}
			}
		}

	}

	// вывод книг по издательству

	public void getListByPublisher(String byPublisher) {

		for (Book b : bookList) {
			if (b != null) {
				if (byPublisher.equalsIgnoreCase(b.getPublisher())) {

					System.out.println("id: " + b.getId() + " author: " + b.getAuthor() + " publisher: "
							+ b.getPublisher() + " year: " + b.getYear() + " pages: " + b.getPages() + " price: "
							+ b.getPrice() + " cover: " + b.getCover());

				}
			}
		}

	}

	// вывод книг по году

	public void getListByYear(int byYear) {

		for (Book b : bookList) {
			if (b != null) {
				if ((b.getYear()) >= byYear) {

					System.out.println("id: " + b.getId() + " author: " + b.getAuthor() + " publisher: "
							+ b.getPublisher() + " year: " + b.getYear() + " pages: " + b.getPages() + " price: "
							+ b.getPrice() + " cover: " + b.getCover());

				}
			}
		}

	}

}
