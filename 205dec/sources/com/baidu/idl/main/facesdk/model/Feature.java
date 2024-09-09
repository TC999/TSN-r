package com.baidu.idl.main.facesdk.model;

import android.util.Base64;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Feature {
    private long ctime;
    private byte[] feature;
    private int id;
    private boolean isChecked;
    private float score;
    private long updateTime;
    private String faceToken = "";
    private String userId = "";
    private String groupId = "";
    private String imageName = "";
    private String userName = "";
    private String cropImageName = "";

    public Feature() {
    }

    public String getCropImageName() {
        return this.cropImageName;
    }

    public long getCtime() {
        return this.ctime;
    }

    public String getFaceToken() {
        byte[] bArr = this.feature;
        if (bArr != null) {
            this.faceToken = new String(Base64.encode(bArr, 2));
        }
        return this.faceToken;
    }

    public byte[] getFeature() {
        return this.feature;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getId() {
        return this.id;
    }

    public String getImageName() {
        return this.imageName;
    }

    public float getScore() {
        return this.score;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z3) {
        this.isChecked = z3;
    }

    public void setCropImageName(String str) {
        this.cropImageName = str;
    }

    public void setCtime(long j4) {
        this.ctime = j4;
    }

    public void setFaceToken(String str) {
        this.faceToken = str;
    }

    public void setFeature(byte[] bArr) {
        this.feature = bArr;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setId(int i4) {
        this.id = i4;
    }

    public void setImageName(String str) {
        this.imageName = str;
    }

    public void setScore(float f4) {
        this.score = f4;
    }

    public void setUpdateTime(long j4) {
        this.updateTime = j4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public Feature(int i4, float f4) {
        this.id = i4;
        this.score = f4;
    }
}
