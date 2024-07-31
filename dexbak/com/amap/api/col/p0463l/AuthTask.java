package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.col.p0463l.AuthTaskDownload;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.ba */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AuthTask extends Thread {

    /* renamed from: a */
    private Context f3691a;

    /* renamed from: b */
    WeakReference<IAMapDelegate> f3692b;

    /* compiled from: AuthTask.java */
    /* renamed from: com.amap.api.col.3l.ba$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1753a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ String f3693a;

        /* renamed from: b */
        final /* synthetic */ String f3694b;

        /* renamed from: c */
        final /* synthetic */ boolean f3695c;

        /* renamed from: d */
        final /* synthetic */ String f3696d;

        /* renamed from: e */
        final /* synthetic */ String f3697e;

        /* renamed from: g */
        final /* synthetic */ String f3698g;

        /* renamed from: h */
        final /* synthetic */ String f3699h;

        C1753a(String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
            this.f3693a = str;
            this.f3694b = str2;
            this.f3695c = z;
            this.f3696d = str3;
            this.f3697e = str4;
            this.f3698g = str5;
            this.f3699h = str6;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            if (!TextUtils.isEmpty(this.f3693a) && !TextUtils.isEmpty(this.f3694b)) {
                boolean z = this.f3695c;
                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                String str2 = this.f3694b;
                String str3 = this.f3693a;
                String str4 = this.f3696d;
                if (z) {
                    AuthTaskDownload.C1761d c1761d = new AuthTaskDownload.C1761d(str2, str3, str4, str);
                    c1761d.m55426g("amap_web_logo", "md5_day");
                    Context context = AuthTask.this.f3691a;
                    C1732a3.m55691s();
                    new AuthTaskDownload(context, c1761d).m55437a();
                }
                WeakReference<IAMapDelegate> weakReference = AuthTask.this.f3692b;
                if (weakReference != null && weakReference.get() != null) {
                    AuthTask.this.f3692b.get().changeLogoIconStyle(str, z, 0);
                }
            }
            if (TextUtils.isEmpty(this.f3697e) || TextUtils.isEmpty(this.f3698g)) {
                return;
            }
            boolean z2 = this.f3695c;
            String str5 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
            String str6 = this.f3698g;
            String str7 = this.f3697e;
            String str8 = this.f3699h;
            if (z2) {
                AuthTaskDownload.C1761d c1761d2 = new AuthTaskDownload.C1761d(str6, str7, str8, str5);
                c1761d2.m55426g("amap_web_logo", "md5_night");
                Context context2 = AuthTask.this.f3691a;
                C1732a3.m55691s();
                new AuthTaskDownload(context2, c1761d2).m55437a();
            }
            WeakReference<IAMapDelegate> weakReference2 = AuthTask.this.f3692b;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            AuthTask.this.f3692b.get().changeLogoIconStyle(str5, z2, 1);
        }
    }

    public AuthTask(Context context, IAMapDelegate iAMapDelegate) {
        this.f3692b = null;
        this.f3691a = context;
        this.f3692b = new WeakReference<>(iAMapDelegate);
    }

    /* renamed from: b */
    private Pair<JSONObject, AuthConfigManager.C1801c.C1802a> m55535b(StringBuilder sb) {
        String str;
        JSONObject jSONObject;
        AuthConfigManager.C1801c.C1802a c1802a;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long longValue = PreferenceTools.m54148a(this.f3691a, "cloud_config_pull", "cloud_config_pull_timestamp", 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb.toString();
                str.replaceAll(";;", ";");
                PreferenceTools.m54146c(this.f3691a, "cloud_config_pull", "cloud_config_pull_timestamp", new Long(currentTimeMillis));
            } else {
                str = "";
            }
            AuthConfigManager.C1801c m55061c = AuthConfigManager.m55061c(this.f3691a, C1732a3.m55691s(), str, null);
            if (AuthConfigManager.f4097a != 1 && str != "" && m55061c != null && (weakReference = this.f3692b) != null && weakReference.get() != null) {
                Message obtainMessage = this.f3692b.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                String str2 = m55061c.f4129c;
                if (str2 != null) {
                    obtainMessage.obj = str2;
                }
                this.f3692b.get().getMainHandler().sendMessage(obtainMessage);
            }
            String str3 = GLFileUtil.getCacheDir(this.f3691a).getAbsolutePath() + "/authCustomConfigName";
            if (!TextUtils.isEmpty(str) && m55061c != null && (jSONObject = m55061c.f4132f) != null) {
                GLFileUtil.writeDatasToFile(str3, jSONObject.toString().getBytes());
            } else {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str3)));
            }
            String str4 = GLFileUtil.getCacheDir(this.f3691a).getAbsolutePath() + "/authLogConfigName";
            if (!TextUtils.isEmpty(str) && m55061c != null && m55061c.f4133g != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("IsExceptionUpdate", m55061c.f4133g.f4136a);
                jSONObject2.put("mOfflineLoc", m55061c.f4133g.f4138c);
                GLFileUtil.writeDatasToFile(str4, jSONObject2.toString().getBytes());
                c1802a = m55061c.f4133g;
            } else {
                byte[] readFileContents = GLFileUtil.readFileContents(str4);
                AuthConfigManager.C1801c.C1802a c1802a2 = new AuthConfigManager.C1801c.C1802a();
                JSONObject jSONObject3 = new JSONObject(new String(readFileContents));
                c1802a2.f4136a = jSONObject3.getBoolean("IsExceptionUpdate");
                if (jSONObject3.has("mOfflineLoc")) {
                    c1802a2.f4138c = jSONObject3.getJSONObject("mOfflineLoc");
                }
                c1802a = c1802a2;
            }
            return new Pair<>(jSONObject, c1802a);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static void m55534c(Context context, SDKInfo sDKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16V");
            boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("di", ""), false);
            String optString = optJSONObject.optString("dis", "");
            boolean m55040x2 = AuthConfigManager.m55040x(optJSONObject.optString("able", ""), false);
            boolean m55040x3 = AuthConfigManager.m55040x(optJSONObject.optString("isFilter", ""), true);
            if (!m55040x || C1925p4.m54209B(optString)) {
                CrashManager.m53654a(sDKInfo).m53653b(context, m55040x2, m55040x3);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private void m55533d(AuthConfigManager.C1801c.C1802a c1802a) {
        if (c1802a != null) {
            try {
                SpUtil.m53602a(this.f3691a, "maploc", "ue", Boolean.valueOf(c1802a.f4136a));
                JSONObject jSONObject = c1802a.f4138c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                OfflineLocManager.m55216b(optInt, AuthConfigManager.m55040x(jSONObject.optString("igu"), false));
                SpUtil.m53602a(this.f3691a, "maploc", "opn", Integer.valueOf(optInt2));
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    /* renamed from: e */
    private static void m55532e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            LinkLogManager.m55484j(jSONObject.optJSONObject("17E"));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    private void m55531f(JSONObject jSONObject) {
        IAMapDelegate iAMapDelegate;
        IAMapDelegate iAMapDelegate2;
        IAMapDelegate iAMapDelegate3;
        if (jSONObject == null) {
            return;
        }
        try {
            FeatureManager.m55016a().m55015b(jSONObject.optJSONObject("1A1"));
            if (!FeatureManager.m55016a().m55014c("feature_terrain") && (iAMapDelegate3 = this.f3692b.get()) != null) {
                iAMapDelegate3.setTerrainAuth(false);
                C1732a3.m55741D(new AMapException(AMapException.FEATURE_TERRAIN_NOT_SUPPORT));
            }
            if (!FeatureManager.m55016a().m55014c("feature_gltf") && (iAMapDelegate2 = this.f3692b.get()) != null) {
                IGlOverlayLayer glOverlayLayer = iAMapDelegate2.getGlOverlayLayer();
                if (glOverlayLayer != null) {
                    glOverlayLayer.clearOverlayByType("GLTFOVERLAY");
                }
                C1732a3.m55741D(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
            }
            if (FeatureManager.m55016a().m55014c("feature_mvt") || (iAMapDelegate = this.f3692b.get()) == null) {
                return;
            }
            IGlOverlayLayer glOverlayLayer2 = iAMapDelegate.getGlOverlayLayer();
            if (glOverlayLayer2 != null) {
                glOverlayLayer2.clearOverlayByType("MVTTILEOVERLAY");
            }
            C1732a3.m55741D(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private static void m55530g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean m55040x = AuthConfigManager.m55040x(optJSONObject.optString("able", ""), false);
            boolean m55040x2 = AuthConfigManager.m55040x(optJSONObject.optString("removeCache", ""), false);
            boolean m55040x3 = AuthConfigManager.m55040x(optJSONObject.optString("uploadInfo", ""), false);
            PureScreenCheckTool.m54072a(m55040x);
            PureScreenCheckTool.m54069d(m55040x2);
            PureScreenCheckTool.m54067f(m55040x3);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    private void m55529h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            PreferenceTools.m54146c(this.f3691a, "amap_param", "overlay_use_old_type", Boolean.valueOf(AuthConfigManager.m55040x(jSONObject.optJSONObject("17W").optString("able", ""), false) ? false : true));
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f6 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0209 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0279 A[Catch: all -> 0x02c5, TRY_ENTER, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0284 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028f A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x029a A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02b3 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a2 A[Catch: all -> 0x02c5, TRY_LEAVE, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01dd A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:6:0x001d, B:19:0x00c4, B:22:0x00cd, B:24:0x00d1, B:26:0x00d9, B:28:0x00e3, B:31:0x00f7, B:32:0x00fc, B:34:0x0102, B:35:0x0107, B:37:0x010d, B:39:0x0114, B:41:0x0118, B:43:0x011e, B:45:0x0129, B:76:0x01a2, B:95:0x01dd, B:97:0x01e1, B:99:0x01e9, B:101:0x01f6, B:103:0x01fa, B:105:0x0209, B:107:0x020d, B:109:0x0215, B:123:0x0279, B:125:0x027d, B:127:0x0284, B:129:0x0288, B:131:0x028f, B:133:0x0293, B:135:0x029a, B:137:0x029e, B:138:0x02a3, B:140:0x02b3, B:142:0x02b9, B:72:0x019a, B:78:0x01a6, B:80:0x01ae, B:82:0x01b4, B:84:0x01c0, B:86:0x01c6, B:90:0x01d3), top: B:148:0x0016 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 747
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AuthTask.run():void");
    }
}
