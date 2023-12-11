package ca.vanier.fobapi.controller;

import ca.vanier.fobapi.services.ClientService;
import ca.vanier.systemlib.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.vanier.fobapi.services.SystemService;
import ca.vanier.systemlib.entity.System;

import java.util.List;
import java.util.Optional;

// import java.util.ArrayList;
// import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {
    
    @Autowired
    private SystemService ss;

    @Autowired
    private ClientService cs;

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

    @GetMapping("/") // Read
    public Response findAll(){
        Response res = new Response();

        try{
            res.setResult(ss.findAll());
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
            res.setResult(ss.findById(id).get());
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
            res.setResult("System " + found.getSystemId() + " updated.");
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
            System found = ss.findById(id).get();
            res.setResult("System " + found.getSystemId() + " deleted.");
            ss.delete(found.getSystemId());
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/renew") // Logic
    public Response renew(){
        Response res = new Response();
        try{
            Iterable<Client> clients = cs.findAll();
            for (Client c: clients) {
                java.lang.System.out.println(c.getCcNum().isEmpty());
                if(c.getCcNum().isEmpty()){ // PAYMENT GATEWAY LOGIC
                    c.setStatus(false);
                } else {
                    c.setStatus(true);
                }
            }
            cs.saveAll(clients);
            res.setResult("Subscription renewal processed.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult("Failed to renew");
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/activate") // Logic
    public Response activate(@RequestParam Long id){
        Response res = new Response();

        try{
            Client found = cs.findById(id).get();
            found.setStatus(true);
            cs.save(found);
            res.setResult("Client " + found.getClientId() + " membership activated.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/deactivate") // Logic
    public Response deactivate(@RequestParam Long id){
        Response res = new Response();

        try{
            Client found = cs.findById(id).get();
            found.setStatus(false);
            cs.save(found);
            res.setResult("Client " + found.getClientId() + " membership deactivated.");
            res.setStatus("200: Success");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/addClient")
    public Response addClient(@RequestParam Long clientID, @RequestParam Long systemID){
        Response res = new Response();

        try{
            Optional<Client> optionalClient = cs.findById(clientID);
            if (optionalClient.isPresent()) {
                Client client = optionalClient.get();
                System system = ss.findById(systemID).get();
                List<Long> clients = system.getClients();
                clients.add(client.getClientId());
                system.setClients(clients);
                ss.save(system);
                res.setResult("Client " + client.getClientId() + " added to System " + system.toString());
                res.setStatus("200: Success");
            } else throw new Exception("Client Not Found");

        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }

    @PostMapping("/removeClient")
    public Response removeClient(@RequestParam Long clientID, @RequestParam Long systemID){
        Response res = new Response();

        try{
            Optional<Client> optionalClient = cs.findById(clientID);
            if (optionalClient.isPresent()) {
                Client client = optionalClient.get();
                System system = ss.findById(systemID).get();
                List<Long> clients = system.getClients();
                clients.remove(client.getClientId());
                system.setClients(clients);
                ss.save(system);
                res.setResult("Client " + client.getClientId() + " removed from " + system.toString());
                res.setStatus("200: Success");
            } else throw new Exception("Client Not Found");
        } catch (Exception e){
            res.setResult(e.toString());
            res.setStatus("500: Fail");
        } return res;
    }
}
