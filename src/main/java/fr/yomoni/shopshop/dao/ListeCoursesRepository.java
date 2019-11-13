package fr.yomoni.shopshop.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.yomoni.shopshop.model.ListeCourses;

@Repository
public interface ListeCoursesRepository extends JpaRepository<ListeCourses, UUID>{

	

}
