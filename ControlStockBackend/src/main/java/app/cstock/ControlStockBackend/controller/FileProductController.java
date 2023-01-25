package app.cstock.ControlStockBackend.controller;

import app.cstock.ControlStockBackend.dto.FileProductDto;
import app.cstock.ControlStockBackend.dto.FileProductWithCodeDto;
import app.cstock.ControlStockBackend.service.FileProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/file-products")
public class FileProductController {

    @Autowired
    private FileProductService fileProductService;

    @GetMapping
    public ResponseEntity<List<FileProductDto>> getAllFileProduct() {
        if (fileProductService.getAllFileProduct().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(fileProductService.getAllFileProduct(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileProductDto> getByIdFileProduct(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(fileProductService.getByIdFileProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<FileProductDto>> createFileProduct(@RequestBody List<FileProductDto> fileProductList) {
        return new ResponseEntity<>(fileProductService.newFileProductList(fileProductList), HttpStatus.CREATED);
    }

    @PostMapping("/new")
    public ResponseEntity<FileProductDto> PostFileProduct(@RequestBody FileProductDto fileProduct) {
        return new ResponseEntity<>(fileProductService.postFileProduct(fileProduct), HttpStatus.CREATED);
    }

    @PostMapping("/code/new")
    public ResponseEntity<HttpStatus> postFilesProductWithCode(@RequestBody List<FileProductWithCodeDto> listFileProductWithCodeDto){
        fileProductService.postFilesProductWithCode(listFileProductWithCodeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FileProductDto> updateFileProduct(@RequestBody FileProductDto fileProductDto,
            @PathVariable(value = "id") Long id) {
        FileProductDto fileProductResponse = fileProductService.updateFileProduct(fileProductDto, id);
        return new ResponseEntity<>(fileProductResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFileProduct(@PathVariable(value = "id") Long id) {
        fileProductService.deleteFileProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/and-scanned/{id}")
    public ResponseEntity<HttpStatus> deleteFileAndScannedProduct(@PathVariable(value = "id") Long id) {
        fileProductService.deleteFileAndScannedProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllFileProducts() {
        fileProductService.deleteAllFileProducts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
