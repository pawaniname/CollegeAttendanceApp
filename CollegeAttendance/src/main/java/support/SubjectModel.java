/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import connections.FireStoreDB;
import com.google.api.core.ApiFuture;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pawan
 */
public class SubjectModel {

    private FireStoreDB db = new FireStoreDB();
    private FirebaseDatabase database;// = FirebaseDatabase.getInstance();

    public boolean saveSubject(String deptName, String className, String subjectName, Map<String, Object> data) {
        boolean status = false;

        try {
            db.init();
            database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("subjects").child(deptName).child(className).child(subjectName);
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

    public List<String> getSubjects(String deptName, String className) {
         List<String> subjects = new ArrayList<String>();
        try {
            db.init();
            database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("subjects").child("CSE").child(className);

            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                   for(DataSnapshot data: dataSnapshot.getChildren()){
                        subjects.add(data.getKey());
                    System.out.println("SUBJECTS :: " + data.getKey());
                   };
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
           
        } catch (InterruptedException ex) {
            Logger.getLogger(SubjectModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SubjectModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SubjectModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(SubjectModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
    }

}
//            Firestore open = FirestoreClient.getFirestore();
//            DocumentReference docRef = open.collection("subjects").document(deptName).collection(className).document(subjectName);
//            ApiFuture<WriteResult> result = docRef.set(data);
//            result.get();
//            if (result.isDone()) {
//                status = true;
//                FireStoreDB.initializeApp.delete();
//            }//ABOVE CODE FOR THE FIRESTORE DATABASE
