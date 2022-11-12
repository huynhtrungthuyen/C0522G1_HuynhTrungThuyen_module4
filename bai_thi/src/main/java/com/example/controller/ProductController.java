package com.example.controller;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "priceSearch", defaultValue = "") String priceSearch,
                           Model model) {

        model.addAttribute("productList", iProductService.searchProduct(nameSearch, priceSearch, pageable));
        model.addAttribute("productTypeList", iProductTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("priceSearch", priceSearch);

        return "list";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("productTypeList", iProductTypeService.findAll());

        return "create";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productTypeList", iProductTypeService.findAll());

            return "create";
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới sản phẩm thành công!");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = iProductService.findById(id).get();

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);

        model.addAttribute("productDto", productDto);
        model.addAttribute("productTypeList", iProductTypeService.findAll());

        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productTypeList", iProductTypeService.findAll());

            return "edit";
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa sản phẩm thành công!");

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iProductService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công.");

        return "redirect:/";
    }
}
