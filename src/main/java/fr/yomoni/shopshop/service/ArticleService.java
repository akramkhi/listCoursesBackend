package fr.yomoni.shopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.yomoni.shopshop.dto.ArticleDTO;
import fr.yomoni.shopshop.model.Article;
@Service
public interface ArticleService {

	List<Article> rechercherListeDArticle();
	void modifierCaracteristiquesArticle(ArticleDTO article);

}
