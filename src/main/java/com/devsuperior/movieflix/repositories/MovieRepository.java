package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(nativeQuery = true, 
			value = "SELECT * FROM tb_movie m  "
					+ "INNER JOIN tb_genre g "
					+ "ON g.id = m.genre_id "
					+ "WHERE 1 = CASE  "
					+ "WHEN :genreId <> 0 THEN g.id=:genreId "
					+ "WHEN :genreId = 0 THEN g.id IN(SELECT id FROM tb_genre) "
					+ "END "
					+ "ORDER BY title ASC")
	
	Page<Movie> findAllPaged(Long genreId, Pageable pageable);
	
	/*
	@Query(nativeQuery = true, 
			value = "SELECT * FROM tb_movie m "
					+ "INNER JOIN tb_genre g "
					+ "ON g.id = m.genre_id "
					+ "WHERE g.id=:genreId "
					+ "ORDER BY title ASC ")

	
	
	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE "
			+ "(COALESCE(:categories) IS NULL OR cats IN :categories) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) ")
	Page<Product> find(List<Category> categories, String name, Pageable pageable);


	@Query(nativeQuery = true, 
			value = "SELECT * FROM tb_movie obj "
				  + "ORDER BY obj.title ASC ")
	
	Page<Movie> findAllPaged(Pageable pageable);

	 * SELECT title, sub_title, name Genre FROM tb_movie m
		INNER JOIN tb_genre g
		ON g.id = m.genre_id
		WHERE g.id=1
		ORDER BY title ASC
	 * 
	 */
}
