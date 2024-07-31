package com.kwad.components.core.p289e.p294e;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.proxy.AbstractDialogFragmentC8890g;
import com.kwad.sdk.core.adlog.C9908c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.e.e.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogFragmentC8639e extends AbstractDialogFragmentC8890g {

    /* renamed from: Lp */
    private C8615a.C8616a f28283Lp;
    private Activity mActivity;

    /* renamed from: a */
    public static void m30093a(Activity activity, C8615a.C8616a c8616a) {
        DialogFragmentC8639e dialogFragmentC8639e = new DialogFragmentC8639e();
        dialogFragmentC8639e.f28283Lp = c8616a;
        dialogFragmentC8639e.mActivity = activity;
        dialogFragmentC8639e.show(activity.getFragmentManager(), "second_confirm_dialog");
    }

    @Override // android.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        C8642g.m30090or().m30089os();
        C9908c.m27337b(this.f28283Lp.getAdTemplate(), 229, (JSONObject) null);
        return super.onCreateDialog(bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        C8642g.m30090or().m30088ot();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.kwad.components.core.proxy.AbstractDialogFragmentC8890g
    /* renamed from: a */
    public final View mo29154a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.e.e.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        return new C8635a(this.mActivity, this, this.f28283Lp);
    }
}
