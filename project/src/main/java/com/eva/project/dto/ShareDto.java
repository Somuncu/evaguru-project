package com.eva.project.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class ShareDto {

    private Long id;

    @NotNull
    @Pattern(regexp = "|.{0,3}",message = "Should not be bigger than 3 letter")
    private String name;

    private Long price;

}
