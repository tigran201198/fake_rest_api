package net.azurewebservices.fakerestapi.books.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    private Integer id;
    private String title;
    private String description;
    private Integer pageCount;
    private String excerpt;
    private OffsetDateTime publishDate;
}
