package com.stakroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
        @Id
        @GeneratedValue
        int id;

        String movieName;
        String releaseDate;
        String category;
        BigDecimal budget;
        String casts;
/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }
    public Movie() { }

    public Movie(int id, String movieName, String releaseDate, String category, BigDecimal budget, String casts) {
        this.id = id;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.category = category;
        this.budget = budget;
        this.casts = casts;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", category='" + category + '\'' +
                ", budget=" + budget +
                ", casts='" + casts + '\'' +
                '}';
    }*/
}
