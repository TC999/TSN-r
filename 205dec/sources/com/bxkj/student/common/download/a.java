package com.bxkj.student.common.download;

import android.content.ContextWrapper;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bxkj.base.BaseApp;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DownloadUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f19559d;

    /* renamed from: b  reason: collision with root package name */
    private d f19561b;

    /* renamed from: c  reason: collision with root package name */
    Handler f19562c = new HandlerC0214a();

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f19560a = new OkHttpClient();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.student.common.download.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class HandlerC0214a extends Handler {
        HandlerC0214a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i4 = msg.what;
            if (i4 == 2) {
                long j4 = msg.getData().getLong("total");
                long j5 = msg.getData().getLong("sum");
                int i5 = msg.getData().getInt("progress");
                if (a.this.f19561b != null) {
                    a.this.f19561b.b(j4, j5, i5);
                }
            } else if (i4 != 3) {
                if (i4 == 4 && a.this.f19561b != null) {
                    a.this.f19561b.onDownloadFailed();
                }
            } else if (a.this.f19561b != null) {
                a.this.f19561b.a((File) msg.obj);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DownloadUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19564a;

        b(final String val$url) {
            this.f19564a = val$url;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e4) {
            a.this.f19562c.sendEmptyMessage(4);
            e4.printStackTrace();
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 213
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.download.a.b.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DownloadUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19566a;

        c(final String val$fileName) {
            this.f19566a = val$fileName;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e4) {
            a.this.f19562c.sendEmptyMessage(4);
            e4.printStackTrace();
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 207
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.download.a.c.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DownloadUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface d {
        void a(File file);

        void b(long totalSize, long bytesWritten, int progress);

        void onDownloadFailed();
    }

    private a() {
    }

    public static a f() {
        if (f19559d == null) {
            f19559d = new a();
        }
        return f19559d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String g(String url) {
        return url.substring(url.lastIndexOf(TTPathConst.sSeparator) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() throws IOException {
        File externalFilesDir = new ContextWrapper(BaseApp.b()).getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (!externalFilesDir.mkdirs()) {
            externalFilesDir.createNewFile();
        }
        return externalFilesDir.getAbsolutePath();
    }

    public void d(final String url, final d listener) {
        this.f19561b = listener;
        this.f19560a.newCall(new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new b(url));
    }

    public void e(final String url, final String fileName, final d listener) {
        this.f19561b = listener;
        this.f19560a.newCall(new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new c(fileName));
    }
}
