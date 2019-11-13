package fr.yomoni.shopshop.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.yomoni.shopshop.dao.ArticleRepository;
import fr.yomoni.shopshop.dto.ArticleDTO;
import fr.yomoni.shopshop.model.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRep;
	
	@Override
	public List<Article> rechercherListeDArticle() {
		
		return   articleRep.findAll();
	}
	
	@Override
	public void modifierCaracteristiquesArticle( ArticleDTO artc) {
		Optional<Article> article = articleRep.findById(artc.getId());
		if(artc.getLabel() != null) {
			article.get().setLabel(artc.getLabel());
		}
		if(artc.getListCourses() != null) {
			article.get().setListCourses(artc.getListCourses());
		}
		if(artc.getListCourses() != null) {
			article.get().setListCourses(artc.getListCourses());
		}
		if(artc.getNbItems() != null) {
			article.get().setNbItems(artc.getNbItems());
		}
		if(artc.getStatus() != null) {
			article.get().setStatus(artc.getStatus());
		}
		
		article.get().setUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
		
		articleRep.save(article.get());
	}
}
