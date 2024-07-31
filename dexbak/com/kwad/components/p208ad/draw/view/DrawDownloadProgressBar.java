package com.kwad.components.p208ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.draw.view.DrawDownloadProgressBar */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DrawDownloadProgressBar extends FrameLayout {

    /* renamed from: dh */
    private TextProgressBar f25376dh;

    /* renamed from: di */
    private View f25377di;
    private Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        m33338B(context);
    }

    /* renamed from: B */
    private void m33338B(Context context) {
        this.mContext = context;
        C10887l.inflate(context, C9659R.C9663layout.ksad_draw_download_bar, this);
        this.f25376dh = (TextProgressBar) findViewById(C9659R.C9662id.ksad_download_progress);
        View findViewById = findViewById(C9659R.C9662id.ksad_download_progress_cover);
        this.f25377di = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    /* renamed from: e */
    public final void m33337e(String str, int i) {
        if (i != 0 && i != getMax()) {
            this.f25377di.setVisibility(8);
        } else {
            this.f25377di.setVisibility(0);
        }
        this.f25376dh.m29709e(str, i);
    }

    public int getMax() {
        return this.f25376dh.getMax();
    }

    public void setTextColor(int i) {
        this.f25376dh.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f25376dh.setTextDimen(C10751a.m24924a(getContext(), i));
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m33338B(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33338B(context);
    }
}
