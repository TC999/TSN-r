package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MBridgeDirContext.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends b {
    public d(String str) {
        super(str);
    }

    @Override // com.mbridge.msdk.foundation.same.b.b
    protected final List<a> b() {
        ArrayList<a> arrayList = new ArrayList<>();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a a4 = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        a4.a(c.MBRIDGE_700_IMG, "mb/res/img");
        a4.a(c.MBRIDGE_700_RES, "mb/res/res");
        a4.a(c.MBRIDGE_700_HTML, "mb/res/html");
        a4.a(c.MBRIDGE_700_XML, "mb/res/xml");
        a4.a(c.MBRIDGE_700_CONFIG, "mb/config");
        c cVar = c.MBRIDGE_OTHER;
        a(arrayList, cVar, "mb/other").a(c.MBRIDGE_700_APK, "mb/apk");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, cVar, "mb/other");
        return arrayList;
    }
}
