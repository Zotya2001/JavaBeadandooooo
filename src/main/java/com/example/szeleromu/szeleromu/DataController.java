package com.example.szeleromu.szeleromu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/szeleromu")
    public String showData(Model model) {
        model.addAttribute("helyszinek", dataService.getAllHelyszin());
        model.addAttribute("megyek", dataService.getAllMegye());
        model.addAttribute("tornyok", dataService.getAllTorony());
        return "szeleromu"; // a "data.html" nézetre mutat az templates könyvtárban
    }
}
