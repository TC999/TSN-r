package com.kwad.components.p208ad.reward.widget;

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
import com.kwad.sdk.C9659R;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.reward.widget.RewardPreviewTopBarView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {

    /* renamed from: Bh */
    private String f27526Bh;

    /* renamed from: Bi */
    private String f27527Bi;

    /* renamed from: Bj */
    private ProgressBar f27528Bj;

    /* renamed from: Bk */
    private TextView f27529Bk;

    /* renamed from: Bl */
    private ImageView f27530Bl;

    /* renamed from: Bm */
    private long f27531Bm;

    /* renamed from: Bn */
    private long f27532Bn;

    /* renamed from: Bo */
    private boolean f27533Bo;

    /* renamed from: Bp */
    private InterfaceC8331a f27534Bp;

    /* renamed from: sA */
    private TextView f27535sA;

    /* renamed from: com.kwad.components.ad.reward.widget.RewardPreviewTopBarView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8331a {
        /* renamed from: F */
        void mo30971F(boolean z);

        /* renamed from: G */
        void mo30970G(boolean z);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.f27526Bh = " 秒后即可获得奖励";
        this.f27527Bi = "恭喜你获得奖励";
        this.f27531Bm = -1L;
        this.f27533Bo = false;
    }

    @MainThread
    /* renamed from: e */
    private void m30974e(boolean z, boolean z2) {
        if (!this.f27533Bo) {
            this.f27535sA.setVisibility(8);
            this.f27529Bk.setText(this.f27527Bi);
            InterfaceC8331a interfaceC8331a = this.f27534Bp;
            if (interfaceC8331a != null) {
                interfaceC8331a.mo30970G(false);
            }
        } else {
            this.f27535sA.setVisibility(0);
        }
        this.f27533Bo = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), C9659R.C9663layout.ksad_activity_preview_topbar, this);
        this.f27528Bj = (ProgressBar) findViewById(C9659R.C9662id.ksad_preview_topbar_progress);
        this.f27535sA = (TextView) findViewById(C9659R.C9662id.ksad_preview_topbar_reward_tips);
        this.f27529Bk = (TextView) findViewById(C9659R.C9662id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_preview_topbar_close);
        this.f27530Bl = imageView;
        imageView.setVisibility(8);
        this.f27530Bl.setOnClickListener(this);
    }

    /* renamed from: ke */
    public final boolean m30973ke() {
        return this.f27533Bo;
    }

    @MainThread
    /* renamed from: n */
    public final void m30972n(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        TextView textView = this.f27529Bk;
        if (textView != null) {
            textView.setText(ceil + this.f27526Bh);
        }
        m30975e(j, this.f27531Bm);
        if (this.f27531Bm - j >= this.f27532Bn && this.f27530Bl.getVisibility() != 0) {
            this.f27530Bl.setVisibility(0);
        }
        if (ceil <= 0) {
            m30974e(true, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC8331a interfaceC8331a;
        if (!view.equals(this.f27530Bl) || (interfaceC8331a = this.f27534Bp) == null) {
            return;
        }
        interfaceC8331a.mo30971F(this.f27533Bo);
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j) {
        this.f27532Bn = j;
        if (j <= 0) {
            this.f27530Bl.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.f27535sA;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTopBarListener(InterfaceC8331a interfaceC8331a) {
        this.f27534Bp = interfaceC8331a;
    }

    @MainThread
    public void setTotalCountDuration(long j) {
        this.f27531Bm = j;
        this.f27528Bj.setMax((int) j);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27526Bh = " 秒后即可获得奖励";
        this.f27527Bi = "恭喜你获得奖励";
        this.f27531Bm = -1L;
        this.f27533Bo = false;
    }

    @MainThread
    /* renamed from: e */
    private void m30975e(long j, long j2) {
        this.f27528Bj.setProgress((int) (j2 - j));
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27526Bh = " 秒后即可获得奖励";
        this.f27527Bi = "恭喜你获得奖励";
        this.f27531Bm = -1L;
        this.f27533Bo = false;
    }
}
