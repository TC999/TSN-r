package com.mbridge.msdk.foundation.same.p475b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.same.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MBridgeDirContext extends DirectoryContext {
    public MBridgeDirContext(String str) {
        super(str);
    }

    @Override // com.mbridge.msdk.foundation.same.p475b.DirectoryContext
    /* renamed from: b */
    protected final List<Directory> mo22353b() {
        ArrayList<Directory> arrayList = new ArrayList<>();
        m22354a(arrayList, MBridgeDir.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        m22354a(arrayList, MBridgeDir.AD_MOVIES, "mb/res/Movies").m22361a(MBridgeDir.MBRIDGE_VC, "mb/res/.MBridge_VC");
        Directory m22354a = m22354a(arrayList, MBridgeDir.AD_MBRIDGE_700, "mb/res/.mbridge700");
        m22354a.m22361a(MBridgeDir.MBRIDGE_700_IMG, "mb/res/img");
        m22354a.m22361a(MBridgeDir.MBRIDGE_700_RES, "mb/res/res");
        m22354a.m22361a(MBridgeDir.MBRIDGE_700_HTML, "mb/res/html");
        m22354a.m22361a(MBridgeDir.MBRIDGE_700_XML, "mb/res/xml");
        m22354a.m22361a(MBridgeDir.MBRIDGE_700_CONFIG, "mb/config");
        MBridgeDir mBridgeDir = MBridgeDir.MBRIDGE_OTHER;
        m22354a(arrayList, mBridgeDir, "mb/other").m22361a(MBridgeDir.MBRIDGE_700_APK, "mb/apk");
        m22354a(arrayList, MBridgeDir.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        m22354a(arrayList, mBridgeDir, "mb/other");
        return arrayList;
    }
}
