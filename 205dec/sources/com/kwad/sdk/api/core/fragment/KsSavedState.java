package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsSavedState {
    final Fragment.SavedState mSaveState;

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }
}
