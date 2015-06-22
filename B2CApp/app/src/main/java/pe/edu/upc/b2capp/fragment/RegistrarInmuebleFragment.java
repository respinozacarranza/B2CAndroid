package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.activity.MapaInmueblesActivity;

/**
 * Created by Renato on 6/15/2015.
 */
public class RegistrarInmuebleFragment extends Fragment{

    private static int LOAD_IMAGE_RESULTS = 1;
    private int but = 0;
    private ImageButton imageButton2;
    private ImageButton imageButton;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private Button btnRegistrar;
    private Button btnCancelar;
    private String imagePath;

    private List<Uri> listaUris;

    public RegistrarInmuebleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registrar_inmueble, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaUris = new ArrayList<Uri>();
        btnRegistrar = (Button)getActivity().findViewById(R.id.btnRegistrar);
        btnCancelar = (Button)getActivity().findViewById(R.id.btnCancelar);
        imageButton2 = (ImageButton)getActivity().findViewById(R.id.imgButton2);
        imageButton = (ImageButton)getActivity().findViewById(R.id.imgButton);
        imageButton3 = (ImageButton)getActivity().findViewById(R.id.imgButton3);
        imageButton4 = (ImageButton)getActivity().findViewById(R.id.imgButton4);
        imageButton5 = (ImageButton)getActivity().findViewById(R.id.imgButton5);
        imageButton6 = (ImageButton)getActivity().findViewById(R.id.imgButton6);
        imageButton7 = (ImageButton)getActivity().findViewById(R.id.imgButton7);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MapaInmueblesActivity.class);
                startActivity(intent);

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                but = 1;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but = 2;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but = 3;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but = 4;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but = 5;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but = 6;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but = 7;
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,LOAD_IMAGE_RESULTS);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOAD_IMAGE_RESULTS && resultCode == getActivity().RESULT_OK && data != null) {
            // Let's read picked image data - its URI
            Uri pickedImage = data.getData();
            listaUris.add(pickedImage);
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            if(but==1) {
                imageButton.setImageBitmap(BitmapFactory.decodeFile(imagePath));
                Log.i(getTag(), imagePath);
            }

            if(but==2)
                imageButton2.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            if(but==3)
                imageButton3.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            if(but==4)
                imageButton4.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            if(but==5)
                imageButton5.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            if(but==6)
                imageButton6.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            if(but==7)
                imageButton7.setImageBitmap(BitmapFactory.decodeFile(imagePath));


            cursor.close();


        }
    }


}
