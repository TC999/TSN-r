package com.kwad.components.p208ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.reward.widget.KsToastView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsToastView extends LinearLayout {

    /* renamed from: Bd */
    TextView f27522Bd;

    /* renamed from: Be */
    private String f27523Be;

    /* renamed from: Bf */
    private Runnable f27524Bf;
    private int countDown;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.f27523Be = "%ss后自动进入";
        this.f27524Bf = null;
        init(context);
    }

    /* renamed from: b */
    static /* synthetic */ int m30977b(KsToastView ksToastView) {
        int i = ksToastView.countDown;
        ksToastView.countDown = i - 1;
        return i;
    }

    private void init(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_interstitial_toast_layout, this);
        this.f27522Bd = (TextView) findViewById(C9659R.C9662id.ksad_total_count_down_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m30976x(int i) {
        this.f27522Bd.setText(String.format(this.f27523Be, Integer.valueOf(i)));
    }

    /* renamed from: U */
    public final void m30980U(int i) {
        if (this.f27524Bf == null) {
            this.f27524Bf = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.m30976x(ksToastView.countDown);
                    KsToastView.m30977b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.f27524Bf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f27524Bf);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.f27523Be = "%ss后自动进入";
        this.f27524Bf = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 3;
        this.f27523Be = "%ss后自动进入";
        this.f27524Bf = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.f27523Be = "%ss后自动进入";
        this.f27524Bf = null;
        init(context);
    }
}
