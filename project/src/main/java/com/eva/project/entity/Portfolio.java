package com.eva.project.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_portfolio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Portfolio implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_user_portfolio", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_portfolio", strategy = GenerationType.SEQUENCE)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_portfolio_id")
//    private User user;

    //@OneToMany
    //@JoinColumn(name = "share_portfolio_id")
    @Column(name = "share_portfolio_id")
    private Long shareId;

    @Column(name = "rate")
    private Long rate;



}
