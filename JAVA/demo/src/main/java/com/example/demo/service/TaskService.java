package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void insert(Task Task) {
        taskRepository.save(Task);
    }

    public void update(Task Task) {
        taskRepository.save(Task);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> selectById(Integer id) {
        return taskRepository.findById(id);
    }
}