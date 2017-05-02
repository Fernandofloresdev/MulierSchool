package com.fernando.proyectofinal.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fernando.proyectofinal.MemberStoreActivity;
import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.MemberStore;

import java.util.List;

/**
 * Created by Dell on 17/04/2017.
 */

public class MemberCardAdapter extends RecyclerView.Adapter<MemberCardAdapter.ViewHolder> {

    private List<MemberStore> memberCardInfo;
    private Context mContext;
    private LayoutInflater inflater;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnail;
        public TextView nameTextView, descriptionTextView;
        public ViewHolder(View view) {
            super(view);
            thumbnail=(ImageView) view.findViewById(R.id.thumbnail_card_member_store);
            nameTextView=(TextView)view.findViewById(R.id.name_card_member_store);
            descriptionTextView=(TextView)view.findViewById(R.id.description_card_member_store);

        }
    }

    public MemberCardAdapter(Context mContext, List<MemberStore> memberCardInfo){
        //member card info contains a string list of the name and the imageid  for the user
        this.memberCardInfo = memberCardInfo;
        this.mContext=mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_member_store, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MemberStore memberStore = memberCardInfo.get(position);
        holder.nameTextView.setText(memberStore.getName());
        holder.descriptionTextView.setText(memberStore.getDescription());
        holder.thumbnail.setImageResource(memberStore.getImageId());

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MemberStoreActivity.class);
                intent.putExtra(MemberStoreActivity.MEMBER_CARD_SELECTED, memberStore);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return memberCardInfo.size();
    }


}
