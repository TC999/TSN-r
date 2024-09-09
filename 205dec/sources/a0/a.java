package a0;

import com.bxkj.student.run.app.offline.RunDatabase;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.table.RunDb;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RunRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J%\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0007J-\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0007J%\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0007J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"La0/a;", "", "", "userNumber", "", "Lcom/bxkj/student/run/app/offline/table/RunDb;", "b", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "", "sportsType", "e", "(Ljava/lang/String;ILkotlin/coroutines/c;)Ljava/lang/Object;", "endTime", "uploadType", "identify", "Lkotlin/f1;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "c", "runDb", "f", "(Lcom/bxkj/student/run/app/offline/table/RunDb;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    @Nullable
    public final Object a(@NotNull String str, @NotNull c<? super f1> cVar) {
        Object h4;
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object deleteByIdentify = runDao.deleteByIdentify(str, cVar);
        h4 = b.h();
        return deleteByIdentify == h4 ? deleteByIdentify : f1.f55527a;
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull c<? super List<RunDb>> cVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getExceptionSports(str, cVar);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull c<? super List<RunDb>> cVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getLocalRecordById(str, cVar);
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull c<? super List<RunDb>> cVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getUploadFailSports(str, cVar);
    }

    @Nullable
    public final Object e(@NotNull String str, int i4, @NotNull c<? super List<RunDb>> cVar) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getUploadFailSportsByType(str, i4, cVar);
    }

    @Nullable
    public final Object f(@NotNull RunDb runDb, @NotNull c<? super f1> cVar) {
        Object h4;
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object insertRun = runDao.insertRun(new RunDb[]{runDb}, cVar);
        h4 = b.h();
        return insertRun == h4 ? insertRun : f1.f55527a;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull c<? super f1> cVar) {
        Object h4;
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object updateSports = runDao.updateSports(str, str2, str3, cVar);
        h4 = b.h();
        return updateSports == h4 ? updateSports : f1.f55527a;
    }
}
