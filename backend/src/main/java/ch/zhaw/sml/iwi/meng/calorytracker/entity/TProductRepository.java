package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TProductRepository extends JpaRepository<TProduct, Integer>{

}