package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bn;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ViewCompatDelegate implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12679a = "generateViewId";

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicInteger f12680b = new AtomicInteger(100000);

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f12681d = av.a((Class<?>) ViewCompat.class, "generateViewId", (Class<?>[]) new Class[0]);

    /* renamed from: c  reason: collision with root package name */
    private final c f12682c;

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f12682c = c.a(iAdInterListener, this);
    }

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i4;
        int i5;
        if (f12681d) {
            return ViewCompat.generateViewId();
        }
        if (bn.a((Context) null).a() >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f12680b;
            i4 = atomicInteger.get();
            i5 = i4 + 1;
            if (i5 > 16777215) {
                i5 = 1;
            }
        } while (!atomicInteger.compareAndSet(i4, i5));
        return i4;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f12682c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f12682c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12682c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f12682c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12682c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f12682c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("generateViewId".equals(str2)) {
            return Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f12682c.setTarget(obj);
    }
}
