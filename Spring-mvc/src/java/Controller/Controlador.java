/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author upgenia
 */
@Controller
public class Controlador {
//    Para poder mandar llamar los datos
//            instanciamos la clase conexion
    
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
////    he instanciar el model a view  para ver las vistas
    ModelAndView mav = new ModelAndView();
    
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql="select * from persona";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("listar",datos);
        mav.setViewName("index");
        return mav;
    }
}
