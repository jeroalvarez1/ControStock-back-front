package app.cstock.ControlStockBackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileProductWithCodeDto {

    private FileProductDto fileProduct;

    private CodesDto code;

    public FileProductWithCodeDto() {
        super();
    }

    public FileProductWithCodeDto(FileProductDto fileProduct, CodesDto code) {
        this.fileProduct = fileProduct;
        this.code = code;
    }
}
