package com.test.model.service;

import com.test.model.dto.externalPublicDto.JobItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PublicDataServing {

    private Candidate  toCandi

    private String makeHashId(JobItem jobItem) {
        return Integer.toHexString(Objects.hash(jobItem.getJobNm(),jobItem.getRegDt(),jobItem.getRegagnName()));
    }

}
