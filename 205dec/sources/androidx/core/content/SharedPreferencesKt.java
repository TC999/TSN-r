package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SharedPreferences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00a8\u0006\t"}, d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "action", "edit", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull SharedPreferences edit, boolean z3, @NotNull l<? super SharedPreferences.Editor, f1> action) {
        f0.q(edit, "$this$edit");
        f0.q(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        f0.h(editor, "editor");
        action.invoke(editor);
        if (z3) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences edit, boolean z3, l action, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        f0.q(edit, "$this$edit");
        f0.q(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        f0.h(editor, "editor");
        action.invoke(editor);
        if (z3) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
