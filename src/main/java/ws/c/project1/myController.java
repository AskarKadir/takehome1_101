/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.project1;

import java.text.Format;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
public class myController {
    
    @RequestMapping("/input")
    public String olahData(
            @RequestParam(value = "namabarang")String Newnamabarang,
            @RequestParam(value = "jumlahbarang") String Newjumlahbarang,
            @RequestParam(value = "hargabarang") String Newhargabarang,
            Model model)
    {
        String total = "";
        String diskon= "";
        if (Newjumlahbarang.isEmpty() && 
                Newnamabarang.isEmpty() && 
                Newhargabarang.isEmpty())
        {
            return "dataeror";
        }
        else{
            total = String.valueOf(Double.parseDouble(Newjumlahbarang) * 
                    Double.parseDouble(Newhargabarang));
            if (Double.parseDouble(total) < 10000 ) {
                diskon = "0";
                total = String.valueOf(Double.parseDouble(total) - (Double.parseDouble(total) *  Double.parseDouble(diskon)/100));
            }else if (Double.parseDouble(total) >= 10000 && Double.parseDouble(total) < 50000){
                diskon = "5";
                total = String.valueOf(Double.parseDouble(total) - (Double.parseDouble(total) *  Double.parseDouble(diskon)/100));
            }else if (Double.parseDouble(total) >= 50000 && Double.parseDouble(total) < 100000){
                diskon = "10";
                total = String.valueOf(Double.parseDouble(total) - (Double.parseDouble(total) *  Double.parseDouble(diskon)/100));
            }else{
                diskon = "15";
                total = String.valueOf(Double.parseDouble(total) - (Double.parseDouble(total) *  Double.parseDouble(diskon)/100));
            }
        }
        model.addAttribute("getnamabarang",Newnamabarang);
        model.addAttribute("getjumlah", Newjumlahbarang);
        model.addAttribute("getharga", Newhargabarang);
        model.addAttribute("getdiskon", String.format("%s%%", diskon));
        model.addAttribute("gettotalharga", total);
        return "pembayaran";
    }
}
