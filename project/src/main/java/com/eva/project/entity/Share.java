package com.eva.project.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shares")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Share implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_share", allocationSize = 1)
    @GeneratedValue(generator = "seq_share", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 3, name = "name")
    private String name;

    @Column(name = "price")
    private Long price;



}
