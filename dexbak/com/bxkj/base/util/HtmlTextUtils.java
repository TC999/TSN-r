package com.bxkj.base.util;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/* renamed from: com.bxkj.base.util.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HtmlTextUtils {
    /* renamed from: a */
    public static void m44070a(TextView textView, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setText(Html.fromHtml(str, 0));
        } else {
            textView.setText(Html.fromHtml(str));
        }
    }
}
