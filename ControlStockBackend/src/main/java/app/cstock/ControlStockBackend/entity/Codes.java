package app.cstock.ControlStockBackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "codes")
public class Codes {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "codes")
    private Set<FileProduct> fileProducts = new HashSet<>();

    public Codes() {
        super();
    }

}
