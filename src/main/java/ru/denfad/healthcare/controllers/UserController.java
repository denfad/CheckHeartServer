package ru.denfad.healthcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.denfad.healthcare.models.Diagnose;
import ru.denfad.healthcare.models.User;
import ru.denfad.healthcare.services.DiagnoseService;
import ru.denfad.healthcare.services.PythonConnector;
import ru.denfad.healthcare.services.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    private final DiagnoseService diagnoseService;
    private final PythonConnector pythonConnector;

    @Autowired
    public UserController(UserService userService, DiagnoseService diagnoseService, PythonConnector pythonConnector){
        this.userService=userService;
        this.diagnoseService = diagnoseService;
        this.pythonConnector = pythonConnector;
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/registration", consumes = "application/json",produces =  "application/json")
    public User registUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping(path="/auth", produces = "application/json")
    public User authUser(@RequestParam String login,@RequestParam String password){
        return userService.checkUser(login,password);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @PutMapping(path = "/diagnose/{id}", consumes = "application/json")
    public void saveDiagnose(@PathVariable(name= "id") Integer userId, @RequestBody Diagnose diagnose, @RequestParam Integer year, @RequestParam Integer month){
        Calendar calendar = new GregorianCalendar();
        System.out.println(year);
        Date date = new Date();
        date.setYear(year);
        date.setMonth(month);
        calendar.setTime(date);
        diagnose.setDate(calendar);
        diagnoseService.saveDiagnose(diagnose,userId);
    }

    @GetMapping(path = "/diagnose/{id}", produces = "application/json")
    public List<Diagnose> getDiagnoses(@PathVariable(name= "id") Integer userId){
        return diagnoseService.getDiagnoseByUserId(userId);
    }

    @GetMapping(path = "/tasks", produces = "application/json")
    public String getDiagnoses(){
        return pythonConnector.sendGet();
    }
}
