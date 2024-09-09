package com.bytedance.sdk.component.widget.recycler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends k {
    private static TimeInterpolator gd;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<RecyclerView.j> f30638p = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<RecyclerView.j> f30637k = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<w> f30634a = new ArrayList<>();
    private ArrayList<c> bk = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.j>> f30635c = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    ArrayList<ArrayList<w>> f30640w = new ArrayList<>();
    ArrayList<ArrayList<c>> xv = new ArrayList<>();
    ArrayList<RecyclerView.j> sr = new ArrayList<>();
    ArrayList<RecyclerView.j> ux = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<RecyclerView.j> f30636f = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    ArrayList<RecyclerView.j> f30639r = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.j f30661c;
        public int sr;
        public int ux;

        /* renamed from: w  reason: collision with root package name */
        public int f30662w;
        public int xv;

        w(RecyclerView.j jVar, int i4, int i5, int i6, int i7) {
            this.f30661c = jVar;
            this.f30662w = i4;
            this.xv = i5;
            this.sr = i6;
            this.ux = i7;
        }
    }

    private void i(final RecyclerView.j jVar) {
        final View view = jVar.sr;
        final ViewPropertyAnimator animate = view.animate();
        this.f30636f.add(jVar);
        animate.setDuration(r()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.xv.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                xv.this.gd(jVar);
                xv.this.f30636f.remove(jVar);
                xv.this.xv();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                xv.this.a(jVar);
            }
        }).start();
    }

    private void q(RecyclerView.j jVar) {
        if (gd == null) {
            gd = new ValueAnimator().getInterpolator();
        }
        jVar.sr.animate().setInterpolator(gd);
        sr(jVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public void c() {
        boolean z3 = !this.f30638p.isEmpty();
        boolean z4 = !this.f30634a.isEmpty();
        boolean z5 = !this.bk.isEmpty();
        boolean z6 = !this.f30637k.isEmpty();
        if (z3 || z4 || z6 || z5) {
            Iterator<RecyclerView.j> it = this.f30638p.iterator();
            while (it.hasNext()) {
                i(it.next());
            }
            this.f30638p.clear();
            if (z4) {
                final ArrayList<w> arrayList = new ArrayList<>();
                arrayList.addAll(this.f30634a);
                this.f30640w.add(arrayList);
                this.f30634a.clear();
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.xv.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            w wVar = (w) it2.next();
                            xv.this.w(wVar.f30661c, wVar.f30662w, wVar.xv, wVar.sr, wVar.ux);
                        }
                        arrayList.clear();
                        xv.this.f30640w.remove(arrayList);
                    }
                };
                if (z3) {
                    com.bytedance.sdk.component.widget.recycler.c.xv.r.c(arrayList.get(0).f30661c.sr, runnable, r());
                } else {
                    runnable.run();
                }
            }
            if (z5) {
                final ArrayList<c> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.bk);
                this.xv.add(arrayList2);
                this.bk.clear();
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.xv.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            xv.this.c((c) it2.next());
                        }
                        arrayList2.clear();
                        xv.this.xv.remove(arrayList2);
                    }
                };
                if (z3) {
                    com.bytedance.sdk.component.widget.recycler.c.xv.r.c(arrayList2.get(0).f30658c.sr, runnable2, r());
                } else {
                    runnable2.run();
                }
            }
            if (z6) {
                final ArrayList<RecyclerView.j> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f30637k);
                this.f30635c.add(arrayList3);
                this.f30637k.clear();
                Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.xv.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            xv.this.xv((RecyclerView.j) it2.next());
                        }
                        arrayList3.clear();
                        xv.this.f30635c.remove(arrayList3);
                    }
                };
                if (!z3 && !z4 && !z5) {
                    runnable3.run();
                } else {
                    com.bytedance.sdk.component.widget.recycler.c.xv.r.c(arrayList3.get(0).sr, runnable3, (z3 ? r() : 0L) + Math.max(z4 ? ux() : 0L, z5 ? ev() : 0L));
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public void sr(RecyclerView.j jVar) {
        View view = jVar.sr;
        view.animate().cancel();
        int size = this.f30634a.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f30634a.get(size).f30661c == jVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                p(jVar);
                this.f30634a.remove(size);
            }
        }
        c(this.bk, jVar);
        if (this.f30638p.remove(jVar)) {
            view.setAlpha(1.0f);
            gd(jVar);
        }
        if (this.f30637k.remove(jVar)) {
            view.setAlpha(1.0f);
            k(jVar);
        }
        for (int size2 = this.xv.size() - 1; size2 >= 0; size2--) {
            ArrayList<c> arrayList = this.xv.get(size2);
            c(arrayList, jVar);
            if (arrayList.isEmpty()) {
                this.xv.remove(size2);
            }
        }
        for (int size3 = this.f30640w.size() - 1; size3 >= 0; size3--) {
            ArrayList<w> arrayList2 = this.f30640w.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f30661c == jVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    p(jVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f30640w.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f30635c.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.j> arrayList3 = this.f30635c.get(size5);
            if (arrayList3.remove(jVar)) {
                view.setAlpha(1.0f);
                k(jVar);
                if (arrayList3.isEmpty()) {
                    this.f30635c.remove(size5);
                }
            }
        }
        this.f30636f.remove(jVar);
        this.sr.remove(jVar);
        this.f30639r.remove(jVar);
        this.ux.remove(jVar);
        xv();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.k
    public boolean w(RecyclerView.j jVar) {
        q(jVar);
        jVar.sr.setAlpha(0.0f);
        this.f30637k.add(jVar);
        return true;
    }

    void xv(final RecyclerView.j jVar) {
        final View view = jVar.sr;
        final ViewPropertyAnimator animate = view.animate();
        this.sr.add(jVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.xv.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                xv.this.k(jVar);
                xv.this.sr.remove(jVar);
                xv.this.xv();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                xv.this.t(jVar);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.j f30658c;

        /* renamed from: f  reason: collision with root package name */
        public int f30659f;
        public int sr;
        public int ux;

        /* renamed from: w  reason: collision with root package name */
        public RecyclerView.j f30660w;
        public int xv;

        private c(RecyclerView.j jVar, RecyclerView.j jVar2) {
            this.f30658c = jVar;
            this.f30660w = jVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f30658c + ", newHolder=" + this.f30660w + ", fromX=" + this.xv + ", fromY=" + this.sr + ", toX=" + this.ux + ", toY=" + this.f30659f + '}';
        }

        c(RecyclerView.j jVar, RecyclerView.j jVar2, int i4, int i5, int i6, int i7) {
            this(jVar, jVar2);
            this.xv = i4;
            this.sr = i5;
            this.ux = i6;
            this.f30659f = i7;
        }
    }

    void w(final RecyclerView.j jVar, int i4, int i5, int i6, int i7) {
        final View view = jVar.sr;
        final int i8 = i6 - i4;
        final int i9 = i7 - i5;
        if (i8 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i9 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.ux.add(jVar);
        animate.setDuration(ux()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.xv.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i8 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i9 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                xv.this.p(jVar);
                xv.this.ux.remove(jVar);
                xv.this.xv();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                xv.this.bk(jVar);
            }
        }).start();
    }

    void xv() {
        if (w()) {
            return;
        }
        gd();
    }

    private void w(c cVar) {
        RecyclerView.j jVar = cVar.f30658c;
        if (jVar != null) {
            c(cVar, jVar);
        }
        RecyclerView.j jVar2 = cVar.f30660w;
        if (jVar2 != null) {
            c(cVar, jVar2);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean w() {
        return (this.f30637k.isEmpty() && this.bk.isEmpty() && this.f30634a.isEmpty() && this.f30638p.isEmpty() && this.ux.isEmpty() && this.f30636f.isEmpty() && this.sr.isEmpty() && this.f30639r.isEmpty() && this.f30640w.isEmpty() && this.f30635c.isEmpty() && this.xv.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.k
    public boolean c(RecyclerView.j jVar) {
        q(jVar);
        this.f30638p.add(jVar);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.k
    public boolean c(RecyclerView.j jVar, int i4, int i5, int i6, int i7) {
        View view = jVar.sr;
        int translationX = i4 + ((int) view.getTranslationX());
        int translationY = i5 + ((int) jVar.sr.getTranslationY());
        q(jVar);
        int i8 = i6 - translationX;
        int i9 = i7 - translationY;
        if (i8 == 0 && i9 == 0) {
            p(jVar);
            return false;
        }
        if (i8 != 0) {
            view.setTranslationX(-i8);
        }
        if (i9 != 0) {
            view.setTranslationY(-i9);
        }
        this.f30634a.add(new w(jVar, translationX, translationY, i6, i7));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public void sr() {
        int size = this.f30634a.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            w wVar = this.f30634a.get(size);
            View view = wVar.f30661c.sr;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            p(wVar.f30661c);
            this.f30634a.remove(size);
        }
        for (int size2 = this.f30638p.size() - 1; size2 >= 0; size2--) {
            gd(this.f30638p.get(size2));
            this.f30638p.remove(size2);
        }
        int size3 = this.f30637k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.j jVar = this.f30637k.get(size3);
            jVar.sr.setAlpha(1.0f);
            k(jVar);
            this.f30637k.remove(size3);
        }
        for (int size4 = this.bk.size() - 1; size4 >= 0; size4--) {
            w(this.bk.get(size4));
        }
        this.bk.clear();
        if (w()) {
            for (int size5 = this.f30640w.size() - 1; size5 >= 0; size5--) {
                ArrayList<w> arrayList = this.f30640w.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    w wVar2 = arrayList.get(size6);
                    View view2 = wVar2.f30661c.sr;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    p(wVar2.f30661c);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f30640w.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f30635c.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.j> arrayList2 = this.f30635c.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.j jVar2 = arrayList2.get(size8);
                    jVar2.sr.setAlpha(1.0f);
                    k(jVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f30635c.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.xv.size() - 1; size9 >= 0; size9--) {
                ArrayList<c> arrayList3 = this.xv.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    w(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.xv.remove(arrayList3);
                    }
                }
            }
            c(this.f30636f);
            c(this.ux);
            c(this.sr);
            c(this.f30639r);
            gd();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.k
    public boolean c(RecyclerView.j jVar, RecyclerView.j jVar2, int i4, int i5, int i6, int i7) {
        if (jVar == jVar2) {
            return c(jVar, i4, i5, i6, i7);
        }
        float translationX = jVar.sr.getTranslationX();
        float translationY = jVar.sr.getTranslationY();
        float alpha = jVar.sr.getAlpha();
        q(jVar);
        int i8 = (int) ((i6 - i4) - translationX);
        int i9 = (int) ((i7 - i5) - translationY);
        jVar.sr.setTranslationX(translationX);
        jVar.sr.setTranslationY(translationY);
        jVar.sr.setAlpha(alpha);
        if (jVar2 != null) {
            q(jVar2);
            jVar2.sr.setTranslationX(-i8);
            jVar2.sr.setTranslationY(-i9);
            jVar2.sr.setAlpha(0.0f);
        }
        this.bk.add(new c(jVar, jVar2, i4, i5, i6, i7));
        return true;
    }

    void c(final c cVar) {
        RecyclerView.j jVar = cVar.f30658c;
        final View view = jVar == null ? null : jVar.sr;
        RecyclerView.j jVar2 = cVar.f30660w;
        final View view2 = jVar2 != null ? jVar2.sr : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(ev());
            this.f30639r.add(cVar.f30658c);
            duration.translationX(cVar.ux - cVar.xv);
            duration.translationY(cVar.f30659f - cVar.sr);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.xv.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    xv.this.c(cVar.f30658c, true);
                    xv.this.f30639r.remove(cVar.f30658c);
                    xv.this.xv();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    xv.this.w(cVar.f30658c, true);
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.f30639r.add(cVar.f30660w);
            animate.translationX(0.0f).translationY(0.0f).setDuration(ev()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.xv.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    xv.this.c(cVar.f30660w, false);
                    xv.this.f30639r.remove(cVar.f30660w);
                    xv.this.xv();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    xv.this.w(cVar.f30660w, false);
                }
            }).start();
        }
    }

    private void c(List<c> list, RecyclerView.j jVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (c(cVar, jVar) && cVar.f30658c == null && cVar.f30660w == null) {
                list.remove(cVar);
            }
        }
    }

    private boolean c(c cVar, RecyclerView.j jVar) {
        boolean z3 = false;
        if (cVar.f30660w == jVar) {
            cVar.f30660w = null;
        } else if (cVar.f30658c != jVar) {
            return false;
        } else {
            cVar.f30658c = null;
            z3 = true;
        }
        jVar.sr.setAlpha(1.0f);
        jVar.sr.setTranslationX(0.0f);
        jVar.sr.setTranslationY(0.0f);
        c(jVar, z3);
        return true;
    }

    void c(List<RecyclerView.j> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).sr.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean c(RecyclerView.j jVar, List<Object> list) {
        return !list.isEmpty() || super.c(jVar, list);
    }
}
