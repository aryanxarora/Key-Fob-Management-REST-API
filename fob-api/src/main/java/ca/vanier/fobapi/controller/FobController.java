package ca.vanier.fobapi.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import ca.vanier.fobapi.services.FobService;
import ca.vanier.systemlib.entity.Fob;
import ca.vanier.fobapi.services.ClientService;
import ca.vanier.systemlib.entity.Client;

@RestController
@RequestMapping("/fob")
public class FobController {

    @Autowired
    private FobService fs;

    @Autowired
    private ClientService cs;

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

    @GetMapping("/") // Read
    public Response findAll(){
        Response res = new Response();

        try{
            res.setResult(fs.findAll());
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
            res.setResult(fs.findById(id).get());
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
            res.setResult("Fob " + found.getFobId() + " updated.");
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
            Fob found = fs.findById(id).get();
            res.setResult("Fob " + found.getFobId() + " deleted.");
            fs.delete(found.getFobId());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    // @Aryan: /access endpoint should check for the fob's expiry date BEFORE checking for the Client's current access status
    @PostMapping("/access") // Logic
    public Response access(@RequestParam Long id){
        Response res = new Response();

        try{
            Fob fob = fs.findById(id).get();
            Client client = cs.findById(fob.getClientId()).get();
            if(client.isStatus()){
                res.setResult(fob.toString() + " granted access.");
                res.setStatus("200: Success");
            } else throw new Exception("Fob does not have access.");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    // @Aryan: additional logic endpoints should be added here. Please add /assign and /deassign client. Make sure to check if clientID exist before assigning.
}
