/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import src.constants.DateFormats;

/**
 *
 * @author arthur
 */
public class DateHelper {
    
    public static String dateToString(Date date){
        SimpleDateFormat formato = new SimpleDateFormat(DateFormats.ISO_DATETIME + "", Locale.US);
        return formato.format(date);
    }
    
    public static Date stringToDate(String date) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat(DateFormats.ISO_DATETIME + "", Locale.US);
        return formato.parse(date);
    }
    
    public static void main(String[] args) {
        System.out.println("Dia de hoje: " + DateHelper.dateToString(new Date()));
        
        try {
            System.out.println("Data de hoje: " + DateHelper.stringToDate("2020-05-15 13:00:25"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
