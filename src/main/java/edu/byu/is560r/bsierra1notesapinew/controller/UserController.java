package edu.byu.is560r.bsierra1notesapinew.controller;

//import edu.byu.is560r.bsierra1notesapinew.service.DummyUserService;
import edu.byu.is560r.bsierra1notesapinew.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor // This means we don't need a constructor
public class UserController {

    private UserService userService; // This is the injected class

    @GetMapping("/user") // REST Endpoint
    public String getUserName(@RequestParam(name = "user_id") String userName) {
        return userService.getUserName(userName);
    }
}
