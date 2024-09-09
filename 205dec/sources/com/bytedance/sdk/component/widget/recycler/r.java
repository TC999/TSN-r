package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.c;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    final c f30596c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        c.w c(int i4, int i5, int i6, Object obj);

        void c(c.w wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.f30596c = cVar;
    }

    private void xv(List<c.w> list, int i4, c.w wVar, int i5, c.w wVar2) {
        int i6 = wVar.sr;
        int i7 = wVar2.f30574w;
        int i8 = i6 < i7 ? -1 : 0;
        int i9 = wVar.f30574w;
        if (i9 < i7) {
            i8++;
        }
        if (i7 <= i9) {
            wVar.f30574w = i9 + wVar2.sr;
        }
        int i10 = wVar2.f30574w;
        if (i10 <= i6) {
            wVar.sr = i6 + wVar2.sr;
        }
        wVar2.f30574w = i10 + i8;
        list.set(i4, wVar2);
        list.set(i5, wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(List<c.w> list) {
        while (true) {
            int w3 = w(list);
            if (w3 == -1) {
                return;
            }
            c(list, w3, w3 + 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void w(java.util.List<com.bytedance.sdk.component.widget.recycler.c.w> r9, int r10, com.bytedance.sdk.component.widget.recycler.c.w r11, int r12, com.bytedance.sdk.component.widget.recycler.c.w r13) {
        /*
            r8 = this;
            int r0 = r11.sr
            int r1 = r13.f30574w
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f30574w = r1
            goto L20
        Ld:
            int r5 = r13.sr
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.sr = r5
            com.bytedance.sdk.component.widget.recycler.r$c r0 = r8.f30596c
            int r1 = r11.f30574w
            java.lang.Object r5 = r13.xv
            com.bytedance.sdk.component.widget.recycler.c$w r0 = r0.c(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f30574w
            int r5 = r13.f30574w
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f30574w = r5
            goto L41
        L2b:
            int r6 = r13.sr
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            com.bytedance.sdk.component.widget.recycler.r$c r3 = r8.f30596c
            int r1 = r1 + r4
            java.lang.Object r4 = r13.xv
            com.bytedance.sdk.component.widget.recycler.c$w r3 = r3.c(r2, r1, r5, r4)
            int r1 = r13.sr
            int r1 = r1 - r5
            r13.sr = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.sr
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            com.bytedance.sdk.component.widget.recycler.r$c r11 = r8.f30596c
            r11.c(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.r.w(java.util.List, int, com.bytedance.sdk.component.widget.recycler.c$w, int, com.bytedance.sdk.component.widget.recycler.c$w):void");
    }

    private void c(List<c.w> list, int i4, int i5) {
        c.w wVar = list.get(i4);
        c.w wVar2 = list.get(i5);
        int i6 = wVar2.f30573c;
        if (i6 == 1) {
            xv(list, i4, wVar, i5, wVar2);
        } else if (i6 == 2) {
            c(list, i4, wVar, i5, wVar2);
        } else if (i6 != 4) {
        } else {
            w(list, i4, wVar, i5, wVar2);
        }
    }

    void c(List<c.w> list, int i4, c.w wVar, int i5, c.w wVar2) {
        boolean z3;
        int i6 = wVar.f30574w;
        int i7 = wVar.sr;
        boolean z4 = false;
        if (i6 < i7) {
            if (wVar2.f30574w == i6 && wVar2.sr == i7 - i6) {
                z3 = false;
                z4 = true;
            } else {
                z3 = false;
            }
        } else if (wVar2.f30574w == i7 + 1 && wVar2.sr == i6 - i7) {
            z3 = true;
            z4 = true;
        } else {
            z3 = true;
        }
        int i8 = wVar2.f30574w;
        if (i7 < i8) {
            wVar2.f30574w = i8 - 1;
        } else {
            int i9 = wVar2.sr;
            if (i7 < i8 + i9) {
                wVar2.sr = i9 - 1;
                wVar.f30573c = 2;
                wVar.sr = 1;
                if (wVar2.sr == 0) {
                    list.remove(i5);
                    this.f30596c.c(wVar2);
                    return;
                }
                return;
            }
        }
        int i10 = wVar.f30574w;
        int i11 = wVar2.f30574w;
        c.w wVar3 = null;
        if (i10 <= i11) {
            wVar2.f30574w = i11 + 1;
        } else {
            int i12 = wVar2.sr;
            if (i10 < i11 + i12) {
                wVar3 = this.f30596c.c(2, i10 + 1, (i11 + i12) - i10, null);
                wVar2.sr = wVar.f30574w - wVar2.f30574w;
            }
        }
        if (z4) {
            list.set(i4, wVar2);
            list.remove(i5);
            this.f30596c.c(wVar);
            return;
        }
        if (z3) {
            if (wVar3 != null) {
                int i13 = wVar.f30574w;
                if (i13 > wVar3.f30574w) {
                    wVar.f30574w = i13 - wVar3.sr;
                }
                int i14 = wVar.sr;
                if (i14 > wVar3.f30574w) {
                    wVar.sr = i14 - wVar3.sr;
                }
            }
            int i15 = wVar.f30574w;
            if (i15 > wVar2.f30574w) {
                wVar.f30574w = i15 - wVar2.sr;
            }
            int i16 = wVar.sr;
            if (i16 > wVar2.f30574w) {
                wVar.sr = i16 - wVar2.sr;
            }
        } else {
            if (wVar3 != null) {
                int i17 = wVar.f30574w;
                if (i17 >= wVar3.f30574w) {
                    wVar.f30574w = i17 - wVar3.sr;
                }
                int i18 = wVar.sr;
                if (i18 >= wVar3.f30574w) {
                    wVar.sr = i18 - wVar3.sr;
                }
            }
            int i19 = wVar.f30574w;
            if (i19 >= wVar2.f30574w) {
                wVar.f30574w = i19 - wVar2.sr;
            }
            int i20 = wVar.sr;
            if (i20 >= wVar2.f30574w) {
                wVar.sr = i20 - wVar2.sr;
            }
        }
        list.set(i4, wVar2);
        if (wVar.f30574w != wVar.sr) {
            list.set(i5, wVar);
        } else {
            list.remove(i5);
        }
        if (wVar3 != null) {
            list.add(i4, wVar3);
        }
    }

    private int w(List<c.w> list) {
        boolean z3 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f30573c != 8) {
                z3 = true;
            } else if (z3) {
                return size;
            }
        }
        return -1;
    }
}
