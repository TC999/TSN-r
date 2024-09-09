package com.mbridge.msdk.widget.custom;

/* compiled from: CustomViewRenderListener.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface a {

    /* compiled from: CustomViewRenderListener.java */
    /* renamed from: com.mbridge.msdk.widget.custom.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum EnumC0769a {
        CLICK_EVENT_OPEN_PRIVACY,
        CLICK_EVENT_DOWNLOAD,
        CLICK_EVENT_CLOSE
    }

    void a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap);

    void a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap, EnumC0769a enumC0769a);

    void a(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap, Exception exc);

    void b(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap);

    void c(DownloadMessageDialog downloadMessageDialog, CustomViewMessageWrap customViewMessageWrap);
}
