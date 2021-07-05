package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String text;
	private Long movieId = 0L;

	private User user;

	private Movie movie = new Movie();
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text,Long movieId, User user, Movie movie) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.user = user;
		this.movie = movie;
	}
	
	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.movieId = entity.getMovie().getId();
		this.user = entity.getUser();
		this.movie = entity.getMovie();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	
}
