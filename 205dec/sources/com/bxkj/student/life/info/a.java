package com.bxkj.student.life.info;

import cn.bluemobi.dylan.http.JsonParse;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: InfoMultiSupport.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
    public int b(int itemType) {
        if (itemType == 1) {
            return 2131427704;
        }
        return itemType == 2 ? 2131427705 : 2131427703;
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
    /* renamed from: c */
    public int a(int position, Map<String, Object> stringObjectMap) {
        List list = JsonParse.getList(stringObjectMap, "titleImg", String.class);
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
