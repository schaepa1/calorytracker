package ch.zhaw.sml.iwi.meng.calorytracker.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserRepository extends JpaRepository<TUser, Integer>{

}