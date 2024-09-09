package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TaskUrlsModel {
    private String implement;
    private long nextTime;
    private long randomTime;
    private String url;

    public String getImplement() {
        return this.implement;
    }

    public long getNextTime() {
        return this.nextTime;
    }

    public long getRandomTime() {
        return this.randomTime;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImplement(String str) {
        this.implement = str;
    }

    public void setNextTime(long j4) {
        this.nextTime = j4;
    }

    public void setRandomTime(long j4) {
        this.randomTime = j4;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "{\"implement\":\"" + this.implement + "\", \"url\":\"" + this.url + "\", \"nextTime\":" + this.nextTime + ", \"randomTime\":" + this.randomTime + '}';
    }
}
