/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20151D12GR0014
 */
public class main {

    public static void main(String Args []) {
        Torta t = new Torta("manga",1,"belle");
        TortaDAO tdao = new TortaDAO();
        
        tdao.insert(t);
        tdao.get(t);
        System.out.println(tdao.get(t).getSabor());
    }
    
}
