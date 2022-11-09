/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Usuarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author higor_x
 */
public interface Usuarios_DAO {
    
   void insert();
   void update();
   void delete();
   Usuarios findOne();
   List<Usuarios> findAll();
    
}
