package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f12316a;

    public void a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.f12316a = c.a(iAdInterListener, this);
        }
    }

    public void b(@Nullable Bundle bundle) {
        this.f12316a.a("onActivityCreated", bundle);
    }

    public void c() {
        this.f12316a.a("onPause");
    }

    public void d() {
        this.f12316a.a("onStop");
    }

    public void e() {
        this.f12316a.a("onDestroyView");
    }

    public void f() {
        this.f12316a.a("onDestroy");
    }

    public void g() {
        this.f12316a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f12316a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f12316a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12316a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f12316a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12316a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f12316a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f12316a.setTarget(obj);
    }

    public void a(Context context) {
        this.f12316a.a("onAttach", context);
    }

    public void b() {
        this.f12316a.a("onResume");
    }

    public void a(@Nullable Bundle bundle) {
        this.f12316a.a("onCreate", bundle);
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        Object a4 = this.f12316a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (a4 instanceof View) {
            return (View) a4;
        }
        return null;
    }

    public void a() {
        this.f12316a.a("onStart");
    }
}
