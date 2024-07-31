package com.baidu.mobads.sdk.internal.p050a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* renamed from: com.baidu.mobads.sdk.internal.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2579e implements InterfaceC2574a {

    /* renamed from: a */
    private C2576c f8520a;

    /* renamed from: a */
    public void m51065a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.f8520a = C2576c.m51074a(iAdInterListener, this);
        }
    }

    /* renamed from: b */
    public void m51063b(@Nullable Bundle bundle) {
        this.f8520a.m51072a("onActivityCreated", bundle);
    }

    /* renamed from: c */
    public void m51062c() {
        this.f8520a.m51073a("onPause");
    }

    /* renamed from: d */
    public void m51061d() {
        this.f8520a.m51073a("onStop");
    }

    /* renamed from: e */
    public void m51060e() {
        this.f8520a.m51073a("onDestroyView");
    }

    /* renamed from: f */
    public void m51059f() {
        this.f8520a.m51073a("onDestroy");
    }

    /* renamed from: g */
    public void m51058g() {
        this.f8520a.m51073a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f8520a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f8520a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8520a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f8520a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8520a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f8520a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f8520a.setTarget(obj);
    }

    /* renamed from: a */
    public void m51068a(Context context) {
        this.f8520a.m51072a("onAttach", context);
    }

    /* renamed from: b */
    public void m51064b() {
        this.f8520a.m51073a("onResume");
    }

    /* renamed from: a */
    public void m51067a(@Nullable Bundle bundle) {
        this.f8520a.m51072a("onCreate", bundle);
    }

    @Nullable
    /* renamed from: a */
    public View m51066a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        Object m51072a = this.f8520a.m51072a("onCreateView", layoutInflater, viewGroup, bundle);
        if (m51072a instanceof View) {
            return (View) m51072a;
        }
        return null;
    }

    /* renamed from: a */
    public void m51069a() {
        this.f8520a.m51073a("onStart");
    }
}
