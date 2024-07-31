package com.bxkj.student.life.info;

import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.List;
import java.util.Map;

/* renamed from: com.bxkj.student.life.info.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InfoMultiSupport implements InterfaceC1125a<Map<String, Object>> {
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
    /* renamed from: b */
    public int mo40464b(int itemType) {
        return itemType == 1 ? C4215R.C4221layout.item_for_info_list1 : itemType == 2 ? C4215R.C4221layout.item_for_info_list2 : C4215R.C4221layout.item_for_info_list;
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
    /* renamed from: c */
    public int mo40465a(int position, Map<String, Object> stringObjectMap) {
        List list = JsonParse.getList(stringObjectMap, "titleImg", String.class);
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
