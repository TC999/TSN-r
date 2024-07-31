package com.kwad.components.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p330s.C8942g;
import com.kwad.components.core.p330s.C8949l;
import com.kwad.components.core.proxy.p325a.C8881a;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.p443m.p444a.C10860a;
import com.kwad.sdk.p443m.p444a.InterfaceC10861b;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.core.proxy.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8889f extends IFragmentActivityProxy {
    public Context mContext;
    public View mRootView;
    private final C8881a mPageMonitor = new C8881a(null);
    private final C10860a mBackPressDelete = new C10860a();

    public void addBackPressable(InterfaceC10861b interfaceC10861b) {
        this.mBackPressDelete.addBackPressable(interfaceC10861b);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i) {
        T t = (T) this.mRootView.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        C8949l.m29542c(intent);
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
            if (!C10829k.m24699zd().m24700ys()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            getActivity().setTheme(C9659R.C9665style.Theme_AppCompat_Light_NoActionBar);
            this.mContext = C10887l.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
            this.mPageMonitor.m29677av(getClass().getSimpleName());
            this.mPageMonitor.m29680F(longExtra);
        } catch (Throwable th) {
            if (C10829k.m24699zd().m24703yp()) {
                C8571a.reportSdkCaughtException(th);
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
            C8942g.destroyActivity(getActivity(), getWindow());
        } catch (Throwable th) {
            C8571a.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            C8881a c8881a = this.mPageMonitor;
            getActivity();
            c8881a.m29676qh();
        } catch (Throwable th) {
            C8571a.reportSdkCaughtException(th);
        }
    }

    public void removeBackPressable(InterfaceC10861b interfaceC10861b) {
        this.mBackPressDelete.removeBackPressable(interfaceC10861b);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i) {
        View inflate = C10887l.inflate(this.mContext, i, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }

    public void addBackPressable(InterfaceC10861b interfaceC10861b, int i) {
        this.mBackPressDelete.addBackPressable(interfaceC10861b, i);
    }
}
