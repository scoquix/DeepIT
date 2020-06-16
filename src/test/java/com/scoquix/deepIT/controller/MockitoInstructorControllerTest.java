package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.Instructor;
import com.scoquix.deepIT.repository.InstructorRepository;
import com.scoquix.deepIT.services.InstructorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoInstructorControllerTest {
    @InjectMocks
    private InstructorController instructorController;

    @Mock
    private InstructorRepository instructorRepository;

    @Mock
    private InstructorService service;

    Logger logger = Logger.getLogger(getClass().getName());
    List<Instructor> list = new ArrayList<>();

    @BeforeEach
    public void setup() {

        list.add(new Instructor(9L, 9, "Rob", "Per", new Timestamp(System.currentTimeMillis())));
        list.add(new Instructor(12L, 12, "John", "Doe", new Timestamp(System.currentTimeMillis())));
        list.add(new Instructor(14L, 14, "Ada", "Lovelace", new Timestamp(System.currentTimeMillis())));
    }

    @BeforeEach
    public void init() {
        logger.info("Before method");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetInstructorById() {
//        when(service.getById(9L)).thenReturn(
//                list.stream()
//                .filter(instructor -> Objects.equals(instructor.getId(), 9L))
//                .findFirst());
        Instructor i = new Instructor();
        i.setId(9L);
        when(service.getById(9L)).thenReturn(Optional.of(i));

        Instructor instructor = instructorController.getUserById(9L);
        verify(service, times(2)).getById(9L);

        assertEquals(9L, instructor.getId().longValue());
    }

    @Test
    public void testGetAll() {
        when(service.getAllUsers()).thenReturn(list);

        List<Instructor> instructors = instructorController.getAll();
        verify(service).getAllUsers();

        assertEquals(list, instructors);
    }
}
