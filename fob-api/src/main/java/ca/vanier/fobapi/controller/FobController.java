package ca.vanier.fobapi.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import ca.vanier.fobapi.services.FobService;
import ca.vanier.systemlib.entity.Fob;
import ca.vanier.fobapi.services.UserService;
import ca.vanier.systemlib.entity.User;

@RestController
@RequestMapping("/fob")
public class FobController {

    @Autowired
    private FobService fs;

    @Autowired
    private UserService us;

    @PostMapping("/save") // Create
    public Response save(@RequestBody Fob f) {
        Response res = new Response();

        try{
            fs.save(f);
            res.setResult(f.toString() + " added.");
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
            res.setResult(fs.findById(id).get().toString() + " found.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PutMapping("/update") // Update
    public Response update(@RequestBody Fob f) {
        Response res = new Response();

        try{
            Fob found = fs.findById(f.getFobId()).get();
            fs.save(f);
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
            Fob found = fs.findById(id).get();
            res.setResult(found.toString() + " deleted.");
            fs.delete(found.getFobId());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/access")
    public Response access(@RequestBody Fob f){
        Response res = new Response();

        try{
            Fob fob = fs.findById(f.getFobId()).get();
            User user = us.findById(fob.getUserId()).get();
            if(user.isStatus()){
                res.setResult(fob.toString() + " granted access.");
                res.setStatus("200: Success");
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }
}
