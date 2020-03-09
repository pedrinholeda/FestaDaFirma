package com.pedro.festadafirma.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.pedro.festadafirma.R;
import com.pedro.festadafirma.constants.FestaDaFirmaConstants;
import com.pedro.festadafirma.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate){
            if(this.mViewHolder.checkParticipate.isChecked()){
                //salvar presença
                this.mSecurityPreferences.storeString(FestaDaFirmaConstants.PRESENCE_KEY, FestaDaFirmaConstants.CONFIRMATION_YES);

            } else {
                // salvar ausência
                this.mSecurityPreferences.storeString(FestaDaFirmaConstants.PRESENCE_KEY, FestaDaFirmaConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox checkParticipate;
    }
}
