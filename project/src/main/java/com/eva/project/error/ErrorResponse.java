package com.eva.project.error;

import com.eva.project.error.model.ErrorModel;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private List<ErrorModel> errorMessage;
}
