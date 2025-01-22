package com.project.crud_applicaion.repo;

import com.project.crud_applicaion.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {


}
