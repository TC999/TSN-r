package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0463l.DownloadManager;
import com.amap.api.col.p0463l.Privacy;
import com.stub.StubApp;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.ca */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AuthTaskDownload implements DownloadManager.InterfaceC1941a {

    /* renamed from: a */
    private final Context f3759a;

    /* renamed from: b */
    private RandomAccessFile f3760b;

    /* renamed from: c */
    private TimeoutDownloadManager f3761c;

    /* renamed from: d */
    private String f3762d;

    /* renamed from: e */
    C1758a f3763e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1758a {

        /* renamed from: a */
        protected String f3764a;

        /* renamed from: b */
        protected String f3765b;

        /* renamed from: c */
        protected String f3766c;

        /* renamed from: d */
        protected String f3767d;

        /* renamed from: e */
        protected String f3768e;

        /* renamed from: f */
        protected C1760c f3769f;

        public C1758a(String str, String str2, String str3, String str4) {
            this.f3764a = str;
            this.f3765b = str2;
            this.f3766c = str3;
            this.f3767d = str4 + ".tmp";
            this.f3768e = str4;
        }

        /* renamed from: a */
        public final String m55435a() {
            return this.f3764a;
        }

        /* renamed from: b */
        public final void m55434b(C1760c c1760c) {
            this.f3769f = c1760c;
        }

        /* renamed from: c */
        public final String m55433c() {
            return this.f3765b;
        }

        /* renamed from: d */
        public final String m55432d() {
            return this.f3767d;
        }

        /* renamed from: e */
        public final String m55431e() {
            return this.f3768e;
        }

        /* renamed from: f */
        public final C1760c m55430f() {
            return this.f3769f;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1759b extends AbstractAMapRequest {

        /* renamed from: i */
        private final C1758a f3770i;

        C1759b(C1758a c1758a) {
            this.f3770i = c1758a;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final String getURL() {
            C1758a c1758a = this.f3770i;
            if (c1758a != null) {
                return c1758a.m55435a();
            }
            return null;
        }

        @Override // com.amap.api.col.p0463l.AbstractC1840if
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1760c {

        /* renamed from: a */
        protected String f3771a;

        /* renamed from: b */
        protected String f3772b;

        public C1760c(String str, String str2) {
            this.f3771a = str;
            this.f3772b = str2;
        }

        /* renamed from: a */
        public final String m55429a() {
            return this.f3771a;
        }

        /* renamed from: b */
        public final String m55428b() {
            return this.f3772b;
        }

        /* renamed from: c */
        public final boolean m55427c() {
            return (TextUtils.isEmpty(this.f3771a) || TextUtils.isEmpty(this.f3772b)) ? false : true;
        }
    }

    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.ca$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1761d extends C1758a {
        public C1761d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        /* renamed from: g */
        public final void m55426g(String str, String str2) {
            m55434b(new C1760c(str, str2));
        }
    }

    public AuthTaskDownload(Context context, C1758a c1758a) {
        this.f3759a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f3763e = c1758a;
        this.f3761c = new TimeoutDownloadManager(new C1759b(c1758a));
        this.f3762d = c1758a.m55432d();
    }

    /* renamed from: b */
    private boolean m55436b() {
        C1760c m55430f = this.f3763e.m55430f();
        return (m55430f != null && m55430f.m55427c() && PreferenceTools.m54147b(this.f3759a, m55430f.m55429a(), m55430f.m55428b(), "").equalsIgnoreCase(this.f3763e.m55433c())) ? false : true;
    }

    /* renamed from: a */
    public final void m55437a() {
        TimeoutDownloadManager timeoutDownloadManager;
        if (MapFragmentDelegateImp.f3708f == null || Privacy.m54995a(MapFragmentDelegateImp.f3708f, C1732a3.m55691s()).f4676a == Privacy.EnumC1812c.SuccessCode) {
            try {
                if (!m55436b() || (timeoutDownloadManager = this.f3761c) == null) {
                    return;
                }
                timeoutDownloadManager.m53927b(this);
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onDownload(byte[] bArr, long j) {
        try {
            if (this.f3760b == null) {
                File file = new File(this.f3762d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f3760b = new RandomAccessFile(file, "rw");
            }
            this.f3760b.seek(j);
            this.f3760b.write(bArr);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.f3760b;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            SDKLogHandler.m53863p(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onFinish() {
        try {
            RandomAccessFile randomAccessFile = this.f3760b;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
            String m55433c = this.f3763e.m55433c();
            String m54586a = C1849l4.m54586a(this.f3762d);
            if (m54586a != null && m55433c.equalsIgnoreCase(m54586a)) {
                String m55431e = this.f3763e.m55431e();
                FileCopy fileCopy = new FileCopy();
                File file = new File(this.f3762d);
                fileCopy.m53897b(file, new File(m55431e), -1L, Utility.m53352b(file), null);
                C1760c m55430f = this.f3763e.m55430f();
                if (m55430f != null && m55430f.m55427c()) {
                    PreferenceTools.m54146c(this.f3759a, m55430f.m55429a(), m55430f.m55428b(), m54586a);
                }
                new File(this.f3762d).delete();
                return;
            }
            new File(this.f3762d).delete();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a
    public final void onStop() {
    }
}
