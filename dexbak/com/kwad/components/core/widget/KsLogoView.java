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
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsLogoView extends LinearLayout {
    private boolean acl;
    TextView acm;
    ImageView acn;
    private InterfaceC9361a aco;

    /* renamed from: ez */
    private SimpleImageLoadingListener f29454ez;

    /* renamed from: com.kwad.components.core.widget.KsLogoView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9361a {
        /* renamed from: kc */
        void mo28908kc();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    public static Bitmap m28913a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int ceil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? C10751a.m24924a(ksLogoView.getContext(), 18.0f) : 0);
        int m24924a = C10751a.m24924a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(ceil, m24924a);
        ksLogoView.layout(0, 0, ceil, m24924a);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        C10887l.inflate(getContext(), C9659R.C9663layout.ksad_logo_layout, this);
        this.acm = (TextView) findViewById(C9659R.C9662id.ksad_logo_text);
        this.acn = (ImageView) findViewById(C9659R.C9662id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.acl = z;
        if (z) {
            this.acn.setImageDrawable(getResources().getDrawable(C9659R.C9661drawable.ksad_logo_gray));
            this.acm.setTextColor(-6513508);
            return;
        }
        this.acn.setImageDrawable(getResources().getDrawable(C9659R.C9661drawable.ksad_logo_white));
        this.acm.setTextColor(-1711276033);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ts */
    public void m28909ts() {
        this.acn.setImageDrawable(getContext().getResources().getDrawable(this.acl ? C9659R.C9661drawable.ksad_logo_gray : C9659R.C9661drawable.ksad_logo_white));
    }

    /* renamed from: aD */
    public final void m28912aD(AdTemplate adTemplate) {
        View findViewById = findViewById(C9659R.C9662id.ksad_logo_container);
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String str = this.acl ? m25641dQ.adBaseInfo.adGrayMarkIcon : m25641dQ.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(m25641dQ.adBaseInfo.adSourceDescription)) {
            this.acm.setVisibility(0);
            this.acm.setText(C10483a.m25958aD(m25641dQ));
            this.acn.setVisibility(0);
            m28909ts();
            InterfaceC9361a interfaceC9361a = this.aco;
            if (interfaceC9361a != null) {
                interfaceC9361a.mo28908kc();
            }
        } else {
            if (!TextUtils.isEmpty(m25641dQ.adBaseInfo.adSourceDescription)) {
                this.acm.setText(C10483a.m25958aD(m25641dQ));
                this.acm.setVisibility(0);
            } else {
                this.acm.setVisibility(8);
                this.acm.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                KSImageLoader.loadFeeImage(this.acn, str, adTemplate, this.f29454ez);
                this.acn.setVisibility(0);
            } else {
                this.acn.setVisibility(8);
                this.acn.setImageDrawable(null);
                InterfaceC9361a interfaceC9361a2 = this.aco;
                if (interfaceC9361a2 != null) {
                    interfaceC9361a2.mo28908kc();
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

    public void setLogoLoadFinishListener(InterfaceC9361a interfaceC9361a) {
        this.aco = interfaceC9361a;
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C10887l.wrapContextIfNeed(context), attributeSet, i);
        this.f29454ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.mo28908kc();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.m28909ts();
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.mo28908kc();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(C10887l.wrapContextIfNeed(context));
        this.f29454ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.mo28908kc();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.m28909ts();
                if (KsLogoView.this.aco != null) {
                    KsLogoView.this.aco.mo28908kc();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(C9659R.C9661drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
