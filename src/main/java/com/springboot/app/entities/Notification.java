package com.springboot.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "notification")
    private String notification;
    @Column(name = "status")
    private String status;

    public Notification(long id, String notification, String status) {
        this.id = id;
        this.notification = notification;
        this.status = status;
    }
}
