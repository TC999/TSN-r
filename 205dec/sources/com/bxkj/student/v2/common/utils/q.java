package com.bxkj.student.v2.common.utils;

import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.v2.common.data.PointData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: TestCase.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/utils/q;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23400a = new a(null);

    /* compiled from: TestCase.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u0002J:\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00030\b\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/v2/common/utils/q$a;", "", "", "", "", "dataList", "Lkotlin/f1;", "b", "", "jsonToListMap", "a", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final List<Map<String, Object>> a(@NotNull List<Map<String, Object>> jsonToListMap) {
            int Z;
            f0.p(jsonToListMap, "jsonToListMap");
            new com.bxkj.student.run.app.utils.o();
            Z = y.Z(jsonToListMap, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (Iterator it = jsonToListMap.iterator(); it.hasNext(); it = it) {
                Map map = (Map) it.next();
                arrayList.add(new PointData(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o"), (long) JsonParse.getDouble(map, "t"), JsonParse.getFloat(map, "s"), JsonParse.getBoolean(map, "i"), JsonParse.getInt(map, "l"), JsonParse.getLong(map, "c"), JsonParse.getInt(map, "e")));
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            arrayList2.add(arrayList.get(0));
            arrayList3.add(jsonToListMap.get(0));
            PointData pointData = (PointData) arrayList.get(0);
            int size = arrayList.size();
            int i4 = 1;
            if (1 < size) {
                while (true) {
                    int i5 = i4 + 1;
                    PointData pointData2 = (PointData) arrayList.get(i4);
                    if (h.f23357a.C(pointData, pointData2)) {
                        arrayList2.add(pointData2);
                        arrayList3.add(jsonToListMap.get(i4));
                        pointData = pointData2;
                    } else {
                        com.orhanobut.logger.j.d("\u6f02\u79fb\u70b9", new Object[0]);
                    }
                    if (i5 >= size) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return arrayList3;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0171 A[LOOP:1: B:9:0x0092->B:24:0x0171, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0179 A[EDGE_INSN: B:28:0x0179->B:25:0x0179 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(@org.jetbrains.annotations.NotNull java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r23) {
            /*
                Method dump skipped, instructions count: 428
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.q.a.b(java.util.List):void");
        }
    }
}
