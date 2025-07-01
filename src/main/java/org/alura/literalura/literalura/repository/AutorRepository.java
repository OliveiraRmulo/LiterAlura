package org.alura.literalura.literalura.repository;

import java.util.List;

import org.alura.literalura.literalura.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

	List<AutorEntity> findByFalecimentoIsNullOrFalecimentoGreaterThanEqual(int ano);

	List<AutorEntity> findByNomeContainingIgnoreCase(String nome);
}
