package com.bxkj.student.p094v2.common.utils;

import com.baidu.mobads.sdk.internal.C2573a;
import com.bxkj.student.C4215R;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/o;", "", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.o */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface SportsType {
    @NotNull

    /* renamed from: a */
    public static final C5549a f20137a = C5549a.f20143a;

    /* renamed from: b */
    public static final int f20138b = -1;

    /* renamed from: c */
    public static final int f20139c = 0;

    /* renamed from: d */
    public static final int f20140d = 1;

    /* renamed from: e */
    public static final int f20141e = 2;

    /* renamed from: f */
    public static final int f20142f = 5;

    /* compiled from: SportsType.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0019"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/o$a;", "", "", "sportsType", "", "d", "", "sportsTypeStr", "c", C2573a.f8443b, "a", "h", "i", "e", "g", "f", "b", "I", "OTHER", "FREE", "SUNSHINE", "MORNING", "EXERCISE_SITE", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.o$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5549a {

        /* renamed from: a */
        static final /* synthetic */ C5549a f20143a = new C5549a();

        /* renamed from: b */
        public static final int f20144b = -1;

        /* renamed from: c */
        public static final int f20145c = 0;

        /* renamed from: d */
        public static final int f20146d = 1;

        /* renamed from: e */
        public static final int f20147e = 2;

        /* renamed from: f */
        public static final int f20148f = 5;

        private C5549a() {
        }

        /* renamed from: a */
        public final int m39063a(@Nullable CharSequence charSequence) {
            return C14342f0.m8193g(charSequence, "早操跑") ? C4215R.C4217color.v3_tab_color1 : (!C14342f0.m8193g(charSequence, "阳光跑") && C14342f0.m8193g(charSequence, "自由跑")) ? C4215R.C4217color.v3_tab_color3 : C4215R.C4217color.v3_tab_color2;
        }

        /* renamed from: b */
        public final int m39062b(int i) {
            return i != 0 ? (i == 1 || i != 2) ? C4215R.mipmap.v3_icon_record_sunshine : C4215R.mipmap.v3_icon_record_morning : C4215R.mipmap.v3_icon_record_free;
        }

        /* renamed from: c */
        public final int m39061c(@Nullable CharSequence charSequence) {
            if (C14342f0.m8193g(charSequence, "早操跑")) {
                return 2;
            }
            if (C14342f0.m8193g(charSequence, "阳光跑")) {
                return 1;
            }
            if (C14342f0.m8193g(charSequence, "自由跑")) {
                return 0;
            }
            return C14342f0.m8193g(charSequence, "场地锻炼") ? 5 : 1;
        }

        @NotNull
        /* renamed from: d */
        public final String m39060d(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 5 ? "非法进入 " : "场地锻炼" : "早操跑" : "阳光跑" : "自由跑";
        }

        /* renamed from: e */
        public final int m39059e(@Nullable CharSequence charSequence) {
            return C14342f0.m8193g(charSequence, "早操跑") ? C4215R.mipmap.v3_sports_location_description1 : (!C14342f0.m8193g(charSequence, "阳光跑") && C14342f0.m8193g(charSequence, "自由跑")) ? C4215R.mipmap.v3_sports_location_description3 : C4215R.mipmap.v3_sports_location_description2;
        }

        /* renamed from: f */
        public final int m39058f(@Nullable CharSequence charSequence) {
            return C14342f0.m8193g(charSequence, "早操跑") ? C4215R.mipmap.v3_sports_location_permission1 : (!C14342f0.m8193g(charSequence, "阳光跑") && C14342f0.m8193g(charSequence, "自由跑")) ? C4215R.mipmap.v3_sports_location_permission3 : C4215R.mipmap.v3_sports_location_permission2;
        }

        /* renamed from: g */
        public final int m39057g(@Nullable CharSequence charSequence) {
            return C14342f0.m8193g(charSequence, "早操跑") ? C4215R.mipmap.v3_sports_location_start1 : (!C14342f0.m8193g(charSequence, "阳光跑") && C14342f0.m8193g(charSequence, "自由跑")) ? C4215R.mipmap.v3_sports_location_start3 : C4215R.mipmap.v3_sports_location_start2;
        }

        /* renamed from: h */
        public final int m39056h(@Nullable CharSequence charSequence) {
            return C14342f0.m8193g(charSequence, "早操跑") ? C4215R.mipmap.v3_sports_location_mark1 : (!C14342f0.m8193g(charSequence, "阳光跑") && C14342f0.m8193g(charSequence, "自由跑")) ? C4215R.mipmap.v3_sports_location_mark3 : C4215R.mipmap.v3_sports_location_mark2;
        }

        /* renamed from: i */
        public final int m39055i(@Nullable CharSequence charSequence) {
            return C14342f0.m8193g(charSequence, "早操跑") ? C4215R.C4217color.v3_location_color1 : (!C14342f0.m8193g(charSequence, "阳光跑") && C14342f0.m8193g(charSequence, "自由跑")) ? C4215R.C4217color.v3_location_color3 : C4215R.C4217color.v3_location_color2;
        }
    }
}
