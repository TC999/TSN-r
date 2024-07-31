package com.bxkj.base.p085v2.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DrawableLeftCenterButton.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/base/v2/common/view/DrawableLeftCenterButton;", "Landroidx/appcompat/widget/AppCompatButton;", "Landroid/graphics/Canvas;", "canvas", "a", "Lkotlin/f1;", "onDraw", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.view.DrawableLeftCenterButton */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DrawableLeftCenterButton extends AppCompatButton {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableLeftCenterButton(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        C14342f0.m8184p(context, "context");
        C14342f0.m8184p(attrs, "attrs");
    }

    /* renamed from: a */
    private final Canvas m43703a(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null) {
            return canvas;
        }
        Drawable drawable = compoundDrawables[0];
        if (drawable == null) {
            drawable = compoundDrawables[2];
        }
        float measureText = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
        setPadding(0, 0, (int) (getWidth() - measureText), 0);
        canvas.translate((getWidth() - measureText) / 2, 0.0f);
        return canvas;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        C14342f0.m8184p(canvas, "canvas");
        super.onDraw(m43703a(canvas));
    }
}
