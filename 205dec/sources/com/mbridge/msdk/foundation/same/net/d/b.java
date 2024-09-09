package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.same.net.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: FileDownloader.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private j f39522a;

    /* renamed from: b  reason: collision with root package name */
    private int f39523b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<a> f39524c = new LinkedList<>();

    /* compiled from: FileDownloader.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private String f39526b;

        /* renamed from: c  reason: collision with root package name */
        private File f39527c;

        /* renamed from: d  reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.net.e<Void> f39528d;

        /* renamed from: e  reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.net.d.a f39529e;

        /* renamed from: f  reason: collision with root package name */
        private int f39530f;

        private a(File file, String str, com.mbridge.msdk.foundation.same.net.e<Void> eVar) {
            this.f39527c = file;
            this.f39528d = eVar;
            this.f39526b = str;
        }

        public final boolean a() {
            return this.f39530f == 1;
        }

        static /* synthetic */ boolean a(a aVar) {
            if (aVar.f39530f != 0) {
                return false;
            }
            com.mbridge.msdk.foundation.same.net.d.a aVar2 = new com.mbridge.msdk.foundation.same.net.d.a(aVar.f39527c, aVar.f39526b);
            aVar.f39529e = aVar2;
            aVar2.a(new com.mbridge.msdk.foundation.same.net.f<Void>() { // from class: com.mbridge.msdk.foundation.same.net.d.b.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f39531a;

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a() {
                    a.this.f39528d.a();
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void b() {
                    if (this.f39531a) {
                        return;
                    }
                    a.this.f39530f = 3;
                    a.this.f39528d.b();
                    a aVar3 = a.this;
                    b.a(b.this, aVar3);
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void c() {
                    a.this.f39528d.c();
                    this.f39531a = true;
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a(k kVar) {
                    if (this.f39531a) {
                        return;
                    }
                    a.this.f39528d.a(kVar);
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar3) {
                    if (this.f39531a) {
                        return;
                    }
                    a.this.f39528d.a(aVar3);
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a(long j4, long j5) {
                    a.this.f39528d.a(j4, j5);
                }
            });
            aVar.f39530f = 1;
            b.this.f39522a.a(aVar.f39529e);
            return true;
        }
    }

    public b(j jVar, int i4) {
        this.f39522a = jVar;
        this.f39523b = i4;
    }

    public final a a(File file, String str, com.mbridge.msdk.foundation.same.net.e<Void> eVar) {
        a aVar = new a(file, str, eVar);
        synchronized (this) {
            this.f39524c.add(aVar);
        }
        a();
        return aVar;
    }

    private void a() {
        synchronized (this) {
            int i4 = 0;
            Iterator<a> it = this.f39524c.iterator();
            while (it.hasNext()) {
                if (it.next().a()) {
                    i4++;
                }
            }
            if (i4 >= this.f39523b) {
                return;
            }
            Iterator<a> it2 = this.f39524c.iterator();
            while (it2.hasNext()) {
                if (a.a(it2.next()) && (i4 = i4 + 1) == this.f39523b) {
                    return;
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        synchronized (bVar) {
            bVar.f39524c.remove(aVar);
        }
        bVar.a();
    }
}
