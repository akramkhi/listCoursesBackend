package fr.yomoni.shopshop.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.yomoni.shopshop.dao.ArticleRepository;
import fr.yomoni.shopshop.dao.ListeCoursesRepository;
import fr.yomoni.shopshop.model.Article;
import fr.yomoni.shopshop.model.ListeCourses;

@Service
public class ListeCoursesServiceImp implements ListeCoursesService {

	@Autowired
	private ListeCoursesRepository listCoursesRep;
	
	@Autowired
	private ArticleRepository articleRep;
	@Override
	public void creerListeDecourseVide(String label) {
		
		ListeCourses listCourse = new ListeCourses(UUID.randomUUID(),label,"vide", new Date());
		listCoursesRep.save(listCourse);
		
	}

	@Override
	public void ajouterArticleDansListeDeCourse(String idListCourse,String label, Integer nbItems) {
		Optional<ListeCourses> listCourse = listCoursesRep.findById(UUID.fromString(idListCourse));
		Set<Article> articles = listCourse.get().getArticle();
		Article article = new Article();
		article.setId(UUID.randomUUID());
		article.setLabel(label);
		article.setStatus("A prendre");
		article.setUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
		article.setListCourses(listCourse.get());
		if(nbItems != null) {
			article.setNbItems(nbItems);
		}else {
			article.setNbItems(1);
		}
		articles.add(article);
		listCourse.get().setArticle(articles);
		listCoursesRep.save(listCourse.get());
	}

	@Override
	public void supprimerArticleDuneListeDeCourse( String idArticle) {
		  articleRep.deleteById(UUID.fromString(idArticle)); 
		
	}

	

	@Override
	public List<ListeCourses> rechercherListeDeCourse() {
		return  listCoursesRep.findAll();
	}



	@Override
	public Set<Article> rechercherArticlesDuneListe(String idListCourse) {
		Optional<ListeCourses> ls = listCoursesRep.findById(UUID.fromString(idListCourse));
		Set<Article> listC =  ls.get().getArticle();
		return listC;
	}

}
