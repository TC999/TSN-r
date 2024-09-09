package com.qq.e.dl.f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.qq.e.dl.f.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j implements i {

    /* renamed from: c  reason: collision with root package name */
    private final Animator f46847c;

    /* renamed from: d  reason: collision with root package name */
    private final h f46848d;

    /* renamed from: e  reason: collision with root package name */
    private c f46849e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f46850f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46851g;

    @Override // com.qq.e.dl.f.i
    public void a(float f4) {
    }

    @Override // com.qq.e.dl.f.i
    public void a(com.qq.e.dl.f.b bVar) {
        if (this.f46847c == null) {
            return;
        }
        this.f46850f = true;
        h hVar = this.f46848d;
        if (hVar != null) {
            if (bVar != null) {
                if (this.f46849e == null) {
                    c cVar = new c(hVar);
                    this.f46849e = cVar;
                    this.f46848d.f46843b.addListener(cVar);
                }
                this.f46849e.a(bVar);
            } else {
                c cVar2 = this.f46849e;
                if (cVar2 != null) {
                    hVar.f46843b.removeListener(cVar2);
                }
            }
        }
        this.f46847c.start();
    }

    @Override // com.qq.e.dl.f.i
    public void cancel() {
        ArrayList<Animator> childAnimations;
        Animator animator = this.f46847c;
        if (animator == null || !this.f46850f) {
            return;
        }
        this.f46850f = false;
        if (animator.isStarted()) {
            this.f46847c.cancel();
        }
        Animator animator2 = this.f46847c;
        if ((animator2 instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator2).getChildAnimations()) != null && childAnimations.size() > 0) {
            Iterator<Animator> it = childAnimations.iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next.isStarted()) {
                    next.cancel();
                } else {
                    ArrayList<Animator.AnimatorListener> listeners = next.getListeners();
                    if (listeners != null && listeners.size() > 0) {
                        Iterator<Animator.AnimatorListener> it2 = listeners.iterator();
                        while (it2.hasNext()) {
                            it2.next().onAnimationCancel(next);
                        }
                    }
                }
            }
        }
    }

    @Override // com.qq.e.dl.f.i
    public void pause() {
        if (!this.f46850f || this.f46851g) {
            return;
        }
        this.f46851g = true;
        cancel();
    }

    @Override // com.qq.e.dl.f.i
    public void resume() {
        if (this.f46851g) {
            this.f46851g = false;
            start();
        }
    }

    @Override // com.qq.e.dl.f.i
    public void start() {
        a((com.qq.e.dl.f.b) null);
    }

    private j(String str, List<Animator> list, h hVar) {
        int size;
        this.f46848d = hVar;
        if (list != null && (size = list.size()) > 0) {
            Animator animator = list.get(0);
            if (size == 1) {
                this.f46847c = animator;
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(list);
            this.f46847c = animatorSet;
            return;
        }
        this.f46847c = null;
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f46852a;

        /* renamed from: c  reason: collision with root package name */
        private h f46854c;

        /* renamed from: b  reason: collision with root package name */
        private final List<Animator> f46853b = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private boolean f46855d = true;

        public b(String str) {
            this.f46852a = str;
        }

        @Override // com.qq.e.dl.f.i.a
        public void a(h hVar) {
            if (hVar != null) {
                String str = this.f46852a;
                com.qq.e.dl.i.a aVar = hVar.f46842a;
                if (a(str, aVar.f46909b)) {
                    if (this.f46855d) {
                        int i4 = aVar.f46918k;
                        if (i4 < 0) {
                            this.f46855d = false;
                            this.f46854c = null;
                        } else {
                            h hVar2 = this.f46854c;
                            if (hVar2 == null || i4 > hVar2.f46842a.f46918k) {
                                this.f46854c = hVar;
                            }
                        }
                    }
                    this.f46853b.add(hVar.f46843b);
                }
            }
        }

        @Override // com.qq.e.dl.f.i.a
        public i build() {
            return new j(this.f46852a, this.f46853b, this.f46854c);
        }

        private boolean a(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }
}
