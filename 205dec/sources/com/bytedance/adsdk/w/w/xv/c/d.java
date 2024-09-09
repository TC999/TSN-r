package com.bytedance.adsdk.w.w.xv.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d extends c {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r0.c() != com.bytedance.adsdk.w.w.sr.w.METHOD) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        r0 = (com.bytedance.adsdk.w.w.w.c.l) r0;
        r1 = new java.util.LinkedList();
        r2 = new java.util.LinkedList();
        r10 = r10.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r10.hasNext() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        r3 = (r0.a) r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r3.c() != com.bytedance.adsdk.w.w.sr.sr.COMMA) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
        r1.add(com.bytedance.adsdk.w.w.ux.b.b(r2, r7, r8));
        r2.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
        r2.addLast(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        if (r2.isEmpty() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
        r1.add(com.bytedance.adsdk.w.w.ux.b.b(r2, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
        r0.d((r0.a[]) r1.toArray(new r0.a[r1.size()]));
        r8 = r8 + 1;
        r9.push(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
        r9.push(com.bytedance.adsdk.w.w.ux.b.b(r10, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
        return r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return r8;
     */
    @Override // com.bytedance.adsdk.w.w.xv.c.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(java.lang.String r7, int r8, java.util.Deque<r0.a> r9, s0.a r10) {
        /*
            r6 = this;
            char r0 = r6.a(r8, r7)
            r1 = 41
            if (r1 == r0) goto Ld
            int r7 = r10.a(r7, r8, r9)
            return r7
        Ld:
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
        L12:
            java.lang.Object r0 = r9.pollFirst()
            r0.a r0 = (r0.a) r0
            if (r0 == 0) goto L2e
            p0.a r1 = r0.c()
            com.bytedance.adsdk.w.w.sr.w r2 = com.bytedance.adsdk.w.w.sr.w.METHOD
            if (r1 == r2) goto L2e
            p0.a r1 = r0.c()
            com.bytedance.adsdk.w.w.sr.sr r2 = com.bytedance.adsdk.w.w.sr.sr.LEFT_PAREN
            if (r1 == r2) goto L2e
            r10.addFirst(r0)
            goto L12
        L2e:
            if (r0 == 0) goto L97
            p0.a r1 = r0.c()
            com.bytedance.adsdk.w.w.sr.w r2 = com.bytedance.adsdk.w.w.sr.w.METHOD
            if (r1 != r2) goto L8d
            com.bytedance.adsdk.w.w.w.c.l r0 = (com.bytedance.adsdk.w.w.w.c.l) r0
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.util.Iterator r10 = r10.iterator()
        L48:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r10.next()
            r0.a r3 = (r0.a) r3
            p0.a r4 = r3.c()
            com.bytedance.adsdk.w.w.sr.sr r5 = com.bytedance.adsdk.w.w.sr.sr.COMMA
            if (r4 != r5) goto L67
            r0.a r3 = com.bytedance.adsdk.w.w.ux.b.b(r2, r7, r8)
            r1.add(r3)
            r2.clear()
            goto L48
        L67:
            r2.addLast(r3)
            goto L48
        L6b:
            boolean r10 = r2.isEmpty()
            if (r10 != 0) goto L78
            r0.a r7 = com.bytedance.adsdk.w.w.ux.b.b(r2, r7, r8)
            r1.add(r7)
        L78:
            int r7 = r1.size()
            r0.a[] r7 = new r0.a[r7]
            java.lang.Object[] r7 = r1.toArray(r7)
            r0.a[] r7 = (r0.a[]) r7
            r0.d(r7)
            int r8 = r8 + 1
            r9.push(r0)
            goto L96
        L8d:
            r0.a r7 = com.bytedance.adsdk.w.w.ux.b.b(r10, r7, r8)
            r9.push(r7)
            int r8 = r8 + 1
        L96:
            return r8
        L97:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r10 = 0
            java.lang.String r7 = r7.substring(r10, r8)
            r9.<init>(r7)
            goto La3
        La2:
            throw r9
        La3:
            goto La2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.w.w.xv.c.d.b(java.lang.String, int, java.util.Deque, s0.a):int");
    }
}
