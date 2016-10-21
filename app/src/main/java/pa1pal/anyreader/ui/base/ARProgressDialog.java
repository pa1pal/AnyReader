package pa1pal.anyreader.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ARProgressDialog {


    public static String mProgressDialogTitle = "Working";
    public static String mProgressDialogMessage = "Please Wait...";

    private ProgressDialog mProgressDialog;

    private Context mContext;

    public ARProgressDialog(Context context) {
        this.mContext = context;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(mProgressDialogMessage);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setTitle(mProgressDialogTitle);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    public static String getmProgressDialogTitle() {
        return mProgressDialogTitle;
    }

    public static void setmProgressDialogTitle(String mProgressDialogTitle) {
        ARProgressDialog.mProgressDialogTitle = mProgressDialogTitle;
    }

    public static String getmProgressDialogMessage() {
        return mProgressDialogMessage;
    }

    public static void setmProgressDialogMessage(String mProgressDialogMessage) {
        ARProgressDialog.mProgressDialogMessage = mProgressDialogMessage;
    }

    public void safelyBlockUI() {
        mProgressDialog.show();
    }

    public void safelyUnBlockUI() {
        mProgressDialog.dismiss();
    }

    public void safelyUnblockUIForFailure(String tag, String message) {

        mProgressDialog.dismiss();
        Toast.makeText(mContext, "Some Problem Executing Request", Toast.LENGTH_SHORT).show();
        Log.i(tag, message);

    }


}