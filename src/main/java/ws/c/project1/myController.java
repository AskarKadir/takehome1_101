/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.project1;

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
            @RequestParam(value = "totalharga") String Newtotalharga,
            Model model)
    {
        String total;
        if (Newjumlahbarang.isEmpty() && 
                Newnamabarang.isEmpty() && 
                Newtotalharga.isEmpty())
        {
            return "dataeror";
        }else{
            
        }
        return "pembayaran";
    }
}
