package com.clj.fastble.scan;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleScanRuleConfig.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private UUID[] f36699a = null;

    /* renamed from: b  reason: collision with root package name */
    private String[] f36700b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f36701c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36702d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f36703e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f36704f = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanRuleConfig.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private UUID[] f36705a = null;

        /* renamed from: b  reason: collision with root package name */
        private String[] f36706b = null;

        /* renamed from: c  reason: collision with root package name */
        private String f36707c = null;

        /* renamed from: d  reason: collision with root package name */
        private boolean f36708d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f36709e = false;

        /* renamed from: f  reason: collision with root package name */
        private long f36710f = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

        void a(b bVar) {
            bVar.f36699a = this.f36705a;
            bVar.f36700b = this.f36706b;
            bVar.f36701c = this.f36707c;
            bVar.f36702d = this.f36708d;
            bVar.f36703e = this.f36709e;
            bVar.f36704f = this.f36710f;
        }

        public b b() {
            b bVar = new b();
            a(bVar);
            return bVar;
        }

        public a c(boolean z3) {
            this.f36708d = z3;
            return this;
        }

        public a d(String str) {
            this.f36707c = str;
            return this;
        }

        public a e(boolean z3, String... strArr) {
            this.f36709e = z3;
            this.f36706b = strArr;
            return this;
        }

        public a f(long j4) {
            this.f36710f = j4;
            return this;
        }

        public a g(UUID[] uuidArr) {
            this.f36705a = uuidArr;
            return this;
        }
    }

    public String g() {
        return this.f36701c;
    }

    public String[] h() {
        return this.f36700b;
    }

    public long i() {
        return this.f36704f;
    }

    public UUID[] j() {
        return this.f36699a;
    }

    public boolean k() {
        return this.f36702d;
    }

    public boolean l() {
        return this.f36703e;
    }
}
