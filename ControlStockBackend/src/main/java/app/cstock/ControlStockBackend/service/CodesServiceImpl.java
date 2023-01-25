package app.cstock.ControlStockBackend.service;

import app.cstock.ControlStockBackend.dto.CodesDto;
import app.cstock.ControlStockBackend.dto.FileProductDto;
import app.cstock.ControlStockBackend.entity.Codes;
import app.cstock.ControlStockBackend.entity.FileProduct;
import app.cstock.ControlStockBackend.exeption.ResourceNoteFoundException;
import app.cstock.ControlStockBackend.repository.CodesRepository;
import app.cstock.ControlStockBackend.repository.FileProductRepository;
import app.cstock.ControlStockBackend.tools.CodesTools;
import app.cstock.ControlStockBackend.tools.FileProductTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodesServiceImpl implements CodesService {

    @Autowired
    private CodesRepository codesRepository;
    @Autowired
    private FileProductRepository fileProductRepository;

    CodesTools codesTools = new CodesTools();
    FileProductTools fileProductTools = new FileProductTools();

    @Override
    public List<CodesDto> getAllCodes() {
        List<Codes> codesList = codesRepository.findAll();
        return codesList.stream().map(codes -> codesTools.mapDto(codes)).collect(Collectors.toList());
    }

    @Override
    public List<CodesDto> getAllCodesByFileProductId(Long fileProductId) {
        if (!fileProductRepository.existsById(fileProductId)) {
            throw new ResourceNoteFoundException("FileProduct", "id", fileProductId);
        }

        List<Codes> codesList = codesRepository.findCodesByFileProductsId(fileProductId);
        return codesList.stream().map(codes -> codesTools.mapDto(codes)).collect(Collectors.toList());
    }

    @Override
    public CodesDto getCodesById(String id) {
        Codes codes = codesRepository.findById(id).orElseThrow(() -> new ResourceNoteFoundException("Codes", "id", 0L)); // Hacer
                                                                                                                         // exeption
                                                                                                                         // para
                                                                                                                         // id
                                                                                                                         // tipo
                                                                                                                         // string
        return codesTools.mapDto(codes);
    }

    @Override
    public Codes getByIdCodesEntity(String id) {
        Codes codes = codesRepository.findById(id).orElseThrow(() -> new ResourceNoteFoundException("Codes", "id", 0L)); // Hacer
                                                                                                                         // exeption
                                                                                                                         // para
                                                                                                                         // id
                                                                                                                         // tipo
                                                                                                                         // string
        return codes;
    }

    @Override
    public List<FileProductDto> getAllFileProductsByCodesId(String codesId) {
        if (!codesRepository.existsById(codesId)) {
            throw new ResourceNoteFoundException("Codes", "id", 0L); // Hacer exeption para id string
        }
        List<FileProduct> fileProductList = fileProductRepository.findFileProductsByCodesId(codesId);
        return fileProductList.stream().map(fileProduct -> fileProductTools.mapDto(fileProduct))
                .collect(Collectors.toList());
    }

    @Override
    public CodesDto addCodes(Long fileProductId, CodesDto codesRequest) {
        Codes codes = fileProductRepository.findById(fileProductId).map(fileProduct -> {
            if (codesRepository.existsById(codesRequest.getId())) {
                // add cod, save file
                fileProduct.addCode(codesTools.mapEntity(codesRequest));
                fileProductRepository.save(fileProduct); // Es probable que tengamos que verificar si el codigo ya le
                                                         // pertenece al producto
                return codesTools.mapEntity(codesRequest);
            } else {
                // add and create new Codes
                fileProduct.addCode(codesTools.mapEntity(codesRequest));
                fileProductRepository.save(fileProduct);
                return codesRepository.save(codesTools.mapEntity(codesRequest));
            }

        }).orElseThrow(() -> new ResourceNoteFoundException("FileProduct", "id", fileProductId));
        return codesTools.mapDto(codes);
    }

    @Override
    public void deleteCodesFromFileProduct(Long fileProductId, String codesId) {
        FileProduct fileProduct = fileProductRepository.findById(fileProductId)
                .orElseThrow(() -> new ResourceNoteFoundException("FileProduct", "id", fileProductId));
        fileProduct.removeCode(codesId);
        fileProductRepository.save(fileProduct);
    }

    @Override
    public void deleteAllCodesFromFileProduct() {
        List<FileProduct> fileProductList = fileProductRepository.findAll();
        int cont = 0;
        for (FileProduct fileProduct: fileProductList) {
            FileProduct fileProductNew = fileProductRepository.findById(fileProduct.getId())
                    .orElseThrow(() -> new ResourceNoteFoundException("FileProduct", "id", fileProduct.getId()));
            List<CodesDto> codes = getAllCodesByFileProductId(fileProduct.getId());
            for (CodesDto code: codes) {
                fileProductNew.removeCode(code.getId());
                fileProductRepository.save(fileProductNew);
            }
        }
    }

    @Override
    public void deleteCodes(String id) {
        codesRepository.delete(getByIdCodesEntity(id));
    }

    @Override
    public void deleteAllCodes() {
        codesRepository.deleteAll();
    }
}
