package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.employee.Employee;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                           Model model) {
        List<Employee> employeeList = iEmployeeService.findAll();
        for (Employee employee : employeeList) {
            if (employee.getEmployeeBirthday().contains("-")) {
                String[] arr = employee.getEmployeeBirthday().split("-");
                employee.setEmployeeBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
            }
        }

        model.addAttribute("employeeList", iEmployeeService.searchEmployee(nameSearch, addressSearch,
                phoneSearch, pageable));
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("employeeDto", new EmployeeDto());
        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);

        return "employee/list";
    }

    @GetMapping("/create")
    public String createEmp(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());

        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);

        return "employee/create";
    }

    @PostMapping("/add")
    public String saveEmp(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());

            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);

            return "employee/create";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Thêm mới nhân viên thành công!");

        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editEmp(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id).get();

        if (employee.getEmployeeBirthday().contains("/")) {
            String[] arr = employee.getEmployeeBirthday().split("/");
            employee.setEmployeeBirthday(arr[2] + "-" + arr[1] + "-" + arr[0]);
        }

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());

        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);

        return "employee/edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());

            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);

            return "employee/edit";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa nhân viên thành công!");

        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iEmployeeService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xóa nhân viên  [" +
                iEmployeeService.findById(id).get().getEmployeeName() + "]  thành công.");

        return "redirect:/employee";
    }
}
