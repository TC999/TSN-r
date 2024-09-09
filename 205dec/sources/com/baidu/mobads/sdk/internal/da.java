package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import com.baidu.mobads.sdk.api.CPUComponent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class da extends com.baidu.mobads.sdk.internal.a.e implements CPUComponent {

    /* renamed from: a  reason: collision with root package name */
    private final db f12736a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f12737b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.fragment.app.Fragment f12738c;

    public da(db dbVar) {
        this.f12736a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void destroy() {
        db dbVar = this.f12736a;
        if (dbVar != null) {
            dbVar.e();
        }
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public Fragment getFragment() {
        Fragment fragment = this.f12737b;
        if (fragment != null) {
            if (fragment instanceof FragmentDelegate) {
                ((FragmentDelegate) fragment).setProxy(this);
            }
            return this.f12737b;
        }
        db dbVar = this.f12736a;
        if (dbVar != null) {
            Fragment a4 = dbVar.a((com.baidu.mobads.sdk.internal.a.e) this);
            this.f12737b = a4;
            return a4;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public androidx.fragment.app.Fragment getSupportFragment() {
        androidx.fragment.app.Fragment fragment = this.f12738c;
        if (fragment != null) {
            if (fragment instanceof FragmentV4Delegate) {
                ((FragmentV4Delegate) fragment).setProxy(this);
            }
            return this.f12738c;
        }
        db dbVar = this.f12736a;
        if (dbVar != null) {
            androidx.fragment.app.Fragment b4 = dbVar.b((com.baidu.mobads.sdk.internal.a.e) this);
            this.f12738c = b4;
            return b4;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.CPUComponent
    public void refresh() {
        db dbVar = this.f12736a;
        if (dbVar != null) {
            dbVar.f();
        }
    }
}
