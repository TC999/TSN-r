package com.bxkj.student.run.app.exam;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.ViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.o;
import kotlin.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: QuestionVieModel.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR)\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR/\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00120\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0003\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/bxkj/student/run/app/exam/QuestionVieModel;", "Landroidx/lifecycle/ViewModel;", "", "a", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "checkId", "Landroidx/databinding/ObservableArrayMap;", "", "", "Lkotlin/o;", "c", "()Landroidx/databinding/ObservableArrayMap;", "data", "Landroidx/databinding/ObservableArrayList;", "", "()Landroidx/databinding/ObservableArrayList;", "answer", "", "d", "Z", "()Z", "f", "(Z)V", "isShowRightAnswer", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class QuestionVieModel extends ViewModel {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Integer f22341a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final o f22342b = q.c(b.f22346a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final o f22343c = q.c(a.f22345a);

    /* renamed from: d  reason: collision with root package name */
    private boolean f22344d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: QuestionVieModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, d2 = {"Landroidx/databinding/ObservableArrayList;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l1.a<ObservableArrayList<Map<String, ? extends Object>>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22345a = new a();

        a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final ObservableArrayList<Map<String, Object>> invoke() {
            return new ObservableArrayList<>();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: QuestionVieModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"Landroidx/databinding/ObservableArrayMap;", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends Lambda implements l1.a<ObservableArrayMap<String, Object>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f22346a = new b();

        b() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final ObservableArrayMap<String, Object> invoke() {
            return new ObservableArrayMap<>();
        }
    }

    @NotNull
    public final ObservableArrayList<Map<String, Object>> a() {
        return (ObservableArrayList) this.f22343c.getValue();
    }

    @Nullable
    public final Integer b() {
        return this.f22341a;
    }

    @NotNull
    public final ObservableArrayMap<String, Object> c() {
        return (ObservableArrayMap) this.f22342b.getValue();
    }

    public final boolean d() {
        return this.f22344d;
    }

    public final void e(@Nullable Integer num) {
        this.f22341a = num;
    }

    public final void f(boolean z3) {
        this.f22344d = z3;
    }
}
