package af.hu.cs.se.controller;

import af.hu.cs.se.model.Student;
import af.hu.cs.se.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("student", new Student());

        return "student-form";
    }


    @PostMapping("/student/register")
    public String register(@ModelAttribute Student student) {

        studentService.saveStudent(student);

        return "redirect:/student/list";
    }

    @RequestMapping(path = {"/student/list", "/"}, method = RequestMethod.GET)
    public String getStudentListPage(Model model) {

        model.addAttribute("students", studentService.findAll());
        return "student-list";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);

        return "student-form";

    }

    @PostMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudentById(id);

        return "redirect:/student/list";
    }
}
