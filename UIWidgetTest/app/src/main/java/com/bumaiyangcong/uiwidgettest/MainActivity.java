package com.bumaiyangcong.uiwidgettest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView=(ImageView) findViewById(R.id.image_view);
        progressBar= (ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
               /* String intputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, intputText, Toast.LENGTH_SHORT).show();*/
               //动态更改图片 imageView.setImageResource(R.drawable.img_2);

               /* if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                }*/

               //条形进度条
//               int progress=progressBar.getProgress();
//                progress=progress+10;
//                progressBar.setProgress(progress);


                //alertdialog  弹出对话框非常重要的警告信息
              /*  AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancle",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();*/


              //ProgressDialog 弹出对话框，而且会显示进度条
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is progressDialog");
                progressDialog.setMessage("loading....");
                progressDialog.setCancelable(true);
                progressDialog.show();

                break;
            default:
                break;
        }
    }
}
