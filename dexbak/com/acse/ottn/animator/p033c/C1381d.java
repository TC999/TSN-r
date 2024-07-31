package com.acse.ottn.animator.p033c;

import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import com.acse.ottn.animator.p031a.C1331L;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.c.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1381d extends AbstractC1379b {

    /* renamed from: b */
    private static final int f2436b = 0;

    /* renamed from: c */
    private static final int f2437c = 1;

    /* renamed from: d */
    private static final int f2438d = 2;

    /* renamed from: e */
    private static final int f2439e = 4;

    /* renamed from: f */
    private static final int f2440f = 8;

    /* renamed from: g */
    private static final int f2441g = 16;

    /* renamed from: h */
    private static final int f2442h = 32;

    /* renamed from: i */
    private static final int f2443i = 64;

    /* renamed from: j */
    private static final int f2444j = 128;

    /* renamed from: k */
    private static final int f2445k = 256;

    /* renamed from: l */
    private static final int f2446l = 512;

    /* renamed from: m */
    private static final int f2447m = 511;

    /* renamed from: n */
    private final WeakReference<View> f2448n;

    /* renamed from: o */
    private long f2449o;

    /* renamed from: s */
    private Interpolator f2453s;

    /* renamed from: p */
    private boolean f2450p = false;

    /* renamed from: q */
    private long f2451q = 0;

    /* renamed from: r */
    private boolean f2452r = false;

    /* renamed from: t */
    private boolean f2454t = false;

    /* renamed from: u */
    private AbstractC1334a.InterfaceC1335a f2455u = null;

    /* renamed from: v */
    private C1382a f2456v = new C1382a(this, null);

    /* renamed from: w */
    ArrayList<C1383b> f2457w = new ArrayList<>();

    /* renamed from: x */
    private Runnable f2458x = new RunnableC1380c(this);

    /* renamed from: y */
    private HashMap<AbstractC1334a, C1384c> f2459y = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.c.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1382a implements AbstractC1334a.InterfaceC1335a, C1331L.InterfaceC1333b {
        private C1382a() {
        }

        /* synthetic */ C1382a(C1381d c1381d, RunnableC1380c runnableC1380c) {
            this();
        }

        @Override // com.acse.ottn.animator.p031a.C1331L.InterfaceC1333b
        /* renamed from: a */
        public void mo56857a(C1331L c1331l) {
            View view;
            float m57127r = c1331l.m57127r();
            C1384c c1384c = (C1384c) C1381d.this.f2459y.get(c1331l);
            if ((c1384c.f2464a & 511) != 0 && (view = (View) C1381d.this.f2448n.get()) != null) {
                view.invalidate();
            }
            ArrayList<C1383b> arrayList = c1384c.f2465b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C1383b c1383b = arrayList.get(i);
                    C1381d.this.m56902c(c1383b.f2461a, c1383b.f2462b + (c1383b.f2463c * m57127r));
                }
            }
            View view2 = (View) C1381d.this.f2448n.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: a */
        public void mo56852a(AbstractC1334a abstractC1334a) {
            if (C1381d.this.f2455u != null) {
                C1381d.this.f2455u.mo56852a(abstractC1334a);
            }
            C1381d.this.f2459y.remove(abstractC1334a);
            if (C1381d.this.f2459y.isEmpty()) {
                C1381d.this.f2455u = null;
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: b */
        public void mo56856b(AbstractC1334a abstractC1334a) {
            if (C1381d.this.f2455u != null) {
                C1381d.this.f2455u.mo56856b(abstractC1334a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: c */
        public void mo56855c(AbstractC1334a abstractC1334a) {
            if (C1381d.this.f2455u != null) {
                C1381d.this.f2455u.mo56855c(abstractC1334a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: d */
        public void mo56854d(AbstractC1334a abstractC1334a) {
            if (C1381d.this.f2455u != null) {
                C1381d.this.f2455u.mo56854d(abstractC1334a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.c.d$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1383b {

        /* renamed from: a */
        int f2461a;

        /* renamed from: b */
        float f2462b;

        /* renamed from: c */
        float f2463c;

        C1383b(int i, float f, float f2) {
            this.f2461a = i;
            this.f2462b = f;
            this.f2463c = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.c.d$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1384c {

        /* renamed from: a */
        int f2464a;

        /* renamed from: b */
        ArrayList<C1383b> f2465b;

        C1384c(int i, ArrayList<C1383b> arrayList) {
            this.f2464a = i;
            this.f2465b = arrayList;
        }

        /* renamed from: a */
        boolean m56898a(int i) {
            ArrayList<C1383b> arrayList;
            if ((this.f2464a & i) != 0 && (arrayList = this.f2465b) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f2465b.get(i2).f2461a == i) {
                        this.f2465b.remove(i2);
                        this.f2464a = (i ^ (-1)) & this.f2464a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1381d(View view) {
        this.f2448n = new WeakReference<>(view);
    }

    /* renamed from: a */
    private float m56910a(int i) {
        View view = this.f2448n.get();
        if (view != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            if (i != 256) {
                                                if (i != 512) {
                                                    return 0.0f;
                                                }
                                                return view.getAlpha();
                                            }
                                            return view.getY();
                                        }
                                        return view.getX();
                                    }
                                    return view.getRotationY();
                                }
                                return view.getRotationX();
                            }
                            return view.getRotation();
                        }
                        return view.getScaleY();
                    }
                    return view.getScaleX();
                }
                return view.getTranslationY();
            }
            return view.getTranslationX();
        }
        return 0.0f;
    }

    /* renamed from: a */
    private void m56909a(int i, float f) {
        float m56910a = m56910a(i);
        m56908a(i, m56910a, f - m56910a);
    }

    /* renamed from: a */
    private void m56908a(int i, float f, float f2) {
        if (this.f2459y.size() > 0) {
            AbstractC1334a abstractC1334a = null;
            Iterator<AbstractC1334a> it = this.f2459y.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC1334a next = it.next();
                C1384c c1384c = this.f2459y.get(next);
                if (c1384c.m56898a(i) && c1384c.f2464a == 0) {
                    abstractC1334a = next;
                    break;
                }
            }
            if (abstractC1334a != null) {
                abstractC1334a.cancel();
            }
        }
        this.f2457w.add(new C1383b(i, f, f2));
        View view = this.f2448n.get();
        if (view != null) {
            view.removeCallbacks(this.f2458x);
            view.post(this.f2458x);
        }
    }

    /* renamed from: b */
    private void m56904b(int i, float f) {
        m56908a(i, m56910a(i), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m56902c(int i, float f) {
        View view = this.f2448n.get();
        if (view != null) {
            if (i == 1) {
                view.setTranslationX(f);
            } else if (i == 2) {
                view.setTranslationY(f);
            } else if (i == 4) {
                view.setScaleX(f);
            } else if (i == 8) {
                view.setScaleY(f);
            } else if (i == 16) {
                view.setRotation(f);
            } else if (i == 32) {
                view.setRotationX(f);
            } else if (i == 64) {
                view.setRotationY(f);
            } else if (i == 128) {
                view.setX(f);
            } else if (i == 256) {
                view.setY(f);
            } else if (i != 512) {
            } else {
                view.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m56899e() {
        C1331L m57146a = C1331L.m57146a(1.0f);
        ArrayList arrayList = (ArrayList) this.f2457w.clone();
        this.f2457w.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((C1383b) arrayList.get(i2)).f2461a;
        }
        this.f2459y.put(m57146a, new C1384c(i, arrayList));
        m57146a.m57152a((C1331L.InterfaceC1333b) this.f2456v);
        m57146a.m57118a((AbstractC1334a.InterfaceC1335a) this.f2456v);
        if (this.f2452r) {
            m57146a.mo57100b(this.f2451q);
        }
        if (this.f2450p) {
            m57146a.mo57054a(this.f2449o);
        }
        if (this.f2454t) {
            m57146a.mo57108a(this.f2453s);
        }
        m57146a.mo57038j();
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56896a(float f) {
        m56909a(512, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56892a(long j) {
        if (j >= 0) {
            this.f2450p = true;
            this.f2449o = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56891a(Interpolator interpolator) {
        this.f2454t = true;
        this.f2453s = interpolator;
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56890a(AbstractC1334a.InterfaceC1335a interfaceC1335a) {
        this.f2455u = interfaceC1335a;
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public void mo56897a() {
        if (this.f2459y.size() > 0) {
            for (AbstractC1334a abstractC1334a : ((HashMap) this.f2459y.clone()).keySet()) {
                abstractC1334a.cancel();
            }
        }
        this.f2457w.clear();
        View view = this.f2448n.get();
        if (view != null) {
            view.removeCallbacks(this.f2458x);
        }
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public long mo56886b() {
        return this.f2450p ? this.f2449o : new C1331L().mo57101b();
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public AbstractC1379b mo56885b(float f) {
        m56904b(512, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public AbstractC1379b mo56883b(long j) {
        if (j >= 0) {
            this.f2452r = true;
            this.f2451q = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: c */
    public long mo56881c() {
        if (this.f2452r) {
            return this.f2451q;
        }
        return 0L;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: c */
    public AbstractC1379b mo56880c(float f) {
        m56909a(16, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: d */
    public AbstractC1379b mo56876d(float f) {
        m56904b(16, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: d */
    public void mo56877d() {
        m56899e();
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: e */
    public AbstractC1379b mo56873e(float f) {
        m56909a(32, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: f */
    public AbstractC1379b mo56872f(float f) {
        m56904b(32, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: g */
    public AbstractC1379b mo56871g(float f) {
        m56909a(64, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: h */
    public AbstractC1379b mo56870h(float f) {
        m56904b(64, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: i */
    public AbstractC1379b mo56869i(float f) {
        m56909a(4, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: j */
    public AbstractC1379b mo56868j(float f) {
        m56904b(4, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: k */
    public AbstractC1379b mo56867k(float f) {
        m56909a(8, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: l */
    public AbstractC1379b mo56866l(float f) {
        m56904b(8, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: m */
    public AbstractC1379b mo56865m(float f) {
        m56909a(1, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: n */
    public AbstractC1379b mo56864n(float f) {
        m56904b(1, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: o */
    public AbstractC1379b mo56863o(float f) {
        m56909a(2, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: p */
    public AbstractC1379b mo56862p(float f) {
        m56904b(2, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: q */
    public AbstractC1379b mo56861q(float f) {
        m56909a(128, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: r */
    public AbstractC1379b mo56860r(float f) {
        m56904b(128, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: s */
    public AbstractC1379b mo56859s(float f) {
        m56909a(256, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: t */
    public AbstractC1379b mo56858t(float f) {
        m56904b(256, f);
        return this;
    }
}
