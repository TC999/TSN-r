package p012a0;

import com.bxkj.student.run.app.offline.RunDatabase;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.table.RunDb;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007J-\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J%\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0007J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m12616d2 = {"La0/a;", "", "", "userNumber", "", "Lcom/bxkj/student/run/app/offline/table/RunDb;", "b", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "", "sportsType", "e", "(Ljava/lang/String;ILkotlin/coroutines/c;)Ljava/lang/Object;", "endTime", "uploadType", "identify", "Lkotlin/f1;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "c", "runDb", "f", "(Lcom/bxkj/student/run/app/offline/table/RunDb;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: a0.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RunRepository {
    @Nullable
    /* renamed from: a */
    public final Object m60054a(@NotNull String str, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object deleteByIdentify = runDao.deleteByIdentify(str, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return deleteByIdentify == m8642h ? deleteByIdentify : Unit.f41048a;
    }

    @Nullable
    /* renamed from: b */
    public final Object m60053b(@NotNull String str, @NotNull InterfaceC14268c<? super List<RunDb>> interfaceC14268c) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getExceptionSports(str, interfaceC14268c);
    }

    @Nullable
    /* renamed from: c */
    public final Object m60052c(@NotNull String str, @NotNull InterfaceC14268c<? super List<RunDb>> interfaceC14268c) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getLocalRecordById(str, interfaceC14268c);
    }

    @Nullable
    /* renamed from: d */
    public final Object m60051d(@NotNull String str, @NotNull InterfaceC14268c<? super List<RunDb>> interfaceC14268c) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getUploadFailSports(str, interfaceC14268c);
    }

    @Nullable
    /* renamed from: e */
    public final Object m60050e(@NotNull String str, int i, @NotNull InterfaceC14268c<? super List<RunDb>> interfaceC14268c) {
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        return runDao.getUploadFailSportsByType(str, i, interfaceC14268c);
    }

    @Nullable
    /* renamed from: f */
    public final Object m60049f(@NotNull RunDb runDb, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object insertRun = runDao.insertRun(new RunDb[]{runDb}, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return insertRun == m8642h ? insertRun : Unit.f41048a;
    }

    @Nullable
    /* renamed from: g */
    public final Object m60048g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        RunDao runDao = RunDatabase.Companion.getInstance().runDao();
        if (runDao == null) {
            return null;
        }
        Object updateSports = runDao.updateSports(str, str2, str3, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return updateSports == m8642h ? updateSports : Unit.f41048a;
    }
}
