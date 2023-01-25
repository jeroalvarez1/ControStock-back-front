package app.cstock.ControlStockBackend.dto;

import app.cstock.ControlStockBackend.entity.FileProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScannedProductDto {
    private Long id;
    private Long amount;
    private FileProduct fileProduct;

    public ScannedProductDto() {
        super();
    }

    public ScannedProductDto(Long id, Long amount, FileProduct fileProduct) {
        this.id = id;
        this.amount = amount;
        this.fileProduct = fileProduct;
    }
}
