package com.eva.project.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class PortfolioDto {

    private Long id;
    @NotNull(message = "user id can not be empty")
    private Long userId;
    @NotNull(message = "share id can not be empty")
    private Long shareId;
    private Long rate;

}
