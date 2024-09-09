package com.bxkj.base.util;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HtmlTextUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class l {
    public static void a(TextView textView, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setText(Html.fromHtml(str, 0));
        } else {
            textView.setText(Html.fromHtml(str));
        }
    }
}
