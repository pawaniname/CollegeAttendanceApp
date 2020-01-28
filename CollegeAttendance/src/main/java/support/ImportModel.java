/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import connections.FireStoreDB;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pawan
 */
public class ImportModel {

    public boolean saveStudents(String department, String className, String divName, Map<String, Object> data) {
        boolean status = false;
        FireStoreDB db = new FireStoreDB();
        try {
            db.init();
//            Firestore open = FirestoreClient.getFirestore();
//            DocumentReference docRef = open.collection("students").document(department).collection(className).document(divName);
//            ApiFuture<WriteResult> result = docRef.set(data);
//            result.get();
//            if (result.isDone()) {
//                status = true;
//                FireStoreDB.initializeApp.delete();
//            }//ABOVE CODE FOR THE FIRESTORE DATABASE
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("students").child(department).child(className).child(divName);
            ApiFuture<Void> result = ref.setValueAsync(data);
            if (result.isDone()) {
                status = true;
               //FirebaseApp.getInstance().delete();
               // database.getApp().delete();
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

    public HashMap<String, Object> readData(InputStream file) throws FileNotFoundException {
        HashMap<String, Object> students = new HashMap<>();
        try {
            InputStream excelFile = file;
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = (Sheet) workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                // Cell currentCell = cellIterator.next();
                while (cellIterator.hasNext()) {
                    Map<String, Object> student = new HashMap<>();
                    Cell currentCell = cellIterator.next();

                    student.put("roll_no", getCellValue(currentCell));
                    currentCell = cellIterator.next();
                    student.put("serial_no", getCellValue(currentCell));
                    currentCell = cellIterator.next();
                    String name = getCellValue(currentCell);
                    currentCell = cellIterator.next();
                    student.put("self_contact", getCellValue(currentCell));
                    currentCell = cellIterator.next();
                    student.put("parents_contact", getCellValue(currentCell));
                    currentCell = cellIterator.next();
                    student.put("self_email", getCellValue(currentCell));

                    students.put(name, student);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static String getCellValue(Cell cell) {
        String value = "";
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case STRING:
                value = String.valueOf(cell.getStringCellValue());
                break;
            case NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                break;
            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }
        return value;
    }

}
