package app.cstock.ControlStockBackend.controller;

import java.util.Date;
import java.util.List;

import app.cstock.ControlStockBackend.dto.DateRangeDto;
import app.cstock.ControlStockBackend.dto.DetailArchingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.cstock.ControlStockBackend.dto.ArchingDto;
import app.cstock.ControlStockBackend.service.ArchingService;

@RestController
@RequestMapping("/api/arching")
public class ArchingController {

    @Autowired
    private ArchingService archingService;

    @GetMapping
    public ResponseEntity<List<ArchingDto>> getAllArching() {
        if (archingService.getAllArching().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(archingService.getAllArching(), HttpStatus.OK);
        }
    }
    @PostMapping("/date")
    public ResponseEntity<List<ArchingDto>> getByDate(@RequestBody DateRangeDto dateRangeDto) {
        return new ResponseEntity<>(archingService.getByDate(dateRangeDto), HttpStatus.OK);
    }

    @GetMapping("/last-one")
    public ResponseEntity<ArchingDto> getLastOneArching() {
        return new ResponseEntity<>(archingService.getLastOneArching(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchingDto> getByIdArching(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(archingService.getByIdArching(id), HttpStatus.OK);
    }
    @GetMapping("/file-product/amount/{id}")
    public ResponseEntity<Long> getTotalFileProductAmount(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(archingService.getTotalFileProductAmount(id), HttpStatus.OK);
    }

    @GetMapping("/scanned-product/amount/{id}")
    public ResponseEntity<Long> getTotalScannedProductAmount(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(archingService.getTotalScannedProductAmount(id), HttpStatus.OK);
    }

    @GetMapping("/valence/{id}")
    public ResponseEntity<Long> getvalence(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(archingService.getValence(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ArchingDto> newArching(
            @RequestBody ArchingDto archingDto) {
        return new ResponseEntity<>(archingService.newArching(archingDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArchingDto> updateArching(@RequestBody ArchingDto archingDto,
                                                          @PathVariable(value = "id") Long id) {
        ArchingDto ArchingResponse = archingService.updateArching(archingDto, id);
        return new ResponseEntity<>(ArchingResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteArchingById(@PathVariable(value = "id") Long id) {
        archingService.deleteArchingById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllArching() {
        archingService.deleteAllArching();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
