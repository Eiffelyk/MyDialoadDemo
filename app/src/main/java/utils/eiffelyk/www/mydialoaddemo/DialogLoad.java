package utils.eiffelyk.www.mydialoaddemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogLoad extends ProgressDialog {

    private TextView tips_loading_msg;
    private ImageView dialog_image;

    private String message = null;
    private AnimationDrawable animationDrawable = null;

    public DialogLoad(Context context) {
        super(context, R.style.theme_customer_progress_dialog);
        //super(context);
        this.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialogload);
        dialog_image = (ImageView) findViewById(R.id.dialog_image);
        dialog_image.setVisibility(View.VISIBLE);
        tips_loading_msg = (TextView) findViewById(R.id.tips_loading_msg);
        tips_loading_msg.setText(this.message);
        dialog_image.setImageResource(R.anim.loadmore_animation);
        animationDrawable = (AnimationDrawable) dialog_image.getDrawable();
        animationDrawable.start();
    }

    public void setText(int resId) {
        setText(getContext().getResources().getString(resId));
    }

    public void setText(String message) {
        this.message = message;
        tips_loading_msg.setText(this.message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * ��ʾĬ�϶Ի�??
     */
    public void showDialog() {
        this.setMessage("dengdaizhogn.....");
        this.show();
        this.setCanceledOnTouchOutside(false);
    }

    /**
     * ��ʾ���ַ����Ի�??
     *
     * @MethodName: showDialog
     */
    public void showDialog(int resId) {
        this.message = getContext().getResources().getString(resId);
        // this.pro_load.setVisibility(View.VISIBLE);
        this.setMessage(message);
        try {
            this.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ʾ�Ƿ�ɰ����ؼ�ȡ���Ի���
     *
     * @param isback
     * @MethodName: showDialog
     * @author Kyla
     * @date 2014??5??21?? ����5:20:43
     */
    public void showDialog(boolean isback) {
        this.setCancelable(!isback);
        this.show();
    }

    /**
     * ��ʾ���ַ������O���Ƿ�ɰ������Iȡ���Ի�??
     *
     * @param resId
     * @param isback true�ǲ���Ӧback??
     * @MethodName: showDialog
     * @author Kyla
     * @date 2014??5??21?? ����5:21:17
     */
    public void showDialog(int resId, boolean isback) {
        this.message = getContext().getResources().getString(resId);
        this.setMessage(message);
        this.setCancelable(!isback);
        this.show();
    }

    /**
     * �رնԻ�??
     *
     * @MethodName: cancelDialog
     * @author Kyla
     * @date 2014??5??21?? ����5:21:59
     */
    public void cancelDialog() {
        if (this != null) {
            try {
                this.dismiss();
            } catch (Exception e) {
            }
        }
    }
}
