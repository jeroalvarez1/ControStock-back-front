package app.cstock.ControlStockBackend.service;

import app.cstock.ControlStockBackend.dto.ScannedProductDto;
import app.cstock.ControlStockBackend.entity.ScannedProduct;

import java.util.List;

public interface ScannedProductService {

    public List<ScannedProductDto> getAllScannedProduct();

    public ScannedProductDto getByIdScannedProduct(Long id);

    public ScannedProduct getByIdScannedProductEntity(Long id);

    public ScannedProductDto newScannedProduct(Long scannedProductId, ScannedProductDto scannedProductDto);

    public ScannedProductDto updateScannedProduct(Long id, ScannedProductDto scannedProductDto);
    public ScannedProductDto newOrUpdateScannedProduct(Long fileProductId, ScannedProductDto scannedProductDto);

    public void deleteScannedProduct(Long id);

}
