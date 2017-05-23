package whitechurchapplication.sig.mvp.view;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.view.detailView.DetailInfoActivity;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlaceViewHolder> {


    Context context;
    DialogInterface.OnClickListener oclBtnOk;

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView placeName;
        TextView placeInfo;
        ImageView placePhoto;
        Button button;

        PlaceViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            placeName = (TextView) itemView.findViewById(R.id.place_name);
            placeInfo = (TextView) itemView.findViewById(R.id.place_info);
            placePhoto = (ImageView) itemView.findViewById(R.id.place_photo);
            button = (Button) itemView.findViewById(R.id.cardButton);



        }
    }



    List<Place> places;

    public RVAdapter(List<Place> places, Context context) {
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
        public void onBindViewHolder(PlaceViewHolder placeViewHolder, final int i) {
        placeViewHolder.placeName.setText(places.get(i).name);
        placeViewHolder.placeInfo.setText(places.get(i).info);
        placeViewHolder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailInfoActivity.class);
                intent.putExtra("imageId",places.get(i).getPhotoId());
                intent.putExtra("placeName",places.get(i).getName());
                intent.putExtra("placeInfo",places.get(i).getInfo());
                intent.putExtra("id",places.get(i).getId());
                ((Activity) context).startActivity(intent);
            }
        });

        Picasso.with(context).load(places.get(i).photoId).into(placeViewHolder.placePhoto);


    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
