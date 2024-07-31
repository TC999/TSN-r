package androidx.core.text;

import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001aA\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a.\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\b2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a&\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a&\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a&\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a0\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a&\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a.\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\b¨\u0006\u0019"}, m12616d2 = {"Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "Landroid/text/SpannedString;", "buildSpannedString", "", "", "spans", "inSpans", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Ll1/l;)Landroid/text/SpannableStringBuilder;", "span", "bold", "italic", "underline", "", "color", "backgroundColor", "strikeThrough", "", "proportion", "scale", "superscript", "subscript", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.text.SpannableStringBuilderKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SpannableStringBuilder {
    @NotNull
    public static final android.text.SpannableStringBuilder backgroundColor(@NotNull android.text.SpannableStringBuilder backgroundColor, @ColorInt int i, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(backgroundColor, "$this$backgroundColor");
        C14342f0.m8183q(builderAction, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i);
        int length = backgroundColor.length();
        builderAction.invoke(backgroundColor);
        backgroundColor.setSpan(backgroundColorSpan, length, backgroundColor.length(), 17);
        return backgroundColor;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder bold(@NotNull android.text.SpannableStringBuilder bold, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(bold, "$this$bold");
        C14342f0.m8183q(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = bold.length();
        builderAction.invoke(bold);
        bold.setSpan(styleSpan, length, bold.length(), 17);
        return bold;
    }

    @NotNull
    public static final SpannedString buildSpannedString(@NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(builderAction, "builderAction");
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        builderAction.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @NotNull
    public static final android.text.SpannableStringBuilder color(@NotNull android.text.SpannableStringBuilder color, @ColorInt int i, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(color, "$this$color");
        C14342f0.m8183q(builderAction, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        int length = color.length();
        builderAction.invoke(color);
        color.setSpan(foregroundColorSpan, length, color.length(), 17);
        return color;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder inSpans(@NotNull android.text.SpannableStringBuilder inSpans, @NotNull Object[] spans, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(inSpans, "$this$inSpans");
        C14342f0.m8183q(spans, "spans");
        C14342f0.m8183q(builderAction, "builderAction");
        int length = inSpans.length();
        builderAction.invoke(inSpans);
        for (Object obj : spans) {
            inSpans.setSpan(obj, length, inSpans.length(), 17);
        }
        return inSpans;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder italic(@NotNull android.text.SpannableStringBuilder italic, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(italic, "$this$italic");
        C14342f0.m8183q(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = italic.length();
        builderAction.invoke(italic);
        italic.setSpan(styleSpan, length, italic.length(), 17);
        return italic;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder scale(@NotNull android.text.SpannableStringBuilder scale, float f, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(scale, "$this$scale");
        C14342f0.m8183q(builderAction, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f);
        int length = scale.length();
        builderAction.invoke(scale);
        scale.setSpan(relativeSizeSpan, length, scale.length(), 17);
        return scale;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder strikeThrough(@NotNull android.text.SpannableStringBuilder strikeThrough, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(strikeThrough, "$this$strikeThrough");
        C14342f0.m8183q(builderAction, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = strikeThrough.length();
        builderAction.invoke(strikeThrough);
        strikeThrough.setSpan(strikethroughSpan, length, strikeThrough.length(), 17);
        return strikeThrough;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder subscript(@NotNull android.text.SpannableStringBuilder subscript, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(subscript, "$this$subscript");
        C14342f0.m8183q(builderAction, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = subscript.length();
        builderAction.invoke(subscript);
        subscript.setSpan(subscriptSpan, length, subscript.length(), 17);
        return subscript;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder superscript(@NotNull android.text.SpannableStringBuilder superscript, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(superscript, "$this$superscript");
        C14342f0.m8183q(builderAction, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = superscript.length();
        builderAction.invoke(superscript);
        superscript.setSpan(superscriptSpan, length, superscript.length(), 17);
        return superscript;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder underline(@NotNull android.text.SpannableStringBuilder underline, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(underline, "$this$underline");
        C14342f0.m8183q(builderAction, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = underline.length();
        builderAction.invoke(underline);
        underline.setSpan(underlineSpan, length, underline.length(), 17);
        return underline;
    }

    @NotNull
    public static final android.text.SpannableStringBuilder inSpans(@NotNull android.text.SpannableStringBuilder inSpans, @NotNull Object span, @NotNull InterfaceC15280l<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        C14342f0.m8183q(inSpans, "$this$inSpans");
        C14342f0.m8183q(span, "span");
        C14342f0.m8183q(builderAction, "builderAction");
        int length = inSpans.length();
        builderAction.invoke(inSpans);
        inSpans.setSpan(span, length, inSpans.length(), 17);
        return inSpans;
    }
}
