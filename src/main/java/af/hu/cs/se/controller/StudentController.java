package af.hu.cs.se.controller;

import af.hu.cs.se.model.Student;
import af.hu.cs.se.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("student", new Student());

        model.addAttribute("students", studentService.findAll());

        return "student-form";
    }


    @PostMapping("/student/register")
    public String register(@ModelAttribute Student student) {

        studentService.saveStudent(student);

        return "redirect:/student/register";
    }
}
