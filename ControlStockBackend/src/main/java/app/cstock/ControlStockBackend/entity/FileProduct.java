package app.cstock.ControlStockBackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Table(name = "file_products")
public class FileProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "mark")
    private String mark;
    @Column(name = "amount")
    private Long amount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonBackReference
    @JoinTable(name = "file_codes", joinColumns = { @JoinColumn(name = "file_product_id") }, inverseJoinColumns = {
            @JoinColumn(name = "codes_id") })
    private Set<Codes> codes = new HashSet<>();

    @JsonManagedReference
    @OneToOne(mappedBy = "fileProduct")
    private ScannedProduct scannedProduct;

    public FileProduct() {
        super();
    }

    public FileProduct(String productName, String mark, Long amount) {
        this.productName = productName;
        this.mark = mark;
        this.amount = amount;
    }

    // Getter and Setter with Lombok

    public void addCode(Codes code) {
        this.codes.add(code);
        code.getFileProducts().add(this);
    }

    public void removeCode(String codeId) {
        Codes code = this.codes.stream().filter(cod -> Objects.equals(cod.getId(), codeId)).findFirst().orElse(null);
        if (code != null) {
            this.codes.remove(code);
            code.getFileProducts().remove(this);
        }
    }
}
