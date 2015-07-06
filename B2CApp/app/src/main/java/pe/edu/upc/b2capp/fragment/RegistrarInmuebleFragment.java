package pe.edu.upc.b2capp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.markushi.ui.CircleButton;
import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.connection.InmuebleManager;
import pe.edu.upc.b2capp.model.ImagenOut;
import pe.edu.upc.b2capp.model.InmuebleOut;
import pe.edu.upc.b2capp.session.LocalSession;
import pe.edu.upc.b2capp.util.Base64Encoder;

/**
 * Created by Renato on 6/15/2015.
 */
public class RegistrarInmuebleFragment extends Fragment{

    private static int LOAD_IMAGE_RESULTS = 1;
    private int but = 0;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private Button btnRegistrar;
    private String imagePath;
    private Activity activity;
    private List<String> listImagePath;

    private SeekBar seekPrecio;
    private SeekBar seekAreaTotal;
    private SeekBar seekAreaConstruida;
    private SeekBar seekAntiguedad;
    private SeekBar seekDormitorios;
    private SeekBar seekBanos;

    private TextView textTitulo;
    private TextView textDireccion;
    private TextView textDistrito;
    private TextView textDescripcion;

    private TextView valueAreaTotal;
    private TextView valueAreaConstruida;
    private TextView valuePrecio;
    private TextView valueAntiguedad;
    private TextView valueDormitorios;
    private TextView valueBanos;

    private Spinner spinnerTipoTransaccion;
    private Spinner spinnerTipoInmueble;

    Pattern pattern;
    Matcher matcher;

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

        activity                = getActivity();
        listImagePath         = new ArrayList<String>();

        //Seteo de Controles
        btnRegistrar            = (Button)activity.findViewById(R.id.btnRegistrar);
        imageButton2            = (ImageButton)activity.findViewById(R.id.imgButton2);
        imageButton             = (ImageButton)activity.findViewById(R.id.imgButton);
        imageButton3            = (ImageButton)activity.findViewById(R.id.imgButton3);
        imageButton4            = (ImageButton)activity.findViewById(R.id.imgButton4);
        imageButton5            = (ImageButton)activity.findViewById(R.id.imgButton5);
        imageButton6            = (ImageButton)activity.findViewById(R.id.imgButton6);
        imageButton7            = (ImageButton)activity.findViewById(R.id.imgButton7);

        seekPrecio              = (SeekBar)activity.findViewById(R.id.seekPrecio);
        seekAreaTotal           = (SeekBar)activity.findViewById(R.id.seekAreaTotal);
        seekAreaConstruida      = (SeekBar)activity.findViewById(R.id.seekAreaConstruida);
        seekAntiguedad          = (SeekBar)activity.findViewById(R.id.seekAntiguedad);
        seekDormitorios         = (SeekBar)activity.findViewById(R.id.seekDormitorios);
        seekBanos               = (SeekBar)activity.findViewById(R.id.seekBanos);
        spinnerTipoTransaccion  = (Spinner)activity.findViewById(R.id.spinnerTipoTransaccion);
        spinnerTipoInmueble     = (Spinner)activity.findViewById(R.id.spinnerTipoInmueble);

        textTitulo              = (TextView)activity.findViewById(R.id.txtTitulo);
        textDireccion           = (TextView)activity.findViewById(R.id.txtDireccion);
        textDistrito            = (TextView)activity.findViewById(R.id.txtDistrito);
        textDescripcion         = (TextView)activity.findViewById(R.id.txtDescripcion);

        valuePrecio             = (TextView)activity.findViewById(R.id.valuePrecio);
        valueAreaTotal          = (TextView)activity.findViewById(R.id.valueAreaTotal);
        valueAreaConstruida     = (TextView)activity.findViewById(R.id.valueAreaConstruida);
        valueAntiguedad         = (TextView)activity.findViewById(R.id.valueAntiguedad);
        valueDormitorios        = (TextView)activity.findViewById(R.id.valueDormitorios);
        valueBanos              = (TextView)activity.findViewById(R.id.valueBanos);

        //Seteando progreso e incremento de los seekBars
        seekPrecio.setProgress(0);
        seekPrecio.incrementProgressBy(10000);
        seekPrecio.setMax(2000000);

