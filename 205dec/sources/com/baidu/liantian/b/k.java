package com.baidu.liantian.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* compiled from: GalaxyId.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12128a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12129b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f12130c;

    /* renamed from: d  reason: collision with root package name */
    private static a f12131d;

    /* renamed from: e  reason: collision with root package name */
    private Context f12132e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GalaxyId.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f12133a;

        /* renamed from: b  reason: collision with root package name */
        public String f12134b;

        private a() {
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                if (!TextUtils.isEmpty(string) && string2 != null) {
                    a aVar = new a();
                    aVar.f12133a = string;
                    aVar.f12134b = string2;
                    return aVar;
                }
                return null;
            } catch (Throwable unused) {
                k.a();
                return null;
            }
        }

        /* synthetic */ a(byte b4) {
            this();
        }

        public final String a() {
            try {
                String str = this.f12134b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                String stringBuffer = new StringBuffer(str).reverse().toString();
                return this.f12133a + "|" + stringBuffer;
            } catch (Throwable unused) {
                k.a();
                return null;
            }
        }
    }

    static {
        String str = new String(c.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        f12128a = str;
        String str2 = new String(c.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        f12129b = str2;
        f12130c = str + str2;
    }

    private k(Context context) {
        this.f12132e = context;
    }

    private String a(String str) {
        try {
            return Settings.System.getString(this.f12132e.getContentResolver(), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void a() {
    }

    private static a b(Context context) {
        if (f12131d == null) {
            synchronized (a.class) {
                if (f12131d == null) {
                    f12131d = new k(context).b();
                }
            }
        }
        return f12131d;
    }

    private static a c() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                String a4 = a(file);
                if (TextUtils.isEmpty(a4)) {
                    return null;
                }
                String str = f12130c;
                return a.a(new String(com.baidu.liantian.b.a.a(str, str, c.a(a4.getBytes()))));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private a d() {
        try {
            String a4 = a("com.baidu.deviceid");
            String a5 = a("bd_setting_i");
            String str = "";
            if (TextUtils.isEmpty(a5)) {
                a5 = c("");
            }
            if (TextUtils.isEmpty(a4)) {
                String string = Settings.Secure.getString(this.f12132e.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    str = string;
                }
                a4 = a(o.b(("com.baidu" + a5 + str).getBytes()));
            }
            if (TextUtils.isEmpty(a4)) {
                return null;
            }
            a aVar = new a((byte) 0);
            aVar.f12133a = a4;
            aVar.f12134b = a5;
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean e(String str) {
        return this.f12132e.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private static String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable unused) {
            fileReader = null;
        }
        try {
            char[] cArr = new char[8192];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                int read = fileReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                charArrayWriter.write(cArr, 0, read);
            }
            String charArrayWriter2 = charArrayWriter.toString();
            try {
                fileReader.close();
            } catch (Throwable unused2) {
            }
            return charArrayWriter2;
        } catch (Throwable unused3) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    private a b() {
        a aVar;
        try {
            a a4 = a.a(d(a("com.baidu.deviceid.v2")));
            if (a4 != null) {
                return a4;
            }
            try {
                boolean e4 = e("android.permission.READ_EXTERNAL_STORAGE");
                if (e4) {
                    a4 = c();
                }
                if (a4 != null) {
                    return a4;
                }
                a d4 = d();
                return (d4 == null && e4) ? b(c("")) : d4;
            } catch (Throwable unused) {
                return aVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String a(Context context) {
        a b4 = b(context);
        if (b4 != null) {
            return b4.a();
        }
        return null;
    }

    private String c(String str) {
        String str2 = null;
        if (e("android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f12132e.getSystemService("phone");
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
            }
            if (str2 != null && str2.contains(":")) {
                str2 = "";
            }
            return TextUtils.isEmpty(str2) ? str : str2;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
        if (r6 != null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.baidu.liantian.b.k.a b(java.lang.String r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 23
            if (r0 >= r3) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            r3 = 0
            if (r0 == 0) goto L15
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 == 0) goto L15
            return r3
        L15:
            java.lang.String r4 = ""
            java.io.File r5 = new java.io.File
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r7 = "baidu/.cuid"
            r5.<init>(r6, r7)
            boolean r6 = r5.exists()
            if (r6 != 0) goto L33
            java.io.File r5 = new java.io.File
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r7 = "backups/.SystemConfig/.cuid"
            r5.<init>(r6, r7)
        L33:
            java.io.FileReader r6 = new java.io.FileReader     // Catch: java.lang.Throwable -> L9c
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L9c
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r7.<init>()     // Catch: java.lang.Throwable -> L9e
        L42:
            java.lang.String r8 = r5.readLine()     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L51
            r7.append(r8)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = "\r\n"
            r7.append(r8)     // Catch: java.lang.Throwable -> L9e
            goto L42
        L51:
            r5.close()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L9e
            java.lang.String r9 = com.baidu.liantian.b.k.f12130c     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L9e
            byte[] r7 = r7.getBytes()     // Catch: java.lang.Throwable -> L9e
            byte[] r7 = com.baidu.liantian.b.c.a(r7)     // Catch: java.lang.Throwable -> L9e
            byte[] r7 = com.baidu.liantian.b.a.a(r9, r9, r7)     // Catch: java.lang.Throwable -> L9e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = "="
            java.lang.String[] r7 = r8.split(r7)     // Catch: java.lang.Throwable -> L9e
            if (r7 == 0) goto L91
            int r8 = r7.length     // Catch: java.lang.Throwable -> L9e
            r9 = 2
            if (r8 != r9) goto L91
            if (r0 == 0) goto L84
            r8 = r7[r1]     // Catch: java.lang.Throwable -> L9e
            boolean r8 = r10.equals(r8)     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L84
            r0 = r7[r2]     // Catch: java.lang.Throwable -> L9e
            goto L90
        L84:
            if (r0 != 0) goto L91
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L8e
            r10 = r7[r2]     // Catch: java.lang.Throwable -> L9e
        L8e:
            r0 = r7[r2]     // Catch: java.lang.Throwable -> L9e
        L90:
            r4 = r0
        L91:
            r5.close()     // Catch: java.lang.Throwable -> L98
        L94:
            r6.close()     // Catch: java.lang.Throwable -> L98
            goto La6
        L98:
            goto La6
        L9a:
            r5 = r3
            goto L9e
        L9c:
            r5 = r3
            r6 = r5
        L9e:
            if (r5 == 0) goto La3
            r5.close()     // Catch: java.lang.Throwable -> L98
        La3:
            if (r6 == 0) goto La6
            goto L94
        La6:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto Lb6
            com.baidu.liantian.b.k$a r0 = new com.baidu.liantian.b.k$a
            r0.<init>(r1)
            r0.f12133a = r4
            r0.f12134b = r10
            return r0
        Lb6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.k.b(java.lang.String):com.baidu.liantian.b.k$a");
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = f12130c;
            return new String(com.baidu.liantian.b.a.a(str2, str2, c.a(str.getBytes())));
        } catch (Throwable unused) {
            return "";
        }
    }
}
