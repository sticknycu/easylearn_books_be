package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addStatus(@RequestBody StatusDTO statusDTO) {
        return statusService.addStatus(statusDTO);
    }

    @PatchMapping("/v1/{statusId}")
    @ResponseBody
    public ResponseEntity<?> modifyStatus(@PathVariable Long statusId, @RequestBody StatusDTO statusDTO) {
        return statusService.modifyStatus(statusId, statusDTO);
    }

    @DeleteMapping("/v1/{statusId}")
    @ResponseBody
    public ResponseEntity<?> deleteStatus(@PathVariable Long statusId) {
        return statusService.deleteStatus(statusId);
    }
}
