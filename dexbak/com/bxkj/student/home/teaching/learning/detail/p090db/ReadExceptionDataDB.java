package com.bxkj.student.home.teaching.learning.detail.p090db;

/* renamed from: com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ReadExceptionDataDB {
    private int alertCount;
    private long countTime;
    private String createTime;
    private String detailId;

    /* renamed from: id */
    private int f17398id;
    private long startTime;
    private String userId;

    public int getAlertCount() {
        return this.alertCount;
    }

    public long getCountTime() {
        return this.countTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDetailId() {
        return this.detailId;
    }

    public int getId() {
        return this.f17398id;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }

    public void setCountTime(long countTime) {
        this.countTime = countTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public void setId(int id) {
        this.f17398id = id;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString() {
        return "ReadExceptionDataDB{id=" + this.f17398id + ", createTime='" + this.createTime + "', userId='" + this.userId + "', detailId='" + this.detailId + "', countTime=" + this.countTime + ", startTime=" + this.startTime + ", alertCount=" + this.alertCount + '}';
    }
}
