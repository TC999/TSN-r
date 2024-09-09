package com.bxkj.student.v2.common.utils;

import com.bxkj.student.R;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsType.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bxkj/student/v2/common/utils/p;", "", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface p {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23388a = a.f23394a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23389b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23390c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f23391d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f23392e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f23393f = 5;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsType.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/bxkj/student/v2/common/utils/p$a;", "", "", "sportsType", "", "d", "", "sportsTypeStr", "c", "text", "a", "h", "i", "e", "g", "f", "b", "I", "OTHER", "FREE", "SUNSHINE", "MORNING", "EXERCISE_SITE", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f23394a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final int f23395b = -1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f23396c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static final int f23397d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static final int f23398e = 2;

        /* renamed from: f  reason: collision with root package name */
        public static final int f23399f = 5;

        private a() {
        }

        public final int a(@Nullable CharSequence charSequence) {
            return f0.g(charSequence, "\u65e9\u64cd\u8dd1") ? R.color.v3_tab_color1 : (!f0.g(charSequence, "\u9633\u5149\u8dd1") && f0.g(charSequence, "\u81ea\u7531\u8dd1")) ? R.color.v3_tab_color3 : R.color.v3_tab_color2;
        }

        public final int b(int i4) {
            if (i4 != 0) {
                return (i4 == 1 || i4 != 2) ? 2131559172 : 2131559171;
            }
            return 2131559170;
        }

        public final int c(@Nullable CharSequence charSequence) {
            if (f0.g(charSequence, "\u65e9\u64cd\u8dd1")) {
                return 2;
            }
            if (f0.g(charSequence, "\u9633\u5149\u8dd1")) {
                return 1;
            }
            if (f0.g(charSequence, "\u81ea\u7531\u8dd1")) {
                return 0;
            }
            return f0.g(charSequence, "\u573a\u5730\u953b\u70bc") ? 5 : 1;
        }

        @NotNull
        public final String d(int i4) {
            return i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 5 ? "\u975e\u6cd5\u8fdb\u5165 " : "\u573a\u5730\u953b\u70bc" : "\u65e9\u64cd\u8dd1" : "\u9633\u5149\u8dd1" : "\u81ea\u7531\u8dd1";
        }

        public final int e(@Nullable CharSequence charSequence) {
            if (f0.g(charSequence, "\u65e9\u64cd\u8dd1")) {
                return 2131559187;
            }
            return (!f0.g(charSequence, "\u9633\u5149\u8dd1") && f0.g(charSequence, "\u81ea\u7531\u8dd1")) ? 2131559189 : 2131559188;
        }

        public final int f(@Nullable CharSequence charSequence) {
            if (f0.g(charSequence, "\u65e9\u64cd\u8dd1")) {
                return 2131559193;
            }
            return (!f0.g(charSequence, "\u9633\u5149\u8dd1") && f0.g(charSequence, "\u81ea\u7531\u8dd1")) ? 2131559195 : 2131559194;
        }

        public final int g(@Nullable CharSequence charSequence) {
            if (f0.g(charSequence, "\u65e9\u64cd\u8dd1")) {
                return 2131559196;
            }
            return (!f0.g(charSequence, "\u9633\u5149\u8dd1") && f0.g(charSequence, "\u81ea\u7531\u8dd1")) ? 2131559198 : 2131559197;
        }

        public final int h(@Nullable CharSequence charSequence) {
            if (f0.g(charSequence, "\u65e9\u64cd\u8dd1")) {
                return 2131559190;
            }
            return (!f0.g(charSequence, "\u9633\u5149\u8dd1") && f0.g(charSequence, "\u81ea\u7531\u8dd1")) ? 2131559192 : 2131559191;
        }

        public final int i(@Nullable CharSequence charSequence) {
            return f0.g(charSequence, "\u65e9\u64cd\u8dd1") ? R.color.v3_location_color1 : (!f0.g(charSequence, "\u9633\u5149\u8dd1") && f0.g(charSequence, "\u81ea\u7531\u8dd1")) ? R.color.v3_location_color3 : R.color.v3_location_color2;
        }
    }
}
