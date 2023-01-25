package app.cstock.ControlStockBackend.service;

import app.cstock.ControlStockBackend.dto.CodesDto;
import app.cstock.ControlStockBackend.dto.FileProductDto;
import app.cstock.ControlStockBackend.entity.Codes;

import java.util.List;

public interface CodesService {

    public List<CodesDto> getAllCodes();

    public List<CodesDto> getAllCodesByFileProductId(Long fileProductId);

    public CodesDto getCodesById(String id);

    public Codes getByIdCodesEntity(String id);

    public List<FileProductDto> getAllFileProductsByCodesId(String codesId);

    public CodesDto addCodes(Long fileProductId, CodesDto codes);

    public void deleteCodesFromFileProduct(Long fileProductId, String codesId);

    public void deleteAllCodesFromFileProduct();

    public void deleteCodes(String id);

    public void deleteAllCodes();
}
