package sap.gb.spring_boot.rest;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sap.gb.spring_boot.exception.ExceptionMessage;
import sap.gb.spring_boot.exception.IdNotNullException;
import sap.gb.spring_boot.exception.NoSuchUserException;
import sap.gb.spring_boot.service.UserService;
import sap.gb.spring_boot.model.User;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserResource {
    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all") //(produces = "application/json") как я понял json установлен по умолчанию, данное значение можно установить для читаемости.
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        if (user.getId() != null) {
            throw new IdNotNullException();
        }
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}/id")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findUserById(id)
                .orElseThrow(NoSuchUserException::new);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/id")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> noSuchUserExceptionHandler(NoSuchUserException exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setTimestamp(new Date());
        exceptionMessage.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionMessage.setMessage(exception.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> illegalStateExceptionHandler(IdNotNullException exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setTimestamp(new Date());
        exceptionMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionMessage.setMessage(exception.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }
}
