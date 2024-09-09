package com.bytedance.adsdk.ugeno.component.text;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RichTextView extends TextView {
    public RichTextView(Context context) {
        super(context);
    }

    public void setRichText(String str) {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(str, 0);
        } else {
            fromHtml = Html.fromHtml(str);
        }
        setText(fromHtml);
    }
}
