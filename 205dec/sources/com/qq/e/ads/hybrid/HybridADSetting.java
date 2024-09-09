package com.qq.e.ads.hybrid;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: f  reason: collision with root package name */
    private String f41502f;

    /* renamed from: g  reason: collision with root package name */
    private String f41503g;

    /* renamed from: h  reason: collision with root package name */
    private String f41504h;

    /* renamed from: a  reason: collision with root package name */
    private int f41497a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f41498b = 44;

    /* renamed from: c  reason: collision with root package name */
    private int f41499c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f41500d = -14013133;

    /* renamed from: e  reason: collision with root package name */
    private int f41501e = 16;

    /* renamed from: i  reason: collision with root package name */
    private int f41505i = -1776153;

    /* renamed from: j  reason: collision with root package name */
    private int f41506j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f41503g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i4) {
        this.f41506j = i4;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f41504h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f41503g;
    }

    public int getBackSeparatorLength() {
        return this.f41506j;
    }

    public String getCloseButtonImage() {
        return this.f41504h;
    }

    public int getSeparatorColor() {
        return this.f41505i;
    }

    public String getTitle() {
        return this.f41502f;
    }

    public int getTitleBarColor() {
        return this.f41499c;
    }

    public int getTitleBarHeight() {
        return this.f41498b;
    }

    public int getTitleColor() {
        return this.f41500d;
    }

    public int getTitleSize() {
        return this.f41501e;
    }

    public int getType() {
        return this.f41497a;
    }

    public HybridADSetting separatorColor(int i4) {
        this.f41505i = i4;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f41502f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i4) {
        this.f41499c = i4;
        return this;
    }

    public HybridADSetting titleBarHeight(int i4) {
        this.f41498b = i4;
        return this;
    }

    public HybridADSetting titleColor(int i4) {
        this.f41500d = i4;
        return this;
    }

    public HybridADSetting titleSize(int i4) {
        this.f41501e = i4;
        return this;
    }

    public HybridADSetting type(int i4) {
        this.f41497a = i4;
        return this;
    }
}
