package projects.condorlabs.com.laligaapp.app.ui.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import projects.condorlabs.com.laligaapp.R;

public class DialogUtil {

    private OnDialogListener onDialogListener;

    public DialogUtil(OnDialogListener onDialogListener){
        this.onDialogListener = onDialogListener;
    }

    public Dialog createCustomDialog(Context context){

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = View.inflate(context, R.layout.custom_dialog, null);

        final TextView tviSpanishLeague = view.findViewById(R.id.tviSpanishLeague);
        final TextView tviItalianLeague = view.findViewById(R.id.tviItalianLeague);
        final TextView tviBrazilianLeague = view.findViewById(R.id.tviBrazilianLeague);

        tviSpanishLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogListener.onLeagueSelected(tviSpanishLeague.getText().toString());
                dialog.dismiss();
            }
        });

        tviItalianLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogListener.onLeagueSelected(tviItalianLeague.getText().toString());
                dialog.dismiss();
            }
        });

        tviBrazilianLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogListener.onLeagueSelected(tviBrazilianLeague.getText().toString());
                dialog.dismiss();
            }
        });

        dialog.setContentView(view);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        return  dialog;
    }

    public interface OnDialogListener {
        void onLeagueSelected(String leagueName);
    }
}
