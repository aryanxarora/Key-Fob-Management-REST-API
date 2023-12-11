package ca.vanier.fobapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.fobapi.services.UserService;
import ca.vanier.systemlib.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService us;

    @PostMapping("/save") // Create
    public Response save(@RequestBody User u) {
        Response res = new Response();

        try{
            us.save(u);
            res.setResult(u.toString() + " added.");
            res.setStatus("201: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @GetMapping("/find") // Read
    public Response find(@RequestBody Long id) {
        Response res = new Response();

        try{
            res.setResult(us.findById(id).get().toString() + " found.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PutMapping("/update") // Update
    public Response update(@RequestBody User u) {
        Response res = new Response();

        try{
            User found = us.findById(u.getUserId()).get();
            us.save(u);
            res.setResult(found.toString() + " updated.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @DeleteMapping("/delete") // Delete
    public Response delete(@RequestBody Long id) {
        Response res = new Response();

        try{
            User found = us.findById(id).get();
            res.setResult(found.toString() + " deleted.");
            us.delete(found.getUserId());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }
}
