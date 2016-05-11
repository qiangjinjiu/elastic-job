package com.kingmed.bidir.job.core.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJobMainWithoutNamespace {
    private SpringJobMainWithoutNamespace() {
    }
    
    // CHECKSTYLE:OFF
    @SuppressWarnings("resource")
    public static void main(final String[] args) {
    // CHECKSTYLE:ON
        new ClassPathXmlApplicationContext("classpath:META-INF/bidirWithoutNamespace.xml");
    }

}
