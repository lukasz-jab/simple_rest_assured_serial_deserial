package rest_assured_by_file.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book implements Serializable {
    private String title, author;
}
