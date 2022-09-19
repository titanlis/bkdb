package ru.itm.bkdb.config;


public class SystemConfig {
    private static boolean needStop = false;    //не пора ли остановить сервис?

    public static boolean isNeedStop() {
        return needStop;
    }

    public static void setNeedStop(boolean needStop) {
        SystemConfig.needStop = needStop;
    }
}
