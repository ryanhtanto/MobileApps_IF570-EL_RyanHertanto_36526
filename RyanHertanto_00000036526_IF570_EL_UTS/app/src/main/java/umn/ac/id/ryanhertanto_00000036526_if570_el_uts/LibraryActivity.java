package umn.ac.id.ryanhertanto_00000036526_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {
    RecyclerView rvDaftarAudio;
    DaftarAudioAdapter mAdapter;
    LinkedList<SumberAudio> daftarAudio = new LinkedList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        isiDaftarAudio();

        Intent loginPage = getIntent();
        String loginName = loginPage.getStringExtra("Nama");

        Toast.makeText(this,  "Selamat datang, " + loginName, Toast.LENGTH_LONG).show();
        rvDaftarAudio = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarAudioAdapter(this, daftarAudio);
        rvDaftarAudio.setAdapter(mAdapter);
        rvDaftarAudio.setLayoutManager(new LinearLayoutManager(this));

        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent profileActivity = new Intent(LibraryActivity.this, Profile.class);
                        startActivity(profileActivity);
                        return true;
                    case R.id.main:
                        Intent mainActivity = new Intent(LibraryActivity.this, MainActivity.class);
                        startActivity(mainActivity);
                        return true;
                    default:
                        return false;
                }
            }
        });
        toolbar.setTitle(loginName);
    }
    public void isiDaftarAudio(){
        daftarAudio.add(new SumberAudio("Goat Scream", "Goat Sound", Integer.toString(R.raw.goat)));
        daftarAudio.add(new SumberAudio("Suspen", "Suspen Sound", Integer.toString(R.raw.suspen)));
    }

}