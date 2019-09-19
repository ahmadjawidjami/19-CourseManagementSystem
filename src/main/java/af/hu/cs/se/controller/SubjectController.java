package af.hu.cs.se.controller;


import af.hu.cs.se.model.Student;
import af.hu.cs.se.model.Subject;
import af.hu.cs.se.service.StudentService;
import af.hu.cs.se.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("subject", new Subject());

        return "subject-form";
    }


    @PostMapping("/subject/register")
    public String register(@ModelAttribute Subject subject) {

        subjectService.saveSubject(subject);

        return "redirect:/subject/list";
    }

    @RequestMapping(path = "/subject/list", method = RequestMethod.GET)
    public String getSubjectListPage(Model model) {

        model.addAttribute("subjects", subjectService.findAll());
        return "subject-list";
    }

    @GetMapping("/subject/edit/{id}")
    public String editSubject(@PathVariable Long id, Model model) {
        Subject subject = subjectService.findSubjectById(id);
        model.addAttribute("subject", subject);

        return "subject-form";

    }

    @PostMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable Long id) {

        subjectService.deleteSubjectById(id);

        return "redirect:/subject/list";
    }
}
