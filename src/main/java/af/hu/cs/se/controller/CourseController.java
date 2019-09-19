package af.hu.cs.se.controller;

import af.hu.cs.se.model.Course;
import af.hu.cs.se.model.Student;
import af.hu.cs.se.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("course", new Course());

        return "course-form";
    }


    @PostMapping("/course/register")
    public String register(@ModelAttribute Course course) {

        courseService.saveCourse(course);

        return "redirect:/course/list";
    }

    @RequestMapping(path = "/course/list", method = RequestMethod.GET)
    public String getCourseListPage(Model model) {

        model.addAttribute("courses", courseService.findAll());
        return "course-list";
    }

    @GetMapping("/course/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);

        return "course-form";

    }

    @PostMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {

        courseService.deleteCourseById(id);

        return "redirect:/course/list";
    }
}
