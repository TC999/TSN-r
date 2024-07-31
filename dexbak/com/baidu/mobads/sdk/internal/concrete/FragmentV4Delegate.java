package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.p050a.C2579e;
import com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FragmentV4Delegate extends Fragment implements InterfaceC2574a {

    /* renamed from: a */
    private C2579e f8866a;

    /* renamed from: b */
    private IAdInterListener f8867b;

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            return c2579e.getCode();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            return c2579e.getData();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public IAdInterListener getDelegator() {
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            return c2579e.getDelegator();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        C2579e c2579e = this.f8866a;
        return c2579e != null ? c2579e.getMessage() : "";
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            return c2579e.getTarget();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        C2579e c2579e = this.f8866a;
        return c2579e != null ? c2579e.getType() : "";
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51063b(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51068a(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51067a(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            return c2579e.m51066a(layoutInflater, viewGroup, bundle);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51059f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51060e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51058g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51062c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51064b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51069a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.m51061d();
        }
    }

    public FragmentV4Delegate setDispatcher(IAdInterListener iAdInterListener) {
        this.f8867b = iAdInterListener;
        return this;
    }

    public void setProxy(@NonNull C2579e c2579e) {
        this.f8866a = c2579e;
        c2579e.m51065a(this.f8867b);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        C2579e c2579e = this.f8866a;
        if (c2579e != null) {
            c2579e.setTarget(obj);
        }
    }
}
