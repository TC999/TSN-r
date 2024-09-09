package com.acse.ottn.model;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class AdInfoModel implements Serializable {
    private String adId;
    private String adType;
    private int countdown;
    private String deeplink;
    private String img;
    private String link;
    private String mediaType;
    private String packageName;

    /* renamed from: r  reason: collision with root package name */
    private int f5980r;
    private boolean showPermissionDialog;
    private String showDisLike = "0";
    private String showBigClose = "0";

    public String getAdId() {
        return this.adId;
    }

    public String getAdType() {
        return this.adType;
    }

    public int getCountdown() {
        return this.countdown;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getImg() {
        return this.img;
    }

    public String getLink() {
        return this.link;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getR() {
        return this.f5980r;
    }

    public String getShowBigClose() {
        return this.showBigClose;
    }

    public String getShowDisLike() {
        return this.showDisLike;
    }

    public boolean isShowPermissionDialog() {
        return this.showPermissionDialog;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setCountdown(int i4) {
        this.countdown = i4;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setR(int i4) {
        this.f5980r = i4;
    }

    public void setShowBigClose(String str) {
        this.showBigClose = str;
    }

    public void setShowDisLike(String str) {
        this.showDisLike = str;
    }

    public void setShowPermissionDialog(boolean z3) {
        this.showPermissionDialog = z3;
    }

    public String toString() {
        return "AdInfoModel{r=" + this.f5980r + ", adType='" + this.adType + "', adId='" + this.adId + "', mediaType='" + this.mediaType + "', showPermissionDialog=" + this.showPermissionDialog + ", img='" + this.img + "', delink='" + this.deeplink + "', link='" + this.link + "'}";
    }
}
