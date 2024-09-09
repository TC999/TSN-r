package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.j;
import com.bumptech.glide.request.target.n;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifFrameLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final GifDecoder f17537a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17538b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f17539c;

    /* renamed from: d  reason: collision with root package name */
    final j f17540d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17541e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17542f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17543g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17544h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.i<Bitmap> f17545i;

    /* renamed from: j  reason: collision with root package name */
    private a f17546j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17547k;

    /* renamed from: l  reason: collision with root package name */
    private a f17548l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f17549m;

    /* renamed from: n  reason: collision with root package name */
    private com.bumptech.glide.load.i<Bitmap> f17550n;

    /* renamed from: o  reason: collision with root package name */
    private a f17551o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private d f17552p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a extends n<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        private final Handler f17553d;

        /* renamed from: e  reason: collision with root package name */
        final int f17554e;

        /* renamed from: f  reason: collision with root package name */
        private final long f17555f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap f17556g;

        a(Handler handler, int i4, long j4) {
            this.f17553d = handler;
            this.f17554e = i4;
            this.f17555f = j4;
        }

        Bitmap d() {
            return this.f17556g;
        }

        @Override // com.bumptech.glide.request.target.p
        /* renamed from: e */
        public void k(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.transition.f<? super Bitmap> fVar) {
            this.f17556g = bitmap;
            this.f17553d.sendMessageAtTime(this.f17553d.obtainMessage(1, this), this.f17555f);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class c implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        static final int f17557b = 1;

        /* renamed from: c  reason: collision with root package name */
        static final int f17558c = 2;

        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                f.this.p((a) message.obj);
                return true;
            } else if (i4 == 2) {
                f.this.f17540d.z((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.bumptech.glide.d dVar, GifDecoder gifDecoder, int i4, int i5, com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this(dVar.g(), com.bumptech.glide.d.C(dVar.getContext()), gifDecoder, null, l(com.bumptech.glide.d.C(dVar.getContext()), i4, i5), iVar, bitmap);
    }

    private static com.bumptech.glide.load.c g() {
        return new com.bumptech.glide.signature.d(Double.valueOf(Math.random()));
    }

    private int h() {
        return k.g(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private static com.bumptech.glide.i<Bitmap> l(j jVar, int i4, int i5) {
        return jVar.u().b(com.bumptech.glide.request.h.X0(com.bumptech.glide.load.engine.j.f17104b).Q0(true).G0(true).v0(i4, i5));
    }

    private void o() {
        if (!this.f17542f || this.f17543g) {
            return;
        }
        if (this.f17544h) {
            com.bumptech.glide.util.j.a(this.f17551o == null, "Pending target must be null when starting from the first frame");
            this.f17537a.j();
            this.f17544h = false;
        }
        a aVar = this.f17551o;
        if (aVar != null) {
            this.f17551o = null;
            p(aVar);
            return;
        }
        this.f17543g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f17537a.i();
        this.f17537a.b();
        this.f17548l = new a(this.f17538b, this.f17537a.l(), uptimeMillis);
        this.f17545i.b(com.bumptech.glide.request.h.o1(g())).o(this.f17537a).f1(this.f17548l);
    }

    private void q() {
        Bitmap bitmap = this.f17549m;
        if (bitmap != null) {
            this.f17541e.d(bitmap);
            this.f17549m = null;
        }
    }

    private void u() {
        if (this.f17542f) {
            return;
        }
        this.f17542f = true;
        this.f17547k = false;
        o();
    }

    private void v() {
        this.f17542f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f17539c.clear();
        q();
        v();
        a aVar = this.f17546j;
        if (aVar != null) {
            this.f17540d.z(aVar);
            this.f17546j = null;
        }
        a aVar2 = this.f17548l;
        if (aVar2 != null) {
            this.f17540d.z(aVar2);
            this.f17548l = null;
        }
        a aVar3 = this.f17551o;
        if (aVar3 != null) {
            this.f17540d.z(aVar3);
            this.f17551o = null;
        }
        this.f17537a.clear();
        this.f17547k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f17537a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f17546j;
        return aVar != null ? aVar.d() : this.f17549m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f17546j;
        if (aVar != null) {
            return aVar.f17554e;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f17549m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f17537a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.i<Bitmap> i() {
        return this.f17550n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return c().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f17537a.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f17537a.p() + h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return c().getWidth();
    }

    @VisibleForTesting
    void p(a aVar) {
        d dVar = this.f17552p;
        if (dVar != null) {
            dVar.a();
        }
        this.f17543g = false;
        if (this.f17547k) {
            this.f17538b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f17542f) {
            this.f17551o = aVar;
        } else {
            if (aVar.d() != null) {
                q();
                a aVar2 = this.f17546j;
                this.f17546j = aVar;
                for (int size = this.f17539c.size() - 1; size >= 0; size--) {
                    this.f17539c.get(size).a();
                }
                if (aVar2 != null) {
                    this.f17538b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.f17550n = (com.bumptech.glide.load.i) com.bumptech.glide.util.j.d(iVar);
        this.f17549m = (Bitmap) com.bumptech.glide.util.j.d(bitmap);
        this.f17545i = this.f17545i.b(new com.bumptech.glide.request.h().J0(iVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        com.bumptech.glide.util.j.a(!this.f17542f, "Can't restart a running animation");
        this.f17544h = true;
        a aVar = this.f17551o;
        if (aVar != null) {
            this.f17540d.z(aVar);
            this.f17551o = null;
        }
    }

    @VisibleForTesting
    void t(@Nullable d dVar) {
        this.f17552p = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(b bVar) {
        if (!this.f17547k) {
            if (!this.f17539c.contains(bVar)) {
                boolean isEmpty = this.f17539c.isEmpty();
                this.f17539c.add(bVar);
                if (isEmpty) {
                    u();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(b bVar) {
        this.f17539c.remove(bVar);
        if (this.f17539c.isEmpty()) {
            v();
        }
    }

    f(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, j jVar, GifDecoder gifDecoder, Handler handler, com.bumptech.glide.i<Bitmap> iVar, com.bumptech.glide.load.i<Bitmap> iVar2, Bitmap bitmap) {
        this.f17539c = new ArrayList();
        this.f17540d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f17541e = eVar;
        this.f17538b = handler;
        this.f17545i = iVar;
        this.f17537a = gifDecoder;
        r(iVar2, bitmap);
    }
}
