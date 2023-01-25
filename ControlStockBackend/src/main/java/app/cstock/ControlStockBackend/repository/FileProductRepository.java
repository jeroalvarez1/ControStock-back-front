package app.cstock.ControlStockBackend.repository;

import app.cstock.ControlStockBackend.entity.Arching;
import app.cstock.ControlStockBackend.entity.FileProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileProductRepository extends JpaRepository<FileProduct, Long> {

    List<FileProduct> findFileProductsByCodesId(String codesId);

}
