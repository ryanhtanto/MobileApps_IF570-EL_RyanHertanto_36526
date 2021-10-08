package umn.ac.id.ryanhertanto_00000036526_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetilAudio extends AppCompatActivity {

    private TextView etJudul;
    private TextView etKeterangan;
    private Button playBtn;
    private MediaPlayer player;
    private int Uri;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_audio);

        etJudul = (TextView) findViewById(R.id.judul);
        etKeterangan = (TextView) findViewById(R.id.keterangan);
        playBtn = (Button) findViewById(R.id.play);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberAudio sumberAudio = (SumberAudio) bundle.getSerializable("DetilAudio");
        etJudul.setText(sumberAudio.getJudul());
        etKeterangan.setText(sumberAudio.getKeterangan());

        Uri = Integer.parseInt(sumberAudio.getAudioURI());

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(sumberAudio.getJudul());
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.backarrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void playSFX(View view){
        if (player == null) {
            player = MediaPlayer.create(this, Uri);
        }
        player.start();
    }
}