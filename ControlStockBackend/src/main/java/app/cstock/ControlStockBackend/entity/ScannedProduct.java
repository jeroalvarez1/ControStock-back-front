package app.cstock.ControlStockBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Objects;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@Entity
@Table(name = "scanned_products")
public class ScannedProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @OneToOne
    @JoinColumn(name = "file_products_id", unique = true)
    @JsonBackReference
    private FileProduct fileProduct;

    public ScannedProduct() {
        super();
    }

    public ScannedProduct(Long amount) {
        this.amount = amount;
    }

    public ScannedProduct(Long id, Long amount, FileProduct fileProduct) {
        this.id = id;
        this.amount = amount;
        this.fileProduct = fileProduct;
    }
}
