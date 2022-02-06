package com.eva.project.controller;

import com.eva.project.dto.ShareDto;
import com.eva.project.error.ErrorResponse;
import com.eva.project.error.model.ErrorModel;
import com.eva.project.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/share")
@RequiredArgsConstructor
public class ShareController {

    private final ShareService shareService;

    @PostMapping
    public ResponseEntity<ShareDto> save(@Valid @RequestBody ShareDto shareDto) {
        return ResponseEntity.ok(shareService.save(shareDto));
    }

    @GetMapping
    public ResponseEntity<List<ShareDto>> getAll() {
        return ResponseEntity.ok(shareService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<Long> delete(Long id) {
        return ResponseEntity.ok(shareService.delete(id));
    }

    /**
     * Method that check against {@code @Valid} Objects passed to controller endpoints
     *
     * @param exception
     * @return a {@code ErrorResponse}
     * @see ErrorResponse
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {

        List<ErrorModel> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErrorModel(err.getField(), err.getRejectedValue(), err.getDefaultMessage()))
                .distinct()
                .collect(Collectors.toList());
        return ErrorResponse.builder().errorMessage(errorMessages).build();
    }

}
