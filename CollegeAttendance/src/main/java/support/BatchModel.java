/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import com.google.api.core.ApiFuture;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import connections.FireStoreDB;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author pawan
 */
public class BatchModel {

    public boolean saveBatches(String deptName, String className, String divName, String batchName, Map<String, Object> data) {
        boolean status = false;
        FireStoreDB db = new FireStoreDB();
        try {
            db.init();
//            Firestore open = FirestoreClient.getFirestore();
//            DocumentReference docRef = open.collection("departments").document(deptName).collection(className).document(divName).collection(batchName).document();
//            ApiFuture<WriteResult> result = docRef.set(data);
//            result.get();
//            if (result.isDone()) {
//                status = true;
//                FireStoreDB.initializeApp.delete();
//            }//ABOVE CODE FOR THE FIRESTORE DATABASE
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("departments").child(deptName).child(className).child(divName).child(batchName);
            ApiFuture<Void> result = ref.setValueAsync(data);
            if (result.isDone()) {
                status = true;
                //FirebaseApp.getInstance().delete();
            }//THIS IS CODE FOR FIREBASE REALTIME DATABASE
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
