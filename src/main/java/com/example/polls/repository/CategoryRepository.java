package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
