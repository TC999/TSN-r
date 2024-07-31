package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class EventListener {

    /* renamed from: a */
    public static final EventListener f1351a = new C1073a();

    /* compiled from: EventListener.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1073a extends EventListener {
        C1073a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventListener.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1074b implements InterfaceC1075c {
        C1074b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener.InterfaceC1075c
        /* renamed from: a */
        public EventListener mo58346a(Call call) {
            return EventListener.this;
        }
    }

    /* compiled from: EventListener.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1075c {
        /* renamed from: a */
        EventListener mo58346a(Call call);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static InterfaceC1075c m58355a(EventListener eventListener) {
        return new C1074b();
    }

    /* renamed from: a */
    public void m58367a(Call call) {
    }

    /* renamed from: a */
    public void m58366a(Call call, long j) {
    }

    /* renamed from: a */
    public void m58365a(Call call, Response response) {
    }

    /* renamed from: a */
    public void m58364a(Call call, Connection connection) {
    }

    /* renamed from: a */
    public void m58363a(Call call, Handshake handshake) {
    }

    /* renamed from: a */
    public void m58362a(Call call, Request request) {
    }

    /* renamed from: a */
    public void m58361a(Call call, IOException iOException) {
    }

    /* renamed from: a */
    public void m58360a(Call call, String str) {
    }

    /* renamed from: a */
    public void m58359a(Call call, String str, List<InetAddress> list) {
    }

    /* renamed from: a */
    public void m58358a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    /* renamed from: a */
    public void m58357a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    /* renamed from: a */
    public void m58356a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    /* renamed from: b */
    public void m58354b(Call call) {
    }

    /* renamed from: b */
    public void m58353b(Call call, long j) {
    }

    /* renamed from: b */
    public void m58352b(Call call, Connection connection) {
    }

    /* renamed from: c */
    public void m58351c(Call call) {
    }

    /* renamed from: d */
    public void m58350d(Call call) {
    }

    /* renamed from: e */
    public void m58349e(Call call) {
    }

    /* renamed from: f */
    public void m58348f(Call call) {
    }

    /* renamed from: g */
    public void m58347g(Call call) {
    }
}
