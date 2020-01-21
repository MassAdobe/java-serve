package com.massadobe.means.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetWithParams {

    private String name;
    private Integer age;
    private Long personId;
    private Long gUid;
    private Long sysId;

    public GetWithParams(String name, Integer age, Long personId) {
        this.name = name;
        this.age = age;
        this.personId = personId;
    }
}
