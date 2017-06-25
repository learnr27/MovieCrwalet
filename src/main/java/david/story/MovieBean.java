package david.story;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MovieBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String movieRUL;
	private String movieName;
	private String score;
	private String toStar;
	private String plot;
	private String photoURL;
	private byte[] photo;

	public MovieBean(String movieRUL, String movieName, String score, String toStar, String plot, String photoURL) {
		this.movieRUL = movieRUL;
		this.movieName = movieName;
		this.score = score;
		this.toStar = toStar;
		this.plot = plot;
		this.photoURL = photoURL;
	}

	public String getMovieRUL() {
		return movieRUL;
	}

	public void setMovieRUL(String movieRUL) {
		this.movieRUL = movieRUL;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getToStar() {
		return toStar;
	}

	public void setToStar(String toStar) {
		this.toStar = toStar;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "电影网址:" + movieRUL + "\t" + "电影名字:" + movieName + "\t" + score + "\t" + toStar + "\t" + plot + "\t照片:"
				+ photo + "\r\n";
	}
}
