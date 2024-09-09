package com.bytedance.sdk.openadsdk.core.widget.playable.loading;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.w.sr;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.TTLoadingProgressBar;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PlayableLoadingLayout extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    protected TTLoadingProgressBar f35454c;
    protected JSONObject sr;

    /* renamed from: w  reason: collision with root package name */
    protected TextView f35455w;
    protected TextView xv;

    public PlayableLoadingLayout(Context context, JSONObject jSONObject) {
        super(context);
        this.sr = jSONObject;
    }

    public void c(Context context) {
        setVisibility(8);
        addView(ux.gd(context));
        TTLoadingProgressBar tTLoadingProgressBar = (TTLoadingProgressBar) findViewById(2114387684);
        this.f35454c = tTLoadingProgressBar;
        tTLoadingProgressBar.getProgressBar().setBackgroundColor(Color.parseColor("#FC625C"));
        this.f35455w = (TextView) findViewById(2114387935);
        this.xv = (TextView) findViewById(2114387727);
        JSONObject jSONObject = this.sr;
        if (jSONObject != null) {
            String optString = jSONObject.optString("button_text");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.xv.setText(optString);
        }
    }

    public void setBtnPlayOnClickListener(sr srVar) {
        TextView textView = this.xv;
        if (textView == null || srVar == null) {
            return;
        }
        textView.setOnClickListener(srVar);
    }

    public void setBtnPlayOnTouchListener(sr srVar) {
        TextView textView = this.xv;
        if (textView == null || srVar == null) {
            return;
        }
        textView.setOnTouchListener(srVar);
    }

    public void setProgress(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        if (i4 > 100) {
            i4 = 100;
        }
        TTLoadingProgressBar tTLoadingProgressBar = this.f35454c;
        if (tTLoadingProgressBar != null) {
            tTLoadingProgressBar.setProgress(i4);
        }
        TextView textView = this.f35455w;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i4)));
        }
    }

    public void w() {
        setVisibility(0);
    }

    public void c() {
        setVisibility(8);
    }
}
