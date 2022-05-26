package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.nicolaemariusghergu.easylearn.books.dto.StatusDTO;
import ro.nicolaemariusghergu.easylearn.books.service.StatusService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/v1")
    public ResponseEntity<List<StatusDTO>> getStatuses() {
        return statusService.getStatuses();
    }
}
