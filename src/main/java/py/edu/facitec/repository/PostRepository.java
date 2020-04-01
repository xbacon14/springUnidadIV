package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
