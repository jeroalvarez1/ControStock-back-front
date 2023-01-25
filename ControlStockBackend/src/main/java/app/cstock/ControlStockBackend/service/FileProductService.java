package app.cstock.ControlStockBackend.service;

import app.cstock.ControlStockBackend.dto.FileProductDto;
import app.cstock.ControlStockBackend.dto.FileProductWithCodeDto;
import app.cstock.ControlStockBackend.entity.Codes;
import app.cstock.ControlStockBackend.entity.FileProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

public interface FileProductService {

    public List<FileProductDto> getAllFileProduct();

    public FileProductDto getByIdFileProduct(Long id);

    public FileProduct getByIdFileProductEntity(Long id);

    public Collection<Codes> getAllCodesOfProduct(Long id);

    public List<FileProductDto> newFileProductList(List<FileProductDto> fileProductDtoList);

    public FileProductDto postFileProduct(FileProductDto fileProductDto);

    public void postFilesProductWithCode(List<FileProductWithCodeDto> listFileProductWithCodeDto);

    public FileProductDto updateFileProduct(FileProductDto fileProductDto, Long id);

    public void deleteFileProduct(Long id);

    public void deleteFileAndScannedProduct(Long id);

    public void deleteAllFileProducts();

}
