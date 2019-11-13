package fr.yomoni.shopshop.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import fr.yomoni.shopshop.model.Article;
import fr.yomoni.shopshop.model.ListeCourses;

@Service
public interface ListeCoursesService {
	
	List<ListeCourses> rechercherListeDeCourse();
	Set<Article> rechercherArticlesDuneListe(String idListCourse);
	void creerListeDecourseVide(String listCourse);
	void ajouterArticleDansListeDeCourse(String idListCourse, String label, Integer nbItems);
	void supprimerArticleDuneListeDeCourse(String idArticle);
	
	
	
}
