package umn.ac.id.ryanhertanto_00000036526_if570_el_uts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarAudioAdapter extends RecyclerView.Adapter<DaftarAudioAdapter.ItemAudioViewHolder> {
    private LinkedList<SumberAudio> mDaftarAudio;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarAudioAdapter(Context context, LinkedList<SumberAudio> daftarAudio){
        this.mContext = context;
        this.mDaftarAudio = daftarAudio;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemAudioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.audio_template , parent , false);
        return new ItemAudioViewHolder(view, this);
    }

    public void onBindViewHolder( ItemAudioViewHolder holder, int position) {
        SumberAudio mSumberAudio = mDaftarAudio.get(position);
        holder.Judul.setText(mSumberAudio.getJudul());
        holder.Keterangan.setText(mSumberAudio.getKeterangan());
    }
    @Override
    public int getItemCount() {
        return mDaftarAudio.size();
    }

    class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Judul;
        private TextView Keterangan;
        private DaftarAudioAdapter mAdapter;
        private ImageView Hapus;
        private int mPosisi;
        private SumberAudio mSumberAudio;

        public ItemAudioViewHolder(View itemView, DaftarAudioAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            Judul = (TextView) itemView.findViewById(R.id.Judul);
            Keterangan = (TextView) itemView.findViewById(R.id.Keterangan);
            Hapus = (ImageView) itemView.findViewById(R.id.deteleBtn);
            itemView.setOnClickListener(this);

            Hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDaftarAudio.remove(getLayoutPosition());
                    notifyItemRemoved(getLayoutPosition());
                    notifyItemRangeChanged(getLayoutPosition(),mDaftarAudio.size());
                }
            });
        }
        public void onClick(View v) {
            mPosisi = getLayoutPosition();
            mSumberAudio = mDaftarAudio.get(mPosisi);
            Intent detilInten = new Intent(mContext, DetilAudio.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetilAudio",mSumberAudio);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }
    }
}
