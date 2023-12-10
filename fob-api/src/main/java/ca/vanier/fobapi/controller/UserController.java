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

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService us;

    @PostMapping("/save") // Create
    public Response save(@RequestBody Response save) {
        Response res = new Response();

        try{
            System.out.println("/USER/SAVE");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("Fail");
        }
        
        return res;
    }

    @GetMapping("/find") // Read
    public Response find(@RequestBody Response save) {
        Response res = new Response();

        try{
            System.out.println("/USER/FIND");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("Fail");
        }
        
        return res;
    }

    @PutMapping("/update") // Update
    public Response update(@RequestBody Response save) {
        Response res = new Response();

        try{
            System.out.println("/USER/UPDATE");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("Fail");
        }
        
        return res;
    }

    @DeleteMapping("/delete") // Delete
    public Response delete(@RequestBody Response save) {
        Response res = new Response();

        try{
            System.out.println("/USER/DELETE");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("Fail");
        }
        
        return res;
    }
    
}
