/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author pawan
 */
public class FireStoreDB {
    /**
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws URISyntaxException
     */
   public static  FirebaseApp initializeApp;
    public void init() throws InterruptedException, ExecutionException, IOException, URISyntaxException {
        try {
            InputStream serviceAccount = new FileInputStream(getClass().getResource("/core/Attendance-6723967d3484.json").toURI().toString().replace("file:", ""));
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl("https://attendance-568b1.firebaseio.com/")
                    .build();
            if(initializeApp==null){
                initializeApp = FirebaseApp.initializeApp(options);
            }else{
                
            }
             

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}//FirebaseApp.getInstance().delete();
