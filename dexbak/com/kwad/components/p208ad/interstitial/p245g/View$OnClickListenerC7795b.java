package com.kwad.components.p208ad.interstitial.p245g;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.proxy.AbstractDialogFragmentC8890g;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.g.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7795b extends AbstractDialogFragmentC8890g implements View.OnClickListener {

    /* renamed from: lA */
    private static boolean f26301lA;

    /* renamed from: hz */
    private TextView f26302hz;

    /* renamed from: jK */
    private C7761c f26303jK;

    /* renamed from: lv */
    private KSCornerImageView f26304lv;

    /* renamed from: lw */
    private TextView f26305lw;

    /* renamed from: lx */
    private TextView f26306lx;

    /* renamed from: ly */
    private TextView f26307ly;

    /* renamed from: lz */
    private TextView f26308lz;
    private AdTemplate mAdTemplate;

    /* renamed from: e */
    public static void m32365e(C7761c c7761c) {
        if (f26301lA) {
            return;
        }
        f26301lA = true;
        View$OnClickListenerC7795b view$OnClickListenerC7795b = new View$OnClickListenerC7795b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", c7761c.mAdTemplate.toJson().toString());
        view$OnClickListenerC7795b.setArguments(bundle);
        view$OnClickListenerC7795b.m32364f(c7761c);
        view$OnClickListenerC7795b.show(c7761c.f26202io.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    /* renamed from: f */
    private void m32364f(C7761c c7761c) {
        this.f26303jK = c7761c;
    }

    /* renamed from: i */
    private void m32363i(View view) {
        this.f26304lv = (KSCornerImageView) view.findViewById(C9659R.C9662id.ksad_interstitial_intercept_app_icon);
        this.f26302hz = (TextView) view.findViewById(C9659R.C9662id.ksad_interstitial_intercept_app_title);
        this.f26305lw = (TextView) view.findViewById(C9659R.C9662id.ksad_interstitial_intercept_dialog_desc);
        this.f26306lx = (TextView) view.findViewById(C9659R.C9662id.ksad_interstitial_intercept_dialog_detail);
        this.f26307ly = (TextView) view.findViewById(C9659R.C9662id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(C9659R.C9662id.ksad_interstitial_intercept_dialog_btn_deny);
        this.f26308lz = textView;
        C10751a.m24923a(this, this.f26304lv, this.f26302hz, this.f26305lw, this.f26306lx, this.f26307ly, textView);
    }

    private void initData() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.f26304lv, C10483a.m25820cf(m25641dQ), this.mAdTemplate, 12);
        this.f26302hz.setText(C10483a.m25823cc(m25641dQ));
        this.f26305lw.setText(C10483a.m25915au(m25641dQ));
        if (C10483a.m25824cb(this.mAdTemplate)) {
            this.f26306lx.setText(C10483a.m25957aE(m25641dQ));
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractDialogFragmentC8890g
    /* renamed from: a */
    public final View mo29154a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View inflate = layoutInflater.inflate(C9659R.C9663layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        m32363i(inflate);
        initData();
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        C7761c c7761c = this.f26303jK;
        if (c7761c != null) {
            C9908c.m27309d(c7761c.mAdTemplate, new JSONObject(), new C9913b().m27264cM(149).m27259cR(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f26303jK != null) {
            if (view.equals(this.f26304lv)) {
                C7761c c7761c = this.f26303jK;
                c7761c.m32465a(c7761c.f26202io.getContext(), 127, 2, 9);
            } else if (view.equals(this.f26302hz)) {
                C7761c c7761c2 = this.f26303jK;
                c7761c2.m32465a(c7761c2.f26202io.getContext(), 128, 2, 9);
            } else if (view.equals(this.f26305lw)) {
                C7761c c7761c3 = this.f26303jK;
                c7761c3.m32465a(c7761c3.f26202io.getContext(), TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 2, 9);
            } else if (view.equals(this.f26306lx)) {
                C7761c c7761c4 = this.f26303jK;
                c7761c4.m32465a(c7761c4.f26202io.getContext(), 131, 2, 9);
            } else if (view.equals(this.f26307ly)) {
                C9908c.m27313c(this.f26303jK.mAdTemplate, (JSONObject) null, new C9913b().m27259cR(9));
            } else if (view.equals(this.f26308lz)) {
                C7761c c7761c5 = this.f26303jK;
                c7761c5.m32457a(false, -1, c7761c5.f26198eN);
                this.f26303jK.f26202io.dismiss();
                C9908c.m27306e(this.f26303jK.mAdTemplate, (JSONObject) null, new C9913b().m27264cM(151).m27259cR(9));
            }
        }
        dismiss();
        f26301lA = false;
    }
}
