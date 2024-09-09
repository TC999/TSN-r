package com.bykv.vk.openvk.component.video.c.w;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f25040c = new HashSet();

    /* renamed from: w  reason: collision with root package name */
    private static final Set<String> f25041w = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private int f25042f;

    /* renamed from: r  reason: collision with root package name */
    private final int f25043r;
    private final int sr;
    private int ux = -1;
    private final ArrayList<c> xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c {

        /* renamed from: c  reason: collision with root package name */
        final String f25044c;

        /* renamed from: w  reason: collision with root package name */
        int f25045w;

        c(String str) {
            this.f25044c = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            a.f25040c.add(this.f25044c);
        }

        public String toString() {
            return this.f25044c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void w() {
            a.f25041w.add(this.f25044c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<String> list) {
        int i4;
        if (!list.isEmpty()) {
            int size = list.size();
            this.sr = size;
            this.xv = new ArrayList<>(size);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                c cVar = new c(str);
                if (f25040c.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(cVar);
                } else if (f25041w.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(cVar);
                } else {
                    this.xv.add(cVar);
                }
            }
            if (arrayList != null) {
                this.xv.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.xv.addAll(arrayList2);
            }
            Integer num = ux.gd;
            if (num != null && num.intValue() > 0) {
                i4 = num.intValue();
            } else {
                i4 = this.sr >= 2 ? 1 : 2;
            }
            this.f25043r = i4;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f25042f < this.f25043r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c w() {
        if (c()) {
            int i4 = this.ux + 1;
            if (i4 >= this.sr - 1) {
                this.ux = -1;
                this.f25042f++;
            } else {
                this.ux = i4;
            }
            c cVar = this.xv.get(i4);
            cVar.f25045w = (this.f25042f * this.sr) + this.ux;
            return cVar;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        ArrayList<c> arrayList = new ArrayList<>(1);
        this.xv = arrayList;
        arrayList.add(new c(str));
        this.sr = 1;
        this.f25043r = 1;
    }
}
