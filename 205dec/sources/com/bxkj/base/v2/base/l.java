package com.bxkj.base.v2.base;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import com.bxkj.base.R;
import com.bxkj.base.v2.common.view.SportCardView;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BindingAdapter.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J.\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0016H\u0007J$\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0016J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020#2\u0006\u0010!\u001a\u00020'\u00a8\u0006+"}, d2 = {"Lcom/bxkj/base/v2/base/l;", "", "Landroid/widget/ImageView;", "imageView", "", "url", "Lkotlin/f1;", "f", "Landroid/graphics/drawable/Drawable;", "src", "e", "Landroid/view/ViewGroup;", "viewGroup", "c", "holderDrawable", "errorDrawable", "g", "Landroid/graphics/Bitmap;", "bitmap", "d", "Landroid/widget/ProgressBar;", "progressBar", "", "progress", "max", "m", "Landroidx/cardview/widget/CardView;", "cardView", "color", "h", "Lcom/bxkj/base/v2/common/view/SportCardView;", "sportCardView", "count", "distance", "n", "Landroid/widget/TextView;", "tvCount", "i", "tvDistance", "", "k", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f18527a = new l();

    private l() {
    }

    @BindingAdapter({"background"})
    @JvmStatic
    public static final void c(@NotNull ViewGroup viewGroup, @Nullable Drawable drawable) {
        f0.p(viewGroup, "viewGroup");
        if (drawable == null) {
            return;
        }
        viewGroup.setBackground(drawable);
    }

    @BindingAdapter({"bitmap"})
    @JvmStatic
    public static final void d(@NotNull ImageView imageView, @Nullable Bitmap bitmap) {
        f0.p(imageView, "imageView");
        if (bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    @BindingAdapter({"src"})
    @JvmStatic
    public static final void e(@NotNull ImageView imageView, @Nullable Drawable drawable) {
        f0.p(imageView, "imageView");
        if (drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter({"imageUrl"})
    @JvmStatic
    public static final void f(@NotNull ImageView imageView, @Nullable String str) {
        f0.p(imageView, "imageView");
        com.bumptech.glide.d.C(imageView.getContext()).a(str).i1(imageView);
    }

    @BindingAdapter({"imageUrl", "placeHolder", "error"})
    @JvmStatic
    public static final void g(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        boolean u22;
        boolean u23;
        f0.p(imageView, "imageView");
        if (str == null) {
            return;
        }
        String str2 = str.length() > 0 ? str : null;
        if (str2 == null) {
            return;
        }
        com.orhanobut.logger.j.d(f0.C("imageUrl:", str), new Object[0]);
        u22 = w.u2(str2, "http", false, 2, null);
        if (u22) {
            com.bumptech.glide.d.C(imageView.getContext()).a(str2).x0(drawable).y(drawable2).r(com.bumptech.glide.load.engine.j.f17104b).G0(true).i1(imageView);
            return;
        }
        u23 = w.u2(str2, TTPathConst.sSeparator, false, 2, null);
        if (u23) {
            com.bumptech.glide.d.C(imageView.getContext()).f(new File(str2)).x0(drawable).y(drawable2).r(com.bumptech.glide.load.engine.j.f17104b).G0(true).i1(imageView);
        } else {
            com.bumptech.glide.d.C(imageView.getContext()).p(Integer.valueOf(Integer.parseInt(str2))).x0(drawable).y(drawable2).r(com.bumptech.glide.load.engine.j.f17104b).G0(true).i1(imageView);
        }
    }

    @BindingAdapter({"cardBackground"})
    @JvmStatic
    public static final void h(@NotNull CardView cardView, int i4) {
        f0.p(cardView, "cardView");
        cardView.setCardBackgroundColor(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TextView tvCount, ValueAnimator animation) {
        f0.p(tvCount, "$tvCount");
        f0.p(animation, "animation");
        tvCount.setText(animation.getAnimatedValue().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TextView tvDistance, ValueAnimator animation) {
        f0.p(tvDistance, "$tvDistance");
        f0.p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            tvDistance.setText(new DecimalFormat("0.000").format(((Float) animatedValue).floatValue()));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    @BindingAdapter({"progress", "max"})
    @JvmStatic
    public static final void m(@NotNull ProgressBar progressBar, int i4, int i5) {
        f0.p(progressBar, "progressBar");
        progressBar.setMax(i5);
        progressBar.setProgress(i4);
    }

    @BindingAdapter({"count", "distance"})
    @JvmStatic
    public static final void n(@NotNull SportCardView sportCardView, @Nullable String str, @Nullable String str2) {
        f0.p(sportCardView, "sportCardView");
        if (str != null) {
            l lVar = f18527a;
            View findViewById = sportCardView.findViewById(R.id.tv_count);
            f0.o(findViewById, "sportCardView.findViewById(R.id.tv_count)");
            lVar.i((TextView) findViewById, (int) Float.parseFloat(str));
        }
        if (str2 == null) {
            return;
        }
        l lVar2 = f18527a;
        View findViewById2 = sportCardView.findViewById(R.id.tv_distance);
        f0.o(findViewById2, "sportCardView.findViewById(R.id.tv_distance)");
        lVar2.k((TextView) findViewById2, Float.parseFloat(str2));
    }

    public final void i(@NotNull final TextView tvCount, int i4) {
        f0.p(tvCount, "tvCount");
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i4);
        ofInt.setDuration(1000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.base.v2.base.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                l.j(tvCount, valueAnimator);
            }
        });
        ofInt.start();
    }

    public final void k(@NotNull final TextView tvDistance, float f4) {
        f0.p(tvDistance, "tvDistance");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f4);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.base.v2.base.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                l.l(tvDistance, valueAnimator);
            }
        });
        ofFloat.start();
    }
}
