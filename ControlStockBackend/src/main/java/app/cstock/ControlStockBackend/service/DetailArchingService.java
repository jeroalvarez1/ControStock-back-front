package app.cstock.ControlStockBackend.service;

import java.util.List;

import app.cstock.ControlStockBackend.dto.DetailArchingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface DetailArchingService {
    public List<DetailArchingDto> getAllDetailArching(Long arching);
    public DetailArchingDto getByDetailArchingId(Long id);

    public Long getValence(Long id);

    public DetailArchingDto newDetailArching(Long archingId, DetailArchingDto detailArchingDto);

    public void updateDetailArching(DetailArchingDto detailArchingDto);

    public void updateFileAmountDetailArching(DetailArchingDto detailArchingDto);

    public void deleteDetailArching(Long id);

    public void deleteAllDetailArching(Long id);

}
