package com.example.controller;

import com.example.dto.FacilityDto;
import com.example.model.facility.Facility;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch, Model model) {
        model.addAttribute("facilityList", iFacilityService.searchFacility(nameSearch, pageable));
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);

        return "facility/list";
    }

    @GetMapping("/create")
    public String createFac(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());

        return "facility/create";
    }

    @PostMapping("/add")
    public String saveFac(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());

            return "facility/create";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Thêm mới dịch vụ thành công!");

        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String editFac(@PathVariable Integer id, Model model) {
        Facility facility = iFacilityService.findById(id).get();

        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);

        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());

        return "facility/edit";
    }

    @PostMapping("/update")
    public String updateFac(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());

            return "facility/edit";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa dịch vụ thành công!");

        return "redirect:/facility";
    }

    @GetMapping("/delete")
    public String deleteFac(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iFacilityService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xóa dịch vụ  [" +
                iFacilityService.findById(id).get().getFacilityName() + "]  thành công.");

        return "redirect:/facility";
    }
}
