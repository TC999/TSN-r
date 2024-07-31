package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.C2603as;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a;
import com.tencent.bugly.BUGLY;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewCompatDelegate implements InterfaceC2574a {

    /* renamed from: c */
    private final C2576c f8881c;

    /* renamed from: b */
    private static final AtomicInteger f8879b = new AtomicInteger(BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH);

    /* renamed from: a */
    private static final String f8878a = "generateViewId";

    /* renamed from: d */
    private static final boolean f8880d = C2603as.m50959a((Class<?>) ViewCompat.class, f8878a, (Class<?>[]) new Class[0]);

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f8881c = C2576c.m51074a(iAdInterListener, this);
    }

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (f8880d) {
            return ViewCompat.generateViewId();
        }
        if (C2624bk.m50799a((Context) null).m50800a() >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f8879b;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f8881c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f8881c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8881c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f8881c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8881c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f8881c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f8878a.equals(str2)) {
            return Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f8881c.setTarget(obj);
    }
}
