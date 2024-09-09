package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ay;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String Be = "%s\u79d2\u540e\u81ea\u52a8\u5173\u95ed";
    private TextView acf;
    private ImageView acg;
    private a ach;
    private boolean aci;
    private boolean acj;
    private int countDown;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void de();

        void df();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }

    private void P(Context context) {
        l.inflate(context, R.layout.ksad_auto_close, this);
        this.acf = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.acg = imageView;
        imageView.setOnClickListener(this);
    }

    static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i4 = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i4 - 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i4) {
        this.acf.setText(String.format(Be, Integer.valueOf(i4)));
    }

    public final void U(int i4) {
        if (i4 <= 0) {
            return;
        }
        this.countDown = i4;
        post(new ay() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (KsAutoCloseView.this.aci) {
                    if (KsAutoCloseView.this.acj) {
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    } else if (KsAutoCloseView.this.countDown == 0) {
                        if (KsAutoCloseView.this.ach != null) {
                            KsAutoCloseView.this.ach.de();
                        }
                    } else {
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.x(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    }
                }
            }
        });
    }

    public final void aY(boolean z3) {
        this.aci = z3;
        int i4 = z3 ? 0 : 8;
        TextView textView = this.acf;
        if (textView != null) {
            textView.setVisibility(i4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ach != null && view.equals(this.acg)) {
            this.ach.df();
        }
    }

    public void setCountDownPaused(boolean z3) {
        this.acj = z3;
    }

    public void setViewListener(a aVar) {
        this.ach = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }
}
