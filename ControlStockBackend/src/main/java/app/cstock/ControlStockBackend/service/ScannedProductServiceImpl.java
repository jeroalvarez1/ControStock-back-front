package app.cstock.ControlStockBackend.service;

import app.cstock.ControlStockBackend.dto.ScannedProductDto;
import app.cstock.ControlStockBackend.entity.FileProduct;
import app.cstock.ControlStockBackend.entity.ScannedProduct;
import app.cstock.ControlStockBackend.exeption.ResourceNoteFoundException;
import app.cstock.ControlStockBackend.repository.FileProductRepository;
import app.cstock.ControlStockBackend.repository.ScannedProductRepository;
import app.cstock.ControlStockBackend.tools.ScannedProductTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScannedProductServiceImpl implements ScannedProductService {

    @Autowired
    private ScannedProductRepository scannedProductRepository;
    @Autowired
    private FileProductRepository fileProductRepository;
    ScannedProductTools scannedProductTools = new ScannedProductTools();

    @Override
    public ScannedProductDto getByIdScannedProduct(Long id) {
        ScannedProduct scannedProduct = scannedProductRepository
                .findById(id).orElseThrow(() -> new ResourceNoteFoundException("ScannedProduct", "id", id));
        return scannedProductTools.mapDto(scannedProduct);
    }

    @Override
    public ScannedProduct getByIdScannedProductEntity(Long id) {
        ScannedProduct scannedProduct = scannedProductRepository
                .findById(id).orElseThrow(() -> new ResourceNoteFoundException("ScannedProduct", "id", id));
        return scannedProduct;
    }

    @Override
    public List<ScannedProductDto> getAllScannedProduct() {
        List<ScannedProduct> scannedProductList = scannedProductRepository.findAll();
        return scannedProductList.stream().map(scannedProduct -> scannedProductTools.mapDto(scannedProduct))
                .collect(Collectors.toList());
    }

    @Override
    public ScannedProductDto newScannedProduct(Long fileProductId, ScannedProductDto scannedProductDto) {
        FileProduct fileProduct = fileProductRepository
                .findById(fileProductId)
                .orElseThrow(() -> new ResourceNoteFoundException("ScannedProduct", "id", fileProductId));
        ScannedProduct scannedProduct = new ScannedProduct();
        scannedProduct.setAmount(scannedProductDto.getAmount());
        scannedProduct.setFileProduct(fileProduct);
        ScannedProduct saveScannedProduct = scannedProductRepository.save(scannedProduct);
        return scannedProductTools.mapDto(saveScannedProduct);
    }

    @Override
    public ScannedProductDto updateScannedProduct(Long id, ScannedProductDto scannedProductDto) {

        ScannedProduct scannedProduct = getByIdScannedProductEntity(id);

        scannedProduct.setAmount(scannedProductDto.getAmount());
        scannedProduct.setFileProduct(scannedProduct.getFileProduct());

        ScannedProduct scannedProductUpdated = scannedProductRepository.save(scannedProduct);
        return scannedProductTools.mapDto(scannedProductUpdated);
    }

    @Override
    public ScannedProductDto newOrUpdateScannedProduct(Long fileProductId, ScannedProductDto scannedProductDto) {
        if (scannedProductRepository.findScannedProductByFileProductId(fileProductId) == null) {
            return newScannedProduct(fileProductId, scannedProductDto);
        } else {
            ScannedProduct scannedProductUpdated = scannedProductRepository
                    .findScannedProductByFileProductId(fileProductId);
            scannedProductUpdated.setId(scannedProductUpdated.getId());
            scannedProductUpdated.setAmount(scannedProductUpdated.getAmount() + scannedProductDto.getAmount());
            scannedProductUpdated.setFileProduct(scannedProductUpdated.getFileProduct());
            return scannedProductTools.mapDto(scannedProductRepository.save(scannedProductUpdated));
        }
    }

    @Override
    public void deleteScannedProduct(Long id) {
        ScannedProduct scannedProduct =  getByIdScannedProductEntity(id);
        scannedProductRepository.delete(scannedProduct);
    }

}
