package app.cstock.ControlStockBackend.tools;

import app.cstock.ControlStockBackend.dto.CodesDto;
import app.cstock.ControlStockBackend.entity.Codes;

public class CodesTools {

    public Codes mapEntity(CodesDto codesDto) {

        Codes codes = new Codes();

        codes.setId(codesDto.getId());
        return codes;
    }

    public CodesDto mapDto(Codes codes) {

        CodesDto codesDto = new CodesDto();

        codesDto.setId(codes.getId());
        return codesDto;
    }

    public CodesTools() {
        super();
    }
}
