package com.bxkj.student.home;

import androidx.collection.ArrayMap;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.db.HomeMenuDB;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HomeMenu.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f19708b;

    /* renamed from: a  reason: collision with root package name */
    private final String f19709a = "groupType";

    private a() {
    }

    private List<Map<String, Object>> a() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u7406\u8bba\u8003\u8bd5");
        arrayMap.put(RewardPlus.ICON, "icon_1_7");
        arrayMap.put("type", 2);
        arrayMap.put("groupType", -1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u67e5\u770b\u70b9\u540d");
        arrayMap2.put(RewardPlus.ICON, "icon_1_3");
        arrayMap2.put("type", 2);
        arrayMap2.put("groupType", -1);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName());
        arrayMap3.put(RewardPlus.ICON, "icon_1_1");
        arrayMap3.put("type", 2);
        arrayMap3.put("groupType", -1);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "\u4e0a\u8bfe\u8bf7\u5047");
        arrayMap4.put(RewardPlus.ICON, "icon_1_5");
        arrayMap4.put("type", 2);
        arrayMap4.put("groupType", -1);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "App\u8dd1\u6b65");
        arrayMap5.put(RewardPlus.ICON, "icon_4_1");
        arrayMap5.put("type", 2);
        arrayMap5.put("groupType", -1);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "\u9884\u7ea6\u573a\u9986");
        arrayMap6.put(RewardPlus.ICON, "icon_5_1");
        arrayMap6.put("type", 2);
        arrayMap6.put("groupType", -1);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "\u4f53\u6d4b\u8ba1\u7b97\u5668");
        arrayMap7.put(RewardPlus.ICON, "icon_2_7");
        arrayMap7.put("type", 2);
        arrayMap7.put("groupType", -1);
        arrayList.add(arrayMap7);
        return arrayList;
    }

    public static a b() {
        if (f19708b == null) {
            synchronized (a.class) {
                if (f19708b == null) {
                    f19708b = new a();
                }
            }
        }
        return f19708b;
    }

    private List<Map<String, Object>> d() {
        ArrayList arrayList = new ArrayList();
        List<HomeMenuDB> query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(HomeMenuDB.class);
        if (query != null) {
            for (HomeMenuDB homeMenuDB : query) {
                if (LoginUser.getLoginUser().getIsOpenKeep() != 0 || !homeMenuDB.getMenuName().equals("\u7ed1\u5b9aKeep\u8d26\u53f7")) {
                    if (LoginUser.getLoginUser().getIsOpenKeep() != 0 || !homeMenuDB.getMenuName().equals("\u540c\u6b65Keep\u6570\u636e")) {
                        ArrayMap arrayMap = new ArrayMap();
                        arrayMap.put("name", homeMenuDB.getMenuName());
                        arrayMap.put(RewardPlus.ICON, homeMenuDB.getIconResName());
                        arrayMap.put("type", 2);
                        arrayMap.put("groupType", -1);
                        arrayList.add(arrayMap);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<Map<String, Object>> c() {
        List<Map<String, Object>> d4 = d();
        return d4.size() == 0 ? a() : d4;
    }
}
