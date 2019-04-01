package com.conurets.inventory.controller;

import com.conurets.inventory.util.InventoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @author MSA
 */

@Controller
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping(value = "/")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/form")
    public String form(Model model) {
        model.addAttribute("userRole", InventoryUtil.getUserRole());
        return "form";
    }

    @GetMapping(value = "/reports")
    public String reports() {
        return "reports";
    }

    @GetMapping(value = "/footer")
    public String Footer() {
        return "footer";
    }

    @GetMapping(value = "/header")
    public String Header() {
        return "header";
    }

    @GetMapping(value = "/form-left-panel")
    public String formLeftPanel() {
        return "form-left-panel";
    }

    @GetMapping(value = "/basic-info")
    public String basicInfo() {
        return "basic-info";
    }

    @GetMapping(value = "/storage-info")
    public String storageInfo() {
        return "storage-info";
    }

    @GetMapping(value = "/report-left-panel")
    public String reportLeftPanel() {
        return "report-left-panel";
    }

    @GetMapping(value = "/report-basic-info")
    public String reportBasicInfo() {
        return "report-basic-info";
    }

    @GetMapping(value = "/spare-useage")
    public String spareUseage() {
        return "spare-useage";
    }

    @GetMapping(value = "/item-handling")
    public String itemHandling() {
        return "item-handling";
    }

    @GetMapping(value = "/caliration")
    public String Caliration() {
        return "caliration";
    }

    @GetMapping(value = "/item-conition")
    public String itemConition() {
        return "item-conition";
    }

    @GetMapping(value = "/supplier-info")
    public String supplierInfo() {
        return "supplier-info";
    }
}