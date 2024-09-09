package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.l;
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
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final i f28845a = i.a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a extends IOException {
        /* synthetic */ a(String str, byte b4) {
            this(str);
        }

        /* synthetic */ a(String str, Throwable th, byte b4) {
            this(str, th);
        }

        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(final File file, final String str, final int i4) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            i iVar = f28845a;
            iVar.a(1000, 0, str, i4, null);
            com.bytedance.pangle.log.a a4 = com.bytedance.pangle.log.a.a("Zeus/install_pangle", "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.f28636e, b.a.f28662r, str, i4, -1L, null);
            int b4 = l.a().b(str, i4, AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY);
            int b5 = l.a().b(str, i4, "load");
            GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            int i5 = (b4 > 3 || b5 > 3) ? 0 : 0;
            SharedPreferences.Editor edit = l.a().f29012a.edit();
            edit.putInt("remove_entry_flag_" + str + "_" + i4, i5);
            edit.apply();
            l.a().c(str, i4, false);
            g.a(com.bytedance.pangle.d.c.a(str, i4));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0424a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.a.a.InterfaceC0424a
                public final void a() {
                    b.a(file, str, i4, stringBuffer);
                }
            }, new a.InterfaceC0424a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.a.a.InterfaceC0424a
                public final void a() {
                    final Map f4 = b.f(file, str, i4, stringBuffer);
                    b.c(file, str, i4, stringBuffer);
                    b.a(b.g(file, str, i4, stringBuffer), str, i4, stringBuffer);
                    if (!com.bytedance.pangle.util.i.f() && !com.bytedance.pangle.util.i.b()) {
                        b.a(str, i4, f4, stringBuffer);
                        zArr[0] = b.a(str, i4, false, stringBuffer);
                        b.a(str, i4);
                        return;
                    }
                    final boolean[] zArr2 = {false};
                    com.bytedance.pangle.a.a.a(new a.InterfaceC0424a() { // from class: com.bytedance.pangle.plugin.b.2.1
                        @Override // com.bytedance.pangle.a.a.InterfaceC0424a
                        public final void a() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            b.a(str, i4, f4, stringBuffer);
                        }
                    }, new a.InterfaceC0424a() { // from class: com.bytedance.pangle.plugin.b.2.2
                        @Override // com.bytedance.pangle.a.a.InterfaceC0424a
                        public final void a() {
                            boolean[] zArr3 = zArr2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            zArr3[0] = b.h(file, str, i4, stringBuffer);
                        }
                    });
                    zArr[0] = b.a(str, i4, zArr2[0], stringBuffer);
                }
            });
            g.a(file);
            a(com.bytedance.pangle.c.b.f28637f, b.a.f28663s, str, i4, a4.a(), stringBuffer.toString());
            a4.a("success");
            iVar.a(1100, 0, str, i4, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w("Zeus/install_pangle", "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w("Zeus/install_pangle", "PluginInstaller " + str + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f28637f, b.a.f28664t, str, i4, -1L, stringBuffer.toString());
                f28845a.a(1100, -1, str, i4, th);
            }
            if (zArr[0]) {
                l.a().a(str, i4, AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY);
            }
            return false;
        }
    }

    static /* synthetic */ void c(File file, String str, int i4, StringBuffer stringBuffer) {
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
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
                        }
                    }
                }
            } catch (Exception e4) {
                a(com.bytedance.pangle.c.b.f28637f, b.a.f28666v, str, i4, -1L, null);
                f28845a.a(1100, -4, str, i4, e4);
                throw new a("\u5b89\u88c5\u5305\u6743\u9650\u6821\u9a8c\u5931\u8d25", e4, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> f(File file, String str, int i4, StringBuffer stringBuffer) {
        if (GlobalParam.getInstance().checkMatchHostAbi()) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    e<Boolean, Map<String, List<ZipEntry>>> a4 = com.bytedance.pangle.d.b.a(file);
                    boolean booleanValue = a4.f29003a.booleanValue();
                    Map<String, List<ZipEntry>> map = a4.f29004b;
                    if (booleanValue) {
                        return map;
                    }
                    throw new a("\u63d2\u4ef6\u5305\u5305\u542bso\u4e0d\u7b26\u5408\u5bbf\u4e3bABI\u7c7b\u578b", (byte) 0);
                } catch (Exception e4) {
                    a(com.bytedance.pangle.c.b.f28637f, b.a.A, str, i4, -1L, null);
                    f28845a.a(1100, -5, str, i4, e4);
                    throw new a("\u63d2\u4ef6\u5305\u5305\u542bso\u4e0d\u7b26\u5408\u5bbf\u4e3bABI\u7c7b\u578b", e4, (byte) 0);
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
    public static String g(File file, String str, int i4, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String b4 = com.bytedance.pangle.d.c.b(str, i4);
        try {
            try {
                h.a(file.getAbsolutePath(), b4);
                return b4;
            } catch (Exception e4) {
                a(com.bytedance.pangle.c.b.f28637f, b.a.f28667w, str, i4, -1L, null);
                f28845a.a(1100, -6, str, i4, e4);
                throw new a("\u5b89\u88c5\u5305\u62f7\u8d1d\u5931\u8d25", e4, (byte) 0);
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
    public static boolean h(File file, String str, int i4, StringBuffer stringBuffer) {
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
                int i5 = 1;
                try {
                    if (com.bytedance.pangle.util.i.b()) {
                        if (file.exists() && str != null) {
                            ZipFile zipFile = null;
                            try {
                                ZipFile zipFile2 = new ZipFile(file);
                                try {
                                    ArrayList arrayList = new ArrayList();
                                    File file2 = new File(com.bytedance.pangle.d.c.i(str, i4));
                                    com.bytedance.pangle.e.g.a(file2);
                                    int i6 = 1;
                                    while (true) {
                                        StringBuilder sb = new StringBuilder(str6);
                                        Object obj = "";
                                        sb.append(i6 == i5 ? "" : Integer.valueOf(i6));
                                        sb.append(str5);
                                        ZipEntry entry = zipFile2.getEntry(sb.toString());
                                        if (entry != null) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(str6);
                                            String str8 = str7;
                                            if (i6 != 1) {
                                                try {
                                                    obj = Integer.valueOf(i6);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile2;
                                                    g.a(zipFile);
                                                    throw th;
                                                }
                                            }
                                            sb2.append(obj);
                                            sb2.append(str5);
                                            g.a aVar = new g.a(file2, sb2.toString());
                                            String str9 = str5;
                                            int i7 = 0;
                                            boolean z3 = false;
                                            while (i7 < 3 && !z3) {
                                                try {
                                                    com.bytedance.pangle.e.g.a(zipFile2, entry, aVar, str6);
                                                    str4 = str6;
                                                    zipEntry = entry;
                                                    z3 = true;
                                                } catch (IOException e4) {
                                                    str4 = str6;
                                                    zipEntry = entry;
                                                    ZeusLogger.w("Zeus/install_pangle", "Plugin-MultiDex Failed to extract entry from " + aVar.getAbsolutePath(), e4);
                                                }
                                                int i8 = i7 + 1;
                                                StringBuilder sb3 = new StringBuilder("Plugin-MultiDex Extraction ");
                                                sb3.append(z3 ? "succeeded" : "failed");
                                                sb3.append(" '");
                                                sb3.append(aVar.getAbsolutePath());
                                                sb3.append("': length ");
                                                sb3.append(aVar.length());
                                                ZeusLogger.i("Zeus/install_pangle", sb3.toString());
                                                if (!z3) {
                                                    aVar.delete();
                                                    if (aVar.exists()) {
                                                        ZeusLogger.w("Zeus/install_pangle", "Plugin-MultiDex Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                                                    }
                                                }
                                                i7 = i8;
                                                str6 = str4;
                                                entry = zipEntry;
                                            }
                                            String str10 = str6;
                                            if (z3) {
                                                arrayList.add(aVar);
                                                i6++;
                                                str5 = str9;
                                                str7 = str8;
                                                str6 = str10;
                                                i5 = 1;
                                            } else {
                                                throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i6 + ")");
                                            }
                                        } else {
                                            str3 = str7;
                                            file.getName();
                                            SharedPreferences.Editor edit = com.bytedance.pangle.e.g.a().edit();
                                            edit.putInt((str + "-" + i4) + ".dex.number", arrayList.size());
                                            edit.commit();
                                            com.bytedance.pangle.util.g.a(zipFile2);
                                            com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i4).apply();
                                            f.a();
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
                        if (com.bytedance.pangle.util.i.f()) {
                            String c4 = com.bytedance.pangle.d.c.c(str, i4);
                            String b4 = com.bytedance.pangle.d.c.b(str, i4);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(c4);
                            String str11 = File.separator;
                            sb4.append(str11);
                            sb4.append(com.bytedance.pangle.e.b.a(b4));
                            String sb5 = sb4.toString();
                            if (com.bytedance.pangle.e.b.a(b4, c4 + str11 + com.bytedance.pangle.e.b.a(b4)) && com.bytedance.pangle.e.b.a(sb5)) {
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
                } catch (Exception e5) {
                    e = e5;
                    a(com.bytedance.pangle.c.b.f28637f, b.a.f28670z, str, i4, -1L, null);
                    throw new a("dexOpt1\u5931\u8d25", e, (byte) 0);
                } catch (Throwable th4) {
                    th = th4;
                    str7 = str2;
                    stringBuffer.append("dexOpt1 cost:");
                    stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                    stringBuffer.append(str7);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static void a(String str, int i4, @NonNull String str2, int i5, long j4, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i4)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i5)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j4))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    static /* synthetic */ void a(File file, String str, int i4, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                    return;
                }
                throw new RuntimeException("\u5b89\u88c5\u5305\u7b7e\u540d\u6821\u9a8c\u5931\u8d25[1]");
            } catch (Exception e4) {
                a(com.bytedance.pangle.c.b.f28637f, b.a.f28665u, str, i4, -1L, null);
                f28845a.a(1100, -3, str, i4, e4);
                throw new a(e4.getMessage(), e4, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    static /* synthetic */ void a(String str, String str2, int i4, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int a4 = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb);
        stringBuffer.append(a4 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (a4 == 100 || a4 == 200) {
            return;
        }
        String sb2 = sb.toString();
        a(com.bytedance.pangle.c.b.f28637f, b.a.B, str2, i4, -1L, sb2);
        f28845a.a(1100, -2, str2, i4, null);
        throw new a("modifyRes failed. result = " + a4 + ", errorLog = " + sb2, (byte) 0);
    }

    static /* synthetic */ void a(String str, int i4, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i4)), new File(com.bytedance.pangle.d.c.d(str, i4)), str, map);
            } catch (Exception e4) {
                a(com.bytedance.pangle.c.b.f28637f, b.a.f28668x, str, i4, -1L, com.bytedance.pangle.log.b.a((Object) e4));
                f28845a.a(1100, -7, str, i4, e4);
                throw new a("\u5b89\u88c5\u5305\u52a8\u6001\u5e93\u62f7\u8d1d\u5931\u8d25", e4, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    static /* synthetic */ boolean a(String str, int i4, boolean z3, StringBuffer stringBuffer) {
        int b4 = l.a().b(str, i4);
        boolean z4 = (b4 & 1) != 0;
        boolean z5 = (b4 & 2) != 0;
        if (!z4 && !z5) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z6 = z3 && z4;
        String b5 = com.bytedance.pangle.d.c.b(str, i4);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a4 = com.bytedance.pangle.util.b.b.a(b5, z6, z5, str, i4, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return a4;
    }

    static /* synthetic */ void a(String str, int i4) {
        try {
            if (com.bytedance.pangle.util.i.e() || com.bytedance.pangle.util.i.g()) {
                l.a().b(str, i4, false);
                com.bytedance.pangle.e.b.a(Zeus.getAppApplication()).edit().putInt(str, i4).apply();
                f.a();
            }
        } catch (Exception e4) {
            a(com.bytedance.pangle.c.b.f28637f, b.a.f28670z, str, i4, -1L, null);
            throw new a("dexOpt2\u5931\u8d25", e4, (byte) 0);
        }
    }
}
