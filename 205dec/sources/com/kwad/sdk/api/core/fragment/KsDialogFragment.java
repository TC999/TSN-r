package com.kwad.sdk.api.core.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsDialogFragment extends KsFragment implements IDialogFragmentLifecycle {
    private DelegateDialogFragment mBase;

    @KsAdSdkDynamicApi
    @Keep
    public KsDialogFragment() {
        super(null);
        ResDialogFragment resDialogFragment = new ResDialogFragment(this);
        this.mBase = resDialogFragment;
        setBase(resDialogFragment);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismiss() {
        this.mBase.dismiss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismissAllowingStateLoss() {
        this.mBase.dismissAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Dialog getDialog() {
        return this.mBase.getDialog();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean getShowsDialog() {
        return this.mBase.getShowsDialog();
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getTheme() {
        return this.mBase.getTheme();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isCancelable() {
        return this.mBase.isCancelable();
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onCancel(DialogInterface dialogInterface) {
        this.mBase.superOnCancel(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Dialog onCreateDialog(Bundle bundle) {
        return this.mBase.superOnCreateDialog(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onDismiss(DialogInterface dialogInterface) {
        this.mBase.superOnDismiss(dialogInterface);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setCancelable(boolean z3) {
        this.mBase.setCancelable(z3);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setShowsDialog(boolean z3) {
        this.mBase.setShowsDialog(z3);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setStyle(int i4, int i5) {
        this.mBase.setStyle(i4, i5);
    }

    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i4) {
        this.mBase.setupDialog(dialog, i4);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void show(KsFragmentManager ksFragmentManager, String str) {
        this.mBase.show(ksFragmentManager.getBase(), str);
    }

    @KsAdSdkDynamicApi
    @Keep
    public int show(KsFragmentTransaction ksFragmentTransaction, String str) {
        return this.mBase.show(ksFragmentTransaction.getBase(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public KsDialogFragment(DelegateDialogFragment delegateDialogFragment) {
        super(delegateDialogFragment);
        this.mBase = delegateDialogFragment;
    }
}