        seekAreaTotal.setProgress(0);
        seekAreaTotal.incrementProgressBy(10);
        seekAreaTotal.setMax(1000);

        seekAreaConstruida.setProgress(0);
        seekAreaConstruida.incrementProgressBy(10);
        seekAreaConstruida.setMax(1000);

        seekAntiguedad.setProgress(0);
        seekAntiguedad.incrementProgressBy(1);
        seekAntiguedad.setMax(50);

        seekDormitorios.setProgress(0);
        seekDormitorios.incrementProgressBy(1);
        seekDormitorios.setMax(15);

        seekBanos.setProgress(0);
        seekBanos.incrementProgressBy(1);
        seekBanos.setMax(10);

        //Listeners de los seekBars
        seekPrecio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i/10000;
                i = i*10000;
                valuePrecio.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekAreaTotal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i / 10;
                i = i * 10;
                valueAreaTotal.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekAreaConstruida.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i / 10;
                i = i * 10;
                valueAreaConstruida.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekAntiguedad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i/1;
                i = i*1;
                valueAntiguedad.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekDormitorios.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i/1;
                i = i*1;
                valueDormitorios.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBanos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i / 1;
                i = i * 1;
                valueBanos.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Listeners de los buttons
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String titulo = textTitulo.getText().toString();
                final String direccion = textDireccion.getText().toString();
                final String distrito = textDistrito.getText().toString();

                if (titulo.length() == 0) {
                    textTitulo.requestFocus();
                    textTitulo.setError("EL CAMPO NO PUEDE ESTAR VACIO");

                }

                if (direccion.length() == 0) {
                    textDireccion.requestFocus();
                    textDireccion.setError("EL CAMPO NO PUEDE ESTAR VACIO");

                }
                if (distrito.length() == 0) {
                    textDistrito.requestFocus();
                    textDistrito.setError("EL CAMPO NO PUEDE ESTAR VACIO");
                }
                InmuebleManager.getInstance(activity).insertarInmueble(getInmuebleOut());
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

    private InmuebleOut getInmuebleOut() {
        InmuebleOut i = new InmuebleOut();
        i.setAntiguedad(seekAntiguedad.getProgress());
        i.setAreaTotal(new BigDecimal(valueAreaTotal.getText().toString()));
        i.setAreaConstruida(new BigDecimal(valueAreaConstruida.getText().toString()));
        i.setBanos(Integer.valueOf(valueBanos.getText().toString()));
        i.setDescripcion(textDescripcion.getText().toString());
        i.setDireccion(textDireccion.getText().toString());
        i.setDistrito(textDistrito.getText().toString());
        i.setDormitorios(Integer.valueOf(valueDormitorios.getText().toString()));
        Integer idTipoTransaccion = spinnerTipoTransaccion.getSelectedItemPosition() + 1;
        i.setIdTipoTransaccion(idTipoTransaccion);
        Integer idTipoInmueble = spinnerTipoInmueble.getSelectedItemPosition() + 1;
        i.setIdTipoInmueble(idTipoInmueble);
        i.setIdUsuario(LocalSession.getInstance(activity).getLoggedUser().getIdUsuario());
        i.setLatitud(BigDecimal.valueOf(12.020393));
        i.setLongitud(BigDecimal.valueOf(-8.339993));
        i.setPrecio(new BigDecimal(valuePrecio.getText().toString()));
        i.setTitulo(textTitulo.getText().toString());
        i.setImagenList(new ArrayList<ImagenOut>());
        for(String imagePath: listImagePath) {
            String encodedImage = Base64Encoder.getStringEncodedImage(imagePath);
            ImagenOut img = new ImagenOut();
            img.setImgBlob(encodedImage);
            i.getImagenList().add(img);
        }
        return i;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOAD_IMAGE_RESULTS && resultCode == getActivity().RESULT_OK && data != null) {
            // Let's read picked image data - its URI
            Uri pickedImage = data.getData();
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
            listImagePath.add(imagePath);

            if (but == 1) {
                imageButton.setImageBitmap(BitmapFactory.decodeFile(imagePath));
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
