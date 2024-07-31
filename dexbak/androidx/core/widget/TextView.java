package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.mobads.sdk.internal.C2573a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15286r;

@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001as\u0010\r\u001a\u00020\f*\u00020\u00002d\b\u0004\u0010\u000b\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001H\u0086\b\u001as\u0010\u000f\u001a\u00020\f*\u00020\u00002d\b\u0004\u0010\u000b\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u0001H\u0086\b\u001a4\u0010\u0012\u001a\u00020\f*\u00020\u00002%\b\u0004\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\u0010H\u0086\b\u001a\u0080\u0002\u0010\u0016\u001a\u00020\f*\u00020\u00002d\b\u0006\u0010\u0013\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00012d\b\u0006\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u00012%\b\u0006\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\u0010H\u0086\b¨\u0006\u0017"}, m12616d2 = {"Landroid/widget/TextView;", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", C2573a.f8443b, "", CampaignEx.JSON_NATIVE_VIDEO_START, "count", "after", "Lkotlin/f1;", CcgConstant.f38549t, "Landroid/text/TextWatcher;", "doBeforeTextChanged", "before", "doOnTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "beforeTextChanged", "onTextChanged", "afterTextChanged", "addTextChangedListener", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.widget.TextViewKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TextView {
    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull android.widget.TextView addTextChangedListener, @NotNull InterfaceC15286r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> beforeTextChanged, @NotNull InterfaceC15286r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> onTextChanged, @NotNull InterfaceC15280l<? super Editable, Unit> afterTextChanged) {
        C14342f0.m8183q(addTextChangedListener, "$this$addTextChangedListener");
        C14342f0.m8183q(beforeTextChanged, "beforeTextChanged");
        C14342f0.m8183q(onTextChanged, "onTextChanged");
        C14342f0.m8183q(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(android.widget.TextView addTextChangedListener, InterfaceC15286r beforeTextChanged, InterfaceC15286r onTextChanged, InterfaceC15280l afterTextChanged, int i, Object obj) {
        if ((i & 1) != 0) {
            beforeTextChanged = new InterfaceC15286r<CharSequence, Integer, Integer, Integer, Unit>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                @Override // p617l1.InterfaceC15286r
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.f41048a;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
                }
            };
        }
        if ((i & 2) != 0) {
            onTextChanged = new InterfaceC15286r<CharSequence, Integer, Integer, Integer, Unit>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                @Override // p617l1.InterfaceC15286r
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.f41048a;
                }

                public final void invoke(@Nullable CharSequence charSequence, int i2, int i3, int i4) {
                }
            };
        }
        if ((i & 4) != 0) {
            afterTextChanged = new InterfaceC15280l<Editable, Unit>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                @Override // p617l1.InterfaceC15280l
                public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                    invoke2(editable);
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Editable editable) {
                }
            };
        }
        C14342f0.m8183q(addTextChangedListener, "$this$addTextChangedListener");
        C14342f0.m8183q(beforeTextChanged, "beforeTextChanged");
        C14342f0.m8183q(onTextChanged, "onTextChanged");
        C14342f0.m8183q(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull android.widget.TextView doAfterTextChanged, @NotNull final InterfaceC15280l<? super Editable, Unit> action) {
        C14342f0.m8183q(doAfterTextChanged, "$this$doAfterTextChanged");
        C14342f0.m8183q(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                InterfaceC15280l.this.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        doAfterTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull android.widget.TextView doBeforeTextChanged, @NotNull final InterfaceC15286r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        C14342f0.m8183q(doBeforeTextChanged, "$this$doBeforeTextChanged");
        C14342f0.m8183q(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                InterfaceC15286r.this.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        doBeforeTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull android.widget.TextView doOnTextChanged, @NotNull final InterfaceC15286r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        C14342f0.m8183q(doOnTextChanged, "$this$doOnTextChanged");
        C14342f0.m8183q(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                InterfaceC15286r.this.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        };
        doOnTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
