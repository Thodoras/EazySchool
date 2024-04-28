package org.thodoras.eazyschool.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Audit {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
