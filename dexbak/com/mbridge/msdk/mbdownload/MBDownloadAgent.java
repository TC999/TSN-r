package com.mbridge.msdk.mbdownload;

import com.mbridge.msdk.DomainMBridgeConstans;

/* renamed from: com.mbridge.msdk.mbdownload.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBDownloadAgent extends DownloadAgent {
    public MBDownloadAgent(String str, String str2) {
        super(str, "mb", str2);
        if (DomainMBridgeConstans.RICH_NOTIFICATION) {
            setRichNotification(true);
        } else {
            setRichNotification(false);
        }
        if (DomainMBridgeConstans.SLIENT_DOWNLOAD) {
            setSilentDownload(true);
        } else {
            setSilentDownload(false);
        }
        setDownloadClz("com.mbridge.msdk.shell.MBService");
    }

    public MBDownloadAgent(String str, String str2, String str3, boolean z) {
        super(str, str2, str3);
        setRichNotification(z);
        setDownloadClz("com.mbridge.msdk.shell.MBService");
    }
}
