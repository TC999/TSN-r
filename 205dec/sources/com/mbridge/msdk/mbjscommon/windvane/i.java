package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.mbjscommon.b.a;
import java.util.regex.Pattern;

/* compiled from: WindVaneJsBridge.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i implements Handler.Callback, b {

    /* renamed from: a  reason: collision with root package name */
    protected Pattern f40351a;

    /* renamed from: b  reason: collision with root package name */
    protected String f40352b;

    /* renamed from: d  reason: collision with root package name */
    protected Context f40354d;

    /* renamed from: e  reason: collision with root package name */
    protected WindVaneWebView f40355e;

    /* renamed from: c  reason: collision with root package name */
    protected final int f40353c = 1;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f40356f = new Handler(Looper.getMainLooper(), this);

    public i(Context context) {
        this.f40354d = context;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.b
    public final void a(WindVaneWebView windVaneWebView) {
        this.f40355e = windVaneWebView;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    @Override // com.mbridge.msdk.mbjscommon.windvane.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L7
            return
        L7:
            r0 = 2
            r1 = 0
            r2 = 1
            if (r8 != 0) goto Ld
            goto L52
        Ld:
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r3 = r7.f40355e
            com.mbridge.msdk.mbjscommon.windvane.a r3 = com.mbridge.msdk.mbjscommon.mraid.c.a(r3, r8)
            if (r3 == 0) goto L1a
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8 = r7.f40355e
            r3.f40326a = r8
            goto L53
        L1a:
            java.util.regex.Pattern r3 = r7.f40351a
            java.util.regex.Matcher r8 = r3.matcher(r8)
            boolean r3 = r8.matches()
            if (r3 == 0) goto L52
            com.mbridge.msdk.mbjscommon.windvane.a r3 = new com.mbridge.msdk.mbjscommon.windvane.a
            r3.<init>()
            int r4 = r8.groupCount()
            r5 = 5
            if (r4 < r5) goto L38
            java.lang.String r5 = r8.group(r5)
            r3.f40331f = r5
        L38:
            r5 = 3
            if (r4 < r5) goto L52
            java.lang.String r4 = r8.group(r2)
            r3.f40329d = r4
            java.lang.String r4 = r8.group(r0)
            r3.f40332g = r4
            java.lang.String r8 = r8.group(r5)
            r3.f40330e = r8
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8 = r7.f40355e
            r3.f40326a = r8
            goto L53
        L52:
            r3 = r1
        L53:
            if (r3 != 0) goto L56
            return
        L56:
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8 = r3.f40326a
            if (r8 != 0) goto L5b
            goto L61
        L5b:
            java.lang.String r1 = r3.f40329d
            java.lang.Object r1 = r8.getJsObject(r1)
        L61:
            if (r1 != 0) goto L64
            goto La9
        L64:
            android.content.Context r8 = r7.f40354d     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            java.lang.Class r4 = r1.getClass()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            com.mbridge.msdk.mbjscommon.b.a$c r8 = com.mbridge.msdk.mbjscommon.b.a.a(r8, r4)     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            java.lang.String r4 = r3.f40330e     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            r5 = 0
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r0[r5] = r6     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r0[r2] = r5     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            com.mbridge.msdk.mbjscommon.b.a$d r8 = r8.a(r4, r0)     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            r8.a()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            boolean r0 = r1 instanceof com.mbridge.msdk.mbjscommon.windvane.j     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            if (r0 == 0) goto La9
            r3.f40328c = r8     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            r3.f40327b = r1     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            android.os.Message r8 = android.os.Message.obtain()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            r8.what = r2     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            r8.obj = r3     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            android.os.Handler r0 = r7.f40356f     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            r0.sendMessage(r8)     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.b.a.b.C0749a -> La5
            goto La9
        La0:
            r8 = move-exception
            r8.printStackTrace()
            goto La9
        La5:
            r8 = move-exception
            r8.printStackTrace()
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.windvane.i.b(java.lang.String):void");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (message.what != 1) {
            return false;
        }
        Object obj = aVar.f40327b;
        a.d dVar = aVar.f40328c;
        Object[] objArr = new Object[2];
        objArr[0] = aVar;
        objArr[1] = TextUtils.isEmpty(aVar.f40331f) ? "{}" : aVar.f40331f;
        dVar.a(obj, objArr);
        return true;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.b
    public final boolean a(String str) {
        if (k.a(str)) {
            this.f40351a = k.b(str);
            this.f40352b = str;
            return true;
        }
        return false;
    }
}
