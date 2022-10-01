package ua.com.solution.view.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ua.com.solution.facade.UniversityFacade;
import ua.com.solution.persistence.entity.University;
import ua.com.solution.util.ResponseMessage;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class MainController {
  private final UniversityFacade universityFacade;

    public MainController(UniversityFacade universityFacade) {
        this.universityFacade = universityFacade;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile multipartFile) {

        String message;
        try {
            universityFacade.saveAll(multipartFile);
            message = "Uploaded the file successfully: " + multipartFile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + multipartFile.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/all")
    public List <University> showAll(){
        return universityFacade.findAll();
    }
}