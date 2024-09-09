package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.devlin_n.videoplayer.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class CenterView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f36981a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f36982b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f36983c;

    public CenterView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setGravity(17);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_center_window, this);
        this.f36981a = (ImageView) inflate.findViewById(R.id.iv_icon);
        this.f36982b = (TextView) inflate.findViewById(R.id.tv_percent);
        this.f36983c = (ProgressBar) inflate.findViewById(R.id.pro_percent);
    }

    public void setIcon(int i4) {
        ImageView imageView = this.f36981a;
        if (imageView != null) {
            imageView.setImageResource(i4);
        }
    }

    public void setProPercent(int i4) {
        ProgressBar progressBar = this.f36983c;
        if (progressBar != null) {
            progressBar.setProgress(i4);
        }
    }

    public void setProVisibility(int i4) {
        ProgressBar progressBar = this.f36983c;
        if (progressBar != null) {
            progressBar.setVisibility(i4);
        }
    }

    public void setTextView(String str) {
        TextView textView = this.f36982b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        if (i4 != 0) {
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_out));
        }
    }
}
