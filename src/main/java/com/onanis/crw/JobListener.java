package com.onanis.crw;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobListener extends JobExecutionListenerSupport{
    @Override
    public void beforeJob(JobExecution jobExecution) {
        super.beforeJob(jobExecution);
        System.out.print("ジョブ開始 : " + jobExecution.getJobConfigurationName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        super.afterJob(jobExecution);
        System.out.print("ジョブ終了 : " + jobExecution.getJobConfigurationName());
    }
}
