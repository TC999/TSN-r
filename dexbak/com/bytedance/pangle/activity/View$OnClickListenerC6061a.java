package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.pangle.activity.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class View$OnClickListenerC6061a implements View.OnClickListener {

    /* renamed from: a */
    private final Activity f21850a;

    /* renamed from: b */
    private final String f21851b;

    /* renamed from: c */
    private final int f21852c;

    /* renamed from: d */
    private Method f21853d;

    public View$OnClickListenerC6061a(@NonNull Activity activity, int i, @NonNull String str) {
        this.f21850a = activity;
        this.f21851b = str;
        this.f21852c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f21853d == null) {
            try {
                Method method = this.f21850a.getClass().getMethod(this.f21851b, View.class);
                if (method != null) {
                    this.f21853d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f21851b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f21852c);
        }
        try {
            this.f21853d.invoke(this.f21850a, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
