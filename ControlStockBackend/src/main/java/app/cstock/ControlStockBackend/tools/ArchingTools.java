package app.cstock.ControlStockBackend.tools;

import app.cstock.ControlStockBackend.dto.ArchingDto;
import app.cstock.ControlStockBackend.entity.Arching;

public class ArchingTools {

    public Arching mapEntity(ArchingDto archingDto) {

        Arching arching = new Arching();

        arching.setId(archingDto.getId());
        arching.setReferrer(archingDto.getReferrer());
        arching.setName(archingDto.getName());
        arching.setStartDate(archingDto.getStartDate());
        arching.setEndDate(archingDto.getEndDate());

        return arching;
    }

    public ArchingDto mapDto(Arching arching) {

        ArchingDto archingDto = new ArchingDto();

        archingDto.setId(arching.getId());
        archingDto.setReferrer(arching.getReferrer());
        archingDto.setName(arching.getName());
        archingDto.setStartDate(arching.getStartDate());
        archingDto.setEndDate(arching.getEndDate());

        return archingDto;
    }

}
