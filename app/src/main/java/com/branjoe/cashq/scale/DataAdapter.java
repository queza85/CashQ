package com.branjoe.cashq.scale;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.branjoe.cashq.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context context;
    private int width;
    public DataAdapter(Context context, int width) {
        this.context = context;
        this.width = width;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int pos);
    }

    int[] banners = new int[]{
            R.drawable.banner01,
            R.drawable.banner02,
            R.drawable.banner03,
            R.drawable.banner04
    };

    int[] ads = new int[]{
            R.drawable.ad_01,
            R.drawable.ad_02,
            R.drawable.ad_03,
            R.drawable.ad_04,
            R.drawable.ad_05,
            R.drawable.ad_06,
            R.drawable.ad_07,
            R.drawable.ad_08,
            R.drawable.ad_09,
            R.drawable.ad_10,
            R.drawable.ad_11,
    };

    String[] titles = new String[]{
            "Cents-off deal",
            "Price-pack/Bonus packs deal",
            "Mobile couponing",
            "Online interactive promotion game",
            "Contests/sweepstakes/games",
            "PICK THE RIGHT TIME",
            "Tesco New Year Promotion (valid until 1 January 2019)",
            "Panasonic Malaysia - Promotions and Events",
            "Chinese New Year Promo - News | SDAC Ford Malaysia",
            "Panasonic Air Conditioners Malaysia",
            "Air Conditioner Rewards"
    };

    String[] descs = new String[]{
            "Offers a brand at a lower price. Price reduction may be a percentage marked on the package.",
            "The packaging offers a consumer a certain percentage more of the product for the same price (for example, 25 percent extra). This is another type of deal “in which customers are offered more of the product for the same price”.[2] For example, a sales company may offer their consumers a bonus pack in which they can receive two products for the price of one. In these scenarios, this bonus pack is framed as a gain because buyers believe that they are obtaining a free product.[2] The purchase of a bonus pack, however, is not always beneficial for the consumer. Sometimes consumers will end up spending money on an item they would not normally buy had it not been in a bonus pack. As a result, items bought in a bonus pack are often wasted and is viewed as a “loss” for the consumer.",
            "Coupons are available on a mobile phone. Consumers show the offer on a mobile phone to a salesperson for redemption.",
            "Consumers play an interactive game associated with the promoted product.",
            "The consumer is automatically entered into the event by purchasing the product.",
            "If you’re trying to get promoted within a year of starting your current role, you’re already bucking convention on timing. So pay careful attention to other factors that can help make the context of your request seem more natural. Know what’s happening around you–both inside the company and out. How is your business doing? What about the industry?",
            "Tesco Malaysia New Year Promotion valid until 1 January 2018. Get the latest promotion from Tesco",
            "Let your patriotic pride shine through with Panasonic, your trusted partner for the home of your dreams. Promotion valid till 30 September 2018.",
            "For starters, new Ford Ranger XLT owners can drive home the feature-packed truck with extended ZERO maintenance costs for five years or 100,000km1. Valid from now until February 28, 2018, the consumer-first promotion includes rebates up to RM5,000, shopping vouchers and exclusive, limited-edition angpow packets.",
            "Experience cool comfort inspired by nature brought into your home by Panasonic SKY and NEW AERO Series.",
            "CELEBRATE WITH PANASONIC‘Tis the season to be merry! Turn on the festive cheer and celebrate with the ones you love. Whether you are serving up a feast, hosting overnight guests or just entertaining at home, celebrations are made easy with Panasonic."
    };

    public OnItemClickListener onItemClickListener;

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ad, parent, false));
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        if(position <= (banners.length-1)) {
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(holder.ivBanner);
            Glide.with(context).load(banners[position]).into(gifImage);

            holder.lvBannerWrapper.setVisibility(View.VISIBLE);
            holder.lvAdWrapper.setVisibility(View.GONE);
//            holder.lvWrapper.setLayoutParams(new FrameLayout.LayoutParams(width, 500));
        } else {
            int newPos = position-banners.length;
            holder.lvBannerWrapper.setVisibility(View.GONE);
            holder.lvAdWrapper.setVisibility(View.VISIBLE);
//            holder.lvWrapper.setLayoutParams(new FrameLayout.LayoutParams(width, 100));

            holder.ivAd.setImageResource(ads[newPos]);
            holder.tvTitle.setText(titles[newPos]);
            holder.tvDesc.setText(descs[newPos]);
        }
    }

    @Override
    public int getItemCount() {
        return ads.length + banners.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBanner, ivAd;
        CardView lvBannerWrapper;
        LinearLayout lvWrapper, lvAdWrapper;
        TextView tvTitle;
        TextView tvDesc;
        ViewHolder(View itemView) {
            super(itemView);

//            lvWrapper = itemView.findViewById(R.id.lv_wrapper);
            lvBannerWrapper = itemView.findViewById(R.id.lv_banner_wrapper);
            ivBanner = itemView.findViewById(R.id.iv_banner);
            lvAdWrapper = itemView.findViewById(R.id.lv_ad_wrapper);
            ivAd = itemView.findViewById(R.id.iv_ad);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
