package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsLogoView extends LinearLayout {
    private boolean acl;
    TextView acm;
    ImageView acn;
    private a aco;
    private SimpleImageLoadingListener ez;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void kc();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int ceil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.d.a.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int a4 = com.kwad.sdk.d.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(ceil, a4);
        ksLogoView.layout(0, 0, ceil, a4);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        l.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.acm = (TextView) findViewById(R.id.ksad_logo_text);
        this.acn = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z3 = getBackground() == null;
        this.acl = z3;
        if (z3) {
            this.acn.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.acm.setTextColor(-6513508);
            return;
        }
        this.acn.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
        this.acm.setTextColor(-1711276033);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts() {
        this.acn.setImageDrawable(getContext().getResources().getDrawable(this.acl ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    public final void aD(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        String str = this.acl ? dQ.adBaseInfo.adGrayMarkIcon : dQ.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(dQ.adBaseInfo.adSourceDescription)) {
            this.acm.setVisibility(0);
            this.acm.setText(com.kwad.sdk.core.response.b.a.aD(dQ));
            this.acn.setVisibility(0);
            ts();
            a aVar = this.aco;
            if (aVar != null) {
                aVar.kc();
            }
        } else {
            if (!TextUtils.isEmpty(dQ.adBaseInfo.adSourceDescription)) {
                this.acm.setText(com.kwad.sdk.core.response.b.a.aD(dQ));
                this.acm.setVisibility(0);
            } else {
                this.acm.setVisibility(8);
                this.acm.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                KSImageLoader.loadFeeImage(this.acn, str, adTemplate, this.ez);
                this.acn.setVisibility(0);
            } else {
                this.acn.setVisibility(8);
                this.acn.setImageDrawable(null);
                a aVar2 = this.aco;
                if (aVar2 != null) {
                    aVar2.kc();
                }
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.acn;
    }

    public TextView getTextView() {
        return this.acm;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.aco = aVar;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(l.wrapContextIfNeed(context), attributeSet, i4);
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.kc();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.ts();
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.kc();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z3) {
        super(l.wrapContextIfNeed(context));
        this.ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.kc();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.ts();
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.kc();
                }
            }
        };
        if (z3) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
