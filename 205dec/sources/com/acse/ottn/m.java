package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class m extends i {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<i> f5902b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<i, f> f5903c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<f> f5904d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<f> f5905e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public boolean f5906f = true;

    /* renamed from: g  reason: collision with root package name */
    public b f5907g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5908h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5909i = false;

    /* renamed from: j  reason: collision with root package name */
    public long f5910j = 0;

    /* renamed from: k  reason: collision with root package name */
    public g4 f5911k = null;

    /* renamed from: l  reason: collision with root package name */
    public long f5912l = -1;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends k {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5913a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f5914b;

        public a(ArrayList arrayList) {
            this.f5914b = arrayList;
        }

        @Override // com.acse.ottn.k, com.acse.ottn.i.a
        public void b(i iVar) {
            if (this.f5913a) {
                return;
            }
            int size = this.f5914b.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = (f) this.f5914b.get(i4);
                fVar.f5927a.k();
                m.this.f5902b.add(fVar.f5927a);
            }
        }

        @Override // com.acse.ottn.k, com.acse.ottn.i.a
        public void d(i iVar) {
            this.f5913a = true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public m f5916a;

        public b(m mVar) {
            this.f5916a = mVar;
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            iVar.b(this);
            m.this.f5902b.remove(iVar);
            boolean z3 = true;
            ((f) this.f5916a.f5903c.get(iVar)).f5932f = true;
            if (m.this.f5908h) {
                return;
            }
            ArrayList arrayList = this.f5916a.f5905e;
            int size = arrayList.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                } else if (!((f) arrayList.get(i4)).f5932f) {
                    z3 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z3) {
                ArrayList<i.a> arrayList2 = m.this.f5729a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        ((i.a) arrayList3.get(i5)).b(this.f5916a);
                    }
                }
                this.f5916a.f5909i = false;
            }
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
            ArrayList<i.a> arrayList;
            m mVar = m.this;
            if (mVar.f5908h || mVar.f5902b.size() != 0 || (arrayList = m.this.f5729a) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                m.this.f5729a.get(i4).d(this.f5916a);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class d {

        /* renamed from: c  reason: collision with root package name */
        public static final int f5920c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5921d = 1;

        /* renamed from: a  reason: collision with root package name */
        public f f5922a;

        /* renamed from: b  reason: collision with root package name */
        public int f5923b;

        public d(f fVar, int i4) {
            this.f5922a = fVar;
            this.f5923b = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class e implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public m f5924a;

        /* renamed from: b  reason: collision with root package name */
        public f f5925b;

        /* renamed from: c  reason: collision with root package name */
        public int f5926c;

        public e(m mVar, f fVar, int i4) {
            this.f5924a = mVar;
            this.f5925b = fVar;
            this.f5926c = i4;
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
            if (this.f5926c == 0) {
                e(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            if (this.f5926c == 1) {
                e(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
        }

        public final void e(i iVar) {
            if (this.f5924a.f5908h) {
                return;
            }
            d dVar = null;
            int size = this.f5925b.f5929c.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    break;
                }
                d dVar2 = this.f5925b.f5929c.get(i4);
                if (dVar2.f5923b == this.f5926c && dVar2.f5922a.f5927a == iVar) {
                    iVar.b(this);
                    dVar = dVar2;
                    break;
                }
                i4++;
            }
            this.f5925b.f5929c.remove(dVar);
            if (this.f5925b.f5929c.size() == 0) {
                this.f5925b.f5927a.k();
                this.f5924a.f5902b.add(this.f5925b.f5927a);
            }
        }
    }

    @Override // com.acse.ottn.i
    public void cancel() {
        this.f5908h = true;
        if (g()) {
            ArrayList arrayList = null;
            ArrayList<i.a> arrayList2 = this.f5729a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).d(this);
                }
            }
            g4 g4Var = this.f5911k;
            if (g4Var != null && g4Var.f()) {
                this.f5911k.cancel();
            } else if (this.f5905e.size() > 0) {
                Iterator<f> it2 = this.f5905e.iterator();
                while (it2.hasNext()) {
                    it2.next().f5927a.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((i.a) it3.next()).b(this);
                }
            }
            this.f5909i = false;
        }
    }

    @Override // com.acse.ottn.i
    public long e() {
        return this.f5910j;
    }

    @Override // com.acse.ottn.i
    public boolean f() {
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            if (it.next().f5927a.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.acse.ottn.i
    public boolean g() {
        return this.f5909i;
    }

    @Override // com.acse.ottn.i
    public void i() {
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            it.next().f5927a.i();
        }
    }

    @Override // com.acse.ottn.i
    public void j() {
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            it.next().f5927a.j();
        }
    }

    @Override // com.acse.ottn.i
    public void k() {
        this.f5908h = false;
        this.f5909i = true;
        n();
        int size = this.f5905e.size();
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = this.f5905e.get(i4);
            ArrayList<i.a> d4 = fVar.f5927a.d();
            if (d4 != null && d4.size() > 0) {
                Iterator it = new ArrayList(d4).iterator();
                while (it.hasNext()) {
                    i.a aVar = (i.a) it.next();
                    if ((aVar instanceof e) || (aVar instanceof b)) {
                        fVar.f5927a.b(aVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            f fVar2 = this.f5905e.get(i5);
            if (this.f5907g == null) {
                this.f5907g = new b(this);
            }
            ArrayList<d> arrayList2 = fVar2.f5928b;
            if (arrayList2 != null && arrayList2.size() != 0) {
                int size2 = fVar2.f5928b.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    d dVar = fVar2.f5928b.get(i6);
                    dVar.f5922a.f5927a.a((i.a) new e(this, fVar2, dVar.f5923b));
                }
                fVar2.f5929c = (ArrayList) fVar2.f5928b.clone();
            } else {
                arrayList.add(fVar2);
            }
            fVar2.f5927a.a((i.a) this.f5907g);
        }
        if (this.f5910j <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f fVar3 = (f) it2.next();
                fVar3.f5927a.k();
                this.f5902b.add(fVar3.f5927a);
            }
        } else {
            g4 a4 = g4.a(0.0f, 1.0f);
            this.f5911k = a4;
            a4.a(this.f5910j);
            this.f5911k.a((i.a) new a(arrayList));
            this.f5911k.k();
        }
        ArrayList<i.a> arrayList3 = this.f5729a;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i7 = 0; i7 < size3; i7++) {
                ((i.a) arrayList4.get(i7)).a(this);
            }
        }
        if (this.f5904d.size() == 0 && this.f5910j == 0) {
            this.f5909i = false;
            ArrayList<i.a> arrayList5 = this.f5729a;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i8 = 0; i8 < size4; i8++) {
                    ((i.a) arrayList6.get(i8)).b(this);
                }
            }
        }
    }

    @Override // com.acse.ottn.i
    /* renamed from: l */
    public m clone() {
        m mVar = (m) super.clone();
        mVar.f5906f = true;
        mVar.f5908h = false;
        mVar.f5909i = false;
        mVar.f5902b = new ArrayList<>();
        mVar.f5903c = new HashMap<>();
        mVar.f5904d = new ArrayList<>();
        mVar.f5905e = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            f next = it.next();
            f clone = next.clone();
            hashMap.put(next, clone);
            mVar.f5904d.add(clone);
            mVar.f5903c.put(clone.f5927a, clone);
            ArrayList arrayList = null;
            clone.f5928b = null;
            clone.f5929c = null;
            clone.f5931e = null;
            clone.f5930d = null;
            ArrayList<i.a> d4 = clone.f5927a.d();
            if (d4 != null) {
                Iterator<i.a> it2 = d4.iterator();
                while (it2.hasNext()) {
                    i.a next2 = it2.next();
                    if (next2 instanceof b) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        d4.remove((i.a) it3.next());
                    }
                }
            }
        }
        Iterator<f> it4 = this.f5904d.iterator();
        while (it4.hasNext()) {
            f next3 = it4.next();
            f fVar = (f) hashMap.get(next3);
            ArrayList<d> arrayList2 = next3.f5928b;
            if (arrayList2 != null) {
                Iterator<d> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    d next4 = it5.next();
                    fVar.a(new d((f) hashMap.get(next4.f5922a), next4.f5923b));
                }
            }
        }
        return mVar;
    }

    public ArrayList<i> m() {
        ArrayList<i> arrayList = new ArrayList<>();
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f5927a);
        }
        return arrayList;
    }

    public final void n() {
        if (this.f5906f) {
            this.f5905e.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f5904d.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.f5904d.get(i4);
                ArrayList<d> arrayList2 = fVar.f5928b;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(fVar);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    f fVar2 = (f) arrayList.get(i5);
                    this.f5905e.add(fVar2);
                    ArrayList<f> arrayList4 = fVar2.f5931e;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i6 = 0; i6 < size3; i6++) {
                            f fVar3 = fVar2.f5931e.get(i6);
                            fVar3.f5930d.remove(fVar2);
                            if (fVar3.f5930d.size() == 0) {
                                arrayList3.add(fVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.f5906f = false;
            if (this.f5905e.size() != this.f5904d.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f5904d.size();
        for (int i7 = 0; i7 < size4; i7++) {
            f fVar4 = this.f5904d.get(i7);
            ArrayList<d> arrayList5 = fVar4.f5928b;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = fVar4.f5928b.size();
                for (int i8 = 0; i8 < size5; i8++) {
                    d dVar = fVar4.f5928b.get(i8);
                    if (fVar4.f5930d == null) {
                        fVar4.f5930d = new ArrayList<>();
                    }
                    if (!fVar4.f5930d.contains(dVar.f5922a)) {
                        fVar4.f5930d.add(dVar.f5922a);
                    }
                }
            }
            fVar4.f5932f = false;
        }
    }

    public void b(i... iVarArr) {
        if (iVarArr != null) {
            this.f5906f = true;
            c a4 = a(iVarArr[0]);
            for (int i4 = 1; i4 < iVarArr.length; i4++) {
                a4.c(iVarArr[i4]);
            }
        }
    }

    @Override // com.acse.ottn.i
    public long c() {
        return this.f5912l;
    }

    @Override // com.acse.ottn.i
    /* renamed from: c */
    public m a(long j4) {
        if (j4 >= 0) {
            Iterator<f> it = this.f5904d.iterator();
            while (it.hasNext()) {
                it.next().f5927a.a(j4);
            }
            this.f5912l = j4;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    public void a(Collection<i> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f5906f = true;
        c cVar = null;
        for (i iVar : collection) {
            if (cVar == null) {
                cVar = a(iVar);
            } else {
                cVar.c(iVar);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public f f5918a;

        public c(i iVar) {
            f fVar = (f) m.this.f5903c.get(iVar);
            this.f5918a = fVar;
            if (fVar == null) {
                this.f5918a = new f(iVar);
                m.this.f5903c.put(iVar, this.f5918a);
                m.this.f5904d.add(this.f5918a);
            }
        }

        public c a(i iVar) {
            f fVar = (f) m.this.f5903c.get(iVar);
            if (fVar == null) {
                fVar = new f(iVar);
                m.this.f5903c.put(iVar, fVar);
                m.this.f5904d.add(fVar);
            }
            this.f5918a.a(new d(fVar, 1));
            return this;
        }

        public c b(i iVar) {
            f fVar = (f) m.this.f5903c.get(iVar);
            if (fVar == null) {
                fVar = new f(iVar);
                m.this.f5903c.put(iVar, fVar);
                m.this.f5904d.add(fVar);
            }
            fVar.a(new d(this.f5918a, 1));
            return this;
        }

        public c c(i iVar) {
            f fVar = (f) m.this.f5903c.get(iVar);
            if (fVar == null) {
                fVar = new f(iVar);
                m.this.f5903c.put(iVar, fVar);
                m.this.f5904d.add(fVar);
            }
            fVar.a(new d(this.f5918a, 0));
            return this;
        }

        public c a(long j4) {
            g4 a4 = g4.a(0.0f, 1.0f);
            a4.a(j4);
            a(a4);
            return this;
        }
    }

    @Override // com.acse.ottn.i
    public void b() {
        this.f5908h = true;
        if (g()) {
            if (this.f5905e.size() != this.f5904d.size()) {
                n();
                Iterator<f> it = this.f5905e.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (this.f5907g == null) {
                        this.f5907g = new b(this);
                    }
                    next.f5927a.a((i.a) this.f5907g);
                }
            }
            g4 g4Var = this.f5911k;
            if (g4Var != null) {
                g4Var.cancel();
            }
            if (this.f5905e.size() > 0) {
                Iterator<f> it2 = this.f5905e.iterator();
                while (it2.hasNext()) {
                    it2.next().f5927a.b();
                }
            }
            ArrayList<i.a> arrayList = this.f5729a;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((i.a) it3.next()).b(this);
                }
            }
            this.f5909i = false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class f implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public i f5927a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<d> f5928b = null;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<d> f5929c = null;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<f> f5930d = null;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<f> f5931e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5932f = false;

        public f(i iVar) {
            this.f5927a = iVar;
        }

        public void a(d dVar) {
            if (this.f5928b == null) {
                this.f5928b = new ArrayList<>();
                this.f5930d = new ArrayList<>();
            }
            this.f5928b.add(dVar);
            if (!this.f5930d.contains(dVar.f5922a)) {
                this.f5930d.add(dVar.f5922a);
            }
            f fVar = dVar.f5922a;
            if (fVar.f5931e == null) {
                fVar.f5931e = new ArrayList<>();
            }
            fVar.f5931e.add(this);
        }

        /* renamed from: a */
        public f clone() {
            try {
                f fVar = (f) super.clone();
                fVar.f5927a = this.f5927a.clone();
                return fVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    public void a(i... iVarArr) {
        if (iVarArr != null) {
            this.f5906f = true;
            int i4 = 0;
            if (iVarArr.length == 1) {
                a(iVarArr[0]);
                return;
            }
            while (i4 < iVarArr.length - 1) {
                i4++;
                a(iVarArr[i4]).b(iVarArr[i4]);
            }
        }
    }

    public void a(List<i> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f5906f = true;
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

    @Override // com.acse.ottn.i
    public void a(Object obj) {
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            i iVar = it.next().f5927a;
            if (iVar instanceof m) {
                ((m) iVar).a(obj);
            } else if (iVar instanceof p2) {
                ((p2) iVar).a(obj);
            }
        }
    }

    @Override // com.acse.ottn.i
    public void b(long j4) {
        this.f5910j = j4;
    }

    @Override // com.acse.ottn.i
    public void a(Interpolator interpolator) {
        Iterator<f> it = this.f5904d.iterator();
        while (it.hasNext()) {
            it.next().f5927a.a(interpolator);
        }
    }

    public c a(i iVar) {
        if (iVar != null) {
            this.f5906f = true;
            return new c(iVar);
        }
        return null;
    }
}
