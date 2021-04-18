package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@Controller
public class TaskApplication {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    String task(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("todos", tasks);
        return "task";
    }


    @GetMapping("/task_add")

    String create(@ModelAttribute Task task) {
        return "task_add";
    }


    @PostMapping("/task_add")
    String regist(@ModelAttribute Task task) {
        Task tas = new Task();
        BeanUtils.copyProperties(task, tas);

        taskService.insert(tas);

        return "redirect:/task";
    }


    @PostMapping(path = "task_edit", params = "edit")

    String edit(@RequestParam Integer task_id, @ModelAttribute Task task) {
        Optional<Task> customerOpt = taskService.selectById(task_id);

        Task tas = customerOpt.get();

        BeanUtils.copyProperties(tas, task);
        return "task_edit";
    }

    @PostMapping(path = "task_edit", params = "regist")

    String regist(@RequestParam Integer task_id, @ModelAttribute Task task) {

        Task tas = new Task();
        BeanUtils.copyProperties(task, tas);
        tas.setTaskId(task_id);
        taskService.update(tas);
        return "redirect:/task";
    }

    @PostMapping(path = "task_edit", params = "back")
    String back() {
        return "redirect:/task";
    }

    @PostMapping(path = "task_edit", params = "delete")
    String delete(@RequestParam Integer task_id) {
        taskService.delete(task_id);
        return "redirect:/task";
    }
}