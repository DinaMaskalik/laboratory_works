package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PERSON")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "P_ID")
    private String id;

    @Column(name = "P_NAME")
    private String name;

    @Column(name = "P_EMAIL")
    private String email;

    @Column(name = "P_STATE")
    private String state;

}
