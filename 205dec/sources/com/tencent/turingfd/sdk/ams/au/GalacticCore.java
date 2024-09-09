package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedList;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class GalacticCore<E> {

    /* renamed from: a  reason: collision with root package name */
    public final int f52065a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<E> f52066b = new LinkedList<>();

    public GalacticCore(int i4) {
        this.f52065a = i4;
    }

    public void a(E e4) {
        if (this.f52066b.size() >= this.f52065a) {
            this.f52066b.poll();
        }
        this.f52066b.offer(e4);
    }
}
