package com.Inventoryservice.repository;


import com.Inventoryservice.entity.MyItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyItemRepository extends JpaRepository<MyItemList,Integer> {
}