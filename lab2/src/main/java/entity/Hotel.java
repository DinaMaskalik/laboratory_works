package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_HOTEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @Column(name = "H_ID")
    private String id;

    @Column(name = "H_NAME")
    private String name;

    @Column(name = "H_STARS")
    private Integer stars;

    @Column(name = "H_PRICE")
    private Double price;

    @Column(name = "H_RESERVATION")
    private boolean reservation;
}
