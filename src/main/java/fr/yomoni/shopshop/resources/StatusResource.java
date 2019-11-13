package fr.yomoni.shopshop.resources;

import java.util.List;
import java.util.Set;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fr.yomoni.shopshop.dto.ArticleDTO;
import fr.yomoni.shopshop.model.Article;
import fr.yomoni.shopshop.model.ListeCourses;
import fr.yomoni.shopshop.service.ArticleService;
import fr.yomoni.shopshop.service.ListeCoursesService;

/*
 * Controller 
 */
@RestController
public class StatusResource {
	
	/**
	 * service injection  
	 */
	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected ListeCoursesService listeCoursesService;
	
	/**
	 * 
	 * @return list of article
	 */
	@GetMapping( value = "/listeArticles" )
	public  ResponseEntity<List<Article>> getArticle() {
		List<Article> articles = articleService.rechercherListeDArticle();
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return list of Courses
	 */
	@GetMapping( value = "/listeCourses" )
	public ResponseEntity<List<ListeCourses>> getCourses() {
		List<ListeCourses> listCourse = listeCoursesService.rechercherListeDeCourse();
		return new ResponseEntity(listCourse ,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param idList
	 * @return list of article of a listOfCourse
	 */
	@GetMapping( value = "/rechercherArticlesDListe/{idList}" )
	public ResponseEntity<List<ListeCourses>> getArticlesFromIdListCourse(@PathVariable String idList) {
		Set<Article> listC = listeCoursesService.rechercherArticlesDuneListe(idList); 
		if(listC.isEmpty()) {
	            return new ResponseEntity(idList,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(listC ,HttpStatus.FOUND);
	} 
	
	/**
	 * 
	 * @param idArticle
	 * @return delete an article
	 */
	@DeleteMapping( value = "/supprimerArticle/{idArticle}" )
	public ResponseEntity<?> deleteArticleFromList(@PathVariable String idArticle) {
		String idArt = idArticle;
		listeCoursesService.supprimerArticleDuneListeDeCourse(idArticle);
	
		return new ResponseEntity<>("Article supprimé : "+ idArt, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param label
	 * @return create a new empty listCourse 
	 */
	@PostMapping(value="/creerListeDeCourseVide")
	public ResponseEntity<?>  createEmptyList(@RequestParam String label) {
		if(!label.isEmpty()) {
			listeCoursesService.creerListeDecourseVide(label);
		}
		return new ResponseEntity<>("Nouvelle liste crée : "+label, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param idList
	 * @param label
	 * @param nbItems
	 * @return add an article to listOfCourse
	 */
	@PostMapping(value="/ajoutArticleEnListeDeCourse")
	public ResponseEntity<?>  addArticleToListCourse(@RequestParam String idList,@RequestParam String label,@RequestParam(required = false) Integer nbItems) {
		
		if((idList!=null && label!=null)) {
			if(nbItems != null) {
				listeCoursesService.ajouterArticleDansListeDeCourse(idList, label, nbItems);
			}else {
				listeCoursesService.ajouterArticleDansListeDeCourse(idList, label, null);
			}
		}
		return new ResponseEntity<>("Article ajouté :  : "+label, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param idArticle
	 * @param label
	 * @param status
	 * @param nbItems
	 * @return update an article
	 */
	@PutMapping(value="/modifierCaracteristiqueArticle/{idArticle}")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW) 
	public ResponseEntity<?>  modifCharactArticle(@PathVariable String idArticle,@RequestParam(required = false) String label, 
			@RequestParam(required = false) String status,@RequestParam(required = false) Integer nbItems) {
		if(idArticle.isEmpty()) {
			return new ResponseEntity<>("IDArticle n'existe pas ", HttpStatus.BAD_REQUEST);
		}else {
			ArticleDTO article = new ArticleDTO();
			article.setId(UUID.fromString(idArticle));
		if(label != null) {
			article.setLabel(label);
		}
		if(status != null) {
			article.setStatus(status);
		}
		if(nbItems != null) {
			article.setNbItems(nbItems);
		}
		articleService.modifierCaracteristiquesArticle(article);
		return new ResponseEntity<>("Article modifié : "+idArticle, HttpStatus.OK);
		}
	}
	
	
	
	
	

}
