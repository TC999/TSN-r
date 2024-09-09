package com.facebook.rebound;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SpringChain implements SpringListener {

    /* renamed from: h  reason: collision with root package name */
    private static final int f37065h = 40;

    /* renamed from: i  reason: collision with root package name */
    private static final int f37066i = 6;

    /* renamed from: j  reason: collision with root package name */
    private static final int f37067j = 70;

    /* renamed from: k  reason: collision with root package name */
    private static final int f37068k = 10;

    /* renamed from: a  reason: collision with root package name */
    private final SpringSystem f37070a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<SpringListener> f37071b;

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList<Spring> f37072c;

    /* renamed from: d  reason: collision with root package name */
    private int f37073d;

    /* renamed from: e  reason: collision with root package name */
    private final SpringConfig f37074e;

    /* renamed from: f  reason: collision with root package name */
    private final SpringConfig f37075f;

    /* renamed from: g  reason: collision with root package name */
    private static final SpringConfigRegistry f37064g = SpringConfigRegistry.c();

    /* renamed from: l  reason: collision with root package name */
    private static int f37069l = 0;

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    public static SpringChain b() {
        return new SpringChain();
    }

    public static SpringChain c(int i4, int i5, int i6, int i7) {
        return new SpringChain(i4, i5, i6, i7);
    }

    public SpringChain a(SpringListener springListener) {
        this.f37072c.add(this.f37070a.d().a(this).B(this.f37075f));
        this.f37071b.add(springListener);
        return this;
    }

    public List<Spring> d() {
        return this.f37072c;
    }

    public SpringConfig e() {
        return this.f37075f;
    }

    public Spring f() {
        return this.f37072c.get(this.f37073d);
    }

    public SpringConfig g() {
        return this.f37074e;
    }

    public SpringChain h(int i4) {
        this.f37073d = i4;
        if (this.f37072c.get(i4) == null) {
            return null;
        }
        for (Spring spring : this.f37070a.f()) {
            spring.B(this.f37075f);
        }
        f().B(this.f37074e);
        return this;
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringActivate(Spring spring) {
        this.f37071b.get(this.f37072c.indexOf(spring)).onSpringActivate(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring spring) {
        this.f37071b.get(this.f37072c.indexOf(spring)).onSpringAtRest(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringEndStateChange(Spring spring) {
        this.f37071b.get(this.f37072c.indexOf(spring)).onSpringEndStateChange(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring spring) {
        int i4;
        int i5;
        int indexOf = this.f37072c.indexOf(spring);
        SpringListener springListener = this.f37071b.get(indexOf);
        int i6 = this.f37073d;
        if (indexOf == i6) {
            i5 = indexOf - 1;
            i4 = indexOf + 1;
        } else if (indexOf < i6) {
            i5 = indexOf - 1;
            i4 = -1;
        } else {
            i4 = indexOf > i6 ? indexOf + 1 : -1;
            i5 = -1;
        }
        if (i4 > -1 && i4 < this.f37072c.size()) {
            this.f37072c.get(i4).x(spring.f());
        }
        if (i5 > -1 && i5 < this.f37072c.size()) {
            this.f37072c.get(i5).x(spring.f());
        }
        springListener.onSpringUpdate(spring);
    }

    private SpringChain(int i4, int i5, int i6, int i7) {
        this.f37070a = SpringSystem.m();
        this.f37071b = new CopyOnWriteArrayList<>();
        this.f37072c = new CopyOnWriteArrayList<>();
        this.f37073d = -1;
        SpringConfig b4 = SpringConfig.b(i4, i5);
        this.f37074e = b4;
        SpringConfig b5 = SpringConfig.b(i6, i7);
        this.f37075f = b5;
        SpringConfigRegistry springConfigRegistry = f37064g;
        StringBuilder sb = new StringBuilder();
        sb.append("main spring ");
        int i8 = f37069l;
        f37069l = i8 + 1;
        sb.append(i8);
        springConfigRegistry.a(b4, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attachment spring ");
        int i9 = f37069l;
        f37069l = i9 + 1;
        sb2.append(i9);
        springConfigRegistry.a(b5, sb2.toString());
    }
}
