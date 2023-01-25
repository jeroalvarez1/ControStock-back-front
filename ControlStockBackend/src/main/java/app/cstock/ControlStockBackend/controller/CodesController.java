package app.cstock.ControlStockBackend.controller;

import app.cstock.ControlStockBackend.dto.CodesDto;
import app.cstock.ControlStockBackend.dto.FileProductDto;
import app.cstock.ControlStockBackend.service.CodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CodesController {

    @Autowired
    private CodesService codesService;

    @GetMapping("/codes")
    public ResponseEntity<List<CodesDto>> getAllCodes() {
        if (codesService.getAllCodes().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(codesService.getAllCodes(), HttpStatus.OK);
        }
    }

    @GetMapping("/file-products/{fileProductId}/codes")
    public ResponseEntity<List<CodesDto>> getAllCodesByFileProductId(
            @PathVariable(value = "fileProductId") Long fileProductId) {
        return new ResponseEntity<>(codesService.getAllCodesByFileProductId(fileProductId), HttpStatus.OK);
    }

    @GetMapping("/codes/{id}")
    public ResponseEntity<CodesDto> getCodesById(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(codesService.getCodesById(id), HttpStatus.OK);
    }

    @GetMapping("/codes/{id}/file-products")
    public ResponseEntity<List<FileProductDto>> getAllFileProductsByCodesId(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(codesService.getAllFileProductsByCodesId(id), HttpStatus.OK);
    }

    @PostMapping("/file-products/{fileProductId}/codes")
    public ResponseEntity<CodesDto> addCodes(@PathVariable(value = "fileProductId") Long fileProductId,
            @RequestBody CodesDto codesRequest) {
        return new ResponseEntity<>(codesService.addCodes(fileProductId, codesRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/file-products/{fileProductId}/codes/{codesId}")
    public ResponseEntity<HttpStatus> deleteCodesFromFileProduct(
            @PathVariable(value = "fileProductId") Long fileProductId,
            @PathVariable(value = "codesId") String codesId) {
        codesService.deleteCodesFromFileProduct(fileProductId, codesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/file-products/codes")
    public ResponseEntity<HttpStatus> deleteCodesFromFileProduct() {
        codesService.deleteAllCodesFromFileProduct();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/codes/{id}")
    public ResponseEntity<HttpStatus> deleteCodes(@PathVariable(value = "id") String id) {
        codesService.deleteCodes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/codes")
    public ResponseEntity<HttpStatus> deleteAllCodes() {
        codesService.deleteAllCodes();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}