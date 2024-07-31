package com.bxkj.base.util.file;

import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: DownloadUtil.java */
/* renamed from: com.bxkj.base.util.file.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3895a {

    /* renamed from: b */
    private static C3895a f14898b;

    /* renamed from: a */
    private final OkHttpClient f14899a = new OkHttpClient();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.base.util.file.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3896a implements Callback {

        /* renamed from: a */
        final /* synthetic */ InterfaceC3897b f14900a;

        /* renamed from: b */
        final /* synthetic */ String f14901b;

        /* renamed from: c */
        final /* synthetic */ String f14902c;

        C3896a(InterfaceC3897b interfaceC3897b, String str, String str2) {
            this.f14900a = interfaceC3897b;
            this.f14901b = str;
            this.f14902c = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f14900a.mo41646c(iOException);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x0088 A[Catch: IOException -> 0x008b, TRY_LEAVE, TryCatch #8 {IOException -> 0x008b, blocks: (B:38:0x0083, B:40:0x0088), top: B:50:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r10, okhttp3.Response r11) throws java.io.IOException {
            /*
                r9 = this;
                r10 = 2048(0x800, float:2.87E-42)
                byte[] r10 = new byte[r10]
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r9.f14901b
                r0.<init>(r1)
                boolean r1 = r0.exists()
                if (r1 != 0) goto L14
                r0.mkdirs()
            L14:
                java.io.File r1 = new java.io.File
                java.lang.String r2 = r9.f14902c
                r1.<init>(r0, r2)
                r0 = 0
                okhttp3.ResponseBody r2 = r11.body()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
                java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L70
                okhttp3.ResponseBody r11 = r11.body()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L69
                long r3 = r11.contentLength()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L69
                java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L69
                r11.<init>(r1)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L69
                r5 = 0
            L33:
                int r0 = r2.read(r10)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r7 = -1
                if (r0 == r7) goto L52
                r7 = 0
                r11.write(r10, r7, r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                long r7 = (long) r0     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                long r5 = r5 + r7
                float r0 = (float) r5     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r7 = 1065353216(0x3f800000, float:1.0)
                float r0 = r0 * r7
                float r7 = (float) r3     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                float r0 = r0 / r7
                r7 = 1120403456(0x42c80000, float:100.0)
                float r0 = r0 * r7
                int r0 = (int) r0     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                com.bxkj.base.util.file.a$b r7 = r9.f14900a     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r7.mo41647b(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                goto L33
            L52:
                r11.flush()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                com.bxkj.base.util.file.a$b r10 = r9.f14900a     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r10.mo41648a(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r2.close()     // Catch: java.io.IOException -> L7f
            L5d:
                r11.close()     // Catch: java.io.IOException -> L7f
                goto L7f
            L61:
                r10 = move-exception
                goto L67
            L63:
                r10 = move-exception
                goto L6b
            L65:
                r10 = move-exception
                r11 = r0
            L67:
                r0 = r2
                goto L81
            L69:
                r10 = move-exception
                r11 = r0
            L6b:
                r0 = r2
                goto L72
            L6d:
                r10 = move-exception
                r11 = r0
                goto L81
            L70:
                r10 = move-exception
                r11 = r0
            L72:
                com.bxkj.base.util.file.a$b r1 = r9.f14900a     // Catch: java.lang.Throwable -> L80
                r1.mo41646c(r10)     // Catch: java.lang.Throwable -> L80
                if (r0 == 0) goto L7c
                r0.close()     // Catch: java.io.IOException -> L7f
            L7c:
                if (r11 == 0) goto L7f
                goto L5d
            L7f:
                return
            L80:
                r10 = move-exception
            L81:
                if (r0 == 0) goto L86
                r0.close()     // Catch: java.io.IOException -> L8b
            L86:
                if (r11 == 0) goto L8b
                r11.close()     // Catch: java.io.IOException -> L8b
            L8b:
                goto L8d
            L8c:
                throw r10
            L8d:
                goto L8c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.file.C3895a.C3896a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.base.util.file.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3897b {
        /* renamed from: a */
        void mo41648a(File file);

        /* renamed from: b */
        void mo41647b(int i);

        /* renamed from: c */
        void mo41646c(Exception exc);
    }

    /* renamed from: b */
    public static C3895a m44111b() {
        if (f14898b == null) {
            f14898b = new C3895a();
        }
        return f14898b;
    }

    /* renamed from: a */
    public void m44112a(String str, String str2, String str3, InterfaceC3897b interfaceC3897b) {
        Request build = new Request.Builder().url(str).build();
        try {
            new OkHttpClient().newCall(build).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f14899a.newCall(build).enqueue(new C3896a(interfaceC3897b, str2, str3));
    }
}
