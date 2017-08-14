package com.onanis.crw;

import com.onanis.crw.tasklet.AvgleCrawleTasklet;
import com.onanis.crw.tasklet.AvgleImportTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvgleDownloadBatchConfiguration {
    @Autowired
    private AvgleCrawleTasklet crwTasklet;
    @Autowired
    private AvgleImportTasklet importTasklet;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    public Step step1() {
        return stepBuilderFactory.get("step12")
                .tasklet(crwTasklet).build();
    }

    public Step step2() {
        return stepBuilderFactory.get("step21")
                .tasklet(importTasklet).build();
    }

    @Bean(name = JobName.Constants.AVGLE)
    public Job job() throws Exception {
        return jobBuilderFactory.get("job2")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .start(step1()).next(step2()).build();
    }

    public JobExecutionListener listener() {
        return new JobListener();
    }
}
