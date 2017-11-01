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
import modelo.Cidade;
import modelo.Estado;

/**
 *
 * @author Frank
 */
@FacesConverter("converterCidade")
public class ConverterCidade implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if(id!=null && !id.isEmpty()){
            DAOGenerico<Cidade> dao = new DAOGenerico<Cidade>(Cidade.class);
            return dao.buscarPorId(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o!=null){
            Cidade estado = (Cidade) o;
            return String.valueOf(estado.getId());
        }
        return null;
    }
    
}
