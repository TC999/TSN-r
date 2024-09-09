package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.sr.k;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.ev += 6;
        if (this.f29132a.pr()) {
            AnimationText animationText = new AnimationText(context, this.f29132a.r(), this.f29132a.ux(), 1, this.f29132a.ev());
            this.ys = animationText;
            animationText.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.ys = textView;
            textView.setIncludeFontPadding(false);
        }
        this.ys.setTag(Integer.valueOf(getClickArea()));
        addView(this.ys, getWidgetLayoutParams());
    }

    private boolean gd() {
        DynamicRootView dynamicRootView = this.f29140t;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.f29140t.getRenderRequest().p() == 4) ? false : true;
    }

    private void k() {
        if (this.ys instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    arrayList.add(jSONArray.optString(i4));
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                arrayList.add(text);
            }
            ((AnimationText) this.ys).setMaxLines(1);
            ((AnimationText) this.ys).setTextColor(this.f29132a.r());
            ((AnimationText) this.ys).setTextSize(this.f29132a.ux());
            ((AnimationText) this.ys).setAnimationText(arrayList);
            ((AnimationText) this.ys).setAnimationType(this.f29132a.x());
            ((AnimationText) this.ys).setAnimationDuration(this.f29132a.bw() * 1000);
            ((AnimationText) this.ys).c();
        }
    }

    private void p() {
        int c4;
        if (TextUtils.equals(this.bk.p().getType(), "source") || TextUtils.equals(this.bk.p().getType(), "title") || TextUtils.equals(this.bk.p().getType(), "text_star")) {
            int[] w3 = k.w(this.f29132a.f(), this.f29132a.ux(), true);
            int c5 = (int) f.c(getContext(), this.f29132a.w());
            int c6 = (int) f.c(getContext(), this.f29132a.xv());
            int c7 = (int) f.c(getContext(), this.f29132a.sr());
            int c8 = (int) f.c(getContext(), this.f29132a.c());
            int min = Math.min(c5, c8);
            if (TextUtils.equals(this.bk.p().getType(), "source") && (c4 = ((this.ev - ((int) f.c(getContext(), this.f29132a.ux()))) - c5) - c8) > 1 && c4 <= min * 2) {
                int i4 = c4 / 2;
                this.ys.setPadding(c6, c5 - i4, c7, c8 - (c4 - i4));
                return;
            }
            int i5 = (((w3[1] + c5) + c8) - this.ev) - 2;
            if (i5 <= 1) {
                return;
            }
            if (i5 <= min * 2) {
                int i6 = i5 / 2;
                this.ys.setPadding(c6, c5 - i6, c7, c8 - (i5 - i6));
            } else if (i5 > c5 + c8) {
                final int i7 = (i5 - c5) - c8;
                this.ys.setPadding(c6, 0, c7, 0);
                if (i7 <= ((int) f.c(getContext(), 1.0f)) + 1) {
                    ((TextView) this.ys).setTextSize(this.f29132a.ux() - 1.0f);
                } else if (i7 <= (((int) f.c(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.ys).setTextSize(this.f29132a.ux() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.ys.getLayoutParams();
                                DynamicTextView dynamicTextView = DynamicTextView.this;
                                layoutParams.height = dynamicTextView.ev + i7;
                                dynamicTextView.ys.setLayoutParams(layoutParams);
                                DynamicTextView.this.ys.setTranslationY(-i7);
                                ((ViewGroup) DynamicTextView.this.ys.getParent()).setClipChildren(false);
                                ((ViewGroup) DynamicTextView.this.ys.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (c5 > c8) {
                this.ys.setPadding(c6, c5 - (i5 - min), c7, c8 - min);
            } else {
                this.ys.setPadding(c6, c5 - min, c7, c8 - (i5 - min));
            }
        }
        if (TextUtils.equals(this.bk.p().getType(), "fillButton")) {
            this.ys.setTextAlignment(2);
            ((TextView) this.ys).setGravity(17);
        }
    }

    public void c(TextView textView, int i4, Context context, String str) {
        String format = String.format(i.c(context, str), Integer.valueOf(i4));
        textView.setText("(" + format + ")");
        if (i4 == -1) {
            textView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        int i4;
        super.ev();
        if (TextUtils.isEmpty(getText())) {
            this.ys.setVisibility(4);
            return true;
        } else if (this.f29132a.pr()) {
            k();
            return true;
        } else {
            ((TextView) this.ys).setText(this.f29132a.f());
            ((TextView) this.ys).setTextDirection(5);
            this.ys.setTextAlignment(this.f29132a.ev());
            ((TextView) this.ys).setTextColor(this.f29132a.r());
            ((TextView) this.ys).setTextSize(this.f29132a.ux());
            if (!this.f29132a.q()) {
                ((TextView) this.ys).setMaxLines(1);
                ((TextView) this.ys).setGravity(17);
                ((TextView) this.ys).setEllipsize(TextUtils.TruncateAt.END);
            } else {
                int j4 = this.f29132a.j();
                if (j4 > 0) {
                    ((TextView) this.ys).setLines(j4);
                    ((TextView) this.ys).setEllipsize(TextUtils.TruncateAt.END);
                }
            }
            ev evVar = this.bk;
            if (evVar != null && evVar.p() != null) {
                if (com.bytedance.sdk.component.adexpress.sr.c() && gd() && (TextUtils.equals(this.bk.p().getType(), "text_star") || TextUtils.equals(this.bk.p().getType(), "score-count") || TextUtils.equals(this.bk.p().getType(), "score-count-type-1") || TextUtils.equals(this.bk.p().getType(), "score-count-type-2"))) {
                    setVisibility(8);
                    return true;
                }
                if (!TextUtils.equals(this.bk.p().getType(), "score-count") && !TextUtils.equals(this.bk.p().getType(), "score-count-type-2")) {
                    if (TextUtils.equals(this.bk.p().getType(), "text_star")) {
                        double d4 = -1.0d;
                        try {
                            d4 = Double.parseDouble(getText());
                        } catch (Exception e4) {
                            a.f("DynamicStarView applyNativeStyle", e4.toString());
                        }
                        if (d4 < 0.0d || d4 > 5.0d) {
                            if (com.bytedance.sdk.component.adexpress.sr.c()) {
                                setVisibility(8);
                                return true;
                            }
                            this.ys.setVisibility(0);
                        }
                        ((TextView) this.ys).setIncludeFontPadding(false);
                        ((TextView) this.ys).setText(String.format("%.1f", Double.valueOf(d4)));
                    } else if (TextUtils.equals("privacy-detail", this.bk.p().getType())) {
                        ((TextView) this.ys).setText("\u529f\u80fd | \u6743\u9650 | \u9690\u79c1");
                    } else if (TextUtils.equals(this.bk.p().getType(), "development-name")) {
                        ((TextView) this.ys).setText(i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_text_privacy_development") + getText());
                    } else if (TextUtils.equals(this.bk.p().getType(), "app-version")) {
                        ((TextView) this.ys).setText(i.c(com.bytedance.sdk.component.adexpress.sr.getContext(), "tt_text_privacy_app_version") + getText());
                    } else {
                        ((TextView) this.ys).setText(getText());
                    }
                } else {
                    try {
                        try {
                            i4 = Integer.parseInt(getText());
                        } catch (Exception unused) {
                        }
                    } catch (NumberFormatException unused2) {
                        i4 = -1;
                    }
                    if (i4 < 0) {
                        if (com.bytedance.sdk.component.adexpress.sr.c()) {
                            setVisibility(8);
                            return true;
                        }
                        this.ys.setVisibility(0);
                    }
                    if (TextUtils.equals(this.bk.p().getType(), "score-count-type-2")) {
                        ((TextView) this.ys).setText(String.format(new DecimalFormat("(###,###,###)").format(i4), Integer.valueOf(i4)));
                        ((TextView) this.ys).setGravity(17);
                        return true;
                    }
                    c((TextView) this.ys, i4, getContext(), "tt_comment_num");
                }
                this.ys.setTextAlignment(this.f29132a.ev());
                ((TextView) this.ys).setGravity(this.f29132a.gd());
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    p();
                }
            }
            return true;
        }
    }

    public String getText() {
        String f4 = this.f29132a.f();
        if (TextUtils.isEmpty(f4)) {
            if (!com.bytedance.sdk.component.adexpress.sr.c() && TextUtils.equals(this.bk.p().getType(), "text_star")) {
                f4 = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.sr.c() && TextUtils.equals(this.bk.p().getType(), "score-count")) {
                f4 = "6870";
            }
        }
        return (TextUtils.equals(this.bk.p().getType(), "title") || TextUtils.equals(this.bk.p().getType(), MediaFormat.KEY_SUBTITLE)) ? f4.replace("\n", "") : f4;
    }
}
