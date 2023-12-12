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

    @PostMapping("/assign") // Logic
    public Response assign(@RequestParam Long clientID, @RequestParam Long fobID){
        Response res = new Response();
        try{
            Fob fob = fs.findById(fobID).get();
            Client client = cs.findById(clientID).get();
            if(fob.getClientId() == null){
                fob.setClientId(client.getClientId());
                fs.save(fob);
                res.setResult("Fob " + fob.getFobId() + " successfully assigned to client: " + client.getClientId());
                res.setStatus("200: Success");
            } else throw new Exception("Fob " + fob.getFobId() + " is already assigned to client: " + client.getClientId());
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/deassign") // Logic
    public Response deassign(@RequestParam Long fobID){
        Response res = new Response();
        try{
            Fob fob = fs.findById(fobID).get();
            if(fob.getClientId() != null){
                fob.setClientId(null);
                fs.save(fob);
                res.setResult("Fob " + fob.getFobId() + " successfully deassigned.");
                res.setStatus("200: Success");
            } else throw new Exception("Fob " + fob.getFobId() + " is not registered to any client.");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }
}
