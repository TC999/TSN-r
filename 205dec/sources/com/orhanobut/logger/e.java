package com.orhanobut.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DiskLogStrategy.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e implements h {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Handler f41369a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: DiskLogStrategy.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class a extends Handler {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f41370a;

        /* renamed from: b  reason: collision with root package name */
        private final int f41371b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(@NonNull Looper looper, @NonNull String str, int i4) {
            super((Looper) n.a(looper));
            this.f41370a = (String) n.a(str);
            this.f41371b = i4;
        }

        private File a(@NonNull String str, @NonNull String str2) {
            File file;
            n.a(str);
            n.a(str2);
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = null;
            File file4 = new File(file2, String.format("%s_%s.csv", str2, 0));
            int i4 = 0;
            while (true) {
                File file5 = file4;
                file = file3;
                file3 = file5;
                if (!file3.exists()) {
                    break;
                }
                i4++;
                file4 = new File(file2, String.format("%s_%s.csv", str2, Integer.valueOf(i4)));
            }
            return (file == null || file.length() >= ((long) this.f41371b)) ? file3 : file;
        }

        private void b(@NonNull FileWriter fileWriter, @NonNull String str) throws IOException {
            n.a(fileWriter);
            n.a(str);
            fileWriter.append((CharSequence) str);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            String str = (String) message.obj;
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(a(this.f41370a, "logs"), true);
                try {
                    b(fileWriter2, str);
                    fileWriter2.flush();
                    fileWriter2.close();
                } catch (IOException unused) {
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.flush();
                            fileWriter.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            } catch (IOException unused3) {
            }
        }
    }

    public e(@NonNull Handler handler) {
        this.f41369a = (Handler) n.a(handler);
    }

    @Override // com.orhanobut.logger.h
    public void a(int i4, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        Handler handler = this.f41369a;
        handler.sendMessage(handler.obtainMessage(i4, str2));
    }
}
