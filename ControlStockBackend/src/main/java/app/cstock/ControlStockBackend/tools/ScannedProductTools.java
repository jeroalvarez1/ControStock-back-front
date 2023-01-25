package app.cstock.ControlStockBackend.tools;

import app.cstock.ControlStockBackend.dto.ScannedProductDto;
import app.cstock.ControlStockBackend.entity.ScannedProduct;

public class ScannedProductTools {

    public ScannedProduct mapEntity(ScannedProductDto scannedProductDto){

        ScannedProduct scannedProduct = new ScannedProduct();

        scannedProduct.setAmount(scannedProductDto.getAmount());

        return scannedProduct;
    }

    public ScannedProductDto mapDto(ScannedProduct scannedProduct){

        ScannedProductDto scannedProductDto = new ScannedProductDto();

        scannedProductDto.setId(scannedProduct.getId());
        scannedProductDto.setAmount(scannedProduct.getAmount());
        scannedProductDto.setFileProduct(scannedProduct.getFileProduct());

        return scannedProductDto;
    }

    public ScannedProductTools() {
        super();
    }

}
