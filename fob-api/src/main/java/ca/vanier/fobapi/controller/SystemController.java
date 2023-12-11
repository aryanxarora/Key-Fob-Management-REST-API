package ca.vanier.fobapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.fobapi.services.SystemService;
import ca.vanier.systemlib.entity.System;

@RestController
@RequestMapping("/system")
public class SystemController {
    
    @Autowired
    private SystemService ss;

    @PostMapping("/save") // Create
    public Response save(@RequestBody System s) {
        Response res = new Response();

        try{
            ss.save(s);
            res.setResult(s.toString() + " added.");
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
            res.setResult(ss.findById(id).get().toString() + " found.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PutMapping("/update") // Update
    public Response update(@RequestBody System s) {
        Response res = new Response();

        try{
            System found = ss.findById(s.getSystemId()).get();
            ss.save(s);
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
            System found = ss.findById(id).get();
            res.setResult(found.toString() + " deleted.");
            ss.delete(found.getSystemId());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }
}
