package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.acse.ottn.f3;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Context.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0086\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aN\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0086\b\u001a8\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0086\b\u00a8\u0006\u0013"}, d2 = {"", "T", "Landroid/content/Context;", "getSystemService", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/util/AttributeSet;", f3.f5659h, "", "attrs", "", "defStyleAttr", "defStyleRes", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "block", "withStyledAttributes", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ContextKt {
    @Nullable
    public static final /* synthetic */ <T> T getSystemService(@NotNull Context getSystemService) {
        f0.q(getSystemService, "$this$getSystemService");
        f0.y(4, "T");
        return (T) ContextCompat.getSystemService(getSystemService, Object.class);
    }

    public static final void withStyledAttributes(@NotNull Context withStyledAttributes, @Nullable AttributeSet attributeSet, @NotNull int[] attrs, @AttrRes int i4, @StyleRes int i5, @NotNull l<? super TypedArray, f1> block) {
        f0.q(withStyledAttributes, "$this$withStyledAttributes");
        f0.q(attrs, "attrs");
        f0.q(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i4, i5);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context withStyledAttributes, AttributeSet attributeSet, int[] attrs, int i4, int i5, l block, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            attributeSet = null;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        f0.q(withStyledAttributes, "$this$withStyledAttributes");
        f0.q(attrs, "attrs");
        f0.q(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i4, i5);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@NotNull Context withStyledAttributes, @StyleRes int i4, @NotNull int[] attrs, @NotNull l<? super TypedArray, f1> block) {
        f0.q(withStyledAttributes, "$this$withStyledAttributes");
        f0.q(attrs, "attrs");
        f0.q(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(i4, attrs);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
