package com.massadobe.means.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetWithoutParams {

    private Long gUid;
    private Long sysId;
    private String ans;

}
