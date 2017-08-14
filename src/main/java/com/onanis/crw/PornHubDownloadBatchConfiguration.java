package com.onanis.crw;

import com.onanis.crw.tasklet.PornHubCrawleTasklet;
import com.onanis.crw.tasklet.PornHubImportTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PornHubDownloadBatchConfiguration {
    @Autowired
    private PornHubCrawleTasklet crwTasklet;
    @Autowired
    private PornHubImportTasklet importTasklet;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;



    @Bean(name = JobName.Constants.PORNHUB)
    public Job job() throws Exception {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .start(step1()).next(step2()).build();
    }

    public Step step1() {
        return stepBuilderFactory.get("step12")
                .tasklet(crwTasklet).build();
    }

    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(importTasklet).build();
    }

    public JobExecutionListener listener() {
        return new JobListener();
    }
}
