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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pawan
 */
public class TeacherModel {

    private FireStoreDB db = new FireStoreDB();
    private FirebaseDatabase database;// = FirebaseDatabase.getInstance();

    public boolean saveTeacher(String deptName,String userEmail, Map<String, Object> data) {
        boolean status = false;
        try {
            db.init();
            database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("teachers").child(deptName).child(userEmail);
            ApiFuture<Void> result = ref.setValueAsync(data);
            if (result.isDone()) {
                status = true;
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
