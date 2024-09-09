package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavOptionsBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Landroidx/navigation/AnimBuilder;", "", "()V", "enter", "", "getEnter", "()I", "setEnter", "(I)V", "exit", "getExit", "setExit", "popEnter", "getPopEnter", "setPopEnter", "popExit", "getPopExit", "setPopExit", "navigation-common-ktx_release"}, k = 1, mv = {1, 1, 16})
@NavOptionsDsl
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class AnimBuilder {
    @AnimRes
    @AnimatorRes
    private int enter = -1;
    @AnimRes
    @AnimatorRes
    private int exit = -1;
    @AnimRes
    @AnimatorRes
    private int popEnter = -1;
    @AnimRes
    @AnimatorRes
    private int popExit = -1;

    public final int getEnter() {
        return this.enter;
    }

    public final int getExit() {
        return this.exit;
    }

    public final int getPopEnter() {
        return this.popEnter;
    }

    public final int getPopExit() {
        return this.popExit;
    }

    public final void setEnter(int i4) {
        this.enter = i4;
    }

    public final void setExit(int i4) {
        this.exit = i4;
    }

    public final void setPopEnter(int i4) {
        this.popEnter = i4;
    }

    public final void setPopExit(int i4) {
        this.popExit = i4;
    }
}
