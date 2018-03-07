package com.xiobit.petstore.cucumber.stepdefs;

import com.xiobit.petstore.PetstoreApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = PetstoreApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
