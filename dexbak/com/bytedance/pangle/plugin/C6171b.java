package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.bytedance.pangle.C6159i;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.C6164a;
import com.bytedance.pangle.log.C6165b;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p114a.C6058a;
import com.bytedance.pangle.p118c.C6073b;
import com.bytedance.pangle.p119d.C6080b;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p120e.C6096b;
import com.bytedance.pangle.p120e.C6102f;
import com.bytedance.pangle.p120e.C6106g;
import com.bytedance.pangle.p123g.C6139e;
import com.bytedance.pangle.res.p124a.C6204c;
import com.bytedance.pangle.util.C6249e;
import com.bytedance.pangle.util.C6251g;
import com.bytedance.pangle.util.C6252h;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.C6256l;
import com.bytedance.pangle.util.p127b.C6242b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bytedance.pangle.plugin.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6171b {

    /* renamed from: a */
    private static final C6159i f22084a = C6159i.m37090a();

    /* renamed from: com.bytedance.pangle.plugin.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6176a extends IOException {
        /* synthetic */ C6176a(String str, byte b) {
            this(str);
        }

        /* synthetic */ C6176a(String str, Throwable th, byte b) {
            this(str, th);
        }

        private C6176a(String str) {
            super(str);
        }

        private C6176a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m37065a(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            C6159i c6159i = f22084a;
            c6159i.m37089a(1000, 0, str, i, null);
            C6164a m37073a = C6164a.m37073a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            m37062a(C6073b.f21867e, C6073b.C6074a.f21901r, str, i, -1L, null);
            int m36862b = C6256l.m36869a().m36862b(str, i, "install");
            int m36862b2 = C6256l.m36869a().m36862b(str, i, "load");
            GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            int i2 = (m36862b > 3 || m36862b2 > 3) ? 0 : 0;
            SharedPreferences.Editor edit = C6256l.m36869a().f22242a.edit();
            edit.putInt("remove_entry_flag_" + str + "_" + i, i2);
            edit.apply();
            C6256l.m36869a().m36860c(str, i, false);
            C6251g.m36896a(C6081c.m37231a(str, i));
            C6058a.m37275a(new C6058a.InterfaceC6060a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.p114a.C6058a.InterfaceC6060a
                /* renamed from: a */
                public final void mo37040a() {
                    C6171b.m37064a(file, str, i, stringBuffer);
                }
            }, new C6058a.InterfaceC6060a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.p114a.C6058a.InterfaceC6060a
                /* renamed from: a */
                public final void mo37040a() {
                    final Map m37054f = C6171b.m37054f(file, str, i, stringBuffer);
                    C6171b.m37057c(file, str, i, stringBuffer);
                    C6171b.m37059a(C6171b.m37053g(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (!C6253i.m36882f() && !C6253i.m36886b()) {
                        C6171b.m37061a(str, i, m37054f, stringBuffer);
                        zArr[0] = C6171b.m37060a(str, i, false, stringBuffer);
                        C6171b.m37063a(str, i);
                        return;
                    }
                    final boolean[] zArr2 = {false};
                    C6058a.m37275a(new C6058a.InterfaceC6060a() { // from class: com.bytedance.pangle.plugin.b.2.1
                        @Override // com.bytedance.pangle.p114a.C6058a.InterfaceC6060a
                        /* renamed from: a */
                        public final void mo37040a() {
                            C61732 c61732 = C61732.this;
                            C6171b.m37061a(str, i, m37054f, stringBuffer);
                        }
                    }, new C6058a.InterfaceC6060a() { // from class: com.bytedance.pangle.plugin.b.2.2
                        @Override // com.bytedance.pangle.p114a.C6058a.InterfaceC6060a
                        /* renamed from: a */
                        public final void mo37040a() {
                            boolean[] zArr3 = zArr2;
                            C61732 c61732 = C61732.this;
                            zArr3[0] = C6171b.m37052h(file, str, i, stringBuffer);
                        }
                    });
                    zArr[0] = C6171b.m37060a(str, i, zArr2[0], stringBuffer);
                }
            });
            C6251g.m36899a(file);
            m37062a(C6073b.f21868f, C6073b.C6074a.f21902s, str, i, m37073a.m37075a(), stringBuffer.toString());
            m37073a.m37074a("success");
            c6159i.m37089a(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof C6176a) {
                ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                m37062a(C6073b.f21868f, C6073b.C6074a.f21903t, str, i, -1L, stringBuffer.toString());
                f22084a.m37089a(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                C6256l.m36869a().m36866a(str, i, "install");
            }
            return false;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m37057c(File file, String str, int i, StringBuffer stringBuffer) {
        String[] strArr;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr2 = packageArchiveInfo.requestedPermissions;
                if (strArr2 != null && strArr2.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.m37077w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new C6176a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
                        }
                    }
                }
            } catch (Exception e) {
                m37062a(C6073b.f21868f, C6073b.C6074a.f21905v, str, i, -1L, null);
                f22084a.m37089a(1100, -4, str, i, e);
                throw new C6176a("安装包权限校验失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static Map<String, List<ZipEntry>> m37054f(File file, String str, int i, StringBuffer stringBuffer) {
        if (GlobalParam.getInstance().checkMatchHostAbi()) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    C6249e<Boolean, Map<String, List<ZipEntry>>> m37247a = C6080b.m37247a(file);
                    boolean booleanValue = m37247a.f22233a.booleanValue();
                    Map<String, List<ZipEntry>> map = m37247a.f22234b;
                    if (booleanValue) {
                        return map;
                    }
                    throw new C6176a("插件包包含so不符合宿主ABI类型", (byte) 0);
                } catch (Exception e) {
                    m37062a(C6073b.f21868f, C6073b.C6074a.f21876A, str, i, -1L, null);
                    f22084a.m37089a(1100, -5, str, i, e);
                    throw new C6176a("插件包包含so不符合宿主ABI类型", e, (byte) 0);
                }
            } finally {
                stringBuffer.append("checkMatchHostAbi cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(";");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static String m37053g(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String m37228b = C6081c.m37228b(str, i);
        try {
            try {
                C6252h.m36889a(file.getAbsolutePath(), m37228b);
                return m37228b;
            } catch (Exception e) {
                m37062a(C6073b.f21868f, C6073b.C6074a.f21906w, str, i, -1L, null);
                f22084a.m37089a(1100, -6, str, i, e);
                throw new C6176a("安装包拷贝失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023b: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:72:0x023b */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023f: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:74:0x023f */
    /* renamed from: h */
    public static boolean m37052h(File file, String str, int i, StringBuffer stringBuffer) {
        String str2;
        String str3;
        String str4;
        ZipEntry zipEntry;
        String str5 = ".dex";
        String str6 = "classes";
        String str7 = ";";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                int i2 = 1;
                try {
                    if (C6253i.m36886b()) {
                        if (file.exists() && str != null) {
                            ZipFile zipFile = null;
                            try {
                                ZipFile zipFile2 = new ZipFile(file);
                                try {
                                    ArrayList arrayList = new ArrayList();
                                    File file2 = new File(C6081c.m37219i(str, i));
                                    C6106g.m37181a(file2);
                                    int i3 = 1;
                                    while (true) {
                                        StringBuilder sb = new StringBuilder(str6);
                                        Object obj = "";
                                        sb.append(i3 == i2 ? "" : Integer.valueOf(i3));
                                        sb.append(str5);
                                        ZipEntry entry = zipFile2.getEntry(sb.toString());
                                        if (entry != null) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(str6);
                                            String str8 = str7;
                                            if (i3 != 1) {
                                                try {
                                                    obj = Integer.valueOf(i3);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile2;
                                                    C6251g.m36894a(zipFile);
                                                    throw th;
                                                }
                                            }
                                            sb2.append(obj);
                                            sb2.append(str5);
                                            C6106g.C6107a c6107a = new C6106g.C6107a(file2, sb2.toString());
                                            String str9 = str5;
                                            int i4 = 0;
                                            boolean z = false;
                                            while (i4 < 3 && !z) {
                                                try {
                                                    C6106g.m37178a(zipFile2, entry, c6107a, str6);
                                                    str4 = str6;
                                                    zipEntry = entry;
                                                    z = true;
                                                } catch (IOException e) {
                                                    str4 = str6;
                                                    zipEntry = entry;
                                                    ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + c6107a.getAbsolutePath(), e);
                                                }
                                                int i5 = i4 + 1;
                                                StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                                                sb3.append(z ? "succeeded" : "failed");
                                                sb3.append(" '");
                                                sb3.append(c6107a.getAbsolutePath());
                                                sb3.append("': length ");
                                                sb3.append(c6107a.length());
                                                ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, sb3.toString());
                                                if (!z) {
                                                    c6107a.delete();
                                                    if (c6107a.exists()) {
                                                        ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + c6107a.getPath() + "'");
                                                    }
                                                }
                                                i4 = i5;
                                                str6 = str4;
                                                entry = zipEntry;
                                            }
                                            String str10 = str6;
                                            if (z) {
                                                arrayList.add(c6107a);
                                                i3++;
                                                str5 = str9;
                                                str7 = str8;
                                                str6 = str10;
                                                i2 = 1;
                                            } else {
                                                throw new IOException("Could not create zip file " + c6107a.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                                            }
                                        } else {
                                            str3 = str7;
                                            file.getName();
                                            SharedPreferences.Editor edit = C6106g.m37183a().edit();
                                            edit.putInt((str + "-" + i) + ".dex.number", arrayList.size());
                                            edit.commit();
                                            C6251g.m36894a(zipFile2);
                                            C6096b.m37198a(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                                            C6102f.m37186a();
                                            break;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } else {
                            throw new IOException("Could not check apk info " + file.getAbsolutePath());
                        }
                    } else {
                        str3 = ";";
                        if (C6253i.m36882f()) {
                            String m37226c = C6081c.m37226c(str, i);
                            String m37228b = C6081c.m37228b(str, i);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(m37226c);
                            String str11 = File.separator;
                            sb4.append(str11);
                            sb4.append(C6096b.m37197a(m37228b));
                            String sb5 = sb4.toString();
                            if (C6096b.m37196a(m37228b, m37226c + str11 + C6096b.m37197a(m37228b)) && C6096b.m37193a(sb5)) {
                                stringBuffer.append("dexOpt1 cost:");
                                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                                stringBuffer.append(str3);
                                return true;
                            }
                        }
                    }
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                    stringBuffer.append(str3);
                    return false;
                } catch (Exception e2) {
                    e = e2;
                    m37062a(C6073b.f21868f, C6073b.C6074a.f21909z, str, i, -1L, null);
                    throw new C6176a("dexOpt1失败", e, (byte) 0);
                } catch (Throwable th4) {
                    th = th4;
                    str7 = str2;
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                    stringBuffer.append(str7);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: a */
    private static void m37062a(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", C6165b.m37072a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", C6165b.m37072a(str2));
            jSONObject.putOpt("version_code", C6165b.m37072a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(C6165b.m37070b(Long.valueOf(j))));
            jSONObject2.putOpt("message", C6165b.m37072a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C6073b.m37254a().m37253a(str, jSONObject, jSONObject3, jSONObject2);
    }

    /* renamed from: a */
    static /* synthetic */ void m37064a(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (C6139e.m37128a(file.getAbsolutePath(), str)) {
                    return;
                }
                throw new RuntimeException("安装包签名校验失败[1]");
            } catch (Exception e) {
                m37062a(C6073b.f21868f, C6073b.C6074a.f21904u, str, i, -1L, null);
                f22084a.m37089a(1100, -3, str, i, e);
                throw new C6176a(e.getMessage(), e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m37059a(String str, String str2, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int m36987a = new C6204c().m36987a(new File(str), false, sb);
        stringBuffer.append(m36987a == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (m36987a == 100 || m36987a == 200) {
            return;
        }
        String sb2 = sb.toString();
        m37062a(C6073b.f21868f, C6073b.C6074a.f21877B, str2, i, -1L, sb2);
        f22084a.m37089a(1100, -2, str2, i, null);
        throw new C6176a("modifyRes failed. result = " + m36987a + ", errorLog = " + sb2, (byte) 0);
    }

    /* renamed from: a */
    static /* synthetic */ void m37061a(String str, int i, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                C6080b.m37246a(new File(C6081c.m37228b(str, i)), new File(C6081c.m37224d(str, i)), str, map);
            } catch (Exception e) {
                m37062a(C6073b.f21868f, C6073b.C6074a.f21907x, str, i, -1L, C6165b.m37072a((Object) e));
                f22084a.m37089a(1100, -7, str, i, e);
                throw new C6176a("安装包动态库拷贝失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m37060a(String str, int i, boolean z, StringBuffer stringBuffer) {
        int m36863b = C6256l.m36869a().m36863b(str, i);
        boolean z2 = (m36863b & 1) != 0;
        boolean z3 = (m36863b & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String m37228b = C6081c.m37228b(str, i);
        long currentTimeMillis = System.currentTimeMillis();
        boolean m36912a = C6242b.m36912a(m37228b, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return m36912a;
    }

    /* renamed from: a */
    static /* synthetic */ void m37063a(String str, int i) {
        try {
            if (C6253i.m36883e() || C6253i.m36881g()) {
                C6256l.m36869a().m36861b(str, i, false);
                C6096b.m37198a(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                C6102f.m37186a();
            }
        } catch (Exception e) {
            m37062a(C6073b.f21868f, C6073b.C6074a.f21909z, str, i, -1L, null);
            throw new C6176a("dexOpt2失败", e, (byte) 0);
        }
    }
}
