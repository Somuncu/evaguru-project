package com.eva.project.dto;

import com.eva.project.entity.Portfolio;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserDto {

    private Long id;

    @NotNull
    private String name;

    private String surname;

    private List<Portfolio> portfolios;
}
