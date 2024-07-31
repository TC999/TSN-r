package com.bxkj.student.home;

import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.p088db.HomeMenuDB;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bxkj.student.home.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HomeMenu {

    /* renamed from: b */
    private static volatile HomeMenu f16318b;

    /* renamed from: a */
    private final String f16319a = "groupType";

    private HomeMenu() {
    }

    /* renamed from: a */
    private List<Map<String, Object>> m42721a() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "理论考试");
        arrayMap.put(RewardPlus.ICON, "icon_1_7");
        arrayMap.put("type", 2);
        arrayMap.put("groupType", -1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "查看点名");
        arrayMap2.put(RewardPlus.ICON, "icon_1_3");
        arrayMap2.put("type", 2);
        arrayMap2.put("groupType", -1);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "查看" + LoginUser.getLoginUser().getViewAfterLabelName());
        arrayMap3.put(RewardPlus.ICON, "icon_1_1");
        arrayMap3.put("type", 2);
        arrayMap3.put("groupType", -1);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "上课请假");
        arrayMap4.put(RewardPlus.ICON, "icon_1_5");
        arrayMap4.put("type", 2);
        arrayMap4.put("groupType", -1);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "App跑步");
        arrayMap5.put(RewardPlus.ICON, "icon_4_1");
        arrayMap5.put("type", 2);
        arrayMap5.put("groupType", -1);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "预约场馆");
        arrayMap6.put(RewardPlus.ICON, "icon_5_1");
        arrayMap6.put("type", 2);
        arrayMap6.put("groupType", -1);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "体测计算器");
        arrayMap7.put(RewardPlus.ICON, "icon_2_7");
        arrayMap7.put("type", 2);
        arrayMap7.put("groupType", -1);
        arrayList.add(arrayMap7);
        return arrayList;
    }

    /* renamed from: b */
    public static HomeMenu m42720b() {
        if (f16318b == null) {
            synchronized (HomeMenu.class) {
                if (f16318b == null) {
                    f16318b = new HomeMenu();
                }
            }
        }
        return f16318b;
    }

    /* renamed from: d */
    private List<Map<String, Object>> m42718d() {
        ArrayList arrayList = new ArrayList();
        List<HomeMenuDB> query = SQLiteDbUtil.m57474h().query(HomeMenuDB.class);
        if (query != null) {
            for (HomeMenuDB homeMenuDB : query) {
                if (LoginUser.getLoginUser().getIsOpenKeep() != 0 || !homeMenuDB.getMenuName().equals("绑定Keep账号")) {
                    if (LoginUser.getLoginUser().getIsOpenKeep() != 0 || !homeMenuDB.getMenuName().equals("同步Keep数据")) {
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

    /* renamed from: c */
    public List<Map<String, Object>> m42719c() {
        List<Map<String, Object>> m42718d = m42718d();
        return m42718d.size() == 0 ? m42721a() : m42718d;
    }
}
