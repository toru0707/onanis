package com.onanis.crw;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {

    @Autowired
    private JobLauncher jobLauncher;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(BatchApplication.class, args);
        executeJob(args[0], ctx);
    }

    private static void executeJob(String jobName, ConfigurableApplicationContext ctx) throws Exception {
        Job job;
        switch (jobName){
            case JobName.Constants.PORNHUB:
                job = (Job) ctx.getBean(JobName.Constants.PORNHUB);
                break;
            case JobName.Constants.AVGLE:
                job = (Job) ctx.getBean(JobName.Constants.AVGLE);
                break;
            default:
                job = null;
        }

        JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
        jobLauncher.run(job, new JobParameters());
    }
}
