package com.bxkj.base.v2.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.R;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ErrorPageView.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bxkj/base/v2/h5/ErrorPageView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "smartWebView", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "(Landroid/content/Context;Lcn/bluemobi/dylan/smartwebview/SmartWebView;)V", "base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ErrorPageView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorPageView(@Nullable Context context, @NotNull final SmartWebView smartWebView) {
        super(context);
        f0.p(smartWebView, "smartWebView");
        ((Button) LayoutInflater.from(context).inflate(R.layout.ac_error_page, this).findViewById(R.id.bt_refresh)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.h5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorPageView.b(SmartWebView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SmartWebView smartWebView, View view) {
        f0.p(smartWebView, "$smartWebView");
        smartWebView.l();
    }
}
