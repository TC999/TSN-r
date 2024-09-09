package com.beizi.ad.internal;

import com.beizi.ad.internal.utilities.HaoboLog;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class m implements f {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<com.beizi.ad.internal.a.a> f13838a;

    /* renamed from: b  reason: collision with root package name */
    private long f13839b = -1;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f13840c = new ArrayList<>();

    @Override // com.beizi.ad.internal.f
    public long a(long j4) {
        long j5 = this.f13839b;
        if (j5 > 0) {
            return j4 - j5;
        }
        return -1L;
    }

    @Override // com.beizi.ad.internal.f
    public LinkedList<com.beizi.ad.internal.a.a> b() {
        return this.f13838a;
    }

    public abstract void e();

    public void g() {
        this.f13839b = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        if (this.f13840c.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("Mediation Classes: \n");
        for (int size = this.f13840c.size(); size > 0; size--) {
            sb.append(String.format("%d: %s\n", Integer.valueOf(size), this.f13840c.get(size - 1)));
        }
        HaoboLog.i(HaoboLog.mediationLogTag, sb.toString());
        this.f13840c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.beizi.ad.internal.a.a i() {
        LinkedList<com.beizi.ad.internal.a.a> linkedList = this.f13838a;
        if (linkedList == null || linkedList.getFirst() == null) {
            return null;
        }
        this.f13840c.add(this.f13838a.getFirst().a());
        return this.f13838a.removeFirst();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(LinkedList<com.beizi.ad.internal.a.a> linkedList) {
        this.f13838a = linkedList;
    }
}
