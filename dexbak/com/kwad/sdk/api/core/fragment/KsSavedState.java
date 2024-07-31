package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsSavedState {
    final Fragment.SavedState mSaveState;

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }
}
