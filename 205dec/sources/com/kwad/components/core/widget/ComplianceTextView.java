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
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.abw = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, 154);
        int color = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (ai.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.abq = "\u529f\u80fd";
        this.abr = "\u6743\u9650";
        this.abs = "\u9690\u79c1";
        AdInfo.DownloadSafeInfo downloadSafeInfo = dQ.downloadSafeInfo;
        this.abt = downloadSafeInfo.appPermissionInfoUrl;
        this.abv = downloadSafeInfo.appPrivacyUrl;
        this.abu = downloadSafeInfo.introductionInfoUrl;
        if (this.abw > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (!ai.LZ()) {
                layoutParams.width = com.kwad.sdk.d.a.a.a(getContext(), this.abw);
            } else {
                layoutParams.width = -1;
            }
            setLayoutParams(layoutParams);
        }
        post(new ay() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = dQ.downloadSafeInfo;
                complianceTextView.a(downloadSafeInfo2.appName, TextUtils.isEmpty(downloadSafeInfo2.corporationName) ? "" : dQ.downloadSafeInfo.corporationName, dQ.downloadSafeInfo.appVersion, ComplianceTextView.this.abq, ComplianceTextView.this.abr, ComplianceTextView.this.abs);
            }
        });
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " | \u7248\u672c ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(this.abu)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str4);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0642a().as("\u529f\u80fd\u4ecb\u7ecd").at(ComplianceTextView.this.abu).aC(true).as(ComplianceTextView.this.mAdTemplate).pl());
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
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0642a().as("\u6743\u9650\u4fe1\u606f").at(ComplianceTextView.this.abt).aC(true).as(ComplianceTextView.this.mAdTemplate).pl());
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
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0642a().as("\u9690\u79c1\u653f\u7b56").at(ComplianceTextView.this.abv).aC(true).as(ComplianceTextView.this.mAdTemplate).pl());
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
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.abp = "...";
        this.abw = 154;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        int width;
        boolean z3;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" | \u7248\u672c ");
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
        if (!ai.LZ()) {
            width = (this.abw - getPaddingLeft()) - getPaddingRight();
            z3 = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z3 = false;
        }
        if (width < 0) {
            return;
        }
        if (!z3 && !TextUtils.isEmpty(str2)) {
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
        b(str, str2 + this.abp, str3, str4, str5, str6);
        requestLayout();
    }
}
