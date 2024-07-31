package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.mbjscommon.p495b.Hack;
import java.util.regex.Pattern;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WindVaneJsBridge implements Handler.Callback, IJsBridge {

    /* renamed from: a */
    protected Pattern f31579a;

    /* renamed from: b */
    protected String f31580b;

    /* renamed from: d */
    protected Context f31582d;

    /* renamed from: e */
    protected WindVaneWebView f31583e;

    /* renamed from: c */
    protected final int f31581c = 1;

    /* renamed from: f */
    protected Handler f31584f = new Handler(Looper.getMainLooper(), this);

    public WindVaneJsBridge(Context context) {
        this.f31582d = context;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IJsBridge
    /* renamed from: a */
    public final void mo21381a(WindVaneWebView windVaneWebView) {
        this.f31583e = windVaneWebView;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    @Override // com.mbridge.msdk.mbjscommon.windvane.IJsBridge
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo21379b(java.lang.String r8) {
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
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r3 = r7.f31583e
            com.mbridge.msdk.mbjscommon.windvane.a r3 = com.mbridge.msdk.mbjscommon.mraid.MraidUriUtil.m21416a(r3, r8)
            if (r3 == 0) goto L1a
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8 = r7.f31583e
            r3.f31554a = r8
            goto L53
        L1a:
            java.util.regex.Pattern r3 = r7.f31579a
            java.util.regex.Matcher r8 = r3.matcher(r8)
            boolean r3 = r8.matches()
            if (r3 == 0) goto L52
            com.mbridge.msdk.mbjscommon.windvane.a r3 = new com.mbridge.msdk.mbjscommon.windvane.a
            r3.<init>()
            int r4 = r8.groupCount()
            r5 = 5
            if (r4 < r5) goto L38
            java.lang.String r5 = r8.group(r5)
            r3.f31559f = r5
        L38:
            r5 = 3
            if (r4 < r5) goto L52
            java.lang.String r4 = r8.group(r2)
            r3.f31557d = r4
            java.lang.String r4 = r8.group(r0)
            r3.f31560g = r4
            java.lang.String r8 = r8.group(r5)
            r3.f31558e = r8
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8 = r7.f31583e
            r3.f31554a = r8
            goto L53
        L52:
            r3 = r1
        L53:
            if (r3 != 0) goto L56
            return
        L56:
            com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView r8 = r3.f31554a
            if (r8 != 0) goto L5b
            goto L61
        L5b:
            java.lang.String r1 = r3.f31557d
            java.lang.Object r1 = r8.getJsObject(r1)
        L61:
            if (r1 != 0) goto L64
            goto La9
        L64:
            android.content.Context r8 = r7.f31582d     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            java.lang.Class r4 = r1.getClass()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            com.mbridge.msdk.mbjscommon.b.a$c r8 = com.mbridge.msdk.mbjscommon.p495b.Hack.m21538a(r8, r4)     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            java.lang.String r4 = r3.f31558e     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            r5 = 0
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r0[r5] = r6     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r0[r2] = r5     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            com.mbridge.msdk.mbjscommon.b.a$d r8 = r8.m21533a(r4, r0)     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            r8.m21532a()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            boolean r0 = r1 instanceof com.mbridge.msdk.mbjscommon.windvane.WindVanePlugin     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            if (r0 == 0) goto La9
            r3.f31556c = r8     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            r3.f31555b = r1     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            android.os.Message r8 = android.os.Message.obtain()     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            r8.what = r2     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            r8.obj = r3     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            android.os.Handler r0 = r7.f31584f     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
            r0.sendMessage(r8)     // Catch: java.lang.Exception -> La0 com.mbridge.msdk.mbjscommon.p495b.Hack.AbstractC11479b.C11480a -> La5
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbjscommon.windvane.WindVaneJsBridge.mo21379b(java.lang.String):void");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        CallMethodContext callMethodContext = (CallMethodContext) message.obj;
        if (callMethodContext == null) {
            return false;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (message.what != 1) {
            return false;
        }
        Object obj = callMethodContext.f31555b;
        Hack.C11482d c11482d = callMethodContext.f31556c;
        Object[] objArr = new Object[2];
        objArr[0] = callMethodContext;
        objArr[1] = TextUtils.isEmpty(callMethodContext.f31559f) ? "{}" : callMethodContext.f31559f;
        c11482d.m21531a(obj, objArr);
        return true;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IJsBridge
    /* renamed from: a */
    public final boolean mo21380a(String str) {
        if (WindVaneUtil.m21378a(str)) {
            this.f31579a = WindVaneUtil.m21377b(str);
            this.f31580b = str;
            return true;
        }
        return false;
    }
}
