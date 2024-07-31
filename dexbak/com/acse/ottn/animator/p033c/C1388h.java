package com.acse.ottn.animator.p033c;

import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import com.acse.ottn.animator.p031a.C1331L;
import com.acse.ottn.animator.p033c.p034a.C1378a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.c.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1388h extends AbstractC1379b {

    /* renamed from: b */
    private static final int f2471b = 0;

    /* renamed from: c */
    private static final int f2472c = 1;

    /* renamed from: d */
    private static final int f2473d = 2;

    /* renamed from: e */
    private static final int f2474e = 4;

    /* renamed from: f */
    private static final int f2475f = 8;

    /* renamed from: g */
    private static final int f2476g = 16;

    /* renamed from: h */
    private static final int f2477h = 32;

    /* renamed from: i */
    private static final int f2478i = 64;

    /* renamed from: j */
    private static final int f2479j = 128;

    /* renamed from: k */
    private static final int f2480k = 256;

    /* renamed from: l */
    private static final int f2481l = 512;

    /* renamed from: m */
    private static final int f2482m = 511;

    /* renamed from: n */
    private final C1378a f2483n;

    /* renamed from: o */
    private final WeakReference<View> f2484o;

    /* renamed from: p */
    private long f2485p;

    /* renamed from: t */
    private Interpolator f2489t;

    /* renamed from: q */
    private boolean f2486q = false;

    /* renamed from: r */
    private long f2487r = 0;

    /* renamed from: s */
    private boolean f2488s = false;

    /* renamed from: u */
    private boolean f2490u = false;

    /* renamed from: v */
    private AbstractC1334a.InterfaceC1335a f2491v = null;

    /* renamed from: w */
    private C1389a f2492w = new C1389a(this, null);

    /* renamed from: x */
    ArrayList<C1390b> f2493x = new ArrayList<>();

    /* renamed from: y */
    private Runnable f2494y = new RunnableC1387g(this);

    /* renamed from: z */
    private HashMap<AbstractC1334a, C1391c> f2495z = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.c.h$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1389a implements AbstractC1334a.InterfaceC1335a, C1331L.InterfaceC1333b {
        private C1389a() {
        }

        /* synthetic */ C1389a(C1388h c1388h, RunnableC1387g runnableC1387g) {
            this();
        }

        @Override // com.acse.ottn.animator.p031a.C1331L.InterfaceC1333b
        /* renamed from: a */
        public void mo56857a(C1331L c1331l) {
            View view;
            float m57127r = c1331l.m57127r();
            C1391c c1391c = (C1391c) C1388h.this.f2495z.get(c1331l);
            if ((c1391c.f2500a & 511) != 0 && (view = (View) C1388h.this.f2484o.get()) != null) {
                view.invalidate();
            }
            ArrayList<C1390b> arrayList = c1391c.f2501b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C1390b c1390b = arrayList.get(i);
                    C1388h.this.m56879c(c1390b.f2497a, c1390b.f2498b + (c1390b.f2499c * m57127r));
                }
            }
            View view2 = (View) C1388h.this.f2484o.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: a */
        public void mo56852a(AbstractC1334a abstractC1334a) {
            if (C1388h.this.f2491v != null) {
                C1388h.this.f2491v.mo56852a(abstractC1334a);
            }
            C1388h.this.f2495z.remove(abstractC1334a);
            if (C1388h.this.f2495z.isEmpty()) {
                C1388h.this.f2491v = null;
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: b */
        public void mo56856b(AbstractC1334a abstractC1334a) {
            if (C1388h.this.f2491v != null) {
                C1388h.this.f2491v.mo56856b(abstractC1334a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: c */
        public void mo56855c(AbstractC1334a abstractC1334a) {
            if (C1388h.this.f2491v != null) {
                C1388h.this.f2491v.mo56855c(abstractC1334a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: d */
        public void mo56854d(AbstractC1334a abstractC1334a) {
            if (C1388h.this.f2491v != null) {
                C1388h.this.f2491v.mo56854d(abstractC1334a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.c.h$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1390b {

        /* renamed from: a */
        int f2497a;

        /* renamed from: b */
        float f2498b;

        /* renamed from: c */
        float f2499c;

        C1390b(int i, float f, float f2) {
            this.f2497a = i;
            this.f2498b = f;
            this.f2499c = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.c.h$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1391c {

        /* renamed from: a */
        int f2500a;

        /* renamed from: b */
        ArrayList<C1390b> f2501b;

        C1391c(int i, ArrayList<C1390b> arrayList) {
            this.f2500a = i;
            this.f2501b = arrayList;
        }

        /* renamed from: a */
        boolean m56853a(int i) {
            ArrayList<C1390b> arrayList;
            if ((this.f2500a & i) != 0 && (arrayList = this.f2501b) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f2501b.get(i2).f2497a == i) {
                        this.f2501b.remove(i2);
                        this.f2500a = (i ^ (-1)) & this.f2500a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1388h(View view) {
        this.f2484o = new WeakReference<>(view);
        this.f2483n = C1378a.m56966a(view);
    }

    /* renamed from: a */
    private float m56895a(int i) {
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
                                            return this.f2483n.m56972a();
                                        }
                                        return this.f2483n.m56915n();
                                    }
                                    return this.f2483n.m56917m();
                                }
                                return this.f2483n.m56945f();
                            }
                            return this.f2483n.m56949e();
                        }
                        return this.f2483n.m56953d();
                    }
                    return this.f2483n.m56937h();
                }
                return this.f2483n.m56941g();
            }
            return this.f2483n.m56921l();
        }
        return this.f2483n.m56925k();
    }

    /* renamed from: a */
    private void m56894a(int i, float f) {
        float m56895a = m56895a(i);
        m56893a(i, m56895a, f - m56895a);
    }

    /* renamed from: a */
    private void m56893a(int i, float f, float f2) {
        if (this.f2495z.size() > 0) {
            AbstractC1334a abstractC1334a = null;
            Iterator<AbstractC1334a> it = this.f2495z.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC1334a next = it.next();
                C1391c c1391c = this.f2495z.get(next);
                if (c1391c.m56853a(i) && c1391c.f2500a == 0) {
                    abstractC1334a = next;
                    break;
                }
            }
            if (abstractC1334a != null) {
                abstractC1334a.cancel();
            }
        }
        this.f2493x.add(new C1390b(i, f, f2));
        View view = this.f2484o.get();
        if (view != null) {
            view.removeCallbacks(this.f2494y);
            view.post(this.f2494y);
        }
    }

    /* renamed from: b */
    private void m56884b(int i, float f) {
        m56893a(i, m56895a(i), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m56879c(int i, float f) {
        if (i == 1) {
            this.f2483n.m56932i(f);
        } else if (i == 2) {
            this.f2483n.m56928j(f);
        } else if (i == 4) {
            this.f2483n.m56940g(f);
        } else if (i == 8) {
            this.f2483n.m56936h(f);
        } else if (i == 16) {
            this.f2483n.m56952d(f);
        } else if (i == 32) {
            this.f2483n.m56948e(f);
        } else if (i == 64) {
            this.f2483n.m56944f(f);
        } else if (i == 128) {
            this.f2483n.m56924k(f);
        } else if (i == 256) {
            this.f2483n.m56920l(f);
        } else if (i != 512) {
        } else {
            this.f2483n.m56971a(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m56874e() {
        C1331L m57146a = C1331L.m57146a(1.0f);
        ArrayList arrayList = (ArrayList) this.f2493x.clone();
        this.f2493x.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((C1390b) arrayList.get(i2)).f2497a;
        }
        this.f2495z.put(m57146a, new C1391c(i, arrayList));
        m57146a.m57152a((C1331L.InterfaceC1333b) this.f2492w);
        m57146a.m57118a((AbstractC1334a.InterfaceC1335a) this.f2492w);
        if (this.f2488s) {
            m57146a.mo57100b(this.f2487r);
        }
        if (this.f2486q) {
            m57146a.mo57054a(this.f2485p);
        }
        if (this.f2490u) {
            m57146a.mo57108a(this.f2489t);
        }
        m57146a.mo57038j();
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56896a(float f) {
        m56894a(512, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56892a(long j) {
        if (j >= 0) {
            this.f2486q = true;
            this.f2485p = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56891a(Interpolator interpolator) {
        this.f2490u = true;
        this.f2489t = interpolator;
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56890a(AbstractC1334a.InterfaceC1335a interfaceC1335a) {
        this.f2491v = interfaceC1335a;
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public void mo56897a() {
        if (this.f2495z.size() > 0) {
            for (AbstractC1334a abstractC1334a : ((HashMap) this.f2495z.clone()).keySet()) {
                abstractC1334a.cancel();
            }
        }
        this.f2493x.clear();
        View view = this.f2484o.get();
        if (view != null) {
            view.removeCallbacks(this.f2494y);
        }
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public long mo56886b() {
        return this.f2486q ? this.f2485p : new C1331L().mo57101b();
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public AbstractC1379b mo56885b(float f) {
        m56884b(512, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public AbstractC1379b mo56883b(long j) {
        if (j >= 0) {
            this.f2488s = true;
            this.f2487r = j;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: c */
    public long mo56881c() {
        if (this.f2488s) {
            return this.f2487r;
        }
        return 0L;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: c */
    public AbstractC1379b mo56880c(float f) {
        m56894a(16, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: d */
    public AbstractC1379b mo56876d(float f) {
        m56884b(16, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: d */
    public void mo56877d() {
        m56874e();
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: e */
    public AbstractC1379b mo56873e(float f) {
        m56894a(32, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: f */
    public AbstractC1379b mo56872f(float f) {
        m56884b(32, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: g */
    public AbstractC1379b mo56871g(float f) {
        m56894a(64, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: h */
    public AbstractC1379b mo56870h(float f) {
        m56884b(64, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: i */
    public AbstractC1379b mo56869i(float f) {
        m56894a(4, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: j */
    public AbstractC1379b mo56868j(float f) {
        m56884b(4, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: k */
    public AbstractC1379b mo56867k(float f) {
        m56894a(8, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: l */
    public AbstractC1379b mo56866l(float f) {
        m56884b(8, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: m */
    public AbstractC1379b mo56865m(float f) {
        m56894a(1, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: n */
    public AbstractC1379b mo56864n(float f) {
        m56884b(1, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: o */
    public AbstractC1379b mo56863o(float f) {
        m56894a(2, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: p */
    public AbstractC1379b mo56862p(float f) {
        m56884b(2, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: q */
    public AbstractC1379b mo56861q(float f) {
        m56894a(128, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: r */
    public AbstractC1379b mo56860r(float f) {
        m56884b(128, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: s */
    public AbstractC1379b mo56859s(float f) {
        m56894a(256, f);
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: t */
    public AbstractC1379b mo56858t(float f) {
        m56884b(256, f);
        return this;
    }
}
