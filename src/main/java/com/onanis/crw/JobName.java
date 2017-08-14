package com.onanis.crw;

public enum JobName {
    PORNHUB(Constants.PORNHUB), AVGLE(Constants.AVGLE);

    JobName(String jobName){
        
    }

    public static class Constants{
        public static final String PORNHUB = "PORNHUB";
        public static final String AVGLE = "AVGLE";
    }
}
