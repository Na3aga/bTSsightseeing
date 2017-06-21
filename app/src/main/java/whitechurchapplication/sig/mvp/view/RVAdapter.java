package whitechurchapplication.sig.mvp.view;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import java.util.List;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.view.detailView.DetailInfoActivity;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlaceViewHolder> {

    Picasso mPicasso;
    private final int CACHE_SIZE = 50000000;
    Context context;
    public static class PlaceViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView placeName;
        TextView placeInfo;
        ImageView placePhoto;


        PlaceViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            placeName = (TextView) itemView.findViewById(R.id.place_name);
            placeInfo = (TextView) itemView.findViewById(R.id.place_info);
            placePhoto = (ImageView) itemView.findViewById(R.id.place_photo);




        }
    }



    List<Place> places;

    public RVAdapter(List<Place> places, Context context) {
        this.places = places;
        this.context = context;
        mPicasso = new Picasso.Builder(context).memoryCache(new LruCache(CACHE_SIZE)).build();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new PlaceViewHolder(v);
    }

    @Override
        public void onBindViewHolder(PlaceViewHolder placeViewHolder, final int i) {
        placeViewHolder.placeName.setText(places.get(i).name);
        placeViewHolder.placeInfo.setText(places.get(i).info);

        int padding_in_dp = 10;  // 10 dps
        final float scale = context.getResources().getDisplayMetrics().density;
        int padding_in_px = (int) (padding_in_dp * scale + 0.5f);
        int padding_in_px_top = (int) ((padding_in_dp-2) * scale + 0.5f);

        if (places.get(i).info != "") {
            placeViewHolder.placeInfo.setPadding(padding_in_px,padding_in_px_top,padding_in_px,padding_in_px);
        }else {
            placeViewHolder.placeInfo.setPadding(0,0,0,0);
            placeViewHolder.placeName.setPadding(0,0,0,0);
        }
        placeViewHolder.cv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailInfoActivity.class);
                intent.putExtra("placeId",places.get(i).getId());
                ((Activity) context).startActivity(intent);
            }
        });
        placeViewHolder.placePhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mPicasso.with(context).load(places.get(i).getImgUrl()).into(placeViewHolder.placePhoto);


    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
