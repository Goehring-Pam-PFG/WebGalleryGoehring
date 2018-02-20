package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artwork")

public class Artwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "ARTIST_NAME")
	private String artist;
	@Column(name = "MEDIA")
	private String media;
	@Column(name = "YEAR")
	private String year;
	@Column(name = "VALUE")
	private double value;
	

	public Artwork() {
		super();
	}

	public Artwork(String title, String artist, String media, String year, double value) {
		super();
		this.title = title;
		this.artist = artist;
		this.media = media;
		this.year = year;
		this.value = value;
	}
	
	

	public Artwork(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ListArtwork [id=" + id + ", title=" + title + ", artist=" + artist + ", media=" + media + ", year="
				+ year + ", value=" + value + "]";
	}

	public String returnArtworkDetails() {
		return String.format("%-5s %-10s %-10s %-10s %-5s %-10s", id, title, artist, media, year, value);
	}
}
