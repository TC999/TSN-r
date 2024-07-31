package com.bxkj.student.run.app.exam;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.ViewModel;
import java.util.Map;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: QuestionVieModel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR)\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR/\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0003\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m12616d2 = {"Lcom/bxkj/student/run/app/exam/QuestionVieModel;", "Landroidx/lifecycle/ViewModel;", "", "a", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "checkId", "Landroidx/databinding/ObservableArrayMap;", "", "", "Lkotlin/o;", "c", "()Landroidx/databinding/ObservableArrayMap;", "data", "Landroidx/databinding/ObservableArrayList;", "", "()Landroidx/databinding/ObservableArrayList;", "answer", "", "d", "Z", "()Z", "f", "(Z)V", "isShowRightAnswer", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class QuestionVieModel extends ViewModel {
    @Nullable

    /* renamed from: a */
    private Integer f19095a;
    @NotNull

    /* renamed from: b */
    private final InterfaceC14378o f19096b;
    @NotNull

    /* renamed from: c */
    private final InterfaceC14378o f19097c;

    /* renamed from: d */
    private boolean f19098d;

    /* compiled from: QuestionVieModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, m12616d2 = {"Landroidx/databinding/ObservableArrayList;", "", "", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.exam.QuestionVieModel$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5225a extends Lambda implements InterfaceC15269a<ObservableArrayList<Map<String, ? extends Object>>> {

        /* renamed from: a */
        public static final C5225a f19099a = new C5225a();

        C5225a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final ObservableArrayList<Map<String, Object>> invoke() {
            return new ObservableArrayList<>();
        }
    }

    /* compiled from: QuestionVieModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, m12616d2 = {"Landroidx/databinding/ObservableArrayMap;", "", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.exam.QuestionVieModel$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5226b extends Lambda implements InterfaceC15269a<ObservableArrayMap<String, Object>> {

        /* renamed from: a */
        public static final C5226b f19100a = new C5226b();

        C5226b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final ObservableArrayMap<String, Object> invoke() {
            return new ObservableArrayMap<>();
        }
    }

    public QuestionVieModel() {
        InterfaceC14378o m7719c;
        InterfaceC14378o m7719c2;
        m7719c = C14389r.m7719c(C5226b.f19100a);
        this.f19096b = m7719c;
        m7719c2 = C14389r.m7719c(C5225a.f19099a);
        this.f19097c = m7719c2;
    }

    @NotNull
    /* renamed from: a */
    public final ObservableArrayList<Map<String, Object>> m40060a() {
        return (ObservableArrayList) this.f19097c.getValue();
    }

    @Nullable
    /* renamed from: b */
    public final Integer m40059b() {
        return this.f19095a;
    }

    @NotNull
    /* renamed from: c */
    public final ObservableArrayMap<String, Object> m40058c() {
        return (ObservableArrayMap) this.f19096b.getValue();
    }

    /* renamed from: d */
    public final boolean m40057d() {
        return this.f19098d;
    }

    /* renamed from: e */
    public final void m40056e(@Nullable Integer num) {
        this.f19095a = num;
    }

    /* renamed from: f */
    public final void m40055f(boolean z) {
        this.f19098d = z;
    }
}
