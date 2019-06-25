package com.kafka.json;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class StudentJson {
    private int id ;
    private String name;
    private String dep;
}
