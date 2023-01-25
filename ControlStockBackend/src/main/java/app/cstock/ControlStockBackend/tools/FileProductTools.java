package app.cstock.ControlStockBackend.tools;

import app.cstock.ControlStockBackend.dto.FileProductDto;
import app.cstock.ControlStockBackend.entity.FileProduct;

public class FileProductTools {

    public FileProduct mapEntity(FileProductDto fileProductDto) {

        FileProduct fileProduct = new FileProduct();

        fileProduct.setId(fileProductDto.getId());
        fileProduct.setProductName(fileProductDto.getProductName());
        fileProduct.setMark(fileProductDto.getMark());
        fileProduct.setAmount(fileProductDto.getAmount());

        return fileProduct;
    }

    public FileProductDto mapDto(FileProduct fileProduct) {

        FileProductDto fileProductDto = new FileProductDto();

        fileProductDto.setId(fileProduct.getId());
        fileProductDto.setProductName(fileProduct.getProductName());
        fileProductDto.setMark(fileProduct.getMark());
        fileProductDto.setAmount(fileProduct.getAmount());
        fileProductDto.setScannedProduct(fileProduct.getScannedProduct());

        return fileProductDto;
    }

    public FileProductTools() {
        super();
    }

}
