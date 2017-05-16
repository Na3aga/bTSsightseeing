package whitechurchapplication.sig.mvp.view;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import whitechurchapplication.sig.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlaceViewHolder> {


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

    public RVAdapter(List<Place> places,Context context) {
        this.places = places;
        this.context = context;
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
        public void onBindViewHolder(PlaceViewHolder placeViewHolder, int i) {
        placeViewHolder.placeName.setText(places.get(i).name);
        placeViewHolder.placeInfo.setText(places.get(i).info);
        Picasso.with(context).load(places.get(i).photoId).into(placeViewHolder.placePhoto);

    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
