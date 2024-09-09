package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: WebSocketListener.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0017"}, d2 = {"Lokhttp3/WebSocketListener;", "", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "Lkotlin/f1;", "onOpen", "", "text", "onMessage", "Lokio/ByteString;", "bytes", "", "code", "reason", "onClosing", "onClosed", "", "t", "onFailure", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class WebSocketListener {
    public void onClosed(@NotNull WebSocket webSocket, int i4, @NotNull String reason) {
        f0.p(webSocket, "webSocket");
        f0.p(reason, "reason");
    }

    public void onClosing(@NotNull WebSocket webSocket, int i4, @NotNull String reason) {
        f0.p(webSocket, "webSocket");
        f0.p(reason, "reason");
    }

    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t3, @Nullable Response response) {
        f0.p(webSocket, "webSocket");
        f0.p(t3, "t");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        f0.p(webSocket, "webSocket");
        f0.p(text, "text");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        f0.p(webSocket, "webSocket");
        f0.p(bytes, "bytes");
    }

    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        f0.p(webSocket, "webSocket");
        f0.p(response, "response");
    }
}
