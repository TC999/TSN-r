package com.tencent.turingfd.sdk.ams.au;

import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Method;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.for  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cfor implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Handler.Callback f52316a;

    /* renamed from: b  reason: collision with root package name */
    public final Cnew f52317b;

    /* renamed from: c  reason: collision with root package name */
    public final String f52318c;

    public Cfor(Handler.Callback callback, Cnew cnew, String str) {
        this.f52316a = callback;
        this.f52317b = cnew;
        this.f52318c = str;
    }

    public final boolean a(Message message) {
        Object a4;
        Object obj = message.obj;
        if (obj == null) {
            return false;
        }
        Object a5 = Triangulum.a(obj.getClass(), "argi3", message.obj);
        if ((a5 instanceof Integer) && (a4 = Triangulum.a(message.obj.getClass(), "arg1", message.obj)) != null) {
            Class<?> cls = a4.getClass();
            Class[] clsArr = {Boolean.TYPE, Integer.TYPE};
            Object[] objArr = {Boolean.FALSE, a5};
            try {
                Method a6 = Triangulum.a(cls, "setPerformAccessibilityActionResult", (Class<?>[]) clsArr);
                if (a6 != null) {
                    a6.invoke(a4, objArr);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x0006, B:9:0x001e, B:11:0x0026, B:13:0x002c, B:18:0x0036, B:20:0x003a, B:14:0x0030, B:8:0x0015), top: B:24:0x0001 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            r0 = 0
            int r1 = r6.what     // Catch: java.lang.Throwable -> L3f
            r2 = 1
            if (r1 != r2) goto L32
            com.tencent.turingfd.sdk.ams.au.new r1 = r5.f52317b     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = r5.f52318c     // Catch: java.lang.Throwable -> L3f
            com.tencent.turingfd.sdk.ams.au.super$do r1 = (com.tencent.turingfd.sdk.ams.au.Csuper.Cdo) r1     // Catch: java.lang.Throwable -> L3f
            java.util.concurrent.atomic.AtomicBoolean r4 = r1.f52359a     // Catch: java.lang.Throwable -> L3f
            boolean r4 = r4.get()     // Catch: java.lang.Throwable -> L3f
            if (r4 == 0) goto L15
            goto L1e
        L15:
            com.tencent.turingfd.sdk.ams.au.class r1 = r1.f52360b     // Catch: java.lang.Throwable -> L3f
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch: java.lang.Throwable -> L3f
            r1.sendToTarget()     // Catch: java.lang.Throwable -> L3f
        L1e:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tencent.turingfd.sdk.ams.au.Cvolatile.f52367a     // Catch: java.lang.Throwable -> L3f
            boolean r1 = r1.get()     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L30
            boolean r1 = r5.a(r6)     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L30
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tencent.turingfd.sdk.ams.au.Cvolatile.f52367a     // Catch: java.lang.Throwable -> L3f
            r1 = 1
            goto L33
        L30:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.tencent.turingfd.sdk.ams.au.Cvolatile.f52367a     // Catch: java.lang.Throwable -> L3f
        L32:
            r1 = 0
        L33:
            if (r1 == 0) goto L36
            return r2
        L36:
            android.os.Handler$Callback r1 = r5.f52316a     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L3f
            boolean r6 = r1.handleMessage(r6)     // Catch: java.lang.Throwable -> L3f
            return r6
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cfor.handleMessage(android.os.Message):boolean");
    }
}
