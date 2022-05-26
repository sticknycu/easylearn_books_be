package ro.nicolaemariusghergu.easylearn.books.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.nicolaemariusghergu.easylearn.books.dto.PublishHouseDTO;
import ro.nicolaemariusghergu.easylearn.books.service.PublishHouseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publish-houses")
public class PublishHouseController {

    private final PublishHouseService publishHouseService;

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<?> addPublishHouse(@RequestBody PublishHouseDTO publishHouseDTO) {
        return publishHouseService.addPublishHouse(publishHouseDTO);
    }

    @PatchMapping("/v1/{publishHouseId}")
    @ResponseBody
    public ResponseEntity<?> modifyPublishHouse(@PathVariable Long publishHouseId, @RequestBody PublishHouseDTO publishHouseDTO) {
        return publishHouseService.modifyPublishHouse(publishHouseId, publishHouseDTO);
    }

    @DeleteMapping("/v1/{publishHouseId}")
    @ResponseBody
    public ResponseEntity<?> deletePublishHouse(@PathVariable Long publishHouseId) {
        return publishHouseService.deletePublishHouse(publishHouseId);
    }
}
