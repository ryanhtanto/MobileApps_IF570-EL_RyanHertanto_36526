package umn.ac.id.week11_36526;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umn.ac.id.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    List<PostModel> data;
    RecyclerView rvPosts;
    PostDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPosts = (RecyclerView)findViewById(R.id.rvPosts);

        rvPosts = (RecyclerView)findViewById(R.id.rvPosts);
        PostServices postServices = DataRepository.create();
        postServices.getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call,
                                   Response<List<PostModel>> response) {
                if(response.isSuccessful()) {
// Log.i("MainActivity", "Get success.");
                    data = response.body();
/*
Log.d("MainActivity", "Received responses: " +
String.valueOf(data.size()));
for(PostModel row : data) {
Log.d("MainActivity", " " + row.getBody());
}
*/
                    adapter = new PostDataAdapter(getApplicationContext(), data);
                    rvPosts.setAdapter(adapter);
                    rvPosts.setLayoutManager(new
                            LinearLayoutManager(getApplicationContext()));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Failed to get posts. Unknown API error.", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
// Log.e("MainActivity", "Failed to get posts: " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Failed to get posts. Check internet connection.", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}