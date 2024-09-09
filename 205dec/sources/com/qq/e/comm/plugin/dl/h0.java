package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.dl.n;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.n2;
import com.qq.e.dl.l.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h0 extends com.qq.e.dl.l.a<b> {

    /* renamed from: y  reason: collision with root package name */
    private static final List<String> f42443y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    public static final boolean f42444z;

    /* renamed from: x  reason: collision with root package name */
    private final Map<String, com.qq.e.dl.k.g> f42445x;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new h0(aVar);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends FrameLayout implements com.qq.e.dl.l.e<h0> {

        /* renamed from: c  reason: collision with root package name */
        private final FrameLayout.LayoutParams f42446c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f42447d;

        /* renamed from: e  reason: collision with root package name */
        private h0 f42448e;

        /* renamed from: f  reason: collision with root package name */
        private com.qq.e.comm.plugin.o0.h.f f42449f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f42450g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f42451h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f42452i;

        /* renamed from: j  reason: collision with root package name */
        private d f42453j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f42454k;

        /* renamed from: l  reason: collision with root package name */
        private f.o f42455l;

        /* renamed from: m  reason: collision with root package name */
        private c f42456m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class a implements f.o {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f.o f42457a;

            a(f.o oVar) {
                this.f42457a = oVar;
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void a(int i4, Exception exc) {
                this.f42457a.a(i4, exc);
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void b() {
                this.f42457a.b();
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void c() {
                this.f42457a.c();
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoComplete() {
                this.f42457a.onVideoComplete();
                b.this.f42451h.setVisibility(0);
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoPause() {
                this.f42457a.onVideoPause();
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoReady() {
                this.f42457a.onVideoReady();
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoResume() {
                this.f42457a.onVideoResume();
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoStart() {
                this.f42457a.onVideoStart();
                b.this.f42451h.setVisibility(8);
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoStop() {
                this.f42457a.onVideoStop();
                b.this.f42451h.setVisibility(0);
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void a() {
                this.f42457a.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class c implements f.s {
            c() {
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.s
            public void a(int i4) {
                if (b.this.f42456m != null) {
                    b.this.f42456m.a(i4);
                }
            }
        }

        public b(h0 h0Var, Context context) {
            super(context);
            this.f42446c = new FrameLayout.LayoutParams(-1, -1, 17);
            this.f42447d = false;
            this.f42450g = false;
            this.f42452i = false;
            setTag("GDTDLVideoView");
            this.f42448e = h0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            if (h()) {
                return;
            }
            ViewParent parent = this.f42449f.getParent();
            if (parent == this) {
                if (this.f42452i) {
                    this.f42449f.setLayoutParams(this.f42446c);
                    this.f42451h.setLayoutParams(this.f42446c);
                }
            } else {
                if (parent != null) {
                    n2.a(this.f42449f);
                    n2.a(this.f42451h);
                }
                addView(this.f42449f, this.f42446c);
                addView(this.f42451h, this.f42446c);
            }
            this.f42452i = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h() {
            return !this.f42450g;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i4;
            com.qq.e.dl.l.i.d g4 = this.f42448e.g();
            int i5 = 0;
            if (g4 != null) {
                i5 = getWidth();
                i4 = getHeight();
                g4.a(canvas, i5, i4);
            } else {
                i4 = 0;
            }
            super.draw(canvas);
            if (g4 != null) {
                g4.b(canvas, i5, i4);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i4, int i5) {
            com.qq.e.dl.l.k.a i6 = this.f42448e.i();
            Pair<Integer, Integer> d4 = i6.d(i4, i5);
            super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
            Pair<Integer, Integer> c4 = i6.c(i4, i5);
            if (c4 != null) {
                super.onMeasure(((Integer) c4.first).intValue(), ((Integer) c4.second).intValue());
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42448e.a(view, i4);
        }

        @Override // android.view.View
        public void setBackgroundColor(int i4) {
            this.f42448e.e(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void d() {
            if (h()) {
                this.f42451h = new ImageView(getContext());
                this.f42449f = new com.qq.e.comm.plugin.o0.h.f(getContext());
                this.f42450g = true;
                e();
                this.f42448e.w();
                d dVar = this.f42453j;
                if (dVar != null) {
                    dVar.a(this.f42449f);
                }
            }
        }

        @Deprecated
        public boolean c() {
            return this.f42447d;
        }

        public void e() {
            if (h0.f42444z) {
                return;
            }
            this.f42449f.a(new C0804b());
            this.f42449f.a(new c());
        }

        public boolean f() {
            return this.f42454k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i4) {
            f.r rVar;
            if (this.f42449f == null) {
                return;
            }
            this.f42447d = true;
            if (i4 == 2) {
                rVar = f.r.f45184e;
            } else if (i4 != 3) {
                rVar = f.r.f45182c;
            } else {
                a(1);
                rVar = f.r.f45183d;
            }
            this.f42449f.a(rVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.dl.h0$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class C0804b implements f.o {
            C0804b() {
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void a(int i4, Exception exc) {
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.a(i4, exc);
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void b() {
                if (b.this.f42455l != null) {
                    b.this.f42455l.b();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void c() {
                if (b.this.f42455l != null) {
                    b.this.f42455l.c();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoComplete() {
                b.this.f42451h.setVisibility(0);
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.onVideoComplete();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoPause() {
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(b.this.b().getVideoState(), b.this.b().b());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.onVideoPause();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoReady() {
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(f.t.PREPARED, b.this.b().getCurrentPosition());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.onVideoReady();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoResume() {
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(b.this.b().getVideoState(), b.this.b().b());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.onVideoResume();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoStart() {
                b.this.f42451h.setVisibility(8);
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.onVideoStart();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void onVideoStop() {
                b.this.f42451h.setVisibility(0);
                if (b.this.f42456m != null) {
                    b.this.f42456m.onPlayStateChange(b.this.b().getVideoState(), b.this.b().getCurrentPosition());
                }
                if (b.this.f42455l != null) {
                    b.this.f42455l.onVideoStop();
                }
            }

            @Override // com.qq.e.comm.plugin.o0.h.f.o
            public void a() {
                if (b.this.f42455l != null) {
                    b.this.f42455l.a();
                }
            }
        }

        @Override // com.qq.e.dl.l.e
        public void a(h0 h0Var) {
            this.f42448e = h0Var;
        }

        public void a(com.qq.e.comm.plugin.g0.e eVar) {
            this.f42449f.a(eVar);
            com.qq.e.comm.plugin.b.g o4 = eVar.o();
            if (o4 == com.qq.e.comm.plugin.b.g.REWARDVIDEOAD || o4 == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN) {
                com.qq.e.comm.plugin.b0.b.a().a(eVar.X(), this.f42451h);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f.o oVar) {
            if (!h0.f42444z) {
                this.f42455l = oVar;
            } else {
                this.f42449f.a(new a(oVar));
            }
        }

        public void a(c cVar) {
            this.f42456m = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i4) {
            this.f42446c.gravity = i4;
            this.f42452i = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            com.qq.e.comm.plugin.o0.h.f fVar = this.f42449f;
            if (fVar == null) {
                return;
            }
            fVar.a(str);
            this.f42449f.play();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z3) {
            com.qq.e.comm.plugin.o0.h.f fVar = this.f42449f;
            if (fVar == null) {
                return;
            }
            if (z3) {
                fVar.c();
            } else {
                fVar.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z3) {
            this.f42454k = z3;
        }

        public com.qq.e.comm.plugin.o0.h.f b() {
            return this.f42449f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f4) {
            com.qq.e.comm.plugin.o0.h.f fVar = this.f42449f;
            if (fVar != null) {
                fVar.a(f4);
            }
        }

        public void a() {
            com.qq.e.comm.plugin.o0.h.f fVar = this.f42449f;
            if (fVar != null) {
                fVar.i();
            }
        }

        public void a(d dVar) {
            this.f42453j = dVar;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(int i4);

        void onPlayStateChange(f.t tVar, int i4);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        void a(com.qq.e.comm.plugin.o0.h.f fVar);
    }

    static {
        f42444z = com.qq.e.comm.plugin.d0.a.d().f().a("svsl", 0) != 1;
    }

    protected h0(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f42445x = new HashMap();
        x();
    }

    private boolean d(String str, com.qq.e.dl.k.g gVar) {
        if (((b) this.f47039w).h()) {
            if ("91".equals(str) && !TextUtils.isEmpty(gVar.toString())) {
                ((b) this.f47039w).d();
                return false;
            } else if (f42443y.contains(str)) {
                this.f42445x.put(str, gVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w() {
        Map<String, com.qq.e.dl.k.g> map = this.f42445x;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, com.qq.e.dl.k.g> entry : this.f42445x.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void x() {
        f42443y.add("adModel");
        f42443y.add("callback");
        f42443y.add("muted");
        f42443y.add("93");
        f42443y.add("speed");
        f42443y.add("replay");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public b a(com.qq.e.dl.a aVar) {
        n.a aVar2 = new n.a();
        b bVar = new b(this, aVar.b());
        if (h.f42442b) {
            bVar.d();
        }
        aVar2.f42489b = System.currentTimeMillis();
        aVar2.f42490c = h.f42441a;
        n.a(aVar2);
        return bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean c(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -1169023802:
                if (str.equals("adModel")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case -934524953:
                if (str.equals("replay")) {
                    c4 = 7;
                    break;
                }
                c4 = '\uffff';
                break;
            case -172220347:
                if (str.equals("callback")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1571:
                if (str.equals("14")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1816:
                if (str.equals("91")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1818:
                if (str.equals("93")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case 104264043:
                if (str.equals("muted")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c4 = 6;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        switch (c4) {
            case 0:
                ((b) this.f47039w).a(com.qq.e.dl.k.n.b(gVar) | 17);
                break;
            case 1:
                ((b) this.f47039w).a(gVar.toString());
                break;
            case 2:
                ((b) this.f47039w).a((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
                break;
            case 3:
                ((b) this.f47039w).a((f.o) gVar.c(new JSONObject[0]));
                break;
            case 4:
                ((b) this.f47039w).a(gVar.b(new JSONObject[0]) == 1);
                break;
            case 5:
                ((b) this.f47039w).b(gVar.b(new JSONObject[0]));
                break;
            case 6:
                ((b) this.f47039w).a(gVar.d(new JSONObject[0]));
                break;
            case 7:
                ((b) this.f47039w).b(gVar.b(new JSONObject[0]) == 1);
                break;
            default:
                return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        com.qq.e.dl.l.i.b bVar = this.f47079q;
        if (bVar != null && bVar.a()) {
            m().setWillNotDraw(false);
        }
        ((b) this.f47039w).g();
    }

    @Override // com.qq.e.dl.l.h
    public void a(com.qq.e.dl.i.g gVar, com.qq.e.dl.l.g gVar2, JSONObject jSONObject) {
        com.qq.e.dl.k.j jVar;
        Map<String, com.qq.e.dl.k.j> map = gVar.f46975c;
        if (map != null && (jVar = map.get("68")) != null && jVar.b(new JSONObject[0]) == -1) {
            ((b) this.f47039w).d();
        }
        super.a(gVar, gVar2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        if (d(str, gVar) || c(str, gVar)) {
            return true;
        }
        return super.a(str, gVar);
    }

    @Override // com.qq.e.dl.l.h
    public void a(String str, JSONObject jSONObject) {
        if ("initVideo".equals(str)) {
            ((b) this.f47039w).d();
            ((b) this.f47039w).g();
        }
    }
}
