package com.bytedance.android.live.base.api.push.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PushUIConfig {
    public static final long dismissTime = 5000;
    private Integer horizontalMargin = null;
    private Integer topMargin = null;
    private Integer textColor = null;
    private Integer liveColor = null;
    private Float borderRadiusWidth = null;
    private Integer bgColor = null;

    public Integer getBgColor() {
        return this.bgColor;
    }

    public Float getBorderRadiusWidth() {
        return this.borderRadiusWidth;
    }

    public Integer getHorizontalMargin() {
        return this.horizontalMargin;
    }

    public Integer getLiveColor() {
        return this.liveColor;
    }

    public Integer getTextColor() {
        return this.textColor;
    }

    public Integer getTopMargin() {
        return this.topMargin;
    }

    public void setBgColor(Integer num) {
        this.bgColor = num;
    }

    public void setBorderRadiusWidth(Float f4) {
        this.borderRadiusWidth = f4;
    }

    public void setHorizontalMargin(Integer num) {
        this.horizontalMargin = num;
    }

    public void setLiveColor(Integer num) {
        this.liveColor = num;
    }

    public void setTextColor(Integer num) {
        this.textColor = num;
    }

    public void setTopMargin(Integer num) {
        this.topMargin = num;
    }
}
