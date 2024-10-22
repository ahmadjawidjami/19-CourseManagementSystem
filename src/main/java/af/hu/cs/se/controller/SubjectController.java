package af.hu.cs.se.controller;


import af.hu.cs.se.model.Course;
import af.hu.cs.se.model.Subject;
import af.hu.cs.se.service.CourseService;
import af.hu.cs.se.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/subject/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("subject", new Subject());

        model.addAttribute("courses", courseService.findAll());

        return "subject/subject-form";
    }


    @PostMapping("/subject/register")
    public String register(@ModelAttribute Subject subject, @RequestParam Long courseId) {
        Course course = courseService.findCourseById(courseId);
        subject.setCourse(course);
        subjectService.saveSubject(subject);

        return "redirect:/subject/list";
    }

    @RequestMapping(path = "/subject/list", method = RequestMethod.GET)
    public String getSubjectListPage(Model model) {

        model.addAttribute("subjects", subjectService.findAll());
        return "subject/subject-list";
    }

    @GetMapping("/subject/edit/{id}")
    public String editSubject(@PathVariable Long id, Model model) {
        Subject subject = subjectService.findSubjectById(id);
        model.addAttribute("subject", subject);

        model.addAttribute("courses", courseService.findAll());

        return "subject/subject-form";

    }

    @PostMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable Long id) {

        subjectService.deleteSubjectById(id);

        return "redirect:/subject/list";
    }
}
