package com.kwad.sdk.utils.p450a;

/* renamed from: com.kwad.sdk.utils.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10978a {

    /* renamed from: com.kwad.sdk.utils.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10979a extends AbstractC10988j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C10979a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        final byte mo24265Ns() {
            return (byte) 7;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static abstract class AbstractC10980b {
        int offset;

        AbstractC10980b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: Ns */
        public abstract byte mo24265Ns();
    }

    /* renamed from: com.kwad.sdk.utils.a.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10981c extends AbstractC10980b {
        boolean value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C10981c(int i, boolean z) {
            this.offset = i;
            this.value = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 1;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10982d extends AbstractC10980b {
        double value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C10982d(int i, double d) {
            this.offset = i;
            this.value = d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 5;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10983e extends AbstractC10980b {
        float value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C10983e(int i, float f) {
            this.offset = i;
            this.value = f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 3;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10984f extends AbstractC10980b {
        int value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C10984f(int i, int i2) {
            this.offset = i;
            this.value = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 2;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10985g extends AbstractC10980b {
        long value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C10985g(int i, long j) {
            this.offset = i;
            this.value = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 4;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$h */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10986h extends AbstractC10988j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C10986h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 8;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$i */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10987i extends AbstractC10988j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C10987i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.p450a.C10978a.AbstractC10980b
        /* renamed from: Ns */
        public final byte mo24265Ns() {
            return (byte) 6;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.a$j */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static abstract class AbstractC10988j extends AbstractC10980b {
        int aRl;
        boolean aRm;
        int start;
        Object value;

        AbstractC10988j(int i, int i2, Object obj, int i3, boolean z) {
            this.start = i;
            this.offset = i2;
            this.value = obj;
            this.aRl = i3;
            this.aRm = z;
        }
    }
}
