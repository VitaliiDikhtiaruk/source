package lesson5;

/*
Book: id, Название, Автор (ы), Издательство, Год издания, Количество стра-
ниц, Цена, Тип переплета.
Создать массив объектов. Вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
 */

public class task1 {
	public static void main(String[] args) {

		// критерии выборки из массива книг

		String pub = "publisher2";
		String author = "author2";
		int year = 2010;
		// создание новых книг

		Book[] bookList = new Book[100];
		bookList[0] = new Book(1, "book1", "author1", "publisher1", 2001, 123, 50, "soft");
		bookList[1] = new Book(2, "book2", "author3", "publisher2", 2002, 223, 60, "hard");
		bookList[2] = new Book(3, "book3", "author3", "publisher1", 2003, 323, 50, "soft");
		bookList[3] = new Book(4, "book4", "author5", "publisher2", 2002, 423, 20, "hard");
		bookList[4] = new Book(5, "book5", "author1", "publisher1", 2004, 223, 30, "soft");
		bookList[5] = new Book(6, "book6", "author4", "publisher2", 2005, 173, 57, "hard");
		bookList[6] = new Book(7, "book7", "author2", "publisher1", 2010, 1223, 150, "soft");
		bookList[7] = new Book(8, "book8", "author1", "publisher2", 2008, 523, 502, "hard");
		bookList[8] = new Book(9, "book9", "author2", "publisher1", 2000, 823, 520, "soft");
		bookList[9] = new Book(10, "book10", "author4", "publisher2", 2012, 523, 150, "soft");
		bookList[10] = new Book(11, "book11", "author5", "publisher1", 2016, 863, 250, "soft");
		List list = new List();

		// добавляем в массив

		for (Book book : bookList) {
			list.addBook(book);
		}

		// вывод устловия задачи

		System.out.println("Книги от издательства - " + pub);
		list.getListByPublisher(pub);
		System.out.println("Книги от автора - " + author);
		list.getListByAuthor(author);
		System.out.println("Книги после " + year + " года");
		list.getListByYear(year);

	}

}
