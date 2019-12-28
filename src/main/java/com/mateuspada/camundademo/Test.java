package com.mateuspada.camundademo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Test implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String item = (String) delegateExecution.getVariable("item");
        Long amount = (Long) delegateExecution.getVariable("amount");

        System.out.println(item + " no valor de: " + amount);
    }
}
