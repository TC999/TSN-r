package xyz.adscope.ad.model.http.response.config;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StatisticsModel {
    private CrashModel carsh;
    private List<EventModel> event;
    private List<TaskModel> task;

    public CrashModel getCarsh() {
        return this.carsh;
    }

    public List<EventModel> getEvent() {
        return this.event;
    }

    public List<TaskModel> getTask() {
        return this.task;
    }

    public void setCarsh(CrashModel crashModel) {
        this.carsh = crashModel;
    }

    public void setEvent(List<EventModel> list) {
        this.event = list;
    }

    public void setTask(List<TaskModel> list) {
        this.task = list;
    }

    public String toString() {
        return "{\"event\":" + this.event + ", \"task\":" + this.task + ", \"carsh\":" + this.carsh + '}';
    }
}
