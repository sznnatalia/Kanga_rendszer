/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import javafx.util.converter.LocalDateStringConverter;
import pojos.Hordozo;

/**
 *
 * @author Nati
 */
public class HataridoComparator implements Comparator<Hordozo>{

    @Override
    public int compare(Hordozo o1, Hordozo o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate d1 = LocalDate.parse(o1.getKolcsonzesiHatarido(),formatter);
        LocalDate d2 = LocalDate.parse(o2.getKolcsonzesiHatarido(),formatter);
        
        return d1.compareTo(d2);
    }

}
