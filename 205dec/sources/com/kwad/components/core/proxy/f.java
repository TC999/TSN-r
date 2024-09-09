package com.kwad.components.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.kwad.components.core.s.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class f extends IFragmentActivityProxy {
    public Context mContext;
    public View mRootView;
    private final com.kwad.components.core.proxy.a.a mPageMonitor = new com.kwad.components.core.proxy.a.a(null);
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();

    public void addBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i4) {
        T t3 = (T) this.mRootView.findViewById(i4);
        return t3 != null ? t3 : (T) super.findViewById(i4);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        l.c(intent);
        return intent;
    }

    protected abstract String getPageName();

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onBackPressed() {
        if (this.mBackPressDelete.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            if (!k.zd().ys()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            this.mContext = com.kwad.sdk.n.l.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
            this.mPageMonitor.av(getClass().getSimpleName());
            this.mPageMonitor.F(longExtra);
        } catch (Throwable th) {
            if (k.zd().yp()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                finish();
                return;
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            com.kwad.components.core.s.g.destroyActivity(getActivity(), getWindow());
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.core.proxy.a.a aVar = this.mPageMonitor;
            getActivity();
            aVar.qh();
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public void removeBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i4) {
        View inflate = com.kwad.sdk.n.l.inflate(this.mContext, i4, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }

    public void addBackPressable(com.kwad.sdk.m.a.b bVar, int i4) {
        this.mBackPressDelete.addBackPressable(bVar, i4);
    }
}
