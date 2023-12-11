package ca.vanier.fobapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.fobapi.services.ClientService;
import ca.vanier.systemlib.entity.Client;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService cs;

    @PostMapping("/save") // Create
    public Response save(@RequestBody Client c) {
        Response res = new Response();

        try{
            cs.save(c);
            res.setResult(c.toString() + " added.");
            res.setStatus("201: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @GetMapping("/") // Read
    public Response findAll(){
        Response res = new Response();

        try{
            res.setResult(cs.findAll());
            res.setStatus("200: Success");
        } catch (Exception ex){
            res.setResult(ex.toString());
            res.setStatus("500: Fail");
        } return res;
    } 

    @GetMapping("/find") // Read
    public Response find(@RequestParam Long id) {
        Response res = new Response();

        try{
            res.setResult(cs.findById(id).get());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PutMapping("/update") // Update
    public Response update(@RequestBody Client c) {
        Response res = new Response();

        try{
            Client found = cs.findById(c.getClientId()).get();
            cs.save(c);
            res.setResult("Client " + found.getClientId() + " updated.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @DeleteMapping("/delete") // Delete
    public Response delete(@RequestParam Long id) {
        Response res = new Response();

        try{
            Client found = cs.findById(id).get();
            res.setResult("Client " + found.getClientId() + " deleted.");
            cs.delete(found.getClientId());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    // @Aryan: additional logic endpoints should be added here. Please add /assign and /deassign system (location). Make sure to check if systemId exist before assigning.
}
