package com.kwad.components.core.proxy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.m;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class g extends DialogFragment {
    private int a(FragmentTransaction fragmentTransaction, String str) {
        try {
            Boolean bool = Boolean.FALSE;
            s.a(this, "mDismissed", bool);
            s.a(this, "mShownByMe", Boolean.TRUE);
            s.a(this, "mViewDestroyed", bool);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    protected abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                super.dismissAllowingStateLoss();
            } else if (getActivity() == null) {
                super.dismissAllowingStateLoss();
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public Context getContext() {
        return l.wrapContextIfNeed(super.getContext());
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        m.checkInitSDK(context);
        super.onAttach(l.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater du = l.du(l.wrapContextIfNeed(layoutInflater.getContext()));
        getDialog().requestWindowFeature(1);
        return a(du, viewGroup);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return l.du(l.wrapContextIfNeed(super.onGetLayoutInflater(bundle).getContext()));
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable unused) {
                s.callMethod(this, "showAllowingStateLoss", fragmentManager, str);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            a(fragmentManager.beginTransaction(), str);
        }
    }
}
