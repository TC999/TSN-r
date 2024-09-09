package com.kwad.sdk.utils.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwad.sdk.utils.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class C0721a extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0721a(int i4, int i5, Object obj, int i6, boolean z3) {
            super(i4, i5, obj, i6, z3);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Ns() {
            return (byte) 7;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static abstract class b {
        int offset;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract byte Ns();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class c extends b {
        boolean value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i4, boolean z3) {
            this.offset = i4;
            this.value = z3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class d extends b {
        double value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(int i4, double d4) {
            this.offset = i4;
            this.value = d4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 5;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class e extends b {
        float value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i4, float f4) {
            this.offset = i4;
            this.value = f4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class f extends b {
        int value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i4, int i5) {
            this.offset = i4;
            this.value = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class g extends b {
        long value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i4, long j4) {
            this.offset = i4;
            this.value = j4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class h extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public h(int i4, int i5, Object obj, int i6, boolean z3) {
            super(i4, i5, obj, i6, z3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 8;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class i extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i4, int i5, String str, int i6, boolean z3) {
            super(i4, i5, str, i6, z3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Ns() {
            return (byte) 6;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static abstract class j extends b {
        int aRl;
        boolean aRm;
        int start;
        Object value;

        j(int i4, int i5, Object obj, int i6, boolean z3) {
            this.start = i4;
            this.offset = i5;
            this.value = obj;
            this.aRl = i6;
            this.aRm = z3;
        }
    }
}
