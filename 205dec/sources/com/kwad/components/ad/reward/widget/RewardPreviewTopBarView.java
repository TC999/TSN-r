package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String Bh;
    private String Bi;
    private ProgressBar Bj;
    private TextView Bk;
    private ImageView Bl;
    private long Bm;
    private long Bn;
    private boolean Bo;
    private a Bp;
    private TextView sA;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void F(boolean z3);

        void G(boolean z3);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.Bh = " \u79d2\u540e\u5373\u53ef\u83b7\u5f97\u5956\u52b1";
        this.Bi = "\u606d\u559c\u4f60\u83b7\u5f97\u5956\u52b1";
        this.Bm = -1L;
        this.Bo = false;
    }

    @MainThread
    private void e(boolean z3, boolean z4) {
        if (!this.Bo) {
            this.sA.setVisibility(8);
            this.Bk.setText(this.Bi);
            a aVar = this.Bp;
            if (aVar != null) {
                aVar.G(false);
            }
        } else {
            this.sA.setVisibility(0);
        }
        this.Bo = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.Bj = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.sA = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.Bk = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.Bl = imageView;
        imageView.setVisibility(8);
        this.Bl.setOnClickListener(this);
    }

    public final boolean ke() {
        return this.Bo;
    }

    @MainThread
    public final void n(long j4) {
        int ceil = (int) Math.ceil(((float) j4) / 1000.0f);
        TextView textView = this.Bk;
        if (textView != null) {
            textView.setText(ceil + this.Bh);
        }
        e(j4, this.Bm);
        if (this.Bm - j4 >= this.Bn && this.Bl.getVisibility() != 0) {
            this.Bl.setVisibility(0);
        }
        if (ceil <= 0) {
            e(true, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.Bl) || (aVar = this.Bp) == null) {
            return;
        }
        aVar.F(this.Bo);
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j4) {
        this.Bn = j4;
        if (j4 <= 0) {
            this.Bl.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.sA;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTopBarListener(a aVar) {
        this.Bp = aVar;
    }

    @MainThread
    public void setTotalCountDuration(long j4) {
        this.Bm = j4;
        this.Bj.setMax((int) j4);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bh = " \u79d2\u540e\u5373\u53ef\u83b7\u5f97\u5956\u52b1";
        this.Bi = "\u606d\u559c\u4f60\u83b7\u5f97\u5956\u52b1";
        this.Bm = -1L;
        this.Bo = false;
    }

    @MainThread
    private void e(long j4, long j5) {
        this.Bj.setProgress((int) (j5 - j4));
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.Bh = " \u79d2\u540e\u5373\u53ef\u83b7\u5f97\u5956\u52b1";
        this.Bi = "\u606d\u559c\u4f60\u83b7\u5f97\u5956\u52b1";
        this.Bm = -1L;
        this.Bo = false;
    }
}
