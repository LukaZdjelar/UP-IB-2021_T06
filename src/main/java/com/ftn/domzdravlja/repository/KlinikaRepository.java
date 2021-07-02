package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftn.domzdravlja.model.Klinika;

public interface KlinikaRepository extends JpaRepository<Klinika, Integer> {

	Klinika findKlinikaById(Integer id);

	List<Klinika> findAll();


	@Query(value = "SELECT k.post_id,p.date,p.description,p.dislikes,p.latitude,p.likes,p.longitude,p.photo"
			+ ",p.title,p.user_id  FROM posts p JOIN  comments c ON p.post_id=c.post_id GROUP BY  c.post_id ORDER BY COUNT(c.post_id) DESC ", nativeQuery = true)
	List<Klinika> findAllOrOrderByCommentsCount();

	@Query(value = "SELECT DISTINCT p.post_id,p.date,p.description,p.dislikes,p.latitude,p.likes,p.longitude,p.photo"
			+ ",p.title,p.user_id  FROM posts p JOIN  users u ON p.user_id=u.user_id JOIN post_tags pt ON p.post_id=pt.post_id JOIN tags t ON pt.tag_id=t.tag_id "
			+ "WHERE t.name LIKE %:text% OR u.username LIKE %:text%", nativeQuery = true)
	List<Klinika> findAllBySearch(@Param("text") String text);
}
