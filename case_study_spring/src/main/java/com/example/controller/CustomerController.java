package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                           Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        for (Customer customer : customerList) {
            if (customer.getCustomerBirthday().contains("-")) {
                String[] arr = customer.getCustomerBirthday().split("-");
                customer.setCustomerBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
            }
        }

        model.addAttribute("customerList", iCustomerService.searchCustomer(nameSearch, addressSearch,
                phoneSearch, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);

        return "customer/list";
    }

    @GetMapping("/create")
    public String createCus(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);

        return "customer/create";
    }

    @PostMapping("/add")
    public String saveCus(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        boolean isDuplicateIdCard = false;
        for (Customer customer : iCustomerService.findAll()) {
            if (customerDto.getCustomerIdCard().equals(customer.getCustomerIdCard())) {
                isDuplicateIdCard = true;
                break;
            }
        }

        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCard", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
            }

            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);

            return "customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");

        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editCus(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id).get();

        if (customer.getCustomerBirthday().contains("/")) {
            String[] arr = customer.getCustomerBirthday().split("/");
            customer.setCustomerBirthday(arr[2] + "-" + arr[1] + "-" + arr[0]);
        }

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);

        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCus(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        boolean isDuplicateIdCard = false;
        for (Customer customer : iCustomerService.findAll()) {
            if (customerDto.getCustomerIdCard().equals(customer.getCustomerIdCard())) {
                isDuplicateIdCard = true;
                break;
            }
        }
        if (customerDto.getCustomerIdCard().equals(iCustomerService.findById(customerDto.getCustomerId()).get().getCustomerIdCard())) {
            isDuplicateIdCard = false;
        }

        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCard", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
            }

            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);

            return "customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa khách hàng thành công!");

        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String deleteCus(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iCustomerService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xóa khách hàng  [" +
                iCustomerService.findById(id).get().getCustomerName() + "]  thành công.");

        return "redirect:/customer";
    }
}
