package com.bytedance.sdk.openadsdk.core.s;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.sdk.openadsdk.bk.c {
    private com.bytedance.sdk.openadsdk.bk.sr a() {
        String f4 = com.bytedance.sdk.openadsdk.core.r.c.f();
        f4.hashCode();
        char c4 = '\uffff';
        switch (f4.hashCode()) {
            case 1653:
                if (f4.equals("2g")) {
                    c4 = 0;
                    break;
                }
                break;
            case 1684:
                if (f4.equals("3g")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1715:
                if (f4.equals("4g")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1746:
                if (f4.equals("5g")) {
                    c4 = 3;
                    break;
                }
                break;
            case 3649301:
                if (f4.equals("wifi")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return com.bytedance.sdk.openadsdk.bk.sr.TYPE_2G;
            case 1:
                return com.bytedance.sdk.openadsdk.bk.sr.TYPE_3G;
            case 2:
                return com.bytedance.sdk.openadsdk.bk.sr.TYPE_4G;
            case 3:
                return com.bytedance.sdk.openadsdk.bk.sr.TYPE_5G;
            case 4:
                return com.bytedance.sdk.openadsdk.bk.sr.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.bk.sr.TYPE_UNKNOWN;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bk.c
    public com.bytedance.sdk.openadsdk.bk.sr w() {
        return a();
    }
}
