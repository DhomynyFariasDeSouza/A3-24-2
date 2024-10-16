package com.a3.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a3.api.Entity.Item;

@Repository
public interface itemRepository extends JpaRepository<Item,String> {

}
