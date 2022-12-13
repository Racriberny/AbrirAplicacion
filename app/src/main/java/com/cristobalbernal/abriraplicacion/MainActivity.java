package com.cristobalbernal.abriraplicacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    String url;
    public static final int REQUEST_CALL_PHONE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        url = "https://www.google.es";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirAplicaciob("com.cristobalbernal.coches","MainActivity","622047350");
            }
        });
    }
    private void abrirAplicaciob(String paquete, String clase, String tel) {
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
        int permision = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permision != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
            startActivity(callIntent);
        }

    }
}