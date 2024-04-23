package com.example.safesdk.sample.internal.special;

import android.app.Activity;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;

public class SpecialsBridge {
   /* public static void interstitialAdShow(InterstitialAd targetInstance, Activity activity) {
        Logger.m3600d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->interstitialAdShow(Lcom/google/android/gms/ads/interstitial/InterstitialAd;Landroid/app/Activity;)V");
        try {
            CreativeInfoManager.m3087b(C1357d.f3603k, targetInstance);
        } catch (Throwable th) {
        }
        targetInstance.show(activity);
    }

    public static void rewardedAdShow(RewardedAd targetInstance, Activity activity, OnUserEarnedRewardListener listener) {
        Logger.m3600d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->rewardedAdShow(Lcom/google/android/gms/ads/rewarded/RewardedAd;Landroid/app/Activity;Lcom/google/android/gms/ads/OnUserEarnedRewardListener;)V");
        try {
            CreativeInfoManager.m3087b(C1357d.f3603k, targetInstance);
        } catch (Throwable th) {
        }
        targetInstance.show(activity, listener);
    }
*/
    public static void appLovinAdViewRenderAd(AppLovinAdView targetInstance, AppLovinAd ad) {
        Logger.m3600d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->appLovinAdViewRenderAd(Lcom/applovin/adview/AppLovinAdView;Lcom/applovin/sdk/AppLovinAd;)V");
        try {
            Logger.m3601d("SafeDK-Special", "appLovinAdViewRenderAd started, ad: " + ad);
            AppLovinAdSize size = ad.getSize();
            if (AppLovinAdSize.INTERSTITIAL.equals(size) || AppLovinAdSize.BANNER.equals(size) || AppLovinAdSize.LEADER.equals(size)) {
                String clCode = ((AppLovinAdBase) ad).getClCode();
                BrandSafetyEvent.AdFormatType adFormatType = AppLovinAdSize.INTERSTITIAL.equals(size) ? BrandSafetyEvent.AdFormatType.INTER : BrandSafetyEvent.AdFormatType.BANNER;
                Logger.m3601d("SafeDK-Special", "appLovinAdViewRenderAd clcode:" + clCode + " ad: " + ad + " formatType: " + adFormatType);
                CreativeInfoManager.m3074a(C1357d.f3593a, "clcode=" + clCode + "&", adFormatType);
            }
        } catch (Throwable th) {
            Logger.m3601d("SafeDK-Special", "appLovinAdViewRenderAd failed");
        }
        targetInstance.renderAd(ad);
    }
}
