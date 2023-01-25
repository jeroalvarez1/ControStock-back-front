package app.cstock.ControlStockBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.cstock.ControlStockBackend.entity.DetailArching;

import java.util.List;

public interface DetailArchingRepository extends JpaRepository<DetailArching, Long> {

    List<DetailArching> findDetailArchingByArchingId(Long archingId);

}
