package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.v;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: WebSocketExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;
    @JvmField
    public final boolean clientNoContextTakeover;
    @JvmField
    public final boolean perMessageDeflate;
    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;
    @JvmField
    public final boolean serverNoContextTakeover;
    @JvmField
    public final boolean unknownValues;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: WebSocketExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers responseHeaders) throws IOException {
            boolean K1;
            boolean K12;
            boolean K13;
            boolean K14;
            boolean K15;
            boolean K16;
            Integer X0;
            Integer X02;
            f0.p(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z3 = false;
            Integer num = null;
            boolean z4 = false;
            Integer num2 = null;
            boolean z5 = false;
            boolean z6 = false;
            for (int i4 = 0; i4 < size; i4++) {
                K1 = w.K1(responseHeaders.name(i4), "Sec-WebSocket-Extensions", true);
                if (K1) {
                    String value = responseHeaders.value(i4);
                    int i5 = 0;
                    while (i5 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i5, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i5, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i5, delimiterOffset);
                        int i6 = delimiterOffset + 1;
                        K12 = w.K1(trimSubstring, "permessage-deflate", true);
                        if (K12) {
                            if (z3) {
                                z6 = true;
                            }
                            while (i6 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i6, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i6, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i6, delimiterOffset3);
                                String l4 = delimiterOffset3 < delimiterOffset2 ? x.l4(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"") : null;
                                int i7 = delimiterOffset2 + 1;
                                K13 = w.K1(trimSubstring2, "client_max_window_bits", true);
                                if (K13) {
                                    if (num != null) {
                                        z6 = true;
                                    }
                                    if (l4 != null) {
                                        X02 = v.X0(l4);
                                        num = X02;
                                    } else {
                                        num = null;
                                    }
                                    if (num != null) {
                                        i6 = i7;
                                    }
                                    z6 = true;
                                    i6 = i7;
                                } else {
                                    K14 = w.K1(trimSubstring2, "client_no_context_takeover", true);
                                    if (K14) {
                                        if (z4) {
                                            z6 = true;
                                        }
                                        if (l4 != null) {
                                            z6 = true;
                                        }
                                        z4 = true;
                                    } else {
                                        K15 = w.K1(trimSubstring2, "server_max_window_bits", true);
                                        if (K15) {
                                            if (num2 != null) {
                                                z6 = true;
                                            }
                                            if (l4 != null) {
                                                X0 = v.X0(l4);
                                                num2 = X0;
                                            } else {
                                                num2 = null;
                                            }
                                            if (num2 != null) {
                                            }
                                            z6 = true;
                                        } else {
                                            K16 = w.K1(trimSubstring2, "server_no_context_takeover", true);
                                            if (K16) {
                                                if (z5) {
                                                    z6 = true;
                                                }
                                                if (l4 != null) {
                                                    z6 = true;
                                                }
                                                z5 = true;
                                            }
                                            z6 = true;
                                        }
                                    }
                                    i6 = i7;
                                }
                            }
                            i5 = i6;
                            z3 = true;
                        } else {
                            i5 = i6;
                            z6 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z3, num, z4, num2, z5, z6);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z3, @Nullable Integer num, boolean z4, @Nullable Integer num2, boolean z5, boolean z6) {
        this.perMessageDeflate = z3;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z4;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z5;
        this.unknownValues = z6;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z3, Integer num, boolean z4, Integer num2, boolean z5, boolean z6, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = webSocketExtensions.perMessageDeflate;
        }
        if ((i4 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i4 & 4) != 0) {
            z4 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z7 = z4;
        if ((i4 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i4 & 16) != 0) {
            z5 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z8 = z5;
        if ((i4 & 32) != 0) {
            z6 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z3, num3, z7, num4, z8, z6);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    @Nullable
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean z3, @Nullable Integer num, boolean z4, @Nullable Integer num2, boolean z5, boolean z6) {
        return new WebSocketExtensions(z3, num, z4, num2, z5, z6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof WebSocketExtensions) {
                WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
                return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && f0.g(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && f0.g(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z3 = this.perMessageDeflate;
        ?? r02 = z3;
        if (z3) {
            r02 = 1;
        }
        int i4 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode = (i4 + (num != null ? num.hashCode() : 0)) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i5 = r22;
        if (r22 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode + i5) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int hashCode2 = (i6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i7 = r23;
        if (r23 != 0) {
            i7 = 1;
        }
        int i8 = (hashCode2 + i7) * 31;
        boolean z4 = this.unknownValues;
        return i8 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z3) {
        if (z3) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public /* synthetic */ WebSocketExtensions(boolean z3, Integer num, boolean z4, Integer num2, boolean z5, boolean z6, int i4, u uVar) {
        this((i4 & 1) != 0 ? false : z3, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? false : z4, (i4 & 8) == 0 ? num2 : null, (i4 & 16) != 0 ? false : z5, (i4 & 32) != 0 ? false : z6);
    }
}
