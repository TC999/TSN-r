package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.C2573a;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ExpressAdData {
    private String adPlaceId;
    private String desc;
    private String iconUrl;
    private String imageUrl;
    private List<String> multiPicUrls;

    /* renamed from: pk */
    private String f8440pk;
    private String title;
    private String videoUrl;

    public ExpressAdData(C2573a c2573a, String str) {
        this.title = "";
        this.desc = "";
        this.iconUrl = "";
        this.f8440pk = "";
        this.imageUrl = "";
        this.videoUrl = "";
        this.multiPicUrls = null;
        this.adPlaceId = str;
        this.title = c2573a.m51107a();
        this.desc = c2573a.m51101b();
        this.iconUrl = c2573a.m51100c();
        this.f8440pk = c2573a.m51090m();
        this.imageUrl = c2573a.m51099d();
        this.videoUrl = c2573a.m51089n();
        this.multiPicUrls = c2573a.m51123G();
    }

    public String getAdPlaceId() {
        return this.adPlaceId;
    }

    public String getAppPackage() {
        return this.f8440pk;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<String> getMultiPicUrls() {
        return this.multiPicUrls;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }
}
