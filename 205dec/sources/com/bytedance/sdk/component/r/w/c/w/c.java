package com.bytedance.sdk.component.r.w.c.w;

import com.bytedance.sdk.component.r.c.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c<T extends com.bytedance.sdk.component.r.c.w> extends com.bytedance.sdk.component.r.w.c.c {

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.r.w.sr.w.c f30077c;
    public com.bytedance.sdk.component.r.c.ux sr;
    private Queue<String> ux;

    /* renamed from: w  reason: collision with root package name */
    public Queue<T> f30078w = new ConcurrentLinkedQueue();
    public String xv;

    public c(com.bytedance.sdk.component.r.w.sr.w.c cVar, Queue<String> queue, String str, com.bytedance.sdk.component.r.c.ux uxVar) {
        this.f30077c = cVar;
        this.ux = queue;
        this.sr = uxVar;
        this.xv = str;
    }

    public com.bytedance.sdk.component.r.w.c.w c(int i4, List<T> list) {
        com.bytedance.sdk.component.r.w.c.w wVar = new com.bytedance.sdk.component.r.w.c.w();
        if (list != null && list.size() != 0 && list.get(0) != null && c(list.get(0))) {
            w(i4, list);
            wVar.c(true);
            return wVar;
        }
        wVar.c(false);
        return wVar;
    }

    public void w(T t3) {
        if (this.f30078w == null || t3 == null || !c(t3)) {
            return;
        }
        this.f30078w.offer(t3);
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public List<com.bytedance.sdk.component.r.c.w> w(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        do {
            T poll = this.f30078w.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        } while (arrayList.size() != this.f30077c.w());
        return arrayList;
    }

    private void w(int i4, List<T> list) {
        Queue<T> queue;
        com.bytedance.sdk.component.r.c.w wVar;
        if (i4 == -1 || i4 == 200 || i4 == 509 || i4 == -3) {
            com.bytedance.sdk.component.r.w.xv.xv.c(this.xv + " memory size\uff1a" + this.f30078w.size(), this.sr);
            if (list == null || list.size() == 0 || (queue = this.f30078w) == null || queue.size() == 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (T t3 : this.f30078w) {
                if (t3 != null) {
                    hashMap.put(t3.xv(), t3);
                }
            }
            for (T t4 : list) {
                if (t4 != null && (wVar = (com.bytedance.sdk.component.r.c.w) hashMap.get(t4.xv())) != null) {
                    this.f30078w.remove(wVar);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public boolean c(String str) {
        int size = this.f30078w.size();
        com.bytedance.sdk.component.r.w.xv.xv.c(str + " checkFlushMeet --> " + this.xv + " cacheQueueSize:" + size, this.sr);
        return size >= 1;
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public boolean w(int i4, String str, com.bytedance.sdk.component.r.c.w wVar) {
        int size = this.f30078w.size();
        int c4 = this.f30077c.c();
        com.bytedance.sdk.component.r.w.xv.xv.c(str + " checkEventComeMeet --> " + this.xv + " cacheQueueSize:" + size + " MaxCacheCount:" + c4 + " message:" + com.bytedance.sdk.component.r.w.xv.c.w(i4), this.sr);
        return size >= c4;
    }
}
