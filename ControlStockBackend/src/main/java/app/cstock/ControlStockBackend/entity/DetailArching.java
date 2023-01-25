package app.cstock.ControlStockBackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detail_arching")
public class DetailArching {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "mark")
    private String mark;

    @Column(name = "employee")
    private String employee;

    @Column(name = "scanned_product_amount")
    private Long scannedProductAmount;

    @Column(name = "file_product_amount")
    private Long fileProductAmount;

    @ManyToOne()
    @JoinColumn(name = "arching")
    private Arching arching;

}
