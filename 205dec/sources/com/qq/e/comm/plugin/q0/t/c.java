package com.qq.e.comm.plugin.q0.t;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public enum c {
    ADLoadSucc,
    ADLoadFail,
    ADReady,
    Exposured,
    Clicked,
    PopupDisplay,
    PopupClosed,
    ADSpecMeasured,
    ADClosed,
    ADLeftApplication,
    ADOpenOverlay,
    ADCloseOverlay,
    DownloadClosed,
    ConfirmDialogOpened,
    ConfirmDialogClosed;

    public static c a(String str) {
        c[] values;
        for (c cVar : values()) {
            if (cVar.name().equals(str)) {
                return cVar;
            }
        }
        return null;
    }
}
