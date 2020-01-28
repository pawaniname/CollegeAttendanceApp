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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pawan
 */
public class ClassTestModel {
 
    public boolean saveClassTest(String department, String className, String divName,String testName, Map<String, Object> data) {
        boolean status = false;
        FireStoreDB db = new FireStoreDB();
        try {
            db.init();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("classtests").child(department).child(className).child(divName).child(testName);
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

    public HashMap<String, Object> readData(InputStream file,String outOf) throws FileNotFoundException {
        HashMap<String, Object> students = new HashMap<>();
        List<String> columnNames=new ArrayList<String>(); 
        try {
            InputStream excelFile = file;
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = (Sheet) workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            Row first = iterator.next();
            Iterator<Cell> headers = first.cellIterator();
            while(headers.hasNext()){
                columnNames.add(ImportModel.getCellValue(headers.next()));
            }
            columnNames.remove(0);
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Map<String, Object> student = new HashMap<>();
                    Cell currentCell = cellIterator.next();
                     String rollNo = ImportModel.getCellValue(currentCell);
                     for(String column:columnNames){
                        String cellValue = ImportModel.getCellValue(cellIterator.next());
                       // System.out.println("DATA ----------->> "+column+" CELL ------------->> "+cellValue);
                         student.put(column, cellValue);
                     }
                     student.put("out_of", outOf);
//                     System.out.println("PROBLEM IS  ----------->> "+rollNo.split("\\.")[0]);
                    students.put(rollNo.split("\\.")[0], student);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
   
}
