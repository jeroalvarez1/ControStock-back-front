package app.cstock.ControlStockBackend.dto;

import app.cstock.ControlStockBackend.entity.ScannedProduct;
import app.cstock.ControlStockBackend.entity.Arching;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailArchingDto {

    private Long id;

    private String productName;

    private String mark;

    private String employee;

    private Long scannedProductAmount;

    private Long fileProductAmount;

    public DetailArchingDto() {
    }

    public DetailArchingDto(Long id, String productName, String mark, String employee, Long scannedProductAmount, Long fileProductAmount) {
        this.id = id;
        this.productName = productName;
        this.mark = mark;
        this.employee = employee;
        this.scannedProductAmount = scannedProductAmount;
        this.fileProductAmount = fileProductAmount;
    }
}
