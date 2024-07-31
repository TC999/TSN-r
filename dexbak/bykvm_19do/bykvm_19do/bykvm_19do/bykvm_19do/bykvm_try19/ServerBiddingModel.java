package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ServerBiddingModel {

    /* renamed from: a */
    private String f528a;

    /* renamed from: b */
    private ServerBiddingWinner f529b;

    /* renamed from: c */
    private C0972a f530c;

    /* compiled from: ServerBiddingModel.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.e$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0972a {

        /* renamed from: a */
        private String f531a;

        /* renamed from: b */
        private List<WaterFallConfig> f532b = new ArrayList();

        /* renamed from: a */
        public void m59503a(String str) {
            this.f531a = str;
        }

        /* renamed from: a */
        public void m59502a(List<WaterFallConfig> list) {
            this.f532b = list;
        }
    }

    /* renamed from: a */
    public String m59513a() {
        return this.f528a;
    }

    /* renamed from: a */
    public void m59512a(C0972a c0972a) {
        this.f530c = c0972a;
    }

    /* renamed from: a */
    public void m59511a(ServerBiddingWinner serverBiddingWinner) {
        this.f529b = serverBiddingWinner;
    }

    /* renamed from: a */
    public void m59510a(String str) {
    }

    /* renamed from: b */
    public List<WaterFallConfig> m59509b() {
        C0972a c0972a = this.f530c;
        if (c0972a == null) {
            return null;
        }
        return c0972a.f532b;
    }

    /* renamed from: b */
    public void m59508b(String str) {
        this.f528a = str;
    }

    /* renamed from: c */
    public ServerBiddingWinner m59507c() {
        return this.f529b;
    }

    /* renamed from: c */
    public void m59506c(String str) {
    }

    /* renamed from: d */
    public boolean m59505d() {
        C0972a c0972a = this.f530c;
        return (c0972a == null || TextUtils.isEmpty(c0972a.f531a)) ? false : true;
    }
}
