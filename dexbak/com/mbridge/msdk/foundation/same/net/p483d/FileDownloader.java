package com.mbridge.msdk.foundation.same.net.p483d;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.IListener;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.RequestQueue;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.mbridge.msdk.foundation.same.net.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class FileDownloader {

    /* renamed from: a */
    private RequestQueue f30728a;

    /* renamed from: b */
    private int f30729b;

    /* renamed from: c */
    private LinkedList<C11346a> f30730c = new LinkedList<>();

    /* compiled from: FileDownloader.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.d.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C11346a {

        /* renamed from: b */
        private String f30732b;

        /* renamed from: c */
        private File f30733c;

        /* renamed from: d */
        private IListener<Void> f30734d;

        /* renamed from: e */
        private FileDownloadRequest f30735e;

        /* renamed from: f */
        private int f30736f;

        private C11346a(File file, String str, IListener<Void> iListener) {
            this.f30733c = file;
            this.f30734d = iListener;
            this.f30732b = str;
        }

        /* renamed from: a */
        public final boolean m22277a() {
            return this.f30736f == 1;
        }

        /* renamed from: a */
        static /* synthetic */ boolean m22276a(C11346a c11346a) {
            if (c11346a.f30736f != 0) {
                return false;
            }
            FileDownloadRequest fileDownloadRequest = new FileDownloadRequest(c11346a.f30733c, c11346a.f30732b);
            c11346a.f30735e = fileDownloadRequest;
            fileDownloadRequest.m22204a(new Listener<Void>() { // from class: com.mbridge.msdk.foundation.same.net.d.b.a.1

                /* renamed from: a */
                boolean f30737a;

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo21053a() {
                    C11346a.this.f30734d.mo21053a();
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: b */
                public final void mo22264b() {
                    if (this.f30737a) {
                        return;
                    }
                    C11346a.this.f30736f = 3;
                    C11346a.this.f30734d.mo22264b();
                    C11346a c11346a2 = C11346a.this;
                    FileDownloader.m22279a(FileDownloader.this, c11346a2);
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: c */
                public final void mo22262c() {
                    C11346a.this.f30734d.mo22262c();
                    this.f30737a = true;
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo21051a(C11356k c11356k) {
                    if (this.f30737a) {
                        return;
                    }
                    C11346a.this.f30734d.mo21051a(c11356k);
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo21052a(CommonError commonError) {
                    if (this.f30737a) {
                        return;
                    }
                    C11346a.this.f30734d.mo21052a(commonError);
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo22265a(long j, long j2) {
                    C11346a.this.f30734d.mo22265a(j, j2);
                }
            });
            c11346a.f30736f = 1;
            FileDownloader.this.f30728a.m22180a(c11346a.f30735e);
            return true;
        }
    }

    public FileDownloader(RequestQueue requestQueue, int i) {
        this.f30728a = requestQueue;
        this.f30729b = i;
    }

    /* renamed from: a */
    public final C11346a m22278a(File file, String str, IListener<Void> iListener) {
        C11346a c11346a = new C11346a(file, str, iListener);
        synchronized (this) {
            this.f30730c.add(c11346a);
        }
        m22281a();
        return c11346a;
    }

    /* renamed from: a */
    private void m22281a() {
        synchronized (this) {
            int i = 0;
            Iterator<C11346a> it = this.f30730c.iterator();
            while (it.hasNext()) {
                if (it.next().m22277a()) {
                    i++;
                }
            }
            if (i >= this.f30729b) {
                return;
            }
            Iterator<C11346a> it2 = this.f30730c.iterator();
            while (it2.hasNext()) {
                if (C11346a.m22276a(it2.next()) && (i = i + 1) == this.f30729b) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22279a(FileDownloader fileDownloader, C11346a c11346a) {
        synchronized (fileDownloader) {
            fileDownloader.f30730c.remove(c11346a);
        }
        fileDownloader.m22281a();
    }
}
