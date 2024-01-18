package com.emp.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {

    private long id;

    @NotEmpty
    @Size(min = 2, message = "city should be at least 4 characters")
    //you can apply size only on string if integer then will not work
    private String name;

    @NotEmpty
    @Size(min = 4, message = "city should be at least 4 characters")
    private String city;

    @NotEmpty
    @Size(min = 4, message = "content should be at least 4 characters")
    private String state;

}
