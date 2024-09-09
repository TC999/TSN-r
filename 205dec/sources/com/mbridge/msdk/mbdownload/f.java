package com.mbridge.msdk.mbdownload;

/* compiled from: MBDownloadAgent.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f extends b {
    public f(String str, String str2) {
        super(str, "mb", str2);
        if (com.mbridge.msdk.a.RICH_NOTIFICATION) {
            setRichNotification(true);
        } else {
            setRichNotification(false);
        }
        if (com.mbridge.msdk.a.SLIENT_DOWNLOAD) {
            setSilentDownload(true);
        } else {
            setSilentDownload(false);
        }
        setDownloadClz("com.mbridge.msdk.shell.MBService");
    }

    public f(String str, String str2, String str3, boolean z3) {
        super(str, str2, str3);
        setRichNotification(z3);
        setDownloadClz("com.mbridge.msdk.shell.MBService");
    }
}
