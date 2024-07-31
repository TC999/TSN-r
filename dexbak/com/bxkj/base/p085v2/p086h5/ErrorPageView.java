package com.bxkj.base.p085v2.p086h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.C3801R;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ErrorPageView.kt */
@Metadata(m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m12616d2 = {"Lcom/bxkj/base/v2/h5/ErrorPageView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "smartWebView", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "(Landroid/content/Context;Lcn/bluemobi/dylan/smartwebview/SmartWebView;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* renamed from: com.bxkj.base.v2.h5.ErrorPageView */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ErrorPageView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorPageView(@Nullable Context context, @NotNull final SmartWebView smartWebView) {
        super(context);
        C14342f0.m8184p(smartWebView, "smartWebView");
        ((Button) LayoutInflater.from(context).inflate(C3801R.C3807layout.ac_error_page, this).findViewById(C3801R.C3805id.bt_refresh)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.h5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorPageView.m43547b(SmartWebView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final void m43547b(SmartWebView smartWebView, View view) {
        C14342f0.m8184p(smartWebView, "$smartWebView");
        smartWebView.m57491l();
    }
}
