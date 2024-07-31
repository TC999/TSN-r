package com.kwad.components.p208ad.reward.p264n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.model.C8026a;
import com.kwad.components.p208ad.widget.KsAppTagsView;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.reward.n.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class View$OnClickListenerC8050h extends AbstractC8075s implements View.OnClickListener {
    @Nullable
    protected KsLogoView mLogoView;

    /* renamed from: yA */
    protected TextView f26807yA;
    @Nullable

    /* renamed from: yB */
    protected TextView f26808yB;
    @Nullable

    /* renamed from: yC */
    protected TextView f26809yC;

    /* renamed from: yD */
    protected InterfaceC8051a f26810yD;
    @LayoutRes

    /* renamed from: yE */
    protected int f26811yE = C9659R.C9663layout.ksad_reward_apk_info_card_tag_item;

    /* renamed from: yF */
    protected boolean f26812yF = true;

    /* renamed from: ye */
    protected ImageView f26813ye;
    @Nullable

    /* renamed from: yi */
    protected KsAppTagsView f26814yi;

    /* renamed from: yz */
    protected KsConvertButton f26815yz;

    /* renamed from: com.kwad.components.ad.reward.n.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8051a {
        /* renamed from: hZ */
        void mo31147hZ();

        /* renamed from: ia */
        void mo31146ia();

        /* renamed from: ib */
        void mo31145ib();

        /* renamed from: ic */
        void mo31144ic();

        /* renamed from: id */
        void mo31143id();

        /* renamed from: ie */
        void mo31142ie();
    }

    /* renamed from: S */
    private void m31710S(int i) {
        KsConvertButton ksConvertButton = this.f26815yz;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().m23531cf(false).m23528ci(false).m23529ch(true).m23530cg(true);
        }
        this.f26815yz.postInvalidate();
    }

    /* renamed from: g */
    private void m31706g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_logo);
        this.f26813ye = (ImageView) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_icon);
        this.f26807yA = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_name);
        this.f26814yi = (KsAppTagsView) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_tags);
        this.f26808yB = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_desc);
        this.f26809yC = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_desc2);
        this.f26815yz = (KsConvertButton) viewGroup.findViewById(C9659R.C9662id.ksad_common_app_action);
    }

    /* renamed from: jU */
    private static int m31705jU() {
        return C9659R.C9662id.ksad_common_app_card_root;
    }

    /* renamed from: a */
    public final void m31708a(InterfaceC8051a interfaceC8051a) {
        this.f26810yD = interfaceC8051a;
    }

    /* renamed from: f */
    public final void m31707f(ViewGroup viewGroup) {
        super.m31644a(viewGroup, mo31148hY(), m31705jU());
        m31706g(this.f26932sz);
        ViewGroup viewGroup2 = this.f26932sz;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.f26815yz.setOnClickListener(this);
            this.f26813ye.setOnClickListener(this);
            this.f26807yA.setOnClickListener(this);
            TextView textView = this.f26808yB;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.f26809yC;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.f26814yi;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: hY */
    public int mo31148hY() {
        return C9659R.C9662id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC8051a interfaceC8051a;
        if (view.equals(this.f26815yz)) {
            InterfaceC8051a interfaceC8051a2 = this.f26810yD;
            if (interfaceC8051a2 != null) {
                interfaceC8051a2.mo31147hZ();
            }
        } else if (view.equals(this.f26813ye)) {
            InterfaceC8051a interfaceC8051a3 = this.f26810yD;
            if (interfaceC8051a3 != null) {
                interfaceC8051a3.mo31146ia();
            }
        } else if (view.equals(this.f26807yA)) {
            InterfaceC8051a interfaceC8051a4 = this.f26810yD;
            if (interfaceC8051a4 != null) {
                interfaceC8051a4.mo31145ib();
            }
        } else if (!view.equals(this.f26808yB) && !view.equals(this.f26809yC)) {
            if (view.equals(this.f26814yi)) {
                InterfaceC8051a interfaceC8051a5 = this.f26810yD;
                if (interfaceC8051a5 != null) {
                    interfaceC8051a5.mo31143id();
                }
            } else if (!view.equals(this.f26932sz) || (interfaceC8051a = this.f26810yD) == null) {
            } else {
                interfaceC8051a.mo31142ie();
            }
        } else {
            InterfaceC8051a interfaceC8051a6 = this.f26810yD;
            if (interfaceC8051a6 != null) {
                interfaceC8051a6.mo31144ic();
            }
        }
    }

    public final void show() {
        ViewGroup viewGroup = this.f26932sz;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        m31709a(C8026a.m31814a(c8074r, this.f26812yF));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m31709a(com.kwad.components.p208ad.reward.model.C8026a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.m31805hc()
            r5.m31710S(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.m31811gY()
            r0.m28912aD(r1)
        L15:
            android.widget.TextView r0 = r5.f26807yA
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.f26808yB
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.m31808gg()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.f26809yC
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L5c
            java.lang.String r3 = r6.m31808gg()
            r0.setText(r3)
            java.lang.String r0 = r6.m31808gg()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L46
            r0 = 8
        L43:
            r3 = 8
            goto L52
        L46:
            boolean r0 = r6.m31806hb()
            if (r0 == 0) goto L50
            r0 = 8
            r3 = 0
            goto L52
        L50:
            r0 = 0
            goto L43
        L52:
            android.widget.TextView r4 = r5.f26808yB
            if (r4 == 0) goto L59
            r4.setVisibility(r0)
        L59:
            android.widget.TextView r0 = r5.f26809yC
            goto L6e
        L5c:
            android.widget.TextView r0 = r5.f26808yB
            if (r0 == 0) goto L71
            java.lang.String r3 = r6.m31808gg()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L6d
            r3 = 8
            goto L6e
        L6d:
            r3 = 0
        L6e:
            r0.setVisibility(r3)
        L71:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.f26814yi
            if (r0 == 0) goto L8b
            java.util.List r3 = r6.m31807ha()
            int r4 = r5.f26811yE
            r0.m30444a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.f26814yi
            boolean r3 = r6.m31806hb()
            if (r3 == 0) goto L88
            r1 = 8
        L88:
            r0.setVisibility(r1)
        L8b:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.f26815yz
            if (r0 == 0) goto L9a
            com.kwad.components.core.e.d.c r1 = r6.m31810gZ()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.m31811gY()
            r0.m28915a(r1, r2)
        L9a:
            android.widget.ImageView r0 = r5.f26813ye
            java.lang.String r1 = r6.m31809gf()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.m31811gY()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8050h.m31709a(com.kwad.components.ad.reward.model.a):void");
    }
}
