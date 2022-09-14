package product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.IProductManagementService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductManagementService productManagementService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> productList = productManagementService.findAll();
        model.addAttribute("products", productList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productManagementService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Add new product successful!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productManagementService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productManagementService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "Update product successful!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productManagementService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productManagementService.remove(product.getId());
        redirectAttributes.addFlashAttribute("mess", "Remove product successful!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productManagementService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String showListSearch(@RequestParam String name, Model model) {
        model.addAttribute("products", productManagementService.findByName(name));
        return "/list";
    }
}