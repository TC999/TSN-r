package com.jg.ids.k;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.jg.ids.IdsHelper;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a extends com.jg.ids.a {

    /* renamed from: b  reason: collision with root package name */
    private String f37852b;

    /* renamed from: c  reason: collision with root package name */
    private ContentObserver f37853c;

    /* renamed from: d  reason: collision with root package name */
    private ContentObserver f37854d;

    /* renamed from: e  reason: collision with root package name */
    private ContentObserver f37855e;

    public a(Context context, String str) {
        super(context, "vivo_thread");
        this.f37853c = null;
        this.f37854d = null;
        this.f37855e = null;
        this.f37852b = str;
        try {
            this.f37853c = new b(this, null, str, 0);
            this.f37854d = new b(this, null, str, 1);
            this.f37855e = new b(this, null, str, 2);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f37853c);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), true, this.f37854d);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), true, this.f37855e);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String a(Context context) {
        String a4 = super.a(context);
        if (TextUtils.isEmpty(a4)) {
            b(1, this.f37852b);
        }
        return a4;
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String b(Context context) {
        String str;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query == null) {
                return "";
            }
            if (!query.moveToNext()) {
                str = "";
            } else {
                str = query.getString(query.getColumnIndex("value"));
            }
            try {
                query.close();
                return str;
            } catch (Throwable th) {
                return str;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String c(Context context) {
        String c4 = super.c(context);
        if (TextUtils.isEmpty(c4)) {
            b(2, this.f37852b);
        }
        return c4;
    }

    @Override // com.jg.ids.a
    protected final void b() {
        b(1, this.f37852b);
        b(2, this.f37852b);
        b(0, this.f37852b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.a
    public final void a(Message message) {
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i4 = message.getData().getInt("type", -1);
                    a(i4, a(IdsHelper.CONTEXT, i4, message.getData().getString("appid", "")));
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4, String str) {
        try {
            Message a4 = a();
            a4.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i4);
            bundle.putString("appid", str);
            a4.setData(bundle);
            b(a4);
        } catch (Throwable th) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String a(android.content.Context r8, int r9, java.lang.String r10) {
        /*
            r7 = 0
            java.lang.String r6 = ""
            switch(r9) {
                case 0: goto Lc;
                case 1: goto L13;
                case 2: goto L27;
                default: goto L6;
            }
        L6:
            r1 = r7
        L7:
            if (r1 != 0) goto L3b
            java.lang.String r0 = ""
        Lb:
            return r0
        Lc:
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60
            goto L7
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60
            goto L7
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60
            goto L7
        L3b:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L60
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L78
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L78
            java.lang.String r0 = "value"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L73
            r0 = r6
        L5a:
            if (r1 == 0) goto Lb
            r1.close()
            goto Lb
        L60:
            r0 = move-exception
            r0 = r7
        L62:
            if (r0 == 0) goto L76
            r0.close()
            r0 = r6
            goto Lb
        L69:
            r0 = move-exception
        L6a:
            if (r7 == 0) goto L6f
            r7.close()
        L6f:
            throw r0
        L70:
            r0 = move-exception
            r7 = r1
            goto L6a
        L73:
            r0 = move-exception
            r0 = r1
            goto L62
        L76:
            r0 = r6
            goto Lb
        L78:
            r0 = r6
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jg.ids.k.a.a(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
