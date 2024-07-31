package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import com.baidu.mobads.sdk.api.CPUComponent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.p050a.C2579e;

/* renamed from: com.baidu.mobads.sdk.internal.cx */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2679cx extends C2579e implements CPUComponent {

    /* renamed from: a */
    private final C2680cy f8916a;

    /* renamed from: b */
    private Fragment f8917b;

    /* renamed from: c */
    private androidx.fragment.app.Fragment f8918c;

    public C2679cx(C2680cy c2680cy) {
        this.f8916a = c2680cy;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void destroy() {
        C2680cy c2680cy = this.f8916a;
        if (c2680cy != null) {
            c2680cy.m50810e();
        }
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public Fragment getFragment() {
        Fragment fragment = this.f8917b;
        if (fragment != null) {
            if (fragment instanceof FragmentDelegate) {
                ((FragmentDelegate) fragment).setProxy(this);
            }
            return this.f8917b;
        }
        C2680cy c2680cy = this.f8916a;
        if (c2680cy != null) {
            Fragment m50576a = c2680cy.m50576a((C2579e) this);
            this.f8917b = m50576a;
            return m50576a;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public androidx.fragment.app.Fragment getSupportFragment() {
        androidx.fragment.app.Fragment fragment = this.f8918c;
        if (fragment != null) {
            if (fragment instanceof FragmentV4Delegate) {
                ((FragmentV4Delegate) fragment).setProxy(this);
            }
            return this.f8918c;
        }
        C2680cy c2680cy = this.f8916a;
        if (c2680cy != null) {
            androidx.fragment.app.Fragment m50573b = c2680cy.m50573b((C2579e) this);
            this.f8918c = m50573b;
            return m50573b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void refresh() {
        C2680cy c2680cy = this.f8916a;
        if (c2680cy != null) {
            c2680cy.m50571f();
        }
    }
}
