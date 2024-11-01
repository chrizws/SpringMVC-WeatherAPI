package com.xyz.weather.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

//    @CreationTimestamp
//    private LocalDateTime createdOn;

//    @UpdateTimestamp
//    private LocalDateTime updatedOn;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="weather_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Day> days;

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String timezone;
    private String local_time;
    private String last_updated;
    private double temp_c;
    private double temp_f;
    private double humidity;
    private String weatherStatus;
    private String weatherIcon;


}
