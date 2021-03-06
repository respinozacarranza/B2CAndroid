package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.fragment.LoginFragment;


public class LoginActivity extends AppCompatActivity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(savedInstanceState==null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            loginFragment = new LoginFragment();
            fragmentTransaction.add(R.id.content_fragment,loginFragment);
            fragmentTransaction.commit();
        }
    }
}
