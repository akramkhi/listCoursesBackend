package fr.yomoni.shopshop.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.yomoni.shopshop.model.Article;

public interface ArticleRepository extends JpaRepository<Article, UUID> {

}
