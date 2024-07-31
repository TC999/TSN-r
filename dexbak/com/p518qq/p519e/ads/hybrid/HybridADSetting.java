package com.p518qq.p519e.ads.hybrid;

/* renamed from: com.qq.e.ads.hybrid.HybridADSetting */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: f */
    private String f32787f;

    /* renamed from: g */
    private String f32788g;

    /* renamed from: h */
    private String f32789h;

    /* renamed from: a */
    private int f32782a = 1;

    /* renamed from: b */
    private int f32783b = 44;

    /* renamed from: c */
    private int f32784c = -1;

    /* renamed from: d */
    private int f32785d = -14013133;

    /* renamed from: e */
    private int f32786e = 16;

    /* renamed from: i */
    private int f32790i = -1776153;

    /* renamed from: j */
    private int f32791j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f32788g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.f32791j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f32789h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f32788g;
    }

    public int getBackSeparatorLength() {
        return this.f32791j;
    }

    public String getCloseButtonImage() {
        return this.f32789h;
    }

    public int getSeparatorColor() {
        return this.f32790i;
    }

    public String getTitle() {
        return this.f32787f;
    }

    public int getTitleBarColor() {
        return this.f32784c;
    }

    public int getTitleBarHeight() {
        return this.f32783b;
    }

    public int getTitleColor() {
        return this.f32785d;
    }

    public int getTitleSize() {
        return this.f32786e;
    }

    public int getType() {
        return this.f32782a;
    }

    public HybridADSetting separatorColor(int i) {
        this.f32790i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f32787f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f32784c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f32783b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.f32785d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.f32786e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f32782a = i;
        return this;
    }
}
