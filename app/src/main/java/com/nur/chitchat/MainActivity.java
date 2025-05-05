package com.nur.chitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.nur.chitchat.Adapter.FragmentsAdapter;
import com.nur.chitchat.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();
        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.viewPager.getRootView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(R.id.settings==item.getItemId()){
            //Toast.makeText(this,"Settings is clicked",Toast.LENGTH_SHORT).show();
            Intent intent2=new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent2);
        }
        else{
            if(R.id.groupChat==item.getItemId()){
                //Toast.makeText(this,"Group Chat is Started.",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(MainActivity.this,GroupChatActivity.class);
                startActivity(intent1);
            }
            else{
                if(R.id.logout==item.getItemId()){
                   mAuth.signOut();
                   Intent intent=new Intent(MainActivity.this, SignInActivity.class);
                   startActivity(intent);
                }
            }
        }

        /*BU KOD ÇALIŞMADI KENDİM İF ELSE İLE YAZDIM BENDE
        switch (item.getItemId())
        {
            case R.id.settings:
                Toast.makeText(this,"Settings is clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.groupChat:
                Toast.makeText(this,"Group Chat is Started.",Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                break;
        }*/

        return super.onOptionsItemSelected(item);
    }
}