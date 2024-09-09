package com.kwad.sdk.api.proxy;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class IFragmentActivityProxy extends IActivityProxy {
    private BaseProxyFragmentActivity mProxyFragmentActivity;

    @KsAdSdkDynamicApi
    @Keep
    public final KsFragmentManager getSupportFragmentManager() {
        return this.mProxyFragmentActivity.getSupportFragmentManager2();
    }

    public void onAttachFragment(KsFragment ksFragment) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProxyFragmentActivity(BaseProxyFragmentActivity baseProxyFragmentActivity) {
        this.mProxyFragmentActivity = baseProxyFragmentActivity;
    }
}
