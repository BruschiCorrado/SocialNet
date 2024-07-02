package org.example.socialnetwork.Db.Repo;

import org.example.socialnetwork.Db.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo extends JpaRepository<Posts, Integer> {


}
