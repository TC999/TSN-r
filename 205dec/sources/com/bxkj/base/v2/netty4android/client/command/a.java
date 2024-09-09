package com.bxkj.base.v2.netty4android.client.command;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Command.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/command/a;", "", "", "toString", "description", "Lkotlin/f1;", "d", "", "a", "B", "()B", "f", "(B)V", CampaignEx.JSON_KEY_BTY, "", "b", "I", "c", "()I", "h", "(I)V", "length", "Ljava/lang/String;", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "datas", "cType", "<init>", "(BILjava/lang/String;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private byte f18731a;

    /* renamed from: b  reason: collision with root package name */
    private int f18732b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f18733c;

    public a(byte b4, int i4, @NotNull String datas) {
        f0.p(datas, "datas");
        this.f18731a = b4;
        this.f18732b = i4;
        this.f18733c = datas;
    }

    public static /* synthetic */ void e(a aVar, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u547d\u4ee4\u6570\u636e\uff1a";
        }
        aVar.d(str);
    }

    public final byte a() {
        return this.f18731a;
    }

    @NotNull
    public final String b() {
        return this.f18733c;
    }

    public final int c() {
        return this.f18732b;
    }

    public final void d(@Nullable String str) {
        j.g(f0.C(str, this), new Object[0]);
    }

    public final void f(byte b4) {
        this.f18731a = b4;
    }

    public final void g(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f18733c = str;
    }

    public final void h(int i4) {
        this.f18732b = i4;
    }

    @NotNull
    public String toString() {
        return "Command{cType=" + t.a.a.b(new byte[]{this.f18731a}) + ", length=" + this.f18732b + ", datas='" + this.f18733c + "'}";
    }
}
