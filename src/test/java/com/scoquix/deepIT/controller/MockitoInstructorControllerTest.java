package com.scoquix.deepIT.controller;

import com.scoquix.deepIT.entity.Instructor;
import com.scoquix.deepIT.services.InstructorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoInstructorControllerTest {
    @Mock
    private InstructorService service;

    @InjectMocks
    private InstructorController instructorController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetInstructorById() {
        Instructor instructor = new Instructor();
        instructor.setId(9L);
        System.out.println(service.getById(9L).get());
        when(service.getById(9L).get()).thenReturn(instructor);

        Instructor instructor1 = instructorController.getUserById(9L);

        verify(service).getById(9L).get();

        assertEquals(9L, instructor.getId().longValue());
    }
}
