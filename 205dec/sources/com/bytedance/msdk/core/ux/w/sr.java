package com.bytedance.msdk.core.ux.w;

import android.content.Context;
import com.bytedance.msdk.core.k.p;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends xv {

    /* renamed from: c  reason: collision with root package name */
    private int f28227c;

    /* renamed from: w  reason: collision with root package name */
    private int f28228w;

    /* JADX INFO: Access modifiers changed from: protected */
    public sr(Context context, String str, int i4) {
        super(context, str, i4);
        this.f28227c = 0;
        this.f28228w = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.f, com.bytedance.msdk.core.r.ux, com.bytedance.msdk.core.r.xv
    public void c(int i4, boolean z3) {
        try {
            c(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.c(i4, z3);
    }

    public int f() {
        return this.f28227c;
    }

    private void c(int i4) {
        Integer num;
        Map<Integer, List<p>> map;
        List<p> list;
        if (i4 > this.f28228w) {
            this.f28228w = i4;
            List<Integer> list2 = this.ia;
            if (list2 == null || i4 >= list2.size() || (num = this.ia.get(i4)) == null || (map = this.ev) == null || !map.containsKey(num) || (list = this.ev.get(num)) == null) {
                return;
            }
            this.f28227c += list.size();
        }
    }
}
