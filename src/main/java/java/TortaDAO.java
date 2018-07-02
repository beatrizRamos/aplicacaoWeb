/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.util.ArrayList;

/**
 *
 * @author 20151D12GR0014
 */
public class TortaDAO {

    private ArrayList<Torta> tortas;

    public TortaDAO() {
        this.tortas = new ArrayList<Torta>();
    }

    public boolean adicionar(Torta torta) {
        return this.tortas.add(torta);
    }

    public boolean deletar(Torta torta) {
        boolean tudoCerto = false;
        for (int i = 0; i < tortas.size(); i++) {
            if (tortas.get(i).getSabor().equals(torta.getSabor())) {
                tortas.remove(i);
                tudoCerto = true;
            }

        }
        return tudoCerto;
    }

    
}
