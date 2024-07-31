package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ComplianceTextView extends TextView {
    private String abp;
    private String abq;
    private String abr;
    private String abs;
    private String abt;
    private String abu;
    private String abv;
    private int abw;
    private AdTemplate mAdTemplate;
    @ColorInt
    private int textColor;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_ComplianceTextView);
        this.abw = obtainStyledAttributes.getDimensionPixelOffset(C9659R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, Opcodes.IFNE);
        int color = obtainStyledAttributes.getColor(C9659R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (C11015ai.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, C9659R.C9661drawable.ksad_compliance_view_bg));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.abq = "功能";
        this.abr = "权限";
        this.abs = "隐私";
        AdInfo.DownloadSafeInfo downloadSafeInfo = m25641dQ.downloadSafeInfo;
        this.abt = downloadSafeInfo.appPermissionInfoUrl;
        this.abv = downloadSafeInfo.appPrivacyUrl;
        this.abu = downloadSafeInfo.introductionInfoUrl;
        if (this.abw > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (!C11015ai.m24123LZ()) {
                layoutParams.width = C10751a.m24924a(getContext(), this.abw);
            } else {
                layoutParams.width = -1;
            }
            setLayoutParams(layoutParams);
        }
        post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = m25641dQ.downloadSafeInfo;
                complianceTextView.m28975a(downloadSafeInfo2.appName, TextUtils.isEmpty(downloadSafeInfo2.corporationName) ? "" : m25641dQ.downloadSafeInfo.corporationName, m25641dQ.downloadSafeInfo.appVersion, ComplianceTextView.this.abq, ComplianceTextView.this.abr, ComplianceTextView.this.abs);
            }
        });
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    private void m28973b(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(this.abu)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str4);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as("功能介绍").m29854at(ComplianceTextView.this.abu).m29859aC(true).m29856as(ComplianceTextView.this.mAdTemplate).m29851pl());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.abt)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as("权限信息").m29854at(ComplianceTextView.this.abt).m29859aC(true).m29856as(ComplianceTextView.this.mAdTemplate).m29851pl());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.abv)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.C8777a.C8778a().m29855as("隐私政策").m29854at(ComplianceTextView.this.abv).m29859aC(true).m29856as(ComplianceTextView.this.mAdTemplate).m29851pl());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), C9659R.C9660color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abp = "...";
        this.abw = Opcodes.IFNE;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m28975a(String str, String str2, String str3, String str4, String str5, String str6) {
        int width;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" | 版本 ");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(this.abu)) {
            sb.append(" | ");
            sb.append(str4);
        }
        if (!TextUtils.isEmpty(this.abt)) {
            sb.append(" | ");
            sb.append(str5);
        }
        if (!TextUtils.isEmpty(this.abv)) {
            sb.append(" | ");
            sb.append(str6);
        }
        getContext();
        if (!C11015ai.m24123LZ()) {
            width = (this.abw - getPaddingLeft()) - getPaddingRight();
            z = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z = false;
        }
        if (width < 0) {
            return;
        }
        if (!z && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float measureText = width - paint.measureText(str + sb.toString());
            if (paint.measureText(" " + str2) > measureText && measureText > 0.0f) {
                while (str2.length() > 1) {
                    str2 = str2.substring(0, str2.length() - 1);
                    if (paint.measureText(" " + str2 + this.abp) <= measureText) {
                        break;
                    }
                }
            } else {
                this.abp = "";
            }
        } else {
            this.abp = "";
        }
        m28973b(str, str2 + this.abp, str3, str4, str5, str6);
        requestLayout();
    }
}
