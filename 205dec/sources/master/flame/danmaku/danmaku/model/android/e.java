package master.flame.danmaku.danmaku.model.android;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.model.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Danmakus.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e implements m {

    /* renamed from: e  reason: collision with root package name */
    public Collection<master.flame.danmaku.danmaku.model.d> f61110e;

    /* renamed from: f  reason: collision with root package name */
    private e f61111f;

    /* renamed from: g  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f61112g;

    /* renamed from: h  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f61113h;

    /* renamed from: i  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f61114i;

    /* renamed from: j  reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f61115j;

    /* renamed from: k  reason: collision with root package name */
    private volatile AtomicInteger f61116k;

    /* renamed from: l  reason: collision with root package name */
    private int f61117l;

    /* renamed from: m  reason: collision with root package name */
    private m.a f61118m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f61119n;

    /* renamed from: o  reason: collision with root package name */
    private Object f61120o;

    public e() {
        this(0, false);
    }

    private master.flame.danmaku.danmaku.model.d k(String str) {
        return new master.flame.danmaku.danmaku.model.e(str);
    }

    private void l(boolean z3) {
        this.f61118m.b(z3);
        this.f61119n = z3;
    }

    private Collection<master.flame.danmaku.danmaku.model.d> n(long j4, long j5) {
        Collection<master.flame.danmaku.danmaku.model.d> collection;
        if (this.f61117l == 4 || (collection = this.f61110e) == null || collection.size() == 0) {
            return null;
        }
        if (this.f61111f == null) {
            e eVar = new e(this.f61119n);
            this.f61111f = eVar;
            eVar.f61120o = this.f61120o;
        }
        if (this.f61115j == null) {
            this.f61115j = k(CampaignEx.JSON_NATIVE_VIDEO_START);
        }
        if (this.f61114i == null) {
            this.f61114i = k("end");
        }
        this.f61115j.D(j4);
        this.f61114i.D(j5);
        return ((SortedSet) this.f61110e).subSet(this.f61115j, this.f61114i);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void a(m.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        synchronized (this.f61120o) {
            h(bVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public Collection<master.flame.danmaku.danmaku.model.d> b() {
        return this.f61110e;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void c(boolean z3) {
        this.f61119n = z3;
        this.f61113h = null;
        this.f61112g = null;
        if (this.f61111f == null) {
            e eVar = new e(z3);
            this.f61111f = eVar;
            eVar.f61120o = this.f61120o;
        }
        this.f61111f.l(z3);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void clear() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        if (collection != null) {
            collection.clear();
            this.f61116k.set(0);
        }
        if (this.f61111f != null) {
            this.f61111f = null;
            this.f61112g = k(CampaignEx.JSON_NATIVE_VIDEO_START);
            this.f61113h = k("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public m d(long j4, long j5) {
        Collection<master.flame.danmaku.danmaku.model.d> n4 = n(j4, j5);
        if (n4 == null || n4.isEmpty()) {
            return null;
        }
        return new e(new LinkedList(n4));
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public Object e() {
        return this.f61120o;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public m f(long j4, long j5) {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (this.f61111f == null) {
            if (this.f61117l == 4) {
                e eVar = new e(4);
                this.f61111f = eVar;
                eVar.f61120o = this.f61120o;
                synchronized (this.f61120o) {
                    this.f61111f.m(this.f61110e);
                }
            } else {
                e eVar2 = new e(this.f61119n);
                this.f61111f = eVar2;
                eVar2.f61120o = this.f61120o;
            }
        }
        if (this.f61117l == 4) {
            return this.f61111f;
        }
        if (this.f61112g == null) {
            this.f61112g = k(CampaignEx.JSON_NATIVE_VIDEO_START);
        }
        if (this.f61113h == null) {
            this.f61113h = k("end");
        }
        if (this.f61111f != null && j4 - this.f61112g.b() >= 0 && j5 <= this.f61113h.b()) {
            return this.f61111f;
        }
        this.f61112g.D(j4);
        this.f61113h.D(j5);
        synchronized (this.f61120o) {
            this.f61111f.m(((SortedSet) this.f61110e).subSet(this.f61112g, this.f61113h));
        }
        return this.f61111f;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public master.flame.danmaku.danmaku.model.d first() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.f61117l == 4) {
            return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.f61110e).peek();
        }
        return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.f61110e).first();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean g(master.flame.danmaku.danmaku.model.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar.s()) {
            dVar.G(false);
        }
        if (this.f61110e.remove(dVar)) {
            this.f61116k.decrementAndGet();
            return true;
        }
        return false;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public void h(m.b<? super master.flame.danmaku.danmaku.model.d, ?> bVar) {
        bVar.c();
        Iterator<master.flame.danmaku.danmaku.model.d> it = this.f61110e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            master.flame.danmaku.danmaku.model.d next = it.next();
            if (next != null) {
                int a4 = bVar.a(next);
                if (a4 == 1) {
                    break;
                } else if (a4 == 2) {
                    it.remove();
                    this.f61116k.decrementAndGet();
                } else if (a4 == 3) {
                    it.remove();
                    this.f61116k.decrementAndGet();
                    break;
                }
            }
        }
        bVar.b();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean i(master.flame.danmaku.danmaku.model.d dVar) {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        if (collection != null) {
            try {
                if (collection.add(dVar)) {
                    this.f61116k.incrementAndGet();
                    return true;
                }
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean isEmpty() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        return collection == null || collection.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public boolean j(master.flame.danmaku.danmaku.model.d dVar) {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        return collection != null && collection.contains(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public master.flame.danmaku.danmaku.model.d last() {
        Collection<master.flame.danmaku.danmaku.model.d> collection = this.f61110e;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.f61117l == 4) {
            return (master.flame.danmaku.danmaku.model.d) ((LinkedList) this.f61110e).peekLast();
        }
        return (master.flame.danmaku.danmaku.model.d) ((SortedSet) this.f61110e).last();
    }

    public void m(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        if (this.f61119n && this.f61117l != 4) {
            this.f61110e.clear();
            this.f61110e.addAll(collection);
            collection = this.f61110e;
        } else {
            this.f61110e = collection;
        }
        if (collection instanceof List) {
            this.f61117l = 4;
        }
        this.f61116k.set(collection == null ? 0 : collection.size());
    }

    @Override // master.flame.danmaku.danmaku.model.m
    public int size() {
        return this.f61116k.get();
    }

    public e(int i4) {
        this(i4, false);
    }

    public e(int i4, boolean z3) {
        m.a fVar;
        this.f61116k = new AtomicInteger(0);
        this.f61117l = 0;
        this.f61120o = new Object();
        if (i4 == 0) {
            fVar = new m.d(z3);
        } else if (i4 == 1) {
            fVar = new m.e(z3);
        } else {
            fVar = i4 == 2 ? new m.f(z3) : null;
        }
        if (i4 == 4) {
            this.f61110e = new LinkedList();
        } else {
            this.f61119n = z3;
            fVar.b(z3);
            this.f61110e = new TreeSet(fVar);
            this.f61118m = fVar;
        }
        this.f61117l = i4;
        this.f61116k.set(0);
    }

    public e(Collection<master.flame.danmaku.danmaku.model.d> collection) {
        this.f61116k = new AtomicInteger(0);
        this.f61117l = 0;
        this.f61120o = new Object();
        m(collection);
    }

    public e(boolean z3) {
        this(0, z3);
    }
}
