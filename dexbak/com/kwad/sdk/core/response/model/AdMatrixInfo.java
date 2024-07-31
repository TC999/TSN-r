package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdMatrixInfo extends C10482a implements Serializable {
    private static final long serialVersionUID = -1399297421861223421L;
    public Styles styles = new Styles();
    public AdDataV2 adDataV2 = new AdDataV2();
    public List<MatrixTag> tag = new ArrayList();

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ActionBarInfoNew extends BaseMatrixTemplate {
        private static final long serialVersionUID = -2897900789505229105L;
        public int cardType;
        public long maxTimeOut;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ActivityMiddlePageInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -7126817779477974119L;
        public boolean showHeaderBar;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class AdDataV2 extends C10482a implements Serializable {
        private static final long serialVersionUID = -8017805390945915342L;
        public List<TemplateData> templateDataList = new ArrayList();
        public BottomBannerInfo bottomBannerInfo = new BottomBannerInfo();
        public ActionBarInfoNew actionBarInfo = new ActionBarInfoNew();
        public AggregationCardInfo aggregationCardInfo = new AggregationCardInfo();
        public BaseMatrixTemplate halfCardInfo = new BaseMatrixTemplate();
        public EndCardInfo endCardInfo = new EndCardInfo();
        public InterstitialCardInfo interstitialCardInfo = new InterstitialCardInfo();
        public FeedInfo feedInfo = new FeedInfo();
        public FeedTKInfo feedTKCardInfo = new FeedTKInfo();
        public FeedInfo adUnionFeedLiveMediaInfo = new FeedInfo();
        public FeedInfo adUnionFeedLiveTemplateInfo = new FeedInfo();
        public BaseMatrixTemplate complianceCardInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate downloadConfirmCardInfo = new BaseMatrixTemplate();
        public SplashInfo splashInfo = new SplashInfo();
        public NeoVideoInfo neoVideoInfo = new NeoVideoInfo();
        public FullScreenInfo fullScreenInfo = new FullScreenInfo();
        public BaseMatrixTemplate middleTKCardInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate actionBarTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate topBarTKInfo = new BaseMatrixTemplate();
        public SplashPlayCardTKInfo splashPlayCardTKInfo = new SplashPlayCardTKInfo();
        public SplashEndCardTKInfo splashEndCardTKInfo = new SplashEndCardTKInfo();
        public TopFloorTKInfo topFloorTKInfo = new TopFloorTKInfo();
        public ActivityMiddlePageInfo activityMiddlePageInfo = new ActivityMiddlePageInfo();
        public BaseMatrixTemplate confirmTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate playendTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate activityTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate neoTKInfo = new BaseMatrixTemplate();
        public RewardVideoInteractInfo rewardVideoInteractInfo = new RewardVideoInteractInfo();
        public RewardVideoTaskInfo rewardVideoTaskInfo = new RewardVideoTaskInfo();
        public RewardWebTaskCloseInfo rewardWebTaskCloseInfo = new RewardWebTaskCloseInfo();
        public MerchantLiveReservationInfo merchantLiveReservationInfo = new MerchantLiveReservationInfo();
        public PushTKInfo pushTKInfo = new PushTKInfo();
        public BaseMatrixTemplate splashActionBarInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate videoLiveTKInfo = new BaseMatrixTemplate();
        public PreLandingPageTKInfo preLandingPageTKInfo = new PreLandingPageTKInfo();
        public InstalledActivateInfo installedActivateInfo = new InstalledActivateInfo();
        public BaseMatrixTemplate videoImageTKInfo = new BaseMatrixTemplate();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class AdInteractionInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -8105791433429537031L;
        public int interactiveStyle;
        public int interactivityDefaultStyle;
        public boolean isMediaDisable;
        public long switchDefaultTime;
        public long tkDefaultTimeout;
        public ShakeInfo shakeInfo = new ShakeInfo();
        public RotateInfo rotateInfo = new RotateInfo();
        public SplashSlideInfo slideInfo = new SplashSlideInfo();
        public SplashActionBarInfo splashActionBarInfo = new SplashActionBarInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class AggregationCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6065340139053228242L;
        public int changeTime;
        public long intervalTime;
        public int maxTimesPerDay;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class BaseMatrixTemplate extends C10482a implements Serializable {
        private static final long serialVersionUID = 3594661163877934414L;
        public int renderType;
        public String templateId;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class BottomBannerInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 9099955467009566699L;
        public int bannerAdType;
        public int bannerSizeType;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class CycleAggregateInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 3365726199254620321L;
        public String convertIconUrl;
        public String cutIconUrl;
        public String refreshIconUrl;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class DownloadTexts extends C10482a implements Serializable {
        private static final long serialVersionUID = -4102977044762642151L;
        public String adActionDescription;
        public String installAppLabel;
        public String openAppLabel;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class EndCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1534468715847534303L;
        public int cardShowPlayCount;
        public int cardType;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class FeedInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -299328228771513399L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class FeedTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -7328588644194532249L;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class FullScreenInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class InstalledActivateInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -959583814667849237L;
        public boolean cardSwitch;
        public long showTime;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class InterstitialCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -5881505827627373593L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
        public CycleAggregateInfo cycleAggregateInfo = new CycleAggregateInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class MatrixTag extends C10482a implements Serializable {
        public boolean isHide;
        public int styleId;
        public String type;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class MatrixTemplate extends BaseMatrixTemplate {
        private static final long serialVersionUID = 1943039524913069727L;
        public String templateMd5;
        public String templateUrl;
        public String templateVersion;
        public long templateVersionCode;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class MerchantLiveReservationInfo extends BaseMatrixTemplate implements Serializable {
        private static final int MIN_COUNT = 50;
        private static final long serialVersionUID = -6879010521415024815L;
        public int bookUserCount;
        public List<String> bookUserUrlList;
        public boolean displayBookCount;
        public boolean displayWeakCard;
        public String liveStartTime;
        public LiveReservationPlayEndInfo playEndCard;
        public String title;
        public String userHeadUrl;

        @KsJson
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class LiveReservationPlayEndInfo extends C10482a implements Serializable {
            private static final long serialVersionUID = 1682477964084325954L;
            public String detailBtnTitle = "查看详情";
            public String reservationBtnTitle = "立即预约";
        }

        @Nullable
        public String getFormattedLiveSubscribeCount() {
            int i = this.bookUserCount;
            if (i < 50) {
                return null;
            }
            if (i < 10000) {
                return this.bookUserCount + "人";
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            return decimalFormat.format(this.bookUserCount / 10000.0f) + "万人";
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.liveStartTime) && TextUtils.isEmpty(this.userHeadUrl);
        }

        public boolean needShowSubscriberCount() {
            return this.displayBookCount && this.bookUserCount >= 50;
        }
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class NeoVideoInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class PreLandingPageTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -6610860492486529913L;
        public int preLandingPageShowType = 1;

        public boolean isPlayEndShow() {
            int i = this.preLandingPageShowType;
            return i == 2 || i == 1;
        }

        public boolean isSkipShow() {
            int i = this.preLandingPageShowType;
            return i == 3 || i == 1;
        }
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class PushTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1907990715102735992L;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RewardVideoInteractInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 8875349394489272055L;
        public int dayMaxLimit;
        public int duration;
        public String errorMsg;
        public int intervalShow;
        public int rewardTime;
        public int showTime;
        public int style;
        public StyleInfo styleInfo = new StyleInfo();
        public String successfulMsg;
        public String templateId;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RewardVideoTaskInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 2487245975856269581L;
        public int duration;
        public int showTime;
        public int taskType;
        public String templateId;
        public int thresholdTime;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RewardWebTaskCloseInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -2697443981301300766L;
        public String templateId;
        public int webConfirmCardType;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RotateDegreeInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 64198654819103772L;
        public int direction;
        public int rotateDegree;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RotateInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -237926423883960071L;
        public String subTitle;
        public String title;
        public DownloadTexts downloadTexts = new DownloadTexts();

        /* renamed from: x */
        public RotateDegreeInfo f29582x = new RotateDegreeInfo();

        /* renamed from: y */
        public RotateDegreeInfo f29583y = new RotateDegreeInfo();

        /* renamed from: z */
        public RotateDegreeInfo f29584z = new RotateDegreeInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ShakeInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 4528782399998808588L;
        public int acceleration;
        public boolean clickDisabled;
        public int componentIndex;
        public String subtitle;
        public String title;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SplashActionBarInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -8978521089375262615L;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public String title;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SplashEndCardTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 3536091976265473949L;
        public int endCardCountDaily;
        public boolean endCardFullScreenClick;
        public boolean endCardShowCountDown;
        public int endCardShowSecond;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SplashInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 240426032769377332L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SplashPlayCardTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 2182484890680464601L;
        public int tkTimeout;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class SplashSlideInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -6853322623324615011L;
        public int convertDistance;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public int style;
        public String subtitle;
        public String title;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class StyleInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 7597936730431611526L;
        public String title;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class Styles extends C10482a implements Serializable {
        private static final long serialVersionUID = 1713930699658485883L;
        public List<MatrixTemplate> templateList = new ArrayList();
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class TemplateData extends BaseMatrixTemplate {
        private static final long serialVersionUID = -3330357033837521996L;
        public String data;
        public long templateDelayTime;
        public long templateShowTime;
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class TopFloorTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 341571719184500541L;
    }
}
