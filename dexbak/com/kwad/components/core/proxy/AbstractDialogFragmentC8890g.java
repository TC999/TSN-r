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
import com.kwad.sdk.C10858m;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11124s;

/* renamed from: com.kwad.components.core.proxy.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractDialogFragmentC8890g extends DialogFragment {
    /* renamed from: a */
    private int m29670a(FragmentTransaction fragmentTransaction, String str) {
        try {
            Boolean bool = Boolean.FALSE;
            C11124s.m23707a(this, "mDismissed", bool);
            C11124s.m23707a(this, "mShownByMe", Boolean.TRUE);
            C11124s.m23707a(this, "mViewDestroyed", bool);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    /* renamed from: a */
    protected abstract View mo29154a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                super.dismissAllowingStateLoss();
            } else if (getActivity() == null) {
                super.dismissAllowingStateLoss();
            }
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public Context getContext() {
        return C10887l.wrapContextIfNeed(super.getContext());
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
        C10858m.checkInitSDK(context);
        super.onAttach(C10887l.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater m24552du = C10887l.m24552du(C10887l.wrapContextIfNeed(layoutInflater.getContext()));
        getDialog().requestWindowFeature(1);
        return mo29154a(m24552du, viewGroup);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return C10887l.m24552du(C10887l.wrapContextIfNeed(super.onGetLayoutInflater(bundle).getContext()));
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return m29670a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable unused) {
                C11124s.callMethod(this, "showAllowingStateLoss", fragmentManager, str);
            }
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            m29670a(fragmentManager.beginTransaction(), str);
        }
    }
}
