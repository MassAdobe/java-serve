package com.massadobe.means.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PrintEveryth {

    private long testId;
    private long nextId;
    private Inner inner;
    private List<String> listing;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Inner {
    private String addr;
    private String name;
}
