package com.example.multidatabases.repositories.database2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "second_mongo")
public class Database2Model {
    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "SecondaryModel{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}
