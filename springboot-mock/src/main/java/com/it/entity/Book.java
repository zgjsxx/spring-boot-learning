package com.it.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Dax
 * @since 10:22  2019-07-23
 */
@Data
public class Book {
    private String title;
    private String author;
    private Double price;
    private LocalDate releaseTime;
}