package com.qq.e.comm.plugin.gdtnativead.p;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.g.a;
import com.qq.e.comm.plugin.o0.h.b;
import com.qq.e.comm.plugin.o0.h.c;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.o0.h.g;
import com.qq.e.comm.plugin.r0.h;
import com.qq.e.comm.plugin.util.f1;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends com.qq.e.comm.plugin.o0.h.c implements c.a, com.qq.e.comm.plugin.o0.h.b, a.InterfaceC0834a {
    private final Handler A;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.h.e f43926e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43927f;

    /* renamed from: g  reason: collision with root package name */
    private d f43928g;

    /* renamed from: h  reason: collision with root package name */
    private f f43929h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f43930i;

    /* renamed from: j  reason: collision with root package name */
    private com.qq.e.comm.plugin.r0.a f43931j;

    /* renamed from: k  reason: collision with root package name */
    private h f43932k;

    /* renamed from: l  reason: collision with root package name */
    private Context f43933l;

    /* renamed from: m  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.h.h f43934m;

    /* renamed from: n  reason: collision with root package name */
    private String f43935n;

    /* renamed from: o  reason: collision with root package name */
    private int f43936o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f43937p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f43938q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f43939r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f43940s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f43941t;

    /* renamed from: u  reason: collision with root package name */
    private final Context f43942u;

    /* renamed from: v  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g.a f43943v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f43944w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f43945x;

    /* renamed from: y  reason: collision with root package name */
    private View.OnClickListener f43946y;

    /* renamed from: z  reason: collision with root package name */
    private f.o f43947z;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.gdtnativead.p.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class View$OnClickListenerC0841a implements View.OnClickListener {
        View$OnClickListenerC0841a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f43928g != null && a.this.f43926e != null) {
                a.this.f43928g.b(a.this.f43926e.isPlaying());
            }
            a.this.b();
            a.this.a(3000, false);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d extends b.a {
        void a(boolean z3);

        void b(boolean z3);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f43952a;

        public e(a aVar) {
            this.f43952a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f43952a.get();
            if (aVar != null) {
                switch (message.what) {
                    case 10001:
                        if (aVar.f43926e != null && aVar.f43926e.isPlaying()) {
                            aVar.c();
                            return;
                        }
                        Message obtainMessage = obtainMessage(10001);
                        removeMessages(10001);
                        sendMessageDelayed(obtainMessage, 3000L);
                        return;
                    case 10002:
                        aVar.k();
                        if (aVar.f43926e == null || !aVar.f43926e.isPlaying()) {
                            return;
                        }
                        sendMessageDelayed(obtainMessage(10002), 500L);
                        return;
                    case 10003:
                        aVar.setEnabled(false);
                        return;
                    case 10004:
                        aVar.j();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface f {
        void a(long j4, long j5);
    }

    public a(Context context, int i4, String str, boolean z3, boolean z4) {
        super(context);
        this.f43945x = true;
        this.f43946y = new View$OnClickListenerC0841a();
        this.f43947z = new b();
        this.A = new e(this);
        this.f43935n = str;
        this.f43937p = z3;
        this.f43938q = z4;
        this.f43933l = context.getApplicationContext();
        this.f43942u = context;
        this.f43943v = new com.qq.e.comm.plugin.g.a(this);
        f();
        h();
    }

    @Override // com.qq.e.comm.plugin.o0.h.c.a
    public void a() {
    }

    public void a(com.qq.e.comm.plugin.n0.c cVar) {
    }

    @Override // android.view.View, com.qq.e.comm.plugin.o0.h.b
    public boolean isShown() {
        return this.f43927f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f43944w) {
            this.f43943v.a(this.f43942u);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.qq.e.comm.plugin.g.a aVar = this.f43943v;
        if (aVar == null || !this.f43944w) {
            return;
        }
        aVar.b(this.f43942u);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b
    public void show() {
        com.qq.e.comm.plugin.o0.h.e eVar = this.f43926e;
        if (eVar == null || eVar.getVideoState() == f.t.ERROR || this.f43926e.getVideoState() == f.t.UNINITIALIZED) {
            return;
        }
        a(3000, false);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements f.o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.o f43950a;

        c(f.o oVar) {
            this.f43950a = oVar;
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void a(int i4, Exception exc) {
            this.f43950a.a(i4, exc);
            a.this.f43947z.a(i4, exc);
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void b() {
            this.f43950a.b();
            a.this.f43947z.b();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void c() {
            this.f43950a.c();
            a.this.f43947z.c();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoComplete() {
            this.f43950a.onVideoComplete();
            a.this.f43947z.onVideoComplete();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoPause() {
            this.f43950a.onVideoPause();
            a.this.f43947z.onVideoPause();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoReady() {
            this.f43950a.onVideoReady();
            a.this.f43947z.onVideoReady();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoResume() {
            this.f43950a.onVideoResume();
            a.this.f43947z.onVideoResume();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStart() {
            this.f43950a.onVideoStart();
            a.this.f43947z.onVideoStart();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStop() {
            this.f43950a.onVideoStop();
            a.this.f43947z.onVideoStop();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void a() {
            this.f43950a.a();
            a.this.f43947z.a();
        }
    }

    private void d() {
        if (this.f43930i == null) {
            ImageView imageView = new ImageView(getContext());
            this.f43930i = imageView;
            imageView.setImageBitmap(g.b(this.f43933l));
            this.f43930i.setOnClickListener(this.f43946y);
        }
        int i4 = this.f43936o;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4);
        layoutParams.gravity = 17;
        this.f43930i.setVisibility(4);
        addView(this.f43930i, layoutParams);
        if (this.f43931j == null) {
            this.f43931j = new com.qq.e.comm.plugin.r0.a(getContext());
        }
        this.f43931j.setVisibility(4);
        addView(this.f43931j, layoutParams);
    }

    private void e() {
        if (this.f43934m == null && this.f43935n != null) {
            this.f43934m = new com.qq.e.comm.plugin.o0.h.h(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.f43934m, layoutParams);
            com.qq.e.comm.plugin.b0.b.a().a(this.f43935n, this.f43934m);
        }
        com.qq.e.comm.plugin.o0.h.h hVar = this.f43934m;
        if (hVar != null) {
            hVar.setVisibility(this.f43938q ? 0 : 4);
        }
    }

    private void f() {
        this.f43936o = f1.a(this.f43933l, 46);
        f1.a(this.f43933l, 56);
    }

    private void g() {
        if (this.f43932k == null) {
            h hVar = new h(getContext());
            this.f43932k = hVar;
            hVar.c(100);
            this.f43932k.a(true);
            this.f43932k.b(Color.parseColor("#66FFFFFF"));
            this.f43932k.setBackgroundColor(Color.parseColor("#33FFFFFF"));
        }
        this.f43932k.setVisibility(this.f43937p ? 0 : 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f1.a(this.f43933l, 2));
        layoutParams.gravity = 80;
        addView(this.f43932k, layoutParams);
    }

    private void h() {
        setBackgroundColor(0);
        a((c.a) this);
        e();
        g();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.qq.e.comm.plugin.o0.h.e eVar;
        if (this.f43930i == null || (eVar = this.f43926e) == null) {
            return;
        }
        if (eVar.isPlaying()) {
            this.f43930i.setImageBitmap(g.a(this.f43933l));
        } else {
            this.f43930i.setImageBitmap(g.b(this.f43933l));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        com.qq.e.comm.plugin.o0.h.e eVar = this.f43926e;
        if (eVar == null) {
            return 0;
        }
        int currentPosition = eVar.getCurrentPosition();
        int duration = this.f43926e.getDuration();
        h hVar = this.f43932k;
        if (hVar != null && duration > 0) {
            hVar.a((currentPosition * 100) / duration);
        }
        f fVar = this.f43929h;
        if (fVar != null) {
            fVar.a(currentPosition, duration);
        }
        return currentPosition;
    }

    public void c(boolean z3) {
        this.f43945x = z3;
    }

    public void i() {
        Handler handler = this.A;
        if (handler != null) {
            handler.removeMessages(10002);
            this.A.removeMessages(10001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.qq.e.comm.plugin.o0.h.e eVar = this.f43926e;
        if (eVar != null) {
            if (eVar.isPlaying()) {
                this.f43926e.pause();
            } else {
                this.f43926e.play();
            }
        }
        this.A.sendEmptyMessageDelayed(10004, 100L);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b
    public void a(com.qq.e.comm.plugin.o0.h.e eVar) {
        this.f43926e = eVar;
        f.o d4 = eVar.d();
        if (d4 != null && this.f43947z != null) {
            this.f43926e.a(new c(d4));
        } else {
            this.f43926e.a(this.f43947z);
        }
        j();
        if (eVar.isPlaying()) {
            this.A.sendEmptyMessage(10002);
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.b
    public void c() {
        ImageView imageView;
        if (!this.f43927f || (imageView = this.f43930i) == null) {
            return;
        }
        imageView.setVisibility(4);
        this.f43927f = false;
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements f.o {
        b() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void a(int i4, Exception exc) {
            a.this.A.sendEmptyMessage(10003);
            if (a.this.f43928g != null) {
                a.this.f43928g.a(i4, exc);
            }
            if (a.this.f43934m == null || !a.this.f43938q) {
                return;
            }
            a.this.f43934m.setVisibility(0);
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void b() {
            if (a.this.f43928g != null) {
                a.this.f43928g.b();
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void c() {
            a.this.f43941t = false;
            if (a.this.f43940s && a.this.f43931j != null) {
                a.this.f43931j.c();
                a.this.f43931j.setVisibility(4);
            }
            if (a.this.f43928g != null) {
                a.this.f43928g.a(false);
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoComplete() {
            a.this.A.removeMessages(10002);
            if (a.this.f43932k != null) {
                a.this.f43932k.a(100);
            }
            if (a.this.f43928g != null) {
                a.this.f43928g.onVideoComplete();
            }
            if (a.this.f43934m != null && a.this.f43938q) {
                a.this.f43934m.setVisibility(0);
            }
            if (a.this.f43945x) {
                a.this.d(true);
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoPause() {
            a.this.A.removeMessages(10002);
            if (a.this.f43939r && a.this.f43934m != null) {
                a.this.f43934m.setVisibility(0);
            }
            if (a.this.f43928g != null) {
                a.this.f43928g.onVideoPause();
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoReady() {
            if (a.this.f43928g != null) {
                a.this.f43928g.onVideoReady();
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoResume() {
            a.this.A.sendEmptyMessage(10002);
            if (a.this.f43934m != null) {
                a.this.f43934m.setVisibility(4);
            }
            a.this.j();
            if (a.this.f43928g != null) {
                a.this.f43928g.onVideoResume();
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStart() {
            a.this.A.sendEmptyMessage(10002);
            if (a.this.f43934m != null) {
                a.this.f43934m.setVisibility(4);
            }
            if (a.this.f43928g != null) {
                a.this.f43928g.onVideoStart();
            }
            a.this.j();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStop() {
            a.this.A.removeMessages(10002);
            if (a.this.f43932k != null) {
                a.this.f43932k.a(100);
            }
            if (a.this.f43934m != null && a.this.f43938q) {
                a.this.f43934m.setVisibility(0);
            }
            if (a.this.f43928g != null) {
                a.this.f43928g.onVideoStop();
            }
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void a() {
            a.this.f43941t = true;
            if (a.this.f43940s && a.this.f43931j != null) {
                a.this.f43931j.setVisibility(0);
                a.this.f43931j.b();
            }
            if (a.this.f43928g != null) {
                a.this.f43928g.a(true);
            }
        }
    }

    public void b(boolean z3) {
        this.f43944w = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z3) {
        com.qq.e.comm.plugin.o0.h.e eVar = this.f43926e;
        if (eVar == null || eVar.getVideoState() == f.t.ERROR || this.f43926e.getVideoState() == f.t.UNINITIALIZED) {
            return;
        }
        a(3000, z3);
    }

    public void a(boolean z3) {
        com.qq.e.comm.plugin.r0.a aVar;
        this.f43940s = z3;
        if (z3 && this.f43941t) {
            com.qq.e.comm.plugin.r0.a aVar2 = this.f43931j;
            if (aVar2 != null) {
                aVar2.setVisibility(0);
                this.f43931j.b();
            }
        } else if (z3 || (aVar = this.f43931j) == null) {
        } else {
            aVar.c();
            this.f43931j.setVisibility(4);
        }
    }

    public void a(boolean z3, boolean z4) {
        com.qq.e.comm.plugin.o0.h.h hVar;
        this.f43939r = z3;
        if (!z4 || (hVar = this.f43934m) == null) {
            return;
        }
        if (z3) {
            com.qq.e.comm.plugin.o0.h.e eVar = this.f43926e;
            if (eVar == null || eVar.getVideoState() != f.t.PAUSE) {
                return;
            }
            this.f43934m.setVisibility(0);
            return;
        }
        hVar.setVisibility(4);
    }

    public void a(int i4, boolean z3) {
        a(i4, z3, 100L);
    }

    public void a(long j4) {
        a(3000, false, j4);
    }

    private void a(int i4, boolean z3, long j4) {
        ImageView imageView;
        if (!this.f43927f && (imageView = this.f43930i) != null) {
            this.f43927f = true;
            imageView.setVisibility(0);
        }
        this.A.sendEmptyMessageDelayed(10004, j4);
        Message obtainMessage = this.A.obtainMessage(10001);
        if (i4 != 0) {
            this.A.removeMessages(10001);
            this.A.sendMessageDelayed(obtainMessage, i4);
        }
    }

    public void a(b.a aVar) {
        if (aVar instanceof d) {
            this.f43928g = (d) aVar;
        }
    }

    public void a(int i4, int i5) {
        com.qq.e.comm.plugin.o0.h.h hVar = this.f43934m;
        if (hVar != null) {
            hVar.a(i4, i5);
        }
    }

    @Override // com.qq.e.comm.plugin.g.a.InterfaceC0834a
    public void a(float f4) {
        com.qq.e.comm.plugin.o0.h.e eVar = this.f43926e;
        if (eVar != null) {
            if (f4 > 0.0f) {
                eVar.a();
            } else {
                eVar.c();
            }
        }
    }

    public a(Context context, int i4, String str) {
        this(context, i4, str, true, true);
    }
}
