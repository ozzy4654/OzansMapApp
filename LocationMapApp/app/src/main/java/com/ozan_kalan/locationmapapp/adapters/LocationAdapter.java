package com.ozan_kalan.locationmapapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ozan_kalan.locationmapapp.R;
import com.ozan_kalan.locationmapapp.models.LocationModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ozan.kalan on 6/28/17.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private LocationModel[] mLocationList;

    private final LocationAdapterOnClickHandler mClickHandler;

    /** interface to be used to handle onClick diresired actions from the activity */
    public interface LocationAdapterOnClickHandler {
        void onClick(LocationModel locationModel);
    }

    public LocationAdapter(LocationAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }



    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.location_list_item, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationAdapter.LocationViewHolder holder, int position) {
        final LocationModel locationModel = mLocationList[position];

        holder.mAddress.setText(locationModel.getAddress());
        holder.mLocationName.setText(locationModel.getName());
    }

    @Override
    public int getItemCount() {
        if (mLocationList == null)
            return 0;
        return mLocationList.length;
    }

    /** this method updates the adapters data
     * @param mm*/
    public void setData(LocationModel[] mm) {
        if (mLocationList != null)
            mLocationList= null;
        mLocationList = mm;
        notifyDataSetChanged();
    }

    protected class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.destination_address_txt) TextView mAddress;
        @BindView(R.id.destination_name_txt) TextView mLocationName;

        public LocationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mLocationList != null) {
                mClickHandler.onClick(mLocationList[getAdapterPosition()]);
            }
        }
    }
}
