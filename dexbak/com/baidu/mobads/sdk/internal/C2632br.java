package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.C2640by;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import java.io.File;
import java.io.FilenameFilter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.baidu.mobads.sdk.internal.br */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2632br extends File {

    /* renamed from: a */
    public static final String f8722a = "LocalApkFile";

    /* renamed from: b */
    private static final long f8723b = 6916965592955692235L;

    /* renamed from: h */
    private static ClassLoader f8724h;

    /* renamed from: c */
    private C2638bw f8725c;

    /* renamed from: d */
    private Class<?> f8726d;

    /* renamed from: e */
    private Context f8727e;

    /* renamed from: f */
    private PublicKey f8728f;

    /* renamed from: g */
    private C2634bs f8729g;

    /* renamed from: com.baidu.mobads.sdk.internal.br$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C2633a implements FilenameFilter {
        C2633a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public C2632br(String str, Context context) {
        this(str, context, null);
    }

    /* renamed from: d */
    private void m50745d() {
        File[] listFiles = this.f8727e.getFilesDir().listFiles(new C2633a());
        for (int i = 0; listFiles != null && i < listFiles.length; i++) {
            if (listFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                C2634bs c2634bs = this.f8729g;
                c2634bs.m50740a(f8722a, "clearDexCacheFiles-->" + i + "--" + listFiles[i].getAbsolutePath());
                listFiles[i].delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m50754a() {
        if (this.f8725c != null) {
            String m50752a = m50752a(new File(getAbsolutePath()));
            String m50748b = m50748b(this.f8725c.m50711d());
            if (m50752a.equalsIgnoreCase(m50748b)) {
                return;
            }
            throw new C2640by.C2641a("doCheckApkIntegrity failed, md5sum: " + m50752a + ", checksum in json info: " + m50748b);
        }
        this.f8729g.m50740a(f8722a, "built-in apk, no need to check");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Class<?> m50750b() {
        if (this.f8726d == null) {
            File file = new File(getAbsolutePath());
            try {
                this.f8726d = m50749b(file);
            } catch (Exception unused) {
                file.delete();
            }
        }
        return this.f8726d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public double m50747c() {
        C2638bw c2638bw = this.f8725c;
        return c2638bw == null ? Utils.DOUBLE_EPSILON : c2638bw.m50713b();
    }

    public C2632br(String str, Context context, C2638bw c2638bw) {
        super(str);
        this.f8726d = null;
        this.f8727e = null;
        this.f8729g = C2634bs.m50744a();
        this.f8727e = context;
        this.f8725c = c2638bw;
        if (c2638bw != null) {
            try {
                this.f8728f = m50746c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f8728f = null;
            }
        }
    }

    /* renamed from: c */
    private static PublicKey m50746c(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    /* renamed from: b */
    private String m50748b(String str) {
        if (this.f8728f != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.f8728f);
                return new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Exception e) {
                this.f8729g.m50730c("ErrorWhileVerifySigNature", e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m50751a(String str) {
        renameTo(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009d A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #5 {Exception -> 0x0099, blocks: (B:46:0x0095, B:50:0x009d), top: B:60:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m50752a(java.io.File r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "LocalApkFile"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            java.lang.String r9 = "MD5"
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            java.security.DigestInputStream r4 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            r4.<init>(r3, r9)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L68
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
        L19:
            int r5 = r4.read(r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6 = -1
            if (r5 == r6) goto L21
            goto L19
        L21:
            byte[] r9 = r9.digest()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r2 = 0
            r5 = r0
        L27:
            int r6 = r9.length     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            if (r2 >= r6) goto L4d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.<init>()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.append(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r5 = r9[r2]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 + 256
            r7 = 16
            java.lang.String r5 = java.lang.Integer.toString(r5, r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r7 = 1
            java.lang.String r5 = r5.substring(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r6.append(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            int r2 = r2 + 1
            goto L27
        L4d:
            r3.close()     // Catch: java.lang.Exception -> L54
            r4.close()     // Catch: java.lang.Exception -> L54
            goto L5e
        L54:
            r9 = move-exception
            com.baidu.mobads.sdk.internal.bs r0 = r8.f8729g
            java.lang.String r9 = r9.getMessage()
            r0.m50740a(r1, r9)
        L5e:
            r0 = r5
            goto L91
        L60:
            r9 = move-exception
            goto L66
        L62:
            r9 = move-exception
            goto L6a
        L64:
            r9 = move-exception
            r4 = r2
        L66:
            r2 = r3
            goto L93
        L68:
            r9 = move-exception
            r4 = r2
        L6a:
            r2 = r3
            goto L71
        L6c:
            r9 = move-exception
            r4 = r2
            goto L93
        L6f:
            r9 = move-exception
            r4 = r2
        L71:
            com.baidu.mobads.sdk.internal.bs r3 = r8.f8729g     // Catch: java.lang.Throwable -> L92
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L92
            r3.m50740a(r1, r9)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.lang.Exception -> L80
            goto L82
        L80:
            r9 = move-exception
            goto L88
        L82:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.lang.Exception -> L80
            goto L91
        L88:
            com.baidu.mobads.sdk.internal.bs r2 = r8.f8729g
            java.lang.String r9 = r9.getMessage()
            r2.m50740a(r1, r9)
        L91:
            return r0
        L92:
            r9 = move-exception
        L93:
            if (r2 == 0) goto L9b
            r2.close()     // Catch: java.lang.Exception -> L99
            goto L9b
        L99:
            r0 = move-exception
            goto La1
        L9b:
            if (r4 == 0) goto Laa
            r4.close()     // Catch: java.lang.Exception -> L99
            goto Laa
        La1:
            com.baidu.mobads.sdk.internal.bs r2 = r8.f8729g
            java.lang.String r0 = r0.getMessage()
            r2.m50740a(r1, r0)
        Laa:
            goto Lac
        Lab:
            throw r9
        Lac:
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.C2632br.m50752a(java.io.File):java.lang.String");
    }

    @TargetApi(14)
    /* renamed from: b */
    private Class<?> m50749b(File file) {
        Class<?> cls;
        C2634bs c2634bs = this.f8729g;
        c2634bs.m50740a(f8722a, "Android version:" + C2624bk.m50799a(this.f8727e).m50791c());
        Class<?> cls2 = null;
        try {
            synchronized (C2640by.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.f8727e.getFilesDir().getAbsolutePath();
                String str = C2736x.f9277aP;
                f8724h = C2598ao.m50987a(absolutePath, absolutePath2, (String) null, classLoader);
                C2634bs c2634bs2 = this.f8729g;
                c2634bs2.m50740a(f8722a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName(str, true, f8724h);
            }
            cls2 = cls;
        } catch (Exception e) {
            this.f8729g.m50740a(f8722a, e.getMessage());
        }
        C2634bs c2634bs3 = this.f8729g;
        c2634bs3.m50740a(f8722a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }

    /* renamed from: a */
    public static ClassLoader m50753a(Context context) {
        ClassLoader classLoader = f8724h;
        return classLoader != null ? classLoader : C2603as.m50962a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }
}
