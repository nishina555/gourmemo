package com.myproject.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by nishina on 2016/05/07.
 */
@Entity
@Table(name="shops")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String note;
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true, name = "id")
    private User user;*/

}