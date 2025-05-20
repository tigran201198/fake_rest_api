package net.azurewebservices.fakerestapi.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class ErrorEntity {

    private String type;
    private String title;
    private Integer status;
    private String traceId;
    private Map<String, List<String>> errors;
}
