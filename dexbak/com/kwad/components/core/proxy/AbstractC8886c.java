package com.kwad.components.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p330s.C8939d;
import com.kwad.components.core.p330s.C8949l;
import com.kwad.components.core.proxy.p325a.C8881a;
import com.kwad.components.core.proxy.p325a.InterfaceC8884c;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.p443m.p444a.C10860a;
import com.kwad.sdk.p443m.p444a.InterfaceC10861b;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.proxy.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8886c extends IActivityProxy implements InterfaceC8884c {
    private static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public Context mContext;
    private boolean mHasCallFinish;
    public View mRootView;
    private final C8881a mPageMonitor = new C8881a(this);
    private final C10860a mBackPressDelete = new C10860a();

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle == null || !C10829k.m24699zd().m24703yp()) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    public void addBackPressable(InterfaceC10861b interfaceC10861b) {
        this.mBackPressDelete.addBackPressable(interfaceC10861b);
    }

    protected boolean checkIntentData(@Nullable Intent intent) {
        return true;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i) {
        T t = (T) this.mRootView.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void finish() {
        if (this.mHasCallFinish) {
            return;
        }
        this.mHasCallFinish = true;
        super.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public Intent getIntent() {
        Intent intent = super.getIntent();
        C8949l.m29542c(intent);
        return intent;
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract String getPageName();

    protected abstract void initData();

    protected abstract void initView();

    protected boolean needAdaptionScreen() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void onActivityCreate() {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onBackPressed() {
        if (this.mBackPressDelete.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        try {
        } catch (Throwable th) {
            onCreateCaughtException(th);
            this.mPageMonitor.m29679a(PageCreateStage.ERROR_CAUGHT_EXCEPTION);
            if (C10829k.m24699zd().m24703yp()) {
                C8571a.reportSdkCaughtException(th);
                finish();
            } else {
                throw th;
            }
        }
        if (!C10829k.m24699zd().m24700ys()) {
            this.mPageMonitor.m29679a(PageCreateStage.ERROR_SDK_NOT_INIT);
            finish();
            return;
        }
        this.mPageMonitor.m29679a(PageCreateStage.START_ON_CREATE);
        super.onCreate(bundle);
        getActivity().setTheme(16973838);
        this.mContext = C10887l.wrapContextIfNeed(getActivity());
        Intent intent = getIntent();
        this.mPageMonitor.m29679a(PageCreateStage.START_CHECK_INTENT);
        if (!checkIntentData(intent)) {
            this.mPageMonitor.m29679a(PageCreateStage.ERROR_CHECK_INTENT);
            finish();
            return;
        }
        getWindow().setFlags(16777216, 16777216);
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.m29677av(getPageName());
        this.mPageMonitor.m29680F(longExtra);
        int layoutId = getLayoutId();
        this.mPageMonitor.m29679a(PageCreateStage.START_SET_CONTENT_VIEW);
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        this.mPageMonitor.m29679a(PageCreateStage.START_INIT_DATA);
        initData();
        this.mPageMonitor.m29679a(PageCreateStage.START_INIT_VIEW);
        initView();
        this.mPageMonitor.m29679a(PageCreateStage.END_INIT_VIEW);
        C8891h.m29662qg().m29669a(this, bundle);
        onActivityCreate();
        this.mPageMonitor.m29679a(PageCreateStage.END_ON_CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreateCaughtException(Throwable th) {
    }

    public void onCreateStageChange(PageCreateStage pageCreateStage) {
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            C8891h.m29662qg().m29663g(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            C8891h.m29662qg().m29664f(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPreCreate(@Nullable Bundle bundle) {
        try {
            this.mPageMonitor.m29679a(PageCreateStage.START_ON_PRE_CREATE);
            super.onPreCreate(bundle);
            if (!C10829k.m24699zd().m24703yp() && needAdaptionScreen() && Build.VERSION.SDK_INT <= 27) {
                C8939d.m29563a(getActivity(), 0, true, false);
            }
            disableFragmentRestore(bundle);
            this.mPageMonitor.m29679a(PageCreateStage.END_ON_PRE_CREATE);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            C8881a c8881a = this.mPageMonitor;
            getActivity();
            c8881a.m29676qh();
            C8891h.m29662qg().m29665e(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        disableFragmentRestore(bundle);
    }

    public void removeBackPressable(InterfaceC10861b interfaceC10861b) {
        this.mBackPressDelete.removeBackPressable(interfaceC10861b);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void setContentView(int i) {
        View inflate = C10887l.inflate(this.mContext, i, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }

    public void addBackPressable(InterfaceC10861b interfaceC10861b, int i) {
        this.mBackPressDelete.addBackPressable(interfaceC10861b, i);
    }
}
