package com.mbridge.msdk.foundation.same.net.g;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.CustomInfoManager;
import com.stub.StubApp;
import java.io.File;
import org.json.JSONArray;

/* compiled from: CommonAsyncHttpRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f39591b = "b";

    /* renamed from: a  reason: collision with root package name */
    protected Context f39592a;

    public b(Context context) {
        if (context == null) {
            this.f39592a = com.mbridge.msdk.foundation.controller.a.f().j();
        } else {
            this.f39592a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private void d(int i4, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        String str2 = dVar.b().get("sign");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a("ts", currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        a(i4, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar);
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            String a4 = Aa.a();
            if (a4 == null) {
                a4 = "";
            }
            dVar.a("channel", a4);
            dVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().e() + "");
            dVar.a("open", com.mbridge.msdk.foundation.same.a.C);
            String str2 = f39591b;
            x.a(str2, "excute addExtraParams , url:" + str);
            if (!TextUtils.isEmpty(str) && str.contains("setting")) {
                String b4 = Aa.b();
                if (!TextUtils.isEmpty(b4)) {
                    dVar.a("keyword", b4);
                }
            }
            String str3 = dVar.b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (str3 != null) {
                String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str3, str);
                if (!TextUtils.isEmpty(customInfoByUnitId)) {
                    dVar.a("ch_info", customInfoByUnitId);
                }
                com.mbridge.msdk.c.d e4 = com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), str3);
                if (e4 != null && !TextUtils.isEmpty(e4.a())) {
                    dVar.a("u_stid", e4.a());
                }
            }
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                return;
            }
            dVar.a("dev_source", "2");
            return;
        }
        x.d(f39591b, "addExtraParams error, params is null,frame work error");
    }

    public final void b(int i4, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        a(i4, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, true);
    }

    public final void c(int i4, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        a(i4, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r14, java.lang.String r15, com.mbridge.msdk.foundation.same.net.g.d r16, com.mbridge.msdk.foundation.same.net.l r17, com.mbridge.msdk.foundation.same.net.e r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.g.b.b(int, java.lang.String, com.mbridge.msdk.foundation.same.net.g.d, com.mbridge.msdk.foundation.same.net.l, com.mbridge.msdk.foundation.same.net.e, boolean):void");
    }

    public final void a(int i4, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        b(i4, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false);
    }

    public final void a(int i4, String str, d dVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar, boolean z3) {
        b(i4, str, dVar, lVar, eVar, z3);
    }

    public static void a(File file, String str, com.mbridge.msdk.foundation.same.net.e eVar) {
        String str2 = f39591b;
        x.b(str2, "downloadFile url = " + str);
        n.a().a(file, str, eVar);
    }

    public final void a(int i4, d dVar, com.mbridge.msdk.foundation.same.net.e eVar, String str) {
        a(i4, dVar, eVar, str, new com.mbridge.msdk.foundation.same.net.b());
    }

    public final void a(int i4, d dVar, com.mbridge.msdk.foundation.same.net.e eVar, String str, l lVar) {
        int aY;
        com.mbridge.msdk.c.a g4 = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
        if (TextUtils.isEmpty(str)) {
            aY = g4.aZ();
        } else {
            aY = g4.aY();
        }
        String a4 = com.mbridge.msdk.foundation.same.net.f.d.a().a(str, aY);
        if (aY < 2) {
            if (lVar == null) {
                d(i4, a4, dVar, eVar);
                return;
            } else {
                a(i4, a4, dVar, eVar, lVar);
                return;
            }
        }
        if (aY % 2 == 0) {
            if (dVar == null) {
                dVar = new d();
            }
            JSONArray b4 = com.mbridge.msdk.foundation.db.a.a.a().b();
            if (b4 != null) {
                String jSONArray = b4.toString();
                int b5 = com.mbridge.msdk.foundation.same.net.f.d.a().b();
                if (b5 > 0 && jSONArray.length() > b5) {
                    c(i4, a4, dVar, eVar);
                    return;
                }
                dVar.a(d.f39598e, jSONArray);
            }
        }
        d dVar2 = dVar;
        if (lVar == null) {
            b(i4, a4, dVar2, eVar);
        } else {
            a(i4, a4, dVar2, lVar, eVar, true);
        }
    }

    private void a(int i4, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar, l lVar) {
        String str2 = dVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a("ts", currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        if (lVar != null) {
            a(i4, str, dVar, lVar, eVar);
        } else {
            a(i4, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[Catch: Exception -> 0x00dc, TRY_ENTER, TryCatch #3 {Exception -> 0x00dc, blocks: (B:34:0x00b0, B:36:0x00b6, B:41:0x00c1, B:46:0x00e0), top: B:75:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r15, java.lang.String r16, com.mbridge.msdk.foundation.same.net.g.d r17, com.mbridge.msdk.foundation.same.net.l r18, com.mbridge.msdk.foundation.same.net.e r19) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.g.b.a(int, java.lang.String, com.mbridge.msdk.foundation.same.net.g.d, com.mbridge.msdk.foundation.same.net.l, com.mbridge.msdk.foundation.same.net.e):void");
    }
}
