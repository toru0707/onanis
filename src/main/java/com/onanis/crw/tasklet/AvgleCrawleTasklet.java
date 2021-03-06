package com.onanis.crw.tasklet;

import com.onanis.crw.webclient.PornHubWebClient;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvgleCrawleTasklet extends AbstractCrawlTasklet{

    @Autowired
    private PornHubWebClient client;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("tasklet2!!");
        return RepeatStatus.FINISHED;
    }
}
