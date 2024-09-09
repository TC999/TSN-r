package com.tencent.turingfd.sdk.ams.au;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.final  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cfinal implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Window f52312c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Cnew f52313d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f52314e;

    public Cfinal(Window window, Cnew cnew, String str) {
        this.f52312c = window;
        this.f52313d = cnew;
        this.f52314e = str;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        Object obj;
        Object obj2;
        Object a4;
        try {
            View decorView = this.f52312c.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            obj = null;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                obj2 = declaredMethod.invoke(decorView, new Object[0]);
            } catch (Throwable unused) {
                obj2 = null;
            }
        } catch (Throwable unused2) {
        }
        if (obj2 == null) {
            return true;
        }
        Class<?> cls = obj2.getClass();
        HashMap<String, Class<?>> hashMap = Triangulum.f52176a;
        Method a5 = Triangulum.a(cls, "getAccessibilityInteractionController", (Class<?>[]) null);
        if (a5 != null) {
            obj = a5.invoke(obj2, null);
        }
        if (obj == null || (a4 = Triangulum.a(obj.getClass(), "mHandler", obj)) == null) {
            return true;
        }
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        Handler.Callback callback = (Handler.Callback) declaredField.get(a4);
        if (callback instanceof Cfor) {
            return true;
        }
        declaredField.set(a4, new Cfor(callback, this.f52313d, this.f52314e));
        return true;
    }
}
