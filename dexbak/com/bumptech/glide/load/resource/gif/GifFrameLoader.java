package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.C3558j;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.resource.gif.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifFrameLoader {

    /* renamed from: a */
    private final GifDecoder f14220a;

    /* renamed from: b */
    private final Handler f14221b;

    /* renamed from: c */
    private final List<InterfaceC3731b> f14222c;

    /* renamed from: d */
    final C3558j f14223d;

    /* renamed from: e */
    private final BitmapPool f14224e;

    /* renamed from: f */
    private boolean f14225f;

    /* renamed from: g */
    private boolean f14226g;

    /* renamed from: h */
    private boolean f14227h;

    /* renamed from: i */
    private RequestBuilder<Bitmap> f14228i;

    /* renamed from: j */
    private C3730a f14229j;

    /* renamed from: k */
    private boolean f14230k;

    /* renamed from: l */
    private C3730a f14231l;

    /* renamed from: m */
    private Bitmap f14232m;

    /* renamed from: n */
    private Transformation<Bitmap> f14233n;

    /* renamed from: o */
    private C3730a f14234o;
    @Nullable

    /* renamed from: p */
    private InterfaceC3733d f14235p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3730a extends SimpleTarget<Bitmap> {

        /* renamed from: d */
        private final Handler f14236d;

        /* renamed from: e */
        final int f14237e;

        /* renamed from: f */
        private final long f14238f;

        /* renamed from: g */
        private Bitmap f14239g;

        C3730a(Handler handler, int i, long j) {
            this.f14236d = handler;
            this.f14237e = i;
            this.f14238f = j;
        }

        /* renamed from: d */
        Bitmap m44798d() {
            return this.f14239g;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: e */
        public void mo44364k(@NonNull Bitmap bitmap, @Nullable InterfaceC3759f<? super Bitmap> interfaceC3759f) {
            this.f14239g = bitmap;
            this.f14236d.sendMessageAtTime(this.f14236d.obtainMessage(1, this), this.f14238f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: com.bumptech.glide.load.resource.gif.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3731b {
        /* renamed from: a */
        void mo44796a();
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: com.bumptech.glide.load.resource.gif.f$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3732c implements Handler.Callback {

        /* renamed from: b */
        static final int f14240b = 1;

        /* renamed from: c */
        static final int f14241c = 2;

        C3732c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.m44807p((C3730a) message.obj);
                return true;
            } else if (i == 2) {
                GifFrameLoader.this.f14223d.m45490z((C3730a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.f$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3733d {
        /* renamed from: a */
        void m44795a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.m45741g(), Glide.m45751C(glide.getContext()), gifDecoder, null, m44811l(Glide.m45751C(glide.getContext()), i, i2), transformation, bitmap);
    }

    /* renamed from: g */
    private static Key m44816g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    /* renamed from: h */
    private int m44815h() {
        return C3771k.m44384g(m44820c().getWidth(), m44820c().getHeight(), m44820c().getConfig());
    }

    /* renamed from: l */
    private static RequestBuilder<Bitmap> m44811l(C3558j c3558j, int i, int i2) {
        return c3558j.m45495u().mo44636b(RequestOptions.m44578X0(DiskCacheStrategy.f13787b).m44648Q0(true).m44668G0(true).m44603v0(i, i2));
    }

    /* renamed from: o */
    private void m44808o() {
        if (!this.f14225f || this.f14226g) {
            return;
        }
        if (this.f14227h) {
            C3770j.m44395a(this.f14234o == null, "Pending target must be null when starting from the first frame");
            this.f14220a.mo45587j();
            this.f14227h = false;
        }
        C3730a c3730a = this.f14234o;
        if (c3730a != null) {
            this.f14234o = null;
            m44807p(c3730a);
            return;
        }
        this.f14226g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f14220a.mo45588i();
        this.f14220a.mo45595b();
        this.f14231l = new C3730a(this.f14221b, this.f14220a.mo45585l(), uptimeMillis);
        this.f14228i.mo44636b(RequestOptions.m44561o1(m44816g())).mo45500o(this.f14220a).m45554f1(this.f14231l);
    }

    /* renamed from: q */
    private void m44806q() {
        Bitmap bitmap = this.f14232m;
        if (bitmap != null) {
            this.f14224e.mo44924d(bitmap);
            this.f14232m = null;
        }
    }

    /* renamed from: u */
    private void m44802u() {
        if (this.f14225f) {
            return;
        }
        this.f14225f = true;
        this.f14230k = false;
        m44808o();
    }

    /* renamed from: v */
    private void m44801v() {
        this.f14225f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m44822a() {
        this.f14222c.clear();
        m44806q();
        m44801v();
        C3730a c3730a = this.f14229j;
        if (c3730a != null) {
            this.f14223d.m45490z(c3730a);
            this.f14229j = null;
        }
        C3730a c3730a2 = this.f14231l;
        if (c3730a2 != null) {
            this.f14223d.m45490z(c3730a2);
            this.f14231l = null;
        }
        C3730a c3730a3 = this.f14234o;
        if (c3730a3 != null) {
            this.f14223d.m45490z(c3730a3);
            this.f14234o = null;
        }
        this.f14220a.clear();
        this.f14230k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public ByteBuffer m44821b() {
        return this.f14220a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Bitmap m44820c() {
        C3730a c3730a = this.f14229j;
        return c3730a != null ? c3730a.m44798d() : this.f14232m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m44819d() {
        C3730a c3730a = this.f14229j;
        if (c3730a != null) {
            return c3730a.f14237e;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Bitmap m44818e() {
        return this.f14232m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public int m44817f() {
        return this.f14220a.mo45594c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Transformation<Bitmap> m44814i() {
        return this.f14233n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public int m44813j() {
        return m44820c().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public int m44812k() {
        return this.f14220a.mo45591f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public int m44810m() {
        return this.f14220a.mo45581p() + m44815h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public int m44809n() {
        return m44820c().getWidth();
    }

    @VisibleForTesting
    /* renamed from: p */
    void m44807p(C3730a c3730a) {
        InterfaceC3733d interfaceC3733d = this.f14235p;
        if (interfaceC3733d != null) {
            interfaceC3733d.m44795a();
        }
        this.f14226g = false;
        if (this.f14230k) {
            this.f14221b.obtainMessage(2, c3730a).sendToTarget();
        } else if (!this.f14225f) {
            this.f14234o = c3730a;
        } else {
            if (c3730a.m44798d() != null) {
                m44806q();
                C3730a c3730a2 = this.f14229j;
                this.f14229j = c3730a;
                for (int size = this.f14222c.size() - 1; size >= 0; size--) {
                    this.f14222c.get(size).mo44796a();
                }
                if (c3730a2 != null) {
                    this.f14221b.obtainMessage(2, c3730a2).sendToTarget();
                }
            }
            m44808o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m44805r(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f14233n = (Transformation) C3770j.m44392d(transformation);
        this.f14232m = (Bitmap) C3770j.m44392d(bitmap);
        this.f14228i = this.f14228i.mo44636b(new RequestOptions().m44662J0(transformation));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public void m44804s() {
        C3770j.m44395a(!this.f14225f, "Can't restart a running animation");
        this.f14227h = true;
        C3730a c3730a = this.f14234o;
        if (c3730a != null) {
            this.f14223d.m45490z(c3730a);
            this.f14234o = null;
        }
    }

    @VisibleForTesting
    /* renamed from: t */
    void m44803t(@Nullable InterfaceC3733d interfaceC3733d) {
        this.f14235p = interfaceC3733d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public void m44800w(InterfaceC3731b interfaceC3731b) {
        if (!this.f14230k) {
            if (!this.f14222c.contains(interfaceC3731b)) {
                boolean isEmpty = this.f14222c.isEmpty();
                this.f14222c.add(interfaceC3731b);
                if (isEmpty) {
                    m44802u();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public void m44799x(InterfaceC3731b interfaceC3731b) {
        this.f14222c.remove(interfaceC3731b);
        if (this.f14222c.isEmpty()) {
            m44801v();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, C3558j c3558j, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f14222c = new ArrayList();
        this.f14223d = c3558j;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new C3732c()) : handler;
        this.f14224e = bitmapPool;
        this.f14221b = handler;
        this.f14228i = requestBuilder;
        this.f14220a = gifDecoder;
        m44805r(transformation, bitmap);
    }
}
