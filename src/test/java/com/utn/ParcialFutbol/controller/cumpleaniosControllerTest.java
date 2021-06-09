package com.utn.ParcialFutbol.controller;

import com.utn.ParcialFutbol.service.CumpleanioService;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class cumpleaniosControllerTest {

    CumpleaniosController cumpleaniosController;
    CumpleanioService cumpleanioService;

    @Before
    public void setUp(){
        cumpleanioService = mock(CumpleanioService.class);
        cumpleaniosController=new CumpleaniosController(cumpleanioService);
    }
    @Test
    public void getInvitados(){


    }







}
