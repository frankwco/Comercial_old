/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.DAOGenerico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Cliente;
import modelo.Estado;

/**
 *
 * @author Frank
 */
@FacesConverter("converterCliente")
public class ConverterCliente implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Cliente> dao = new DAOGenerico<Cliente>(Cliente.class);
            return dao.buscarPorId(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Cliente estado = (Cliente) o;
            return String.valueOf(estado.getId());
        }
        return null;
    }
    
}
