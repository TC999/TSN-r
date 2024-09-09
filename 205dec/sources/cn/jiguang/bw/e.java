package cn.jiguang.bw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static i[] f3029d = new i[0];

    /* renamed from: e  reason: collision with root package name */
    private static h[] f3030e = new h[0];

    /* renamed from: a  reason: collision with root package name */
    private d f3031a;

    /* renamed from: b  reason: collision with root package name */
    private List[] f3032b;

    /* renamed from: c  reason: collision with root package name */
    private int f3033c;

    public e() {
        this(new d());
    }

    e(b bVar) {
        this(new d(bVar));
        for (int i4 = 0; i4 < 4; i4++) {
            try {
                int c4 = this.f3031a.c(i4);
                if (c4 > 0) {
                    this.f3032b[i4] = new ArrayList(c4);
                }
                for (int i5 = 0; i5 < c4; i5++) {
                    this.f3032b[i4].add(i.a(bVar, i4));
                }
            } catch (IOException e4) {
                throw e4;
            }
        }
        this.f3033c = bVar.a();
    }

    private e(d dVar) {
        this.f3032b = new List[4];
        this.f3031a = dVar;
    }

    public e(byte[] bArr) {
        this(new b(bArr));
    }

    private int a(c cVar, int i4, a aVar, int i5) {
        int size = this.f3032b[i4].size();
        int a4 = cVar.a();
        i iVar = null;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i iVar2 = (i) this.f3032b[i4].get(i8);
            if (i4 == 3) {
                i6++;
            } else {
                if (iVar != null && !a(iVar2, iVar)) {
                    a4 = cVar.a();
                    i7 = i8;
                }
                iVar2.a(cVar, i4, aVar);
                if (cVar.a() > i5) {
                    cVar.a(a4);
                    return (size - i7) + i6;
                }
                iVar = iVar2;
            }
        }
        return i6;
    }

    public static e a(i iVar) {
        e eVar = new e();
        eVar.a(iVar, 0);
        return eVar;
    }

    private boolean a(c cVar, int i4) {
        if (i4 < 12) {
            return false;
        }
        cVar.a();
        this.f3031a.a(cVar);
        a aVar = new a();
        this.f3031a.c();
        for (int i5 = 0; i5 < 4; i5++) {
            if (this.f3032b[i5] != null) {
                a(cVar, i5, aVar, i4);
            }
        }
        return true;
    }

    private static boolean a(i iVar, i iVar2) {
        return iVar.f() == iVar2.f() && iVar.g() == iVar2.g() && iVar.d().equals(iVar2.d());
    }

    public i a() {
        List list = this.f3032b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (i) list.get(0);
    }

    public void a(i iVar, int i4) {
        List[] listArr = this.f3032b;
        if (listArr[i4] == null) {
            listArr[i4] = new LinkedList();
        }
        this.f3031a.b(i4);
        this.f3032b[i4].add(iVar);
    }

    public i[] a(int i4) {
        List[] listArr = this.f3032b;
        if (listArr[i4] == null) {
            return f3029d;
        }
        List list = listArr[i4];
        return (i[]) list.toArray(new i[list.size()]);
    }

    public h[] b(int i4) {
        if (this.f3032b[i4] == null) {
            return f3030e;
        }
        LinkedList linkedList = new LinkedList();
        i[] a4 = a(i4);
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < a4.length; i5++) {
            g d4 = a4[i5].d();
            boolean z3 = true;
            if (hashSet.contains(d4)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    h hVar = (h) linkedList.get(size);
                    if (hVar.c() == a4[i5].f() && hVar.d() == a4[i5].g() && hVar.b().equals(d4)) {
                        hVar.a(a4[i5]);
                        z3 = false;
                        break;
                    }
                    size--;
                }
            }
            if (z3) {
                linkedList.add(new h(a4[i5]));
                hashSet.add(d4);
            }
        }
        return (h[]) linkedList.toArray(new h[linkedList.size()]);
    }

    public byte[] c(int i4) {
        c cVar = new c();
        a(cVar, i4);
        this.f3033c = cVar.a();
        return cVar.b();
    }

    public Object clone() {
        e eVar = new e();
        int i4 = 0;
        while (true) {
            List[] listArr = this.f3032b;
            if (i4 >= listArr.length) {
                eVar.f3031a = (d) this.f3031a.clone();
                eVar.f3033c = this.f3033c;
                return eVar;
            }
            if (listArr[i4] != null) {
                eVar.f3032b[i4] = new LinkedList(this.f3032b[i4]);
            }
            i4++;
        }
    }
}
