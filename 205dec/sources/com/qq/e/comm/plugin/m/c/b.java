package com.qq.e.comm.plugin.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends a {

    /* renamed from: e  reason: collision with root package name */
    private static long f44645e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static long f44646f = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f44647b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f44648c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f44649d;

    private String e(Context context) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 0, this, context);
    }

    @Override // com.qq.e.comm.plugin.m.a
    public String a(Context context) {
        if (GlobalSetting.isAgreePrivacyStrategy()) {
            if (TextUtils.isEmpty(this.f44644a)) {
                this.f44644a = c(context);
            }
            return this.f44644a;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.m.a
    public String b(Context context) {
        return a(context);
    }

    protected String c(Context context) {
        JSONObject d4 = d(context);
        if (d4 != null) {
            return d4.toString();
        }
        return null;
    }

    public JSONObject d(Context context) {
        if (GlobalSetting.isAgreePrivacyStrategy()) {
            String str = this.f44647b;
            JSONObject jSONObject = this.f44648c;
            a(context, true);
            String str2 = this.f44647b;
            if (this.f44649d == null || ((!TextUtils.isEmpty(str) && !str.equals(this.f44647b)) || ((!TextUtils.isEmpty(str2) && !str2.equals(str)) || jSONObject != this.f44648c))) {
                this.f44649d = a();
            }
            return this.f44649d;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[Catch: all -> 0x00ad, TryCatch #1 {, blocks: (B:5:0x0006, B:7:0x0016, B:13:0x002a, B:15:0x003a, B:17:0x003e, B:20:0x0054, B:21:0x006a, B:25:0x0077, B:24:0x0072, B:26:0x0090, B:27:0x00a9, B:12:0x0028, B:9:0x001e), top: B:33:0x0006, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0006, B:7:0x0016, B:13:0x002a, B:15:0x003a, B:17:0x003e, B:20:0x0054, B:21:0x006a, B:25:0x0077, B:24:0x0072, B:26:0x0090, B:27:0x00a9, B:12:0x0028, B:9:0x001e), top: B:33:0x0006, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(android.content.Context r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 1
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L28
            com.qq.e.comm.plugin.d0.a r6 = com.qq.e.comm.plugin.d0.a.d()     // Catch: java.lang.Throwable -> Lad
            com.qq.e.comm.plugin.d0.d.h r6 = r6.f()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r3 = "bdon"
            int r6 = r6.a(r3, r2)     // Catch: java.lang.Throwable -> Lad
            if (r6 != r0) goto L28
            java.lang.String r6 = "bssid"
            boolean r6 = com.qq.e.comm.plugin.util.y.b(r6)     // Catch: java.lang.Throwable -> Lad
            if (r6 != 0) goto L28
            java.lang.String r5 = r4.e(r5)     // Catch: java.lang.Throwable -> L25
            r4.f44647b = r5     // Catch: java.lang.Throwable -> L25
            goto L2a
        L25:
            r4.f44647b = r1     // Catch: java.lang.Throwable -> Lad
            goto L2a
        L28:
            r4.f44647b = r1     // Catch: java.lang.Throwable -> Lad
        L2a:
            com.qq.e.comm.plugin.d0.a r5 = com.qq.e.comm.plugin.d0.a.d()     // Catch: java.lang.Throwable -> Lad
            com.qq.e.comm.plugin.d0.d.h r5 = r5.f()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = "udon"
            int r5 = r5.a(r6, r2)     // Catch: java.lang.Throwable -> Lad
            if (r5 != r0) goto La9
            org.json.JSONObject r5 = r4.f44648c     // Catch: java.lang.Throwable -> Lad
            if (r5 != 0) goto L90
            com.qq.e.comm.plugin.d0.a r5 = com.qq.e.comm.plugin.d0.a.d()     // Catch: java.lang.Throwable -> Lad
            com.qq.e.comm.plugin.d0.d.h r5 = r5.f()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = "ud_salt"
            java.lang.String r5 = r5.c(r6)     // Catch: java.lang.Throwable -> Lad
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto L54
            java.lang.String r5 = "[{\"v\":1,\"s\":\"CB6;8PHJtpsNJwTW\"}]"
        L54:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r6.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = "read uuid use salt:"
            r6.append(r0)     // Catch: java.lang.Throwable -> Lad
            r6.append(r5)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lad
            com.qq.e.comm.plugin.util.d1.a(r6, r0)     // Catch: java.lang.Throwable -> Lad
            org.json.JSONObject r5 = com.qq.e.comm.plugin.m.c.g.a(r5)     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> Lad
            r4.f44648c = r5     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> Lad
            goto L77
        L71:
            r5 = move-exception
            java.lang.String r6 = "read uuid error"
            com.qq.e.comm.plugin.util.d1.a(r6, r5)     // Catch: java.lang.Throwable -> Lad
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r5.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = "read uuid from file:"
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            org.json.JSONObject r6 = r4.f44648c     // Catch: java.lang.Throwable -> Lad
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lad
            com.qq.e.comm.plugin.util.d1.a(r5, r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        L90:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r5.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r6 = "read uuid from cached:"
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            org.json.JSONObject r6 = r4.f44648c     // Catch: java.lang.Throwable -> Lad
            r5.append(r6)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lad
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lad
            com.qq.e.comm.plugin.util.d1.a(r5, r6)     // Catch: java.lang.Throwable -> Lad
            goto Lab
        La9:
            r4.f44648c = r1     // Catch: java.lang.Throwable -> Lad
        Lab:
            monitor-exit(r4)
            return
        Lad:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.m.c.b.a(android.content.Context, boolean):void");
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f44647b)) {
                jSONObject.put("wm_h", this.f44647b);
            }
            if (this.f44648c != null && this.f44648c.length() > 0) {
                jSONObject.put("uuid", this.f44648c);
            }
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        JSONObject jSONObject2 = null;
        if (jSONObject.length() > 0) {
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("attri_info", jSONObject);
            } catch (JSONException e5) {
                d1.a(e5.getMessage(), e5);
            }
        }
        return jSONObject2;
    }
}
