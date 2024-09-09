package com.acse.ottn.animator.a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1361a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.acse.ottn.animator.a.e  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class C1365e extends AbstractC1361a {

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<AbstractC1361a> f4899b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<AbstractC1361a, C0083e> f4900c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<C0083e> f4901d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<C0083e> f4902e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f4903f = true;

    /* renamed from: g  reason: collision with root package name */
    private a f4904g = null;

    /* renamed from: h  reason: collision with root package name */
    boolean f4905h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4906i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f4907j = 0;

    /* renamed from: k  reason: collision with root package name */
    private L f4908k = null;

    /* renamed from: l  reason: collision with root package name */
    private long f4909l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.e$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements AbstractC1361a.InterfaceC0082a {

        /* renamed from: a  reason: collision with root package name */
        private C1365e f4910a;

        a(C1365e c1365e) {
            this.f4910a = c1365e;
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void a(AbstractC1361a abstractC1361a) {
            abstractC1361a.b(this);
            C1365e.this.f4899b.remove(abstractC1361a);
            boolean z3 = true;
            ((C0083e) this.f4910a.f4900c.get(abstractC1361a)).f4926f = true;
            if (C1365e.this.f4905h) {
                return;
            }
            ArrayList arrayList = this.f4910a.f4902e;
            int size = arrayList.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                } else if (!((C0083e) arrayList.get(i4)).f4926f) {
                    z3 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z3) {
                ArrayList<AbstractC1361a.InterfaceC0082a> arrayList2 = C1365e.this.f4880a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        ((AbstractC1361a.InterfaceC0082a) arrayList3.get(i5)).a(this.f4910a);
                    }
                }
                this.f4910a.f4906i = false;
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void b(AbstractC1361a abstractC1361a) {
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void c(AbstractC1361a abstractC1361a) {
            ArrayList<AbstractC1361a.InterfaceC0082a> arrayList;
            C1365e c1365e = C1365e.this;
            if (c1365e.f4905h || c1365e.f4899b.size() != 0 || (arrayList = C1365e.this.f4880a) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1365e.this.f4880a.get(i4).c(this.f4910a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void d(AbstractC1361a abstractC1361a) {
        }
    }

    /* renamed from: com.acse.ottn.animator.a.e$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private C0083e f4912a;

        b(AbstractC1361a abstractC1361a) {
            C0083e c0083e = (C0083e) C1365e.this.f4900c.get(abstractC1361a);
            this.f4912a = c0083e;
            if (c0083e == null) {
                this.f4912a = new C0083e(abstractC1361a);
                C1365e.this.f4900c.put(abstractC1361a, this.f4912a);
                C1365e.this.f4901d.add(this.f4912a);
            }
        }

        public b a(long j4) {
            L a4 = L.a(0.0f, 1.0f);
            a4.a(j4);
            a(a4);
            return this;
        }

        public b a(AbstractC1361a abstractC1361a) {
            C0083e c0083e = (C0083e) C1365e.this.f4900c.get(abstractC1361a);
            if (c0083e == null) {
                c0083e = new C0083e(abstractC1361a);
                C1365e.this.f4900c.put(abstractC1361a, c0083e);
                C1365e.this.f4901d.add(c0083e);
            }
            this.f4912a.a(new c(c0083e, 1));
            return this;
        }

        public b b(AbstractC1361a abstractC1361a) {
            C0083e c0083e = (C0083e) C1365e.this.f4900c.get(abstractC1361a);
            if (c0083e == null) {
                c0083e = new C0083e(abstractC1361a);
                C1365e.this.f4900c.put(abstractC1361a, c0083e);
                C1365e.this.f4901d.add(c0083e);
            }
            c0083e.a(new c(this.f4912a, 1));
            return this;
        }

        public b c(AbstractC1361a abstractC1361a) {
            C0083e c0083e = (C0083e) C1365e.this.f4900c.get(abstractC1361a);
            if (c0083e == null) {
                c0083e = new C0083e(abstractC1361a);
                C1365e.this.f4900c.put(abstractC1361a, c0083e);
                C1365e.this.f4901d.add(c0083e);
            }
            c0083e.a(new c(this.f4912a, 0));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.e$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        static final int f4914a = 0;

        /* renamed from: b  reason: collision with root package name */
        static final int f4915b = 1;

        /* renamed from: c  reason: collision with root package name */
        public C0083e f4916c;

        /* renamed from: d  reason: collision with root package name */
        public int f4917d;

        public c(C0083e c0083e, int i4) {
            this.f4916c = c0083e;
            this.f4917d = i4;
        }
    }

    /* renamed from: com.acse.ottn.animator.a.e$d */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class d implements AbstractC1361a.InterfaceC0082a {

        /* renamed from: a  reason: collision with root package name */
        private C1365e f4918a;

        /* renamed from: b  reason: collision with root package name */
        private C0083e f4919b;

        /* renamed from: c  reason: collision with root package name */
        private int f4920c;

        public d(C1365e c1365e, C0083e c0083e, int i4) {
            this.f4918a = c1365e;
            this.f4919b = c0083e;
            this.f4920c = i4;
        }

        private void e(AbstractC1361a abstractC1361a) {
            if (this.f4918a.f4905h) {
                return;
            }
            c cVar = null;
            int size = this.f4919b.f4923c.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                c cVar2 = this.f4919b.f4923c.get(i4);
                if (cVar2.f4917d == this.f4920c && cVar2.f4916c.f4921a == abstractC1361a) {
                    abstractC1361a.b(this);
                    cVar = cVar2;
                    break;
                }
                i4++;
            }
            this.f4919b.f4923c.remove(cVar);
            if (this.f4919b.f4923c.size() == 0) {
                this.f4919b.f4921a.j();
                this.f4918a.f4899b.add(this.f4919b.f4921a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void a(AbstractC1361a abstractC1361a) {
            if (this.f4920c == 1) {
                e(abstractC1361a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void b(AbstractC1361a abstractC1361a) {
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void c(AbstractC1361a abstractC1361a) {
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void d(AbstractC1361a abstractC1361a) {
            if (this.f4920c == 0) {
                e(abstractC1361a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.animator.a.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class C0083e implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public AbstractC1361a f4921a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c> f4922b = null;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<c> f4923c = null;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<C0083e> f4924d = null;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<C0083e> f4925e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4926f = false;

        public C0083e(AbstractC1361a abstractC1361a) {
            this.f4921a = abstractC1361a;
        }

        public void a(c cVar) {
            if (this.f4922b == null) {
                this.f4922b = new ArrayList<>();
                this.f4924d = new ArrayList<>();
            }
            this.f4922b.add(cVar);
            if (!this.f4924d.contains(cVar.f4916c)) {
                this.f4924d.add(cVar.f4916c);
            }
            C0083e c0083e = cVar.f4916c;
            if (c0083e.f4925e == null) {
                c0083e.f4925e = new ArrayList<>();
            }
            c0083e.f4925e.add(this);
        }

        /* renamed from: clone */
        public C0083e m11clone() {
            try {
                C0083e c0083e = (C0083e) super.clone();
                c0083e.f4921a = this.f4921a.mo10clone();
                return c0083e;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void l() {
        if (!this.f4903f) {
            int size = this.f4901d.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0083e c0083e = this.f4901d.get(i4);
                ArrayList<c> arrayList = c0083e.f4922b;
                if (arrayList != null && arrayList.size() > 0) {
                    int size2 = c0083e.f4922b.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        c cVar = c0083e.f4922b.get(i5);
                        if (c0083e.f4924d == null) {
                            c0083e.f4924d = new ArrayList<>();
                        }
                        if (!c0083e.f4924d.contains(cVar.f4916c)) {
                            c0083e.f4924d.add(cVar.f4916c);
                        }
                    }
                }
                c0083e.f4926f = false;
            }
            return;
        }
        this.f4902e.clear();
        ArrayList arrayList2 = new ArrayList();
        int size3 = this.f4901d.size();
        for (int i6 = 0; i6 < size3; i6++) {
            C0083e c0083e2 = this.f4901d.get(i6);
            ArrayList<c> arrayList3 = c0083e2.f4922b;
            if (arrayList3 == null || arrayList3.size() == 0) {
                arrayList2.add(c0083e2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        while (arrayList2.size() > 0) {
            int size4 = arrayList2.size();
            for (int i7 = 0; i7 < size4; i7++) {
                C0083e c0083e3 = (C0083e) arrayList2.get(i7);
                this.f4902e.add(c0083e3);
                ArrayList<C0083e> arrayList5 = c0083e3.f4925e;
                if (arrayList5 != null) {
                    int size5 = arrayList5.size();
                    for (int i8 = 0; i8 < size5; i8++) {
                        C0083e c0083e4 = c0083e3.f4925e.get(i8);
                        c0083e4.f4924d.remove(c0083e3);
                        if (c0083e4.f4924d.size() == 0) {
                            arrayList4.add(c0083e4);
                        }
                    }
                }
            }
            arrayList2.clear();
            arrayList2.addAll(arrayList4);
            arrayList4.clear();
        }
        this.f4903f = false;
        if (this.f4902e.size() != this.f4901d.size()) {
            throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        }
    }

    public b a(AbstractC1361a abstractC1361a) {
        if (abstractC1361a != null) {
            this.f4903f = true;
            return new b(abstractC1361a);
        }
        return null;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public C1365e a(long j4) {
        if (j4 >= 0) {
            Iterator<C0083e> it = this.f4901d.iterator();
            while (it.hasNext()) {
                it.next().f4921a.a(j4);
            }
            this.f4909l = j4;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void a() {
        this.f4905h = true;
        if (f()) {
            if (this.f4902e.size() != this.f4901d.size()) {
                l();
                Iterator<C0083e> it = this.f4902e.iterator();
                while (it.hasNext()) {
                    C0083e next = it.next();
                    if (this.f4904g == null) {
                        this.f4904g = new a(this);
                    }
                    next.f4921a.a((AbstractC1361a.InterfaceC0082a) this.f4904g);
                }
            }
            L l4 = this.f4908k;
            if (l4 != null) {
                l4.cancel();
            }
            if (this.f4902e.size() > 0) {
                Iterator<C0083e> it2 = this.f4902e.iterator();
                while (it2.hasNext()) {
                    it2.next().f4921a.a();
                }
            }
            ArrayList<AbstractC1361a.InterfaceC0082a> arrayList = this.f4880a;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((AbstractC1361a.InterfaceC0082a) it3.next()).a(this);
                }
            }
            this.f4906i = false;
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void a(Interpolator interpolator) {
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            it.next().f4921a.a(interpolator);
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void a(Object obj) {
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            AbstractC1361a abstractC1361a = it.next().f4921a;
            if (abstractC1361a instanceof C1365e) {
                ((C1365e) abstractC1361a).a(obj);
            } else if (abstractC1361a instanceof m) {
                ((m) abstractC1361a).a(obj);
            }
        }
    }

    public void a(Collection<AbstractC1361a> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f4903f = true;
        b bVar = null;
        for (AbstractC1361a abstractC1361a : collection) {
            if (bVar == null) {
                bVar = a(abstractC1361a);
            } else {
                bVar.c(abstractC1361a);
            }
        }
    }

    public void a(List<AbstractC1361a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f4903f = true;
        int i4 = 0;
        if (list.size() == 1) {
            a(list.get(0));
            return;
        }
        while (i4 < list.size() - 1) {
            i4++;
            a(list.get(i4)).b(list.get(i4));
        }
    }

    public void a(AbstractC1361a... abstractC1361aArr) {
        if (abstractC1361aArr != null) {
            this.f4903f = true;
            int i4 = 0;
            if (abstractC1361aArr.length == 1) {
                a(abstractC1361aArr[0]);
                return;
            }
            while (i4 < abstractC1361aArr.length - 1) {
                i4++;
                a(abstractC1361aArr[i4]).b(abstractC1361aArr[i4]);
            }
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public long b() {
        return this.f4909l;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void b(long j4) {
        this.f4907j = j4;
    }

    public void b(AbstractC1361a... abstractC1361aArr) {
        if (abstractC1361aArr != null) {
            this.f4903f = true;
            b a4 = a(abstractC1361aArr[0]);
            for (int i4 = 1; i4 < abstractC1361aArr.length; i4++) {
                a4.c(abstractC1361aArr[i4]);
            }
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void cancel() {
        this.f4905h = true;
        if (f()) {
            ArrayList arrayList = null;
            ArrayList<AbstractC1361a.InterfaceC0082a> arrayList2 = this.f4880a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC1361a.InterfaceC0082a) it.next()).c(this);
                }
            }
            L l4 = this.f4908k;
            if (l4 != null && l4.e()) {
                this.f4908k.cancel();
            } else if (this.f4902e.size() > 0) {
                Iterator<C0083e> it2 = this.f4902e.iterator();
                while (it2.hasNext()) {
                    it2.next().f4921a.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((AbstractC1361a.InterfaceC0082a) it3.next()).a(this);
                }
            }
            this.f4906i = false;
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    /* renamed from: clone */
    public C1365e mo10clone() {
        C1365e c1365e = (C1365e) super.mo10clone();
        c1365e.f4903f = true;
        c1365e.f4905h = false;
        c1365e.f4906i = false;
        c1365e.f4899b = new ArrayList<>();
        c1365e.f4900c = new HashMap<>();
        c1365e.f4901d = new ArrayList<>();
        c1365e.f4902e = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            C0083e next = it.next();
            C0083e m11clone = next.m11clone();
            hashMap.put(next, m11clone);
            c1365e.f4901d.add(m11clone);
            c1365e.f4900c.put(m11clone.f4921a, m11clone);
            ArrayList arrayList = null;
            m11clone.f4922b = null;
            m11clone.f4923c = null;
            m11clone.f4925e = null;
            m11clone.f4924d = null;
            ArrayList<AbstractC1361a.InterfaceC0082a> c4 = m11clone.f4921a.c();
            if (c4 != null) {
                Iterator<AbstractC1361a.InterfaceC0082a> it2 = c4.iterator();
                while (it2.hasNext()) {
                    AbstractC1361a.InterfaceC0082a next2 = it2.next();
                    if (next2 instanceof a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        c4.remove((AbstractC1361a.InterfaceC0082a) it3.next());
                    }
                }
            }
        }
        Iterator<C0083e> it4 = this.f4901d.iterator();
        while (it4.hasNext()) {
            C0083e next3 = it4.next();
            C0083e c0083e = (C0083e) hashMap.get(next3);
            ArrayList<c> arrayList2 = next3.f4922b;
            if (arrayList2 != null) {
                Iterator<c> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    c next4 = it5.next();
                    c0083e.a(new c((C0083e) hashMap.get(next4.f4916c), next4.f4917d));
                }
            }
        }
        return c1365e;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public long d() {
        return this.f4907j;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public boolean e() {
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            if (it.next().f4921a.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public boolean f() {
        return this.f4906i;
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void h() {
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            it.next().f4921a.h();
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void i() {
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            it.next().f4921a.i();
        }
    }

    @Override // com.acse.ottn.animator.a.AbstractC1361a
    public void j() {
        this.f4905h = false;
        this.f4906i = true;
        l();
        int size = this.f4902e.size();
        for (int i4 = 0; i4 < size; i4++) {
            C0083e c0083e = this.f4902e.get(i4);
            ArrayList<AbstractC1361a.InterfaceC0082a> c4 = c0083e.f4921a.c();
            if (c4 != null && c4.size() > 0) {
                Iterator it = new ArrayList(c4).iterator();
                while (it.hasNext()) {
                    AbstractC1361a.InterfaceC0082a interfaceC0082a = (AbstractC1361a.InterfaceC0082a) it.next();
                    if ((interfaceC0082a instanceof d) || (interfaceC0082a instanceof a)) {
                        c0083e.f4921a.b(interfaceC0082a);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            C0083e c0083e2 = this.f4902e.get(i5);
            if (this.f4904g == null) {
                this.f4904g = new a(this);
            }
            ArrayList<c> arrayList2 = c0083e2.f4922b;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(c0083e2);
            } else {
                int size2 = c0083e2.f4922b.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    c cVar = c0083e2.f4922b.get(i6);
                    cVar.f4916c.f4921a.a((AbstractC1361a.InterfaceC0082a) new d(this, c0083e2, cVar.f4917d));
                }
                c0083e2.f4923c = (ArrayList) c0083e2.f4922b.clone();
            }
            c0083e2.f4921a.a((AbstractC1361a.InterfaceC0082a) this.f4904g);
        }
        if (this.f4907j <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0083e c0083e3 = (C0083e) it2.next();
                c0083e3.f4921a.j();
                this.f4899b.add(c0083e3.f4921a);
            }
        } else {
            L a4 = L.a(0.0f, 1.0f);
            this.f4908k = a4;
            a4.a(this.f4907j);
            this.f4908k.a((AbstractC1361a.InterfaceC0082a) new C1364d(this, arrayList));
            this.f4908k.j();
        }
        ArrayList<AbstractC1361a.InterfaceC0082a> arrayList3 = this.f4880a;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i7 = 0; i7 < size3; i7++) {
                ((AbstractC1361a.InterfaceC0082a) arrayList4.get(i7)).d(this);
            }
        }
        if (this.f4901d.size() == 0 && this.f4907j == 0) {
            this.f4906i = false;
            ArrayList<AbstractC1361a.InterfaceC0082a> arrayList5 = this.f4880a;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i8 = 0; i8 < size4; i8++) {
                    ((AbstractC1361a.InterfaceC0082a) arrayList6.get(i8)).a(this);
                }
            }
        }
    }

    public ArrayList<AbstractC1361a> k() {
        ArrayList<AbstractC1361a> arrayList = new ArrayList<>();
        Iterator<C0083e> it = this.f4901d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f4921a);
        }
        return arrayList;
    }
}
