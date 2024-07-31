package com.kwad.framework.filedownloader.p349b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9461a;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9442b implements InterfaceC9440a {
    final SparseArray<C9464c> afn = new SparseArray<>();
    final SparseArray<List<C9461a>> afo = new SparseArray<>();

    /* renamed from: com.kwad.framework.filedownloader.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C9443a implements InterfaceC9440a.InterfaceC9441a {
        C9443a() {
        }

        @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a
        /* renamed from: a */
        public final void mo28765a(int i, C9464c c9464c) {
        }

        @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a
        /* renamed from: c */
        public final void mo28764c(C9464c c9464c) {
        }

        @Override // java.lang.Iterable
        public final Iterator<C9464c> iterator() {
            return new C9444b();
        }

        @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a.InterfaceC9441a
        /* renamed from: vg */
        public final void mo28763vg() {
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C9444b implements Iterator<C9464c> {
        C9444b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ C9464c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    /* renamed from: d */
    private void m28804d(C9464c c9464c) {
        synchronized (this.afn) {
            this.afn.put(c9464c.getId(), c9464c);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28794a(int i, long j, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28791a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28790a(int i, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28789a(int i, Throwable th, long j) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28784a(C9461a c9461a) {
        List<C9461a> list;
        try {
            int id = c9461a.getId();
            synchronized (this.afo) {
                list = this.afo.get(id);
                if (list == null) {
                    list = new ArrayList<>();
                    this.afo.put(id, list);
                }
            }
            list.add(c9461a);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: b */
    public final void mo28783b(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: b */
    public final void mo28782b(C9464c c9464c) {
        if (c9464c == null) {
            C9498d.m28534d(this, "update but model == null!", new Object[0]);
        } else if (mo28780bk(c9464c.getId()) != null) {
            synchronized (this.afn) {
                this.afn.remove(c9464c.getId());
                this.afn.put(c9464c.getId(), c9464c);
            }
        } else {
            m28804d(c9464c);
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bj */
    public final void mo28781bj(int i) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bk */
    public final C9464c mo28780bk(int i) {
        C9464c c9464c;
        synchronized (this.afn) {
            c9464c = this.afn.get(i);
        }
        return c9464c;
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bl */
    public final List<C9461a> mo28779bl(int i) {
        List<C9461a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.afo) {
                list = this.afo.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bm */
    public final void mo28778bm(int i) {
        try {
            synchronized (this.afo) {
                this.afo.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bn */
    public final boolean mo28777bn(int i) {
        synchronized (this.afn) {
            this.afn.remove(i);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: bo */
    public final void mo28776bo(int i) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: c */
    public final void mo28775c(int i, long j) {
        mo28777bn(i);
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    public final void clear() {
        synchronized (this.afn) {
            this.afn.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: d */
    public final void mo28774d(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: s */
    public final void mo28768s(int i, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: vf */
    public final InterfaceC9440a.InterfaceC9441a mo28767vf() {
        return new C9443a();
    }

    @Override // com.kwad.framework.filedownloader.p349b.InterfaceC9440a
    /* renamed from: a */
    public final void mo28795a(int i, int i2, long j) {
        List<C9461a> list;
        synchronized (this.afo) {
            list = this.afo.get(i);
        }
        if (list == null) {
            return;
        }
        for (C9461a c9461a : list) {
            if (c9461a.getIndex() == i2) {
                c9461a.m28712Q(j);
                return;
            }
        }
    }
}
