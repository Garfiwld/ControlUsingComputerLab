/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static server.View.jb;

/**
 *
 * @author admin
 */
public class Connect {

    public static ServerSocket ss;
    public static Socket sock;
    static String ip;
    String[] ipclient = new String[40];

    ReciveImage ri = new ReciveImage();
    Thread t = new Thread(ri);

    static String[] onoff = new String[40];
    ArrayList<Integer> list = new ArrayList<>();
    int clientnumber;
    static Thread user[] = new Thread[40];

    int j = 0;
    static Timer timer = new Timer();

    public Connection getconnect() {
        Connection con;
        String url = "jdbc:mysql://localhost/controllab";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Editcourse.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void IPList() {
        Connection connection = getconnect();
        String sql = " SELECT * FROM  ip ";
        PreparedStatement pre;
        ResultSet rs;
        int i = 0;
        try {
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                ipclient[i] = rs.getString("IP_Address");
                onoff[i] = "offline";
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Editcourse.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
            }
        }
    }

    public Connect() {
        IPList();
        for (int i = 0; i < 40; i++) {
            list.add(i + 1);
        }
        Collections.shuffle(list);
        timer.schedule(checkarray, 0, 8000);
    }

    TimerTask checkarray = new TimerTask() {
        @Override
        public void run() {
            for (int i = 0; i < 40; i++) {
                if (onoff[i].equals("online")) {
                    jb[i].setEnabled(true);
                    jb[i].setIcon(View.on);
                    onoff[i] = "wait";
                } else {
                    jb[i].setEnabled(false);
                    jb[i].setIcon(View.on);
                    onoff[i] = "offline";
                }
            }
        }
    };

    public void createserver() {

        try {
            ss = new ServerSocket(25000);
            System.out.println("open port");
            t.start();
            while (true) {
                sock = ss.accept();
                clientnumber = button();
                onoff[clientnumber] = "online";
                user[clientnumber] = new Thread(new User(ipclient[clientnumber], list.get(clientnumber), clientnumber));
                user[clientnumber].start();
            }
        } catch (IOException ex) {
        }
    }

    public static String getip() {
        String socket = sock.getRemoteSocketAddress().toString().substring(1);
        String[] address = socket.split(":");
        ip = address[0];
        return ip;
    }

    public int button() {
        int i;
        String ipt = getip();
        for (i = 0; i < 40; i++) {
            if (ipt.equals(ipclient[i])) {
                break;
            }
        }
        return i;
    }

}

class ReciveImage implements Runnable {

    public static ServerSocket ss, ss2;
    public static Socket s, r;
    public static byte[] b;
    public static File f;
    public static int c;
    public static InputStream in;
    public static OutputStream out;
    static BufferedReader read;

    @Override
    public void run() {
        String msg;
        int a = 10;
        try {
            ss = new ServerSocket(12500);
            ss2 = new ServerSocket(12501);
            while (true) {
                r = ss2.accept();
                read = new BufferedReader(new InputStreamReader(r.getInputStream()));
                msg = read.readLine();

                s = ss.accept();
                in = s.getInputStream();
                out = new FileOutputStream("C:\\Controllab\\student\\" + msg);
                b = new byte[16 * 1024];
                while ((c = in.read(b)) > 0) {
                    out.write(b, 0, c);
                }
                out.close();
                in.close();
            }

        } catch (IOException ex) {
        } finally {
            try {
                s.close();
                ss.close();
            } catch (IOException ex) {
                Logger.getLogger(ReciveImage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class User implements Runnable {

    static String User;
    static Thread Send[] = new Thread[40];
    static Thread Recive[] = new Thread[40];
    int j = 0;
    private final String ip;
    private final int port;
    private final int clientnumber;

    User(String ip, int port, int clientnumber) {
        this.ip = ip;
        this.port = port + 25000;
        this.clientnumber = clientnumber;
    }

    @Override
    public void run() {
        System.out.println("IP " + ip + " port " + port + " client " + clientnumber);
        Send[clientnumber] = new Thread(new Send(ip, port, clientnumber));
        Recive[clientnumber] = new Thread(new Recive(ip, port, clientnumber));
        Send[clientnumber].start();
        Recive[clientnumber].start();

    }

}

class Send implements Runnable {

    String ip;
    int clientnumber;
    Socket send;
    int port;
    PrintWriter out;

    Send(String ip, int port, int clientnumber) {
        this.ip = ip;
        this.port = port + 25000;
        this.clientnumber = clientnumber;

    }

    @Override
    public void run() {
        System.out.println("this is " + ip);
        try {
            send = new Socket(ip, 25005);
            out = new PrintWriter(send.getOutputStream());
            System.out.println("Random port = " + port + " " + clientnumber);
            out.println(port);
            out.flush();
            send.close();
            addoption();
        } catch (IOException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("client offline");
    }

    private void addoption() {

        View.jb[clientnumber].addActionListener((ActionEvent ae) -> {
            Object[] options = {"Shutdown", "Restart"};
            int n = JOptionPane.showOptionDialog(null,
                    "Command to client number " + clientnumber,
                    "choose command", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            try {
                send = new Socket(ip, 25005);
                out = new PrintWriter(send.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (n) {
                case 0:
                    System.out.println("Shutdown");
                    out.println("Shutdown");
                    out.flush();
                     {
                        try {
                            send.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case 1:
                    System.out.println("Restart");
                    out.println("Restart");
                    out.flush();
                     {
                        try {
                            send.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                default:
                    break;
            }
        });
    }

}

class Recive implements Runnable {

    ServerSocket newss;
    String msg, clientid;
    Socket recive;
    int clientnumber, port;
    public BufferedReader read;
    Connection con = null;
    String url = "jdbc:mysql://localhost/controllab";

    String Studentusername;
    public int count = 1;
    public String ip;

    Recive(String ip, int port, int clientnumber) {
        this.ip = ip;
        this.port = port + 25000;
        this.clientnumber = clientnumber;
    }

    @Override
    public void run() {
        try {
            newss = new ServerSocket(port);
            while (true) {
                recive = newss.accept();
                read = new BufferedReader(new InputStreamReader(recive.getInputStream()));
                msg = read.readLine();
                if (msg.equals("online")) {
                    Connect.onoff[clientnumber] = "online";
                } else if (msg.equals("login")) {
                    String user, pass;
                    user = read.readLine();
                    pass = read.readLine();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection(url, "root", "");
                        String sql = " SELECT * FROM  student WHERE St_Username = ? AND St_Password = ? ";
                        PreparedStatement pre = con.prepareStatement(sql);
                        pre.setString(1, user);
                        pre.setString(2, pass);
                        ResultSet rec = pre.executeQuery();

                        Socket s = new Socket(ip, 25005);
                        try (PrintWriter out = new PrintWriter(s.getOutputStream())) {
                            if (rec.next()) {
                                out.println("success");
                                out.flush();
                                out.println(Login.Subject);
                                out.flush();
                                out.println(Login.Section);
                                out.flush();
                                User.User = user;
                                if (rec.getString("St_status").equals("first")) {
                                    out.println("first");
                                    out.flush();
                                } else {
                                    out.println("last");
                                    out.flush();
                                }
                            } else {
                                out.println("failed");
                                out.flush();
                            }
                            out.close();
                            rec.close();
                            con.close();
                        }
                    } catch (IOException | ClassNotFoundException | SQLException e) {
                    }
                }
            }
        } catch (IOException ex) {
        }
    }
}
