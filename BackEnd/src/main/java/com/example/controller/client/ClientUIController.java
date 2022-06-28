package com.example.controller.client;
/*
 * Classname ClientUIController
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.form.ClientForm;
import com.example.model.Client;
import com.example.model.DiscountType;
import com.example.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/clients")
public class ClientUIController {
    @Autowired
    ClientServiceImpl service;

    @GetMapping("/")
    String showAll(Model model) {
        List<Client> clients = service.getAll();
        model.addAttribute("clients", clients);
        return "clients-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/clients/";
    }


    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addClient(Model model){
        ClientForm clientForm = new ClientForm();
        List<DiscountType> discount = Arrays.asList(DiscountType.values());

        model.addAttribute("form", clientForm);
        model.addAttribute("discounte", discount);
        return "add-client";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("form") ClientForm form){
        if(form.getId() == null &&
        form.getName() == null &&
        form.getDescription() == null &&
        form.getClientNum() == null &&
        form.getClientName() == null &&
        form.getClientMiddleName() == null &&
        form.getClientSurname() == null &&
        form.getClientPassportData() == null
        )
            return "redirect:/ui/v1/clients/";
        else {
            Client client = new Client();
            client.setId(form.getId());
            client.setName(form.getName());
            client.setDescription(form.getDescription());
            client.setClientNum(form.getClientNum());
            client.setClientName(form.getClientName());
            client.setClientMiddleName(form.getClientMiddleName());
            client.setClientSurname(form.getClientSurname());
            client.setClientPassportData(form.getClientPassportData());
            client.setDiscount(null);
            service.create(client);

            return "redirect:/ui/v1/clients/";
        }
    }


    @RequestMapping(value = "updateForm/{id}", method = RequestMethod.GET)
    public String updateClient(Model model, @PathVariable("id") String id){
        Client client = service.get(id);
        ClientForm clientForm = new ClientForm();
        clientForm.setId(client.getId());
        clientForm.setName(client.getName());
        clientForm.setDescription(client.getDescription());
        clientForm.setClientNum(client.getClientNum());
        clientForm.setClientName(client.getClientName());
        clientForm.setClientMiddleName(client.getClientMiddleName());
        clientForm.setClientSurname(client.getClientSurname());
        clientForm.setClientPassportData(client.getClientPassportData());
        clientForm.setDiscount(null);


        model.addAttribute("form", clientForm);
        return "update-client";
    }

    @RequestMapping(value = "updateForm/{id}", method = RequestMethod.POST)
    public String updateClient(@PathVariable("id") String id,
                               @ModelAttribute("form") ClientForm form){
        Client client = service.get(form.getId());
        if(form.getId()==null){
            return "redirect:/ui/v1/clients/";
        }
        else{
            client.setId(form.getId());
            client.setName(form.getName());
            client.setDescription(form.getDescription());
            client.setClientNum(form.getClientNum());
            client.setClientName(form.getClientName());
            client.setClientMiddleName(form.getClientMiddleName());
            client.setClientSurname(form.getClientSurname());
            client.setClientPassportData(form.getClientPassportData());
            client.setDiscount(null);

            service.update(client);
            return "redirect:/ui/v1/clients/";
        }
    }
}
