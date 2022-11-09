
package DAO;

import Models.Item;
import java.util.List;

public interface Item_DAO {
   void insert(Item item);
   void update(Item item);
   void delete(Item item);
   Item findOne(Item item);
   List<Item> findAll();
}
