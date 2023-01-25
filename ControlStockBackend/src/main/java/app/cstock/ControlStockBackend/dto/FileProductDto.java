package app.cstock.ControlStockBackend.dto;

import app.cstock.ControlStockBackend.entity.ScannedProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileProductDto {
    private Long id;
    private String productName;
    private String mark;
    private Long amount;

    private ScannedProduct scannedProduct;

    public FileProductDto() {
        super();
    }

    public FileProductDto(Long id, String productName, String mark, Long amount, ScannedProduct scannedProduct) {
        this.id = id;
        this.productName = productName;
        this.mark = mark;
        this.amount = amount;
        this.scannedProduct = scannedProduct;
    }
}
