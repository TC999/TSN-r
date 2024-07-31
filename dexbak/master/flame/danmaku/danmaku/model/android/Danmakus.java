package master.flame.danmaku.danmaku.model.android;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.Danmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;

/* renamed from: master.flame.danmaku.danmaku.model.android.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Danmakus implements IDanmakus {

    /* renamed from: e */
    public Collection<BaseDanmaku> f43802e;

    /* renamed from: f */
    private Danmakus f43803f;

    /* renamed from: g */
    private BaseDanmaku f43804g;

    /* renamed from: h */
    private BaseDanmaku f43805h;

    /* renamed from: i */
    private BaseDanmaku f43806i;

    /* renamed from: j */
    private BaseDanmaku f43807j;

    /* renamed from: k */
    private volatile AtomicInteger f43808k;

    /* renamed from: l */
    private int f43809l;

    /* renamed from: m */
    private IDanmakus.C15348a f43810m;

    /* renamed from: n */
    private boolean f43811n;

    /* renamed from: o */
    private Object f43812o;

    public Danmakus() {
        this(0, false);
    }

    /* renamed from: k */
    private BaseDanmaku m3141k(String str) {
        return new Danmaku(str);
    }

    /* renamed from: l */
    private void m3140l(boolean z) {
        this.f43810m.m3047b(z);
        this.f43811n = z;
    }

    /* renamed from: n */
    private Collection<BaseDanmaku> m3138n(long j, long j2) {
        Collection<BaseDanmaku> collection;
        if (this.f43809l == 4 || (collection = this.f43802e) == null || collection.size() == 0) {
            return null;
        }
        if (this.f43803f == null) {
            Danmakus danmakus = new Danmakus(this.f43811n);
            this.f43803f = danmakus;
            danmakus.f43812o = this.f43812o;
        }
        if (this.f43807j == null) {
            this.f43807j = m3141k(CampaignEx.JSON_NATIVE_VIDEO_START);
        }
        if (this.f43806i == null) {
            this.f43806i = m3141k("end");
        }
        this.f43807j.m3093D(j);
        this.f43806i.m3093D(j2);
        return ((SortedSet) this.f43802e).subSet(this.f43807j, this.f43806i);
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: a */
    public void mo3057a(IDanmakus.AbstractC15349b<? super BaseDanmaku, ?> abstractC15349b) {
        synchronized (this.f43812o) {
            mo3050h(abstractC15349b);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: b */
    public Collection<BaseDanmaku> mo3056b() {
        return this.f43802e;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: c */
    public void mo3055c(boolean z) {
        this.f43811n = z;
        this.f43805h = null;
        this.f43804g = null;
        if (this.f43803f == null) {
            Danmakus danmakus = new Danmakus(z);
            this.f43803f = danmakus;
            danmakus.f43812o = this.f43812o;
        }
        this.f43803f.m3140l(z);
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public void clear() {
        Collection<BaseDanmaku> collection = this.f43802e;
        if (collection != null) {
            collection.clear();
            this.f43808k.set(0);
        }
        if (this.f43803f != null) {
            this.f43803f = null;
            this.f43804g = m3141k(CampaignEx.JSON_NATIVE_VIDEO_START);
            this.f43805h = m3141k("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: d */
    public IDanmakus mo3054d(long j, long j2) {
        Collection<BaseDanmaku> m3138n = m3138n(j, j2);
        if (m3138n == null || m3138n.isEmpty()) {
            return null;
        }
        return new Danmakus(new LinkedList(m3138n));
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: e */
    public Object mo3053e() {
        return this.f43812o;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: f */
    public IDanmakus mo3052f(long j, long j2) {
        Collection<BaseDanmaku> collection = this.f43802e;
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (this.f43803f == null) {
            if (this.f43809l == 4) {
                Danmakus danmakus = new Danmakus(4);
                this.f43803f = danmakus;
                danmakus.f43812o = this.f43812o;
                synchronized (this.f43812o) {
                    this.f43803f.m3139m(this.f43802e);
                }
            } else {
                Danmakus danmakus2 = new Danmakus(this.f43811n);
                this.f43803f = danmakus2;
                danmakus2.f43812o = this.f43812o;
            }
        }
        if (this.f43809l == 4) {
            return this.f43803f;
        }
        if (this.f43804g == null) {
            this.f43804g = m3141k(CampaignEx.JSON_NATIVE_VIDEO_START);
        }
        if (this.f43805h == null) {
            this.f43805h = m3141k("end");
        }
        if (this.f43803f != null && j - this.f43804g.m3088b() >= 0 && j2 <= this.f43805h.m3088b()) {
            return this.f43803f;
        }
        this.f43804g.m3093D(j);
        this.f43805h.m3093D(j2);
        synchronized (this.f43812o) {
            this.f43803f.m3139m(((SortedSet) this.f43802e).subSet(this.f43804g, this.f43805h));
        }
        return this.f43803f;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public BaseDanmaku first() {
        Collection<BaseDanmaku> collection = this.f43802e;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.f43809l == 4) {
            return (BaseDanmaku) ((LinkedList) this.f43802e).peek();
        }
        return (BaseDanmaku) ((SortedSet) this.f43802e).first();
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: g */
    public boolean mo3051g(BaseDanmaku baseDanmaku) {
        if (baseDanmaku == null) {
            return false;
        }
        if (baseDanmaku.m3076s()) {
            baseDanmaku.m3090G(false);
        }
        if (this.f43802e.remove(baseDanmaku)) {
            this.f43808k.decrementAndGet();
            return true;
        }
        return false;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: h */
    public void mo3050h(IDanmakus.AbstractC15349b<? super BaseDanmaku, ?> abstractC15349b) {
        abstractC15349b.mo2955c();
        Iterator<BaseDanmaku> it = this.f43802e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BaseDanmaku next = it.next();
            if (next != null) {
                int mo2892a = abstractC15349b.mo2892a(next);
                if (mo2892a == 1) {
                    break;
                } else if (mo2892a == 2) {
                    it.remove();
                    this.f43808k.decrementAndGet();
                } else if (mo2892a == 3) {
                    it.remove();
                    this.f43808k.decrementAndGet();
                    break;
                }
            }
        }
        abstractC15349b.mo2963b();
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: i */
    public boolean mo3049i(BaseDanmaku baseDanmaku) {
        Collection<BaseDanmaku> collection = this.f43802e;
        if (collection != null) {
            try {
                if (collection.add(baseDanmaku)) {
                    this.f43808k.incrementAndGet();
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public boolean isEmpty() {
        Collection<BaseDanmaku> collection = this.f43802e;
        return collection == null || collection.isEmpty();
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    /* renamed from: j */
    public boolean mo3048j(BaseDanmaku baseDanmaku) {
        Collection<BaseDanmaku> collection = this.f43802e;
        return collection != null && collection.contains(baseDanmaku);
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public BaseDanmaku last() {
        Collection<BaseDanmaku> collection = this.f43802e;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.f43809l == 4) {
            return (BaseDanmaku) ((LinkedList) this.f43802e).peekLast();
        }
        return (BaseDanmaku) ((SortedSet) this.f43802e).last();
    }

    /* renamed from: m */
    public void m3139m(Collection<BaseDanmaku> collection) {
        if (this.f43811n && this.f43809l != 4) {
            this.f43802e.clear();
            this.f43802e.addAll(collection);
            collection = this.f43802e;
        } else {
            this.f43802e = collection;
        }
        if (collection instanceof List) {
            this.f43809l = 4;
        }
        this.f43808k.set(collection == null ? 0 : collection.size());
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public int size() {
        return this.f43808k.get();
    }

    public Danmakus(int i) {
        this(i, false);
    }

    public Danmakus(int i, boolean z) {
        IDanmakus.C15348a c15353f;
        this.f43808k = new AtomicInteger(0);
        this.f43809l = 0;
        this.f43812o = new Object();
        if (i == 0) {
            c15353f = new IDanmakus.C15351d(z);
        } else if (i == 1) {
            c15353f = new IDanmakus.C15352e(z);
        } else {
            c15353f = i == 2 ? new IDanmakus.C15353f(z) : null;
        }
        if (i == 4) {
            this.f43802e = new LinkedList();
        } else {
            this.f43811n = z;
            c15353f.m3047b(z);
            this.f43802e = new TreeSet(c15353f);
            this.f43810m = c15353f;
        }
        this.f43809l = i;
        this.f43808k.set(0);
    }

    public Danmakus(Collection<BaseDanmaku> collection) {
        this.f43808k = new AtomicInteger(0);
        this.f43809l = 0;
        this.f43812o = new Object();
        m3139m(collection);
    }

    public Danmakus(boolean z) {
        this(0, z);
    }
}
