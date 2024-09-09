package xyz.adscope.amps.model.config.response;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FrequencyModel {
    private int count;
    private String event = "";
    private long time;

    public int getCount() {
        return this.count;
    }

    public String getEvent() {
        return this.event;
    }

    public long getTime() {
        return this.time;
    }

    public void setCount(int i4) {
        this.count = i4;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public String toString() {
        return "{\"time\":" + this.time + ", \"event\":\"" + this.event + "\", \"count\":" + this.count + '}';
    }
}
