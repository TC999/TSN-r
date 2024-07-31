package com.acse.ottn.animator.p031a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.acse.ottn.animator.a.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1339e extends AbstractC1334a {

    /* renamed from: b */
    private ArrayList<AbstractC1334a> f2352b = new ArrayList<>();

    /* renamed from: c */
    private HashMap<AbstractC1334a, C1344e> f2353c = new HashMap<>();

    /* renamed from: d */
    private ArrayList<C1344e> f2354d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<C1344e> f2355e = new ArrayList<>();

    /* renamed from: f */
    private boolean f2356f = true;

    /* renamed from: g */
    private C1340a f2357g = null;

    /* renamed from: h */
    boolean f2358h = false;

    /* renamed from: i */
    private boolean f2359i = false;

    /* renamed from: j */
    private long f2360j = 0;

    /* renamed from: k */
    private C1331L f2361k = null;

    /* renamed from: l */
    private long f2362l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.e$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1340a implements AbstractC1334a.InterfaceC1335a {

        /* renamed from: a */
        private C1339e f2363a;

        C1340a(C1339e c1339e) {
            this.f2363a = c1339e;
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: a */
        public void mo56852a(AbstractC1334a abstractC1334a) {
            abstractC1334a.m57117b(this);
            C1339e.this.f2352b.remove(abstractC1334a);
            boolean z = true;
            ((C1344e) this.f2363a.f2353c.get(abstractC1334a)).f2379f = true;
            if (C1339e.this.f2358h) {
                return;
            }
            ArrayList arrayList = this.f2363a.f2355e;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (!((C1344e) arrayList.get(i)).f2379f) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                ArrayList<AbstractC1334a.InterfaceC1335a> arrayList2 = C1339e.this.f2333a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((AbstractC1334a.InterfaceC1335a) arrayList3.get(i2)).mo56852a(this.f2363a);
                    }
                }
                this.f2363a.f2359i = false;
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: b */
        public void mo56856b(AbstractC1334a abstractC1334a) {
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: c */
        public void mo56855c(AbstractC1334a abstractC1334a) {
            ArrayList<AbstractC1334a.InterfaceC1335a> arrayList;
            C1339e c1339e = C1339e.this;
            if (c1339e.f2358h || c1339e.f2352b.size() != 0 || (arrayList = C1339e.this.f2333a) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                C1339e.this.f2333a.get(i).mo56855c(this.f2363a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: d */
        public void mo56854d(AbstractC1334a abstractC1334a) {
        }
    }

    /* renamed from: com.acse.ottn.animator.a.e$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1341b {

        /* renamed from: a */
        private C1344e f2365a;

        C1341b(AbstractC1334a abstractC1334a) {
            C1344e c1344e = (C1344e) C1339e.this.f2353c.get(abstractC1334a);
            this.f2365a = c1344e;
            if (c1344e == null) {
                this.f2365a = new C1344e(abstractC1334a);
                C1339e.this.f2353c.put(abstractC1334a, this.f2365a);
                C1339e.this.f2354d.add(this.f2365a);
            }
        }

        /* renamed from: a */
        public C1341b m57090a(long j) {
            C1331L m57146a = C1331L.m57146a(0.0f, 1.0f);
            m57146a.mo57054a(j);
            m57089a(m57146a);
            return this;
        }

        /* renamed from: a */
        public C1341b m57089a(AbstractC1334a abstractC1334a) {
            C1344e c1344e = (C1344e) C1339e.this.f2353c.get(abstractC1334a);
            if (c1344e == null) {
                c1344e = new C1344e(abstractC1334a);
                C1339e.this.f2353c.put(abstractC1334a, c1344e);
                C1339e.this.f2354d.add(c1344e);
            }
            this.f2365a.m57085a(new C1342c(c1344e, 1));
            return this;
        }

        /* renamed from: b */
        public C1341b m57088b(AbstractC1334a abstractC1334a) {
            C1344e c1344e = (C1344e) C1339e.this.f2353c.get(abstractC1334a);
            if (c1344e == null) {
                c1344e = new C1344e(abstractC1334a);
                C1339e.this.f2353c.put(abstractC1334a, c1344e);
                C1339e.this.f2354d.add(c1344e);
            }
            c1344e.m57085a(new C1342c(this.f2365a, 1));
            return this;
        }

        /* renamed from: c */
        public C1341b m57087c(AbstractC1334a abstractC1334a) {
            C1344e c1344e = (C1344e) C1339e.this.f2353c.get(abstractC1334a);
            if (c1344e == null) {
                c1344e = new C1344e(abstractC1334a);
                C1339e.this.f2353c.put(abstractC1334a, c1344e);
                C1339e.this.f2354d.add(c1344e);
            }
            c1344e.m57085a(new C1342c(this.f2365a, 0));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.e$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1342c {

        /* renamed from: a */
        static final int f2367a = 0;

        /* renamed from: b */
        static final int f2368b = 1;

        /* renamed from: c */
        public C1344e f2369c;

        /* renamed from: d */
        public int f2370d;

        public C1342c(C1344e c1344e, int i) {
            this.f2369c = c1344e;
            this.f2370d = i;
        }
    }

    /* renamed from: com.acse.ottn.animator.a.e$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1343d implements AbstractC1334a.InterfaceC1335a {

        /* renamed from: a */
        private C1339e f2371a;

        /* renamed from: b */
        private C1344e f2372b;

        /* renamed from: c */
        private int f2373c;

        public C1343d(C1339e c1339e, C1344e c1344e, int i) {
            this.f2371a = c1339e;
            this.f2372b = c1344e;
            this.f2373c = i;
        }

        /* renamed from: e */
        private void m57086e(AbstractC1334a abstractC1334a) {
            if (this.f2371a.f2358h) {
                return;
            }
            C1342c c1342c = null;
            int size = this.f2372b.f2376c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                C1342c c1342c2 = this.f2372b.f2376c.get(i);
                if (c1342c2.f2370d == this.f2373c && c1342c2.f2369c.f2374a == abstractC1334a) {
                    abstractC1334a.m57117b(this);
                    c1342c = c1342c2;
                    break;
                }
                i++;
            }
            this.f2372b.f2376c.remove(c1342c);
            if (this.f2372b.f2376c.size() == 0) {
                this.f2372b.f2374a.mo57038j();
                this.f2371a.f2352b.add(this.f2372b.f2374a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: a */
        public void mo56852a(AbstractC1334a abstractC1334a) {
            if (this.f2373c == 1) {
                m57086e(abstractC1334a);
            }
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: b */
        public void mo56856b(AbstractC1334a abstractC1334a) {
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: c */
        public void mo56855c(AbstractC1334a abstractC1334a) {
        }

        @Override // com.acse.ottn.animator.p031a.AbstractC1334a.InterfaceC1335a
        /* renamed from: d */
        public void mo56854d(AbstractC1334a abstractC1334a) {
            if (this.f2373c == 0) {
                m57086e(abstractC1334a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.e$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1344e implements Cloneable {

        /* renamed from: a */
        public AbstractC1334a f2374a;

        /* renamed from: b */
        public ArrayList<C1342c> f2375b = null;

        /* renamed from: c */
        public ArrayList<C1342c> f2376c = null;

        /* renamed from: d */
        public ArrayList<C1344e> f2377d = null;

        /* renamed from: e */
        public ArrayList<C1344e> f2378e = null;

        /* renamed from: f */
        public boolean f2379f = false;

        public C1344e(AbstractC1334a abstractC1334a) {
            this.f2374a = abstractC1334a;
        }

        /* renamed from: a */
        public void m57085a(C1342c c1342c) {
            if (this.f2375b == null) {
                this.f2375b = new ArrayList<>();
                this.f2377d = new ArrayList<>();
            }
            this.f2375b.add(c1342c);
            if (!this.f2377d.contains(c1342c.f2369c)) {
                this.f2377d.add(c1342c.f2369c);
            }
            C1344e c1344e = c1342c.f2369c;
            if (c1344e.f2378e == null) {
                c1344e.f2378e = new ArrayList<>();
            }
            c1344e.f2378e.add(this);
        }

        /* renamed from: clone */
        public C1344e m60090clone() {
            try {
                C1344e c1344e = (C1344e) super.clone();
                c1344e.f2374a = this.f2374a.mo60089clone();
                return c1344e;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: l */
    private void m57091l() {
        if (!this.f2356f) {
            int size = this.f2354d.size();
            for (int i = 0; i < size; i++) {
                C1344e c1344e = this.f2354d.get(i);
                ArrayList<C1342c> arrayList = c1344e.f2375b;
                if (arrayList != null && arrayList.size() > 0) {
                    int size2 = c1344e.f2375b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        C1342c c1342c = c1344e.f2375b.get(i2);
                        if (c1344e.f2377d == null) {
                            c1344e.f2377d = new ArrayList<>();
                        }
                        if (!c1344e.f2377d.contains(c1342c.f2369c)) {
                            c1344e.f2377d.add(c1342c.f2369c);
                        }
                    }
                }
                c1344e.f2379f = false;
            }
            return;
        }
        this.f2355e.clear();
        ArrayList arrayList2 = new ArrayList();
        int size3 = this.f2354d.size();
        for (int i3 = 0; i3 < size3; i3++) {
            C1344e c1344e2 = this.f2354d.get(i3);
            ArrayList<C1342c> arrayList3 = c1344e2.f2375b;
            if (arrayList3 == null || arrayList3.size() == 0) {
                arrayList2.add(c1344e2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        while (arrayList2.size() > 0) {
            int size4 = arrayList2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                C1344e c1344e3 = (C1344e) arrayList2.get(i4);
                this.f2355e.add(c1344e3);
                ArrayList<C1344e> arrayList5 = c1344e3.f2378e;
                if (arrayList5 != null) {
                    int size5 = arrayList5.size();
                    for (int i5 = 0; i5 < size5; i5++) {
                        C1344e c1344e4 = c1344e3.f2378e.get(i5);
                        c1344e4.f2377d.remove(c1344e3);
                        if (c1344e4.f2377d.size() == 0) {
                            arrayList4.add(c1344e4);
                        }
                    }
                }
            }
            arrayList2.clear();
            arrayList2.addAll(arrayList4);
            arrayList4.clear();
        }
        this.f2356f = false;
        if (this.f2355e.size() != this.f2354d.size()) {
            throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        }
    }

    /* renamed from: a */
    public C1341b m57107a(AbstractC1334a abstractC1334a) {
        if (abstractC1334a != null) {
            this.f2356f = true;
            return new C1341b(abstractC1334a);
        }
        return null;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public C1339e mo57054a(long j) {
        if (j >= 0) {
            Iterator<C1344e> it = this.f2354d.iterator();
            while (it.hasNext()) {
                it.next().f2374a.mo57054a(j);
            }
            this.f2362l = j;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public void mo57109a() {
        this.f2358h = true;
        if (mo57093f()) {
            if (this.f2355e.size() != this.f2354d.size()) {
                m57091l();
                Iterator<C1344e> it = this.f2355e.iterator();
                while (it.hasNext()) {
                    C1344e next = it.next();
                    if (this.f2357g == null) {
                        this.f2357g = new C1340a(this);
                    }
                    next.f2374a.m57118a((AbstractC1334a.InterfaceC1335a) this.f2357g);
                }
            }
            C1331L c1331l = this.f2361k;
            if (c1331l != null) {
                c1331l.cancel();
            }
            if (this.f2355e.size() > 0) {
                Iterator<C1344e> it2 = this.f2355e.iterator();
                while (it2.hasNext()) {
                    it2.next().f2374a.mo57109a();
                }
            }
            ArrayList<AbstractC1334a.InterfaceC1335a> arrayList = this.f2333a;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((AbstractC1334a.InterfaceC1335a) it3.next()).mo56852a(this);
                }
            }
            this.f2359i = false;
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public void mo57108a(Interpolator interpolator) {
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            it.next().f2374a.mo57108a(interpolator);
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: a */
    public void mo57052a(Object obj) {
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            AbstractC1334a abstractC1334a = it.next().f2374a;
            if (abstractC1334a instanceof C1339e) {
                ((C1339e) abstractC1334a).mo57052a(obj);
            } else if (abstractC1334a instanceof C1355m) {
                ((C1355m) abstractC1334a).mo57052a(obj);
            }
        }
    }

    /* renamed from: a */
    public void m57104a(Collection<AbstractC1334a> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f2356f = true;
        C1341b c1341b = null;
        for (AbstractC1334a abstractC1334a : collection) {
            if (c1341b == null) {
                c1341b = m57107a(abstractC1334a);
            } else {
                c1341b.m57087c(abstractC1334a);
            }
        }
    }

    /* renamed from: a */
    public void m57103a(List<AbstractC1334a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f2356f = true;
        int i = 0;
        if (list.size() == 1) {
            m57107a(list.get(0));
            return;
        }
        while (i < list.size() - 1) {
            i++;
            m57107a(list.get(i)).m57088b(list.get(i));
        }
    }

    /* renamed from: a */
    public void m57102a(AbstractC1334a... abstractC1334aArr) {
        if (abstractC1334aArr != null) {
            this.f2356f = true;
            int i = 0;
            if (abstractC1334aArr.length == 1) {
                m57107a(abstractC1334aArr[0]);
                return;
            }
            while (i < abstractC1334aArr.length - 1) {
                i++;
                m57107a(abstractC1334aArr[i]).m57088b(abstractC1334aArr[i]);
            }
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: b */
    public long mo57101b() {
        return this.f2362l;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: b */
    public void mo57100b(long j) {
        this.f2360j = j;
    }

    /* renamed from: b */
    public void m57098b(AbstractC1334a... abstractC1334aArr) {
        if (abstractC1334aArr != null) {
            this.f2356f = true;
            C1341b m57107a = m57107a(abstractC1334aArr[0]);
            for (int i = 1; i < abstractC1334aArr.length; i++) {
                m57107a.m57087c(abstractC1334aArr[i]);
            }
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    public void cancel() {
        this.f2358h = true;
        if (mo57093f()) {
            ArrayList arrayList = null;
            ArrayList<AbstractC1334a.InterfaceC1335a> arrayList2 = this.f2333a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC1334a.InterfaceC1335a) it.next()).mo56855c(this);
                }
            }
            C1331L c1331l = this.f2361k;
            if (c1331l != null && c1331l.mo57094e()) {
                this.f2361k.cancel();
            } else if (this.f2355e.size() > 0) {
                Iterator<C1344e> it2 = this.f2355e.iterator();
                while (it2.hasNext()) {
                    it2.next().f2374a.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((AbstractC1334a.InterfaceC1335a) it3.next()).mo56852a(this);
                }
            }
            this.f2359i = false;
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: clone */
    public C1339e mo60089clone() {
        C1339e c1339e = (C1339e) super.mo60089clone();
        c1339e.f2356f = true;
        c1339e.f2358h = false;
        c1339e.f2359i = false;
        c1339e.f2352b = new ArrayList<>();
        c1339e.f2353c = new HashMap<>();
        c1339e.f2354d = new ArrayList<>();
        c1339e.f2355e = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            C1344e next = it.next();
            C1344e m60090clone = next.m60090clone();
            hashMap.put(next, m60090clone);
            c1339e.f2354d.add(m60090clone);
            c1339e.f2353c.put(m60090clone.f2374a, m60090clone);
            ArrayList arrayList = null;
            m60090clone.f2375b = null;
            m60090clone.f2376c = null;
            m60090clone.f2378e = null;
            m60090clone.f2377d = null;
            ArrayList<AbstractC1334a.InterfaceC1335a> m57116c = m60090clone.f2374a.m57116c();
            if (m57116c != null) {
                Iterator<AbstractC1334a.InterfaceC1335a> it2 = m57116c.iterator();
                while (it2.hasNext()) {
                    AbstractC1334a.InterfaceC1335a next2 = it2.next();
                    if (next2 instanceof C1340a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        m57116c.remove((AbstractC1334a.InterfaceC1335a) it3.next());
                    }
                }
            }
        }
        Iterator<C1344e> it4 = this.f2354d.iterator();
        while (it4.hasNext()) {
            C1344e next3 = it4.next();
            C1344e c1344e = (C1344e) hashMap.get(next3);
            ArrayList<C1342c> arrayList2 = next3.f2375b;
            if (arrayList2 != null) {
                Iterator<C1342c> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    C1342c next4 = it5.next();
                    c1344e.m57085a(new C1342c((C1344e) hashMap.get(next4.f2369c), next4.f2370d));
                }
            }
        }
        return c1339e;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: d */
    public long mo57096d() {
        return this.f2360j;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: e */
    public boolean mo57094e() {
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            if (it.next().f2374a.mo57094e()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: f */
    public boolean mo57093f() {
        return this.f2359i;
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: h */
    public void mo57040h() {
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            it.next().f2374a.mo57040h();
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: i */
    public void mo57039i() {
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            it.next().f2374a.mo57039i();
        }
    }

    @Override // com.acse.ottn.animator.p031a.AbstractC1334a
    /* renamed from: j */
    public void mo57038j() {
        this.f2358h = false;
        this.f2359i = true;
        m57091l();
        int size = this.f2355e.size();
        for (int i = 0; i < size; i++) {
            C1344e c1344e = this.f2355e.get(i);
            ArrayList<AbstractC1334a.InterfaceC1335a> m57116c = c1344e.f2374a.m57116c();
            if (m57116c != null && m57116c.size() > 0) {
                Iterator it = new ArrayList(m57116c).iterator();
                while (it.hasNext()) {
                    AbstractC1334a.InterfaceC1335a interfaceC1335a = (AbstractC1334a.InterfaceC1335a) it.next();
                    if ((interfaceC1335a instanceof C1343d) || (interfaceC1335a instanceof C1340a)) {
                        c1344e.f2374a.m57117b(interfaceC1335a);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            C1344e c1344e2 = this.f2355e.get(i2);
            if (this.f2357g == null) {
                this.f2357g = new C1340a(this);
            }
            ArrayList<C1342c> arrayList2 = c1344e2.f2375b;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(c1344e2);
            } else {
                int size2 = c1344e2.f2375b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1342c c1342c = c1344e2.f2375b.get(i3);
                    c1342c.f2369c.f2374a.m57118a((AbstractC1334a.InterfaceC1335a) new C1343d(this, c1344e2, c1342c.f2370d));
                }
                c1344e2.f2376c = (ArrayList) c1344e2.f2375b.clone();
            }
            c1344e2.f2374a.m57118a((AbstractC1334a.InterfaceC1335a) this.f2357g);
        }
        if (this.f2360j <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1344e c1344e3 = (C1344e) it2.next();
                c1344e3.f2374a.mo57038j();
                this.f2352b.add(c1344e3.f2374a);
            }
        } else {
            C1331L m57146a = C1331L.m57146a(0.0f, 1.0f);
            this.f2361k = m57146a;
            m57146a.mo57054a(this.f2360j);
            this.f2361k.m57118a((AbstractC1334a.InterfaceC1335a) new C1338d(this, arrayList));
            this.f2361k.mo57038j();
        }
        ArrayList<AbstractC1334a.InterfaceC1335a> arrayList3 = this.f2333a;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((AbstractC1334a.InterfaceC1335a) arrayList4.get(i4)).mo56854d(this);
            }
        }
        if (this.f2354d.size() == 0 && this.f2360j == 0) {
            this.f2359i = false;
            ArrayList<AbstractC1334a.InterfaceC1335a> arrayList5 = this.f2333a;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    ((AbstractC1334a.InterfaceC1335a) arrayList6.get(i5)).mo56852a(this);
                }
            }
        }
    }

    /* renamed from: k */
    public ArrayList<AbstractC1334a> m57092k() {
        ArrayList<AbstractC1334a> arrayList = new ArrayList<>();
        Iterator<C1344e> it = this.f2354d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f2374a);
        }
        return arrayList;
    }
}
