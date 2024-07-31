package p581d0;

import android.content.Context;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bxkj.student.run.app.utils.VoiceSpeaker;
import com.clj.fastble.BleManager;
import com.orhanobut.logger.C11792j;
import com.tencent.bugly.BUGLY;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections._Arrays;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Ld0/a;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: d0.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class VoiceUtils {
    @NotNull

    /* renamed from: a */
    public static final C13571a f40105a = new C13571a(null);

    /* compiled from: VoiceUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00020\u0004\"\u00020\u0005J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u0011"}, m12616d2 = {"Ld0/a$a;", "", "Landroid/content/Context;", "mContext", "", "", "raw", "Lkotlin/f1;", "b", "", "tempTime", "", "tempDistance", "countStep", "a", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: d0.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C13571a {
        private C13571a() {
        }

        public /* synthetic */ C13571a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final void m12843a(@NotNull Context mContext, long j, double d, int i) {
            List m6471T4;
            List m6471T42;
            C14342f0.m8184p(mContext, "mContext");
            int m43655g = LoggedInUser.f15182b.m43634a().m43655g();
            if (m43655g == 3 || j == 0) {
                return;
            }
            if (j > 216000000) {
                C11792j.m20469d("超过60个小时，无法语音播报", new Object[0]);
            } else if (d > 60000.0d) {
                C11792j.m20469d("超过60Km，无法语音播报", new Object[0]);
            } else {
                long j2 = 60;
                if (m43655g != 0) {
                    if (m43655g == 1) {
                        j2 = 120;
                    } else if (m43655g == 2) {
                        j2 = 300;
                    }
                }
                if (j % j2 == 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf((int) C4215R.raw.dingdong));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.active_for));
                    if (JsonGet.f15134a.m43769k(SportsDataAgent.f19899a.m39250v(), "runType") != 5) {
                        String formatDistance = FormatUtils.m39634c(d);
                        C14342f0.m8185o(formatDistance, "formatDistance");
                        m6471T42 = C14579x.m6471T4(formatDistance, new String[]{"."}, false, 0, 6, null);
                        Object[] array = m6471T42.toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(Integer.parseInt(strArr[0]))), "raw", mContext.getApplicationInfo().packageName)));
                            String str = strArr[1];
                            if (!C14342f0.m8193g("0", str)) {
                                arrayList.add(Integer.valueOf((int) C4215R.raw.dot));
                                if (str != null) {
                                    char[] charArray = str.toCharArray();
                                    C14342f0.m8185o(charArray, "(this as java.lang.String).toCharArray()");
                                    int length = charArray.length;
                                    int i2 = 0;
                                    while (i2 < length) {
                                        char c = charArray[i2];
                                        i2++;
                                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", String.valueOf(c)), "raw", mContext.getApplicationInfo().packageName)));
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            arrayList.add(Integer.valueOf((int) C4215R.raw.kilometer));
                            int i3 = (i / BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH) % 10;
                            if (i3 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(i3)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(Integer.valueOf((int) C4215R.raw.f16023s));
                            }
                            int i4 = (i / BleManager.f22896l) % 10;
                            if (i4 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(i4)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(Integer.valueOf((int) C4215R.raw.f16024w));
                            } else if (i3 > 0) {
                                arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                            }
                            int i5 = (i / 1000) % 10;
                            if (i5 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(i5)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(Integer.valueOf((int) C4215R.raw.f16022k));
                            } else if (i4 > 0) {
                                arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                            }
                            int i6 = (i / 100) % 10;
                            if (i6 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(i6)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(Integer.valueOf((int) C4215R.raw.f16020b));
                            } else if (i5 > 0) {
                                arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                            }
                            int i7 = (i / 10) % 10;
                            if (i7 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(i7)), "raw", mContext.getApplicationInfo().packageName)));
                                arrayList.add(Integer.valueOf((int) C4215R.raw.f16023s));
                            } else if (i6 > 0) {
                                arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                            }
                            int i8 = (i / 1) % 10;
                            if (i8 > 0) {
                                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(i8)), "raw", mContext.getApplicationInfo().packageName)));
                            }
                            if (i > 0 && arrayList.size() > 0 && ((Number) arrayList.get(arrayList.size() - 1)).intValue() == 2131755036) {
                                arrayList.remove(arrayList.size() - 1);
                            } else if (i == 0) {
                                arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                            }
                            arrayList.add(Integer.valueOf((int) C4215R.raw.step));
                            C11792j.m20469d("文字=" + i3 + (char) 21313 + i4 + (char) 19975 + i5 + (char) 21315 + i6 + (char) 30334 + i7 + (char) 21313 + i8 + (char) 20010, new Object[0]);
                            arrayList.add(Integer.valueOf((int) C4215R.raw.duration));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    String formatTime = FormatUtils.m39630g(j);
                    C14342f0.m8185o(formatTime, "formatTime");
                    m6471T4 = C14579x.m6471T4(formatTime, new String[]{":"}, false, 0, 6, null);
                    Object[] array2 = m6471T4.toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        int parseInt = Integer.parseInt(strArr2[0]);
                        if (parseInt > 0) {
                            arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(parseInt)), "raw", mContext.getApplicationInfo().packageName)));
                            arrayList.add(Integer.valueOf((int) C4215R.raw.hour));
                        }
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier(C14342f0.m8216C("num_", Integer.valueOf(Integer.parseInt(strArr2[1]))), "raw", mContext.getApplicationInfo().packageName)));
                        arrayList.add(Integer.valueOf((int) C4215R.raw.minute));
                        VoiceSpeaker.m39665e().m39656n(mContext, arrayList);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
        }

        /* renamed from: b */
        public final void m12842b(@NotNull Context mContext, @NotNull int... raw) {
            List<Integer> m10543cy;
            C14342f0.m8184p(mContext, "mContext");
            C14342f0.m8184p(raw, "raw");
            VoiceSpeaker m39665e = VoiceSpeaker.m39665e();
            m10543cy = _Arrays.m10543cy(raw);
            m39665e.m39656n(mContext, m10543cy);
        }
    }
}
