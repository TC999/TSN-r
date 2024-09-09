package com.bytedance.sdk.component.widget.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.bk;
import com.bytedance.sdk.component.widget.recycler.c;
import com.bytedance.sdk.component.widget.recycler.sr;
import com.bytedance.sdk.component.widget.recycler.t;
import com.bytedance.sdk.component.widget.recycler.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.c.xv.xv {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f30473c;
    private static final Class<?>[] gw;

    /* renamed from: m  reason: collision with root package name */
    private static final boolean f30474m;
    static final boolean sr;

    /* renamed from: w  reason: collision with root package name */
    static final boolean f30475w;
    static final Interpolator wx;

    /* renamed from: x  reason: collision with root package name */
    private static final boolean f30476x;
    static final boolean xv;

    /* renamed from: a  reason: collision with root package name */
    final RectF f30477a;
    private int au;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityManager f30478b;
    final u ba;
    private int be;
    private boolean bj;
    c bk;
    private int bm;
    private int bs;
    com.bytedance.sdk.component.widget.recycler.sr ck;

    /* renamed from: e  reason: collision with root package name */
    private final int f30479e;
    private List<t> eb;
    boolean eq;
    private int eu;
    final com.bytedance.sdk.component.widget.recycler.t ev;

    /* renamed from: f  reason: collision with root package name */
    com.bytedance.sdk.component.widget.recycler.c f30480f;
    private EdgeEffect fm;
    final ArrayList<ev> fp;
    boolean fz;

    /* renamed from: g  reason: collision with root package name */
    private int f30481g;
    f gb;
    boolean gd;
    private int ge;
    private final int[] gp;

    /* renamed from: h  reason: collision with root package name */
    private EdgeEffect f30482h;

    /* renamed from: i  reason: collision with root package name */
    boolean f30483i;
    boolean ia;
    private final int[] iw;

    /* renamed from: j  reason: collision with root package name */
    boolean f30484j;

    /* renamed from: k  reason: collision with root package name */
    final Rect f30485k;
    private float kk;
    private final int[] kn;
    private int lf;
    boolean ls;
    private sr lw;
    boolean me;
    private final ArrayList<bk> mt;
    private final int mu;

    /* renamed from: n  reason: collision with root package name */
    final q f30486n;
    private ux ng;

    /* renamed from: o  reason: collision with root package name */
    private final t.w f30487o;
    private EdgeEffect oh;
    private EdgeEffect ok;
    private bk oo;
    private int ox;

    /* renamed from: p  reason: collision with root package name */
    final Runnable f30488p;

    /* renamed from: q  reason: collision with root package name */
    boolean f30489q;
    private com.bytedance.sdk.component.widget.recycler.c.xv.sr qy;

    /* renamed from: r  reason: collision with root package name */
    com.bytedance.sdk.component.widget.recycler.w f30490r;
    private f.w rh;

    /* renamed from: s  reason: collision with root package name */
    boolean f30491s;

    /* renamed from: t  reason: collision with root package name */
    gd f30492t;
    private VelocityTracker ta;
    private int te;
    private float tl;

    /* renamed from: u  reason: collision with root package name */
    boolean f30493u;
    private final Rect up;
    final fp ux;
    private final s vc;
    private List<k> wo;
    final int[] wv;
    private a xg;
    final int[] xk;
    private int xu;

    /* renamed from: y  reason: collision with root package name */
    boolean f30494y;
    ia ys;
    final List<j> yu;

    /* renamed from: z  reason: collision with root package name */
    sr.c f30495z;
    private Runnable zg;
    private boolean zr;
    private t zt;
    private static final int[] pr = {16843830};
    private static final int[] bw = {16842987};

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class a {
        public abstract boolean c(int i4, int i5);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface bk {
        void c(boolean z3);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void w(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c<VH extends j> {

        /* renamed from: c  reason: collision with root package name */
        private final w f30501c = new w();

        /* renamed from: w  reason: collision with root package name */
        private boolean f30502w = false;

        public abstract int c();

        public int c(int i4) {
            return 0;
        }

        public abstract VH c(ViewGroup viewGroup, int i4);

        public void c(VH vh) {
        }

        public abstract void c(VH vh, int i4);

        public void c(VH vh, int i4, List<Object> list) {
            c((c<VH>) vh, i4);
        }

        public void c(RecyclerView recyclerView) {
        }

        public void sr(VH vh) {
        }

        public long w(int i4) {
            return -1L;
        }

        public final VH w(ViewGroup viewGroup, int i4) {
            try {
                com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV CreateView");
                VH c4 = c(viewGroup, i4);
                if (c4.sr.getParent() == null) {
                    c4.gd = i4;
                    return c4;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                com.bytedance.sdk.component.widget.recycler.c.c.c.c();
            }
        }

        public void w(RecyclerView recyclerView) {
        }

        public boolean w(VH vh) {
            return false;
        }

        public final void xv() {
            this.f30501c.c();
        }

        public void xv(VH vh) {
        }

        public void c(xv xvVar) {
            this.f30501c.registerObserver(xvVar);
        }

        public final void c(int i4, Object obj) {
            this.f30501c.c(i4, 1, obj);
        }

        public final void c(int i4, int i5) {
            this.f30501c.c(i4, i5);
        }

        public final void w(VH vh, int i4) {
            vh.f30533f = i4;
            if (w()) {
                vh.ev = w(i4);
            }
            vh.c(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV OnBindView");
            c(vh, i4, vh.gb());
            vh.ls();
            ViewGroup.LayoutParams layoutParams = vh.sr.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).xv = true;
            }
            com.bytedance.sdk.component.widget.recycler.c.c.c.c();
        }

        public final boolean w() {
            return this.f30502w;
        }

        public void w(xv xvVar) {
            this.f30501c.unregisterObserver(xvVar);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class ev {
        @Deprecated
        public void c(Canvas canvas, RecyclerView recyclerView) {
        }

        public void c(Canvas canvas, RecyclerView recyclerView, u uVar) {
            c(canvas, recyclerView);
        }

        @Deprecated
        public void w(Canvas canvas, RecyclerView recyclerView) {
        }

        public void w(Canvas canvas, RecyclerView recyclerView, u uVar) {
            w(canvas, recyclerView);
        }

        @Deprecated
        public void c(Rect rect, int i4, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void c(Rect rect, View view, RecyclerView recyclerView, u uVar) {
            c(rect, ((p) view.getLayoutParams()).sr(), recyclerView);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class f {

        /* renamed from: c  reason: collision with root package name */
        private w f30503c = null;

        /* renamed from: w  reason: collision with root package name */
        private ArrayList<c> f30505w = new ArrayList<>();
        private long xv = 120;
        private long sr = 120;
        private long ux = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f30504f = 250;

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface c {
            void c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface w {
            void c(j jVar);
        }

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class xv {

            /* renamed from: c  reason: collision with root package name */
            public int f30506c;
            public int sr;

            /* renamed from: w  reason: collision with root package name */
            public int f30507w;
            public int xv;

            public xv c(j jVar) {
                return c(jVar, 0);
            }

            public xv c(j jVar, int i4) {
                View view = jVar.sr;
                this.f30506c = view.getLeft();
                this.f30507w = view.getTop();
                this.xv = view.getRight();
                this.sr = view.getBottom();
                return this;
            }
        }

        public abstract void c();

        public void c(long j4) {
            this.f30504f = j4;
        }

        public abstract boolean c(j jVar, xv xvVar, xv xvVar2);

        public abstract boolean c(j jVar, j jVar2, xv xvVar, xv xvVar2);

        public long ev() {
            return this.f30504f;
        }

        public boolean ev(j jVar) {
            return true;
        }

        public long f() {
            return this.xv;
        }

        public final void gd() {
            int size = this.f30505w.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f30505w.get(i4).c();
            }
            this.f30505w.clear();
        }

        public xv p() {
            return new xv();
        }

        public long r() {
            return this.sr;
        }

        public void r(j jVar) {
        }

        public abstract void sr();

        public abstract void sr(j jVar);

        public long ux() {
            return this.ux;
        }

        public abstract boolean w();

        public abstract boolean w(j jVar, xv xvVar, xv xvVar2);

        public abstract boolean xv(j jVar, xv xvVar, xv xvVar2);

        static int ux(j jVar) {
            int i4 = jVar.bk & 14;
            if (jVar.s()) {
                return 4;
            }
            if ((i4 & 4) == 0) {
                int p3 = jVar.p();
                int gd = jVar.gd();
                return (p3 == -1 || gd == -1 || p3 == gd) ? i4 : i4 | 2048;
            }
            return i4;
        }

        void c(w wVar) {
            this.f30503c = wVar;
        }

        public final void f(j jVar) {
            r(jVar);
            w wVar = this.f30503c;
            if (wVar != null) {
                wVar.c(jVar);
            }
        }

        public xv c(u uVar, j jVar, int i4, List<Object> list) {
            return p().c(jVar);
        }

        public xv c(u uVar, j jVar) {
            return p().c(jVar);
        }

        public boolean c(j jVar, List<Object> list) {
            return ev(jVar);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class fp {

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<j> f30508c;
        private int ev;
        private i gd;

        /* renamed from: r  reason: collision with root package name */
        private final List<j> f30510r;
        int sr;
        ys ux;

        /* renamed from: w  reason: collision with root package name */
        ArrayList<j> f30511w;
        final ArrayList<j> xv;

        public fp() {
            ArrayList<j> arrayList = new ArrayList<>();
            this.f30508c = arrayList;
            this.f30511w = null;
            this.xv = new ArrayList<>();
            this.f30510r = Collections.unmodifiableList(arrayList);
            this.ev = 2;
            this.sr = 2;
        }

        private void ux(j jVar) {
            View view = jVar.sr;
            if (view instanceof ViewGroup) {
                c((ViewGroup) view, false);
            }
        }

        public void c() {
            this.f30508c.clear();
            sr();
        }

        void ev() {
            int size = this.xv.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar = this.xv.get(i4);
                if (jVar != null) {
                    jVar.w(6);
                    jVar.c((Object) null);
                }
            }
            c cVar = RecyclerView.this.bk;
            if (cVar == null || !cVar.w()) {
                sr();
            }
        }

        void f() {
            this.f30508c.clear();
            ArrayList<j> arrayList = this.f30511w;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void gd() {
            int size = this.xv.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.xv.get(i4).ux();
            }
            int size2 = this.f30508c.size();
            for (int i5 = 0; i5 < size2; i5++) {
                this.f30508c.get(i5).ux();
            }
            ArrayList<j> arrayList = this.f30511w;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    this.f30511w.get(i6).ux();
                }
            }
        }

        void p() {
            int size = this.xv.size();
            for (int i4 = 0; i4 < size; i4++) {
                p pVar = (p) this.xv.get(i4).sr.getLayoutParams();
                if (pVar != null) {
                    pVar.xv = true;
                }
            }
        }

        ys r() {
            if (this.ux == null) {
                this.ux = new ys();
            }
            return this.ux;
        }

        void sr() {
            for (int size = this.xv.size() - 1; size >= 0; size--) {
                xv(size);
            }
            this.xv.clear();
            if (RecyclerView.sr) {
                RecyclerView.this.f30495z.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void w() {
            gd gdVar = RecyclerView.this.f30492t;
            this.sr = this.ev + (gdVar != null ? gdVar.fp : 0);
            for (int size = this.xv.size() - 1; size >= 0 && this.xv.size() > this.sr; size--) {
                xv(size);
            }
        }

        public List<j> xv() {
            return this.f30510r;
        }

        void xv(int i4) {
            c(this.xv.get(i4), true);
            this.xv.remove(i4);
        }

        public void c(int i4) {
            this.ev = i4;
            w();
        }

        int ux() {
            return this.f30508c.size();
        }

        j ux(int i4) {
            int size;
            int w3;
            ArrayList<j> arrayList = this.f30511w;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    j jVar = this.f30511w.get(i5);
                    if (!jVar.ys() && jVar.ev() == i4) {
                        jVar.w(32);
                        return jVar;
                    }
                }
                if (RecyclerView.this.bk.w() && (w3 = RecyclerView.this.f30480f.w(i4)) > 0 && w3 < RecyclerView.this.bk.c()) {
                    long w4 = RecyclerView.this.bk.w(w3);
                    for (int i6 = 0; i6 < size; i6++) {
                        j jVar2 = this.f30511w.get(i6);
                        if (!jVar2.ys() && jVar2.k() == w4) {
                            jVar2.w(32);
                            return jVar2;
                        }
                    }
                }
            }
            return null;
        }

        boolean c(j jVar) {
            if (jVar.i()) {
                return RecyclerView.this.ba.c();
            }
            int i4 = jVar.f30533f;
            if (i4 >= 0 && i4 < RecyclerView.this.bk.c()) {
                if (RecyclerView.this.ba.c() || RecyclerView.this.bk.c(jVar.f30533f) == jVar.a()) {
                    return !RecyclerView.this.bk.w() || jVar.k() == RecyclerView.this.bk.w(jVar.f30533f);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + jVar + RecyclerView.this.c());
        }

        public View w(int i4) {
            return c(i4, false);
        }

        void xv(View view) {
            j ux = RecyclerView.ux(view);
            if (!ux.c(12) && ux.y() && !RecyclerView.this.w(ux)) {
                if (this.f30511w == null) {
                    this.f30511w = new ArrayList<>();
                }
                ux.c(this, true);
                this.f30511w.add(ux);
            } else if (ux.s() && !ux.i() && !RecyclerView.this.bk.w()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.c());
            } else {
                ux.c(this, false);
                this.f30508c.add(ux);
            }
        }

        View sr(int i4) {
            return this.f30508c.get(i4).sr;
        }

        void w(j jVar) {
            boolean z3;
            boolean z4 = true;
            if (!jVar.bk() && jVar.sr.getParent() == null) {
                if (!jVar.q()) {
                    if (!jVar.r()) {
                        boolean ba = jVar.ba();
                        c cVar = RecyclerView.this.bk;
                        if ((cVar != null && ba && cVar.w((c) jVar)) || jVar.ck()) {
                            if (this.sr <= 0 || jVar.c(526)) {
                                z3 = false;
                            } else {
                                int size = this.xv.size();
                                if (size >= this.sr && size > 0) {
                                    xv(0);
                                    size--;
                                }
                                if (RecyclerView.sr && size > 0 && !RecyclerView.this.f30495z.c(jVar.f30533f)) {
                                    int i4 = size - 1;
                                    while (i4 >= 0) {
                                        if (!RecyclerView.this.f30495z.c(this.xv.get(i4).f30533f)) {
                                            break;
                                        }
                                        i4--;
                                    }
                                    size = i4 + 1;
                                }
                                this.xv.add(size, jVar);
                                z3 = true;
                            }
                            if (!z3) {
                                c(jVar, true);
                                r1 = z3;
                                RecyclerView.this.ev.r(jVar);
                                if (r1 && !z4 && ba) {
                                    jVar.fz = null;
                                    return;
                                }
                                return;
                            }
                            r1 = z3;
                        }
                        z4 = false;
                        RecyclerView.this.ev.r(jVar);
                        if (r1) {
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.c());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + jVar + RecyclerView.this.c());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(jVar.bk());
            sb.append(" isAttached:");
            sb.append(jVar.sr.getParent() != null);
            sb.append(RecyclerView.this.c());
            throw new IllegalArgumentException(sb.toString());
        }

        void sr(j jVar) {
            ia iaVar = RecyclerView.this.ys;
            if (iaVar != null) {
                iaVar.c(jVar);
            }
            c cVar = RecyclerView.this.bk;
            if (cVar != null) {
                cVar.c((c) jVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.ba != null) {
                recyclerView.ev.r(jVar);
            }
        }

        private boolean c(j jVar, int i4, int i5, long j4) {
            jVar.fz = RecyclerView.this;
            int a4 = jVar.a();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j4 == Long.MAX_VALUE || this.ux.w(a4, nanoTime, j4)) {
                RecyclerView.this.bk.w((c) jVar, i4);
                this.ux.w(jVar.a(), RecyclerView.this.getNanoTime() - nanoTime);
                if (RecyclerView.this.ba.c()) {
                    jVar.f30535p = i5;
                    return true;
                }
                return true;
            }
            return false;
        }

        void xv(j jVar) {
            if (jVar.ia) {
                this.f30511w.remove(jVar);
            } else {
                this.f30508c.remove(jVar);
            }
            jVar.fp = null;
            jVar.ia = false;
            jVar.fp();
        }

        void xv(int i4, int i5) {
            int i6;
            int i7 = i5 + i4;
            for (int size = this.xv.size() - 1; size >= 0; size--) {
                j jVar = this.xv.get(size);
                if (jVar != null && (i6 = jVar.f30533f) >= i4 && i6 < i7) {
                    jVar.w(2);
                    xv(size);
                }
            }
        }

        View c(int i4, boolean z3) {
            return c(i4, z3, Long.MAX_VALUE).sr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:100:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.sdk.component.widget.recycler.RecyclerView.j c(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 615
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.fp.c(int, boolean, long):com.bytedance.sdk.component.widget.recycler.RecyclerView$j");
        }

        void w(View view) {
            j ux = RecyclerView.ux(view);
            ux.fp = null;
            ux.ia = false;
            ux.fp();
            w(ux);
        }

        j w(int i4, boolean z3) {
            View xv;
            int size = this.f30508c.size();
            for (int i5 = 0; i5 < size; i5++) {
                j jVar = this.f30508c.get(i5);
                if (!jVar.ys() && jVar.ev() == i4 && !jVar.s() && (RecyclerView.this.ba.f30553r || !jVar.i())) {
                    jVar.w(32);
                    return jVar;
                }
            }
            if (!z3 && (xv = RecyclerView.this.f30490r.xv(i4)) != null) {
                j ux = RecyclerView.ux(xv);
                RecyclerView.this.f30490r.ux(xv);
                int w3 = RecyclerView.this.f30490r.w(xv);
                if (w3 != -1) {
                    RecyclerView.this.f30490r.ux(w3);
                    xv(xv);
                    ux.w(8224);
                    return ux;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ux + RecyclerView.this.c());
            }
            int size2 = this.xv.size();
            for (int i6 = 0; i6 < size2; i6++) {
                j jVar2 = this.xv.get(i6);
                if (!jVar2.s() && jVar2.ev() == i4) {
                    if (!z3) {
                        this.xv.remove(i6);
                    }
                    return jVar2;
                }
            }
            return null;
        }

        void w(int i4, int i5) {
            int size = this.xv.size();
            for (int i6 = 0; i6 < size; i6++) {
                j jVar = this.xv.get(i6);
                if (jVar != null && jVar.f30533f >= i4) {
                    jVar.c(i5, true);
                }
            }
        }

        private void c(ViewGroup viewGroup, boolean z3) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, true);
                }
            }
            if (z3) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void c(View view) {
            j ux = RecyclerView.ux(view);
            if (ux.q()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (ux.bk()) {
                ux.t();
            } else if (ux.ys()) {
                ux.fp();
            }
            w(ux);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(j jVar, boolean z3) {
            RecyclerView.xv(jVar);
            if (jVar.c(16384)) {
                jVar.c(0, 16384);
            }
            if (z3) {
                sr(jVar);
            }
            jVar.fz = null;
            r().c(jVar);
        }

        j c(long j4, int i4, boolean z3) {
            for (int size = this.f30508c.size() - 1; size >= 0; size--) {
                j jVar = this.f30508c.get(size);
                if (jVar.k() == j4 && !jVar.ys()) {
                    if (i4 == jVar.a()) {
                        jVar.w(32);
                        if (jVar.i() && !RecyclerView.this.ba.c()) {
                            jVar.c(2, 14);
                        }
                        return jVar;
                    } else if (!z3) {
                        this.f30508c.remove(size);
                        RecyclerView.this.removeDetachedView(jVar.sr, false);
                        w(jVar.sr);
                    }
                }
            }
            int size2 = this.xv.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                j jVar2 = this.xv.get(size2);
                if (jVar2.k() == j4) {
                    if (i4 == jVar2.a()) {
                        if (!z3) {
                            this.xv.remove(size2);
                        }
                        return jVar2;
                    } else if (!z3) {
                        xv(size2);
                        return null;
                    }
                }
            }
        }

        void c(c cVar, c cVar2, boolean z3) {
            c();
            r().c(cVar, cVar2, z3);
        }

        void c(int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            if (i4 < i5) {
                i6 = -1;
                i8 = i4;
                i7 = i5;
            } else {
                i6 = 1;
                i7 = i4;
                i8 = i5;
            }
            int size = this.xv.size();
            for (int i10 = 0; i10 < size; i10++) {
                j jVar = this.xv.get(i10);
                if (jVar != null && (i9 = jVar.f30533f) >= i8 && i9 <= i7) {
                    if (i9 == i4) {
                        jVar.c(i5 - i4, false);
                    } else {
                        jVar.c(i6, false);
                    }
                }
            }
        }

        void c(int i4, int i5, boolean z3) {
            int i6 = i4 + i5;
            for (int size = this.xv.size() - 1; size >= 0; size--) {
                j jVar = this.xv.get(size);
                if (jVar != null) {
                    int i7 = jVar.f30533f;
                    if (i7 >= i6) {
                        jVar.c(-i5, z3);
                    } else if (i7 >= i4) {
                        jVar.w(8);
                        xv(size);
                    }
                }
            }
        }

        void c(i iVar) {
            this.gd = iVar;
        }

        void c(ys ysVar) {
            ys ysVar2 = this.ux;
            if (ysVar2 != null) {
                ysVar2.xv();
            }
            this.ux = ysVar;
            if (ysVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.ux.w();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class fz {
        private boolean ev;

        /* renamed from: f  reason: collision with root package name */
        private View f30513f;
        private boolean sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private RecyclerView f30515w;
        private gd xv;

        /* renamed from: c  reason: collision with root package name */
        private int f30512c = -1;

        /* renamed from: r  reason: collision with root package name */
        private final c f30514r = new c(0, 0);

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class c {

            /* renamed from: c  reason: collision with root package name */
            private int f30516c;

            /* renamed from: f  reason: collision with root package name */
            private boolean f30517f;

            /* renamed from: r  reason: collision with root package name */
            private int f30518r;
            private int sr;
            private Interpolator ux;

            /* renamed from: w  reason: collision with root package name */
            private int f30519w;
            private int xv;

            public c(int i4, int i5) {
                this(i4, i5, Integer.MIN_VALUE, null);
            }

            private void w() {
                if (this.ux != null && this.xv < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.xv < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void c(int i4) {
                this.sr = i4;
            }

            public void update(int i4, int i5, int i6, Interpolator interpolator) {
                this.f30516c = i4;
                this.f30519w = i5;
                this.xv = i6;
                this.ux = interpolator;
                this.f30517f = true;
            }

            public c(int i4, int i5, int i6, Interpolator interpolator) {
                this.sr = -1;
                this.f30517f = false;
                this.f30518r = 0;
                this.f30516c = i4;
                this.f30519w = i5;
                this.xv = i6;
                this.ux = interpolator;
            }

            boolean c() {
                return this.sr >= 0;
            }

            void c(RecyclerView recyclerView) {
                int i4 = this.sr;
                if (i4 >= 0) {
                    this.sr = -1;
                    recyclerView.w(i4);
                    this.f30517f = false;
                } else if (this.f30517f) {
                    w();
                    Interpolator interpolator = this.ux;
                    if (interpolator == null) {
                        int i5 = this.xv;
                        if (i5 == Integer.MIN_VALUE) {
                            recyclerView.f30486n.w(this.f30516c, this.f30519w);
                        } else {
                            recyclerView.f30486n.c(this.f30516c, this.f30519w, i5);
                        }
                    } else {
                        recyclerView.f30486n.c(this.f30516c, this.f30519w, this.xv, interpolator);
                    }
                    int i6 = this.f30518r + 1;
                    this.f30518r = i6;
                    if (i6 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f30517f = false;
                } else {
                    this.f30518r = 0;
                }
            }
        }

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface w {
            PointF xv(int i4);
        }

        protected abstract void c();

        protected abstract void c(int i4, int i5, u uVar, c cVar);

        protected abstract void c(View view, u uVar, c cVar);

        void c(RecyclerView recyclerView, gd gdVar) {
            if (this.ev) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f30515w = recyclerView;
            this.xv = gdVar;
            int i4 = this.f30512c;
            if (i4 != -1) {
                recyclerView.ba.f30549c = i4;
                this.ux = true;
                this.sr = true;
                this.f30513f = ux(gd());
                c();
                this.f30515w.f30486n.c();
                this.ev = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public boolean ev() {
            return this.ux;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void f() {
            if (this.ux) {
                this.ux = false;
                w();
                this.f30515w.ba.f30549c = -1;
                this.f30513f = null;
                this.f30512c = -1;
                this.sr = false;
                this.xv.w(this);
                this.xv = null;
                this.f30515w = null;
            }
        }

        public int gd() {
            return this.f30512c;
        }

        public int p() {
            return this.f30515w.f30492t.i();
        }

        public boolean r() {
            return this.sr;
        }

        public PointF sr(int i4) {
            gd ux = ux();
            if (ux instanceof w) {
                return ((w) ux).xv(i4);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + w.class.getCanonicalName());
            return null;
        }

        public gd ux() {
            return this.xv;
        }

        protected abstract void w();

        protected void w(View view) {
            if (c(view) == gd()) {
                this.f30513f = view;
            }
        }

        public void xv(int i4) {
            this.f30512c = i4;
        }

        public View ux(int i4) {
            return this.f30515w.f30492t.w(i4);
        }

        void c(int i4, int i5) {
            PointF sr;
            RecyclerView recyclerView = this.f30515w;
            if (!this.ux || this.f30512c == -1 || recyclerView == null) {
                f();
            }
            if (this.sr && this.f30513f == null && this.xv != null && (sr = sr(this.f30512c)) != null) {
                float f4 = sr.x;
                if (f4 != 0.0f || sr.y != 0.0f) {
                    recyclerView.c((int) Math.signum(f4), (int) Math.signum(sr.y), (int[]) null);
                }
            }
            this.sr = false;
            View view = this.f30513f;
            if (view != null) {
                if (c(view) == this.f30512c) {
                    c(this.f30513f, recyclerView.ba, this.f30514r);
                    this.f30514r.c(recyclerView);
                    f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f30513f = null;
                }
            }
            if (this.ux) {
                c(i4, i5, recyclerView.ba, this.f30514r);
                boolean c4 = this.f30514r.c();
                this.f30514r.c(recyclerView);
                if (c4) {
                    if (this.ux) {
                        this.sr = true;
                        recyclerView.f30486n.c();
                        return;
                    }
                    f();
                }
            }
        }

        public int c(View view) {
            return this.f30515w.ev(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void c(PointF pointF) {
            float f4 = pointF.x;
            float f5 = pointF.y;
            float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class gd {

        /* renamed from: a  reason: collision with root package name */
        fz f30520a;
        boolean bk;

        /* renamed from: c  reason: collision with root package name */
        private final bk.w f30521c;
        com.bytedance.sdk.component.widget.recycler.w ev;

        /* renamed from: f  reason: collision with root package name */
        private int f30522f;
        int fp;
        RecyclerView gd;
        boolean ia;

        /* renamed from: k  reason: collision with root package name */
        com.bytedance.sdk.component.widget.recycler.bk f30523k;

        /* renamed from: p  reason: collision with root package name */
        com.bytedance.sdk.component.widget.recycler.bk f30524p;

        /* renamed from: r  reason: collision with root package name */
        private int f30525r;

        /* renamed from: s  reason: collision with root package name */
        private int f30526s;
        private boolean sr;

        /* renamed from: t  reason: collision with root package name */
        boolean f30527t;
        private int ux;

        /* renamed from: w  reason: collision with root package name */
        private final bk.w f30528w;
        private boolean xv;
        boolean ys;

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface c {
            void w(int i4, int i5);
        }

        public gd() {
            bk.w wVar = new bk.w() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.gd.1
                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public View c(int i4) {
                    return gd.this.ev(i4);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int w() {
                    return gd.this.ls() - gd.this.z();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int c() {
                    return gd.this.n();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int w(View view) {
                    return gd.this.gd(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int c(View view) {
                    return gd.this.r(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
                }
            };
            this.f30521c = wVar;
            bk.w wVar2 = new bk.w() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.gd.2
                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public View c(int i4) {
                    return gd.this.ev(i4);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int w() {
                    return gd.this.gb() - gd.this.ba();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int c() {
                    return gd.this.ck();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int w(View view) {
                    return gd.this.p(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bk.w
                public int c(View view) {
                    return gd.this.ev(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
                }
            };
            this.f30528w = wVar2;
            this.f30524p = new com.bytedance.sdk.component.widget.recycler.bk(wVar);
            this.f30523k = new com.bytedance.sdk.component.widget.recycler.bk(wVar2);
            this.bk = false;
            this.f30527t = false;
            this.ys = false;
            this.xv = true;
            this.sr = true;
        }

        public int a(View view) {
            return ((p) view.getLayoutParams()).f30541w.bottom;
        }

        public int ba() {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int bk(View view) {
            return ((p) view.getLayoutParams()).f30541w.left;
        }

        public int c(int i4, fp fpVar, u uVar) {
            return 0;
        }

        public View c(View view, int i4, fp fpVar, u uVar) {
            return null;
        }

        public void c(int i4, int i5, u uVar, c cVar) {
        }

        public void c(int i4, c cVar) {
        }

        public void c(c cVar, c cVar2) {
        }

        void c(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.gd = null;
                this.ev = null;
                this.f30525r = 0;
                this.f30526s = 0;
            } else {
                this.gd = recyclerView;
                this.ev = recyclerView.f30490r;
                this.f30525r = recyclerView.getWidth();
                this.f30526s = recyclerView.getHeight();
            }
            this.ux = 1073741824;
            this.f30522f = 1073741824;
        }

        public void c(RecyclerView recyclerView, int i4, int i5) {
        }

        public void c(RecyclerView recyclerView, int i4, int i5, int i6) {
        }

        public boolean c(p pVar) {
            return pVar != null;
        }

        public boolean c(RecyclerView recyclerView, ArrayList<View> arrayList, int i4, int i5) {
            return false;
        }

        public int ck() {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int eq() {
            RecyclerView recyclerView = this.gd;
            c adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public int ev(u uVar) {
            return 0;
        }

        public View ev(int i4) {
            com.bytedance.sdk.component.widget.recycler.w wVar = this.ev;
            if (wVar != null) {
                return wVar.w(i4);
            }
            return null;
        }

        public int f(u uVar) {
            return 0;
        }

        public void f(int i4) {
            if (ev(i4) != null) {
                this.ev.c(i4);
            }
        }

        public final boolean fp() {
            return this.sr;
        }

        public int fz() {
            return com.bytedance.sdk.component.widget.recycler.c.xv.r.c(this.gd);
        }

        public int gb() {
            return this.f30526s;
        }

        public void gd(int i4) {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                recyclerView.r(i4);
            }
        }

        boolean gd() {
            return false;
        }

        public int i() {
            com.bytedance.sdk.component.widget.recycler.w wVar = this.ev;
            if (wVar != null) {
                return wVar.w();
            }
            return 0;
        }

        public boolean ia() {
            RecyclerView recyclerView = this.gd;
            return recyclerView != null && recyclerView.gd;
        }

        public int j() {
            return this.f30522f;
        }

        public int k(View view) {
            return ((p) view.getLayoutParams()).f30541w.top;
        }

        public void k(int i4) {
        }

        public int ls() {
            return this.f30525r;
        }

        public int me() {
            return com.bytedance.sdk.component.widget.recycler.c.xv.r.sr(this.gd);
        }

        public int n() {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void p(int i4) {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                recyclerView.f(i4);
            }
        }

        public int q() {
            return this.ux;
        }

        public int r(u uVar) {
            return 0;
        }

        public void r(int i4) {
            c(i4, ev(i4));
        }

        public boolean s() {
            fz fzVar = this.f30520a;
            return fzVar != null && fzVar.ev();
        }

        public int sr(View view) {
            return ((p) view.getLayoutParams()).sr();
        }

        public int sr(u uVar) {
            return 0;
        }

        public View sr(View view, int i4) {
            return null;
        }

        public void sr(int i4) {
        }

        @Deprecated
        public void sr(RecyclerView recyclerView) {
        }

        public boolean sr() {
            return false;
        }

        public int t(View view) {
            return ((p) view.getLayoutParams()).f30541w.right;
        }

        public boolean t() {
            return false;
        }

        public int u() {
            return -1;
        }

        public int ux(View view) {
            Rect rect = ((p) view.getLayoutParams()).f30541w;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int ux(u uVar) {
            return 0;
        }

        public void ux(RecyclerView recyclerView) {
        }

        public int w(int i4, fp fpVar, u uVar) {
            return 0;
        }

        public abstract p w();

        void w(int i4, int i5) {
            this.f30525r = View.MeasureSpec.getSize(i4);
            int mode = View.MeasureSpec.getMode(i4);
            this.ux = mode;
            if (mode == 0 && !RecyclerView.f30475w) {
                this.f30525r = 0;
            }
            this.f30526s = View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.f30522f = mode2;
            if (mode2 != 0 || RecyclerView.f30475w) {
                return;
            }
            this.f30526s = 0;
        }

        public void w(u uVar) {
        }

        public void w(RecyclerView recyclerView, int i4, int i5) {
        }

        public int wv() {
            return com.bytedance.sdk.component.widget.recycler.c.xv.r.ux(this.gd);
        }

        void xk() {
            fz fzVar = this.f30520a;
            if (fzVar != null) {
                fzVar.f();
            }
        }

        public int xv(u uVar) {
            return 0;
        }

        void xv(int i4, int i5) {
            int i6 = i();
            if (i6 == 0) {
                this.gd.ux(i4, i5);
                return;
            }
            int i7 = Integer.MIN_VALUE;
            int i8 = Integer.MIN_VALUE;
            int i9 = Integer.MAX_VALUE;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < i6; i11++) {
                View ev = ev(i11);
                Rect rect = this.gd.f30485k;
                c(ev, rect);
                int i12 = rect.left;
                if (i12 < i9) {
                    i9 = i12;
                }
                int i13 = rect.right;
                if (i13 > i7) {
                    i7 = i13;
                }
                int i14 = rect.top;
                if (i14 < i10) {
                    i10 = i14;
                }
                int i15 = rect.bottom;
                if (i15 > i8) {
                    i8 = i15;
                }
            }
            this.gd.f30485k.set(i9, i10, i7, i8);
            c(this.gd.f30485k, i4, i5);
        }

        public void xv(RecyclerView recyclerView) {
        }

        public void xv(RecyclerView recyclerView, int i4, int i5) {
        }

        public boolean xv() {
            return false;
        }

        public View y() {
            View focusedChild;
            RecyclerView recyclerView = this.gd;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.ev.xv(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void ys() {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean yu() {
            int i4 = i();
            for (int i5 = 0; i5 < i4; i5++) {
                ViewGroup.LayoutParams layoutParams = ev(i5).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int z() {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int ev(View view) {
            return view.getTop() - k(view);
        }

        public int r(View view) {
            return view.getLeft() - bk(view);
        }

        public void sr(int i4, int i5) {
            View ev = ev(i4);
            if (ev != null) {
                r(i4);
                xv(ev, i5);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i4 + this.gd.toString());
        }

        public int f(View view) {
            Rect rect = ((p) view.getLayoutParams()).f30541w;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int gd(View view) {
            return view.getRight() + t(view);
        }

        public int p(View view) {
            return view.getBottom() + a(view);
        }

        public void ux(int i4, int i5) {
            this.gd.setMeasuredDimension(i4, i5);
        }

        void f(RecyclerView recyclerView) {
            w(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        private boolean sr(RecyclerView recyclerView, int i4, int i5) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n4 = n();
            int ck = ck();
            int ls = ls() - z();
            int gb = gb() - ba();
            Rect rect = this.gd.f30485k;
            c(focusedChild, rect);
            return rect.left - i4 < ls && rect.right - i4 > n4 && rect.top - i5 < gb && rect.bottom - i5 > ck;
        }

        public final void w(boolean z3) {
            if (z3 != this.sr) {
                this.sr = z3;
                this.fp = 0;
                RecyclerView recyclerView = this.gd;
                if (recyclerView != null) {
                    recyclerView.ux.w();
                }
            }
        }

        public void c(Rect rect, int i4, int i5) {
            ux(c(i4, rect.width() + n() + z(), me()), c(i5, rect.height() + ck() + ba(), wv()));
        }

        public void xv(View view) {
            this.ev.c(view);
        }

        public void xv(View view, int i4) {
            c(view, i4, (p) view.getLayoutParams());
        }

        void w(RecyclerView recyclerView) {
            this.f30527t = true;
            xv(recyclerView);
        }

        public void xv(fp fpVar) {
            for (int i4 = i() - 1; i4 >= 0; i4--) {
                if (!RecyclerView.ux(ev(i4)).r()) {
                    c(i4, fpVar);
                }
            }
        }

        public static int c(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i5, i6) : size;
            }
            return Math.min(size, Math.max(i5, i6));
        }

        void w(RecyclerView recyclerView, fp fpVar) {
            this.f30527t = false;
            c(recyclerView, fpVar);
        }

        public void w(View view) {
            w(view, -1);
        }

        public void w(View view, int i4) {
            c(view, i4, false);
        }

        public void c(String str) {
            RecyclerView recyclerView = this.gd;
            if (recyclerView != null) {
                recyclerView.c(str);
            }
        }

        public View w(int i4) {
            int i5 = i();
            for (int i6 = 0; i6 < i5; i6++) {
                View ev = ev(i6);
                j ux = RecyclerView.ux(ev);
                if (ux != null && ux.ev() == i4 && !ux.r() && (this.gd.ba.c() || !ux.i())) {
                    return ev;
                }
            }
            return null;
        }

        public boolean c() {
            return this.ys;
        }

        public void c(RecyclerView recyclerView, fp fpVar) {
            sr(recyclerView);
        }

        public void c(fp fpVar, u uVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void w(fp fpVar) {
            int ux = fpVar.ux();
            for (int i4 = ux - 1; i4 >= 0; i4--) {
                View sr = fpVar.sr(i4);
                j ux2 = RecyclerView.ux(sr);
                if (!ux2.r()) {
                    ux2.c(false);
                    if (ux2.q()) {
                        this.gd.removeDetachedView(sr, false);
                    }
                    f fVar = this.gd.gb;
                    if (fVar != null) {
                        fVar.sr(ux2);
                    }
                    ux2.c(true);
                    fpVar.w(sr);
                }
            }
            fpVar.f();
            if (ux > 0) {
                this.gd.invalidate();
            }
        }

        public p c(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public p c(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void c(RecyclerView recyclerView, u uVar, int i4) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void c(fz fzVar) {
            fz fzVar2 = this.f30520a;
            if (fzVar2 != null && fzVar != fzVar2 && fzVar2.ev()) {
                this.f30520a.f();
            }
            this.f30520a = fzVar;
            fzVar.c(this.gd, this);
        }

        public void c(View view) {
            c(view, -1);
        }

        public void c(View view, int i4) {
            c(view, i4, true);
        }

        private void c(View view, int i4, boolean z3) {
            j ux = RecyclerView.ux(view);
            if (!z3 && !ux.i()) {
                this.gd.ev.f(ux);
            } else {
                this.gd.ev.ux(ux);
            }
            p pVar = (p) view.getLayoutParams();
            if (!ux.ys() && !ux.bk()) {
                if (view.getParent() == this.gd) {
                    int w3 = this.ev.w(view);
                    if (i4 == -1) {
                        i4 = this.ev.w();
                    }
                    if (w3 == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.gd.indexOfChild(view) + this.gd.c());
                    } else if (w3 != i4) {
                        this.gd.f30492t.sr(w3, i4);
                    }
                } else {
                    this.ev.c(view, i4, false);
                    pVar.xv = true;
                    fz fzVar = this.f30520a;
                    if (fzVar != null && fzVar.ev()) {
                        this.f30520a.w(view);
                    }
                }
            } else {
                if (ux.bk()) {
                    ux.t();
                } else {
                    ux.fp();
                }
                this.ev.c(view, i4, view.getLayoutParams(), false);
            }
            if (pVar.sr) {
                ux.sr.invalidate();
                pVar.sr = false;
            }
        }

        private static boolean w(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            if (i6 <= 0 || i4 == i6) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i4;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i4;
                } else {
                    return true;
                }
            }
            return false;
        }

        private int[] w(RecyclerView recyclerView, View view, Rect rect, boolean z3) {
            int[] iArr = new int[2];
            int n4 = n();
            int ck = ck();
            int ls = ls() - z();
            int gb = gb() - ba();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top2 = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top2;
            int i4 = left - n4;
            int min = Math.min(0, i4);
            int i5 = top2 - ck;
            int min2 = Math.min(0, i5);
            int i6 = width - ls;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, height - gb);
            if (fz() != 1) {
                if (min == 0) {
                    min = Math.min(i4, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i6);
            }
            if (min2 == 0) {
                min2 = Math.min(i5, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        void w(fz fzVar) {
            if (this.f30520a == fzVar) {
                this.f30520a = null;
            }
        }

        private void c(int i4, View view) {
            this.ev.ux(i4);
        }

        public void c(View view, int i4, p pVar) {
            j ux = RecyclerView.ux(view);
            if (ux.i()) {
                this.gd.ev.ux(ux);
            } else {
                this.gd.ev.f(ux);
            }
            this.ev.c(view, i4, pVar, ux.i());
        }

        public void c(View view, fp fpVar) {
            xv(view);
            fpVar.c(view);
        }

        public void c(int i4, fp fpVar) {
            View ev = ev(i4);
            f(i4);
            fpVar.c(ev);
        }

        public void c(fp fpVar) {
            for (int i4 = i() - 1; i4 >= 0; i4--) {
                c(fpVar, i4, ev(i4));
            }
        }

        private void c(fp fpVar, int i4, View view) {
            j ux = RecyclerView.ux(view);
            if (ux.r()) {
                return;
            }
            if (ux.s() && !ux.i() && !this.gd.bk.w()) {
                f(i4);
                fpVar.w(ux);
                return;
            }
            r(i4);
            fpVar.xv(view);
            this.gd.ev.ev(ux);
        }

        boolean c(View view, int i4, int i5, p pVar) {
            return (!view.isLayoutRequested() && this.xv && w(view.getWidth(), i4, ((ViewGroup.MarginLayoutParams) pVar).width) && w(view.getHeight(), i5, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public void c(View view, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect k4 = this.gd.k(view);
            int i6 = i4 + k4.left + k4.right;
            int i7 = i5 + k4.top + k4.bottom;
            int c4 = c(ls(), q(), n() + z() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i6, ((ViewGroup.MarginLayoutParams) pVar).width, xv());
            int c5 = c(gb(), j(), ck() + ba() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i7, ((ViewGroup.MarginLayoutParams) pVar).height, sr());
            if (c(view, c4, c5, pVar)) {
                view.measure(c4, c5);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int c(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2e
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2e
                if (r5 == r3) goto L21
                goto L2e
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L30
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L30
            L23:
                if (r7 != r0) goto L2e
                if (r5 == r2) goto L2b
                if (r5 == r3) goto L2b
                r5 = 0
                goto L21
            L2b:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2e:
                r5 = 0
                r7 = 0
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.gd.c(int, int, int, int, boolean):int");
        }

        public void c(View view, int i4, int i5, int i6, int i7) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f30541w;
            view.layout(i4 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i5 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i6 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i7 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void c(View view, boolean z3, Rect rect) {
            Matrix matrix;
            if (z3) {
                Rect rect2 = ((p) view.getLayoutParams()).f30541w;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.gd != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.gd.f30477a;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void c(View view, Rect rect) {
            RecyclerView.c(view, rect);
        }

        public boolean c(RecyclerView recyclerView, View view, Rect rect, boolean z3) {
            return c(recyclerView, view, rect, z3, false);
        }

        public boolean c(RecyclerView recyclerView, View view, Rect rect, boolean z3, boolean z4) {
            int[] w3 = w(recyclerView, view, rect, z3);
            int i4 = w3[0];
            int i5 = w3[1];
            if ((!z4 || sr(recyclerView, i4, i5)) && !(i4 == 0 && i5 == 0)) {
                if (z3) {
                    recyclerView.scrollBy(i4, i5);
                } else {
                    recyclerView.c(i4, i5);
                }
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean c(RecyclerView recyclerView, View view, View view2) {
            return s() || recyclerView.t();
        }

        public boolean c(RecyclerView recyclerView, u uVar, View view, View view2) {
            return c(recyclerView, view, view2);
        }

        public void c(RecyclerView recyclerView, int i4, int i5, Object obj) {
            xv(recyclerView, i4, i5);
        }

        public void c(fp fpVar, u uVar, int i4, int i5) {
            this.gd.ux(i4, i5);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class i {
        public abstract View c(fp fpVar, int i4, int i5);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface ia {
        void c(j jVar);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class j {

        /* renamed from: c  reason: collision with root package name */
        private static final List<Object> f30531c = Collections.emptyList();
        int bk;
        RecyclerView fz;
        public final View sr;
        WeakReference<RecyclerView> ux;

        /* renamed from: f  reason: collision with root package name */
        int f30533f = -1;

        /* renamed from: r  reason: collision with root package name */
        int f30536r = -1;
        long ev = -1;
        int gd = -1;

        /* renamed from: p  reason: collision with root package name */
        int f30535p = -1;

        /* renamed from: k  reason: collision with root package name */
        j f30534k = null;

        /* renamed from: a  reason: collision with root package name */
        j f30532a = null;

        /* renamed from: t  reason: collision with root package name */
        List<Object> f30538t = null;
        List<Object> ys = null;

        /* renamed from: w  reason: collision with root package name */
        private int f30539w = 0;
        fp fp = null;
        boolean ia = false;
        private int xv = 0;

        /* renamed from: s  reason: collision with root package name */
        int f30537s = -1;

        public j(View view) {
            if (view != null) {
                this.sr = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public final int a() {
            return this.gd;
        }

        boolean ba() {
            return (this.bk & 16) == 0 && com.bytedance.sdk.component.widget.recycler.c.xv.r.f(this.sr);
        }

        boolean bk() {
            return this.fp != null;
        }

        void c(int i4, int i5, boolean z3) {
            w(8);
            c(i5, z3);
            this.f30533f = i4;
        }

        public final boolean ck() {
            return (this.bk & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.c.xv.r.f(this.sr);
        }

        public final int ev() {
            int i4 = this.f30535p;
            return i4 == -1 ? this.f30533f : i4;
        }

        void f() {
            if (this.f30536r == -1) {
                this.f30536r = this.f30533f;
            }
        }

        void fp() {
            this.bk &= -33;
        }

        boolean fz() {
            return (this.bk & 2) != 0;
        }

        List<Object> gb() {
            if ((this.bk & 1024) == 0) {
                List<Object> list = this.f30538t;
                return (list == null || list.size() == 0) ? f30531c : this.ys;
            }
            return f30531c;
        }

        public final int gd() {
            RecyclerView recyclerView = this.fz;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.sr(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i() {
            return (this.bk & 8) != 0;
        }

        void ia() {
            this.bk &= -257;
        }

        boolean j() {
            return (this.bk & 512) != 0 || s();
        }

        public final long k() {
            return this.ev;
        }

        void ls() {
            List<Object> list = this.f30538t;
            if (list != null) {
                list.clear();
            }
            this.bk &= -1025;
        }

        void n() {
            this.bk = 0;
            this.f30533f = -1;
            this.f30536r = -1;
            this.ev = -1L;
            this.f30535p = -1;
            this.f30539w = 0;
            this.f30534k = null;
            this.f30532a = null;
            ls();
            this.xv = 0;
            this.f30537s = -1;
            RecyclerView.xv(this);
        }

        public final int p() {
            return this.f30536r;
        }

        boolean q() {
            return (this.bk & 256) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean r() {
            return (this.bk & 128) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            return (this.bk & 4) != 0;
        }

        void t() {
            this.fp.xv(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f30533f + " id=" + this.ev + ", oldPos=" + this.f30536r + ", pLpos:" + this.f30535p);
            if (bk()) {
                sb.append(" scrap ");
                sb.append(this.ia ? "[changeScrap]" : "[attachedScrap]");
            }
            if (s()) {
                sb.append(" invalid");
            }
            if (!u()) {
                sb.append(" unbound");
            }
            if (fz()) {
                sb.append(" update");
            }
            if (i()) {
                sb.append(" removed");
            }
            if (r()) {
                sb.append(" ignored");
            }
            if (q()) {
                sb.append(" tmpDetached");
            }
            if (!ck()) {
                sb.append(" not recyclable(" + this.f30539w + ")");
            }
            if (j()) {
                sb.append(" undefined adapter position");
            }
            if (this.sr.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean u() {
            return (this.bk & 1) != 0;
        }

        void ux() {
            this.f30536r = -1;
            this.f30535p = -1;
        }

        void w(int i4) {
            this.bk = i4 | this.bk;
        }

        boolean y() {
            return (this.bk & 2) != 0;
        }

        boolean ys() {
            return (this.bk & 32) != 0;
        }

        boolean z() {
            return (this.bk & 16) != 0;
        }

        void w(RecyclerView recyclerView) {
            recyclerView.c(this, this.xv);
            this.xv = 0;
        }

        void c(int i4, boolean z3) {
            if (this.f30536r == -1) {
                this.f30536r = this.f30533f;
            }
            if (this.f30535p == -1) {
                this.f30535p = this.f30533f;
            }
            if (z3) {
                this.f30535p += i4;
            }
            this.f30533f += i4;
            if (this.sr.getLayoutParams() != null) {
                ((p) this.sr.getLayoutParams()).xv = true;
            }
        }

        void c(fp fpVar, boolean z3) {
            this.fp = fpVar;
            this.ia = z3;
        }

        boolean c(int i4) {
            return (i4 & this.bk) != 0;
        }

        void c(int i4, int i5) {
            this.bk = (i4 & i5) | (this.bk & (i5 ^ (-1)));
        }

        void c(Object obj) {
            if (obj == null) {
                w(1024);
            } else if ((1024 & this.bk) == 0) {
                c();
                this.f30538t.add(obj);
            }
        }

        private void c() {
            if (this.f30538t == null) {
                ArrayList arrayList = new ArrayList();
                this.f30538t = arrayList;
                this.ys = Collections.unmodifiableList(arrayList);
            }
        }

        void c(RecyclerView recyclerView) {
            int i4 = this.f30537s;
            if (i4 != -1) {
                this.xv = i4;
            } else {
                this.xv = com.bytedance.sdk.component.widget.recycler.c.xv.r.w(this.sr);
            }
            recyclerView.c(this, 4);
        }

        public final void c(boolean z3) {
            int i4 = this.f30539w;
            int i5 = z3 ? i4 - 1 : i4 + 1;
            this.f30539w = i5;
            if (i5 < 0) {
                this.f30539w = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z3 && i5 == 1) {
                this.bk |= 16;
            } else if (z3 && i5 == 0) {
                this.bk &= -17;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface k {
        void c(View view);

        void w(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class q implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        OverScroller f30542c;

        /* renamed from: f  reason: collision with root package name */
        private boolean f30543f;

        /* renamed from: r  reason: collision with root package name */
        private boolean f30544r;
        private int sr;
        private int ux;

        /* renamed from: w  reason: collision with root package name */
        Interpolator f30545w;

        q() {
            Interpolator interpolator = RecyclerView.wx;
            this.f30545w = interpolator;
            this.f30543f = false;
            this.f30544r = false;
            this.f30542c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private void sr() {
            this.f30543f = false;
            if (this.f30544r) {
                c();
            }
        }

        private void xv() {
            this.f30544r = false;
            this.f30543f = true;
        }

        void c() {
            if (this.f30543f) {
                this.f30544r = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            com.bytedance.sdk.component.widget.recycler.c.xv.r.c(RecyclerView.this, this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
            if (r8 > 0) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00ff A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 419
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.q.run():void");
        }

        public void w(int i4, int i5) {
            c(i4, i5, 0, 0);
        }

        private int w(int i4, int i5, int i6, int i7) {
            int i8;
            int abs = Math.abs(i4);
            int abs2 = Math.abs(i5);
            boolean z3 = abs > abs2;
            int sqrt = (int) Math.sqrt((i6 * i6) + (i7 * i7));
            int sqrt2 = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z3 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i9 = width / 2;
            float f4 = width;
            float f5 = i9;
            float c4 = f5 + (c(Math.min(1.0f, (sqrt2 * 1.0f) / f4)) * f5);
            if (sqrt > 0) {
                i8 = Math.round(Math.abs(c4 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z3) {
                    abs = abs2;
                }
                i8 = (int) (((abs / f4) + 1.0f) * 300.0f);
            }
            return Math.min(i8, 2000);
        }

        public void c(int i4, int i5) {
            RecyclerView.this.setScrollState(2);
            this.ux = 0;
            this.sr = 0;
            this.f30542c.fling(0, 0, i4, i5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        public void c(int i4, int i5, int i6, int i7) {
            c(i4, i5, w(i4, i5, i6, i7));
        }

        private float c(float f4) {
            return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
        }

        public void c(int i4, int i5, int i6) {
            c(i4, i5, i6, RecyclerView.wx);
        }

        public void c(int i4, int i5, Interpolator interpolator) {
            int w3 = w(i4, i5, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.wx;
            }
            c(i4, i5, w3, interpolator);
        }

        public void w() {
            RecyclerView.this.removeCallbacks(this);
            this.f30542c.abortAnimation();
        }

        public void c(int i4, int i5, int i6, Interpolator interpolator) {
            if (this.f30545w != interpolator) {
                this.f30545w = interpolator;
                this.f30542c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.ux = 0;
            this.sr = 0;
            this.f30542c.startScroll(0, 0, i4, i5, i6);
            if (Build.VERSION.SDK_INT < 23) {
                this.f30542c.computeScrollOffset();
            }
            c();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class r implements f.w {
        r() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f.w
        public void c(j jVar) {
            jVar.c(true);
            if (jVar.f30534k != null && jVar.f30532a == null) {
                jVar.f30534k = null;
            }
            jVar.f30532a = null;
            if (jVar.z() || RecyclerView.this.c(jVar.sr) || !jVar.q()) {
                return;
            }
            RecyclerView.this.removeDetachedView(jVar.sr, false);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface sr {
        int c(int i4, int i5);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class t {
        public void c(RecyclerView recyclerView, int i4) {
        }

        public void c(RecyclerView recyclerView, int i4, int i5) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ux {
        protected EdgeEffect c(RecyclerView recyclerView, int i4) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class xv {
        public void c() {
        }

        public void c(int i4, int i5) {
        }

        public void c(int i4, int i5, Object obj) {
            c(i4, i5);
        }
    }

    static {
        int i4 = Build.VERSION.SDK_INT;
        f30473c = i4 == 18 || i4 == 19 || i4 == 20;
        f30475w = i4 >= 23;
        xv = true;
        sr = i4 >= 21;
        f30476x = false;
        f30474m = false;
        Class<?> cls = Integer.TYPE;
        gw = new Class[]{Context.class, AttributeSet.class, cls, cls};
        wx = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f4) {
                float f5 = f4 - 1.0f;
                return (f5 * f5 * f5 * f5 * f5) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void ba() {
        VelocityTracker velocityTracker = this.ta;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        p(0);
        z();
    }

    private void bw() {
        boolean z3 = true;
        this.ba.c(1);
        c(this.ba);
        this.ba.gd = false;
        ux();
        this.ev.c();
        a();
        wv();
        xk();
        u uVar = this.ba;
        uVar.ev = (uVar.f30552p && this.eq) ? false : false;
        this.eq = false;
        this.f30494y = false;
        uVar.f30553r = uVar.f30551k;
        uVar.ux = this.bk.c();
        c(this.kn);
        if (this.ba.f30552p) {
            int w3 = this.f30490r.w();
            for (int i4 = 0; i4 < w3; i4++) {
                j ux2 = ux(this.f30490r.w(i4));
                if (!ux2.r() && (!ux2.s() || this.bk.w())) {
                    this.ev.c(ux2, this.gb.c(this.ba, ux2, f.ux(ux2), ux2.gb()));
                    if (this.ba.ev && ux2.y() && !ux2.i() && !ux2.r() && !ux2.s()) {
                        this.ev.c(c(ux2), ux2);
                    }
                }
            }
        }
        if (this.ba.f30551k) {
            s();
            u uVar2 = this.ba;
            boolean z4 = uVar2.f30550f;
            uVar2.f30550f = false;
            this.f30492t.c(this.ux, uVar2);
            this.ba.f30550f = z4;
            for (int i5 = 0; i5 < this.f30490r.w(); i5++) {
                j ux3 = ux(this.f30490r.w(i5));
                if (!ux3.r() && !this.ev.sr(ux3)) {
                    int ux4 = f.ux(ux3);
                    boolean c4 = ux3.c(8192);
                    if (!c4) {
                        ux4 |= 4096;
                    }
                    f.xv c5 = this.gb.c(this.ba, ux3, ux4, ux3.gb());
                    if (c4) {
                        c(ux3, c5);
                    } else {
                        this.ev.w(ux3, c5);
                    }
                }
            }
            fz();
        } else {
            fz();
        }
        bk();
        c(false);
        this.ba.sr = 2;
    }

    private void ck() {
        this.f30486n.w();
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.xk();
        }
    }

    private void eq() {
        this.bm = 0;
    }

    private void gb() {
        this.f30490r = new com.bytedance.sdk.component.widget.recycler.w(new w.InterfaceC0459w() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public int c() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void sr(View view) {
                j ux2 = RecyclerView.ux(view);
                if (ux2 != null) {
                    ux2.w(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public View w(int i4) {
                return RecyclerView.this.getChildAt(i4);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void xv(int i4) {
                j ux2;
                View w3 = w(i4);
                if (w3 != null && (ux2 = RecyclerView.ux(w3)) != null) {
                    if (ux2.q() && !ux2.r()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + ux2 + RecyclerView.this.c());
                    }
                    ux2.w(256);
                }
                RecyclerView.this.detachViewFromParent(i4);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void c(View view, int i4) {
                RecyclerView.this.addView(view, i4);
                RecyclerView.this.t(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void w() {
                int c4 = c();
                for (int i4 = 0; i4 < c4; i4++) {
                    View w3 = w(i4);
                    RecyclerView.this.bk(w3);
                    w3.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public int c(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void c(int i4) {
                View childAt = RecyclerView.this.getChildAt(i4);
                if (childAt != null) {
                    RecyclerView.this.bk(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i4);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public j w(View view) {
                return RecyclerView.ux(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void xv(View view) {
                j ux2 = RecyclerView.ux(view);
                if (ux2 != null) {
                    ux2.c(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.w.InterfaceC0459w
            public void c(View view, int i4, ViewGroup.LayoutParams layoutParams) {
                j ux2 = RecyclerView.ux(view);
                if (ux2 != null) {
                    if (!ux2.q() && !ux2.r()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + ux2 + RecyclerView.this.c());
                    }
                    ux2.ia();
                }
                RecyclerView.this.attachViewToParent(view, i4, layoutParams);
            }
        });
    }

    private com.bytedance.sdk.component.widget.recycler.c.xv.sr getScrollingChildHelper() {
        if (this.qy == null) {
            this.qy = new com.bytedance.sdk.component.widget.recycler.c.xv.sr(this);
        }
        return this.qy;
    }

    @SuppressLint({"InlinedApi"})
    private void ls() {
        if (com.bytedance.sdk.component.widget.recycler.c.xv.r.gd(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.c.xv.r.w(this, 8);
        }
    }

    private void m() {
        this.ba.c(4);
        ux();
        a();
        u uVar = this.ba;
        uVar.sr = 1;
        if (uVar.f30552p) {
            for (int w3 = this.f30490r.w() - 1; w3 >= 0; w3--) {
                j ux2 = ux(this.f30490r.w(w3));
                if (!ux2.r()) {
                    long c4 = c(ux2);
                    f.xv c5 = this.gb.c(this.ba, ux2);
                    j c6 = this.ev.c(c4);
                    if (c6 != null && !c6.r()) {
                        boolean c7 = this.ev.c(c6);
                        boolean c8 = this.ev.c(ux2);
                        if (c7 && c6 == ux2) {
                            this.ev.xv(ux2, c5);
                        } else {
                            f.xv w4 = this.ev.w(c6);
                            this.ev.xv(ux2, c5);
                            f.xv xv2 = this.ev.xv(ux2);
                            if (w4 == null) {
                                c(c4, ux2, c6);
                            } else {
                                c(c6, ux2, w4, xv2, c7, c8);
                            }
                        }
                    } else {
                        this.ev.xv(ux2, c5);
                    }
                }
            }
            this.ev.c(this.f30487o);
        }
        this.f30492t.w(this.ux);
        u uVar2 = this.ba;
        uVar2.f30555w = uVar2.ux;
        this.f30484j = false;
        this.ls = false;
        uVar2.f30552p = false;
        uVar2.f30551k = false;
        this.f30492t.bk = false;
        ArrayList<j> arrayList = this.ux.f30511w;
        if (arrayList != null) {
            arrayList.clear();
        }
        gd gdVar = this.f30492t;
        if (gdVar.ia) {
            gdVar.fp = 0;
            gdVar.ia = false;
            this.ux.w();
        }
        this.f30492t.w(this.ba);
        bk();
        c(false);
        this.ev.c();
        int[] iArr = this.kn;
        if (k(iArr[0], iArr[1])) {
            gd(0, 0);
        }
        pr();
        yu();
    }

    private boolean me() {
        return this.gb != null && this.f30492t.t();
    }

    private boolean n() {
        int w3 = this.f30490r.w();
        for (int i4 = 0; i4 < w3; i4++) {
            j ux2 = ux(this.f30490r.w(i4));
            if (ux2 != null && !ux2.r() && ux2.y()) {
                return true;
            }
        }
        return false;
    }

    private void pr() {
        View findViewById;
        if (!this.zr || this.bk == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (f30474m && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.f30490r.w() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.f30490r.xv(focusedChild)) {
                return;
            }
        }
        View view = null;
        j c4 = (this.ba.bk == -1 || !this.bk.w()) ? null : c(this.ba.bk);
        if (c4 != null && !this.f30490r.xv(c4.sr) && c4.sr.hasFocusable()) {
            view = c4.sr;
        } else if (this.f30490r.w() > 0) {
            view = wx();
        }
        if (view != null) {
            int i4 = this.ba.f30554t;
            if (i4 != -1 && (findViewById = view.findViewById(i4)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void ux(j jVar) {
        View view = jVar.sr;
        boolean z3 = view.getParent() == this;
        this.ux.xv(w(view));
        if (jVar.q()) {
            this.f30490r.c(view, -1, view.getLayoutParams(), true);
        } else if (!z3) {
            this.f30490r.c(view, true);
        } else {
            this.f30490r.sr(view);
        }
    }

    private void wv() {
        boolean z3;
        if (this.f30484j) {
            this.f30480f.c();
            if (this.ls) {
                this.f30492t.ux(this);
            }
        }
        if (me()) {
            this.f30480f.w();
        } else {
            this.f30480f.ux();
        }
        boolean z4 = false;
        boolean z5 = this.f30494y || this.eq;
        this.ba.f30552p = this.fz && this.gb != null && ((z3 = this.f30484j) || z5 || this.f30492t.bk) && (!z3 || this.bk.w());
        u uVar = this.ba;
        if (uVar.f30552p && z5 && !this.f30484j && me()) {
            z4 = true;
        }
        uVar.f30551k = z4;
    }

    private View wx() {
        j ux2;
        u uVar = this.ba;
        int i4 = uVar.f30548a;
        if (i4 == -1) {
            i4 = 0;
        }
        int sr2 = uVar.sr();
        for (int i5 = i4; i5 < sr2; i5++) {
            j ux3 = ux(i5);
            if (ux3 == null) {
                break;
            } else if (ux3.sr.hasFocusable()) {
                return ux3.sr;
            }
        }
        int min = Math.min(sr2, i4);
        while (true) {
            min--;
            if (min < 0 || (ux2 = ux(min)) == null) {
                return null;
            }
            if (ux2.sr.hasFocusable()) {
                return ux2.sr;
            }
        }
    }

    private void x() {
        ux();
        a();
        this.ba.c(6);
        this.f30480f.ux();
        this.ba.ux = this.bk.c();
        u uVar = this.ba;
        uVar.xv = 0;
        uVar.f30553r = false;
        this.f30492t.c(this.ux, uVar);
        u uVar2 = this.ba;
        uVar2.f30550f = false;
        uVar2.f30552p = uVar2.f30552p && this.gb != null;
        uVar2.sr = 4;
        bk();
        c(false);
    }

    private void xk() {
        View focusedChild = (this.zr && hasFocus() && this.bk != null) ? getFocusedChild() : null;
        j sr2 = focusedChild != null ? sr(focusedChild) : null;
        if (sr2 == null) {
            yu();
            return;
        }
        this.ba.bk = this.bk.w() ? sr2.k() : -1L;
        this.ba.f30548a = this.f30484j ? -1 : sr2.i() ? sr2.f30536r : sr2.gd();
        this.ba.f30554t = ys(sr2.sr);
    }

    private void y() {
        ba();
        setScrollState(0);
    }

    private void yu() {
        u uVar = this.ba;
        uVar.bk = -1L;
        uVar.f30548a = -1;
        uVar.f30554t = -1;
    }

    private void z() {
        boolean z3;
        EdgeEffect edgeEffect = this.ok;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z3 = this.ok.isFinished();
        } else {
            z3 = false;
        }
        EdgeEffect edgeEffect2 = this.f30482h;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z3 |= this.f30482h.isFinished();
        }
        EdgeEffect edgeEffect3 = this.oh;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z3 |= this.oh.isFinished();
        }
        EdgeEffect edgeEffect4 = this.fm;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z3 |= this.fm.isFinished();
        }
        if (z3) {
            com.bytedance.sdk.component.widget.recycler.c.xv.r.xv(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.ox++;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i4, int i5) {
        gd gdVar = this.f30492t;
        if (gdVar == null || !gdVar.c(this, arrayList, i4, i5)) {
            super.addFocusables(arrayList, i4, i5);
        }
    }

    void bk() {
        w(true);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f30492t.c((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        gd gdVar = this.f30492t;
        if (gdVar != null && gdVar.xv()) {
            return this.f30492t.ux(this.ba);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        gd gdVar = this.f30492t;
        if (gdVar != null && gdVar.xv()) {
            return this.f30492t.xv(this.ba);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        gd gdVar = this.f30492t;
        if (gdVar != null && gdVar.xv()) {
            return this.f30492t.r(this.ba);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        gd gdVar = this.f30492t;
        if (gdVar != null && gdVar.sr()) {
            return this.f30492t.f(this.ba);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        gd gdVar = this.f30492t;
        if (gdVar != null && gdVar.sr()) {
            return this.f30492t.sr(this.ba);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        gd gdVar = this.f30492t;
        if (gdVar != null && gdVar.sr()) {
            return this.f30492t.ev(this.ba);
        }
        return 0;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        return getScrollingChildHelper().c(f4, f5, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().c(f4, f5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return getScrollingChildHelper().c(i4, i5, i6, i7, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z3;
        super.draw(canvas);
        int size = this.fp.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            this.fp.get(i4).w(canvas, this, this.ba);
        }
        EdgeEffect edgeEffect = this.ok;
        boolean z5 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z3 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.gd ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.ok;
            z3 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.f30482h;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.gd) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f30482h;
            z3 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.oh;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.gd ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.oh;
            z3 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.fm;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.gd) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.fm;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 |= z4;
            canvas.restoreToCount(save4);
        }
        if (z3 || this.gb == null || this.fp.size() <= 0 || !this.gb.w()) {
            z5 = z3;
        }
        if (z5) {
            com.bytedance.sdk.component.widget.recycler.c.xv.r.xv(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    void ev() {
        if (this.oh == null) {
            EdgeEffect c4 = this.ng.c(this, 2);
            this.oh = c4;
            if (this.gd) {
                c4.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                c4.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ev(int i4) {
    }

    public void ev(int i4, int i5) {
    }

    public void f() {
        setScrollState(0);
        ck();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i4) {
        View view2;
        boolean z3;
        View sr2 = this.f30492t.sr(view, i4);
        if (sr2 != null) {
            return sr2;
        }
        boolean z4 = (this.bk == null || this.f30492t == null || t() || this.f30483i) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z4 && (i4 == 2 || i4 == 1)) {
            if (this.f30492t.sr()) {
                int i5 = i4 == 2 ? 130 : 33;
                z3 = focusFinder.findNextFocus(this, view, i5) == null;
                if (f30476x) {
                    i4 = i5;
                }
            } else {
                z3 = false;
            }
            if (!z3 && this.f30492t.xv()) {
                int i6 = (this.f30492t.fz() == 1) ^ (i4 == 2) ? 66 : 17;
                boolean z5 = focusFinder.findNextFocus(this, view, i6) == null;
                if (f30476x) {
                    i4 = i6;
                }
                z3 = z5;
            }
            if (z3) {
                sr();
                if (xv(view) == null) {
                    return null;
                }
                ux();
                this.f30492t.c(view, i4, this.ux, this.ba);
                c(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i4);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i4);
            if (findNextFocus == null && z4) {
                sr();
                if (xv(view) == null) {
                    return null;
                }
                ux();
                view2 = this.f30492t.c(view, i4, this.ux, this.ba);
                c(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return c(view, view2, i4) ? view2 : super.focusSearch(view, i4);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i4);
        } else {
            c(view2, (View) null);
            return view;
        }
    }

    void fp() {
        if (this.bk == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f30492t == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            u uVar = this.ba;
            uVar.gd = false;
            if (uVar.sr == 1) {
                bw();
                this.f30492t.f(this);
                x();
            } else if (!this.f30480f.f() && this.f30492t.ls() == getWidth() && this.f30492t.gb() == getHeight()) {
                this.f30492t.f(this);
            } else {
                this.f30492t.f(this);
                x();
            }
            m();
        }
    }

    void fz() {
        int xv2 = this.f30490r.xv();
        for (int i4 = 0; i4 < xv2; i4++) {
            j ux2 = ux(this.f30490r.sr(i4));
            if (!ux2.r()) {
                ux2.ux();
            }
        }
        this.ux.gd();
    }

    void gd() {
        if (this.f30482h == null) {
            EdgeEffect c4 = this.ng.c(this, 1);
            this.f30482h = c4;
            if (this.gd) {
                c4.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                c4.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void gd(View view) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            return gdVar.w();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + c());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            return gdVar.c(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + c());
    }

    public c getAdapter() {
        return this.bk;
    }

    @Override // android.view.View
    public int getBaseline() {
        gd gdVar = this.f30492t;
        return gdVar != null ? gdVar.u() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i4, int i5) {
        sr srVar = this.lw;
        return srVar == null ? super.getChildDrawingOrder(i4, i5) : srVar.c(i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.gd;
    }

    public ux getEdgeEffectFactory() {
        return this.ng;
    }

    public f getItemAnimator() {
        return this.gb;
    }

    public int getItemDecorationCount() {
        return this.fp.size();
    }

    public gd getLayoutManager() {
        return this.f30492t;
    }

    public int getMaxFlingVelocity() {
        return this.f30479e;
    }

    public int getMinFlingVelocity() {
        return this.mu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (sr) {
            return System.nanoTime();
        }
        return 0L;
    }

    public a getOnFlingListener() {
        return this.xg;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.zr;
    }

    public ys getRecycledViewPool() {
        return this.ux.r();
    }

    public int getScrollState() {
        return this.te;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().w();
    }

    public boolean i() {
        return !this.fz || this.f30484j || this.f30480f.sr();
    }

    void ia() {
        int xv2 = this.f30490r.xv();
        for (int i4 = 0; i4 < xv2; i4++) {
            ((p) this.f30490r.sr(i4).getLayoutParams()).xv = true;
        }
        this.ux.p();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.ia;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().c();
    }

    void j() {
        int i4;
        for (int size = this.yu.size() - 1; size >= 0; size--) {
            j jVar = this.yu.get(size);
            if (jVar.sr.getParent() == this && !jVar.r() && (i4 = jVar.f30537s) != -1) {
                com.bytedance.sdk.component.widget.recycler.c.xv.r.c(jVar.sr, i4);
                jVar.f30537s = -1;
            }
        }
        this.yu.clear();
    }

    void k() {
        this.fm = null;
        this.f30482h = null;
        this.oh = null;
        this.ok = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ox = 0;
        boolean z3 = true;
        this.ia = true;
        this.fz = (!this.fz || isLayoutRequested()) ? false : false;
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.w(this);
        }
        this.me = false;
        if (sr) {
            ThreadLocal<com.bytedance.sdk.component.widget.recycler.sr> threadLocal = com.bytedance.sdk.component.widget.recycler.sr.f30597c;
            com.bytedance.sdk.component.widget.recycler.sr srVar = threadLocal.get();
            this.ck = srVar;
            if (srVar == null) {
                this.ck = new com.bytedance.sdk.component.widget.recycler.sr();
                Display r3 = com.bytedance.sdk.component.widget.recycler.c.xv.r.r(this);
                float f4 = 60.0f;
                if (!isInEditMode() && r3 != null) {
                    float refreshRate = r3.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f4 = refreshRate;
                    }
                }
                com.bytedance.sdk.component.widget.recycler.sr srVar2 = this.ck;
                srVar2.sr = 1.0E9f / f4;
                threadLocal.set(srVar2);
            }
            this.ck.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.sr srVar;
        super.onDetachedFromWindow();
        f fVar = this.gb;
        if (fVar != null) {
            fVar.sr();
        }
        f();
        this.ia = false;
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.w(this, this.ux);
        }
        this.yu.clear();
        removeCallbacks(this.zg);
        this.ev.w();
        if (!sr || (srVar = this.ck) == null) {
            return;
        }
        srVar.w(this);
        this.ck = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.fp.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.fp.get(i4).c(canvas, this, this.ba);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.RecyclerView$gd r0 = r5.f30492t
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f30483i
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            com.bytedance.sdk.component.widget.recycler.RecyclerView$gd r0 = r5.f30492t
            boolean r0 = r0.sr()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$gd r3 = r5.f30492t
            boolean r3 = r3.xv()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$gd r3 = r5.f30492t
            boolean r3 = r3.sr()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$gd r3 = r5.f30492t
            boolean r3 = r3.xv()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.tl
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.kk
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.c(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        if (this.f30483i) {
            return false;
        }
        if (c(motionEvent)) {
            y();
            return true;
        }
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            return false;
        }
        boolean xv2 = gdVar.xv();
        boolean sr2 = this.f30492t.sr();
        if (this.ta == null) {
            this.ta = VelocityTracker.obtain();
        }
        this.ta.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.bj) {
                this.bj = false;
            }
            this.ge = motionEvent.getPointerId(0);
            int x3 = (int) (motionEvent.getX() + 0.5f);
            this.f30481g = x3;
            this.eu = x3;
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.bs = y3;
            this.be = y3;
            if (this.te == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.gp;
            iArr[1] = 0;
            iArr[0] = 0;
            int i4 = xv2;
            if (sr2) {
                i4 = (xv2 ? 1 : 0) | 2;
            }
            p(i4, 0);
        } else if (actionMasked == 1) {
            this.ta.clear();
            p(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ge);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ge + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x4 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.te != 1) {
                int i5 = x4 - this.eu;
                int i6 = y4 - this.be;
                if (!xv2 || Math.abs(i5) <= this.lf) {
                    z3 = false;
                } else {
                    this.f30481g = x4;
                    z3 = true;
                }
                if (sr2 && Math.abs(i6) > this.lf) {
                    this.bs = y4;
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.ge = motionEvent.getPointerId(actionIndex);
            int x5 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f30481g = x5;
            this.eu = x5;
            int y5 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.bs = y5;
            this.be = y5;
        } else if (actionMasked == 6) {
            xv(motionEvent);
        }
        return this.te == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV OnLayout");
        fp();
        com.bytedance.sdk.component.widget.recycler.c.c.c.c();
        this.fz = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            ux(i4, i5);
            return;
        }
        boolean z3 = false;
        if (!gdVar.c()) {
            if (this.f30491s) {
                this.f30492t.c(this.ux, this.ba, i4, i5);
                return;
            }
            if (this.f30489q) {
                ux();
                a();
                wv();
                bk();
                u uVar = this.ba;
                if (uVar.f30551k) {
                    uVar.f30553r = true;
                } else {
                    this.f30480f.ux();
                    this.ba.f30553r = false;
                }
                this.f30489q = false;
                c(false);
            } else if (this.ba.f30551k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            c cVar = this.bk;
            if (cVar != null) {
                this.ba.ux = cVar.c();
            } else {
                this.ba.ux = 0;
            }
            ux();
            this.f30492t.c(this.ux, this.ba, i4, i5);
            c(false);
            this.ba.f30553r = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        this.f30492t.c(this.ux, this.ba, i4, i5);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z3 = true;
        }
        if (z3 || this.bk == null) {
            return;
        }
        if (this.ba.sr == 1) {
            bw();
        }
        this.f30492t.w(i4, i5);
        this.ba.gd = true;
        x();
        this.f30492t.xv(i4, i5);
        if (this.f30492t.gd()) {
            this.f30492t.w(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.ba.gd = true;
            x();
            this.f30492t.xv(i4, i5);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (t()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 == i6 && i5 == i7) {
            return;
        }
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p() {
        if (this.fm == null) {
            EdgeEffect c4 = this.ng.c(this, 3);
            this.fm = c4;
            if (this.gd) {
                c4.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                c4.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void p(View view) {
    }

    void q() {
        j jVar;
        int w3 = this.f30490r.w();
        for (int i4 = 0; i4 < w3; i4++) {
            View w4 = this.f30490r.w(i4);
            j w5 = w(w4);
            if (w5 != null && (jVar = w5.f30532a) != null) {
                View view = jVar.sr;
                int left = w4.getLeft();
                int top2 = w4.getTop();
                if (left != view.getLeft() || top2 != view.getTop()) {
                    view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
                }
            }
        }
    }

    void r() {
        if (this.ok == null) {
            EdgeEffect c4 = this.ng.c(this, 0);
            this.ok = c4;
            if (this.gd) {
                c4.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                c4.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z3) {
        j ux2 = ux(view);
        if (ux2 != null) {
            if (ux2.q()) {
                ux2.ia();
            } else if (!ux2.r()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + ux2 + c());
            }
        }
        view.clearAnimation();
        bk(view);
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f30492t.c(this, this.ba, view, view2) && view2 != null) {
            c(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        return this.f30492t.c(this, view, rect, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        int size = this.mt.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mt.get(i4).c(z3);
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.au == 0 && !this.f30483i) {
            super.requestLayout();
        } else {
            this.f30493u = true;
        }
    }

    void s() {
        int xv2 = this.f30490r.xv();
        for (int i4 = 0; i4 < xv2; i4++) {
            j ux2 = ux(this.f30490r.sr(i4));
            if (!ux2.r()) {
                ux2.f();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i4, int i5) {
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f30483i) {
        } else {
            boolean xv2 = gdVar.xv();
            boolean sr2 = this.f30492t.sr();
            if (xv2 || sr2) {
                if (!xv2) {
                    i4 = 0;
                }
                if (!sr2) {
                    i5 = 0;
                }
                c(i4, i5, (MotionEvent) null);
            }
        }
    }

    public void setAdapter(c cVar) {
        setLayoutFrozen(false);
        c(cVar, false, true);
        xv(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(sr srVar) {
        if (srVar != this.lw) {
            this.lw = srVar;
            setChildrenDrawingOrderEnabled(srVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z3) {
        if (z3 != this.gd) {
            k();
        }
        this.gd = z3;
        super.setClipToPadding(z3);
        if (this.fz) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(ux uxVar) {
        c(uxVar);
        this.ng = uxVar;
        k();
    }

    public void setHasFixedSize(boolean z3) {
        this.f30491s = z3;
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.gb;
        if (fVar2 != null) {
            fVar2.sr();
            this.gb.c((f.w) null);
        }
        this.gb = fVar;
        if (fVar != null) {
            fVar.c(this.rh);
        }
    }

    public void setItemViewCacheSize(int i4) {
        this.ux.c(i4);
    }

    public void setLayoutFrozen(boolean z3) {
        if (z3 != this.f30483i) {
            c("Do not setLayoutFrozen in layout or scroll");
            if (!z3) {
                this.f30483i = false;
                if (this.f30493u && this.f30492t != null && this.bk != null) {
                    requestLayout();
                }
                this.f30493u = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f30483i = true;
            this.bj = true;
            f();
        }
    }

    public void setLayoutManager(gd gdVar) {
        if (gdVar != this.f30492t) {
            f();
            if (this.f30492t != null) {
                f fVar = this.gb;
                if (fVar != null) {
                    fVar.sr();
                }
                this.f30492t.xv(this.ux);
                this.f30492t.w(this.ux);
                this.ux.c();
                if (this.ia) {
                    this.f30492t.w(this, this.ux);
                }
                this.f30492t.c((RecyclerView) null);
                this.f30492t = null;
            } else {
                this.ux.c();
            }
            this.f30490r.c();
            this.f30492t = gdVar;
            if (gdVar != null) {
                if (gdVar.gd == null) {
                    gdVar.c(this);
                    if (this.ia) {
                        this.f30492t.w(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + gdVar + " is already attached to a RecyclerView:" + gdVar.gd.c());
                }
            }
            this.ux.w();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        getScrollingChildHelper().c(z3);
    }

    public void setOnFlingListener(a aVar) {
        this.xg = aVar;
    }

    public void setPreserveFocusAfterLayout(boolean z3) {
        this.zr = z3;
    }

    public void setRecycledViewPool(ys ysVar) {
        this.ux.c(ysVar);
    }

    public void setRecyclerListener(ia iaVar) {
        this.ys = iaVar;
    }

    void setScrollState(int i4) {
        if (i4 != this.te) {
            this.te = i4;
            if (i4 != 2) {
                ck();
            }
            gd(i4);
        }
    }

    public void setViewCacheExtension(i iVar) {
        this.ux.c(iVar);
    }

    void sr() {
        if (this.fz && !this.f30484j) {
            if (this.f30480f.sr()) {
                if (this.f30480f.c(4) && !this.f30480f.c(11)) {
                    com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV PartialInvalidate");
                    ux();
                    a();
                    this.f30480f.w();
                    if (!this.f30493u) {
                        if (n()) {
                            fp();
                        } else {
                            this.f30480f.xv();
                        }
                    }
                    c(true);
                    bk();
                    com.bytedance.sdk.component.widget.recycler.c.c.c.c();
                    return;
                } else if (this.f30480f.sr()) {
                    com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV FullInvalidate");
                    fp();
                    com.bytedance.sdk.component.widget.recycler.c.c.c.c();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV FullInvalidate");
        fp();
        com.bytedance.sdk.component.widget.recycler.c.c.c.c();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i4) {
        return getScrollingChildHelper().w(i4);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.c.xv.w
    public void stopNestedScroll() {
        getScrollingChildHelper().xv();
    }

    public boolean t() {
        return this.ox > 0;
    }

    void u() {
        int xv2 = this.f30490r.xv();
        for (int i4 = 0; i4 < xv2; i4++) {
            j ux2 = ux(this.f30490r.sr(i4));
            if (ux2 != null && !ux2.r()) {
                ux2.w(6);
            }
        }
        ia();
        this.ux.ev();
    }

    void w() {
        this.f30480f = new com.bytedance.sdk.component.widget.recycler.c(new c.InterfaceC0458c() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public j c(int i4) {
                j c4 = RecyclerView.this.c(i4, true);
                if (c4 == null || RecyclerView.this.f30490r.xv(c4.sr)) {
                    return null;
                }
                return c4;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void sr(int i4, int i5) {
                RecyclerView.this.f(i4, i5);
                RecyclerView.this.f30494y = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void w(int i4, int i5) {
                RecyclerView.this.c(i4, i5, false);
                RecyclerView.this.f30494y = true;
            }

            void xv(c.w wVar) {
                int i4 = wVar.f30573c;
                if (i4 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.f30492t.c(recyclerView, wVar.f30574w, wVar.sr);
                } else if (i4 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.f30492t.w(recyclerView2, wVar.f30574w, wVar.sr);
                } else if (i4 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.f30492t.c(recyclerView3, wVar.f30574w, wVar.sr, wVar.xv);
                } else if (i4 != 8) {
                } else {
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.f30492t.c(recyclerView4, wVar.f30574w, wVar.sr, 1);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void c(int i4, int i5) {
                RecyclerView.this.c(i4, i5, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f30494y = true;
                recyclerView.ba.xv += i5;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void w(c.w wVar) {
                xv(wVar);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void xv(int i4, int i5) {
                RecyclerView.this.r(i4, i5);
                RecyclerView.this.f30494y = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void c(int i4, int i5, Object obj) {
                RecyclerView.this.c(i4, i5, obj);
                RecyclerView.this.eq = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.c.InterfaceC0458c
            public void c(c.w wVar) {
                xv(wVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv() {
        f fVar = this.gb;
        if (fVar != null) {
            fVar.sr();
        }
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.xv(this.ux);
            this.f30492t.w(this.ux);
        }
        this.ux.c();
    }

    void ys() {
        if (this.me || !this.ia) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.c.xv.r.c(this, this.zg);
        this.me = true;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class u {

        /* renamed from: a  reason: collision with root package name */
        int f30548a;
        long bk;
        int fp;
        private SparseArray<Object> ia;

        /* renamed from: t  reason: collision with root package name */
        int f30554t;
        int ys;

        /* renamed from: c  reason: collision with root package name */
        int f30549c = -1;

        /* renamed from: w  reason: collision with root package name */
        int f30555w = 0;
        int xv = 0;
        int sr = 1;
        int ux = 0;

        /* renamed from: f  reason: collision with root package name */
        boolean f30550f = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f30553r = false;
        boolean ev = false;
        boolean gd = false;

        /* renamed from: p  reason: collision with root package name */
        boolean f30552p = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f30551k = false;

        void c(int i4) {
            if ((this.sr & i4) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i4) + " but it is " + Integer.toBinaryString(this.sr));
        }

        public int sr() {
            return this.f30553r ? this.f30555w - this.xv : this.ux;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f30549c + ", mData=" + this.ia + ", mItemCount=" + this.ux + ", mIsMeasuring=" + this.gd + ", mPreviousLayoutItemCount=" + this.f30555w + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.xv + ", mStructureChanged=" + this.f30550f + ", mInPreLayout=" + this.f30553r + ", mRunSimpleAnimations=" + this.f30552p + ", mRunPredictiveAnimations=" + this.f30551k + '}';
        }

        public boolean w() {
            return this.f30551k;
        }

        public boolean xv() {
            return this.f30549c != -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(c cVar) {
            this.sr = 1;
            this.ux = cVar.c();
            this.f30553r = false;
            this.ev = false;
            this.gd = false;
        }

        public boolean c() {
            return this.f30553r;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w extends Observable<xv> {
        w() {
        }

        public void c() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((xv) ((Observable) this).mObservers.get(size)).c();
            }
        }

        public void c(int i4, int i5) {
            c(i4, i5, null);
        }

        public void c(int i4, int i5, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((xv) ((Observable) this).mObservers.get(size)).c(i4, i5, obj);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ys {

        /* renamed from: c  reason: collision with root package name */
        SparseArray<c> f30556c = new SparseArray<>();

        /* renamed from: w  reason: collision with root package name */
        private int f30557w = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class c {

            /* renamed from: c  reason: collision with root package name */
            final ArrayList<j> f30558c = new ArrayList<>();

            /* renamed from: w  reason: collision with root package name */
            int f30559w = 5;
            long xv = 0;
            long sr = 0;

            c() {
            }
        }

        public void c() {
            for (int i4 = 0; i4 < this.f30556c.size(); i4++) {
                this.f30556c.valueAt(i4).f30558c.clear();
            }
        }

        void w(int i4, long j4) {
            c w3 = w(i4);
            w3.sr = c(w3.sr, j4);
        }

        void xv() {
            this.f30557w--;
        }

        boolean w(int i4, long j4, long j5) {
            long j6 = w(i4).sr;
            return j6 == 0 || j4 + j6 < j5;
        }

        public j c(int i4) {
            c cVar = this.f30556c.get(i4);
            if (cVar == null || cVar.f30558c.isEmpty()) {
                return null;
            }
            ArrayList<j> arrayList = cVar.f30558c;
            return arrayList.remove(arrayList.size() - 1);
        }

        void w() {
            this.f30557w++;
        }

        private c w(int i4) {
            c cVar = this.f30556c.get(i4);
            if (cVar == null) {
                c cVar2 = new c();
                this.f30556c.put(i4, cVar2);
                return cVar2;
            }
            return cVar;
        }

        public void c(j jVar) {
            int a4 = jVar.a();
            ArrayList<j> arrayList = w(a4).f30558c;
            if (this.f30556c.get(a4).f30559w > arrayList.size()) {
                jVar.n();
                arrayList.add(jVar);
            }
        }

        long c(long j4, long j5) {
            if (j4 == 0) {
                return j5;
            }
            return (j5 / 4) + ((j4 / 4) * 3);
        }

        void c(int i4, long j4) {
            c w3 = w(i4);
            w3.xv = c(w3.xv, j4);
        }

        boolean c(int i4, long j4, long j5) {
            long j6 = w(i4).xv;
            return j6 == 0 || j4 + j6 < j5;
        }

        void c(c cVar, c cVar2, boolean z3) {
            if (cVar != null) {
                xv();
            }
            if (!z3 && this.f30557w == 0) {
                c();
            }
            if (cVar2 != null) {
                w();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static RecyclerView a(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                RecyclerView a4 = a(viewGroup.getChildAt(i4));
                if (a4 != null) {
                    return a4;
                }
            }
            return null;
        }
        return null;
    }

    private boolean k(int i4, int i5) {
        c(this.kn);
        int[] iArr = this.kn;
        return (iArr[0] == i4 && iArr[1] == i5) ? false : true;
    }

    void bk(View view) {
        j ux2 = ux(view);
        p(view);
        c cVar = this.bk;
        if (cVar != null && ux2 != null) {
            cVar.sr(ux2);
        }
        List<k> list = this.wo;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.wo.get(size).w(view);
            }
        }
    }

    void t(View view) {
        j ux2 = ux(view);
        gd(view);
        c cVar = this.bk;
        if (cVar != null && ux2 != null) {
            cVar.xv(ux2);
        }
        List<k> list = this.wo;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.wo.get(size).c(view);
            }
        }
    }

    public void w(t tVar) {
        List<t> list = this.eb;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.vc = new s();
        this.ux = new fp();
        this.ev = new com.bytedance.sdk.component.widget.recycler.t();
        this.f30488p = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.fz || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.ia) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.f30483i) {
                    recyclerView2.f30493u = true;
                } else {
                    recyclerView2.sr();
                }
            }
        };
        this.f30485k = new Rect();
        this.up = new Rect();
        this.f30477a = new RectF();
        this.fp = new ArrayList<>();
        this.mt = new ArrayList<>();
        this.au = 0;
        this.f30484j = false;
        this.ls = false;
        this.ox = 0;
        this.xu = 0;
        this.ng = new ux();
        this.gb = new com.bytedance.sdk.component.widget.recycler.xv();
        this.te = 0;
        this.ge = -1;
        this.tl = Float.MIN_VALUE;
        this.kk = Float.MIN_VALUE;
        this.zr = true;
        this.f30486n = new q();
        this.f30495z = sr ? new sr.c() : null;
        this.ba = new u();
        this.f30494y = false;
        this.eq = false;
        this.rh = new r();
        this.me = false;
        this.kn = new int[2];
        this.iw = new int[2];
        this.wv = new int[2];
        this.gp = new int[2];
        this.xk = new int[2];
        this.yu = new ArrayList();
        this.zg = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                f fVar = RecyclerView.this.gb;
                if (fVar != null) {
                    fVar.c();
                }
                RecyclerView.this.me = false;
            }
        };
        this.f30487o = new t.w() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.t.w
            public void c(j jVar, f.xv xvVar, f.xv xvVar2) {
                RecyclerView.this.ux.xv(jVar);
                RecyclerView.this.w(jVar, xvVar, xvVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.t.w
            public void w(j jVar, f.xv xvVar, f.xv xvVar2) {
                RecyclerView.this.c(jVar, xvVar, xvVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.t.w
            public void xv(j jVar, f.xv xvVar, f.xv xvVar2) {
                jVar.c(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f30484j) {
                    if (recyclerView.gb.c(jVar, jVar, xvVar, xvVar2)) {
                        RecyclerView.this.ys();
                    }
                } else if (recyclerView.gb.xv(jVar, xvVar, xvVar2)) {
                    RecyclerView.this.ys();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.t.w
            public void c(j jVar) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f30492t.c(jVar.sr, recyclerView.ux);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bw, i4, 0);
                this.gd = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else {
            this.gd = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.lf = viewConfiguration.getScaledTouchSlop();
        this.tl = com.bytedance.sdk.component.widget.recycler.c.xv.r.c(viewConfiguration, context);
        this.kk = com.bytedance.sdk.component.widget.recycler.c.xv.r.w(viewConfiguration, context);
        this.mu = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f30479e = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.gb.c(this.rh);
        w();
        gb();
        ls();
        if (com.bytedance.sdk.component.widget.recycler.c.xv.r.w(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.c.xv.r.c(this, 1);
        }
        this.f30478b = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
                int i5 = Build.VERSION.SDK_INT;
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        setNestedScrollingEnabled(true);
    }

    void f(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int xv2 = this.f30490r.xv();
        if (i4 < i5) {
            i8 = -1;
            i7 = i4;
            i6 = i5;
        } else {
            i6 = i4;
            i7 = i5;
            i8 = 1;
        }
        for (int i10 = 0; i10 < xv2; i10++) {
            j ux2 = ux(this.f30490r.sr(i10));
            if (ux2 != null && (i9 = ux2.f30533f) >= i7 && i9 <= i6) {
                if (i9 == i4) {
                    ux2.c(i5 - i4, false);
                } else {
                    ux2.c(i8, false);
                }
                this.ba.f30550f = true;
            }
        }
        this.ux.c(i4, i5);
        requestLayout();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: c  reason: collision with root package name */
        j f30540c;
        boolean sr;

        /* renamed from: w  reason: collision with root package name */
        final Rect f30541w;
        boolean xv;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f30541w = new Rect();
            this.xv = true;
            this.sr = false;
        }

        public boolean c() {
            return this.f30540c.s();
        }

        public int sr() {
            return this.f30540c.ev();
        }

        public boolean w() {
            return this.f30540c.i();
        }

        public boolean xv() {
            return this.f30540c.y();
        }

        public p(int i4, int i5) {
            super(i4, i5);
            this.f30541w = new Rect();
            this.xv = true;
            this.sr = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f30541w = new Rect();
            this.xv = true;
            this.sr = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f30541w = new Rect();
            this.xv = true;
            this.sr = false;
        }

        public p(p pVar) {
            super((ViewGroup.MarginLayoutParams) pVar);
            this.f30541w = new Rect();
            this.xv = true;
            this.sr = false;
        }
    }

    private int ys(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            return gdVar.c(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + c());
    }

    Rect k(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.xv) {
            return pVar.f30541w;
        }
        if (this.ba.c() && (pVar.xv() || pVar.c())) {
            return pVar.f30541w;
        }
        Rect rect = pVar.f30541w;
        rect.set(0, 0, 0, 0);
        int size = this.fp.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f30485k.set(0, 0, 0, 0);
            this.fp.get(i4).c(this.f30485k, view, this, this.ba);
            int i5 = rect.left;
            Rect rect2 = this.f30485k;
            rect.left = i5 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.xv = false;
        return rect;
    }

    void w(int i4) {
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.sr(i4);
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class s extends xv {
        s() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xv
        public void c() {
            RecyclerView.this.c((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.ba.f30550f = true;
            recyclerView.xv(true);
            if (RecyclerView.this.f30480f.sr()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        void w() {
            if (RecyclerView.xv) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f30491s && recyclerView.ia) {
                    com.bytedance.sdk.component.widget.recycler.c.xv.r.c(recyclerView, recyclerView.f30488p);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f30489q = true;
            recyclerView2.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xv
        public void c(int i4, int i5, Object obj) {
            RecyclerView.this.c((String) null);
            if (RecyclerView.this.f30480f.c(i4, i5, obj)) {
                w();
            }
        }
    }

    String c() {
        return " " + super.toString() + ", adapter:" + this.bk + ", layout:" + this.f30492t + ", context:" + getContext();
    }

    private void c(c cVar, boolean z3, boolean z4) {
        c cVar2 = this.bk;
        if (cVar2 != null) {
            cVar2.w(this.vc);
            this.bk.w(this);
        }
        if (!z3 || z4) {
            xv();
        }
        this.f30480f.c();
        c cVar3 = this.bk;
        this.bk = cVar;
        if (cVar != null) {
            cVar.c(this.vc);
            cVar.c(this);
        }
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.c(cVar3, this.bk);
        }
        this.ux.c(cVar3, this.bk, z3);
        this.ba.f30550f = true;
    }

    public int ev(View view) {
        j ux2 = ux(view);
        if (ux2 != null) {
            return ux2.ev();
        }
        return -1;
    }

    void gd(int i4, int i5) {
        this.xu++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        ev(i4, i5);
        t tVar = this.zt;
        if (tVar != null) {
            tVar.c(this, i4, i5);
        }
        List<t> list = this.eb;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.eb.get(size).c(this, i4, i5);
            }
        }
        this.xu--;
    }

    public boolean p(int i4, int i5) {
        return getScrollingChildHelper().c(i4, i5);
    }

    void r(int i4, int i5) {
        int xv2 = this.f30490r.xv();
        for (int i6 = 0; i6 < xv2; i6++) {
            j ux2 = ux(this.f30490r.sr(i6));
            if (ux2 != null && !ux2.r() && ux2.f30533f >= i4) {
                ux2.c(i5, false);
                this.ba.f30550f = true;
            }
        }
        this.ux.w(i4, i5);
        requestLayout();
    }

    public void p(int i4) {
        getScrollingChildHelper().xv(i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean w(int i4, int i5) {
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f30483i) {
            return false;
        } else {
            int xv2 = gdVar.xv();
            boolean sr2 = this.f30492t.sr();
            i4 = (xv2 == 0 || Math.abs(i4) < this.mu) ? 0 : 0;
            i5 = (!sr2 || Math.abs(i5) < this.mu) ? 0 : 0;
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            float f4 = i4;
            float f5 = i5;
            if (!dispatchNestedPreFling(f4, f5)) {
                boolean z3 = xv2 != 0 || sr2;
                dispatchNestedFling(f4, f5, z3);
                a aVar = this.xg;
                if (aVar != null && aVar.c(i4, i5)) {
                    return true;
                }
                if (z3) {
                    if (sr2) {
                        xv2 = (xv2 == true ? 1 : 0) | 2;
                    }
                    p(xv2, 1);
                    int i6 = this.f30479e;
                    int max = Math.max(-i6, Math.min(i4, i6));
                    int i7 = this.f30479e;
                    this.f30486n.c(max, Math.max(-i7, Math.min(i5, i7)));
                    return true;
                }
            }
            return false;
        }
    }

    public void xv(int i4) {
        if (this.f30483i) {
            return;
        }
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            gdVar.c(this, this.ba, i4);
        }
    }

    void ux() {
        int i4 = this.au + 1;
        this.au = i4;
        if (i4 != 1 || this.f30483i) {
            return;
        }
        this.f30493u = false;
    }

    @Deprecated
    public int f(View view) {
        return r(view);
    }

    void ux(int i4, int i5) {
        setMeasuredDimension(gd.c(i4, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.c.xv.r.sr(this)), gd.c(i5, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.c.xv.r.ux(this)));
    }

    void xv(int i4, int i5) {
        boolean z3;
        EdgeEffect edgeEffect = this.ok;
        if (edgeEffect == null || edgeEffect.isFinished() || i4 <= 0) {
            z3 = false;
        } else {
            this.ok.onRelease();
            z3 = this.ok.isFinished();
        }
        EdgeEffect edgeEffect2 = this.oh;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i4 < 0) {
            this.oh.onRelease();
            z3 |= this.oh.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f30482h;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.f30482h.onRelease();
            z3 |= this.f30482h.isFinished();
        }
        EdgeEffect edgeEffect4 = this.fm;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.fm.onRelease();
            z3 |= this.fm.isFinished();
        }
        if (z3) {
            com.bytedance.sdk.component.widget.recycler.c.xv.r.xv(this);
        }
    }

    public void f(int i4) {
        int w3 = this.f30490r.w();
        for (int i5 = 0; i5 < w3; i5++) {
            this.f30490r.w(i5).offsetTopAndBottom(i4);
        }
    }

    public int r(View view) {
        j ux2 = ux(view);
        if (ux2 != null) {
            return ux2.gd();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j ux(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f30540c;
    }

    public void r(int i4) {
        int w3 = this.f30490r.w();
        for (int i5 = 0; i5 < w3; i5++) {
            this.f30490r.w(i5).offsetLeftAndRight(i4);
        }
    }

    public j ux(int i4) {
        j jVar = null;
        if (this.f30484j) {
            return null;
        }
        int xv2 = this.f30490r.xv();
        for (int i5 = 0; i5 < xv2; i5++) {
            j ux2 = ux(this.f30490r.sr(i5));
            if (ux2 != null && !ux2.i() && sr(ux2) == i4) {
                if (!this.f30490r.xv(ux2.sr)) {
                    return ux2;
                }
                jVar = ux2;
            }
        }
        return jVar;
    }

    void gd(int i4) {
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.k(i4);
        }
        ev(i4);
        t tVar = this.zt;
        if (tVar != null) {
            tVar.c(this, i4);
        }
        List<t> list = this.eb;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.eb.get(size).c(this, i4);
            }
        }
    }

    public void c(k kVar) {
        if (this.wo == null) {
            this.wo = new ArrayList();
        }
        this.wo.add(kVar);
    }

    public boolean k(int i4) {
        return getScrollingChildHelper().c(i4);
    }

    private boolean w(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        bk bkVar = this.oo;
        if (bkVar != null) {
            if (action != 0) {
                bkVar.w(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.oo = null;
                }
                return true;
            }
            this.oo = null;
        }
        if (action != 0) {
            int size = this.mt.size();
            for (int i4 = 0; i4 < size; i4++) {
                bk bkVar2 = this.mt.get(i4);
                if (bkVar2.c(this, motionEvent)) {
                    this.oo = bkVar2;
                    return true;
                }
            }
        }
        return false;
    }

    boolean c(View view) {
        ux();
        boolean f4 = this.f30490r.f(view);
        if (f4) {
            j ux2 = ux(view);
            this.ux.xv(ux2);
            this.ux.w(ux2);
        }
        c(!f4);
        return f4;
    }

    void sr(int i4, int i5) {
        if (i4 < 0) {
            r();
            this.ok.onAbsorb(-i4);
        } else if (i4 > 0) {
            ev();
            this.oh.onAbsorb(i4);
        }
        if (i5 < 0) {
            gd();
            this.f30482h.onAbsorb(-i5);
        } else if (i5 > 0) {
            p();
            this.fm.onAbsorb(i5);
        }
        if (i4 == 0 && i5 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.c.xv.r.xv(this);
    }

    private void xv(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ge) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.ge = motionEvent.getPointerId(i4);
            int x3 = (int) (motionEvent.getX(i4) + 0.5f);
            this.f30481g = x3;
            this.eu = x3;
            int y3 = (int) (motionEvent.getY(i4) + 0.5f);
            this.bs = y3;
            this.be = y3;
        }
    }

    public void c(ev evVar, int i4) {
        gd gdVar = this.f30492t;
        if (gdVar != null) {
            gdVar.c("Cannot add item decoration during a scroll  or layout");
        }
        if (this.fp.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i4 < 0) {
            this.fp.add(evVar);
        } else {
            this.fp.add(i4, evVar);
        }
        ia();
        requestLayout();
    }

    void xv(boolean z3) {
        this.ls = z3 | this.ls;
        this.f30484j = true;
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z3) {
        int i4 = this.ox - 1;
        this.ox = i4;
        if (i4 < 1) {
            this.ox = 0;
            if (z3) {
                eq();
                j();
            }
        }
    }

    public j sr(View view) {
        View xv2 = xv(view);
        if (xv2 == null) {
            return null;
        }
        return w(xv2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View xv(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.xv(android.view.View):android.view.View");
    }

    public j sr(int i4) {
        return c(i4, false);
    }

    static void xv(j jVar) {
        WeakReference<RecyclerView> weakReference = jVar.ux;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == jVar.sr) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            jVar.ux = null;
        }
    }

    int sr(j jVar) {
        if (jVar.c(524) || !jVar.u()) {
            return -1;
        }
        return this.f30480f.xv(jVar.f30533f);
    }

    void w(j jVar, f.xv xvVar, f.xv xvVar2) {
        ux(jVar);
        jVar.c(false);
        if (this.gb.c(jVar, xvVar, xvVar2)) {
            ys();
        }
    }

    public void c(ev evVar) {
        c(evVar, -1);
    }

    public void c(t tVar) {
        if (this.eb == null) {
            this.eb = new ArrayList();
        }
        this.eb.add(tVar);
    }

    boolean w(j jVar) {
        f fVar = this.gb;
        return fVar == null || fVar.c(jVar, jVar.gb());
    }

    public j w(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return ux(view);
    }

    public void c(int i4) {
        if (this.f30483i) {
            return;
        }
        f();
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        gdVar.sr(i4);
        awakenScrollBars();
    }

    void c(int i4, int i5, int[] iArr) {
        ux();
        a();
        com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV Scroll");
        c(this.ba);
        int c4 = i4 != 0 ? this.f30492t.c(i4, this.ux, this.ba) : 0;
        int w3 = i5 != 0 ? this.f30492t.w(i5, this.ux, this.ba) : 0;
        com.bytedance.sdk.component.widget.recycler.c.c.c.c();
        q();
        bk();
        c(false);
        if (iArr != null) {
            iArr[0] = c4;
            iArr[1] = w3;
        }
    }

    boolean c(int i4, int i5, MotionEvent motionEvent) {
        int i6;
        int i7;
        int i8;
        int i9;
        sr();
        if (this.bk != null) {
            c(i4, i5, this.xk);
            int[] iArr = this.xk;
            int i10 = iArr[0];
            int i11 = iArr[1];
            i7 = i11;
            i8 = i10;
            i9 = i4 - i10;
            i6 = i5 - i11;
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
        }
        if (!this.fp.isEmpty()) {
            invalidate();
        }
        int i12 = i6;
        if (c(i8, i7, i9, i6, this.iw, 0)) {
            int i13 = this.f30481g;
            int[] iArr2 = this.iw;
            this.f30481g = i13 - iArr2[0];
            this.bs -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.gp;
            int i14 = iArr3[0];
            int[] iArr4 = this.iw;
            iArr3[0] = i14 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.c.xv.r.c(motionEvent, 8194)) {
                c(motionEvent.getX(), i9, motionEvent.getY(), i12);
            }
            xv(i4, i5);
        }
        if (i8 != 0 || i7 != 0) {
            gd(i8, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i8 == 0 && i7 == 0) ? false : true;
    }

    void c(boolean z3) {
        if (this.au < 1) {
            this.au = 1;
        }
        if (!z3 && !this.f30483i) {
            this.f30493u = false;
        }
        if (this.au == 1) {
            if (z3 && this.f30493u && !this.f30483i && this.f30492t != null && this.bk != null) {
                fp();
            }
            if (!this.f30483i) {
                this.f30493u = false;
            }
        }
        this.au--;
    }

    public void c(int i4, int i5) {
        c(i4, i5, (Interpolator) null);
    }

    public void c(int i4, int i5, Interpolator interpolator) {
        gd gdVar = this.f30492t;
        if (gdVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f30483i) {
        } else {
            if (!gdVar.xv()) {
                i4 = 0;
            }
            if (!this.f30492t.sr()) {
                i5 = 0;
            }
            if (i4 == 0 && i5 == 0) {
                return;
            }
            this.f30486n.c(i4, i5, interpolator);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.r()
            android.widget.EdgeEffect r3 = r6.ok
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            com.bytedance.sdk.component.widget.recycler.c.xv.c.c(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.ev()
            android.widget.EdgeEffect r3 = r6.oh
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            com.bytedance.sdk.component.widget.recycler.c.xv.c.c(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.gd()
            android.widget.EdgeEffect r9 = r6.f30482h
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            com.bytedance.sdk.component.widget.recycler.c.xv.c.c(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.p()
            android.widget.EdgeEffect r9 = r6.fm
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            com.bytedance.sdk.component.widget.recycler.c.xv.c.c(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            com.bytedance.sdk.component.widget.recycler.c.xv.r.xv(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.c(float, float, float, float):void");
    }

    public static <T> T c(T t3) {
        t3.getClass();
        return t3;
    }

    private boolean c(View view, View view2, int i4) {
        int i5;
        if (view2 == null || view2 == this || xv(view2) == null) {
            return false;
        }
        if (view == null || xv(view) == null) {
            return true;
        }
        this.f30485k.set(0, 0, view.getWidth(), view.getHeight());
        this.up.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f30485k);
        offsetDescendantRectToMyCoords(view2, this.up);
        char c4 = '\uffff';
        int i6 = this.f30492t.fz() == 1 ? -1 : 1;
        Rect rect = this.f30485k;
        int i7 = rect.left;
        Rect rect2 = this.up;
        int i8 = rect2.left;
        if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
            i5 = 1;
        } else {
            int i9 = rect.right;
            int i10 = rect2.right;
            i5 = ((i9 > i10 || i7 >= i10) && i7 > i8) ? -1 : 0;
        }
        int i11 = rect.top;
        int i12 = rect2.top;
        if ((i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom) {
            c4 = 1;
        } else {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if ((i13 <= i14 && i11 < i14) || i11 <= i12) {
                c4 = 0;
            }
        }
        if (i4 == 1) {
            return c4 < 0 || (c4 == 0 && i5 * i6 <= 0);
        } else if (i4 == 2) {
            return c4 > 0 || (c4 == 0 && i5 * i6 >= 0);
        } else if (i4 == 17) {
            return i5 < 0;
        } else if (i4 == 33) {
            return c4 < 0;
        } else if (i4 == 66) {
            return i5 > 0;
        } else if (i4 == 130) {
            return c4 > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i4 + c());
        }
    }

    private void c(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f30485k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.xv) {
                Rect rect = pVar.f30541w;
                Rect rect2 = this.f30485k;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f30485k);
            offsetRectIntoDescendantCoords(view, this.f30485k);
        }
        this.f30492t.c(this, view, this.f30485k, !this.fz, view2 == null);
    }

    void c(String str) {
        if (t()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + c());
            }
            throw new IllegalStateException(str);
        } else if (this.xu > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + c()));
        }
    }

    private boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.oo = null;
        }
        int size = this.mt.size();
        for (int i4 = 0; i4 < size; i4++) {
            bk bkVar = this.mt.get(i4);
            if (bkVar.c(this, motionEvent) && action != 3) {
                this.oo = bkVar;
                return true;
            }
        }
        return false;
    }

    final void c(u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f30486n.f30542c;
            uVar.ys = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.fp = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        uVar.ys = 0;
        uVar.fp = 0;
    }

    private void c(long j4, j jVar, j jVar2) {
        int w3 = this.f30490r.w();
        for (int i4 = 0; i4 < w3; i4++) {
            j ux2 = ux(this.f30490r.w(i4));
            if (ux2 != jVar && c(ux2) == j4) {
                c cVar = this.bk;
                if (cVar != null && cVar.w()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + ux2 + " \n View Holder 2:" + jVar + c());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + ux2 + " \n View Holder 2:" + jVar + c());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + jVar2 + " cannot be found but it is necessary for " + jVar + c());
    }

    void c(j jVar, f.xv xvVar) {
        jVar.c(0, 8192);
        if (this.ba.ev && jVar.y() && !jVar.i() && !jVar.r()) {
            this.ev.c(c(jVar), jVar);
        }
        this.ev.c(jVar, xvVar);
    }

    private void c(int[] iArr) {
        int w3 = this.f30490r.w();
        if (w3 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < w3; i6++) {
            j ux2 = ux(this.f30490r.w(i6));
            if (!ux2.r()) {
                int ev2 = ux2.ev();
                if (ev2 < i4) {
                    i4 = ev2;
                }
                if (ev2 > i5) {
                    i5 = ev2;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
    }

    long c(j jVar) {
        return this.bk.w() ? jVar.k() : jVar.f30533f;
    }

    void c(j jVar, f.xv xvVar, f.xv xvVar2) {
        jVar.c(false);
        if (this.gb.w(jVar, xvVar, xvVar2)) {
            ys();
        }
    }

    private void c(j jVar, j jVar2, f.xv xvVar, f.xv xvVar2, boolean z3, boolean z4) {
        jVar.c(false);
        if (z3) {
            ux(jVar);
        }
        if (jVar != jVar2) {
            if (z4) {
                ux(jVar2);
            }
            jVar.f30534k = jVar2;
            ux(jVar);
            this.ux.xv(jVar);
            jVar2.c(false);
            jVar2.f30532a = jVar;
        }
        if (this.gb.c(jVar, jVar2, xvVar, xvVar2)) {
            ys();
        }
    }

    void c(int i4, int i5, boolean z3) {
        int i6 = i4 + i5;
        int xv2 = this.f30490r.xv();
        for (int i7 = 0; i7 < xv2; i7++) {
            j ux2 = ux(this.f30490r.sr(i7));
            if (ux2 != null && !ux2.r()) {
                int i8 = ux2.f30533f;
                if (i8 >= i6) {
                    ux2.c(-i5, z3);
                    this.ba.f30550f = true;
                } else if (i8 >= i4) {
                    ux2.c(i4 - 1, -i5, z3);
                    this.ba.f30550f = true;
                }
            }
        }
        this.ux.c(i4, i5, z3);
        requestLayout();
    }

    void c(int i4, int i5, Object obj) {
        int i6;
        int xv2 = this.f30490r.xv();
        int i7 = i4 + i5;
        for (int i8 = 0; i8 < xv2; i8++) {
            View sr2 = this.f30490r.sr(i8);
            j ux2 = ux(sr2);
            if (ux2 != null && !ux2.r() && (i6 = ux2.f30533f) >= i4 && i6 < i7) {
                ux2.w(2);
                ux2.c(obj);
                ((p) sr2.getLayoutParams()).xv = true;
            }
        }
        this.ux.xv(i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.bytedance.sdk.component.widget.recycler.RecyclerView.j c(int r6, boolean r7) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.w r0 = r5.f30490r
            int r0 = r0.xv()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L39
            com.bytedance.sdk.component.widget.recycler.w r3 = r5.f30490r
            android.view.View r3 = r3.sr(r2)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$j r3 = ux(r3)
            if (r3 == 0) goto L36
            boolean r4 = r3.i()
            if (r4 != 0) goto L36
            if (r7 == 0) goto L23
            int r4 = r3.f30533f
            if (r4 == r6) goto L2a
            goto L36
        L23:
            int r4 = r3.ev()
            if (r4 == r6) goto L2a
            goto L36
        L2a:
            com.bytedance.sdk.component.widget.recycler.w r1 = r5.f30490r
            android.view.View r4 = r3.sr
            boolean r1 = r1.xv(r4)
            if (r1 != 0) goto L35
            return r3
        L35:
            r1 = r3
        L36:
            int r2 = r2 + 1
            goto L8
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.c(int, boolean):com.bytedance.sdk.component.widget.recycler.RecyclerView$j");
    }

    public j c(long j4) {
        c cVar = this.bk;
        j jVar = null;
        if (cVar != null && cVar.w()) {
            int xv2 = this.f30490r.xv();
            for (int i4 = 0; i4 < xv2; i4++) {
                j ux2 = ux(this.f30490r.sr(i4));
                if (ux2 != null && !ux2.i() && ux2.k() == j4) {
                    if (!this.f30490r.xv(ux2.sr)) {
                        return ux2;
                    }
                    jVar = ux2;
                }
            }
        }
        return jVar;
    }

    static void c(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f30541w;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    boolean c(j jVar, int i4) {
        if (t()) {
            jVar.f30537s = i4;
            this.yu.add(jVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.c.xv.r.c(jVar.sr, i4);
        return true;
    }

    public boolean c(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        return getScrollingChildHelper().c(i4, i5, i6, i7, iArr, i8);
    }

    public boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2, i6);
    }
}
