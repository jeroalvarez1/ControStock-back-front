package app.cstock.ControlStockBackend.service;

import java.util.List;

import app.cstock.ControlStockBackend.dto.ArchingDto;
import app.cstock.ControlStockBackend.dto.DateRangeDto;

public interface ArchingService {

    public List<ArchingDto> getAllArching();

    public ArchingDto getByIdArching(Long id);

    public List<ArchingDto> getByDate(DateRangeDto dateRangeDto);

    public ArchingDto getLastOneArching();
    public ArchingDto newArching(ArchingDto archingDto);

    public Long getTotalFileProductAmount(Long id);

    public Long getTotalScannedProductAmount(Long id);

    public Long getValence(Long id);

    public ArchingDto updateArching(ArchingDto archingDto, Long id);

    public void deleteArchingById(Long id);
    public void deleteAllArching();

}
