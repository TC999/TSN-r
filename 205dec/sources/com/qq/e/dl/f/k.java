package com.qq.e.dl.f;

import android.animation.Animator;
import android.animation.TimeAnimator;
import com.qq.e.dl.f.i;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class k extends TimeAnimator implements i, TimeAnimator.TimeListener, Animator.AnimatorListener {

    /* renamed from: c  reason: collision with root package name */
    private final String f46856c;

    /* renamed from: d  reason: collision with root package name */
    private final int f46857d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedList<h> f46858e;

    /* renamed from: f  reason: collision with root package name */
    private LinkedList<h> f46859f;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.dl.f.b f46860g;

    /* renamed from: h  reason: collision with root package name */
    private float f46861h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f46862a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedList<h> f46863b = new LinkedList<>();

        /* renamed from: c  reason: collision with root package name */
        private int f46864c = 0;

        public b(String str) {
            this.f46862a = str;
        }

        @Override // com.qq.e.dl.f.i.a
        public void a(h hVar) {
            int i4 = hVar.f46842a.f46918k;
            int i5 = this.f46864c;
            if (i5 >= 0) {
                if (i4 < 0) {
                    this.f46864c = -1;
                } else if (i4 > i5) {
                    this.f46864c = i4;
                }
            }
            this.f46863b.add(hVar);
        }

        @Override // com.qq.e.dl.f.i.a
        public i build() {
            return new k(this.f46862a, this.f46864c, this.f46863b);
        }
    }

    @Override // com.qq.e.dl.f.i
    public void a(com.qq.e.dl.f.b bVar) {
        this.f46859f = (LinkedList) this.f46858e.clone();
        if (bVar == null) {
            if (this.f46860g != null) {
                this.f46860g = null;
                removeListener(this);
            }
        } else {
            if (this.f46860g == null) {
                addListener(this);
            }
            this.f46860g = bVar;
        }
        super.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        com.qq.e.dl.f.b bVar = this.f46860g;
        if (bVar != null) {
            bVar.a(this.f46856c);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public void onTimeUpdate(TimeAnimator timeAnimator, long j4, long j5) {
        a(j4, true, false);
    }

    @Override // android.animation.TimeAnimator, android.animation.ValueAnimator, android.animation.Animator, com.qq.e.dl.f.i
    public void start() {
        a((com.qq.e.dl.f.b) null);
    }

    private k(String str, int i4, LinkedList<h> linkedList) {
        this.f46861h = -1.0f;
        this.f46856c = str;
        this.f46857d = i4;
        this.f46858e = linkedList;
        setTimeListener(this);
    }

    @Override // com.qq.e.dl.f.i
    public void a(float f4) {
        int i4;
        if (this.f46857d < 0 || f4 == this.f46861h) {
            return;
        }
        if (isStarted()) {
            cancel();
            this.f46859f = null;
        }
        if (f4 > 1.0f) {
            i4 = this.f46857d;
        } else {
            i4 = f4 < 0.0f ? 0 : (int) (this.f46857d * f4);
        }
        if (this.f46859f == null) {
            this.f46859f = (LinkedList) this.f46858e.clone();
        }
        a(i4, false, f4 < this.f46861h);
        this.f46861h = f4;
    }

    private void a(long j4, boolean z3, boolean z4) {
        long j5;
        LinkedList<h> linkedList = this.f46859f;
        if (linkedList == null) {
            return;
        }
        Iterator<h> descendingIterator = z4 ? linkedList.descendingIterator() : linkedList.iterator();
        while (descendingIterator.hasNext()) {
            h next = descendingIterator.next();
            com.qq.e.dl.i.a aVar = next.f46842a;
            if (aVar.f46911d >= j4) {
                next.a(0.0f);
                next.f46845d = false;
            } else if (aVar.f46912e <= 0) {
                next.a(z4 ? 0.0f : 1.0f);
                if (z3) {
                    descendingIterator.remove();
                }
            } else {
                int i4 = aVar.f46918k;
                if (i4 >= 0 && j4 >= i4) {
                    next.a(aVar.f46914g + 1.0f);
                    next.f46845d = false;
                    if (z3) {
                        descendingIterator.remove();
                    }
                } else {
                    long j6 = j4 - aVar.f46919l;
                    int i5 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
                    if (i5 > 0) {
                        j5 = (j6 % aVar.f46920m) - aVar.f46913f;
                        if (j5 <= 0 && !next.f46845d) {
                        }
                    } else {
                        j5 = 0;
                    }
                    if (i5 <= 0) {
                        r6 = (((float) (j4 - aVar.f46911d)) * 1.0f) / aVar.f46912e;
                        next.f46845d = i5 != 0;
                    } else if (j5 > 0) {
                        int i6 = aVar.f46912e;
                        r6 = ((((float) j5) * 1.0f) / i6) + ((int) (j6 / aVar.f46920m)) + 1;
                        next.f46845d = j5 != ((long) i6);
                    } else {
                        if (!z4 || !aVar.b()) {
                            r6 = ((int) (j6 / aVar.f46920m)) + 1;
                        }
                        next.f46845d = false;
                    }
                    next.a(r6);
                }
            }
        }
        if (z3 && this.f46859f.size() == 0) {
            end();
            this.f46859f = null;
        }
    }
}
