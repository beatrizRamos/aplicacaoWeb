/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 20151D12GR0014
 */
public class Torta {
    protected String sabor;
    protected int id;
    protected String fabricante;

    public Torta(String sabor, int camadasDeRecheio, String fabricante) {
        this.sabor = sabor;
        this.id = camadasDeRecheio;
        this.fabricante = fabricante;
    }
     public Torta() {
        
    }

    

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    
    
    
    
}
