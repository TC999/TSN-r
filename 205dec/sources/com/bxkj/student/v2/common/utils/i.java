package com.bxkj.student.v2.common.utils;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import m.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: H5Utils.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J,\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0006\u0010\u000e\u001a\u00020\rJ$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/v2/common/utils/i;", "", "", "url", "a", "Landroid/content/Context;", "mContext", "", "menu", "Lkotlin/f1;", "b", "Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lm/b$a;", "callBack", "c", "d", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final i f23368a = new i();

    private i() {
    }

    private final String a(String str) {
        String k22;
        String k23;
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        k22 = w.k2(str, "${school}", bVar.a().w(), false, 4, null);
        k23 = w.k2(k22, "${token}", bVar.a().d(), false, 4, null);
        return k23;
    }

    public final void b(@NotNull Context mContext, @NotNull Map<String, ? extends Object> menu) {
        f0.p(mContext, "mContext");
        f0.p(menu, "menu");
        Intent intent = new Intent(mContext, H5AppActivity.class);
        com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
        mContext.startActivity(intent.putExtra("needUpdatePasswordStatus", mVar.t(menu, "needUpdatePasswordStatus")).putExtra("title", mVar.t(menu, "name")).putExtra("url", a(mVar.t(menu, "linkUrl"))));
    }

    public final void c(@NotNull FragmentActivity mActivity, @NotNull Map<String, ? extends Object> menu, @NotNull b.a callBack) {
        f0.p(mActivity, "mActivity");
        f0.p(menu, "menu");
        f0.p(callBack, "callBack");
        m.b bVar = new m.b(mActivity);
        Intent intent = new Intent(mActivity, H5AppActivity.class);
        com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
        Intent putExtra = intent.putExtra("needUpdatePasswordStatus", mVar.t(menu, "needUpdatePasswordStatus")).putExtra("title", mVar.t(menu, "name")).putExtra("url", a(mVar.t(menu, "linkUrl")));
        f0.o(putExtra, "Intent(mActivity, H5AppA\u2026 \"linkUrl\"))\n           )");
        bVar.startActivityForResult(putExtra).c(callBack);
    }

    public final void d(@NotNull Context mContext, @NotNull Map<String, ? extends Object> menu) {
        f0.p(mContext, "mContext");
        f0.p(menu, "menu");
        Intent intent = new Intent(mContext, H5AppActivity.class);
        com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
        mContext.startActivity(intent.putExtra("needUpdatePasswordStatus", mVar.t(menu, "needUpdatePasswordStatus")).putExtra("title", mVar.t(menu, "name")).putExtra("url", a(mVar.t(menu, "linkUrl"))).putExtra("imagePath", mVar.t(menu, "imagePath")));
    }
}
