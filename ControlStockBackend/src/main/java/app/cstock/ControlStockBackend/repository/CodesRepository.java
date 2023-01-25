package app.cstock.ControlStockBackend.repository;

import app.cstock.ControlStockBackend.entity.Codes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodesRepository extends JpaRepository<Codes, String> {
    List<Codes> findCodesByFileProductsId(Long fileProductId);
}
