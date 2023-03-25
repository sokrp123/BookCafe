package project;
public class Books {
	String name;
	String genre;
	String publisher;
	String author;
	String date;
	String rating;

	public Books(String title, String author, String publisher, String genre, String rating) {
		this.name = title;
		this.author = author;
		this.publisher = publisher;
		this.genre =  genre;
		this.rating = rating;
	}
	public Books() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPub() {
		return publisher;
	}

	public void setPub(String publisher) {
		this.publisher = publisher;
	}

	public String getAut() {
		return author;
	}

	public void setAut(String author) {
		this.author = author;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setRate(String rating) {
		this.rating = rating;
	}

	public String getRate() {
		return rating;
	}

}
