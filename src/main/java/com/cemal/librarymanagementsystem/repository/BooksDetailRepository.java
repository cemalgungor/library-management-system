package com.cemal.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cemal.librarymanagementsystem.entity.BooksDetail;
@Repository
public interface BooksDetailRepository extends  JpaRepository<BooksDetail, Long> {

}
