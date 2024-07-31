package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Address;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ConnectionPool;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ConnectionSpec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Route;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RouteDatabase;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class Internal {

    /* renamed from: a */
    public static Internal f891a;

    /* renamed from: a */
    public abstract int mo58239a(Response.C1017a c1017a);

    /* renamed from: a */
    public abstract RealConnection mo58235a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    /* renamed from: a */
    public abstract RouteDatabase mo58237a(ConnectionPool connectionPool);

    /* renamed from: a */
    public abstract Socket mo58236a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    /* renamed from: a */
    public abstract void mo58233a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    /* renamed from: a */
    public abstract void mo58232a(Headers.C1076a c1076a, String str);

    /* renamed from: a */
    public abstract void mo58231a(Headers.C1076a c1076a, String str, String str2);

    /* renamed from: a */
    public abstract boolean mo58238a(Address address, Address address2);

    /* renamed from: a */
    public abstract boolean mo58234a(ConnectionPool connectionPool, RealConnection realConnection);

    /* renamed from: b */
    public abstract void mo58230b(ConnectionPool connectionPool, RealConnection realConnection);
}
