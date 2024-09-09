package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.util.AttributeSet;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: H5WebView.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/bxkj/base/v2/common/view/H5WebView;", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "Lkotlin/f1;", "n", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class H5WebView extends SmartWebView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5WebView(@NotNull Context context) {
        super(context);
        f0.p(context, "context");
        n();
    }

    private final void n() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5WebView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        f0.p(context, "context");
        f0.p(attrs, "attrs");
        n();
    }
}
