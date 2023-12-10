package ca.vanier.fobapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/fob")
public class FobController {
    
    @PostMapping("/save") // Create
    public Response save(@RequestBody Response save) {
        Response res = new Response();

        try{
            // do something
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
            // do something
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
            // do something
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
            // do something
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("Fail");
        }
        
        return res;
    }
    
}
