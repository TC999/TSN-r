package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public interface m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f1195a = new a();

    /* compiled from: PushObserver.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a implements m {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.m
        public void a(int i4, b bVar) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.m
        public boolean a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i5, boolean z3) throws IOException {
            eVar.skip(i5);
            return true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.m
        public boolean a(int i4, List<c> list) {
            return true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.m
        public boolean a(int i4, List<c> list, boolean z3) {
            return true;
        }
    }

    void a(int i4, b bVar);

    boolean a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i5, boolean z3) throws IOException;

    boolean a(int i4, List<c> list);

    boolean a(int i4, List<c> list, boolean z3);
}
