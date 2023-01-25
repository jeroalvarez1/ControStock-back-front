package app.cstock.ControlStockBackend.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
public class ArchingDto {

    private Long id;

    private String referrer;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;

    public ArchingDto() {
        super();
    }

    public ArchingDto(Long id, String referrer, String technical, Long totalQuantity, Date startDate,
                      Date endDate) {
        this.id = id;
        this.referrer = referrer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
