package app.cstock.ControlStockBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.cstock.ControlStockBackend.dto.DetailArchingDto;
import app.cstock.ControlStockBackend.service.DetailArchingService;

@RestController
@RequestMapping("/api")
public class DetailArchingController {

    @Autowired
    private DetailArchingService detailArchingService;
    @GetMapping("/detail-arching/all/{archingId}")
    public ResponseEntity<List<DetailArchingDto>> getAllDetailArching(@PathVariable(value = "archingId") Long archingId) {
        return new ResponseEntity<>(detailArchingService.getAllDetailArching(archingId), HttpStatus.OK);
    }
    @GetMapping("/detail-arching/{id}")
    public ResponseEntity<DetailArchingDto> getByIdDetailArching(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(detailArchingService.getByDetailArchingId(id), HttpStatus.OK);
    }

    @GetMapping("/detail-arching/{detailArchingId}/valance")
    public ResponseEntity<Long> getDetailArchingValance(@PathVariable(value = "detailArchingId") Long detailArchingId) {
        return new ResponseEntity<>(detailArchingService.getValence(detailArchingId), HttpStatus.OK);
    }

    @PostMapping("/arching/{arching-id}/detail-arching")
    public ResponseEntity<DetailArchingDto> newDetailArching(
            @PathVariable(value = "arching-id") Long archingId,
            @RequestBody DetailArchingDto detailArchingDto) {

        return new ResponseEntity<>(detailArchingService.newDetailArching(archingId, detailArchingDto),
                HttpStatus.OK);
    }

    //crear put
    @PutMapping("/detail-arching-file")
    public ResponseEntity<HttpStatus> updateFileAmountDetailArching(
            @RequestBody DetailArchingDto detailArchingDto) {
        detailArchingService.updateFileAmountDetailArching(detailArchingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/detail-arching")
    public ResponseEntity<HttpStatus> updateDetailArching(
            @RequestBody DetailArchingDto detailArchingDto) {
        detailArchingService.updateDetailArching(detailArchingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Hacerle control de errores al borrar
    @DeleteMapping("/detail-arching/{id}")
    public ResponseEntity<HttpStatus> deleteDetailRegister(@PathVariable(value = "id") Long id) {
        detailArchingService.deleteDetailArching(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/detailarching/deleteall/{id}")
    public ResponseEntity<HttpStatus> deleteAllDetailArching(@PathVariable(value = "id") Long id){
        detailArchingService.deleteAllDetailArching(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
