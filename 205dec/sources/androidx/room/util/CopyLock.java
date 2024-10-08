package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CopyLock {
    private static final Map<String, Lock> sThreadLocks = new HashMap();
    private final File mCopyLockFile;
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final Lock mThreadLock;

    public CopyLock(@NonNull String name, @NonNull File lockDir, boolean processLock) {
        File file = new File(lockDir, name + ".lck");
        this.mCopyLockFile = file;
        this.mThreadLock = getThreadLock(file.getAbsolutePath());
        this.mFileLevelLock = processLock;
    }

    private static Lock getThreadLock(String key) {
        Lock lock;
        Map<String, Lock> map = sThreadLocks;
        synchronized (map) {
            lock = map.get(key);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(key, lock);
            }
        }
        return lock;
    }

    public void lock() {
        this.mThreadLock.lock();
        if (this.mFileLevelLock) {
            try {
                FileChannel channel = new FileOutputStream(this.mCopyLockFile).getChannel();
                this.mLockChannel = channel;
                channel.lock();
            } catch (IOException e4) {
                throw new IllegalStateException("Unable to grab copy lock.", e4);
            }
        }
    }

    public void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.mThreadLock.unlock();
    }
}
