package com.bxkj.base.util.file;

import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DownloadUtil.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f18382b;

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f18383a = new OkHttpClient();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.base.util.file.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class C0198a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f18384a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18385b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18386c;

        C0198a(b bVar, String str, String str2) {
            this.f18384a = bVar;
            this.f18385b = str;
            this.f18386c = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f18384a.c(iOException);
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
                java.lang.String r1 = r9.f18385b
                r0.<init>(r1)
                boolean r1 = r0.exists()
                if (r1 != 0) goto L14
                r0.mkdirs()
            L14:
                java.io.File r1 = new java.io.File
                java.lang.String r2 = r9.f18386c
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
                com.bxkj.base.util.file.a$b r7 = r9.f18384a     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r7.b(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                goto L33
            L52:
                r11.flush()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                com.bxkj.base.util.file.a$b r10 = r9.f18384a     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
                r10.a(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
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
                com.bxkj.base.util.file.a$b r1 = r9.f18384a     // Catch: java.lang.Throwable -> L80
                r1.c(r10)     // Catch: java.lang.Throwable -> L80
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.file.a.C0198a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DownloadUtil.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        void a(File file);

        void b(int i4);

        void c(Exception exc);
    }

    public static a b() {
        if (f18382b == null) {
            f18382b = new a();
        }
        return f18382b;
    }

    public void a(String str, String str2, String str3, b bVar) {
        Request build = new Request.Builder().url(str).build();
        try {
            new OkHttpClient().newCall(build).execute();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        this.f18383a.newCall(build).enqueue(new C0198a(bVar, str2, str3));
    }
}
