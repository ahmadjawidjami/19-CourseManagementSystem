package af.hu.cs.se.controller;

import af.hu.cs.se.model.*;
import af.hu.cs.se.service.CourseService;
import af.hu.cs.se.service.LecturerService;
import af.hu.cs.se.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/lecturer/register")
    public String getRegisterPage(Model model) {

        model.addAttribute("lecturer", new Lecturer());

        return "lecturer/lecturer-form";
    }


    @PostMapping("/lecturer/register")
    public String register(@ModelAttribute Lecturer lecturer) {

        lecturerService.saveLecturer(lecturer);

        return "redirect:/lecturer/list";
    }

    @RequestMapping(path = "/lecturer/list", method = RequestMethod.GET)
    public String getStudentListPage(Model model) {

        model.addAttribute("lecturers", lecturerService.findAll());
        return "lecturer/lecturer-list";
    }

    @GetMapping("/lecturer/edit/{id}")
    public String editLecturer(@PathVariable Long id, Model model) {
        Lecturer lecturer = lecturerService.findLecturerById(id);
        model.addAttribute("lecturer", lecturer);

        return "lecturer/lecturer-form";

    }

    @PostMapping("/lecturer/delete/{id}")
    public String deleteLecturer(@PathVariable Long id) {

        lecturerService.deleteLecturerById(id);

        return "redirect:/lecturer/list";
    }

    @GetMapping("/lecturer/{id}/details")
    public String getDetails(@PathVariable Long id, Model model) {

        Lecturer lecturer = lecturerService.findLecturerById(id);
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("lecturerId", id);

        model.addAttribute("courses", lecturer.getCourses());
        return "lecturer/lecturer-detail";
    }

    @GetMapping("/lecturer/{id}/set-course")
    public String chooseCourses(@PathVariable Long id, Model model) {
        model.addAttribute("lecturerId", id);

        List<Course> courses = courseService.findAll();

        model.addAttribute("courses", courses);
        model.addAttribute("chooseCourse", new ChooseCourse());
        return "lecturer/choose-course";
    }

    @PostMapping("/lecturer/{id}/set-course")
    public String chooseCourses(@PathVariable Long id, @ModelAttribute ChooseCourse chooseCourse) {

        Lecturer lecturer = lecturerService.findLecturerById(id);
        Set<Course> courses = new HashSet<>();
        for (Long currentId :chooseCourse.getCourseIds()) {
            courses.add(courseService.findCourseById(currentId));
        }

        lecturer.setCourses(courses);
        lecturerService.saveLecturer(lecturer);

        return "redirect:/lecturer/" + id + "/details";
    }


    @GetMapping("/lecturer/{id}/set-subjects")
    public String chooseSubjects(@PathVariable Long id, Model model) {

        List<Subject> subjects = new ArrayList<>();

        Lecturer lecturer = lecturerService.findLecturerById(id);

        for (Course course : lecturer.getCourses()) {

            subjects.addAll(course.getSubjects());
        }

        model.addAttribute("chooseSubject", new ChooseSubject());
        model.addAttribute("subjects", subjects);
        model.addAttribute("lecturerId", id);

        return "lecturer/choose-subject";
    }

    @PostMapping("/lecturer/{id}/set-subjects")
    public String chooseSubjects(@PathVariable Long id, @ModelAttribute ChooseSubject chooseSubject) {
        Lecturer lecturer = lecturerService.findLecturerById(id);
        List<Subject> subjects = new ArrayList<>();

        for (Long subjectId : chooseSubject.getSubjectIds()) {
            subjects.add(subjectService.findSubjectById(subjectId));
        }

       // lecturer.setSubjects(new HashSet<>(subjects));

        //lecturerService.saveLecturer(lecturer);

        for (Subject subject : subjects) {
            subject.setLecturer(lecturer);
            subjectService.saveSubject(subject);
        }


        return "redirect:/lecturer/" + id + "/details";
    }
}
