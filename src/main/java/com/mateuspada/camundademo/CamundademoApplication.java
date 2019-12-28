package com.mateuspada.camundademo;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class CamundademoApplication {

    private final RuntimeService runtimeService;

    public CamundademoApplication(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CamundademoApplication.class, args);
    }

    @EventListener
    public void processPostDeploy(PostDeployEvent event) {
        runtimeService.startProcessInstanceByKey("loanApproval");
    }

}
