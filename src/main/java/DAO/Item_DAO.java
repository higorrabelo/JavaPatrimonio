
package DAO;

import Models.Item;
import java.util.List;

public interface Item_DAO {
   void insert();
   void update();
   void delete();
   Item findOne();
   List<Item> findAll();
}
