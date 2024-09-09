package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.a;
import d2.l;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: View.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a2\u0010\u0007\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\b\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\n\u001a\u00020\t*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\u000b\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\f\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a5\u0010\u0012\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\r2\b\b\u0003\u0010\u0010\u001a\u00020\r2\b\b\u0003\u0010\u0011\u001a\u00020\rH\u0087\b\u001a5\u0010\u0015\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0013\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\r2\b\b\u0003\u0010\u0014\u001a\u00020\r2\b\b\u0003\u0010\u0011\u001a\u00020\rH\u0086\b\u001a\u0017\u0010\u0017\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\rH\u0086\b\u001a%\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0086\b\u001a%\u0010\u001d\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0087\b\u001a\u0014\u0010!\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u001a&\u0010%\u001a\u00020\u0005*\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u0001\u00a2\u0006\u0002\b#H\u0086\b\u001a9\u0010%\u001a\u00020\u0005\"\n\b\u0000\u0010&\u0018\u0001*\u00020\"*\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0001\u00a2\u0006\u0002\b#H\u0087\b\u00a2\u0006\u0004\b'\u0010(\"*\u0010+\u001a\u00020)*\u00020\u00002\u0006\u0010*\u001a\u00020)8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\"*\u0010/\u001a\u00020)*\u00020\u00002\u0006\u0010*\u001a\u00020)8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.\"*\u00101\u001a\u00020)*\u00020\u00002\u0006\u0010*\u001a\u00020)8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.\"\u0016\u00105\u001a\u00020\r*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b3\u00104\"\u0016\u00107\u001a\u00020\r*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b6\u00104\"\u0016\u00109\u001a\u00020\r*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b8\u00104\"\u0016\u0010;\u001a\u00020\r*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b:\u00104\"\u0016\u0010=\u001a\u00020\r*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b<\u00104\"\u0016\u0010?\u001a\u00020\r*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b>\u00104\u00a8\u0006@"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lkotlin/f1;", "action", "doOnNextLayout", "doOnLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "doOnAttach", "doOnDetach", "", CampaignEx.JSON_NATIVE_VIDEO_START, "top", "end", "bottom", "updatePaddingRelative", "left", "right", "updatePadding", "size", "setPadding", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "postOnAnimationDelayed", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "drawToBitmap", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "block", "updateLayoutParams", "T", "updateLayoutParamsTyped", "(Landroid/view/View;Ld2/l;)V", "", "value", "isVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isGone", "setGone", "getMarginLeft", "(Landroid/view/View;)I", "marginLeft", "getMarginTop", "marginTop", "getMarginRight", "marginRight", "getMarginBottom", "marginBottom", "getMarginStart", "marginStart", "getMarginEnd", "marginEnd", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewKt {
    public static final void doOnAttach(@NotNull final View doOnAttach, @NotNull final l<? super View, f1> action) {
        f0.q(doOnAttach, "$this$doOnAttach");
        f0.q(action, "action");
        if (ViewCompat.isAttachedToWindow(doOnAttach)) {
            action.invoke(doOnAttach);
        } else {
            doOnAttach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view) {
                    f0.q(view, "view");
                    doOnAttach.removeOnAttachStateChangeListener(this);
                    action.invoke(view);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view) {
                    f0.q(view, "view");
                }
            });
        }
    }

    public static final void doOnDetach(@NotNull final View doOnDetach, @NotNull final l<? super View, f1> action) {
        f0.q(doOnDetach, "$this$doOnDetach");
        f0.q(action, "action");
        if (!ViewCompat.isAttachedToWindow(doOnDetach)) {
            action.invoke(doOnDetach);
        } else {
            doOnDetach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view) {
                    f0.q(view, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view) {
                    f0.q(view, "view");
                    doOnDetach.removeOnAttachStateChangeListener(this);
                    action.invoke(view);
                }
            });
        }
    }

    public static final void doOnLayout(@NotNull View doOnLayout, @NotNull final l<? super View, f1> action) {
        f0.q(doOnLayout, "$this$doOnLayout");
        f0.q(action, "action");
        if (ViewCompat.isLaidOut(doOnLayout) && !doOnLayout.isLayoutRequested()) {
            action.invoke(doOnLayout);
        } else {
            doOnLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    f0.q(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    l.this.invoke(view);
                }
            });
        }
    }

    public static final void doOnNextLayout(@NotNull View doOnNextLayout, @NotNull final l<? super View, f1> action) {
        f0.q(doOnNextLayout, "$this$doOnNextLayout");
        f0.q(action, "action");
        doOnNextLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                f0.q(view, "view");
                view.removeOnLayoutChangeListener(this);
                l.this.invoke(view);
            }
        });
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull final View doOnPreDraw, @NotNull final l<? super View, f1> action) {
        f0.q(doOnPreDraw, "$this$doOnPreDraw");
        f0.q(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(doOnPreDraw, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke(doOnPreDraw);
            }
        });
        f0.h(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull View drawToBitmap, @NotNull Bitmap.Config config) {
        f0.q(drawToBitmap, "$this$drawToBitmap");
        f0.q(config, "config");
        if (ViewCompat.isLaidOut(drawToBitmap)) {
            Bitmap createBitmap = Bitmap.createBitmap(drawToBitmap.getWidth(), drawToBitmap.getHeight(), config);
            f0.h(createBitmap, "Bitmap.createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-drawToBitmap.getScrollX(), -drawToBitmap.getScrollY());
            drawToBitmap.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final int getMarginBottom(@NotNull View marginBottom) {
        f0.q(marginBottom, "$this$marginBottom");
        ViewGroup.LayoutParams layoutParams = marginBottom.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@NotNull View marginEnd) {
        f0.q(marginEnd, "$this$marginEnd");
        ViewGroup.LayoutParams layoutParams = marginEnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@NotNull View marginLeft) {
        f0.q(marginLeft, "$this$marginLeft");
        ViewGroup.LayoutParams layoutParams = marginLeft.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@NotNull View marginRight) {
        f0.q(marginRight, "$this$marginRight");
        ViewGroup.LayoutParams layoutParams = marginRight.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@NotNull View marginStart) {
        f0.q(marginStart, "$this$marginStart");
        ViewGroup.LayoutParams layoutParams = marginStart.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@NotNull View marginTop) {
        f0.q(marginTop, "$this$marginTop");
        ViewGroup.LayoutParams layoutParams = marginTop.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@NotNull View isGone) {
        f0.q(isGone, "$this$isGone");
        return isGone.getVisibility() == 8;
    }

    public static final boolean isInvisible(@NotNull View isInvisible) {
        f0.q(isInvisible, "$this$isInvisible");
        return isInvisible.getVisibility() == 4;
    }

    public static final boolean isVisible(@NotNull View isVisible) {
        f0.q(isVisible, "$this$isVisible");
        return isVisible.getVisibility() == 0;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View postDelayed, long j4, @NotNull final a<f1> action) {
        f0.q(postDelayed, "$this$postDelayed");
        f0.q(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.invoke();
            }
        };
        postDelayed.postDelayed(runnable, j4);
        return runnable;
    }

    @RequiresApi(16)
    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull View postOnAnimationDelayed, long j4, @NotNull final a<f1> action) {
        f0.q(postOnAnimationDelayed, "$this$postOnAnimationDelayed");
        f0.q(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.invoke();
            }
        };
        postOnAnimationDelayed.postOnAnimationDelayed(runnable, j4);
        return runnable;
    }

    public static final void setGone(@NotNull View isGone, boolean z3) {
        f0.q(isGone, "$this$isGone");
        isGone.setVisibility(z3 ? 8 : 0);
    }

    public static final void setInvisible(@NotNull View isInvisible, boolean z3) {
        f0.q(isInvisible, "$this$isInvisible");
        isInvisible.setVisibility(z3 ? 4 : 0);
    }

    public static final void setPadding(@NotNull View setPadding, @Px int i4) {
        f0.q(setPadding, "$this$setPadding");
        setPadding.setPadding(i4, i4, i4, i4);
    }

    public static final void setVisible(@NotNull View isVisible, boolean z3) {
        f0.q(isVisible, "$this$isVisible");
        isVisible.setVisibility(z3 ? 0 : 8);
    }

    public static final void updateLayoutParams(@NotNull View updateLayoutParams, @NotNull l<? super ViewGroup.LayoutParams, f1> block) {
        f0.q(updateLayoutParams, "$this$updateLayoutParams");
        f0.q(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        if (layoutParams != null) {
            block.invoke(layoutParams);
            updateLayoutParams.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(@NotNull View updateLayoutParams, @NotNull l<? super T, f1> block) {
        f0.q(updateLayoutParams, "$this$updateLayoutParams");
        f0.q(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        f0.y(1, "T");
        block.invoke(layoutParams);
        updateLayoutParams.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@NotNull View updatePadding, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        f0.q(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updatePadding$default(View updatePadding, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = updatePadding.getPaddingLeft();
        }
        if ((i8 & 2) != 0) {
            i5 = updatePadding.getPaddingTop();
        }
        if ((i8 & 4) != 0) {
            i6 = updatePadding.getPaddingRight();
        }
        if ((i8 & 8) != 0) {
            i7 = updatePadding.getPaddingBottom();
        }
        f0.q(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i4, i5, i6, i7);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@NotNull View updatePaddingRelative, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        f0.q(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View updatePaddingRelative, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = updatePaddingRelative.getPaddingStart();
        }
        if ((i8 & 2) != 0) {
            i5 = updatePaddingRelative.getPaddingTop();
        }
        if ((i8 & 4) != 0) {
            i6 = updatePaddingRelative.getPaddingEnd();
        }
        if ((i8 & 8) != 0) {
            i7 = updatePaddingRelative.getPaddingBottom();
        }
        f0.q(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i4, i5, i6, i7);
    }
}
