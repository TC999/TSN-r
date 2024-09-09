package com.jg.ids.meizu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;

/* loaded from: E:\TSN-r\205dec\93344.dex */
final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f37864b = new a();

    /* renamed from: a  reason: collision with root package name */
    private BroadcastReceiver f37865a = null;

    /* renamed from: c  reason: collision with root package name */
    private b f37866c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a() {
        return f37864b;
    }

    private a() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final boolean a(android.content.Context r10) {
        /*
            r9 = this;
            r7 = 0
            r6 = 0
            android.content.pm.PackageManager r0 = r10.getPackageManager()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r1 = "com.meizu.flyme.openidsdk"
            r2 = 0
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r1, r2)     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L11
            r0 = r6
        L10:
            return r0
        L11:
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L4a
            android.content.ContentResolver r0 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L4a
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4a
            r5 = 0
            java.lang.String r8 = "supported"
            r4[r5] = r8     // Catch: java.lang.Throwable -> L4a
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L43
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L5c
            com.jg.ids.meizu.d r0 = a(r1)     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L43
            java.lang.String r2 = "0"
            java.lang.String r0 = r0.f37867a     // Catch: java.lang.Throwable -> L5c
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L10
            r1.close()
            goto L10
        L43:
            if (r1 == 0) goto L48
            r1.close()
        L48:
            r0 = r6
            goto L10
        L4a:
            r0 = move-exception
            r0 = r7
        L4c:
            if (r0 == 0) goto L48
            r0.close()
            goto L48
        L52:
            r0 = move-exception
        L53:
            if (r7 == 0) goto L58
            r7.close()
        L58:
            throw r0
        L59:
            r0 = move-exception
            r7 = r1
            goto L53
        L5c:
            r0 = move-exception
            r0 = r1
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jg.ids.meizu.a.a(android.content.Context):boolean");
    }

    private static d a(Cursor cursor) {
        d dVar = null;
        d dVar2 = new d(null, 0);
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        dVar2.f37867a = cursor.getString(columnIndex);
                    }
                    int columnIndex2 = cursor.getColumnIndex("code");
                    if (columnIndex2 >= 0) {
                        dVar2.f37868b = cursor.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursor.getColumnIndex("expired");
                    if (columnIndex3 >= 0) {
                        dVar2.f37869c = cursor.getLong(columnIndex3);
                        return dVar2;
                    }
                }
            } catch (Throwable th) {
            }
        }
        dVar = dVar2;
        return dVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final java.lang.String b(android.content.Context r10) {
        /*
            r9 = this;
            r7 = 0
            java.lang.String r6 = ""
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r0)
            android.content.ContentResolver r0 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L3c
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L3c
            r5 = 0
            java.lang.String r8 = "aaid"
            r4[r5] = r8     // Catch: java.lang.Throwable -> L3c
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L35
            com.jg.ids.meizu.d r0 = a(r1)     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L35
            int r2 = r0.f37868b     // Catch: java.lang.Throwable -> L4e
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L2d
            r9.e(r10)     // Catch: java.lang.Throwable -> L4e
        L2d:
            java.lang.String r0 = r0.f37867a     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L34
            r1.close()
        L34:
            return r0
        L35:
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            r0 = r6
            goto L34
        L3c:
            r0 = move-exception
            r0 = r7
        L3e:
            if (r0 == 0) goto L3a
            r0.close()
            goto L3a
        L44:
            r0 = move-exception
        L45:
            if (r7 == 0) goto L4a
            r7.close()
        L4a:
            throw r0
        L4b:
            r0 = move-exception
            r7 = r1
            goto L45
        L4e:
            r0 = move-exception
            r0 = r1
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jg.ids.meizu.a.b(android.content.Context):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final java.lang.String c(android.content.Context r9) {
        /*
            r8 = this;
            r6 = 0
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r0)
            android.content.ContentResolver r0 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L3b
            r5 = 0
            java.lang.String r7 = "oaid"
            r4[r5] = r7     // Catch: java.lang.Throwable -> L3b
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L33
            com.jg.ids.meizu.d r0 = a(r1)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L33
            int r2 = r0.f37868b     // Catch: java.lang.Throwable -> L4d
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L2b
            r8.e(r9)     // Catch: java.lang.Throwable -> L4d
        L2b:
            java.lang.String r0 = r0.f37867a     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L32
            r1.close()
        L32:
            return r0
        L33:
            if (r1 == 0) goto L38
            r1.close()
        L38:
            java.lang.String r0 = ""
            goto L32
        L3b:
            r0 = move-exception
            r0 = r6
        L3d:
            if (r0 == 0) goto L38
            r0.close()
            goto L38
        L43:
            r0 = move-exception
        L44:
            if (r6 == 0) goto L49
            r6.close()
        L49:
            throw r0
        L4a:
            r0 = move-exception
            r6 = r1
            goto L44
        L4d:
            r0 = move-exception
            r0 = r1
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jg.ids.meizu.a.c(android.content.Context):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final java.lang.String d(android.content.Context r9) {
        /*
            r8 = this;
            r6 = 0
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r0)
            android.content.ContentResolver r0 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L3b
            r5 = 0
            java.lang.String r7 = "vaid"
            r4[r5] = r7     // Catch: java.lang.Throwable -> L3b
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L33
            com.jg.ids.meizu.d r0 = a(r1)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L33
            int r2 = r0.f37868b     // Catch: java.lang.Throwable -> L4d
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L2b
            r8.e(r9)     // Catch: java.lang.Throwable -> L4d
        L2b:
            java.lang.String r0 = r0.f37867a     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L32
            r1.close()
        L32:
            return r0
        L33:
            if (r1 == 0) goto L38
            r1.close()
        L38:
            java.lang.String r0 = ""
            goto L32
        L3b:
            r0 = move-exception
            r0 = r6
        L3d:
            if (r0 == 0) goto L38
            r0.close()
            goto L38
        L43:
            r0 = move-exception
        L44:
            if (r6 == 0) goto L49
            r6.close()
        L49:
            throw r0
        L4a:
            r0 = move-exception
            r6 = r1
            goto L44
        L4d:
            r0 = move-exception
            r0 = r1
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jg.ids.meizu.a.d(android.content.Context):java.lang.String");
    }

    public final void a(b bVar) {
        this.f37866c = bVar;
    }

    public final void a(int i4) {
        if (this.f37866c != null) {
            this.f37866c.a(i4);
        }
    }

    private synchronized void e(Context context) {
        try {
            if (this.f37865a == null) {
                this.f37865a = new MeiZuReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                context.registerReceiver(this.f37865a, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        } catch (Throwable th) {
        }
    }
}
