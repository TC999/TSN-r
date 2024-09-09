package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003l.da;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthTask.java */
/* renamed from: com.amap.api.col.3l.ca  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ca extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f7330a;

    /* renamed from: b  reason: collision with root package name */
    WeakReference<IAMapDelegate> f7331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthTask.java */
    /* renamed from: com.amap.api.col.3l.ca$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7333b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f7334c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7335d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f7336e;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f7337g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f7338h;

        a(String str, String str2, boolean z3, String str3, String str4, String str5, String str6) {
            this.f7332a = str;
            this.f7333b = str2;
            this.f7334c = z3;
            this.f7335d = str3;
            this.f7336e = str4;
            this.f7337g = str5;
            this.f7338h = str6;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            if (!TextUtils.isEmpty(this.f7332a) && !TextUtils.isEmpty(this.f7333b)) {
                boolean z3 = this.f7334c;
                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                String str2 = this.f7333b;
                String str3 = this.f7332a;
                String str4 = this.f7335d;
                if (z3) {
                    da.d dVar = new da.d(str2, str3, str4, str);
                    dVar.g("amap_web_logo", "md5_day");
                    Context context = ca.this.f7330a;
                    a3.s();
                    new da(context, dVar).a();
                }
                WeakReference<IAMapDelegate> weakReference = ca.this.f7331b;
                if (weakReference != null && weakReference.get() != null) {
                    ca.this.f7331b.get().changeLogoIconStyle(str, z3, 0);
                }
            }
            if (TextUtils.isEmpty(this.f7336e) || TextUtils.isEmpty(this.f7337g)) {
                return;
            }
            boolean z4 = this.f7334c;
            String str5 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
            String str6 = this.f7337g;
            String str7 = this.f7336e;
            String str8 = this.f7338h;
            if (z4) {
                da.d dVar2 = new da.d(str6, str7, str8, str5);
                dVar2.g("amap_web_logo", "md5_night");
                Context context2 = ca.this.f7330a;
                a3.s();
                new da(context2, dVar2).a();
            }
            WeakReference<IAMapDelegate> weakReference2 = ca.this.f7331b;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            ca.this.f7331b.get().changeLogoIconStyle(str5, z4, 1);
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class b extends f2 {

        /* renamed from: i  reason: collision with root package name */
        private final a f7340i;

        b(a aVar) {
            this.f7340i = aVar;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            a aVar = this.f7340i;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        protected String f7341a;

        /* renamed from: b  reason: collision with root package name */
        protected String f7342b;

        public c(String str, String str2) {
            this.f7341a = str;
            this.f7342b = str2;
        }

        public final String a() {
            return this.f7341a;
        }

        public final String b() {
            return this.f7342b;
        }

        public final boolean c() {
            return (TextUtils.isEmpty(this.f7341a) || TextUtils.isEmpty(this.f7342b)) ? false : true;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$d */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public final void g(String str, String str2) {
            b(new c(str, str2));
        }
    }

    public ca(Context context, IAMapDelegate iAMapDelegate) {
        this.f7331b = null;
        this.f7330a = context;
        this.f7331b = new WeakReference<>(iAMapDelegate);
    }

    private Pair<JSONObject, g4.c.a> b(StringBuilder sb) {
        String str;
        JSONObject jSONObject;
        g4.c.a aVar;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long longValue = q2.a(this.f7330a, "cloud_config_pull", "cloud_config_pull_timestamp", 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb.toString();
                str.replaceAll(";;", ";");
                q2.c(this.f7330a, "cloud_config_pull", "cloud_config_pull_timestamp", new Long(currentTimeMillis));
            } else {
                str = "";
            }
            g4.c c4 = g4.c(this.f7330a, a3.s(), str, null);
            if (g4.f7809a != 1 && str != "" && c4 != null && (weakReference = this.f7331b) != null && weakReference.get() != null) {
                Message obtainMessage = this.f7331b.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                String str2 = c4.f7841c;
                if (str2 != null) {
                    obtainMessage.obj = str2;
                }
                this.f7331b.get().getMainHandler().sendMessage(obtainMessage);
            }
            String str3 = GLFileUtil.getCacheDir(this.f7330a).getAbsolutePath() + "/authCustomConfigName";
            if (!TextUtils.isEmpty(str) && c4 != null && (jSONObject = c4.f7844f) != null) {
                GLFileUtil.writeDatasToFile(str3, jSONObject.toString().getBytes());
            } else {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str3)));
            }
            String str4 = GLFileUtil.getCacheDir(this.f7330a).getAbsolutePath() + "/authLogConfigName";
            if (!TextUtils.isEmpty(str) && c4 != null && c4.f7845g != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("IsExceptionUpdate", c4.f7845g.f7848a);
                jSONObject2.put("mOfflineLoc", c4.f7845g.f7850c);
                GLFileUtil.writeDatasToFile(str4, jSONObject2.toString().getBytes());
                aVar = c4.f7845g;
            } else {
                byte[] readFileContents = GLFileUtil.readFileContents(str4);
                g4.c.a aVar2 = new g4.c.a();
                JSONObject jSONObject3 = new JSONObject(new String(readFileContents));
                aVar2.f7848a = jSONObject3.getBoolean("IsExceptionUpdate");
                if (jSONObject3.has("mOfflineLoc")) {
                    aVar2.f7850c = jSONObject3.getJSONObject("mOfflineLoc");
                }
                aVar = aVar2;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void c(Context context, p4 p4Var, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16V");
            boolean x3 = g4.x(optJSONObject.optString("di", ""), false);
            String optString = optJSONObject.optString("dis", "");
            boolean x4 = g4.x(optJSONObject.optString("able", ""), false);
            boolean x5 = g4.x(optJSONObject.optString("isFilter", ""), true);
            if (!x3 || q4.B(optString)) {
                w5.a(p4Var).b(context, x4, x5);
            }
        } catch (Throwable unused) {
        }
    }

    private void d(g4.c.a aVar) {
        if (aVar != null) {
            try {
                w2.a(this.f7330a, "maploc", "ue", Boolean.valueOf(aVar.f7848a));
                JSONObject jSONObject = aVar.f7850c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                f7.b(optInt, g4.x(jSONObject.optString("igu"), false));
                w2.a(this.f7330a, "maploc", "opn", Integer.valueOf(optInt2));
            } catch (Throwable th) {
                u5.p(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    private static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            c3.j(jSONObject.optJSONObject("17E"));
        } catch (Throwable unused) {
        }
    }

    private void f(JSONObject jSONObject) {
        IAMapDelegate iAMapDelegate;
        IAMapDelegate iAMapDelegate2;
        IAMapDelegate iAMapDelegate3;
        if (jSONObject == null) {
            return;
        }
        try {
            ga.a().b(jSONObject.optJSONObject("1A1"));
            if (!ga.a().c("feature_terrain") && (iAMapDelegate3 = this.f7331b.get()) != null) {
                iAMapDelegate3.setTerrainAuth(false);
                a3.D(new AMapException("\u5730\u5f62\u56fe\u529f\u80fd\u4e3a\u8ba1\u8d39\u80fd\u529b\uff0c\u8bf7\u8054\u7cfb\u5546\u52a1\u8fdb\u884c\u529f\u80fd\u5f00\u901a\u3002"));
            }
            if (!ga.a().c("feature_gltf") && (iAMapDelegate2 = this.f7331b.get()) != null) {
                IGlOverlayLayer glOverlayLayer = iAMapDelegate2.getGlOverlayLayer();
                if (glOverlayLayer != null) {
                    glOverlayLayer.clearOverlayByType("GLTFOVERLAY");
                }
                a3.D(new AMapException("GLTF\u529f\u80fd\u4e0d\u652f\u6301"));
            }
            if (ga.a().c("feature_mvt") || (iAMapDelegate = this.f7331b.get()) == null) {
                return;
            }
            IGlOverlayLayer glOverlayLayer2 = iAMapDelegate.getGlOverlayLayer();
            if (glOverlayLayer2 != null) {
                glOverlayLayer2.clearOverlayByType("MVTTILEOVERLAY");
            }
            a3.D(new AMapException("MVT\u529f\u80fd\u4e0d\u652f\u6301"));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean x3 = g4.x(optJSONObject.optString("able", ""), false);
            boolean x4 = g4.x(optJSONObject.optString("removeCache", ""), false);
            boolean x5 = g4.x(optJSONObject.optString("uploadInfo", ""), false);
            r2.a(x3);
            r2.d(x4);
            r2.f(x5);
        } catch (Throwable unused) {
        }
    }

    private void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            q2.c(this.f7330a, "amap_param", "overlay_use_old_type", Boolean.valueOf(g4.x(jSONObject.optJSONObject("17W").optString("able", ""), false) ? false : true));
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f8 A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020b A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027b A[Catch: all -> 0x02c7, TRY_ENTER, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0286 A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0291 A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x029c A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02b5 A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0254 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a4 A[Catch: all -> 0x02c7, TRY_LEAVE, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01df A[Catch: all -> 0x02c7, TryCatch #1 {all -> 0x02c7, blocks: (B:3:0x0018, B:6:0x001f, B:19:0x00c6, B:22:0x00cf, B:24:0x00d3, B:26:0x00db, B:28:0x00e5, B:31:0x00f9, B:32:0x00fe, B:34:0x0104, B:35:0x0109, B:37:0x010f, B:39:0x0116, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:76:0x01a4, B:95:0x01df, B:97:0x01e3, B:99:0x01eb, B:101:0x01f8, B:103:0x01fc, B:105:0x020b, B:107:0x020f, B:109:0x0217, B:123:0x027b, B:125:0x027f, B:127:0x0286, B:129:0x028a, B:131:0x0291, B:133:0x0295, B:135:0x029c, B:137:0x02a0, B:138:0x02a5, B:140:0x02b5, B:142:0x02bb, B:72:0x019c, B:78:0x01a8, B:80:0x01b0, B:82:0x01b6, B:84:0x01c2, B:86:0x01c8, B:90:0x01d5), top: B:148:0x0018 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ca.run():void");
    }
}
