package com.kwad.sdk.api.core.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
interface IFragment {
    @KsAdSdkDynamicApi
    @Keep
    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KsAdSdkDynamicApi
    @Keep
    Activity getActivity();

    @KsAdSdkDynamicApi
    @Keep
    boolean getAllowEnterTransitionOverlap();

    @KsAdSdkDynamicApi
    @Keep
    boolean getAllowReturnTransitionOverlap();

    Bundle getArguments();

    KsFragmentManager getChildFragmentManager();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Context getContext();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Object getEnterTransition();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Object getExitTransition();

    KsFragmentManager getFragmentManager();

    Object getHost();

    int getId();

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    LayoutInflater getLayoutInflater(@Nullable Bundle bundle);

    KsLifecycle getLifecycle();

    KsFragment getParentFragment();

    @KsAdSdkDynamicApi
    @Keep
    Object getReenterTransition();

    @NonNull
    Resources getResources();

    boolean getRetainInstance();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Object getReturnTransition();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Object getSharedElementEnterTransition();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Object getSharedElementReturnTransition();

    @NonNull
    String getString(@StringRes int i4);

    @NonNull
    String getString(@StringRes int i4, Object... objArr);

    @Nullable
    String getTag();

    int getTargetRequestCode();

    @NonNull
    CharSequence getText(@StringRes int i4);

    @KsAdSdkDynamicApi
    @Keep
    boolean getUserVisibleHint();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    View getView();

    @SuppressLint({"RestrictedApi"})
    boolean hasOptionsMenu();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    @SuppressLint({"RestrictedApi"})
    boolean isMenuVisible();

    boolean isRemoving();

    boolean isResumed();

    boolean isStateSaved();

    boolean isVisible();

    LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle);

    @KsAdSdkDynamicApi
    @Keep
    void postponeEnterTransition();

    @KsAdSdkDynamicApi
    @Keep
    void registerForContextMenu(View view);

    void requestPermissions(@NonNull String[] strArr, int i4);

    @KsAdSdkDynamicApi
    @Keep
    void setAllowEnterTransitionOverlap(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setAllowReturnTransitionOverlap(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setArguments(@Nullable Bundle bundle);

    @KsAdSdkDynamicApi
    @Keep
    void setEnterTransition(@Nullable Object obj);

    @KsAdSdkDynamicApi
    @Keep
    void setExitTransition(@Nullable Object obj);

    @KsAdSdkDynamicApi
    @Keep
    void setHasOptionsMenu(boolean z3);

    void setInitialSavedState(@Nullable KsSavedState ksSavedState);

    @KsAdSdkDynamicApi
    @Keep
    void setMenuVisibility(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setReenterTransition(@Nullable Object obj);

    @KsAdSdkDynamicApi
    @Keep
    void setRetainInstance(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    void setReturnTransition(@Nullable Object obj);

    @KsAdSdkDynamicApi
    @Keep
    void setSharedElementEnterTransition(@Nullable Object obj);

    @KsAdSdkDynamicApi
    @Keep
    void setSharedElementReturnTransition(@Nullable Object obj);

    @KsAdSdkDynamicApi
    @Keep
    void setUserVisibleHint(boolean z3);

    @KsAdSdkDynamicApi
    @Keep
    boolean shouldShowRequestPermissionRationale(@NonNull String str);

    @KsAdSdkDynamicApi
    @Keep
    void startActivity(Intent intent);

    @KsAdSdkDynamicApi
    @Keep
    void startActivity(Intent intent, @Nullable Bundle bundle);

    @KsAdSdkDynamicApi
    @Keep
    void startActivityForResult(Intent intent, int i4);

    @KsAdSdkDynamicApi
    @Keep
    void startActivityForResult(Intent intent, int i4, @Nullable Bundle bundle);

    @KsAdSdkDynamicApi
    @Keep
    void startIntentSenderForResult(IntentSender intentSender, int i4, @Nullable Intent intent, int i5, int i6, int i7, Bundle bundle);

    @KsAdSdkDynamicApi
    @Keep
    void startPostponedEnterTransition();

    @KsAdSdkDynamicApi
    @Keep
    void unregisterForContextMenu(View view);
}
