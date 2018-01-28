package io.khasang.eshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "Cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long id;

    private String name;
    private String description;

    @Transient
    private String additionnal;

    public String getAdditionnal() {
        return additionnal;
    }

    public void setAdditionnal(String aditionnal) {
        this.additionnal = aditionnal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
