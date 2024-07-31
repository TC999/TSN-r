package com.bxkj.student.p094v2.common.utils;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.p098ui.LoginActivity;
import com.bxkj.student.p094v2.p098ui.MainActivity;
import com.bxkj.student.p094v2.p098ui.p101my.AboutUsActivity;
import com.bxkj.student.p094v2.p098ui.p101my.MyQRCodeActivity;
import com.bxkj.student.p094v2.p098ui.p101my.ScanQrCodeActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.V3RecordListActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.set.V3StatisticsActivity;
import com.bxkj.student.p094v2.p098ui.sports.set.SportsRankActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/j;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.j */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MenuOnclick {
    @NotNull

    /* renamed from: a */
    public static final C5545a f20125a = new C5545a(null);

    /* compiled from: MenuOnclick.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\b\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J,\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\t\u001a\u00020\u0003¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/j$a;", "", "", "", "menu", "Landroidx/fragment/app/FragmentActivity;", "mContext", "Lkotlin/f1;", "a", "menuType", "b", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.j$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5545a {
        private C5545a() {
        }

        public /* synthetic */ C5545a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        private final void m39074a(Map<String, ? extends Object> map, FragmentActivity fragmentActivity) {
            JsonGet jsonGet = JsonGet.f15134a;
            String m43760t = jsonGet.m43760t(map, "name");
            String m43760t2 = jsonGet.m43760t(map, "mkey");
            switch (m43760t2.hashCode()) {
                case -1612520458:
                    if (m43760t2.equals("appRunRank")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, SportsRankActivity.class).putExtra("title", jsonGet.m43760t(map, "name")));
                        return;
                    }
                    break;
                case -1554031739:
                    if (m43760t2.equals("myQrCodeKey")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, MyQRCodeActivity.class).putExtra("title", m43760t));
                        return;
                    }
                    break;
                case -1181718421:
                    if (m43760t2.equals("scanQRCode")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, ScanQrCodeActivity.class));
                        return;
                    }
                    break;
                case -286799507:
                    if (m43760t2.equals("appRunStatistics")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, V3StatisticsActivity.class).putExtra("title", jsonGet.m43760t(map, "name")));
                        return;
                    }
                    break;
                case 110354812:
                    if (m43760t2.equals("tice3")) {
                        H5Utils.f20124a.m39075b(fragmentActivity, map);
                        return;
                    }
                    break;
                case 854407579:
                    if (m43760t2.equals("appRunRecord")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, V3RecordListActivity.class).putExtra("title", jsonGet.m43760t(map, "name")));
                        return;
                    }
                    break;
                case 1272599731:
                    if (m43760t2.equals("app_home_menu_more")) {
                        if (fragmentActivity instanceof MainActivity) {
                            ((MainActivity) fragmentActivity).m38870S();
                            return;
                        }
                        return;
                    }
                    break;
                case 1471997269:
                    if (m43760t2.equals("appRunKey")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, V3SportsHomeActivity.class).putExtra("title", jsonGet.m43760t(map, "name")));
                        return;
                    }
                    break;
                case 1619344274:
                    if (m43760t2.equals("aboutKey")) {
                        fragmentActivity.startActivity(new Intent(fragmentActivity, AboutUsActivity.class).putExtra("title", m43760t));
                        return;
                    }
                    break;
            }
            if (TextUtils.isEmpty(jsonGet.m43760t(map, "linkUrl"))) {
                ContextExt.m43846r(fragmentActivity, "暂未开通此权限");
            } else {
                H5Utils.f20124a.m39075b(fragmentActivity, map);
            }
        }

        /* renamed from: b */
        public final void m39073b(@NotNull FragmentActivity mContext, @NotNull Map<String, ? extends Object> menu, @NotNull String menuType) {
            C14342f0.m8184p(mContext, "mContext");
            C14342f0.m8184p(menu, "menu");
            C14342f0.m8184p(menuType, "menuType");
            JsonGet jsonGet = JsonGet.f15134a;
            if (C14342f0.m8193g(jsonGet.m43760t(menu, "isEnabled"), "1")) {
                if (jsonGet.m43776d(menu, "isLogin") && !LoggedInUser.f15182b.m43634a().m43637y()) {
                    mContext.startActivity(new Intent(mContext, LoginActivity.class));
                    return;
                } else {
                    m39074a(menu, mContext);
                    return;
                }
            }
            ContextExt.m43846r(mContext, "暂未开通此权限");
        }
    }
}
