/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import sun.security.timestamp.TSRequest;

/**
 *
 * @author 20151D12GR0014
 */
public class TortaDAO {

    private ArrayList<Torta> tortas;

    public TortaDAO() {
        this.tortas = new ArrayList<Torta>();
    }

    public boolean insert(Torta torta) {
        return this.tortas.add(torta);
    }

    public boolean delete(Torta torta) {
        boolean tudoCerto = false;
        for (int i = 0; i < tortas.size(); i++) {
            if (tortas.get(i).getSabor().equals(torta.getSabor()) & tortas.get(i).getFabricante().equals(torta.getFabricante()) & tortas.get(i).getCamadasDeRecheio() == torta.getCamadasDeRecheio()) {
                tortas.remove(i);
                tudoCerto = true;
            }

        }
        return tudoCerto;
    }

    public Torta get(Torta torta) {
        Torta t = new Torta("não encontrado", 0, "não encontrado");
        for (int i = 0; i < tortas.size(); i++) {
            if (tortas.get(i).getSabor().equals(torta.getSabor()) & tortas.get(i).getFabricante().equals(torta.getFabricante()) & tortas.get(i).getCamadasDeRecheio() == torta.getCamadasDeRecheio()) {
                t.setSabor(tortas.get(i).getSabor());
                t.setFabricante(tortas.get(i).getFabricante());
                t.setCamadasDeRecheio(tortas.get(i).getCamadasDeRecheio());
                break;
            }
        }
        return t;
    }

}
