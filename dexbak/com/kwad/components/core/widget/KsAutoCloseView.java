package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {

    /* renamed from: Be */
    private static String f29453Be = "%s秒后自动关闭";
    private TextView acf;
    private ImageView acg;
    private InterfaceC9359a ach;
    private boolean aci;
    private boolean acj;
    private int countDown;

    /* renamed from: com.kwad.components.core.widget.KsAutoCloseView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9359a {
        /* renamed from: de */
        void mo28917de();

        /* renamed from: df */
        void mo28916df();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        m28927P(context);
    }

    /* renamed from: P */
    private void m28927P(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_auto_close, this);
        this.acf = (TextView) findViewById(C9659R.C9662id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_auto_close_btn);
        this.acg = imageView;
        imageView.setOnClickListener(this);
    }

    /* renamed from: e */
    static /* synthetic */ int m28919e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m28918x(int i) {
        this.acf.setText(String.format(f29453Be, Integer.valueOf(i)));
    }

    /* renamed from: U */
    public final void m28926U(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (KsAutoCloseView.this.aci) {
                    if (KsAutoCloseView.this.acj) {
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    } else if (KsAutoCloseView.this.countDown == 0) {
                        if (KsAutoCloseView.this.ach != null) {
                            KsAutoCloseView.this.ach.mo28917de();
                        }
                    } else {
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.m28918x(ksAutoCloseView.countDown);
                        KsAutoCloseView.m28919e(KsAutoCloseView.this);
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    }
                }
            }
        });
    }

    /* renamed from: aY */
    public final void m28923aY(boolean z) {
        this.aci = z;
        int i = z ? 0 : 8;
        TextView textView = this.acf;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ach != null && view.equals(this.acg)) {
            this.ach.mo28916df();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.acj = z;
    }

    public void setViewListener(InterfaceC9359a interfaceC9359a) {
        this.ach = interfaceC9359a;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        m28927P(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        m28927P(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        m28927P(context);
    }
}
