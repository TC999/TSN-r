package androidx.core.content;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aN\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\b\u001a8\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\b¨\u0006\u0013"}, m12616d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "getSystemService", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/util/AttributeSet;", "set", "", "attrs", "", "defStyleAttr", "defStyleRes", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "withStyledAttributes", "resourceId", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.content.ContextKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Context {
    @Nullable
    public static final /* synthetic */ <T> T getSystemService(@NotNull android.content.Context getSystemService) {
        C14342f0.m8183q(getSystemService, "$this$getSystemService");
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(getSystemService, Object.class);
    }

    public static final void withStyledAttributes(@NotNull android.content.Context withStyledAttributes, @Nullable AttributeSet attributeSet, @NotNull int[] attrs, @AttrRes int i, @StyleRes int i2, @NotNull InterfaceC15280l<? super TypedArray, Unit> block) {
        C14342f0.m8183q(withStyledAttributes, "$this$withStyledAttributes");
        C14342f0.m8183q(attrs, "attrs");
        C14342f0.m8183q(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i, i2);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(android.content.Context withStyledAttributes, AttributeSet attributeSet, int[] attrs, int i, int i2, InterfaceC15280l block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        C14342f0.m8183q(withStyledAttributes, "$this$withStyledAttributes");
        C14342f0.m8183q(attrs, "attrs");
        C14342f0.m8183q(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i, i2);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@NotNull android.content.Context withStyledAttributes, @StyleRes int i, @NotNull int[] attrs, @NotNull InterfaceC15280l<? super TypedArray, Unit> block) {
        C14342f0.m8183q(withStyledAttributes, "$this$withStyledAttributes");
        C14342f0.m8183q(attrs, "attrs");
        C14342f0.m8183q(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(i, attrs);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
