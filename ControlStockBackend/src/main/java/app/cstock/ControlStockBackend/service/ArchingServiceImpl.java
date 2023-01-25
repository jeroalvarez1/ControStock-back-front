package app.cstock.ControlStockBackend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

import app.cstock.ControlStockBackend.dto.DateRangeDto;
import app.cstock.ControlStockBackend.dto.DetailArchingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.cstock.ControlStockBackend.dto.ArchingDto;
import app.cstock.ControlStockBackend.entity.Arching;
import app.cstock.ControlStockBackend.exeption.ResourceNoteFoundException;
import app.cstock.ControlStockBackend.repository.ArchingRepository;
import app.cstock.ControlStockBackend.tools.ArchingTools;

@Service
public class ArchingServiceImpl implements ArchingService {

    @Autowired
    private ArchingRepository archingRepository;

    @Autowired
    private DetailArchingService detailArchingService;

    ArchingTools archingTools = new ArchingTools();

    @Override
    public List<ArchingDto> getAllArching() {
        List<Arching> archingList = archingRepository.findAll();
        return archingList.stream().map(arching -> archingTools.mapDto(arching))
                .collect(Collectors.toList());
    }

    @Override
    public ArchingDto getByIdArching(Long id) {
        Arching arching = archingRepository.findById(id)
                .orElseThrow(() -> new ResourceNoteFoundException("Arching", "id", id));
        return archingTools.mapDto(arching);
    }

    @Override
    public ArchingDto newArching(ArchingDto archingDto) {
        Arching arching = archingTools.mapEntity(archingDto);
        return archingTools.mapDto(archingRepository.save(arching));
    }

    @Override
    public Long getTotalFileProductAmount(Long id) {
        List<DetailArchingDto> detailArchingDtoList = detailArchingService.getAllDetailArching(id);
        Long sum = 0L;
        for (DetailArchingDto detailArchingDto: detailArchingDtoList) {
            sum += detailArchingDto.getFileProductAmount();
        }
        return sum;
    }

    @Override
    public Long getTotalScannedProductAmount(Long id){
        List<DetailArchingDto> detailArchingDtoList = detailArchingService.getAllDetailArching(id);
        Long sum = 0L;
        for (DetailArchingDto detailArchingDto: detailArchingDtoList) {
            sum += detailArchingDto.getScannedProductAmount();
        }
        return sum;
    }
    @Override
    public Long getValence(Long id){
        return getTotalScannedProductAmount(id) - getTotalFileProductAmount(id);
    }

    ///seguir
    @Override
    public List<ArchingDto> getByDate(DateRangeDto dateRangeDto) {
        System.out.println(dateRangeDto.getFrom());
        System.out.println(dateRangeDto.getTo());
        List<Arching> archingList = archingRepository.findAllArchingByDate(dateRangeDto.getFrom(), dateRangeDto.getTo());
        return archingList.stream().map(arching -> archingTools.mapDto(arching)).collect(Collectors.toList());
    }

    @Override
    public ArchingDto getLastOneArching() {
        return archingTools.mapDto(archingRepository.findLastOneArching());
    }

    @Override
    public ArchingDto updateArching(ArchingDto archingDto, Long id) {

        Arching arching = archingTools.mapEntity(getByIdArching(id));

        arching.setEndDate(archingDto.getEndDate());

        Arching archingUpdated = archingRepository.save(arching);
        return archingTools.mapDto(archingUpdated);
    }

    @Override
    public void deleteArchingById(Long id) {
        archingRepository.delete(archingTools.mapEntity(getByIdArching(id)));
    }

    @Override
    public void deleteAllArching() {
        archingRepository.deleteAll();
    }
}
