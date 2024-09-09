package com.bytedance.sdk.component.r.w.c.c.w;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w extends com.bytedance.sdk.component.r.w.c.c implements xv {
    private com.bytedance.sdk.component.r.w.sr.w.c sr;

    /* renamed from: w  reason: collision with root package name */
    private final Context f30064w;
    private com.bytedance.sdk.component.r.c.ux xv;

    /* renamed from: c  reason: collision with root package name */
    protected final List<com.bytedance.sdk.component.r.c.w> f30062c = new ArrayList();
    private boolean ux = false;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f30063f = new Runnable() { // from class: com.bytedance.sdk.component.r.w.c.c.w.w.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (w.this) {
                if (w.this.f30062c.isEmpty()) {
                    w.this.ux = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(w.this.f30062c);
                w.this.f30062c.clear();
                w.this.ux = false;
                w.this.w(arrayList);
            }
        }
    };

    public w(Context context, com.bytedance.sdk.component.r.c.ux uxVar, com.bytedance.sdk.component.r.w.sr.w.c cVar) {
        this.f30064w = context;
        this.xv = uxVar;
        this.sr = cVar;
    }

    private void w() {
        if (this.ux) {
            return;
        }
        com.bytedance.sdk.component.r.w.r.c.c().postDelayed(this.f30063f, com.bytedance.sdk.component.r.w.r.c.w());
        this.ux = true;
    }

    public abstract String c();

    public Context getContext() {
        return this.f30064w;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r1 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (r1 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int sr() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r11.getContext()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            java.lang.String r3 = r11.c()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            java.lang.String r5 = "count(1)"
            r4[r0] = r5     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            com.bytedance.sdk.component.r.c.ux r10 = r11.xv     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            android.database.Cursor r1 = com.bytedance.sdk.component.r.w.c.c.w.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            if (r1 == 0) goto L25
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L32
        L25:
            if (r1 == 0) goto L35
        L27:
            r1.close()     // Catch: java.lang.Exception -> L35
            goto L35
        L2b:
            r0 = move-exception
            if (r1 == 0) goto L31
            r1.close()     // Catch: java.lang.Exception -> L31
        L31:
            throw r0
        L32:
            if (r1 == 0) goto L35
            goto L27
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.r.w.c.c.w.w.sr():int");
    }

    public List<com.bytedance.sdk.component.r.c.w> c(int i4, int i5, com.bytedance.sdk.component.r.c.w wVar) {
        int w3;
        if (this.sr == null || wVar == null || !com.bytedance.sdk.component.r.w.xv.c.c(i4) || !c(wVar) || (w3 = this.sr.w()) <= i5) {
            return null;
        }
        return c(w3 - i5, "_id", i4);
    }

    public synchronized void w(com.bytedance.sdk.component.r.c.w wVar) {
        if (c(wVar) && wVar.r() != null && !TextUtils.isEmpty(wVar.xv())) {
            this.f30062c.add(wVar);
            w();
        }
    }

    public com.bytedance.sdk.component.r.w.c.w c(int i4, List<com.bytedance.sdk.component.r.c.w> list) {
        com.bytedance.sdk.component.r.w.c.w wVar = new com.bytedance.sdk.component.r.w.c.w();
        if (list != null && list.size() != 0 && list.get(0) != null && c(list.get(0))) {
            if (i4 != 200 && i4 != -1 && i4 != -3) {
                wVar.c("code:" + i4);
            } else {
                wVar.c(delete(list));
            }
            wVar.c(true);
            return wVar;
        }
        wVar.c(false);
        return wVar;
    }

    public void w(List<com.bytedance.sdk.component.r.c.w> list) {
        com.bytedance.sdk.component.r.w.c.c.w.insert(getContext(), c(), list, this.xv);
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public List<com.bytedance.sdk.component.r.c.w> w(int i4, com.bytedance.sdk.component.r.c.w wVar, List<String> list, String str) {
        List<com.bytedance.sdk.component.r.c.w> c4 = c("_id", i4);
        if (c(c4, list)) {
            com.bytedance.sdk.component.r.w.xv.xv.c("db " + str + " " + c() + " get size:" + c4.size(), this.xv);
            return c4;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public boolean w(int i4, String str, com.bytedance.sdk.component.r.c.w wVar) {
        if (this.sr == null) {
            return false;
        }
        int sr = sr();
        int c4 = this.sr.c();
        com.bytedance.sdk.component.r.w.xv.xv.w("check db " + c() + " count:" + sr + " MaxCacheCount:" + c4 + " message:" + com.bytedance.sdk.component.r.w.xv.c.w(i4), this.xv);
        return sr >= c4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.r.c.w> it = this.f30062c.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.r.c.w next = it.next();
                if (next != null) {
                    String xv = next.xv();
                    if (!TextUtils.isEmpty(xv) && list.contains(xv)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.c("DBInsertMemRepo", c() + "deleteMemList: " + th.getMessage(), this.xv.ux());
        }
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public boolean c(String str) {
        if (this.sr == null) {
            return false;
        }
        int sr = sr();
        com.bytedance.sdk.component.r.w.xv.xv.w("check flush db " + c() + " count:" + sr, this.xv);
        return sr >= 1;
    }

    private boolean c(List<com.bytedance.sdk.component.r.c.w> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.r.c.w> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.r.c.w next = it.next();
                    if (next != null) {
                        String xv = next.xv();
                        if (!TextUtils.isEmpty(xv) && list2.contains(xv)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.r.w.xv.xv.w("DBInsertMemRepo", "deleteMemList: " + th.getMessage(), this.xv);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}
