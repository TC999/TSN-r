package com.kwad.components.core.webview.tachikoma.p335c;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.AbstractDialogFragmentC8890g;
import com.kwad.components.core.webview.tachikoma.AbstractC9340k;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9870k;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.webview.tachikoma.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DialogFragmentC9274e extends AbstractDialogFragmentC8890g {

    /* renamed from: SA */
    protected StyleTemplate f29334SA;

    /* renamed from: Sy */
    public InterfaceC9291c f29335Sy;
    protected InterfaceC9870k aaA;
    protected AbstractC9340k aaB;
    public boolean aaC;
    public InterfaceC9276a aaD;
    private InterfaceC9292d aaG;
    private C9272d aaJ;
    private KSFrameLayout aaK;
    protected List<DialogInterface.OnDismissListener> aaL = new CopyOnWriteArrayList();
    public boolean aaM = false;
    protected C9267b aay;
    public AdResultData mAdResultData;
    private Presenter mPresenter;

    /* renamed from: xn */
    public String f29336xn;

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9276a {
        /* renamed from: fT */
        boolean mo29141fT();
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9277b {
        private InterfaceC9870k aaA;
        private boolean aaC;
        private boolean aaM;
        private StyleTemplate aaO;
        private AbstractC9340k aaP;
        private AdResultData mAdResultData;
        private String templateId;

        /* renamed from: a */
        public final void m29139a(StyleTemplate styleTemplate) {
            this.aaO = styleTemplate;
        }

        /* renamed from: aU */
        public final void m29138aU(String str) {
            this.templateId = str;
        }

        /* renamed from: aW */
        public final void m29137aW(boolean z) {
            this.aaC = false;
        }

        /* renamed from: aX */
        public final void m29136aX(boolean z) {
            this.aaM = true;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        /* renamed from: hk */
        public final AdResultData m29128hk() {
            return this.mAdResultData;
        }

        /* renamed from: ke */
        public final boolean m29127ke() {
            return this.aaC;
        }

        /* renamed from: sX */
        public final boolean m29126sX() {
            return this.aaM;
        }

        /* renamed from: a */
        public final void m29140a(AbstractC9340k abstractC9340k) {
            this.aaP = abstractC9340k;
        }

        /* renamed from: c */
        public final void m29134c(InterfaceC9870k interfaceC9870k) {
            this.aaA = interfaceC9870k;
        }

        /* renamed from: d */
        public final void m29132d(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }
    }

    /* renamed from: af */
    private Presenter m29151af() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        if (this.aay.aaB != null) {
            presenter.m24612a(m29143sW());
        } else {
            presenter.m24612a(mo29145jl());
        }
        return this.mPresenter;
    }

    /* renamed from: b */
    public static DialogFragmentC9274e m29149b(C9277b c9277b) {
        DialogFragmentC9274e dialogFragmentC9274e = new DialogFragmentC9274e();
        dialogFragmentC9274e.mAdResultData = c9277b.m29128hk();
        dialogFragmentC9274e.f29336xn = c9277b.getTemplateId();
        dialogFragmentC9274e.aaC = c9277b.aaC;
        dialogFragmentC9274e.aaM = c9277b.aaM;
        dialogFragmentC9274e.f29334SA = c9277b.aaO;
        dialogFragmentC9274e.aaA = c9277b.aaA;
        dialogFragmentC9274e.aaB = c9277b.aaP;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", c9277b.getTemplateId());
        dialogFragmentC9274e.setArguments(bundle);
        return dialogFragmentC9274e;
    }

    /* renamed from: sW */
    private C9272d m29143sW() {
        if (this.aaJ == null) {
            this.aaJ = new C9272d();
        }
        return this.aaJ;
    }

    /* renamed from: z */
    private void m29142z(View view) {
        if (this.aay == null) {
            this.aay = mo29146jk();
        }
        mo29144jm();
        if (this.mPresenter == null) {
            Presenter m29151af = m29151af();
            this.mPresenter = m29151af;
            m29151af.m24616G(view);
        }
        this.mPresenter.m24605k(this.aay);
    }

    /* renamed from: d */
    public final void m29148d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.aaL.add(onDismissListener);
        }
    }

    /* renamed from: e */
    public final void m29147e(DialogInterface.OnDismissListener onDismissListener) {
        this.aaL.remove(onDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: jk */
    public C9267b mo29146jk() {
        return new C9267b();
    }

    /* renamed from: jl */
    protected C9268c mo29145jl() {
        return new C9268c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: jm */
    public void mo29144jm() {
        this.aay.m29160d(this.mAdResultData);
        this.aay.mActivity = getActivity();
        C9267b c9267b = this.aay;
        c9267b.f29325YI = this;
        c9267b.aaz = this.aaK;
        c9267b.f29326xn = this.f29336xn;
        c9267b.f29323SA = this.f29334SA;
        c9267b.aaC = this.aaC;
        c9267b.aaA = this.aaA;
        c9267b.aaB = this.aaB;
        c9267b.aaD = this.aaD;
        c9267b.f29324Sy = this.f29335Sy;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (m29150b(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.c.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 0) {
                    DialogFragmentC9274e dialogFragmentC9274e = DialogFragmentC9274e.this;
                    if (dialogFragmentC9274e.aaM) {
                        return true;
                    }
                    if (dialogFragmentC9274e.aaJ != null) {
                        return DialogFragmentC9274e.this.aaJ.onBackPressed();
                    }
                    return false;
                }
                return false;
            }
        });
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29336xn = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        C9267b c9267b = this.aay;
        if (c9267b != null) {
            c9267b.release();
            this.aay = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KSFrameLayout kSFrameLayout = this.aaK;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.aaK.getParent()).removeView(this.aaK);
            this.aaK = null;
        }
        InterfaceC9292d interfaceC9292d = this.aaG;
        if (interfaceC9292d != null) {
            interfaceC9292d.mo29095fZ();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        InterfaceC9291c interfaceC9291c = this.f29335Sy;
        if (interfaceC9291c != null) {
            interfaceC9291c.mo29098fZ();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.aaL) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        InterfaceC9870k interfaceC9870k = this.aaA;
        if (interfaceC9870k != null) {
            interfaceC9870k.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m29142z(view);
        InterfaceC9291c interfaceC9291c = this.f29335Sy;
        if (interfaceC9291c != null) {
            interfaceC9291c.mo29099fR();
        }
        InterfaceC9292d interfaceC9292d = this.aaG;
        if (interfaceC9292d != null) {
            interfaceC9292d.mo29096fR();
        }
    }

    /* renamed from: a */
    public final void m29152a(InterfaceC9292d interfaceC9292d) {
        this.aaG = interfaceC9292d;
    }

    @Override // com.kwad.components.core.proxy.AbstractDialogFragmentC8890g
    /* renamed from: a */
    public final View mo29154a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.aaK == null) {
            this.aaK = (KSFrameLayout) layoutInflater.inflate(C9659R.C9663layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.aaK;
    }

    /* renamed from: b */
    private static boolean m29150b(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }
}
