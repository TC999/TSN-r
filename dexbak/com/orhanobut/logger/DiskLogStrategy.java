package com.orhanobut.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.orhanobut.logger.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DiskLogStrategy implements LogStrategy {
    @NonNull

    /* renamed from: a */
    private final Handler f32682a;

    /* compiled from: DiskLogStrategy.java */
    /* renamed from: com.orhanobut.logger.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class HandlerC11791a extends Handler {
        @NonNull

        /* renamed from: a */
        private final String f32683a;

        /* renamed from: b */
        private final int f32684b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HandlerC11791a(@NonNull Looper looper, @NonNull String str, int i) {
            super((Looper) C11795n.m20423a(looper));
            this.f32683a = (String) C11795n.m20423a(str);
            this.f32684b = i;
        }

        /* renamed from: a */
        private File m20477a(@NonNull String str, @NonNull String str2) {
            File file;
            C11795n.m20423a(str);
            C11795n.m20423a(str2);
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = null;
            File file4 = new File(file2, String.format("%s_%s.csv", str2, 0));
            int i = 0;
            while (true) {
                File file5 = file4;
                file = file3;
                file3 = file5;
                if (!file3.exists()) {
                    break;
                }
                i++;
                file4 = new File(file2, String.format("%s_%s.csv", str2, Integer.valueOf(i)));
            }
            return (file == null || file.length() >= ((long) this.f32684b)) ? file3 : file;
        }

        /* renamed from: b */
        private void m20476b(@NonNull FileWriter fileWriter, @NonNull String str) throws IOException {
            C11795n.m20423a(fileWriter);
            C11795n.m20423a(str);
            fileWriter.append((CharSequence) str);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            String str = (String) message.obj;
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(m20477a(this.f32683a, "logs"), true);
                try {
                    m20476b(fileWriter2, str);
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

    public DiskLogStrategy(@NonNull Handler handler) {
        this.f32682a = (Handler) C11795n.m20423a(handler);
    }

    @Override // com.orhanobut.logger.LogStrategy
    /* renamed from: a */
    public void mo20473a(int i, @Nullable String str, @NonNull String str2) {
        C11795n.m20423a(str2);
        Handler handler = this.f32682a;
        handler.sendMessage(handler.obtainMessage(i, str2));
    }
}
