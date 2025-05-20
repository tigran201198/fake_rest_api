package net.azurewebservices.fakerestapi.authors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    private Integer id;
    private Integer idBook;
    private String firstName;
    private String lastName;
}
