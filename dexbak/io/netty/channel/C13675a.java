package io.netty.channel;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: R8$$SyntheticClass */
/* renamed from: io.netty.channel.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final /* synthetic */ class C13675a {
    /* renamed from: a */
    public static /* synthetic */ boolean m12692a(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
