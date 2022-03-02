package edu.byu.is560r.bsierra1notesapinew.controller;

import edu.byu.is560r.bsierra1notesapinew.model.User;
import edu.byu.is560r.bsierra1notesapinew.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "UserController", description = "User Controller endpoint")
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private HttpServletRequest httpServletRequest;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@RequestParam(name = "id") Long id) {
        var user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        var returnUser = userService.saveUser(user);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromRequestUri(httpServletRequest)
                        .queryParam("id={id}")
                        .buildAndExpand(returnUser.getId()).toUri())
                .body(returnUser);
    }
}
