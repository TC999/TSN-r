package com.bxkj.student.common.download;

import android.content.ContextWrapper;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bxkj.base.BaseApp;
import java.io.File;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: DownloadUtil.java */
/* renamed from: com.bxkj.student.common.download.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C4238a {

    /* renamed from: d */
    private static C4238a f16165d;

    /* renamed from: b */
    private InterfaceC4242d f16167b;

    /* renamed from: c */
    Handler f16168c = new HandlerC4239a();

    /* renamed from: a */
    private final OkHttpClient f16166a = new OkHttpClient();

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.student.common.download.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC4239a extends Handler {
        HandlerC4239a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = msg.what;
            if (i == 2) {
                long j = msg.getData().getLong("total");
                long j2 = msg.getData().getLong("sum");
                int i2 = msg.getData().getInt(NotificationCompat.CATEGORY_PROGRESS);
                if (C4238a.this.f16167b != null) {
                    C4238a.this.f16167b.mo42761b(j, j2, i2);
                }
            } else if (i != 3) {
                if (i == 4 && C4238a.this.f16167b != null) {
                    C4238a.this.f16167b.onDownloadFailed();
                }
            } else if (C4238a.this.f16167b != null) {
                C4238a.this.f16167b.mo42762a((File) msg.obj);
            }
        }
    }

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.student.common.download.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4240b implements Callback {

        /* renamed from: a */
        final /* synthetic */ String f16170a;

        C4240b(final String val$url) {
            this.f16170a = val$url;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e) {
            C4238a.this.f16168c.sendEmptyMessage(4);
            e.printStackTrace();
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.download.C4238a.C4240b.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.student.common.download.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4241c implements Callback {

        /* renamed from: a */
        final /* synthetic */ String f16172a;

        C4241c(final String val$fileName) {
            this.f16172a = val$fileName;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e) {
            C4238a.this.f16168c.sendEmptyMessage(4);
            e.printStackTrace();
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.common.download.C4238a.C4241c.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* compiled from: DownloadUtil.java */
    /* renamed from: com.bxkj.student.common.download.a$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4242d {
        /* renamed from: a */
        void mo42762a(File file);

        /* renamed from: b */
        void mo42761b(long totalSize, long bytesWritten, int progress);

        void onDownloadFailed();
    }

    private C4238a() {
    }

    /* renamed from: f */
    public static C4238a m42909f() {
        if (f16165d == null) {
            f16165d = new C4238a();
        }
        return f16165d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: g */
    public String m42908g(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public String m42907h() throws IOException {
        File externalFilesDir = new ContextWrapper(BaseApp.m44341b()).getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (!externalFilesDir.mkdirs()) {
            externalFilesDir.createNewFile();
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* renamed from: d */
    public void m42911d(final String url, final InterfaceC4242d listener) {
        this.f16167b = listener;
        this.f16166a.newCall(new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new C4240b(url));
    }

    /* renamed from: e */
    public void m42910e(final String url, final String fileName, final InterfaceC4242d listener) {
        this.f16167b = listener;
        this.f16166a.newCall(new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new C4241c(fileName));
    }
}
