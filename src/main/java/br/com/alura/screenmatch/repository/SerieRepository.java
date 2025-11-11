package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

/*pegando os recursos do JPARepository informando que as operações serão na Entidade Serie
 e que a chave primária dessa Entidade é um Long*/
public interface SerieRepository extends JpaRepository<Serie, Long> {
}
