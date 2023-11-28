package com.example.szeleromu.Uzenet;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlapController {
    private final UzenetOsztalyService uzenetService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public UrlapController(UzenetOsztalyService uzenetService, AuthenticationFacade authenticationFacade) {
        this.uzenetService = uzenetService;
        this.authenticationFacade = authenticationFacade;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/uzenetek")
    public String listMessagesTable(Model model) {
        model.addAttribute("uzenetek", uzenetService.findAllGuestMessages());
        return "uzenetek";
    }

    @GetMapping("/curlap")
    public String showForm(Model model) {
        model.addAttribute("uzenetOsztaly", new UzenetOsztaly());
        return "curlap";
    }

    @PostMapping("/curlap2")
    public String handleFormSubmission(@ModelAttribute("uzenetOsztaly") @Valid UzenetOsztaly uzenetOsztaly,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "curlap";
        }

        String senderName = authenticationFacade.isAuthenticated()
                ? SecurityContextHolder.getContext().getAuthentication().getName()
                : "Vendég"; // Ez dönti el, hogy a felhasználó nevét vagy "Vendég" szöveget adjuk meg.

        uzenetService.saveGuestMessage(uzenetOsztaly, senderName);
        model.addAttribute("attr2", uzenetOsztaly);
        return "eredmeny";
    }
}
