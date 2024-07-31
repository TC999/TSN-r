package com.bxkj.student.run.app.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: SharedViewModel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/run/app/livedata/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "b", "Landroidx/lifecycle/LiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "mutableLiveData", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SharedViewModel extends ViewModel {
    @NotNull

    /* renamed from: a */
    private MutableLiveData<String> f19161a = new MutableLiveData<>();

    @NotNull
    /* renamed from: a */
    public final LiveData<String> m39999a() {
        return this.f19161a;
    }

    /* renamed from: b */
    public final void m39998b(@NotNull String value) {
        C14342f0.m8184p(value, "value");
        this.f19161a.setValue(value);
    }
}
