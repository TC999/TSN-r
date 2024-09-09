package com.bytedance.sdk.component.r.w.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements ux {

    /* renamed from: c  reason: collision with root package name */
    private final ux f30079c;
    private com.bytedance.sdk.component.r.c.ux sr;

    /* renamed from: w  reason: collision with root package name */
    private final sr f30080w;
    private final Queue<String> xv;

    public xv(com.bytedance.sdk.component.r.c.ux uxVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.xv = concurrentLinkedQueue;
        this.sr = uxVar;
        this.f30079c = new f(concurrentLinkedQueue, uxVar);
        this.f30080w = new sr(this.sr);
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list) {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public synchronized void c(com.bytedance.sdk.component.r.c.w wVar, int i4) {
        ux uxVar;
        if (i4 != 5) {
            if (this.sr.sr().c(this.sr.getContext()) && (uxVar = this.f30079c) != null && wVar != null) {
                uxVar.c(wVar, i4);
            }
        }
        sr srVar = this.f30080w;
        if (srVar != null && wVar != null) {
            srVar.c(wVar, i4);
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public synchronized w c(int i4, List<com.bytedance.sdk.component.r.c.w> list) {
        w wVar;
        try {
            for (com.bytedance.sdk.component.r.c.w wVar2 : list) {
                this.xv.remove(wVar2.xv());
            }
            this.f30079c.c(i4, list);
            try {
                wVar = this.f30080w.c(i4, list);
                com.bytedance.sdk.component.r.w.xv.xv.c("_delete", " code:" + i4);
            } catch (Exception e4) {
                wVar = new w();
                wVar.c(false);
                wVar.c("db exception:" + e4.getMessage());
                com.bytedance.sdk.component.r.w.xv.xv.sr(e4.getMessage(), this.sr);
            }
        }
        return wVar;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    @Override // com.bytedance.sdk.component.r.w.c.ux
    public synchronized List<com.bytedance.sdk.component.r.c.w> c(int i4, com.bytedance.sdk.component.r.c.w wVar, String str) {
        String str2;
        List<com.bytedance.sdk.component.r.c.w> list;
        String str3;
        boolean z3;
        List<com.bytedance.sdk.component.r.c.w> c4 = this.f30079c.c(i4, wVar, (List<String>) null);
        if (c4 != null && c4.size() != 0) {
            int size = c4.size();
            if (i4 != 1 && i4 != 2) {
                str3 = "mem";
                list = c4;
            }
            List<com.bytedance.sdk.component.r.c.w> c5 = this.f30080w.c(c4.get(0), size, i4);
            if (c5 == null || c5.size() == 0) {
                str3 = "mem_flush";
            } else {
                c5.size();
                HashMap hashMap = new HashMap();
                for (com.bytedance.sdk.component.r.c.w wVar2 : c5) {
                    hashMap.put(wVar2.xv(), wVar2);
                }
                ArrayList arrayList = new ArrayList(this.xv);
                arrayList.size();
                for (com.bytedance.sdk.component.r.c.w wVar3 : c5) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        if (TextUtils.equals(wVar3.xv(), (String) it.next())) {
                            com.bytedance.sdk.component.r.w.xv.xv.c(" duplicate delete ", this.sr);
                            z3 = true;
                            break;
                        }
                    }
                    if (z3) {
                        hashMap.remove(wVar3.xv());
                    }
                }
                for (com.bytedance.sdk.component.r.c.w wVar4 : c4) {
                    hashMap.put(wVar4.xv(), wVar4);
                }
                c4.clear();
                Set<String> keySet = hashMap.keySet();
                hashMap.size();
                for (String str4 : keySet) {
                    c4.add(hashMap.get(str4));
                }
                c5.clear();
                str3 = "mem_db_sending";
            }
            list = c4;
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.xv);
            int size2 = arrayList2.size();
            List<com.bytedance.sdk.component.r.c.w> c6 = this.f30080w.c(i4, wVar, arrayList2);
            if (c6 == null || c6.size() == 0) {
                str2 = "db";
            } else {
                c6.size();
                HashMap hashMap2 = new HashMap();
                for (com.bytedance.sdk.component.r.c.w wVar5 : c6) {
                    hashMap2.put(wVar5.xv(), wVar5);
                }
                if (size2 != 0) {
                    for (String str5 : arrayList2) {
                        if (hashMap2.get(str5) != null) {
                            hashMap2.remove(str5);
                        }
                    }
                }
                c6.clear();
                Set<String> keySet2 = hashMap2.keySet();
                hashMap2.size();
                for (String str6 : keySet2) {
                    c6.add(hashMap2.get(str6));
                }
                str2 = "db_sending";
                c6.size();
            }
            String str7 = str2;
            list = c6;
            str3 = str7;
        }
        if (list != null && !list.isEmpty()) {
            for (com.bytedance.sdk.component.r.c.w wVar6 : list) {
                com.bytedance.sdk.component.r.w.xv.c.c(wVar6, "get_ts", System.currentTimeMillis(), "get_type", str3, "mee_ori", str);
                this.xv.offer(wVar6.xv());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.r.w.c.ux
    public synchronized boolean c(int i4, boolean z3, String str, com.bytedance.sdk.component.r.c.w wVar) {
        if (this.f30079c.c(i4, z3, str, wVar)) {
            com.bytedance.sdk.component.r.w.xv.xv.xv("_opt", "cacheManager check result : memory meet " + str, this.sr);
            return true;
        } else if ((i4 == 1 || i4 == 2) && this.f30080w.c(i4, z3, str, wVar)) {
            com.bytedance.sdk.component.r.w.xv.xv.xv("_opt", "cacheManager check result : db meet " + str, this.sr);
            return true;
        } else {
            return false;
        }
    }
}
