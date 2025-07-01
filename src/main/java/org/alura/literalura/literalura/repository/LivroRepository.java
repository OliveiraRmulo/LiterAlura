package org.alura.literalura.literalura.repository;

import java.util.List;

import org.alura.literalura.literalura.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

	List<LivroEntity> findByIdioma(String idioma);

    @Query("SELECT COUNT(l) FROM LivroEntity l WHERE l.idioma = :idioma")
    long contarPorIdioma(String idioma);

    List<LivroEntity> findTop10ByOrderByDownloadsDesc();
}
