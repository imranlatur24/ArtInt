package otpex2.root.example.com.artint;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.MyViewHolder> {

    private MainActivity context;

    private String TITLE []= {"Home",
                            "Profile",
                            "My Location",
                            "About Me",
                            "Contact By",
                            "Rate Us",
                            "Networks",
                            "Business",
                            "Professionals",
                            "Exit"};
    private int IMAGES []={
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark,
                    R.drawable.bookmark};

    private int COlOR []={
            R.color.ic_profile_icon,
            R.color.ic_offer_icon,
            R.color.ic_local_offer,
            R.color.ic_support3,
            R.color.ic_support,
            R.color.ic_settings_icon,
            R.color.ic_local_offer3,
            R.color.ic_support2,
            R.color.ic_offer_icon2,
            R.color.ic_local_offer2,
           };


    private Dialog dialog1;

    public HomeMenuAdapter(MainActivity context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        int w = holder.cvCategory.getResources().getDisplayMetrics().widthPixels;
        int h = holder.cvCategory.getResources().getDisplayMetrics().heightPixels;
        holder.images.getLayoutParams().width = w/8;
        holder.images.getLayoutParams().height = w/8;
        holder.ltyCategory.getLayoutParams().height = h/5;

        holder.title.setText(TITLE[position]);
        holder.title.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        holder.title.setSelected(true);
        holder.images.setImageResource(IMAGES[position]);
        holder.ltyCategory.setBackgroundColor(context.getResources().getColor(COlOR[position]));
        holder.ltyCategory.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                switch (position)
                {
                        case 0:
                            context.startActivity(new Intent(context, SpeakActivity.class));
                        break;
                        case 1:
                            //context.startActivity(new Intent(context, OfferListingActivity.class));
                        break;
                        case 2:
                            context.startActivity(new Intent(context, Support.class));
                        break;
                        case 3:

                        break;
                        case 4:
                            //context.startActivity(new Intent(context, ProfileActivity.class));
                        break;
                        case 5:
                            //context.startActivity(new Intent(context, ChangePasswordActivity.class));
                        break;
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return IMAGES.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView images;
        public LinearLayout ltyCategory;
        public CardView cvCategory;
        public MyViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.imageView_image);
            title = (TextView) view.findViewById(R.id.textView_title);
            ltyCategory = (LinearLayout) view.findViewById(R.id.ltyCategory);
            cvCategory = (CardView) view.findViewById(R.id.cvCategory);

        }
    }
}
