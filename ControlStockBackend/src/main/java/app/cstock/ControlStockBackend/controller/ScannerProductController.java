package app.cstock.ControlStockBackend.controller;

import app.cstock.ControlStockBackend.dto.ScannedProductDto;
import app.cstock.ControlStockBackend.service.ScannedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScannerProductController {

    @Autowired
    private ScannedProductService scannedProductService;

    @GetMapping("/scanned-product")
    public ResponseEntity<List<ScannedProductDto>> getAllScannedProduct() {
        return new ResponseEntity<>(scannedProductService.getAllScannedProduct(), HttpStatus.OK);
    }

    @GetMapping("/scanned-product/{id}")
    public ResponseEntity<ScannedProductDto> getByIdScannedProduct(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(scannedProductService.getByIdScannedProduct(id), HttpStatus.OK);
    }

    @PostMapping("/file-products/{file-product-id}/scanned-product")
    public ResponseEntity<ScannedProductDto> saveScannedProduct(
            @PathVariable(value = "file-product-id") Long fileProductId,
            @RequestBody ScannedProductDto scannedProductRequest) {
        return new ResponseEntity<>(scannedProductService.newScannedProduct(fileProductId, scannedProductRequest),
                HttpStatus.OK);
    }

    @PutMapping("/scanned-product/{id}")
    public ResponseEntity<ScannedProductDto> updateScannedProduct(@PathVariable(value = "id") Long id,
            @RequestBody ScannedProductDto scannedProductDto) {
        ScannedProductDto scannedProductResponse = scannedProductService.updateScannedProduct(id, scannedProductDto);
        return new ResponseEntity<>(scannedProductResponse, HttpStatus.OK);
    }

    @PostMapping("/scanned-product/new-update/{file-product-id}")
    public ResponseEntity<ScannedProductDto> newOrUpdateScannedProduct(
            @PathVariable(value = "file-product-id") Long fileProductId,
            @RequestBody ScannedProductDto scannedProductRequest) {
        return new ResponseEntity<>(
                scannedProductService.newOrUpdateScannedProduct(fileProductId, scannedProductRequest),
                HttpStatus.OK);
    }

    // Hacerle control de errores al borrar
    @DeleteMapping("/scanned-product/{id}")
    public ResponseEntity<HttpStatus> deleteScannedProduct(@PathVariable(value = "id") Long id) {
        scannedProductService.deleteScannedProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
