package com.test.model.dto.fastApiDto;

import com.test.model.dto.externalPublicDto.Items;
import lombok.Data;

@Data
public class Candidate {
    private Items items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;
}
