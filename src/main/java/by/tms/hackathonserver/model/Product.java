package by.tms.hackathonserver.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "creatorusername")
    private String creatorUsername;

    @Column(name = "location")
    private String location;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private long price;

    @Column(name = "namepicture")
    private String namePicture;

    @Column(name = "datecreating")
    private String dateCreating;

//    @PrePersist
//    protected void onCreate() {
//        this.dateCreating = LocalDateTime.now();
//    }
}
