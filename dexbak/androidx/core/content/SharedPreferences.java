package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\b¨\u0006\t"}, m12616d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "edit", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.content.SharedPreferencesKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SharedPreferences {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull android.content.SharedPreferences edit, boolean z, @NotNull InterfaceC15280l<? super SharedPreferences.Editor, Unit> action) {
        C14342f0.m8183q(edit, "$this$edit");
        C14342f0.m8183q(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        C14342f0.m8192h(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(android.content.SharedPreferences edit, boolean z, InterfaceC15280l action, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        C14342f0.m8183q(edit, "$this$edit");
        C14342f0.m8183q(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        C14342f0.m8192h(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
