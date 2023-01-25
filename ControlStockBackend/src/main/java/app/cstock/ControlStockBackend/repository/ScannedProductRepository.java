package app.cstock.ControlStockBackend.repository;

import app.cstock.ControlStockBackend.entity.ScannedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScannedProductRepository extends JpaRepository<ScannedProduct, Long> {
    ScannedProduct findScannedProductByFileProductId(Long fileProductId);

}
