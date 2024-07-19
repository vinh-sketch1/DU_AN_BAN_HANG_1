package myclass;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class ClockThread implements Runnable {

    JLabel ngay;
    JLabel gio;

    public ClockThread(JLabel ngay, JLabel gio) {
        this.ngay = ngay;
        this.gio = gio;
    }

    @Override
    public void run() {
        while (true) {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd-MM-YYYY ");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat(" HH:mm aa");
            ngay.setText(dateFormat.format(now));
            gio.setText(dateFormat1.format(now));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

}
