package com.bxkj.student.v2.common.utils;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.ui.MainActivity;
import com.bxkj.student.v2.ui.my.AboutUsActivity;
import com.bxkj.student.v2.ui.my.MyQRCodeActivity;
import com.bxkj.student.v2.ui.my.ScanQrCodeActivity;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.bxkj.student.v2.ui.sports.v3.set.V3StatisticsActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MenuOnclick.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/utils/j;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23369a = new a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MenuOnclick.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\b\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J,\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\t\u001a\u00020\u0003\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/v2/common/utils/j$a;", "", "", "", "menu", "Landroidx/fragment/app/FragmentActivity;", "mContext", "Lkotlin/f1;", "a", "menuType", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final void a(Map<String, ? extends Object> map, FragmentActivity fragmentActivity) {
            com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
            String t3 = mVar.t(map, "name");
            String t4 = mVar.t(map, "mkey");
            switch (t4.hashCode()) {
                case -1554031739:
                    if (t4.equals("myQrCodeKey")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, MyQRCodeActivity.class).putExtra("title", t3));
                        return;
                    }
                    break;
                case -1181718421:
                    if (t4.equals("scanQRCode")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, ScanQrCodeActivity.class));
                        return;
                    }
                    break;
                case -286799507:
                    if (t4.equals("appRunStatistics")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, V3StatisticsActivity.class).putExtra("title", mVar.t(map, "name")));
                        return;
                    }
                    break;
                case 110354812:
                    if (t4.equals("tice3")) {
                        i.f23368a.b(fragmentActivity, map);
                        return;
                    }
                    break;
                case 854407579:
                    if (t4.equals("appRunRecord")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, V3RecordListActivity.class).putExtra("title", mVar.t(map, "name")));
                        return;
                    }
                    break;
                case 1272599731:
                    if (t4.equals("app_home_menu_more")) {
                        if (fragmentActivity instanceof MainActivity) {
                            ((MainActivity) fragmentActivity).R();
                            return;
                        }
                        return;
                    }
                    break;
                case 1471997269:
                    if (t4.equals("appRunKey")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, V3SportsHomeActivity.class).putExtra("title", mVar.t(map, "name")));
                        return;
                    }
                    break;
                case 1619344274:
                    if (t4.equals("aboutKey")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, AboutUsActivity.class).putExtra("title", t3));
                        return;
                    }
                    break;
            }
            if (TextUtils.isEmpty(mVar.t(map, "linkUrl"))) {
                ContextExtKt.r(fragmentActivity, "\u6682\u672a\u5f00\u901a\u6b64\u6743\u9650");
            } else {
                i.f23368a.b(fragmentActivity, map);
            }
        }

        public final void b(@NotNull FragmentActivity mContext, @NotNull Map<String, ? extends Object> menu, @NotNull String menuType) {
            f0.p(mContext, "mContext");
            f0.p(menu, "menu");
            f0.p(menuType, "menuType");
            com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
            if (f0.g(mVar.t(menu, "isEnabled"), "1")) {
                if (mVar.d(menu, "isLogin") && !com.bxkj.base.v2.data.a.f18673h.a().G()) {
                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
                    return;
                } else {
                    a(menu, mContext);
                    return;
                }
            }
            ContextExtKt.r(mContext, "\u6682\u672a\u5f00\u901a\u6b64\u6743\u9650");
        }
    }
}
