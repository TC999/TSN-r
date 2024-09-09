package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f28619a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28620b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28621c;

    /* renamed from: d  reason: collision with root package name */
    private Method f28622d;

    public a(@NonNull Activity activity, int i4, @NonNull String str) {
        this.f28619a = activity;
        this.f28620b = str;
        this.f28621c = i4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f28622d == null) {
            try {
                Method method = this.f28619a.getClass().getMethod(this.f28620b, View.class);
                if (method != null) {
                    this.f28622d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f28620b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f28621c);
        }
        try {
            this.f28622d.invoke(this.f28619a, view);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException("Could not execute method for android:onClick", e5);
        }
    }
}
