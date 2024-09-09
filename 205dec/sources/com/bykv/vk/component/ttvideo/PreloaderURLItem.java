package com.bykv.vk.component.ttvideo;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class PreloaderURLItem {

    /* renamed from: a  reason: collision with root package name */
    private String f24812a;

    /* renamed from: b  reason: collision with root package name */
    private String f24813b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24814c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24815d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f24816e;

    /* renamed from: f  reason: collision with root package name */
    private IPreLoaderItemCallBackListener f24817f;

    public PreloaderURLItem(String str, String str2, long j4, String[] strArr) {
        this.f24813b = null;
        this.f24817f = null;
        this.f24812a = str;
        this.f24814c = str2;
        this.f24815d = j4;
        this.f24816e = strArr;
    }

    public PreloaderURLItem(String str, String str2, long j4, String[] strArr, String str3) {
        this.f24817f = null;
        this.f24812a = str;
        this.f24813b = str3;
        this.f24814c = str2;
        this.f24815d = j4;
        this.f24816e = strArr;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.f24817f;
    }

    public String getFilePath() {
        return this.f24813b;
    }

    public String getKey() {
        return this.f24812a;
    }

    public long getPreloadSize() {
        return this.f24815d;
    }

    public String[] getUrls() {
        return this.f24816e;
    }

    public String getVideoId() {
        return this.f24814c;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
        this.f24817f = iPreLoaderItemCallBackListener;
    }

    public void setKey(String str) {
        this.f24812a = str;
    }
}
