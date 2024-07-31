package com.bxkj.student.p094v2.common.utils;

import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.run.app.utils.PathSmoothTool;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/p;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.p */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class TestCase {
    @NotNull

    /* renamed from: a */
    public static final C5550a f20149a = new C5550a(null);

    /* compiled from: TestCase.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u0002J:\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00030\b¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/p$a;", "", "", "", "", "dataList", "Lkotlin/f1;", "b", "", "jsonToListMap", "a", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.p$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5550a {
        private C5550a() {
        }

        public /* synthetic */ C5550a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final List<Map<String, Object>> m39054a(@NotNull List<Map<String, Object>> jsonToListMap) {
            int m8957Y;
            C14342f0.m8184p(jsonToListMap, "jsonToListMap");
            new PathSmoothTool();
            m8957Y = C14236x.m8957Y(jsonToListMap, 10);
            ArrayList arrayList = new ArrayList(m8957Y);
            for (Iterator it = jsonToListMap.iterator(); it.hasNext(); it = it) {
                Map map = (Map) it.next();
                arrayList.add(new PointData(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o"), (long) JsonParse.getDouble(map, UMCommonContent.f37782aL), JsonParse.getFloat(map, "s"), JsonParse.getBoolean(map, "i"), JsonParse.getInt(map, C7304t.f25048d), JsonParse.getLong(map, "c"), JsonParse.getInt(map, "e")));
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            arrayList2.add(arrayList.get(0));
            arrayList3.add(jsonToListMap.get(0));
            PointData pointData = (PointData) arrayList.get(0);
            int size = arrayList.size();
            int i = 1;
            if (1 < size) {
                while (true) {
                    int i2 = i + 1;
                    PointData pointData2 = (PointData) arrayList.get(i);
                    if (C5543h.f20113a.m39104C(pointData, pointData2)) {
                        arrayList2.add(pointData2);
                        arrayList3.add(jsonToListMap.get(i));
                        pointData = pointData2;
                    } else {
                        C11792j.m20469d("漂移点", new Object[0]);
                    }
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList3;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0170 A[LOOP:1: B:9:0x0091->B:24:0x0170, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0178 A[EDGE_INSN: B:28:0x0178->B:25:0x0178 ?: BREAK  , SYNTHETIC] */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m39053b(@org.jetbrains.annotations.NotNull java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r23) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.common.utils.TestCase.C5550a.m39053b(java.util.List):void");
        }
    }
}
