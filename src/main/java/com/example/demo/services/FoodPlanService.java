package com.example.demo.services;

import com.example.demo.models.Recipe;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FoodPlanService {
    public void createPdf(ArrayList<Recipe> selectedRecipes, String[] days) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream("FoodPlan.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(4);
            for (int i = 0; i < 4; i++) {
                table.addCell(days[i]);
            }
            for (int i = 0; i < 4; i++) {
                table.addCell(selectedRecipes.get(i).toString());
            }

            for (int i = 3; i < 7; i++) {
                table.addCell(days[i]);
            }
            for (int i = 3; i < 7; i++) {
                table.addCell(selectedRecipes.get(i).toString());
            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
