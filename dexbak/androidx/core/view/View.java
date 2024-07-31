package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.InterfaceC0075Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.beizi.fusion.widget.ScrollClickView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a2\u0010\u0007\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\b\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\n\u001a\u00020\t*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\u000b\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a2\u0010\f\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b\u001a5\u0010\u0012\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\r2\b\b\u0003\u0010\u0010\u001a\u00020\r2\b\b\u0003\u0010\u0011\u001a\u00020\rH\u0087\b\u001a5\u0010\u0015\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0013\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\r2\b\b\u0003\u0010\u0014\u001a\u00020\r2\b\b\u0003\u0010\u0011\u001a\u00020\rH\u0086\b\u001a\u0017\u0010\u0017\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\rH\u0086\b\u001a%\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0086\b\u001a%\u0010\u001d\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0087\b\u001a\u0014\u0010!\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u001a&\u0010%\u001a\u00020\u0005*\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b#H\u0086\b\u001a9\u0010%\u001a\u00020\u0005\"\n\b\u0000\u0010&\u0018\u0001*\u00020\"*\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b#H\u0087\b¢\u0006\u0004\b'\u0010(\"*\u0010+\u001a\u00020)*\u00020\u00002\u0006\u0010*\u001a\u00020)8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\"*\u0010/\u001a\u00020)*\u00020\u00002\u0006\u0010*\u001a\u00020)8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.\"*\u00101\u001a\u00020)*\u00020\u00002\u0006\u0010*\u001a\u00020)8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.\"\u0016\u00105\u001a\u00020\r*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b3\u00104\"\u0016\u00107\u001a\u00020\r*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b6\u00104\"\u0016\u00109\u001a\u00020\r*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b8\u00104\"\u0016\u0010;\u001a\u00020\r*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b:\u00104\"\u0016\u0010=\u001a\u00020\r*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b<\u00104\"\u0016\u0010?\u001a\u00020\r*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b>\u00104¨\u0006@"}, m12616d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lkotlin/f1;", CcgConstant.f38549t, "doOnNextLayout", "doOnLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "doOnAttach", "doOnDetach", "", CampaignEx.JSON_NATIVE_VIDEO_START, "top", "end", "bottom", "updatePaddingRelative", ScrollClickView.DIR_LEFT, ScrollClickView.DIR_RIGHT, "updatePadding", "size", "setPadding", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "postOnAnimationDelayed", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "drawToBitmap", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "block", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "updateLayoutParamsTyped", "(Landroid/view/View;Ll1/l;)V", "", DomainCampaignEx.LOOPBACK_VALUE, "isVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isGone", "setGone", "getMarginLeft", "(Landroid/view/View;)I", "marginLeft", "getMarginTop", "marginTop", "getMarginRight", "marginRight", "getMarginBottom", "marginBottom", "getMarginStart", "marginStart", "getMarginEnd", "marginEnd", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.view.ViewKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class View {
    public static final void doOnAttach(@NotNull final android.view.View doOnAttach, @NotNull final InterfaceC15280l<? super android.view.View, Unit> action) {
        C14342f0.m8183q(doOnAttach, "$this$doOnAttach");
        C14342f0.m8183q(action, "action");
        if (ViewCompat.isAttachedToWindow(doOnAttach)) {
            action.invoke(doOnAttach);
        } else {
            doOnAttach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view) {
                    C14342f0.m8183q(view, "view");
                    doOnAttach.removeOnAttachStateChangeListener(this);
                    action.invoke(view);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view) {
                    C14342f0.m8183q(view, "view");
                }
            });
        }
    }

    public static final void doOnDetach(@NotNull final android.view.View doOnDetach, @NotNull final InterfaceC15280l<? super android.view.View, Unit> action) {
        C14342f0.m8183q(doOnDetach, "$this$doOnDetach");
        C14342f0.m8183q(action, "action");
        if (!ViewCompat.isAttachedToWindow(doOnDetach)) {
            action.invoke(doOnDetach);
        } else {
            doOnDetach.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view) {
                    C14342f0.m8183q(view, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view) {
                    C14342f0.m8183q(view, "view");
                    doOnDetach.removeOnAttachStateChangeListener(this);
                    action.invoke(view);
                }
            });
        }
    }

    public static final void doOnLayout(@NotNull android.view.View doOnLayout, @NotNull final InterfaceC15280l<? super android.view.View, Unit> action) {
        C14342f0.m8183q(doOnLayout, "$this$doOnLayout");
        C14342f0.m8183q(action, "action");
        if (ViewCompat.isLaidOut(doOnLayout) && !doOnLayout.isLayoutRequested()) {
            action.invoke(doOnLayout);
        } else {
            doOnLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    C14342f0.m8183q(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    InterfaceC15280l.this.invoke(view);
                }
            });
        }
    }

    public static final void doOnNextLayout(@NotNull android.view.View doOnNextLayout, @NotNull final InterfaceC15280l<? super android.view.View, Unit> action) {
        C14342f0.m8183q(doOnNextLayout, "$this$doOnNextLayout");
        C14342f0.m8183q(action, "action");
        doOnNextLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                C14342f0.m8183q(view, "view");
                view.removeOnLayoutChangeListener(this);
                InterfaceC15280l.this.invoke(view);
            }
        });
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull final android.view.View doOnPreDraw, @NotNull final InterfaceC15280l<? super android.view.View, Unit> action) {
        C14342f0.m8183q(doOnPreDraw, "$this$doOnPreDraw");
        C14342f0.m8183q(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(doOnPreDraw, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke(doOnPreDraw);
            }
        });
        C14342f0.m8192h(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull android.view.View drawToBitmap, @NotNull Bitmap.Config config) {
        C14342f0.m8183q(drawToBitmap, "$this$drawToBitmap");
        C14342f0.m8183q(config, "config");
        if (ViewCompat.isLaidOut(drawToBitmap)) {
            Bitmap createBitmap = Bitmap.createBitmap(drawToBitmap.getWidth(), drawToBitmap.getHeight(), config);
            C14342f0.m8192h(createBitmap, "Bitmap.createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-drawToBitmap.getScrollX(), -drawToBitmap.getScrollY());
            drawToBitmap.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(android.view.View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final int getMarginBottom(@NotNull android.view.View marginBottom) {
        C14342f0.m8183q(marginBottom, "$this$marginBottom");
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

    public static final int getMarginEnd(@NotNull android.view.View marginEnd) {
        C14342f0.m8183q(marginEnd, "$this$marginEnd");
        ViewGroup.LayoutParams layoutParams = marginEnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@NotNull android.view.View marginLeft) {
        C14342f0.m8183q(marginLeft, "$this$marginLeft");
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

    public static final int getMarginRight(@NotNull android.view.View marginRight) {
        C14342f0.m8183q(marginRight, "$this$marginRight");
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

    public static final int getMarginStart(@NotNull android.view.View marginStart) {
        C14342f0.m8183q(marginStart, "$this$marginStart");
        ViewGroup.LayoutParams layoutParams = marginStart.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@NotNull android.view.View marginTop) {
        C14342f0.m8183q(marginTop, "$this$marginTop");
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

    public static final boolean isGone(@NotNull android.view.View isGone) {
        C14342f0.m8183q(isGone, "$this$isGone");
        return isGone.getVisibility() == 8;
    }

    public static final boolean isInvisible(@NotNull android.view.View isInvisible) {
        C14342f0.m8183q(isInvisible, "$this$isInvisible");
        return isInvisible.getVisibility() == 4;
    }

    public static final boolean isVisible(@NotNull android.view.View isVisible) {
        C14342f0.m8183q(isVisible, "$this$isVisible");
        return isVisible.getVisibility() == 0;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull android.view.View postDelayed, long j, @NotNull final InterfaceC15269a<Unit> action) {
        C14342f0.m8183q(postDelayed, "$this$postDelayed");
        C14342f0.m8183q(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC15269a.this.invoke();
            }
        };
        postDelayed.postDelayed(runnable, j);
        return runnable;
    }

    @RequiresApi(16)
    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull android.view.View postOnAnimationDelayed, long j, @NotNull final InterfaceC15269a<Unit> action) {
        C14342f0.m8183q(postOnAnimationDelayed, "$this$postOnAnimationDelayed");
        C14342f0.m8183q(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC15269a.this.invoke();
            }
        };
        postOnAnimationDelayed.postOnAnimationDelayed(runnable, j);
        return runnable;
    }

    public static final void setGone(@NotNull android.view.View isGone, boolean z) {
        C14342f0.m8183q(isGone, "$this$isGone");
        isGone.setVisibility(z ? 8 : 0);
    }

    public static final void setInvisible(@NotNull android.view.View isInvisible, boolean z) {
        C14342f0.m8183q(isInvisible, "$this$isInvisible");
        isInvisible.setVisibility(z ? 4 : 0);
    }

    public static final void setPadding(@NotNull android.view.View setPadding, @InterfaceC0075Px int i) {
        C14342f0.m8183q(setPadding, "$this$setPadding");
        setPadding.setPadding(i, i, i, i);
    }

    public static final void setVisible(@NotNull android.view.View isVisible, boolean z) {
        C14342f0.m8183q(isVisible, "$this$isVisible");
        isVisible.setVisibility(z ? 0 : 8);
    }

    public static final void updateLayoutParams(@NotNull android.view.View updateLayoutParams, @NotNull InterfaceC15280l<? super ViewGroup.LayoutParams, Unit> block) {
        C14342f0.m8183q(updateLayoutParams, "$this$updateLayoutParams");
        C14342f0.m8183q(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        if (layoutParams != null) {
            block.invoke(layoutParams);
            updateLayoutParams.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(@NotNull android.view.View updateLayoutParams, @NotNull InterfaceC15280l<? super T, Unit> block) {
        C14342f0.m8183q(updateLayoutParams, "$this$updateLayoutParams");
        C14342f0.m8183q(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        C14342f0.m8175y(1, ExifInterface.GPS_DIRECTION_TRUE);
        block.invoke(layoutParams);
        updateLayoutParams.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@NotNull android.view.View updatePadding, @InterfaceC0075Px int i, @InterfaceC0075Px int i2, @InterfaceC0075Px int i3, @InterfaceC0075Px int i4) {
        C14342f0.m8183q(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(android.view.View updatePadding, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updatePadding.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = updatePadding.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = updatePadding.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = updatePadding.getPaddingBottom();
        }
        C14342f0.m8183q(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@NotNull android.view.View updatePaddingRelative, @InterfaceC0075Px int i, @InterfaceC0075Px int i2, @InterfaceC0075Px int i3, @InterfaceC0075Px int i4) {
        C14342f0.m8183q(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(android.view.View updatePaddingRelative, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updatePaddingRelative.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = updatePaddingRelative.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = updatePaddingRelative.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = updatePaddingRelative.getPaddingBottom();
        }
        C14342f0.m8183q(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i, i2, i3, i4);
    }
}
