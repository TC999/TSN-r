package d0;

import android.content.Context;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.data.c;
import com.orhanobut.logger.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.p;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: VoiceUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Ld0/a;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C1075a f54621a = new C1075a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: VoiceUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00020\u0004\"\u00020\u0005J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005\u00a8\u0006\u0011"}, d2 = {"Ld0/a$a;", "", "Landroid/content/Context;", "mContext", "", "", "raw", "Lkotlin/f1;", "b", "", "tempTime", "", "tempDistance", "countStep", "a", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: d0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C1075a {
        private C1075a() {
        }

        public /* synthetic */ C1075a(u uVar) {
            this();
        }

        public final void a(@NotNull Context mContext, long j4, double d4, int i4) {
            List T4;
            List T42;
            f0.p(mContext, "mContext");
            int j5 = com.bxkj.base.v2.data.a.f18673h.a().j();
            if (j5 == 3 || j4 == 0) {
                return;
            }
            if (j4 > 216000000) {
                j.d("\u8d85\u8fc760\u4e2a\u5c0f\u65f6\uff0c\u65e0\u6cd5\u8bed\u97f3\u64ad\u62a5", new Object[0]);
            } else if (d4 > 60000.0d) {
                j.d("\u8d85\u8fc760Km\uff0c\u65e0\u6cd5\u8bed\u97f3\u64ad\u62a5", new Object[0]);
            } else {
                long j6 = 60;
                if (j5 != 0) {
                    if (j5 == 1) {
                        j6 = 120;
                    } else if (j5 == 2) {
                        j6 = 300;
                    }
                }
                if (j4 % j6 == 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(2131755015);
                    arrayList.add(2131755008);
                    if (m.a.k(c.f23133a.v(), "runType") != 5) {
                        String formatDistance = i.c(d4);
                        f0.o(formatDistance, "formatDistance");
                        T42 = x.T4(formatDistance, new String[]{"."}, false, 0, 6, null);
                        Object[] array = T42.toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(Integer.parseInt(strArr[0]))), "raw", mContext.getApplicationInfo().packageName)));
                            String str = strArr[1];
                            if (!f0.g("0", str)) {
                                arrayList.add(2131755016);
                                char[] charArray = str.toCharArray();
                                f0.o(charArray, "this as java.lang.String).toCharArray()");
                                int length = charArray.length;
                                int i5 = 0;
                                while (i5 < length) {
                                    char c4 = charArray[i5];
                                    i5++;
                                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", String.valueOf(c4)), "raw", mContext.getApplicationInfo().packageName)));
                                }
                            }
                            arrayList.add(2131755027);
                            int i6 = (i4 / 100000) % 10;
                            if (i6 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(i6)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(2131755100);
                            }
                            int i7 = (i4 / 10000) % 10;
                            if (i7 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(i7)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(2131755109);
                            } else if (i6 > 0) {
                                arrayList.add(2131755036);
                            }
                            int i8 = (i4 / 1000) % 10;
                            if (i8 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(i8)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(2131755025);
                            } else if (i7 > 0) {
                                arrayList.add(2131755036);
                            }
                            int i9 = (i4 / 100) % 10;
                            if (i9 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(i9)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(2131755009);
                            } else if (i8 > 0) {
                                arrayList.add(2131755036);
                            }
                            int i10 = (i4 / 10) % 10;
                            if (i10 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(i10)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(2131755100);
                            } else if (i9 > 0) {
                                arrayList.add(2131755036);
                            }
                            int i11 = (i4 / 1) % 10;
                            if (i11 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(i11)), "raw", mContext.getApplicationInfo().packageName)));
                            }
                            if (i4 > 0 && arrayList.size() > 0 && ((Number) arrayList.get(arrayList.size() - 1)).intValue() == 2131755036) {
                                arrayList.remove(arrayList.size() - 1);
                            } else if (i4 == 0) {
                                arrayList.add(2131755036);
                            }
                            arrayList.add(2131755102);
                            j.d("\u6587\u5b57=" + i6 + '\u5341' + i7 + '\u4e07' + i8 + '\u5343' + i9 + '\u767e' + i10 + '\u5341' + i11 + '\u4e2a', new Object[0]);
                            arrayList.add(2131755017);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                    }
                    String formatTime = i.g(j4);
                    f0.o(formatTime, "formatTime");
                    T4 = x.T4(formatTime, new String[]{":"}, false, 0, 6, null);
                    Object[] array2 = T4.toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        int parseInt = Integer.parseInt(strArr2[0]);
                        if (parseInt > 0) {
                            arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(parseInt)), "raw", mContext.getApplicationInfo().packageName)));
                            arrayList.add(2131755024);
                        }
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(f0.C("num_", Integer.valueOf(Integer.parseInt(strArr2[1]))), "raw", mContext.getApplicationInfo().packageName)));
                        arrayList.add(2131755035);
                        d0.e().n(mContext, arrayList);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
        }

        public final void b(@NotNull Context mContext, @NotNull int... raw) {
            List<Integer> cy;
            f0.p(mContext, "mContext");
            f0.p(raw, "raw");
            d0 e4 = d0.e();
            cy = p.cy(raw);
            e4.n(mContext, cy);
        }
    }
}
