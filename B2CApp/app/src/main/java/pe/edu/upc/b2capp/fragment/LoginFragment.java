package pe.edu.upc.b2capp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.upc.b2capp.activity.MainActivity;
import pe.edu.upc.b2capp.R;
import pe.edu.upc.b2capp.session.LocalSession;

/**
 * Created by Andres on 13/06/2015.
 */
public class LoginFragment extends Fragment
{
    private LocalSession localSession;
    private Button mButtonConectarse;
    private EditText mEditTextUser;
    private EditText mEditTextPasword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedBundlesState) {
        localSession = LocalSession.getInstance(getActivity());
        mButtonConectarse = (Button) view.findViewById(R.id.login_btn_connect);
        mEditTextUser = (EditText) view.findViewById(R.id.login_et_usuario);
        mEditTextPasword = (EditText) view.findViewById(R.id.login_et_password);

        mButtonConectarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (localSession.startSession(mEditTextUser.getText().toString(),
                        mEditTextPasword.getText().toString(),
                        getActivity())) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

}
