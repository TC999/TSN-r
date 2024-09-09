package defpackage;

import io.github.libxposed.api.XposedInterface;
import java.lang.reflect.Member;

/* renamed from: a0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1340a0 implements XposedInterface.BeforeHookCallback, XposedInterface.AfterHookCallback {

    /* renamed from: a  reason: collision with root package name */
    public Member f98a;

    /* renamed from: b  reason: collision with root package name */
    public Object f99b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f100c;

    /* renamed from: d  reason: collision with root package name */
    public Object f101d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f102e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f103f;

    @Override // io.github.libxposed.api.XposedInterface.BeforeHookCallback, io.github.libxposed.api.XposedInterface.AfterHookCallback
    public Object[] getArgs() {
        return this.f100c;
    }

    @Override // io.github.libxposed.api.XposedInterface.BeforeHookCallback, io.github.libxposed.api.XposedInterface.AfterHookCallback
    public Member getMember() {
        return this.f98a;
    }

    @Override // io.github.libxposed.api.XposedInterface.AfterHookCallback
    public Object getResult() {
        return this.f101d;
    }

    @Override // io.github.libxposed.api.XposedInterface.BeforeHookCallback, io.github.libxposed.api.XposedInterface.AfterHookCallback
    public Object getThisObject() {
        return this.f99b;
    }

    @Override // io.github.libxposed.api.XposedInterface.AfterHookCallback
    public Throwable getThrowable() {
        return this.f102e;
    }

    @Override // io.github.libxposed.api.XposedInterface.AfterHookCallback
    public boolean isSkipped() {
        return this.f103f;
    }

    @Override // io.github.libxposed.api.XposedInterface.BeforeHookCallback
    public void returnAndSkip(Object obj) {
        this.f101d = obj;
        this.f102e = null;
        this.f103f = true;
    }

    @Override // io.github.libxposed.api.XposedInterface.AfterHookCallback
    public void setResult(Object obj) {
        this.f101d = obj;
        this.f102e = null;
    }

    @Override // io.github.libxposed.api.XposedInterface.AfterHookCallback
    public void setThrowable(Throwable th) {
        this.f101d = null;
        this.f102e = th;
    }

    @Override // io.github.libxposed.api.XposedInterface.BeforeHookCallback
    public void throwAndSkip(Throwable th) {
        this.f101d = null;
        this.f102e = th;
        this.f103f = true;
    }
}
