package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CPUDramaResponse {
    private String contentId;
    private String coverImageUrl;
    private int represent;
    private String subVideoId;
    private String title;

    public String getDramaContentId() {
        return this.contentId;
    }

    public String getDramaCoverImage() {
        return this.coverImageUrl;
    }

    public String getDramaSubVideoId() {
        return this.subVideoId;
    }

    public String getDramaTitle() {
        return this.title;
    }

    public int getRepresent() {
        return this.represent;
    }

    public CPUDramaResponse setContentId(String str) {
        this.contentId = str;
        return this;
    }

    public CPUDramaResponse setCoverImageUrl(String str) {
        this.coverImageUrl = str;
        return this;
    }

    public CPUDramaResponse setRepresent(int i4) {
        this.represent = i4;
        return this;
    }

    public CPUDramaResponse setSubVideoId(String str) {
        this.subVideoId = str;
        return this;
    }

    public CPUDramaResponse setTitle(String str) {
        this.title = str;
        return this;
    }
}
