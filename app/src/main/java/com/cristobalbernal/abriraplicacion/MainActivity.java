package com.cristobalbernal.abriraplicacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btPare;
    Button btJordan;
    //String url;
    public static final int REQUEST_CALL_PHONE = 2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btPare = findViewById(R.id.btPare);
        btJordan = findViewById(R.id.btJordan);
        //url = "https://www.google.es";
        btPare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirAplicaciob("com.cristobal.bernal.coche","MainActivity","637336566");
            }
        });
        btJordan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirAplicaciob("com.cristobal.bernal.coche","MainActivity","644309410");
            }
        });

    }
    private void abrirAplicaciob(String paquete, String clase,String tel) {
        int permision = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permision != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
            startActivity(callIntent);
        }

        /*
        //Abrir la galaria
        Intent intent = new Intent().setAction(Intent.ACTION_VIEW); //Define Intent.
        intent.setType("image/*"); //Define mime type para abrir imagenes
        startActivity(intent); //Abre galería.

         */

        /*
        //Abrir pagina web...
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
         */

        /*
        //Abrir la camara del movil...
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
         */


        //Abrir la aplicacion...
        /*
        Intent abrirAplicacion = new Intent()
            .setAction(Intent.ACTION_MAIN);
        abrirAplicacion.setComponent(new ComponentName(paquete, paquete+ "." + clase));
        startActivity(abrirAplicacion);

         */

    }
}