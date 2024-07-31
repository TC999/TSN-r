package com.kwad.components.p208ad.reward.p249b;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.AbstractDialogFragmentC8890g;
import com.kwad.components.p208ad.reward.p249b.View$OnClickListenerC7848a;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DialogFragmentC7855b extends AbstractDialogFragmentC8890g implements View$OnClickListenerC7848a.InterfaceC7854b {
    private AdTemplate mAdTemplate;

    /* renamed from: qL */
    private int[] f26465qL;

    /* renamed from: rb */
    private View$OnClickListenerC7848a f26466rb;

    /* renamed from: rc */
    private InterfaceC7857a f26467rc;

    /* renamed from: com.kwad.components.ad.reward.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7857a {
        /* renamed from: gJ */
        void mo32146gJ();
    }

    /* renamed from: a */
    public static void m32152a(Activity activity, AdTemplate adTemplate, InterfaceC7857a interfaceC7857a, int[] iArr) {
        if (adTemplate == null || activity == null) {
            return;
        }
        String jSONObject = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", jSONObject);
        bundle.putIntArray("key_end_location", iArr);
        DialogFragmentC7855b dialogFragmentC7855b = new DialogFragmentC7855b();
        dialogFragmentC7855b.m32151a(interfaceC7857a);
        dialogFragmentC7855b.setArguments(bundle);
        dialogFragmentC7855b.show(activity.getFragmentManager(), "rewardCoupon");
    }

    @Override // com.kwad.components.p208ad.reward.p249b.View$OnClickListenerC7848a.InterfaceC7854b
    /* renamed from: gJ */
    public final void mo32150gJ() {
        dismiss();
        InterfaceC7857a interfaceC7857a = this.f26467rc;
        if (interfaceC7857a != null) {
            interfaceC7857a.mo32146gJ();
        }
    }

    @Override // com.kwad.components.p208ad.reward.p249b.View$OnClickListenerC7848a.InterfaceC7854b
    /* renamed from: gK */
    public final void mo32149gK() {
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    AdTemplate adTemplate = new AdTemplate();
                    this.mAdTemplate = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    C10331c.printStackTraceOnly(e);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.f26465qL = arguments.getIntArray("key_end_location");
            }
        }
    }

    /* renamed from: a */
    private void m32151a(InterfaceC7857a interfaceC7857a) {
        this.f26467rc = interfaceC7857a;
    }

    @Override // com.kwad.components.core.proxy.AbstractDialogFragmentC8890g
    /* renamed from: a */
    public final View mo29154a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View$OnClickListenerC7848a view$OnClickListenerC7848a = new View$OnClickListenerC7848a(layoutInflater.getContext(), viewGroup, this.f26465qL);
        this.f26466rb = view$OnClickListenerC7848a;
        view$OnClickListenerC7848a.m32169a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f26466rb.m31726b(C8074r.m31647R(this.mAdTemplate));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.b.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.f26466rb.mo31643gF();
    }
}
