package edu.cecyt9.ipn.practica_13_hilos;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;


public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
    }

    //public void calcularOperacion(View view) {
      //  int n = Integer.parseInt(entrada.getText().toString());
        //salida.append(n +"! = ");
  //      int res = factorial(n);
//       salida.append(res + "\n");
        //MiThread miThread = new MiThread(n);
        //miThread.start();

    //}

    public int factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++){
            res*=i;
            SystemClock.sleep(1000);
        }

        return res;

    }
    public int conejo(int n) {
        int res=1;
        int numa=0;
        int numb=1;
        for (int i=3; i<=n; i++){
            res = numa+numb;
            numa = numb;
            numb = res;
            SystemClock.sleep(1000);
        }

        return res;

    }

    class MiThread extends Thread {
        private int n, res,  res2;

        public MiThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            res2 = conejo(n);
            salida.append(n + "! = "+res + "\n" + "fibonacci.pos("+n+") = "+res2);
        }

//        @Override
//        public void run() {
//            res = factorial(n);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    salida.append(res + "\n");
//                }
//            });
//        }
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        MiThread thread = new MiThread(n);
        thread.run();
    }




//    ejemplo AsyncTask
//    class MiTarea extends AsyncTask<Integer, Void, Integer> {
//
//        @Override
//
//        protected Integer doInBackground(Integer... n) {
//
//            return factorial(n[0]);
//
//        }
//
//        @Override
//
//        protected void onPostExecute(Integer res) {
//
//            salida.append(res + "\n");
//
//        }
//
//    }

//        public void calcularOperacion(View view) {
//        int n = Integer.parseInt(entrada.getText().toString());
//        salida.append(n + "! = ");
//        MiTarea tarea = new MiTarea();
//        tarea.execute(n);
//
//        }

    //    ejemplo AsyncTask whit progressdialog
//    class MiTarea extends AsyncTask<Integer, Integer, Integer> {
//
//        private ProgressDialog progreso;
//
//        @Override protected void onPreExecute() {
//
//            progreso = new ProgressDialog(MainActivity.this);
//
//            progreso.setProgressStyle(ProgressDialog.
//                    STYLE_HORIZONTAL);
//
//            progreso.setMessage("Calculando...");
//
//            progreso.setCancelable(false);
//
//            progreso.setMax(100);
//
//            progreso.setProgress(0);
//
//            progreso.show();
//
//        }
//
//        @Override protected Integer doInBackground(Integer... n) {
//
//            int res = 1;
//
//            for (int i = 1; i <= n[0]; i++) {
//
//                res *= i;
//
//                SystemClock.sleep(1000);
//
//                publishProgress(i*100 / n[0]);
//
//            }
//
//            return res;
//
//        }
//
//        @Override protected void onProgressUpdate(Integer... porc) {
//
//            progreso.setProgress(porc[0]);
//
//        }
//
//        @Override protected void onPostExecute(Integer res) {
//
//            progreso.dismiss();
//
//            salida.append(res + "\n");
//
//        }
//
//    }

    //    ejemplo AsyncTask whit progressdialog cancel
//    class MiTarea extends AsyncTask<Integer, Integer, Integer> {
//
//        private ProgressDialog progreso;
//
//        @Override protected void onPreExecute() {
//
//            progreso = new ProgressDialog(MainActivity.this);
//
//            progreso.setProgressStyle(ProgressDialog.
//                    STYLE_HORIZONTAL);
//
//            progreso.setMessage("Calculando...");
//
//            progreso.setCancelable(true);
//
//            progreso.setOnCancelListener(new OnCancelListener() {
//
//                @Override
//                public void onCancel(DialogInterface dialog) {
//
//                    MiTarea.this.cancel(true);
//
//                }
//
//            });
//
//            progreso.setMax(100);
//
//            progreso.setProgress(0);
//
//            progreso.show();
//
//        }
//
//        @Override protected Integer doInBackground(Integer... n) {
//
//            int res = 1;
//
//            for (int i = 1; i <= n[0] && !isCancelled(); i++) {
//                res *= i;
//
//                SystemClock.sleep(1000);
//
//                publishProgress(i*100 / n[0]);
//
//            }
//
//            return res;
//
//        }
//
//        @Override protected void onProgressUpdate(Integer... porc) {
//
//            progreso.setProgress(porc[0]);
//
//        }
//
//        @Override protected void onPostExecute(Integer res) {
//
//            progreso.dismiss();
//
//            salida.append(res + "\n");
//
//        }
//
//        @Override protected void onCancelled() {
//
//            salida.append("cancelado\n");
//
//        }
//
//    }

}