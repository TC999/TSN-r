package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> afn = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> afo = new SparseArray<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a implements a.InterfaceC0667a {
        a() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0667a
        public final void a(int i4, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0667a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return new C0668b();
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0667a
        public final void vg() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.framework.filedownloader.b.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class C0668b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        C0668b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.afn) {
            this.afn.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, long j4, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, String str, long j4, long j5, int i5) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, Throwable th, long j4) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            int id = aVar.getId();
            synchronized (this.afo) {
                list = this.afo.get(id);
                if (list == null) {
                    list = new ArrayList<>();
                    this.afo.put(id, list);
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i4, long j4) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (bk(cVar.getId()) != null) {
            synchronized (this.afn) {
                this.afn.remove(cVar.getId());
                this.afn.put(cVar.getId(), cVar);
            }
        } else {
            d(cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i4) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i4) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.afn) {
            cVar = this.afn.get(i4);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i4) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.afo) {
                list = this.afo.get(i4);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i4) {
        try {
            synchronized (this.afo) {
                this.afo.remove(i4);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i4) {
        synchronized (this.afn) {
            this.afn.remove(i4);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i4) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i4, long j4) {
        bn(i4);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.afn) {
            this.afn.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i4, long j4) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i4, int i5) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0667a vf() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i4, int i5, long j4) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.afo) {
            list = this.afo.get(i4);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i5) {
                aVar.Q(j4);
                return;
            }
        }
    }
}
