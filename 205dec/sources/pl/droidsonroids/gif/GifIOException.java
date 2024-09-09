package pl.droidsonroids.gif;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;
    @NonNull
    public final GifError reason;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifIOException(int i4, String str) {
        this.reason = GifError.fromCode(i4);
        this.mErrnoMessage = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifIOException fromCode(int i4) {
        if (i4 == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i4, null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        return this.reason.getFormattedDescription() + ": " + this.mErrnoMessage;
    }
}
