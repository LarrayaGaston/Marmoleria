package Metodos;

/**
 * ItemData.java
 *
 * @Objetivo: registra un elemento el contiene informacion adicional.
 */



public class JItem {    
    
    public JItem() { }
    
    public JItem( Object value ) { 
        this.item = ((JItem)value).getItem();
        this.itemData = ((JItem)value).getItemData();
    }
    
   @Override
    public String toString(){                    
        return getItem();   
    }
    
    /**
     * Retorna la descripcion del combo box
     * @author 
     */    
    public String getItem(){        
        return item;
    }  
    
    /**
     * Retorna el Objeto que identifica la descripcion del combo box
     * @author 
     */    
    public Object getItemData(){
        return itemData;
    }

    public void setItem( String value ) {
        item = value;
    }

    public void setItemData(Object value) {
        itemData = value;
    }         
    
    private String item = "";
    private Object itemData = null;
}
