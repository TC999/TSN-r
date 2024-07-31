package com.bxkj.base.util;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.utils.Tools;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* renamed from: com.bxkj.base.util.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DownloadUtil {

    /* renamed from: b */
    private static DownloadUtil f14890b;

    /* renamed from: a */
    private final OkHttpClient f14891a = new OkHttpClient();

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.base.util.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3892a implements Callback {

        /* renamed from: a */
        final /* synthetic */ HandlerC3894c f14892a;

        /* renamed from: b */
        final /* synthetic */ String f14893b;

        /* renamed from: c */
        final /* synthetic */ String f14894c;

        C3892a(HandlerC3894c handlerC3894c, String str, String str2) {
            this.f14892a = handlerC3894c;
            this.f14893b = str;
            this.f14894c = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f14892a.sendEmptyMessage(4);
            iOException.printStackTrace();
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) throws java.io.IOException {
            /*
                r10 = this;
                r11 = 2048(0x800, float:2.87E-42)
                byte[] r11 = new byte[r11]
                com.bxkj.base.util.f r0 = com.bxkj.base.util.DownloadUtil.this
                java.lang.String r1 = r10.f14893b
                java.lang.String r0 = com.bxkj.base.util.DownloadUtil.m44121a(r0, r1)
                r1 = 0
                okhttp3.ResponseBody r2 = r12.body()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L97
                java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L97
                okhttp3.ResponseBody r12 = r12.body()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                long r3 = r12.contentLength()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                java.io.File r12 = new java.io.File     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                com.bxkj.base.util.f r5 = com.bxkj.base.util.DownloadUtil.this     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                java.lang.String r6 = r10.f14894c     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                java.lang.String r5 = com.bxkj.base.util.DownloadUtil.m44120b(r5, r6)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                r12.<init>(r0, r5)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                r0.<init>(r12)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
                r5 = 0
            L31:
                int r1 = r2.read(r11)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r7 = -1
                if (r1 == r7) goto L6f
                r7 = 0
                r0.write(r11, r7, r1)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                long r7 = (long) r1     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                long r5 = r5 + r7
                float r1 = (float) r5     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r7 = 1065353216(0x3f800000, float:1.0)
                float r1 = r1 * r7
                float r7 = (float) r3     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                float r1 = r1 / r7
                r7 = 1120403456(0x42c80000, float:100.0)
                float r1 = r1 * r7
                int r1 = (int) r1     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                android.os.Message r7 = new android.os.Message     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r7.<init>()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                android.os.Bundle r8 = new android.os.Bundle     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r8.<init>()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                java.lang.String r9 = "total"
                r8.putLong(r9, r3)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                java.lang.String r9 = "sum"
                r8.putLong(r9, r5)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                java.lang.String r9 = "progress"
                r8.putInt(r9, r1)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r7.setData(r8)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r1 = 2
                r7.what = r1     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                com.bxkj.base.util.f$c r1 = r10.f14892a     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r1.sendMessage(r7)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                goto L31
            L6f:
                r0.flush()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                android.os.Message r11 = new android.os.Message     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r11.<init>()     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r11.obj = r12     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r12 = 3
                r11.what = r12     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                com.bxkj.base.util.f$c r12 = r10.f14892a     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r12.sendMessage(r11)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8a
                r2.close()     // Catch: java.io.IOException -> L84
            L84:
                r0.close()     // Catch: java.io.IOException -> Lac
                goto Lac
            L88:
                r11 = move-exception
                goto L8e
            L8a:
                r11 = move-exception
                goto L92
            L8c:
                r11 = move-exception
                r0 = r1
            L8e:
                r1 = r2
                goto Lae
            L90:
                r11 = move-exception
                r0 = r1
            L92:
                r1 = r2
                goto L99
            L94:
                r11 = move-exception
                r0 = r1
                goto Lae
            L97:
                r11 = move-exception
                r0 = r1
            L99:
                r11.printStackTrace()     // Catch: java.lang.Throwable -> Lad
                com.bxkj.base.util.f$c r11 = r10.f14892a     // Catch: java.lang.Throwable -> Lad
                r12 = 4
                r11.sendEmptyMessage(r12)     // Catch: java.lang.Throwable -> Lad
                if (r1 == 0) goto La9
                r1.close()     // Catch: java.io.IOException -> La8
                goto La9
            La8:
            La9:
                if (r0 == 0) goto Lac
                goto L84
            Lac:
                return
            Lad:
                r11 = move-exception
            Lae:
                if (r1 == 0) goto Lb5
                r1.close()     // Catch: java.io.IOException -> Lb4
                goto Lb5
            Lb4:
            Lb5:
                if (r0 == 0) goto Lba
                r0.close()     // Catch: java.io.IOException -> Lba
            Lba:
                goto Lbc
            Lbb:
                throw r11
            Lbc:
                goto Lbb
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.DownloadUtil.C3892a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.base.util.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC3893b {
        /* renamed from: a */
        public void m44115a() {
        }

        /* renamed from: b */
        public abstract void m44114b(File file);

        /* renamed from: c */
        public void m44113c(long j, long j2, int i) {
        }
    }

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.base.util.f$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class HandlerC3894c extends Handler {

        /* renamed from: a */
        private AbstractC3893b f14896a;

        public HandlerC3894c(AbstractC3893b abstractC3893b) {
            this.f14896a = abstractC3893b;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractC3893b abstractC3893b;
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                long j = message.getData().getLong("total");
                long j2 = message.getData().getLong("sum");
                int i2 = message.getData().getInt(NotificationCompat.CATEGORY_PROGRESS);
                AbstractC3893b abstractC3893b2 = this.f14896a;
                if (abstractC3893b2 != null) {
                    abstractC3893b2.m44113c(j, j2, i2);
                }
            } else if (i != 3) {
                if (i == 4 && (abstractC3893b = this.f14896a) != null) {
                    abstractC3893b.m44115a();
                }
            } else {
                AbstractC3893b abstractC3893b3 = this.f14896a;
                if (abstractC3893b3 != null) {
                    abstractC3893b3.m44114b((File) message.obj);
                }
            }
        }
    }

    private DownloadUtil() {
    }

    /* renamed from: d */
    public static DownloadUtil m44118d() {
        if (f14890b == null) {
            f14890b = new DownloadUtil();
        }
        return f14890b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: e */
    public String m44117e(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m44116f(String str) throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.mkdirs()) {
            file.createNewFile();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    public void m44119c(String str, String str2, AbstractC3893b abstractC3893b) {
        if (Tools.m57617b0(str)) {
            return;
        }
        this.f14891a.newCall(new Request.Builder().url(str).build()).enqueue(new C3892a(new HandlerC3894c(abstractC3893b), str2, str));
    }
}
