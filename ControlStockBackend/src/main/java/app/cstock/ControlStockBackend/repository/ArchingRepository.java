package app.cstock.ControlStockBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.cstock.ControlStockBackend.entity.Arching;


import java.util.Date;
import java.util.List;

@Repository
public interface ArchingRepository extends JpaRepository<Arching, Long> {


    @Query(
            value = "SELECT * FROM arching a WHERE a.start_date >= :from AND a.start_date <= :to ORDER BY a.id DESC;",
            nativeQuery = true)
    List<Arching> findAllArchingByDate(@Param("from") Date from, @Param("to") Date to);

    @Query(
            value = "SELECT * FROM arching a ORDER BY a.id DESC LIMIT 1;",
            nativeQuery = true)
    Arching findLastOneArching();

}



