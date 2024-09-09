package cn.jiguang.bw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private List f3052a;

    /* renamed from: b  reason: collision with root package name */
    private short f3053b;

    /* renamed from: c  reason: collision with root package name */
    private short f3054c;

    public h() {
        this.f3052a = new ArrayList(1);
        this.f3053b = (short) 0;
        this.f3054c = (short) 0;
    }

    public h(i iVar) {
        this();
        b(iVar);
    }

    private String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            stringBuffer.append("[");
            stringBuffer.append(((i) it.next()).c());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z3, boolean z4) {
        int i4;
        List subList;
        int size = this.f3052a.size();
        int i5 = z3 ? size - this.f3053b : this.f3053b;
        if (i5 == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z3) {
            i4 = size - this.f3053b;
        } else if (z4) {
            if (this.f3054c >= i5) {
                this.f3054c = (short) 0;
            }
            i4 = this.f3054c;
            this.f3054c = (short) (i4 + 1);
        } else {
            i4 = 0;
        }
        ArrayList arrayList = new ArrayList(i5);
        if (z3) {
            arrayList.addAll(this.f3052a.subList(i4, i5));
            if (i4 != 0) {
                subList = this.f3052a.subList(0, i4);
            }
            return arrayList.iterator();
        }
        subList = this.f3052a.subList(i4, size);
        arrayList.addAll(subList);
        return arrayList.iterator();
    }

    private void b(i iVar) {
        if (this.f3053b == 0) {
            this.f3052a.add(iVar);
            return;
        }
        List list = this.f3052a;
        list.add(list.size() - this.f3053b, iVar);
    }

    public synchronized Iterator a() {
        return a(true, true);
    }

    public synchronized void a(i iVar) {
        if (this.f3052a.size() == 0) {
            b(iVar);
            return;
        }
        i f4 = f();
        if (!iVar.a(f4)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (iVar.h() != f4.h()) {
            if (iVar.h() > f4.h()) {
                iVar = iVar.i();
                iVar.a(f4.h());
            } else {
                for (int i4 = 0; i4 < this.f3052a.size(); i4++) {
                    i i5 = ((i) this.f3052a.get(i4)).i();
                    i5.a(iVar.h());
                    this.f3052a.set(i4, i5);
                }
            }
        }
        if (!this.f3052a.contains(iVar)) {
            b(iVar);
        }
    }

    public g b() {
        return f().d();
    }

    public int c() {
        return f().f();
    }

    public int d() {
        return f().g();
    }

    public synchronized long e() {
        return f().h();
    }

    public synchronized i f() {
        if (this.f3052a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (i) this.f3052a.get(0);
    }

    public String toString() {
        if (this.f3052a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(b() + " ");
        stringBuffer.append(e() + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.f3053b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
