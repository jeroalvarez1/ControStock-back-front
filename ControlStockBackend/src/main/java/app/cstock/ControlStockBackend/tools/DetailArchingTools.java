package app.cstock.ControlStockBackend.tools;

import app.cstock.ControlStockBackend.dto.DetailArchingDto;
import app.cstock.ControlStockBackend.entity.Arching;
import app.cstock.ControlStockBackend.entity.DetailArching;

public class DetailArchingTools {

    public app.cstock.ControlStockBackend.entity.DetailArching mapEntity(DetailArchingDto detailArchingDto) {
        DetailArching detailArching = new DetailArching();

        detailArching.setId(detailArchingDto.getId());
        detailArching.setProductName(detailArchingDto.getProductName());
        detailArching.setMark(detailArchingDto.getMark());
        detailArching.setEmployee(detailArchingDto.getEmployee());
        detailArching.setScannedProductAmount(detailArchingDto.getScannedProductAmount());
        detailArching.setFileProductAmount(detailArchingDto.getFileProductAmount());
        return detailArching;
    }

    public DetailArchingDto mapDto(app.cstock.ControlStockBackend.entity.DetailArching detailArching) {
        DetailArchingDto detailArchingDto = new DetailArchingDto();
        detailArchingDto.setId(detailArching.getId());
        detailArchingDto.setProductName(detailArching.getProductName());
        detailArchingDto.setMark(detailArching.getMark());
        detailArchingDto.setEmployee(detailArching.getEmployee());
        detailArchingDto.setScannedProductAmount(detailArching.getScannedProductAmount());
        detailArchingDto.setFileProductAmount(detailArching.getFileProductAmount());
        return detailArchingDto;
    }

}
