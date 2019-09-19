package af.hu.cs.se.controller;

import af.hu.cs.se.model.Lecturer;
import af.hu.cs.se.model.Student;
import af.hu.cs.se.service.LecturerService;
import af.hu.cs.se.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/lecturer/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("lecturer", new Lecturer());

        return "lecturer-form";
    }


    @PostMapping("/lecturer/register")
    public String register(@ModelAttribute Lecturer lecturer) {

        lecturerService.saveLecturer(lecturer);

        return "redirect:/lecturer/list";
    }

    @RequestMapping(path = "/lecturer/list", method = RequestMethod.GET)
    public String getStudentListPage(Model model) {

        model.addAttribute("lecturers", lecturerService.findAll());
        return "lecturer-list";
    }

    @GetMapping("/lecturer/edit/{id}")
    public String editLecturer(@PathVariable Long id, Model model) {
        Lecturer lecturer = lecturerService.findLecturerById(id);
        model.addAttribute("lecturer", lecturer);

        return "lecturer-form";

    }

    @PostMapping("/lecturer/delete/{id}")
    public String deleteLecturer(@PathVariable Long id) {

        lecturerService.deleteLecturerById(id);

        return "redirect:/lecturer/list";
    }
}
