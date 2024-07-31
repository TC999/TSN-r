package com.bxkj.base.p085v2.base;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bxkj.base.C3801R;
import com.bxkj.base.p085v2.common.view.SportCardView;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b)\u0010*J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J.\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0007J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0016H\u0007J$\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0016J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020#2\u0006\u0010!\u001a\u00020'¨\u0006+"}, m12616d2 = {"Lcom/bxkj/base/v2/base/l;", "", "Landroid/widget/ImageView;", "imageView", "", "url", "Lkotlin/f1;", "f", "Landroid/graphics/drawable/Drawable;", "src", "e", "Landroid/view/ViewGroup;", "viewGroup", "c", "holderDrawable", "errorDrawable", "g", "Landroid/graphics/Bitmap;", "bitmap", "d", "Landroid/widget/ProgressBar;", "progressBar", "", NotificationCompat.CATEGORY_PROGRESS, "max", "m", "Landroidx/cardview/widget/CardView;", "cardView", "color", "h", "Lcom/bxkj/base/v2/common/view/SportCardView;", "sportCardView", "count", "distance", "n", "Landroid/widget/TextView;", "tvCount", "i", "tvDistance", "", "k", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class BindingAdapter {
    @NotNull

    /* renamed from: a */
    public static final BindingAdapter f15040a = new BindingAdapter();

    private BindingAdapter() {
    }

    @androidx.databinding.BindingAdapter({"background"})
    @JvmStatic
    /* renamed from: c */
    public static final void m43887c(@NotNull ViewGroup viewGroup, @Nullable Drawable drawable) {
        C14342f0.m8184p(viewGroup, "viewGroup");
        if (drawable == null) {
            return;
        }
        viewGroup.setBackground(drawable);
    }

    @androidx.databinding.BindingAdapter({"bitmap"})
    @JvmStatic
    /* renamed from: d */
    public static final void m43886d(@NotNull ImageView imageView, @Nullable Bitmap bitmap) {
        C14342f0.m8184p(imageView, "imageView");
        if (bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    @androidx.databinding.BindingAdapter({"src"})
    @JvmStatic
    /* renamed from: e */
    public static final void m43885e(@NotNull ImageView imageView, @Nullable Drawable drawable) {
        C14342f0.m8184p(imageView, "imageView");
        if (drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @androidx.databinding.BindingAdapter({"imageUrl"})
    @JvmStatic
    /* renamed from: f */
    public static final void m43884f(@NotNull ImageView imageView, @Nullable String str) {
        C14342f0.m8184p(imageView, "imageView");
        Glide.m45751C(imageView.getContext()).mo45507a(str).m45551i1(imageView);
    }

    @androidx.databinding.BindingAdapter({"imageUrl", "placeHolder", "error"})
    @JvmStatic
    /* renamed from: g */
    public static final void m43883g(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        boolean m6548u2;
        boolean m6548u22;
        C14342f0.m8184p(imageView, "imageView");
        if (str == null) {
            return;
        }
        String str2 = str.length() > 0 ? str : null;
        if (str2 == null) {
            return;
        }
        C11792j.m20469d(C14342f0.m8216C("imageUrl:", str), new Object[0]);
        m6548u2 = StringsJVM.m6548u2(str2, IDataSource.f43971a, false, 2, null);
        if (m6548u2) {
            Glide.m45751C(imageView.getContext()).mo45507a(str2).m44599x0(drawable).m44598y(drawable2).m44612r(DiskCacheStrategy.f13787b).m44668G0(true).m45551i1(imageView);
            return;
        }
        m6548u22 = StringsJVM.m6548u2(str2, "/", false, 2, null);
        if (m6548u22) {
            Glide.m45751C(imageView.getContext()).mo45503f(new File(str2)).m44599x0(drawable).m44598y(drawable2).m44612r(DiskCacheStrategy.f13787b).m44668G0(true).m45551i1(imageView);
        } else {
            Glide.m45751C(imageView.getContext()).mo45499p(Integer.valueOf(Integer.parseInt(str2))).m44599x0(drawable).m44598y(drawable2).m44612r(DiskCacheStrategy.f13787b).m44668G0(true).m45551i1(imageView);
        }
    }

    @androidx.databinding.BindingAdapter({"cardBackground"})
    @JvmStatic
    /* renamed from: h */
    public static final void m43882h(@NotNull CardView cardView, int i) {
        C14342f0.m8184p(cardView, "cardView");
        cardView.setCardBackgroundColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m43880j(TextView tvCount, ValueAnimator animation) {
        C14342f0.m8184p(tvCount, "$tvCount");
        C14342f0.m8184p(animation, "animation");
        tvCount.setText(animation.getAnimatedValue().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m43878l(TextView tvDistance, ValueAnimator animation) {
        C14342f0.m8184p(tvDistance, "$tvDistance");
        C14342f0.m8184p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            tvDistance.setText(new DecimalFormat("0.000").format(((Float) animatedValue).floatValue()));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    @androidx.databinding.BindingAdapter({NotificationCompat.CATEGORY_PROGRESS, "max"})
    @JvmStatic
    /* renamed from: m */
    public static final void m43877m(@NotNull ProgressBar progressBar, int i, int i2) {
        C14342f0.m8184p(progressBar, "progressBar");
        progressBar.setMax(i2);
        progressBar.setProgress(i);
    }

    @androidx.databinding.BindingAdapter({"count", "distance"})
    @JvmStatic
    /* renamed from: n */
    public static final void m43876n(@NotNull SportCardView sportCardView, @Nullable String str, @Nullable String str2) {
        C14342f0.m8184p(sportCardView, "sportCardView");
        if (str != null) {
            BindingAdapter bindingAdapter = f15040a;
            View findViewById = sportCardView.findViewById(C3801R.C3805id.tv_count);
            C14342f0.m8185o(findViewById, "sportCardView.findViewById(R.id.tv_count)");
            bindingAdapter.m43881i((TextView) findViewById, (int) Float.parseFloat(str));
        }
        if (str2 == null) {
            return;
        }
        BindingAdapter bindingAdapter2 = f15040a;
        View findViewById2 = sportCardView.findViewById(C3801R.C3805id.tv_distance);
        C14342f0.m8185o(findViewById2, "sportCardView.findViewById(R.id.tv_distance)");
        bindingAdapter2.m43879k((TextView) findViewById2, Float.parseFloat(str2));
    }

    /* renamed from: i */
    public final void m43881i(@NotNull final TextView tvCount, int i) {
        C14342f0.m8184p(tvCount, "tvCount");
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i);
        ofInt.setDuration(1000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.base.v2.base.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BindingAdapter.m43880j(tvCount, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* renamed from: k */
    public final void m43879k(@NotNull final TextView tvDistance, float f) {
        C14342f0.m8184p(tvDistance, "tvDistance");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.base.v2.base.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BindingAdapter.m43878l(tvDistance, valueAnimator);
            }
        });
        ofFloat.start();
    }
}
