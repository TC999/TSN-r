package com.bxkj.student.p094v2.common.utils;

import android.content.Context;
import android.content.Intent;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/i;", "", "", "url", "a", "Landroid/content/Context;", "mContext", "", "menu", "Lkotlin/f1;", "b", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class H5Utils {
    @NotNull

    /* renamed from: a */
    public static final H5Utils f20124a = new H5Utils();

    private H5Utils() {
    }

    /* renamed from: a */
    private final String m39076a(String str) {
        String m6568k2;
        String m6568k22;
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        m6568k2 = StringsJVM.m6568k2(str, "${school}", c3984b.m43634a().m43646p(), false, 4, null);
        m6568k22 = StringsJVM.m6568k2(m6568k2, "${token}", c3984b.m43634a().m43662b(), false, 4, null);
        return m6568k22;
    }

    /* renamed from: b */
    public final void m39075b(@NotNull Context mContext, @NotNull Map<String, ? extends Object> menu) {
        C14342f0.m8184p(mContext, "mContext");
        C14342f0.m8184p(menu, "menu");
        Intent intent = new Intent(mContext, H5AppActivity.class);
        JsonGet jsonGet = JsonGet.f15134a;
        mContext.startActivity(intent.putExtra("needUpdatePasswordStatus", jsonGet.m43760t(menu, "needUpdatePasswordStatus")).putExtra("title", jsonGet.m43760t(menu, "name")).putExtra("url", m39076a(jsonGet.m43760t(menu, "linkUrl"))));
    }
}
