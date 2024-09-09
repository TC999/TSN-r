package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import d2.l;
import d2.r;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TextView.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001as\u0010\r\u001a\u00020\f*\u00020\u00002d\b\u0004\u0010\u000b\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001H\u0086\b\u001as\u0010\u000f\u001a\u00020\f*\u00020\u00002d\b\u0004\u0010\u000b\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u0001H\u0086\b\u001a4\u0010\u0012\u001a\u00020\f*\u00020\u00002%\b\u0004\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\u0010H\u0086\b\u001a\u0080\u0002\u0010\u0016\u001a\u00020\f*\u00020\u00002d\b\u0006\u0010\u0013\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00012d\b\u0006\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u00012%\b\u0006\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\u0010H\u0086\b\u00a8\u0006\u0017"}, d2 = {"Landroid/widget/TextView;", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", CampaignEx.JSON_NATIVE_VIDEO_START, "count", "after", "Lkotlin/f1;", "action", "Landroid/text/TextWatcher;", "doBeforeTextChanged", "before", "doOnTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "beforeTextChanged", "onTextChanged", "afterTextChanged", "addTextChangedListener", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TextViewKt {
    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull TextView addTextChangedListener, @NotNull r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f1> beforeTextChanged, @NotNull r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f1> onTextChanged, @NotNull l<? super Editable, f1> afterTextChanged) {
        f0.q(addTextChangedListener, "$this$addTextChangedListener");
        f0.q(beforeTextChanged, "beforeTextChanged");
        f0.q(onTextChanged, "onTextChanged");
        f0.q(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView addTextChangedListener, r beforeTextChanged, r onTextChanged, l afterTextChanged, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            beforeTextChanged = new r<CharSequence, Integer, Integer, Integer, f1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                @Override // d2.r
                public /* bridge */ /* synthetic */ f1 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return f1.f55527a;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i5, int i6, int i7) {
                }
            };
        }
        if ((i4 & 2) != 0) {
            onTextChanged = new r<CharSequence, Integer, Integer, Integer, f1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                @Override // d2.r
                public /* bridge */ /* synthetic */ f1 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return f1.f55527a;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i5, int i6, int i7) {
                }
            };
        }
        if ((i4 & 4) != 0) {
            afterTextChanged = new l<Editable, f1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                @Override // d2.l
                public /* bridge */ /* synthetic */ f1 invoke(Editable editable) {
                    invoke2(editable);
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Editable editable) {
                }
            };
        }
        f0.q(addTextChangedListener, "$this$addTextChangedListener");
        f0.q(beforeTextChanged, "beforeTextChanged");
        f0.q(onTextChanged, "onTextChanged");
        f0.q(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull TextView doAfterTextChanged, @NotNull final l<? super Editable, f1> action) {
        f0.q(doAfterTextChanged, "$this$doAfterTextChanged");
        f0.q(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                l.this.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        };
        doAfterTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull TextView doBeforeTextChanged, @NotNull final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f1> action) {
        f0.q(doBeforeTextChanged, "$this$doBeforeTextChanged");
        f0.q(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
                r.this.invoke(charSequence, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        };
        doBeforeTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull TextView doOnTextChanged, @NotNull final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f1> action) {
        f0.q(doOnTextChanged, "$this$doOnTextChanged");
        f0.q(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
                r.this.invoke(charSequence, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
            }
        };
        doOnTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
